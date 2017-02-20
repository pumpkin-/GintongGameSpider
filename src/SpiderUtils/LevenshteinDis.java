package SpiderUtils;

import JavaBean.BasPersonInfo;
import JavaBean.BugData;
import JavaBean.ProKnowledge;
import dao.impl.BasPersonInfoImpl;
import dao.impl.BugDataImpl;
import dao.impl.ProKnowledgeImpl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/2/10.
 */
public class LevenshteinDis {

    public static boolean isExist(String aticle, String date,String url,String kuuid) {
        ProKnowledgeImpl pro=new ProKnowledgeImpl();
        //System.out.println(pro.selectList(dateformat.format(date).toString()));
        List<ProKnowledge> list=pro.selectList(date);
        if (list == null || list.size() == 0) {
            return false;
        }
        String essay;
        for(int x=0;x<list.size();x++){
            essay= list.get(x).getMain();

            //修改为错误代码
            double dis = levenshtein(essay, aticle);
            if (dis > 0.95) {
                BugData bugData=new BugData();
                bugData.setKey(list.get(x).getMain());
                bugData.setValue(aticle);
                bugData.setUuid(kuuid);
                BugDataImpl bugDataimpl = new BugDataImpl();
                bugDataimpl.insert(bugData);
                System.out.println("--------------This data should be delete------------------");
                return true;
            }
        }
        return false;
    }

    /**
     * 判断作者是否重复
     * @param source
     * @param name
     * @return
     */
    public static boolean nameIsExist(String source, String name) {
        BasPersonInfoImpl per=new BasPersonInfoImpl();
        //System.out.println(pro.selectList(dateformat.format(date).toString()));
        List<String> list=per.selectList(source);
        if (list == null || list.size() == 0) {
            return false;
        }
        String essay;
        for(int x=0;x<list.size();x++){
            essay= list.get(x);
            double dis = levenshtein(essay, name);
            if (dis > 0.9) {
                System.out.println("--------------This data should be delete------------------");
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static float levenshtein(String str1, String str2) {


        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dif = new int[len1 + 1][len2 + 1];

        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }

        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 取三个值中最小的
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        //System.out.println("字符串\"" + str1 + "\"与\"" + str2 + "\"的比较");
        System.out.println("差异步骤：" + dif[len1][len2]);
        // 计算相似度
        float similarity = 1 - (float) dif[len1][len2]
                / Math.max(str1.length(), str2.length());
        return similarity;
    }

    private static int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static double getSimilarity(String doc1, String doc2) {
        if (doc1 != null && doc1.trim().length() > 0 && doc2 != null
                && doc2.trim().length() > 0) {
            Map<Integer, int[]> AlgorithmMap = new HashMap<Integer, int[]>();

            //将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中
            for (int i = 0; i < doc1.length(); i++) {
                char d1 = doc1.charAt(i);
                if(isHanZi(d1)){
                    int charIndex = getGB2312Id(d1);
                    if(charIndex != -1){
                        int[] fq = AlgorithmMap.get(charIndex);
                        if(fq != null && fq.length == 2){
                            fq[0]++;
                        }else {
                            fq = new int[2];
                            fq[0] = 1;
                            fq[1] = 0;
                            AlgorithmMap.put(charIndex, fq);
                        }
                    }
                }
            }

            for (int i = 0; i < doc2.length(); i++) {
                char d2 = doc2.charAt(i);
                if(isHanZi(d2)){
                    int charIndex = getGB2312Id(d2);
                    if(charIndex != -1){
                        int[] fq = AlgorithmMap.get(charIndex);
                        if(fq != null && fq.length == 2){
                            fq[1]++;
                        }else {
                            fq = new int[2];
                            fq[0] = 0;
                            fq[1] = 1;
                            AlgorithmMap.put(charIndex, fq);
                        }
                    }
                }
            }

            Iterator<Integer> iterator = AlgorithmMap.keySet().iterator();
            double sqdoc1 = 0;
            double sqdoc2 = 0;
            double denominator = 0;
            while(iterator.hasNext()){
                int[] c = AlgorithmMap.get(iterator.next());
                denominator += c[0]*c[1];
                sqdoc1 += c[0]*c[0];
                sqdoc2 += c[1]*c[1];
            }
            return denominator / Math.sqrt(sqdoc1*sqdoc2);
        } else {
            throw new NullPointerException(
                    " the Document is null or have not cahrs!!");
        }
    }

    public static boolean isHanZi(char ch) {
        // 判断是否汉字 或字母
        return (ch >= 0x4E00 && ch <= 0x9FA5) || Character.isLetter(ch);

    }

    /**
     * 根据输入的Unicode字符，获取它的GB2312编码或者ascii编码，
     *
     * @param ch
     *            输入的GB2312中文字符或者ASCII字符(128个)
     * @return ch在GB2312中的位置，-1表示该字符不认识
     */
    public static short getGB2312Id(char ch) {
        try {
            byte[] buffer = Character.toString(ch).getBytes("GB2312");
//            if (buffer.length != 2) {
//                // 正常情况下buffer应该是两个字节，否则说明ch不属于GB2312编码，故返回'?'，此时说明不认识该字符
//                return -1;
//            }
            int b0 = (int) (buffer[0] & 0x0FF) - 161; // 编码从A1开始，因此减去0xA1=161
            int b1 = 0;
            if(buffer.length == 2) {
                b1 = (int) (buffer[1] & 0x0FF) - 161; // 第一个字符和最后一个字符没有汉字，因此每个区只收16*6-2=94个汉字
            }
            return (short) (b0 * 94 + b1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
