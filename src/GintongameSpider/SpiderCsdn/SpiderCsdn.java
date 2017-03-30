package GintongameSpider.SpiderCsdn;

import SpiderUtils.SpiderContant;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by admin on 2017/3/28.
 */
public class SpiderCsdn {
    public static void getOnePerson(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        //System.out.println(doc.outerHtml());
        String name=doc.select("dt.person-nick-name span").text();
        String field=doc.select("div.field div[class=tags clearfix] div.tag span").text();
        String skill=doc.select("div.skill div[class=tags clearfix] div.tag span").text();
        String person_education=doc.select("div.person_education").text();
        String person_job=doc.select("div.person_job").text();
        String email=doc.select("ul.clearfix li:contains(电子邮箱) span").text();
        String telephone=doc.select("ul.clearfix li:contains(手机号码) span").text();
        String QQ=doc.select("ul.clearfix li:contains(QQ号码) span").text();
        String weiXin=doc.select("ul.clearfix li:contains(微信号) span").text();
        System.out.println("名字:"+name);
        System.out.println("熟悉领域:"+field);
        System.out.println("专业技能:"+skill);
        System.out.println("教育经历:"+person_education);
        System.out.println("工作经历:"+person_job);
        System.out.println("邮箱:"+email);
        System.out.println("联系方式:"+telephone);
        System.out.println("QQ:"+QQ);
        System.out.println("微信:"+weiXin);

        driver.close();

    }


    public static void main(String[] args) throws InterruptedException {
        SpiderCsdn.getOnePerson("http://my.csdn.net/leilba");

       // SpiderCsdn.getOnePerson("http://my.csdn.net/sun1021873926");
    }
}
