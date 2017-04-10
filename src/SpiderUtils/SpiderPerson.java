package SpiderUtils;

import JavaBean.OrgKnowledge;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import JavaBean.ProKnowledge;
import dao.impl.OrgKnowledgeImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import dao.impl.ProKnowledgeDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovon on 2017/4/6.
 */
public class SpiderPerson {
    public static List<String> hrefList=new ArrayList<String>();
    public static List<String> ptimeList=new ArrayList<String>();
    public static BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl =new BasKnowledgeInfoDaoImpl();
    public static List<String> list=null;
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
                BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl = new BasKnowledgeInfoDaoImpl();
                basKnowledgeInfoDaoImpl.insert(basKnowledgeInfo);
                String kuuid=UUID.randomUUID().toString();
                if(type==SpiderContant.PersonKnowledgeType){
                    PerKnowledge perKnowledge=new PerKnowledge();
                    perKnowledge.setSource(source);
                    perKnowledge.setPuuid(uuid);
                    perKnowledge.setKuuid(kuuid);
                    perKnowledge.setKname(title);
                    perKnowledge.setName(name);
                    PerKnowledgeImpl perKnowledgeImpl=new PerKnowledgeImpl();
                    perKnowledgeImpl.insert(perKnowledge);
                }else if (type==SpiderContant.OrgKnowledgeType){
                    OrgKnowledge orgKnowledge=new OrgKnowledge();
                    orgKnowledge.setKuuid(kuuid);
                    orgKnowledge.setOuuid(UUID.randomUUID().toString());
                    orgKnowledge.setTitle(title);
                    orgKnowledge.setSource(source);
                    orgKnowledge.setOname(name);
                    OrgKnowledgeImpl orgKnowledgeImpl=new OrgKnowledgeImpl();
                    orgKnowledgeImpl.insert(orgKnowledge);
                }else if (type==SpiderContant.ProductKnowledgeType){
                    ProKnowledge proKnowledge=new ProKnowledge();
                    proKnowledge.setKuuid(UUID.randomUUID().toString());
                    proKnowledge.setSource(source);
                    proKnowledge.setPuuid(uuid);
                    proKnowledge.setKname(title);
                    proKnowledge.setPname(name);
                    ProKnowledgeDaoImpl proKnowledgeDaoImpl=new ProKnowledgeDaoImpl();
                    proKnowledgeDaoImpl.insert(proKnowledge);
                }
                System.out.println("---------------------这是第"+i+"条数据----------------------");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        fetchByName("王者荣耀", UUID.randomUUID().toString(),SpiderContant.ProductKnowledgeType);
    }
}
