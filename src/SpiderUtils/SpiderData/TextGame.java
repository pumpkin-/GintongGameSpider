package SpiderUtils.SpiderData;

import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
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
    public static void main(String [] args) throws XpathSyntaxErrorException {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath );
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.youxituoluo.com/news");
        WebElement web = driver.findElement(By.xpath("/html"));
        String html = web.getAttribute("outerHTML");
        Document doc = Jsoup.parse(html);
       // System.out.println(doc.outerHtml());
        JXDocument document=new JXDocument(doc);
            System.out.println(document.sel("//div[@class='list']//section/time/a/text()"));
    }
}
