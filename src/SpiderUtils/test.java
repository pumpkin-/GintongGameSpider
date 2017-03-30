package SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;


import dao.impl.ProKnowledgeImpl;

import org.dom4j.DocumentException;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.text.ParseException;

import java.util.List;


public class test {
//    public static WebDriver getChromeDriver(){
//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
//        return new ChromeDriver();
//    }
//    public static WebDriver driver=getChromeDriver();
    static List<org.dom4j.Element> books;
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {
//jsoup查看网页源码
//http://chanye.07073.com/     http://chanye.07073.com/shuju/1560716.html
//TODO
//      org.jsoup.nodes.Document doc1=Jsoup.connect("http://search.ifeng.com/sofeng/search.action?q=%E4%BA%BA%E5%8A%9B%E8%B5%84%E6%BA%90&c=1&p=2")
//                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
//                         .get();
//        JXDocument doc=new JXDocument(doc1);
//       System.out.println(doc1.outerHtml());







//selenium查看网页源码
//////
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://news.baidu.com/ns?word=%E5%AE%8C%E7%BE%8E%E4%B8%96%E7%95%8C&tn=newstitle&from=news&cl=2&rn=20&ct=0");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
        JXDocument jxDocument=new JXDocument(doc);
        System.out.println(doc.outerHtml());
////        System.out.println(jxDocument.sel(""));
//        JavascriptExecutor executor= (JavascriptExecutor) driver;
//        executor.executeScript("$(\'doc.sel(\"//a[text()*='下一页']/@href\")\').click()");


    }
}
