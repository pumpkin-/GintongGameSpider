package GintongameSpider.SpiderWm;

import JavaBean.BasBusinessInfo;
import JavaBean.BasOrganizeInfo;
import JavaBean.BasPersonInfo;
import JavaBean.PerOrganize;
import MaiMaiDataParser.Maimai;
import SpiderUtils.KnowledgeSpiderConfig;
import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.model.JXDocument;
import com.google.gson.Gson;
import dao.BasOrganizeInfoDao;
import dao.BasPersonInfoDao;
import dao.PerOrganizeDao;
import dao.impl.BasOrganizeInfoImpl;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerOrganizeImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
 * Created by lenovo on 2017/3/1.
 */
public class SpiderWm {
    private static String username="";
    private static String password="";
    private static List<String> perUrlList=new ArrayList<String>();
    private static WebDriver driver=null;
    private static String comName="多益";

    public static void getPerUrl(WebDriver driver,String comName) throws Exception {
        int page=0;
        String comUrl="http://s.weibo.com/user/"+comName+"&auth=per_vip";
        driver.get(comUrl);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        Elements elements=docMain.select("div.person_detail p.person_name a[class=W_texta W_fb]");
        for(Element element:elements){
            perUrlList.add(element.attr("href"));
            System.out.println(element.attr("href"));
        }
        System.out.println("第1页数据已经跑完");
        Element elementsPage=docMain.select("div[class=layer_menu_list W_scroll] ul li a").last();
        if(elementsPage!=null) {
            String pages = elementsPage.text();
            Pattern pattern = Pattern.compile("[0-9]{1,}");
            Matcher matcher = pattern.matcher(pages);
            while (matcher.find()) {
                page = Integer.parseInt(matcher.group(0));
            }
            for(int i=0;i<page-1;i++){
                docMain=listPageSelenium(driver);
                Elements elementsMain=docMain.select("div.person_detail p.person_name a[class=W_texta W_fb]");
                for(Element element:elementsMain){
                    System.out.println(element.attr("href"));
                    perUrlList.add(element.attr("href"));
                }
                System.out.println("第"+(i+2)+"页数据已经跑完");
                Thread.sleep(5000);
            }
        }

       // System.out.println(docMain);
    }

