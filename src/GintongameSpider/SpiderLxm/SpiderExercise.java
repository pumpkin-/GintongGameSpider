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
 * Created by lenovon on 2017/2/22.
 */
public class SpiderExercise {
//    获取整个页面的doc
    public static Document document(WebDriver driver ,String url){
        driver.get(url);
        WebElement web=driver.findElement(By.xpath("/html"));
        String html=web.getAttribute("outerHTML");
        Document doc= Jsoup.parse(html);
    return doc;
    }
//    获取页面的详情页
    public static void getHtmlContent(WebDriver driver,String url){
        Document doc=document(driver,url);
        Elements element=doc.select(".article");
//        获取文章的标题
        String title=element.select("h1").html();
        System.out.println("标题："+title);
//        获取文章标题头信息
        Elements infos=doc.select(".article-info span");
       for(Element info:infos){
        String author=info.html();
           System.out.println(author);
       }
//获取页面的图片
//        doc.select("")
    }
//    获取整个页面的链接
    public static void getHtmlHref(WebDriver driver ,String url){
        driver.get(url);
        WebElement web=driver.findElement(By.xpath("/html"));
        String html=web.getAttribute("outerHTML");
        Document doc=Jsoup.parse(html);
        Elements hrefs=doc.select(".title-list a");
        for(Element href:hrefs ){
            String link=href.attr("href");
            System.out.println(link);
        }
    }
    public static void main(String[] args){
        System.setProperty("phantomjs.binary.path", "D://phantomjs//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
       SpiderExercise.getHtmlContent(driver, "http://pc.265g.com/news/1702/16167.html");
    }
}