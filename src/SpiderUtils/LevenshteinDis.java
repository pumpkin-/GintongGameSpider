package SpiderUtils;

import JavaBean.*;
import dao.impl.BasPersonInfoImpl;
import dao.impl.BugDataImpl;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/10.
 */
public class LevenshteinDis {
    private static int fg=0;
    public static class FormatEexception extends Exception
    {
        public FormatEexception(String msg)
        {
            super(msg);
        }
    }

    /**
     * 判断当前页面的所有数据重复问题
     * @param proKnowledges
     * @param basPersonInfos
     * @param perKnowledges
     * @return
     * @throws SpiderUtils.FormatEexception
     * @throws ParseException
     * @throws FormatEexception
     */
    public static Map<Integer, List> isExist(List<ProKnowledge> proKnowledges, List<BasPersonInfo> basPersonInfos, List<PerKnowledge> perKnowledges) throws SpiderUtils.FormatEexception, ParseException, FormatEexception {
        ProKnowledgeImpl pro=new ProKnowledgeImpl();
        //System.out.println(pro.selectList(dateformat.format(date).toString()));
        List<Integer> flaglist=new ArrayList<Integer>();
        List<String> bznlist=new ArrayList<String>();
        int flag=0;
        String bzn="true";
        Map<Integer,List> map=new TreeMap<Integer, List>();
        if(StringUtils.isNotEmpty(proKnowledges.get(0).getPtime())) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date2 = simpleDateFormat.parse(proKnowledges.get(0).getPtime());
            Date date3 = simpleDateFormat.parse(proKnowledges.get(0).getPtime());
            for (int i = 0; i < proKnowledges.size(); i++) {
                try {
                    if (StringUtils.isNotEmpty(proKnowledges.get(i).getPtime())) {
                        Date date1 = simpleDateFormat.parse(proKnowledges.get(i).getPtime());
                        if (date1.getTime() > date2.getTime()) {
                            date2 = date1;
                        }
                        if (date1.getTime() < date3.getTime()) {
                            date3 = date1;
                        }
                    }
                } catch (Exception e) {
                    throw new FormatEexception("Time format error,It should be in the form of:\"yyyy-MM-dd HH:mm:ss\"");
                }
            }
            String dd = simpleDateFormat.format(date2);
            long day = (date2.getTime() - date3.getTime()) / (24 * 60 * 60 * 1000);
            Date date4 = new Date(date2.getTime() - (day + 5) * (24 * 60 * 60 * 1000));
            DateInfo da = new DateInfo();
            da.setDatepast(simpleDateFormat.format(date4));
            da.setDate(dd);
            System.out.println(da.getDatepast());
            System.out.println(da.getDate());
            if (day > SpiderContant.insertBatchContant * perKnowledges.size()) {
                String essay;
                for (int i = 0; i < proKnowledges.size(); i++) {
                    DateInfo daa = new DateInfo();
                    daa.setDate(proKnowledges.get(i).getPtime());
                    System.out.println(proKnowledges);
                    Date date5 = new Date((simpleDateFormat.parse(proKnowledges.get(i).getPtime()).getTime()) - (5 * (24 * 60 * 60 * 1000)));
                    dd = simpleDateFormat.format(date5);
                    daa.setDatepast(dd);
                    List<ProKnowledge> list = pro.selectList(daa);
                    System.out.println("从数据库中抽出：" + list.size() + "条数据做对比");
                    if (list == null || list.size() != 0) {
                        for (int x = 0; x < list.size(); x++) {
                            essay = list.get(x).getMain();
                            String aticle = proKnowledges.get(i).getMain();
                            double dis;
                            //修改为错误代码
                            try {
                                dis = getSimilarity(essay, aticle);
                            } catch (Exception e) {
                                dis = 0;
                            }
                            if (StringUtils.isEmpty(proKnowledges.get(i).getMain())) {
                                System.out.println("this is the null");
                                proKnowledges.remove(i);
                                basPersonInfos.remove(i);
                                perKnowledges.remove(i);
                                i = i - 1;
                                break;
                            } else if (dis > 0.95) {
                                CommonSpiderKnowledge.storeBugdata(essay, aticle, proKnowledges.get(i).getUuid(),proKnowledges.get(i).getSource());
                                proKnowledges.remove(i);
                                basPersonInfos.remove(i);
                                perKnowledges.remove(i);
                                i = i - 1;
                                fg = fg + 1;

                                if (fg % 5 == 0) {
                                    bzn = "false";
                                }
                                System.out.println("--------------This data should be delete------------------");
                                break;
                            } else {
                                fg = 0;
                            }
                        }
                        flag = i + 1;
                    }
                }
                if (basPersonInfos != null) {
                    for (int u = 0; u < basPersonInfos.size(); u++) {
                        if (basPersonInfos.get(u).getName().equals("null")) {
                            basPersonInfos.remove(u);
                            perKnowledges.remove(u);
                            u = u - 1;
                        }
                    }
                }
                flaglist.add(flag);
                bznlist.add(bzn);
                map.put(1, basPersonInfos);
                map.put(3, perKnowledges);
                map.put(4, flaglist);
                map.put(2, bznlist);
                map.put(5, proKnowledges);
            } else {
                List<ProKnowledge> list = pro.selectList(da);
                System.out.println("从数据库中抽出：" + list.size() + "条数据做对比");
                String essay;
                if (list == null || list.size() != 0) {
                    for (int i = 0; i < proKnowledges.size(); i++) {
                        for (int x = 0; x < list.size(); x++) {
                            essay = list.get(x).getMain();
                            String aticle = proKnowledges.get(i).getMain();
                            double dis;
                            //修改为错误代码
                            try {
                                dis = getSimilarity(essay, aticle);
                            } catch (Exception e) {
                                dis = 0;
                            }
                            if (StringUtils.isEmpty(proKnowledges.get(i).getMain())) {
                                System.out.println("this is the null");
                                proKnowledges.remove(i);
                                basPersonInfos.remove(i);
                                perKnowledges.remove(i);
                                i = i - 1;
                                break;
                            } else if (dis > 0.95) {

                                CommonSpiderKnowledge.storeBugdata(essay, aticle, list.get(i).getUuid(),proKnowledges.get(i).getSource());
                                proKnowledges.remove(i);
                                basPersonInfos.remove(i);
                                perKnowledges.remove(i);
                                i = i - 1;
                                fg = fg + 1;

                                if (fg % 5 == 0) {
                                    bzn = "false";
                                }
                                System.out.println("--------------This data should be delete------------------");
                                break;
                            } else {
                                fg = 0;
                            }
                        }
                        flag = i + 1;
                    }
                }
                if (basPersonInfos != null) {
                    for (int u = 0; u < basPersonInfos.size(); u++) {
                        if (basPersonInfos.get(u).getName().equals("null")) {
                            basPersonInfos.remove(u);
                            perKnowledges.remove(u);
                            u = u - 1;
                        }
                    }
                }
                flaglist.add(flag);
                bznlist.add(bzn);
                map.put(1, basPersonInfos);
                map.put(3, perKnowledges);
                map.put(4, flaglist);
                map.put(2, bznlist);
                map.put(5, proKnowledges);
            }
        }else{
            flaglist.add(flag);
            bznlist.add(bzn);
            map.put(1, basPersonInfos);
            map.put(3, perKnowledges);
            map.put(4, flaglist);
            map.put(2, bznlist);
            map.put(5, proKnowledges);
        }
        return map;
    }

    /**
     * 判断单条数据是否重复
     * @param proKnowledge
     * @throws SpiderUtils.FormatEexception
     * @throws ParseException
     * @throws FormatEexception
     */
    public static boolean isExist(ProKnowledge proKnowledge) throws SpiderUtils.FormatEexception, ParseException, FormatEexception {
        ProKnowledgeImpl pro=new ProKnowledgeImpl();
        //System.out.println(pro.selectList(dateformat.format(date).toString()));
        String essay = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(proKnowledge.getPtime());
        Date dd = simpleDateFormat.parse(proKnowledge.getPtime());
        DateInfo daa = new DateInfo();
        daa.setDate(proKnowledge.getPtime());
//        System.out.println(proKnowledge);
        Date date5 = new Date((simpleDateFormat.parse(proKnowledge.getPtime()).getTime()) - (5 * (24 * 60 * 60 * 1000)));
//        System.out.println("------" + date5);
        dd = simpleDateFormat.parse(date5.toLocaleString());
//        System.out.println(dd.toLocaleString());
        daa.setDatepast(dd.toLocaleString());
//        System.out.println(daa.toString());
        List<ProKnowledge> list = pro.selectList(daa);
//        System.out.println(list);
        System.out.println("从数据库中抽出：" + list.size() + "条数据做对比");
        if (list != null && list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                essay = list.get(x).getMain();
                double dis;
                //修改为错误代码
                try {
                    dis = getSimilarity(essay, proKnowledge.getMain());
                } catch (Exception e) {
                    dis = 0;
                }
                if (StringUtils.isEmpty(proKnowledge.getMain())) {
                    System.out.println("this is the null");
                } else if (dis > 0.95) {
                    CommonSpiderKnowledge.storeBugdata(essay, proKnowledge.getMain(), proKnowledge.getUuid(),proKnowledge.getSource());
                    System.out.println("--------------This data should be delete------------------");
                    return false;
                } else {
                    fg = 0;
                }

            }
        }
        return true;
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
     *  编译距离算法
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
        //System.out.println("差异步骤：" + dif[len1][len2]);
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

    /**
     * 余弦距离算法
     * @param tmpdoc1
     * @param tmpdoc2
     * @return
     */
    public static double getSimilarity(String tmpdoc1, String tmpdoc2) {
        //对文本进行预处理, 去除图片的影响
        String regEx = "(?<=src=).+\\.";
        Pattern p = Pattern.compile(regEx);
        String doc1 =null;
        String doc2=null;
        // String  doc1 = p.matcher(tmpdoc1).replaceAll("");
        if(StringUtils.isNotEmpty(tmpdoc1)&&StringUtils.isNotEmpty(tmpdoc2)) {
            doc1 = tmpdoc1.replaceAll(regEx, "");
            doc2 = p.matcher(tmpdoc2).replaceAll("");
        }
        if (doc1 != null && doc1.length() > 0 && doc2 != null
                && doc2.length() > 0) {
            Map<Integer, int[]> AlgorithmMap = new HashMap<Integer, int[]>();

            //将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中
            for (int i = 0; i < doc1.length(); i++) {
                char d1 = doc1.charAt(i);
                if (isHanZi(d1)) {
                    int charIndex = getGB2312Id(d1);
                    if (charIndex != -1) {
                        int[] fq = AlgorithmMap.get(charIndex);
                        if (fq != null && fq.length == 2) {
                            fq[0]++;
                        } else {
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
                if (isHanZi(d2)) {
                    int charIndex = getGB2312Id(d2);
                    if (charIndex != -1) {
                        int[] fq = AlgorithmMap.get(charIndex);
                        if (fq != null && fq.length == 2) {
                            fq[1]++;
                        } else {
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
            while (iterator.hasNext()) {
                int[] c = AlgorithmMap.get(iterator.next());
                denominator += c[0] * c[1];
                sqdoc1 += c[0] * c[0];
                sqdoc2 += c[1] * c[1];
            }
            return denominator / Math.sqrt(sqdoc1 * sqdoc2);
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
