package GintongameSpider.SpiderMm;

import JavaBean.BasOrganizeInfo;
import JavaBean.BasPersonInfo;
import JavaBean.PerOrganize;
import MaiMaiDataParser.Contact;
import MaiMaiDataParser.Contacts;
import MaiMaiDataParser.Maimai;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/3/1.
 */

public class SpiderMaimai {

    private static WebDriver driver=null;
    //脉脉账号
    private static String username="13267462575";
    //脉脉密码
    private static String password="123456";
    //查询的公司名称(如果不想查公司赋值null)
    private static String comName=null;
    //查询个人时的所放的连接
    private static List<String> personList=new ArrayList();
    //个人的Url
    private static String personUrl="https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1Ijo1NzY1NTEsImxldmVsIjoxfQ.Tx9A06JaNUj5t-beBy6nHtpEnxH_JuG-V5WSK2-YI_c?from=webview%23%2Fweb%2Fsearch_center";
    //滚轮共滑动次数
    private static int count=30;

    public static void getPerUrl(WebDriver driver,String comName,int count) throws Exception {
        String comUrl="https://maimai.cn/web/search_center?type=contact&query="+comName+"&highlight=true";
        driver.get(comUrl);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        for(int i=0;i<count;i++) {
            docMain = slidingRoller(driver);
            System.out.println("请稍等正在获取数据!滚轮已滑动"+(i+1)+"次，共"+count+"次");
            Thread.sleep(1000);
        }
        Elements elements=docMain.select("div.media-left");
        for(Element element:elements){
            String tag=element.attr("data-reactid").split("\\$")[1].split("\\.")[0];
            String url="https://maimai.cn/contact/detail/"+tag;
            personList.add(url);
            System.out.println(url);
        }
    }

