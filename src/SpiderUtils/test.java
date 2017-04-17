package SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;


import dao.impl.BasKnowledgeInfoDaoImpl;

import org.dom4j.DocumentException;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.text.ParseException;

import java.util.List;


public class test {
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, BasKnowledgeInfoDaoImpl.FormatEexception, InterruptedException, ParseException {
//TODO
//      org.jsoup.nodes.Document doc1=Jsoup.connect("http://news.yxrb.net/201703/119906.html")
//                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
//                         .get();
//        JXDocument doc=new JXDocument(doc1);
//        List<Object> list=doc.sel("//span[@class='post-time']/time/text()");
//        for(Object lists:list){
//            System.out.println(lists.toString());
//        }







//selenium查看网页源码
//////
//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://www.cgigc.com.cn/cgigc/investment-financing-detail.html?queryId=161");
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
//        JXDocument jxDocument=new JXDocument(doc);
//        System.out.println(jxDocument.sel("//p[@data-bind='text:investDetailModel.investMarketDetail.description']"));
//

    }
}
