package GintongameSpider.Spider40407;

import JavaBean.ProKnowledge;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/2/23.
 */
public class Spider40407 {
    public static void main(String args[]) throws Exception {
        System.setProperty("phantomjs.binary.path", "E://GinTong//phantomjs-2.1.1-windows//bin//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.40407.com/news/gamenews/");
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
       /*String str= doc.select(".con_left_news a").text();
        System.out.println(str);*/

       // System.out.print("aaa");
        List<ProKnowledge> list = listKnowledge(doc,driver);

    }
    public static List<ProKnowledge> listKnowledge(Document doc,WebDriver driver){
        Elements elements = doc.select(".con_left_news dl");
        //System.out.println(elements);
        List<ProKnowledge> list = new ArrayList<ProKnowledge>();
        for(Element ele:elements){
            String author = ele.select("span").eq(0).text();
            String from = ele.select("span").eq(1).text();
            String time = ele.select("span").eq(2).text();
            //System.out.println(author+"  "+from+"  " +time);
            String href = ele.select("a").eq(0).attr("href");
            //System.out.println(href);
            driver.get("http://www.40407.com" + href);
            WebElement webElement1 = driver.findElement(By.xpath("/html"));
            Document doc1 = Jsoup.parse(webElement1.getAttribute("outerHTML"));
            String title = doc1.select(".con03_left h1").text();
            String label = doc1.select(".biaoqian_wz a").text();
            String main = doc1.select(".con02").outerHtml();
            System.out.println(title);
        }
        return  null;
    }
}
