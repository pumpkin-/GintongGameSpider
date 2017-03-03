package GintongameSpider.SpiderLxm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
//        System.setProperty("phantomjs.binary.path", "D://phantomjs//phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver();
//        Document document=spiderURL.document(driver,"http://mil.huanqiu.com/observation/2017-03/10224937.html");
//        document.
//        Elements elements=document.getAllElements();
////        String title=elements.text();
//////        System.out.println(elements);
////        System.out.println("-----------------我是title------------------");
////        System.out.println(title);
////        System.out.println("-----------------我是content------------------");
////        String content=document.select("p").text();
////        System.out.println(content);
//        System.out.println(elements);
//
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
//        SimpleDateFormat dateFormater1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=dateFormater.parse("1983年9月23日");
            System.out.println(date.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