    public static Document slidingRoller(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("document.body.scrollTop='300000'");
        Thread.sleep(2000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        Document nextDocument=Jsoup.parse(webElement.getAttribute("outerHTML"));
        return nextDocument;
    }



    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void getPerInfoDataByList(List<String> urls) throws Exception {
        WebDriver driver =getWebDriver();
        login(username,password);
        getPerUrl(driver,comName,count);
        for(String url: urls) {
            getPerInfoDataByUrl(driver, url);
            Thread.sleep(8000);
        }
        closeWebDriver();
    }

    public static void getOnePersonInfo(List<String> urls) throws Exception {
        WebDriver driver =getWebDriver();
        login(username,password);
        for(String url: urls) {
            getPerInfoDataByUrl(driver, url);
            Thread.sleep(8000);
        }
        closeWebDriver();
    }

    public static void closeWebDriver() {
        driver.close();
        System.exit(0);
        personList.clear();
    }

    public static void login(String username,String password) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor)driver;
        String WebUrl="https://maimai.cn/login";
        //String url="https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1IjozMDU4Nzg2LCJsZXZlbCI6MX0.00WZZ-W-x7yNWdvsS_k81qco3Fhi-HG73QUt9dQub-Q?from=webview%23%2Fweb%2Fsearch_center";
        //String url="https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1Ijo2NTU2OTIsImxldmVsIjoxfQ.F3FIQONf8gf_QIeNYSPb9YsrbY25BUKFlNpZa8mVRh4?from=webview%23%2Fweb%2Fsearch_center";
        driver.get(WebUrl);
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        String loginBox=doc.select("body > div.wrap > div.matter.clearfix > div.content.ft > div").text();
        if(loginBox.contains("验证码")) {
            driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/div/input")).sendKeys(username);
            driver.findElement(By.xpath("//*[@id=\"form\"]/div[2]/input")).sendKeys(password);
            Scanner scan=new Scanner(System.in);
            System.out.println("请输入验证码:");
            String code=scan.nextLine();
            driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/input")).sendKeys(code);
            executornext.executeScript("$('#form > input.loginBtn').click()");
            Thread.sleep(1000);
        }else {
            driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/div/input")).sendKeys(username);
            driver.findElement(By.xpath("//*[@id=\"form\"]/div[2]/input")).sendKeys(password);
            executornext.executeScript("$('#form > input.loginBtn').click()");
            Thread.sleep(1000);
        }
    }






    public static void getPerInfoDataByUrl(WebDriver driver, String perInfoUrl) throws InterruptedException {
        driver.get(perInfoUrl);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        String uuid= UUID.randomUUID().toString();


        //HTML文本信息
        String main=docMain.outerHtml().split("JSON\\.parse\\(\"")[1].split("\"\\)\\;\\<\\/script\\>")[0];


        String reagx="\\\\u[0-9,a-f,A-F]{4}";
        Pattern pat=Pattern.compile(reagx);
        Matcher mat=pat.matcher(main);
        while(mat.find()){
            int data=Integer.parseInt(mat.group(0).replaceAll("\\\\u",""),16);
            main=main.replace(mat.group(0),String.valueOf((char) data));
        }

        //往数据库入数据
        Gson gson = new Gson();
        Maimai maimai = gson.fromJson(main, Maimai.class);
        String name=maimai.data.card.name;
        String com_now=maimai.data.card.company;
        String mmid=maimai.data.card.mmid;
        String position_now=maimai.data.card.position;
        String rank=maimai.data.card.rank;
        String diqu=maimai.data.card.province+maimai.data.card.city;
        String tags=maimai.data.uinfo.weibo_tags.toString();
        String mobile=maimai.data.uinfo.mobile;
        String phone=maimai.data.uinfo.phone;
        String email=maimai.data.uinfo.email;
        String jiaxiang=maimai.data.uinfo.ht_province+maimai.data.uinfo.ht_city;
        String account=maimai.data.uinfo.account;
        String province=maimai.data.uinfo.province;
        String city=maimai.data.uinfo.city;
        List<String> tag=maimai.data.uinfo.weibo_tags;
        StringBuffer sb=new StringBuffer();
        for(String ptag:tag){
            sb.append(ptag);
            sb.append(",");
        }
        String ptag=sb.toString();

        //人物信息入库
        BasPersonInfoDao basPersonInfoDao=new BasPersonInfoImpl();
        BasPersonInfo basPersonInfo=new BasPersonInfo();
        basPersonInfo.setUuid(uuid);
        basPersonInfo.setName(name);
        basPersonInfo.setHometown(jiaxiang);
        basPersonInfo.setCon_way(mobile);
        basPersonInfo.setSource("脉脉");
        basPersonInfo.setUrl(perInfoUrl);
        basPersonInfo.setPtag(ptag);
        basPersonInfo.setProvince(province);
        basPersonInfo.setCity(city);
        basPersonInfoDao.insertPerInfo(basPersonInfo);
        System.out.println(name+":数据入库成功！");



        //工作经历
        BasOrganizeInfoDao basOrganizeInfoDao=new BasOrganizeInfoImpl();
        PerOrganizeDao perOrganizeDao=new PerOrganizeImpl();
        String ouuid=UUID.randomUUID().toString();
        if(maimai.data.uinfo.work_exp!=null) {
            for (int x = 0; x < maimai.data.uinfo.work_exp.size(); x++) {
                BasOrganizeInfo basOrganizeInfo=new BasOrganizeInfo();
                String exp_com = maimai.data.uinfo.work_exp.get(x).company;
                String exp_position = maimai.data.uinfo.work_exp.get(x).position;
                String com_start = maimai.data.uinfo.work_exp.get(x).start_date;
                String com_end = maimai.data.uinfo.work_exp.get(x).end_date;
                String exp_description = maimai.data.uinfo.work_exp.get(x).description;
                basOrganizeInfo.setOname(exp_com);
                basOrganizeInfo.setSource("脉脉");
                basOrganizeInfo.setUuid(ouuid);
                basOrganizeInfoDao.insertSingle(basOrganizeInfo);

                PerOrganize perOrganize=new PerOrganize();
                perOrganize.setOuuid(ouuid);
                perOrganize.setOname(exp_com);
                perOrganize.setSource("脉脉");
                perOrganize.setPuuid(uuid);
                perOrganize.setRtype("工作经历");
                perOrganize.setJob(exp_position);
                perOrganize.setName(name);
                perOrganizeDao.insertPerOrgani(perOrganize);

            }
        }
        if(maimai.data.uinfo.education!=null) {
            for (int y = 0; y < maimai.data.uinfo.education.size(); y++) {
                BasOrganizeInfo basOrganizeInfo = new BasOrganizeInfo();
                String edu_school = maimai.data.uinfo.education.get(y).school;
                String edu_department = maimai.data.uinfo.education.get(y).department;
                String edu_start = maimai.data.uinfo.education.get(y).start_date;
                String edu_end = maimai.data.uinfo.education.get(y).end_date;
                String edu_description = maimai.data.uinfo.education.get(y).description;
                basOrganizeInfo.setOname(edu_school);
                basOrganizeInfo.setUuid(ouuid);
                basOrganizeInfo.setSource("脉脉");
                basOrganizeInfoDao.insertSingle(basOrganizeInfo);

                PerOrganize perOrganize = new PerOrganize();
                perOrganize.setOuuid(ouuid);
                perOrganize.setOname(edu_school);
                perOrganize.setSource("脉脉");
                perOrganize.setPuuid(uuid);
                perOrganize.setRtype("教育经历");
                perOrganize.setJob("学生");
                perOrganize.setName(name);
                perOrganizeDao.insertPerOrgani(perOrganize);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        if (comName!=null){
            getPerInfoDataByList(SpiderMaimai.personList);
        }else{
            personList.add(personUrl);
            getOnePersonInfo(SpiderMaimai.personList);
        }
    }
}
