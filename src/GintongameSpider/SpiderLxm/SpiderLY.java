package GintongameSpider.SpiderLxm;

import JavaBean.*;
import SpiderUtils.SpiderContant;
import dao.impl.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by lenovon on 2017/3/20.
 */
public class SpiderLY {
//    897692892@qq.com    helloworld    15711490906@163.com  a19941031
    private static String username="897692892@qq.com";
    private static String password="helloworld";
    private static String companyName="多益";
    private static List<String> listPageUrl=new ArrayList<String>();
    private static WebDriver driver=getWebDriver();
    private static String listurl=null;
    private static Document listDocument=null;
    private static String source="领英";
    private static String name=null;
    private static String personUUID=UUID.randomUUID().toString();
    private static String organizeUUID=UUID.randomUUID().toString();
    /**
     * 获取驱动器
     * @return
     */
    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        return new ChromeDriver();
    }

    /**
     * 登录领英
     * @param username
     * @param password
     * @return
     */
    public static String loginLinkedin(String username,String password){
        String result="登陆成功";
        //登录URL
        String loginUrl="https://www.linkedin.com/hp/";
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        driver.get(loginUrl);
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        Document doc=Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        // 设置用户名
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys(username);
        //设置密码
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys(password);
        //模拟点击登录
        executor.executeScript("$('#pagekey-uno-reg-guest-home > div.header > div > form > input[type=\"submit\"]:nth-child(8)').click()");
        return result;
    }

    /**
     * 通过公司名称获取信息
     * @param companyName
     * @return
     */
    public static boolean fetchListPageUrl(String companyName){
        //搜索的URL
        String searchUrl="http://www.linkedin.com/search/results/people/?keywords="+companyName+"&origin=SWITCH_SEARCH_VERTICAL";
        driver.get(searchUrl);
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        listDocument=Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        try{
            while(true){
                parseOtherPage(listDocument);
                fetchPersonDataByUrl(listurl);
                listDocument = listPageSelenium();
                clearListPageURl();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("出错了。。。");
        }
        return true;
    }
    /**
     * 获取详情页信息
     * @param listUrl
     * @return
     */
    public static boolean fetchPersonDataByUrl(String listUrl){
        List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
        for(String listurls:listPageUrl){
            driver.get(listurls);
            JavascriptExecutor executor=(JavascriptExecutor)driver;
            executor.executeScript("$('figure > img').click()");
            Document document=returnPageDocument();
            System.out.println("--------------------个人信息开始------------------------");
            Elements element=document.select("div.core-rail");
           try{
               for (Element elements:element){
                   BasPersonInfo basPersonInfo=fetchPersonMessage(elements,listurls,document);
                   basPersonInfoList.add(basPersonInfo);
               }
           }catch(Exception e){
               System.out.println("获取个人信息出错了");
           }
            System.out.println("----------------教育经历-----------------");
            Elements elementEducation=document.select(" li[class=education-entity pv-profile-section__card-item ember-view] div[class=pv-entity__summary-info] ");
            if(elementEducation!=null){
                try{
                    for(Element elementUnEdu:elementEducation){
                        fetchPersonEducation(elementUnEdu);
                    }
                }catch(Exception e){
                    System.out.println("获取教育经历出错了");
                }
            }
            System.out.println("-------------------工作经历---------------------");
            Elements eleWork=document.select("div[class=pv-profile-section__sortable-card-item position-entity ember-view] div[class=pv-entity__summary-info]");
                if(eleWork!=null){
                    try{
                        for(Element elementWork:eleWork){
                            fetchPersonWork(elementWork);
                        }
                    }catch(Exception e){
                        System.out.println("获取工作经历出错了");
                    }
                }
        }
        return true;
    }
    /**
     * 翻页
     * @return
     */
    public static Document listPageSelenium(){
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("$('.next-text').click()");
        Document doc=returnPageDocument();
        return doc;
    }

    /**
     * 解析Json页面
     * @param listDocument
     */
    public static void parseJsonPage(Document listDocument){
        String[] strs=null;
        String s=null;
        String listPartUrl="http://www.linkedin.com/in/";
        String main=listDocument.outerHtml();
        strs=main.split("publicIdentifier");
        for(int i=3;i<strs.length;i++){
            s=strs[i].split(",")[0].replaceAll("\"", "").replaceAll(":","");
            if (!s.equals("UNKNOWN")){
                listurl=listPartUrl+s;
                listPageUrl.add(listurl);
            }
        }
    }

    /**
     * 解析不是Json页面
     * @param listDocument
     */
    public static void parseOtherPage(Document listDocument){
        Elements element=null;
        element=listDocument.select("div[class=search-result__image-wrapper] a[class=search-result__result-link ember-view]");
        for (Element elements:element){
            String  href=elements.attr("href");
            listurl="http://www.linkedin.com"+href;
            listPageUrl.add(listurl);
            System.out.println(listurl);
        }
    }

    /**
     * 清空listPageUrl
     */
    public static void clearListPageURl(){
        listPageUrl.clear();
    }

    /**
     * 返回页面的Document
     * @return
     */
    public static Document returnPageDocument(){
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
        Document doc=Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        return doc;
    }

    /**
     * 解析一个人的信息
     * @param elements
     */
    public static BasPersonInfo fetchPersonMessage(Element elements,String listurls,Document document){
        personUUID=UUID.randomUUID().toString();
        organizeUUID=UUID.randomUUID().toString();
        String src=null;
        String comName=null;
        String livePlace=null;
        src=elements.select("button.pv-top-card-section__photo img").attr("src");
        if (!(src.substring(0,4).equals("http"))){
            src=null;
        }
        name=elements.select("div[class=pv-top-card-section__information mt3] h1").text();
        livePlace=elements.select("div[class=pv-top-card-section__information mt3] h3[class=pv-top-card-section__location Sans-15px-black-55% mb1 inline-block]").text();
        StringBuffer ss=new StringBuffer();
        String s=null;
        System.out.println("-----------------个人标签----------------------");
        if(document.outerHtml().contains("其他")) {
            Elements elementTag = document.select("ul[class=pv-featured-skills-list pv-profile-section__section-info section-info pv-featured-skills-list--include-highlights]");
            if (document.select("ul[class=pv-featured-skills-list pv-profile-section__section-info section-info pv-featured-skills-list--include-highlights]") != null) {
                for (Element elementTags : elementTag) {
                    String tag = elementTags.select("div[id=pv-skill-entity-name-tooltip]").text();
                    ss.append(tag+",");
                }
            }
            String main=document.outerHtml();
            String[] str=main.split("standardizedSkill");
            for(int i=1;i<str.length;i++){
                if(str[i].contains("name")) {
                    s=str[i].split("name")[1].split(",")[0].split(":")[1].replaceAll("\"", "");
                    s= ss.append(s + ",").toString();
                }
            }
            s=s.substring(0, s.lastIndexOf(","));
        }else{
            Elements elementTag = document.select("ul[class=pv-featured-skills-list pv-profile-section__section-info section-info pv-featured-skills-list--include-highlights]");
            if (document.select("ul[class=pv-featured-skills-list pv-profile-section__section-info section-info pv-featured-skills-list--include-highlights]") != null) {
                for (Element elementTags : elementTag) {
                    String tag = elementTags.select("div[id=pv-skill-entity-name-tooltip]").text();
                    s=tag;
                }
            }
        }
        System.out.println("URL:"+listurls);
        System.out.println("头像：" + src);
        System.out.println("姓名：" + name);
//        放入人基本表中
        BasPersonInfo basPersonInfo=new BasPersonInfo();
        basPersonInfo.setUuid(personUUID);
        basPersonInfo.setUrl(listurls);
        basPersonInfo.setName(name);
        basPersonInfo.setPtag(s);
        BasPersonInfoImpl basPersonInfoImpl=new BasPersonInfoImpl();
        basPersonInfoImpl.insertPerInfo(basPersonInfo);
//
        PerSkillInfo perSkillInfo=new PerSkillInfo();
        perSkillInfo.setUuid(personUUID);
        perSkillInfo.setSpecialty(s);
        PerSkillInfoDaoImpl perSkillInfoImpl=new PerSkillInfoDaoImpl();
        perSkillInfoImpl.insertPerSkillInfo(perSkillInfo);
        return basPersonInfo;
    }

    /**
     * 解析教育信息
     * @param elementUnEdu
     */
    public static void fetchPersonEducation(Element elementUnEdu){
        String university=null;
        String startDate=null;
        String endDate=null;
        String date=null;
        university=elementUnEdu.select("h3[class=pv-entity__school-name Sans-17px-black-85%-semibold]").text();
        System.out.println("大学："+university);
        date=elementUnEdu.select("h4[class=pv-entity__dates Sans-15px-black-55%] span time").text();
        startDate=date.replaceAll(" ","").split("年")[0];
        endDate=date.replaceAll(" ","").split("年")[1];
        System.out.println("startDate:"+startDate);
        System.out.println("endDate:"+endDate);
        String dipContent=elementUnEdu.select("span[class=pv-entity__comma-item]").text();
        String dip=dipContent.split(" ")[0];
        String major=dipContent.split(" ")[1];
        System.out.println("学位："+dip);
        System.out.println("专业："+major);
//        放入教育表中
        PerEducationInfo perEducationInfo=new PerEducationInfo();
        perEducationInfo.setUuid(personUUID);
        perEducationInfo.setSchool(university);
        perEducationInfo.setStart_date(startDate);
        perEducationInfo.setEnd_date(endDate);
        perEducationInfo.setDiploma(dip);
        perEducationInfo.setMajor(major);
        PerEducationInfoDaoImpl perEduImpl=new PerEducationInfoDaoImpl();
        perEduImpl.insertPerEducationInfo(perEducationInfo);

    }

    /**
     * 获取个人工作经历
     * @param elementWork
     */
    public static void fetchPersonWork(Element elementWork){
        String position=null;
        String comName=null;
        String time=null;
        String workAddress=null;
        position=elementWork.select("h3[class=Sans-17px-black-85%-semibold]").text();
        System.out.println("职位："+position);
        comName=elementWork.select("span[class=pv-entity__secondary-title Sans-15px-black-55%]").text();
        System.out.println("公司名称："+comName);
        time=elementWork.select("h4[class=pv-entity__date-range Sans-15px-black-55%] span").text().split("期 ")[1];
        System.out.println("工作时间："+time);
        workAddress=elementWork.select("h4[class=pv-entity__location detail-facet Sans-15px-black-55% inline-block] span[class=pv-entity__bullet-item]").text();
        System.out.println("工作地点："+workAddress);
//        放入工作表中
        PerWorkInfo perWorkInfo=new PerWorkInfo();
        perWorkInfo.setOname(comName);
        perWorkInfo.setUuid(personUUID);
        perWorkInfo.setCompany_addr(workAddress);
        perWorkInfo.setJob(position);
        perWorkInfo.setWork_time(time);
        PerWorkInfoDaoImpl perWorkImpl=new PerWorkInfoDaoImpl();
        perWorkImpl.insertPerWorkInfo(perWorkInfo);
//        放入人与组织关系表中
        PerOrganize perOrganize=new PerOrganize();
        perOrganize.setOuuid(organizeUUID);
        perOrganize.setPuuid(personUUID);
        perOrganize.setOname(comName);
        perOrganize.setName(name);
        perOrganize.setSource(source);
        PerOrganizeImpl perOrganizeImpl=new PerOrganizeImpl();
        perOrganizeImpl.insertPerOrgani(perOrganize);
        BasOrganizeInfo basOrganizeInfo=new BasOrganizeInfo();
        basOrganizeInfo.setOname(comName);
        basOrganizeInfo.setAddress(workAddress);
//        basOrganizeInfo.setUrl(listurls);
        basOrganizeInfo.setSource(source);
        BasOrganizeInfoImpl basOrganizeInfoImpl=new BasOrganizeInfoImpl();
        basOrganizeInfoImpl.insertSingle(basOrganizeInfo);
    }
    public static void main(String arg[]) {
        loginLinkedin(username,password);
        fetchListPageUrl(companyName);
    }
}
