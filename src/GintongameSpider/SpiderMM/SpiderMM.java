package GintongameSpider.SpiderMM;

import JavaBean.BasPersonInfo;
import MaiMaiDataParser.Maimai;
import SpiderUtils.SpiderContant;
import com.google.gson.Gson;
import dao.BasPersonInfoDao;
import dao.impl.BasPersonInfoImpl;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/1/16.
 */
public class SpiderMM {
    public static void main(String args[]) throws Exception {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor executornext = (JavascriptExecutor)driver;
        String WebUrl="https://maimai.cn/login";
        String username="13267462575";
        String password="123456";
        String url="https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1IjozMDU4Nzg2LCJsZXZlbCI6MX0.00WZZ-W-x7yNWdvsS_k81qco3Fhi-HG73QUt9dQub-Q?from=webview%23%2Fweb%2Fsearch_center";
//        String url="https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1Ijo2NTU2OTIsImxldmVsIjoxfQ.F3FIQONf8gf_QIeNYSPb9YsrbY25BUKFlNpZa8mVRh4?from=webview%23%2Fweb%2Fsearch_center";
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

            driver.get(url);
            WebElement webElementMain = driver.findElement(By.xpath("/html"));
            Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
            BasPersonInfoDao basPersonInfoDao=new BasPersonInfoImpl();
            String uuid= UUID.randomUUID().toString();

            //System.out.println(docMain.outerHtml());

            //姓名
            String name=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(2) > span > span").text();
            //公司职位
            String job=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(3) > span:nth-child(1)").text();
            //工作类型
            String jobStyle=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(4) > span:nth-child(1)").text();
            //电话
            String telephone=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(2) > span").text();
            //地区
            String address=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(3) > span").text();
            //邮箱
            String email=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(3) > dd:nth-child(4) > span").text();
            //影响力
            String effect=docMain.select("#react_app > div > div.PCcontainer.clearfix > div.PCcontent.float-l > div > div.list-group-item > div > dl:nth-child(2) > dd:nth-child(4) > span.text-primary").text();
            System.out.println("基本信息："+name+"-"+job+"-"+jobStyle+"-"+telephone+"-"+address+"-"+email+"-"+effect);
            //工作经历
            //工作地点名称
            String type=docMain.select("div.panel-default").attr("data-reactid").split(":")[0];
                String[] workNames = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] div.title").text().split(" ");
                //工作时间
                String[] workTypes = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] span[class=text-muted small]").text().split(" ");
                //公司类型
                String[] comTypes = docMain.select("div[data-reactid="+type+":$work] div[class=media-left cursor-pointer] div[class=text-content short-text]").text().split(" ");
                for(int i=0;i<workNames.length;i++){
                    String workName=workNames[i];
                    String workDate=workTypes[i].split("，")[0];
                    String workType=workTypes[i].split("，")[1];
                    String comType=comTypes[i];
                    System.out.println("工作经历："+workName+"****"+workDate+"*****"+workType+"*****"+comType);
                }

            //教育经历
                String[] eduNames = docMain.select("div[data-reactid="+type+":$edu] div[class=media-left cursor-pointer] div.title").text().split(" ");
                //工作时间
                String[] eduTypes = docMain.select("div[data-reactid="+type+":$edu] div[class=media-left cursor-pointer] span[class=text-muted small]").text().split(" ");
                //公司类型
                for(int i=0;i<eduNames.length;i++){
                    String eduName=eduNames[i];
                    String eduDate=eduTypes[i].split("，")[0];
                    String eduMajor=eduTypes[i].split("，")[1];
                    String eduLev=eduTypes[i].split("，")[2];
                    System.out.println("教育经历："+eduName+"-"+eduDate+"-"+eduMajor+"-"+eduLev);
                }

            //更多资料
            String tag=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".9");
            System.out.println("tag------"+tag);
            String other=docMain.select("div[data-reactid="+tag+"] div[class=media list-group-item-heading list-group-item-text]").text();
            System.out.println("other---------"+other);


            //标签
            String tagOne=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".b");
            System.out.println("tagOne-------------"+tagOne);
            String flag=docMain.select("div[data-reactid="+tagOne+"] span b[style=float:left;height:32px;line-height:20px;padding:6px 8px;font-weight:normal;color:#ffffff;]").text();
            System.out.println("flag--------------"+flag);

            //服务
            String tagTwo=docMain.select("div.panel-default").attr("data-reactid").split(":")[0].replace(".8",".c");
            String service=docMain.select("div[data-reactid="+tagTwo+"] div.ascInfo").text();
            System.out.println(service);

        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("cookies------>"+cookies);
        Map<String,Set> map=new HashMap<>();
        map.put("cookies",cookies);
        org.jsoup.Connection.Response res = Jsoup.connect("https://maimai.cn/contact/detail/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1IjozMDU4Nzg2LCJsZXZlbCI6MX0.00WZZ-W-x7yNWdvsS_k81qco3Fhi-HG73QUt9dQub-Q?from=webview%23%2Fweb%2Fsearch_center")
                .data("m","13267462575","p","123456")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .timeout(200000).ignoreHttpErrors(true).ignoreContentType(true).execute();
        System.out.println(res.cookies());
       // System.out.println(res.body());
        Gson gson = new Gson();


//        Maimai maimai = gson.fromJson(res.body(), Maimai.class);
//        System.out.println(maimai.data.uinfo.noaccount);
//        System.out.println(maimai.data.uinfo.noemail);
//        System.out.println(maimai.data.uinfo.nomobile);
//        System.out.println(maimai.data.uinfo.xingzuo);

//            BasPersonInfo basPersonInfo=new BasPersonInfo();
//            basPersonInfo.setSource("脉脉");
//            basPersonInfo.setName(name);
//            basPersonInfo.setUuid(uuid);
//            basPersonInfo.setUrl(url);
//            basPersonInfo.setCon_way(telephone);
//            basPersonInfo.setLiveplace(address);
//            basPersonInfo.setPtag(flag);
//            basPersonInfoDao.insertPerInfo(basPersonInfo);

            driver.close();

    }
}
