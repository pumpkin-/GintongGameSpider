package GintongameSpider.Spider265g;

import JavaBean.ProKnowledge;
import dao.impl.ProKnowledgeImpl;
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
 * Created by admin on 2017/2/22.
 */
public class Spider265g {
    public static void main(String args[]) throws Exception {
        System.setProperty("phantomjs.binary.path", "E://GinTong//phantomjs-2.1.1-windows//bin//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://pc.265g.com/news/xw/");
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        doc.select("");
        List<ProKnowledge> list = Spider265g.listPage(doc,driver);
        ProKnowledgeImpl proKnowledge = new ProKnowledgeImpl();
        proKnowledge.insertBatch(list);
      //  System.out.println("标题："+title+"   日期: "+time+"   作者:  "+author+"  来源："+from+"   更新时间："+publish+"  正文："+article);
    }
    public  static List<ProKnowledge> listPage(Document doc,WebDriver driver){
        Elements elements = doc.select(".title-list li");
        List<ProKnowledge> list = new ArrayList<ProKnowledge>();

        for(Element ele : elements) {
            ProKnowledge pro = new ProKnowledge();
            String title = ele.select("a").text();
            String time = ele.select("em").text();
            String href = ele.select("a").attr("href");
            //System.out.println(href);
            driver.get("http://pc.265g.com" + href);
            WebElement webElement1 = driver.findElement(By.xpath("/html"));
            Document doc1 = Jsoup.parse(webElement1.getAttribute("outerHTML"));
            String author = doc1.select(".article-author").text();
            String from = doc1.select(".article-from").text();
            String publish = doc1.select(".article-publish").text();
            String article = doc1.select(".article p").text();
            pro.setAuthor(author);
            pro.setTitle(title);
            pro.setPtime(time);
            pro.setMain(article);
            pro.setSource("http://pc.265g.com");
            list.add(pro);

            //System.out.println(pro);
        }
        return list;

    }

}














