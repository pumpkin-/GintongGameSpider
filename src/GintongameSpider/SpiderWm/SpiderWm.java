package GintongameSpider.SpiderWm;

import JavaBean.*;
import MaiMaiDataParser.Maimai;
import SpiderUtils.KnowledgeSpiderConfig;
import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.model.JXDocument;
import com.google.gson.Gson;
import dao.*;
import dao.impl.*;
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
 * 爬取微博信息
 * Created by lenovo on 2017/3/1.
 */
public class SpiderWm {
    //微博用户名
    private static String username="15711490906";
    //微博密码
    private static String password="a19941031";

    private static List<String> perUrlList=new ArrayList<String>();
    //谷歌驱动器
    private static WebDriver driver=null;
    //爬取公司人名信息
    private static String comName="完美世界";
    //人物主页的Url（非详情页）
    private static String personUrl="http://weibo.com/mayun?refer_flag=1001030101_&is_hot=1";

    /**
     * 爬取列表页
     * @param driver
     * @param comName
     * @throws Exception
     */
    public static List<String> getPerUrl(WebDriver driver,String comName) throws Exception {
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
                System.out.println("page----:"+page);
            }
            for(int i=0;i<page-1;i++){
                try{
                    docMain=listPageSelenium(driver);
                    Elements elementsMain=docMain.select("div.person_detail p.person_name a[class=W_texta W_fb]");
                    for(Element element:elementsMain){
                        System.out.println(element.attr("href"));
                        perUrlList.add(element.attr("href"));
                    }
                    System.out.println("第"+(i+2)+"页数据已经跑完");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return perUrlList;
    }

    /**
     * 翻页
     * @param driver
     * @return
     * @throws InterruptedException
     */
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

    /**
     * 获取驱动器
     * @return
     */
    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * 登陆微博
     * @param username
     * @param password
     * @throws InterruptedException
     */
    public static String loginWeiBo(String username,String password) throws InterruptedException {
        String url="http://weibo.com/login.php";
        String result="登录失败";
        driver.get(url);
        JavascriptExecutor executornext = (JavascriptExecutor)driver;
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        Document doc= Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        driver.findElement(By.xpath("//*[@id=\"loginname\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div/div[3]/div[2]/div/input")).sendKeys(password);
        executornext.executeScript("document.getElementsByClassName('W_btn_a btn_32px ')[0].click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        WebElement element=driver.findElement(By.xpath("/html"));
        Document doca= Jsoup.parse(element.getAttribute("outerHTML"));
        String login=doca.select("#pl_login_form > div > div:nth-child(3) > div.info_list.login_btn > a").text();
        //System.out.println(login);
        if(login==null||login.equals("")){
            result="登录成功";
            return result;
        }else{
            return result;
        }

    }

    /**
     * 爬取单条网页
     * @param driver
     * @param perInfoUrl
     * @throws InterruptedException
     */
//    TODO
    public static BasPersonInfo getPerInfoDataByUrl(WebDriver driver, String perInfoUrl,String ouuid,String companyName) throws InterruptedException {
        String uuid= UUID.randomUUID().toString();
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
        basPersonInfo.setUrl(perInfoUrl);
        basPersonInfo.setAdvantage("测试HelloWorld");
        basPersonInfo.setBirthday(birthday);
        basPersonInfo.setP_desc(summary);
        basPersonInfo.setSex(sex);
        basPersonInfo.setPtag(tag);
        basPersonInfoDao.insertPerInfo(basPersonInfo);

        //System.out.println(name+"-"+livePlace+"-"+sex+"-"+birthday+"-"+bokeUrl+"-"+selfUrl+"-"+summary+"-"+regTime+"-"+tag);

        BasOrganizeInfoDao basOrganizeInfoDao=new BasOrganizeInfoImpl();
        PerOrganizeDao perOrganizeDao=new PerOrganizeImpl();
        PerWorkInfoDao perWorkInfoDao=new PerWorkInfoDaoImpl();
        PerEducationInfoDao perEducationInfoDao=new PerEducationInfoDaoImpl();
        Elements comElements=docMain.select("div.WB_innerwrap div[class=m_wrap clearfix] ul.clearfix li span[class=pt_detail]");
        for(Element element:comElements){
            if(element.text().contains("职位")){
                String eouuid =UUID.randomUUID().toString();
                //System.out.println(element.text());
                String[] company=element.text().split(" ");
                BasOrganizeInfo basOrganizeInfo = new BasOrganizeInfo();
                //微博组织入库
                if(!company[0].contains(companyName)){
                    basOrganizeInfo.setOname(company[0]);
                    basOrganizeInfo.setUuid(eouuid);
                    basOrganizeInfo.setSource("微博");
                    basOrganizeInfo.setBusiness_plan("测试HelloWorld");
                    basOrganizeInfoDao.insertSingle(basOrganizeInfo);
                }

                //微博人和工作关系入库
                PerWorkInfo perWorkInfo=new PerWorkInfo();
                perWorkInfo.setOname(company[0]);
                for(String com:company){
                    if(com.contains("地区")){
                        perWorkInfo.setCompany_addr(com.split("：")[1]);
                    }
                    if(com.contains("职位")){
                        perWorkInfo.setJob(com.split("：")[1]);
                    }
                }
                perWorkInfo.setUuid(uuid);
                perWorkInfo.setWtype("工作经历");
                perWorkInfoDao.insertPerWorkInfo(perWorkInfo);


                //微博人和组织入库
                PerOrganize perOrganize = new PerOrganize();
                for(String com:company){
                    if(com.contains("地区")){
                        basOrganizeInfo.setAddress(com.split("：")[1]);
                    }
                    if(com.contains("职位")){
                        perOrganize.setJob(com.split("：")[1]);
                    }
                }
                perOrganize.setSource("微博");
                perOrganize.setName(name);
                perOrganize.setOname(company[0]);
                perOrganize.setPuuid(uuid);
                if(company[0].contains(companyName)) {
                    perOrganize.setOuuid(ouuid);
                }else{
                    perOrganize.setOuuid(eouuid);
                }
                perOrganize.setRgDesc("测试HelloWorld");
                perOrganize.setRtype("工作经历");
                perOrganizeDao.insertPerOrgani(perOrganize);
            }
        }
        Elements schElements=docMain.select("div.WB_innerwrap div[class=m_wrap clearfix] ul.clearfix");
        for(Element element:schElements) {
            if (element.select("ul").text().contains("大学")) {
                String[] schools = element.select("span a").text().split(" ");
                for (String school : schools) {
                    String souuid=UUID.randomUUID().toString();
                    PerEducationInfo perEducationInfo=new PerEducationInfo();
                    BasOrganizeInfo basOrganizeInfo = new BasOrganizeInfo();
                    //微博组织入库
                    basOrganizeInfo.setOname(school);
                    basOrganizeInfo.setBusiness_plan("测试HelloWorld");
                    basOrganizeInfo.setUuid(souuid);
                    basOrganizeInfo.setTag("学校");
                    basOrganizeInfo.setSource("微博");
                    basOrganizeInfoDao.insertSingle(basOrganizeInfo);


                    //微博人和教育入库
                    perEducationInfo.setUuid(uuid);
                    perEducationInfo.setSchool(school);
                    perEducationInfo.setType((byte)2);
                    perEducationInfoDao.insertPerEducationInfo(perEducationInfo);


                    //微博人和组织入库
                    PerOrganize perOrganize = new PerOrganize();
                    perOrganize.setSource("微博");
                    perOrganize.setName(name);
                    perOrganize.setOname(school);
                    perOrganize.setPuuid(uuid);
                    perOrganize.setRgDesc("测试HelloWorld");
                    perOrganize.setOuuid(ouuid);
                    perOrganize.setRtype("教育经历");
                    perOrganize.setJob("学生");
                    perOrganizeDao.insertPerOrgani(perOrganize);
                }
            }
        }
        System.out.println(name+"：数据入库成功");
        return basPersonInfo;
    }

    /**
     * 网页爬取完成后自动关闭
     */
    public static void closeWebDriver(){
        driver.close();
        //System.exit(0);
        perUrlList.clear();
    }


    /**
     * 程序主流程
     * @param urls
     * @throws Exception
     */
    public static void getPerInfoDataByList(List<String> urls,String ouuid,String companyName) throws Exception {
        WebDriver driver =getWebDriver();
        String result=loginWeiBo(username, password);
        if(result.equals("登录成功")) {
            getPerUrl(driver, comName);
            for (String url : urls) {
                getPerInfoDataByUrl(driver, url,ouuid,companyName);
                Thread.sleep(8000);
            }
            closeWebDriver();
        }else{
            System.out.println("账号或者密码错误，登录失败!");
            closeWebDriver();
        }
    }

    public static List<BasPersonInfo> getPerInfoDataByComName(String companyName,String ouuid) throws Exception {
        WebDriver driver =getWebDriver();
        String result=loginWeiBo(username, password);
        List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
        if(result.equals("登录成功")) {
            List<String> urlsByComName=getPerUrl(driver, companyName);
            for (String url : urlsByComName) {
                try{
//                    TODO
                    BasPersonInfo basPersonInfo=getPerInfoDataByUrl(driver, url,ouuid,companyName);
                    basPersonInfoList.add(basPersonInfo);
                    Thread.sleep(8000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            closeWebDriver();
        }else{
            System.out.println("账号或者密码错误，登录失败!");
            closeWebDriver();
        }
        return basPersonInfoList;
    }


    public static void getPersonInfo(String url,String ouuid,String companyName) throws Exception {
        WebDriver driver =getWebDriver();
        String result=loginWeiBo(username, password);
        if(result.equals("登录成功")) {
            getPerUrl(driver, comName);
            getPerInfoDataByUrl(driver, url,ouuid,companyName);
            Thread.sleep(8000);
            closeWebDriver();
        }else{
            System.out.println("账号或者密码错误，登录失败!");
            closeWebDriver();
        }
    }

    public static void getOnePersonInfo(List<String> urls,String ouuid,String companyName) throws InterruptedException {
        WebDriver driver =getWebDriver();
        String result=loginWeiBo(username, password);
        if(result.equals("登录成功")) {
            for (String url : urls) {
                getPerInfoDataByUrl(driver, url,ouuid,companyName);
                Thread.sleep(8000);
            }
            closeWebDriver();
        }else{
            System.out.println("账号或者密码错误，登录失败!");
            closeWebDriver();
        }
    }


    public static void main(String[] args) throws Exception {
//        if(comName!=null) {
//            SpiderWm.getPerInfoDataByList(perUrlList);
//        }else{
//            perUrlList.add(personUrl);
//            SpiderWm.getOnePersonInfo(perUrlList);
//        }



    }
}
