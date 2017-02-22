package GintongameSpider.SpiderYmxk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


/**
 * Created by lenovo on 2017/2/17.
 */
public class SpiderYmxk {

    public static void main(String [] args) throws Exception{
        grabWeb();
    }

    public static void grabWeb(){
//        System.setProperty("phantomjs.binary.path", "E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver();
//        driver.get("http://www.gamersky.com/news");
//        WebElement webElement = driver.findElement(By.xpath("/html"));
//        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        //标签
//        Elements biaoqian=doc.select("div.tit a.dh");
//       for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text());
//       }
        //标题
//        Elements linksauthor=doc.select("div.tit a.tt");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text());
//        }

        //图片路径
//        Elements linksauthor=doc.select(".img a img.pe_u_thumb");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.attr("src"));
//        }

        //简介
//        Elements linksauthor=doc.select("div.con div.txt");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text());
//        }

        //时间
//        Elements linksauthor=doc.select("div.con div.time");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text());
//        }

        //内部页

        System.setProperty("phantomjs.binary.path", "E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.gamersky.com/news/201702/869895.shtml");
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        //标题
//        Elements linksauthor=doc.select("div.Mid2L_tit h1");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text());
//        }
        //时间
//        Elements linksauthor=doc.select("div.detail");
//        for(Element linkauthor:linksauthor){
//            System.out.println(linkauthor.text().substring(0,20));
//        }

        //来源
//        Elements linksauthor=doc.select("div.detail");
//        for(Element linkauthor:linksauthor) {
//            String message = linkauthor.text();
//            String[] message1 = message.split(" ");
//            System.out.println(message1[2].substring(3));
//        }

        //作者
//        Elements linksauthor=doc.select("div.detail");
//        for(Element linkauthor:linksauthor) {
//            String message = linkauthor.text();
//            String[] message1 = message.split(" ");
//            System.out.println(message1[3].substring(3));
//        }

        //编辑
//        Elements linksauthor=doc.select("div.detail");
//        for(Element linkauthor:linksauthor) {
//            String message = linkauthor.text();
//            String[] message1 = message.split(" ");
//            String[] message2=message1[4].split("浏");
//            System.out.println(message2[0].substring(3));
//        }

        //正文
        Elements linksauthor=doc.select("div.Mid2L_con p");
        System.out.println(linksauthor.text());
        // 正文内部图片
        Elements linksauthor1=doc.select("div.Mid2L_con p img");
        for(Element ele:linksauthor1){
            System.out.println(ele.attr("src"));
        }





    }
}
