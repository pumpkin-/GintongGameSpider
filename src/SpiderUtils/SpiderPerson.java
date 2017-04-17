package SpiderUtils;

import JavaBean.OrgKnowledge;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import JavaBean.ProKnowledge;
import dao.impl.OrgKnowledgeImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import dao.impl.ProKnowledgeDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.xpath.SourceTree;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovon on 2017/4/6.
 */
public class SpiderPerson {
    public static int fg=0;
    public static List<String> hrefList=new ArrayList<String>();
    public static List<String> ptimeList=new ArrayList<String>();
    public static BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl =new BasKnowledgeInfoDaoImpl();
    public static List<String> list=null;
    public static BasKnowledgeInfo basKnowledgeInfo1=null;
    /**
     * 获取selenium驱动器
     * @return
     */
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        return new ChromeDriver();
    }

    /**
     * $('.n:last-child')[0].click()
     * selenium方法翻页
     * @param driver
     * @return
     */
    public static org.jsoup.nodes.Document listSeleniumPage(WebDriver driver){
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("$('.n:last-child')[0].click()");
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handle.equals(handles)){
                continue;
            }else{
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document docs= Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        return docs;
    }
    /**
     * 转化时间格式
     * @param ptime
     * @return
     * @throws java.text.ParseException
     */
    public static String parsePtime(String ptime) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= simpleDateFormat.parse(ptime);
        ptime=simpleDateFormat1.format(date);
        return ptime;
    }
    /**
     * 得到所有的信息
     * @param doc
     * @param driver
     * @throws InterruptedException
     */
    public static void getAllPageURL(org.jsoup.nodes.Document doc,WebDriver driver) throws InterruptedException {
        while(true){
            Elements elementsPtime=doc.select("div[class=c-title-author]");
            for(org.jsoup.nodes.Element elementsPtimes:elementsPtime){
                String ptime=elementsPtimes.text().replace(Jsoup.parse("&nbsp;&nbsp;").text(),"-").split("-")[1];
                ptimeList.add(ptime);
            }
            Elements elementsHref=doc.select("h3[class=c-title] a");
            for(org.jsoup.nodes.Element elementHrefs:elementsHref){
                String href=elementHrefs.attr("href");
                hrefList.add(href);
            }
            doc= listSeleniumPage(driver);
        }
    }
    /*
   *
   * 获取当前时间之前或之后几小时 hour
   *
   *
   */
    public static String getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /*
     *
     * 获取当前时间之前或之后几分钟 minute
     *
     */

    public static String getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /*
     *
     * 获取当前时间之前或之后几天 day
     *
     */

    public static String getTimeByDay(int day) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, day);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /**
     * 获取日期是几分钟前，几小时前，几天前
     * @param ptime
     * @return
     */
    public static String returnPtime(String ptime){
        Pattern pattern=Pattern.compile("\\d");
        Matcher matcher=pattern.matcher(ptime);
        if(matcher.find()){
            ptime=matcher.group(0);
        }
        return ptime;
    }
    /**
     * 程序主方法
     * @param name
     * @param uuid
     * @param type
     */
    public  static void fetchByName(String name,String uuid,String type) {
        String source="百度搜索_"+name;
        String url="http://news.baidu.com/ns?ct=0&rn=20&ie=utf-8&bs=intitle"+name+"&rsv_bp=1&sr=0&cl=2&f=8&prevct=no&tn=newstitle&word="+name+"&rsv_sug3=1&rsv_sug4=7&rsv_sug1=1";
        WebDriver driver=getChromeDriver();
        driver.get(url);
        WebElement element=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc= Jsoup.parse(element.getAttribute("outerHTML"));
        try {
            getAllPageURL(doc,driver);
        } catch (Exception e) {
        }
        System.out.println("一共有数据"+hrefList.size()+"条");
        System.out.println("开始解析数据：");
        int i=0;
        for(int j=0;j<hrefList.size();j++){
            i++;
            try{
                driver.get(hrefList.get(j));
                WebElement elementDetails=driver.findElement(By.xpath("/html"));
                org.jsoup.nodes.Document documentDetails= Jsoup.parse(elementDetails.getAttribute("outerHTML"));
                String title=documentDetails.select("title").text();
                System.out.println(title);
                String time=documentDetails.select("span[class=date]").text();
                System.out.println(time);
                Elements elementMain=documentDetails.select("p");
                String main=null;
                String imgSrc=null;
                for( org.jsoup.nodes.Element elementMains:elementMain){
                    main="<p>"+elementMains.text()+"</p>";
                    Elements elementImg=elementMains.select("img");
                    for(org.jsoup.nodes.Element elementImgs:elementImg){
                        imgSrc=elementImgs.attr("src");
                        System.out.println("<img src=\""+imgSrc+"\"/>");
                    }
                    System.out.println(main);
                }
                System.out.println(hrefList.get(j));
                BasKnowledgeInfo basKnowledgeInfo = new BasKnowledgeInfo();
                String ptime=null;
                if (ptimeList.get(j).contains("分钟")){
                    ptime=returnPtime(ptimeList.get(j));
                    ptime=getTimeByMinute(-Integer.parseInt(ptime));
                    System.out.println("+++++++++++++------------"+ptime);
                    basKnowledgeInfo.setPtime(ptime);
                }else if (ptimeList.get(j).contains("小时")){
                    ptime=returnPtime(ptimeList.get(j));
                    ptime=getTimeByHour(-Integer.parseInt(ptime));
                    System.out.println("-------------+++++++++++++"+ptime);
                    basKnowledgeInfo.setPtime(ptime);
                }else if(ptimeList.get(j).contains("天")){
                    ptime=returnPtime(ptimeList.get(j));
                    ptime=getTimeByDay(-Integer.parseInt(ptime));
                    System.out.println("+++++++++-------------++++++++"+ptime);
                    basKnowledgeInfo.setPtime(ptime);

                }else if (ptimeList.get(j).contains("刚刚")){
                    basKnowledgeInfo.setPtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
                }else{
                    System.out.println("***********************"+parsePtime(ptimeList.get(j)));
                    basKnowledgeInfo.setPtime(parsePtime(ptimeList.get(j)));
                }
                basKnowledgeInfo.setSource(source);
                System.out.println(source);
                basKnowledgeInfo.setUrl(hrefList.get(j));
                basKnowledgeInfo.setTitle(title);
                basKnowledgeInfo.setUuid(uuid);
                basKnowledgeInfo.setMain(main);
                List<BasKnowledgeInfo> list=SpiderPerson.returnUUID(basKnowledgeInfo);
                if (list==null || list.size()==0){
                    BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl = new BasKnowledgeInfoDaoImpl();
                    basKnowledgeInfoDaoImpl.insert(basKnowledgeInfo);
                    if(type==SpiderContant.PersonKnowledgeType){
                        PerKnowledgeImpl perKnowledgeImpl=new PerKnowledgeImpl();
                        PerKnowledge perKnowledge=new PerKnowledge();
                        perKnowledge.setSource(source);
                        perKnowledge.setPuuid(uuid);
                        perKnowledge.setKuuid(UUID.randomUUID().toString());
                        perKnowledge.setKname(title);
                        perKnowledge.setName(name);
                        perKnowledgeImpl.insert(perKnowledge);
                    }else if (type==SpiderContant.OrgKnowledgeType){
                        OrgKnowledge orgKnowledge=new OrgKnowledge();
                        orgKnowledge.setKuuid(uuid);
                        orgKnowledge.setOuuid(UUID.randomUUID().toString());
                        orgKnowledge.setTitle(title);
                        orgKnowledge.setSource(source);
                        orgKnowledge.setOname(name);
                        OrgKnowledgeImpl orgKnowledgeImpl=new OrgKnowledgeImpl();
                        orgKnowledgeImpl.insert(orgKnowledge);
                    }else if (type==SpiderContant.ProductKnowledgeType){
                        ProKnowledge proKnowledge=new ProKnowledge();
                        proKnowledge.setKuuid(uuid);
                        proKnowledge.setSource(source);
                        proKnowledge.setPuuid(UUID.randomUUID().toString());
                        proKnowledge.setKname(title);
                        proKnowledge.setPname(name);
                        ProKnowledgeDaoImpl proKnowledgeDaoImpl=new ProKnowledgeDaoImpl();
                        proKnowledgeDaoImpl.insert(proKnowledge);
                    }
                }else{
                    for(int x=0;x<list.size();x++){
                        if(type==SpiderContant.PersonKnowledgeType){
                        PerKnowledgeImpl perKnowledgeImpl=new PerKnowledgeImpl();
                        PerKnowledge perKnowledge=new PerKnowledge();
                        perKnowledge.setSource(source);
                        perKnowledge.setPuuid(UUID.randomUUID().toString());
                        perKnowledge.setKuuid(list.get(x).getUuid());
                        perKnowledge.setKname(list.get(x).getTitle());
                        perKnowledge.setName(name);
                        perKnowledgeImpl.insert(perKnowledge);
                    }else if (type==SpiderContant.OrgKnowledgeType){
                        OrgKnowledge orgKnowledge=new OrgKnowledge();
                        orgKnowledge.setKuuid(list.get(x).getUuid());
                        orgKnowledge.setOuuid(UUID.randomUUID().toString());
                        orgKnowledge.setTitle(list.get(x).getTitle());
                        orgKnowledge.setSource(source);
                        orgKnowledge.setOname(name);
                        OrgKnowledgeImpl orgKnowledgeImpl=new OrgKnowledgeImpl();
                        orgKnowledgeImpl.insert(orgKnowledge);
                    }else if (type==SpiderContant.ProductKnowledgeType){
                        ProKnowledge proKnowledge=new ProKnowledge();
                        proKnowledge.setKuuid(list.get(x).getUuid());
                        proKnowledge.setSource(source);
                        proKnowledge.setPuuid(UUID.randomUUID().toString());
                        proKnowledge.setKname(list.get(x).getTitle());
                        proKnowledge.setPname(name);
                        ProKnowledgeDaoImpl proKnowledgeDaoImpl=new ProKnowledgeDaoImpl();
                        proKnowledgeDaoImpl.insert(proKnowledge);
                    }
                    }

                }
                System.out.println("---------------------这是第"+i+"条数据----------------------");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static List<BasKnowledgeInfo> returnUUID(BasKnowledgeInfo basKnowledgeInfo){
        String uuid=null;
        String essay=null;
        String title=null;
        String main=null;
        List<BasKnowledgeInfo> list1=new ArrayList<BasKnowledgeInfo>();
        BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl = new BasKnowledgeInfoDaoImpl();
        List<BasKnowledgeInfo> list=basKnowledgeInfoDaoImpl.selectByTime();
        System.out.println("从数据库中抽出"+list.size()+"条数据作对比");
        for (int i = 0; i < list.size(); i++) {
            essay = list.get(i).getMain();
            double dis;
            try {
                dis = getSimilarity(essay, basKnowledgeInfo.getMain());
            } catch (Exception e) {
                dis = 0;
            }
            if (StringUtils.isEmpty(basKnowledgeInfo.getMain())) {
                System.out.println("this is the null");
            } else if (dis > 0.95) {
                CommonSpiderKnowledge.storeBugdata(essay, basKnowledgeInfo.getMain(), basKnowledgeInfo.getUuid(), basKnowledgeInfo.getSource());
                List<BasKnowledgeInfo> listMain= basKnowledgeInfoDaoImpl.selectByMain(essay);
                for (int j=0;j<listMain.size();j++){
                    uuid=listMain.get(j).getUuid();
                    title=listMain.get(j).getTitle();
                    main=listMain.get(j).getMain();
                    basKnowledgeInfo1=new BasKnowledgeInfo();
                    basKnowledgeInfo1.setUuid(uuid);
                    basKnowledgeInfo1.setMain(main);
                    basKnowledgeInfo1.setTitle(title);
                    list1.add(basKnowledgeInfo1);
                }
                System.out.println("--------------This data should be delete------------------");
            } else {
                fg = 0;
            }
        }
        return list1;
    }

    public static double getSimilarity(String tmpdoc1, String tmpdoc2) {
        //对文本进行预处理, 去除图片的影响
        String regEx = "(?<=src=).+\\.";
        Pattern p = Pattern.compile(regEx);
        String doc1 =null;
        String doc2=null;
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

    public static void main(String[] args){
        fetchByName("刘雪明", UUID.randomUUID().toString(),SpiderContant.PersonKnowledgeType);
    }
}
