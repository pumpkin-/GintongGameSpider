package GintongameSpider.SpiderLxm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


/**
 * Created by lenovon on 2017/2/27.
 */
public class spiderURL {
    public static Document document(WebDriver driver,String url){
        driver.get(url);
        WebElement web=driver.findElement(By.xpath("/html"));
        String html=web.getAttribute("outerHTML");
        Document doc = Jsoup.parse(html);
        return doc;
    }
    public static void main(String[] args){
        System.setProperty("phantomjs.binary.path", "D://phantomjs//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        Document document=spiderURL.document(driver,"http://shouyoujz.com/");
        Elements elements=document.select("body a");
        String atext=elements.text();
        System.out.println(elements);
        System.out.println("-----------------我是条分割线------------------");
        System.out.println(atext);
        System.out.println("-----------------我是条分割线------------------");
        for(Element element:elements) {
            String href = element.attr("href");
            System.out.println(href);
        }
    }
}