    public static Document listPageSelenium(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("document.getElementsByClassName('page next S_txt1 S_line1')[0].click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        Document Document=Jsoup.parse(webElement.getAttribute("outerHTML"));
        return Document;
    }

    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void login(String username,String password) throws InterruptedException {
        String url="http://weibo.com/login.php";
        driver.get(url);
        JavascriptExecutor executornext = (JavascriptExecutor)driver;
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        Document doc= Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        driver.findElement(By.xpath("//*[@id=\"loginname\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div/div[3]/div[2]/div/input")).sendKeys(password);
        executornext.executeScript("document.getElementsByClassName('W_btn_a btn_32px ')[0].click()");
    }


    public static void getPerInfoDataByUrl(WebDriver driver, String perInfoUrl) throws InterruptedException {
        String uuid= UUID.randomUUID().toString();
        String ouuid=UUID.randomUUID().toString();
        String name=null;
        String livePlace=null;
        String sex=null;
        String birthday=null;
        String bokeUrl=null;
        String selfUrl=null;
        String summary=null;
        String regTime=null;
        String tag=null;
        driver.get(perInfoUrl);
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("document.getElementsByClassName('WB_cardmore S_txt1 S_line1 clearfix')[0].click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        Elements elements=docMain.select("div.WB_innerwrap div[class=m_wrap clearfix] ul.clearfix li");
        BasPersonInfoDao basPersonInfoDao=new BasPersonInfoImpl();
        BasPersonInfo basPersonInfo=new BasPersonInfo();
        for(Element element:elements){
            String[] base= element.text().split("：");
            if(base[0].equals("昵称")){
                name=base[1];
            }
            if(base[0].equals("所在地")){
                livePlace=base[1];
            }
            if(base[0].equals("性别")){
                sex=base[1];
            }
            if(base[0].equals("生日")){
                birthday=base[1];
                birthday=birthday.replace("年","-");
                birthday=birthday.replace("月","-");
                birthday=birthday.replace("日","");
            }
            if(base[0].equals("博客")){
                bokeUrl=base[1];
            }
            if(base[0].equals("个性域名")){
                selfUrl=base[1];
            }
            if(base[0].equals("简介")){
                summary=base[1];
            }
            if(base[0].equals("注册时间")){
                regTime=base[1];
            }
            if(base[0].equals("标签")) {
                tag=base[1];
            }
        }
        basPersonInfo.setUuid(uuid);
        basPersonInfo.setSource("微博");
        basPersonInfo.setLiveplace(livePlace);
        basPersonInfo.setName(name);
        basPersonInfo.setUrl(selfUrl);
        basPersonInfo.setBirthday(birthday);
        basPersonInfo.setP_desc(summary);
        basPersonInfo.setSex(sex);
        basPersonInfo.setPtag(tag);
        basPersonInfoDao.insertPerInfo(basPersonInfo);

        System.out.println(name+"-"+livePlace+"-"+sex+"-"+birthday+"-"+bokeUrl+"-"+selfUrl+"-"+summary+"-"+regTime+"-"+tag);

        BasOrganizeInfoDao basOrganizeInfoDao=new BasOrganizeInfoImpl();
        PerOrganizeDao perOrganizeDao=new PerOrganizeImpl();
        Elements comElements=docMain.select("div.WB_innerwrap div[class=m_wrap clearfix] ul.clearfix li span[class=pt_detail]");
        for(Element element:comElements){
            if(element.text().contains("职位")){
                System.out.println(element.text());
                String[] company=element.text().split(" ");
                BasOrganizeInfo basOrganizeInfo = new BasOrganizeInfo();
                PerOrganize perOrganize = new PerOrganize();
                for(String com:company){
                    if(com.contains("地区")){
                        basOrganizeInfo.setAddress(com.split("：")[1]);
                    }
                    if(com.contains("职位")){
                        perOrganize.setJob(com.split("：")[1]);
                    }
                }
                basOrganizeInfo.setOname(company[0]);
                basOrganizeInfo.setSource("微博");
                basOrganizeInfo.setUuid(ouuid);
                perOrganize.setSource("微博");
                perOrganize.setName(name);
                perOrganize.setOname(company[0]);
                perOrganize.setPuuid(uuid);
                perOrganize.setOuuid(ouuid);
                perOrganize.setRtype("工作经历");
                basOrganizeInfoDao.insertSingle(basOrganizeInfo);
                perOrganizeDao.insertPerOrgani(perOrganize);
            }
        }
        Elements schElements=docMain.select("div.WB_innerwrap div[class=m_wrap clearfix] ul.clearfix");
        for(Element element:schElements){
            if(element.select("ul").text().contains("大学")) {
                String[] schools=element.select("span a").text().split(" ");
                for(String school:schools){
                    BasOrganizeInfo basOrganizeInfo=new BasOrganizeInfo();
                    PerOrganize perOrganize=new PerOrganize();
                    basOrganizeInfo.setOname(school);
                    basOrganizeInfo.setSource("微博");
                    basOrganizeInfo.setUuid(ouuid);
                    perOrganize.setSource("微博");
                    perOrganize.setName(name);
                    perOrganize.setOname(school);
                    perOrganize.setPuuid(uuid);
                    perOrganize.setOuuid(ouuid);
                    perOrganize.setRtype("教育经历");
                    perOrganize.setJob("学生");
                    basOrganizeInfoDao.insertSingle(basOrganizeInfo);
                    perOrganizeDao.insertPerOrgani(perOrganize);
                }
            }
        }
    }


    public static void closeWebDriver(){
        driver.close();
        System.exit(0);
        perUrlList.clear();
    }



    public static void getPerInfoDataByList(List<String> urls) throws Exception {
        WebDriver driver =getWebDriver();
        login(username,password);
        getPerUrl(driver,comName);
        for(String url: urls) {
            getPerInfoDataByUrl(driver, url);
            Thread.sleep(8000);
        }
        closeWebDriver();
    }


    public static void main(String[] args) throws Exception {
        SpiderWm.getPerInfoDataByList(perUrlList);



    }
}
