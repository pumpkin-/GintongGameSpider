package GintongameSpider.SpiderLG;

import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by admin on 2017/3/28.
 */
public class TestTwo {
    public static void main(String [] args) throws XpathSyntaxErrorException {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();

        driver.get("http://weibo.com/login.php");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        System.out.println(doc.outerHtml());
//        Select select=new Select(driver.findElement(By.ById.xpath("//select[@id='txt_1_sel']")));
//        select.selectByValue("AF$%");

//        JXDocument jxdoc=new JXDocument(doc);
//        String main=jxdoc.sel("//section[@class='textblock']/allText()").toString();
//        System.out.println(main);
        //System.out.println(doc.outerHtml());
//        String email=doc.select("ul.clearfix li:contains(电子邮箱) span").text();
//        String telephone=doc.select("ul.clearfix li:contains(手机号码) span").text();
//        System.out.println(email+"----"+telephone);
    }
}
