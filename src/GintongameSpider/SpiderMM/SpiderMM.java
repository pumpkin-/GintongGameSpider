package GintongameSpider.SpiderMM;

import JavaBean.BasOrganizeInfo;
import JavaBean.BasPersonInfo;
import JavaBean.PerOrganize;
import MaiMaiDataParser.Maimai;
import SpiderUtils.SpiderContant;
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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.nio.cs.UnicodeEncoder;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/1/16.
 */

class SpiderMm {
    private static WebDriver driver=null;
    private static String username="13267462575";
    private static String password="123456";




    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void getPerInfoDataByList(List<String> urls) throws InterruptedException {
        WebDriver driver =getWebDriver();
        login(username,password);
        for(String url: urls) {
            getPerInfoDataByUrl(driver, url);
        }
        closeWebDriver();
    }

    public static void closeWebDriver() {
        driver.close();
        System.exit(0);
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



//            driver.get(url);
//            WebElement webElementMain = driver.findElement(By.xpath("/html"));
//            Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
//            BasPersonInfoDao basPersonInfoDao=new BasPersonInfoImpl();
//            String uuid= UUID.randomUUID().toString();
//
//            //System.out.println(docMain.outerHtml());
//
//            //姓名
//            String name=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(2) > span > span").text();
//            //公司职位
//            String job=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(3) > span:nth-child(1)").text();
//            //工作类型
//            String jobStyle=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(4) > span:nth-child(1)").text();
//            //电话
//            String telephone=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(2) > span").text();
//            //地区
//            String address=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(3) > span").text();
//            //邮箱
//            String email=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(4) > span").text();
//            //影响力
//            String effect=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(4) > span.text-primary").text();
//            System.out.println("基本信息："+name+"-"+job+"-"+jobStyle+"-"+telephone+"-"+address+"-"+email+"-"+effect);
//            //工作经历
//            //工作地点名称
//            String type=docMain.select("div.panel-default").attr("data-reactid").split(":")[0];
//                String[] workNames = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] div.title").text().split(" ");
//                //工作时间
//                String[] workTypes = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] span[class=text-muted small]").text().split(" ");
//                //公司类型
//                String[] comTypes = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] div[class=text-content short-text]").text().split(" ");
//                for(int i=0;i<workNames.length;i++){
//                    String workName=workNames[i];
//                    String workDate=workTypes[i].split("，")[0];
//                    String workType=workTypes[i].split("，")[1];
//                    String comType=comTypes[i];
//                    System.out.println("工作经历："+workName+"****"+workDate+"*****"+workType+"*****"+comType);
//                }
//
//            //教育经历
//                String[] eduNames = docMain.select("div[data-reactid="+type+":$edu] div[class=media-left cursor-pointer] div.title").text().split(" ");
//                //工作时间
//                String[] eduTypes = docMain.select("div[data-reactid="+type+":$edu] div[class=media-left cursor-pointer] span[class=text-muted small]").text().split(" ");
//                //公司类型
//                for(int i=0;i<eduNames.length;i++){
//                    String eduName=eduNames[i];
//                    String eduDate=eduTypes[i].split("，")[0];
//                    String eduMajor=eduTypes[i].split("，")[1];
//                    String eduLev=eduTypes[i].split("，")[2];
//                    System.out.println("教育经历："+eduName+"-"+eduDate+"-"+eduMajor+"-"+eduLev);
//                }
//
//            //更多资料
//            String tag=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".9");
//            System.out.println("tag------"+tag);
//            String other=docMain.select("div[data-reactid="+tag+"] div[class=media list-group-item-heading list-group-item-text]").text();
//            System.out.println("other---------"+other);
//
//
//            //标签
//            String tagOne=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".b");
//            System.out.println("tagOne-------------"+tagOne);
//            String flag=docMain.select("div[data-reactid="+tagOne+"] span b[style=float:left;height:32px;line-height:20px;padding:6px 8px;font-weight:normal;color:#ffffff;]").text();
//            System.out.println("flag--------------"+flag);
//
//            //服务
//            String tagTwo=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".c");
//            String service=docMain.select("div[data-reactid="+tagTwo+"] div.ascInfo").text();
//            System.out.println(service);
//
//        Set<Cookie> cookies=driver.manage().getCookies();
//        System.out.println("cookies------>"+cookies);
//        Map<String,Set> map=new HashMap();
//        map.put("cookies",cookies);
//        org.jsoup.Connection.Response res = Jsoup.connect("https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1IjozMDU4Nzg2LCJsZXZlbCI6MX0.00WZZ-W-x7yNWdvsS_k81qco3Fhi-HG73QUt9dQub-Q?from=webview%23%2Fweb%2Fsearch_center")
//                .data("m","13267462575","p","123456")
//                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
//                .timeout(200000).ignoreHttpErrors(true).ignoreContentType(true).execute();
//        System.out.println(res.cookies());
//       // System.out.println(res.body());
//        Gson gson = new Gson();


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
        List<String> urls=new ArrayList<String>();
        urls.add("https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1IjozMDU4Nzg2LCJsZXZlbCI6MX0.00WZZ-W-x7yNWdvsS_k81qco3Fhi-HG73QUt9dQub-Q?from=webview%23%2Fweb%2Fsearch_center");
        urls.add("https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1Ijo2NTU2OTIsImxldmVsIjoxfQ.F3FIQONf8gf_QIeNYSPb9YsrbY25BUKFlNpZa8mVRh4?from=webview%23%2Fweb%2Fsearch_center");
        SpiderMm.getPerInfoDataByList(urls);
    }
}

