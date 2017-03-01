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
    //获取整个页面的doc
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
        Document document=spiderURL.document(driver,"http://mil.huanqiu.com/observation/2017-03/10224937.html");
        Elements elements=document.getAllElements();
//        String title=elements.text();
////        System.out.println(elements);
//        System.out.println("-----------------我是title------------------");
//        System.out.println(title);
//        System.out.println("-----------------我是content------------------");
//        String content=document.select("p").text();
//        System.out.println(content);
        System.out.println(elements);

       }
}
