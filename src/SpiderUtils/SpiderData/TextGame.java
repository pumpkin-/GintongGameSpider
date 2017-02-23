package SpiderUtils.SpiderData;

import SpiderUtils.SpiderContant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by 123 on 2017/2/23.
 */
public class TextGame {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath );
        WebDriver driver= new ChromeDriver();
        driver.get("http://play.163.com/");
        WebElement web = driver.findElement(By.xpath("/html"));
        String html = web.getAttribute("outerHTML");
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }
}
