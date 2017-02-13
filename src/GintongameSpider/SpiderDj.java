package GintongameSpider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lenovo on 2017/1/20.
 */
public class SpiderDj {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dajie.com/account/login");
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys("1343490516@qq.com");
        driver.findElement(By.id("login-pwd")).clear();
        driver.findElement(By.id("login-pwd")).sendKeys("3961shy3961");
        Thread.sleep(10000);
        driver.findElement(By.id("login-submit")).click();
        driver.manage().deleteAllCookies();


        Thread.sleep(1000);
        driver.get("https://www.dajie.com/profile/WnRb5hiQ6fg*");
        driver.findElement(By.id("searchText")).clear();
        driver.findElement(By.id("searchText")).sendKeys("游戏");
        Thread.sleep(1000);
        driver.findElement(By.id("searchBtn_composite")).click();
        Thread.sleep(1000);
        WebElement webElementt = driver.findElement(By.xpath("/html"));
        String aa = webElementt.getAttribute("outerHTML");
        Document doc = Jsoup.parse(aa);
        Elements links=doc.select("div.icardm-list-c>p.sms>a.b.search-cardtips");
       /* for(Element link:links){
            String childLink="https:"+link.attr("href");
            System.out.println(childLink);
        }*/
        driver.get("https://www.dajie.com/profile/WnNY4xyV6Po*");
        WebElement webElement1 = driver.findElement(By.xpath("/html"));
        String aa1 = webElement1.getAttribute("outerHTML");
        Document doc1 = Jsoup.parse(aa1);
        System.out.println(doc1.outerHtml());
        String gerenbiaoq=doc1.select("div.post-info>p").get(1).text().replace("|", "").split(" ", 2)[0].trim();
        String xianjuzhudi=doc1.select("div.post-info>p").get(1).text().replace("|", "").split(" ", 2)[1].trim();
        String xuelir=null;
        Elements jiaoyu=doc1.select("div.record-bd.edu-exp>dl.exp-list");
        for(Element link:jiaoyu){
            int flag=0;
            String startdate=link.select("dt").text().split("至",2)[0].trim();
            String enddate=link.select("dt").text().split("至",2)[1].trim();
            String zhuanye=link.select("h4").text();
            String xuexiao=null;
            String xueli=null;
            try {
                xuexiao = link.select("p.ins-name>span").text().split("·")[0];
            }catch (Exception e1){
                xuexiao=null;
            }
            try {
                xueli = link.select("p.ins-name>span").text().split("·")[link.select("p.ins-name>span").text().split("·").length - 2];
            }catch (Exception e2){
                xueli=null;
            }
            if(flag==0){
                xuelir=xueli;
            }
            flag++;
            System.out.println(startdate);
            System.out.println(enddate);
            System.out.println(zhuanye);
            System.out.println(xuexiao);
            System.out.println(xueli);
        }

        Elements work=doc1.select("div.record-bd.job-exp>dl.exp-list");
        for(Element link:work){
            String shijian=link.select("dt").text();
            String zhiwu=link.select("h4").text();
            String gongsi=null;
            String hangye=null;
            String xinzi=null;
            String logo=null;
            try {
                gongsi = link.select("p.ins-name>span").get(0).text();
            }catch (Exception e3){
                gongsi=null;
            }
            try {
                hangye = link.select("p.ins-name>span").get(1).text();
            }catch (Exception e4){
                hangye=null;
            }
            try {
                xinzi = link.select("p.ins-name>span").get(4).text();
            }catch (Exception e5){
                xinzi=null;
            }
            try {
                logo = link.select("a.company-logo>img").attr("src");
            }catch (Exception e6){
                logo=null;
            }
            System.out.println(shijian);
            System.out.println(zhiwu);
            System.out.println(gongsi);
            System.out.println(hangye);
            System.out.println(xinzi);
            System.out.println(logo);
        }
    }
}
