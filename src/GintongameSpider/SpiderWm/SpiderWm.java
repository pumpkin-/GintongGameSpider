package GintongameSpider.SpiderWm;

import SpiderUtils.SpiderContant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * Created by lenovo on 2017/3/1.
 */
public class SpiderWm {
    public static void main(String[] args){
        String username="15711490906";
        String password="a19941031";
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();
        String url="http://weibo.com/login.php";
        //String url="http://weibo.com/p/1005055852633043/info?mod=pedit_more";
        driver.get(url);
        JavascriptExecutor executornext = (JavascriptExecutor)driver;
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        Document doc= Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        System.out.println(doc.outerHtml());
        driver.findElement(By.xpath("//*[@id=\"loginname\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div/div[3]/div[2]/div/input")).sendKeys(password);
        executornext.executeScript("$('#pl_login_form > div > div:nth-child(3) > div.info_list.login_btn > a').click()");

    }
}
