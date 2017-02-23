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
 * Created by lenovon on 2017/2/23.
 */
public class SpiderChuapp {
//    获取页面的doc
    public static Document document(WebDriver driver,String url){
        driver.get(url);
        WebElement web=driver.findElement(By.xpath("/html"));
        String html=web.getAttribute("outerHTML");
        Document doc=Jsoup.parse(html);
        return doc;
    }
    //    获取页面详情页信息
    public static void getHtmlContent(WebDriver driver,String url){
        Document doc=SpiderChuapp.document(driver,url);
        Elements elements=doc.select(".single-cont");
        //        详情页标题
        String title=elements.select("h1").text();
        System.out.println("详情页面："+title);
        //        详情页编辑
        String author=elements.select(".author-time").text();
        System.out.println("详情页面："+author);
        //        详情页时间
        String time=elements.select(".friendly_time").text();
        System.out.println("详情页面："+time);
        String cont=elements.select(".the-content").text();
        System.out.println("详情页面："+cont);
    }
//    获取列表页信息
    public static void getCenterListContent(WebDriver driver,String url){
        Document doc=SpiderChuapp.document(driver,url);
    //        获取页面中间的图片、标题、内容信息信息
        Elements element= doc.select(".item");

       for(Element elements:element){
    //      获取页面的一个图片链接
           String img=elements.select("img").attr("src");
    //       获取页面的编辑时间
           String e=elements.select(".fn-clear .author_dom").text();
    //          获取页面的标题
           String title=elements.select("dt").text();
    //           获取页面的内容
           String cont=elements.select(".cont").text();
           System.out.println(img + "-- " + title + " --" + cont + "-- " + e);
       }

    }

    public static void main(String[] args){
        System.setProperty("phantomjs.binary.path", "D://phantomjs//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
    //        测试列表页信息
        SpiderChuapp.getCenterListContent(driver, "http://www.chuapp.com/");
    //        测试详细页面信息
    //        SpiderChuapp.getHtmlContent(driver,"http://www.chuapp.com/article/282321.html");
    }
}
