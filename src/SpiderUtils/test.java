package SpiderUtils;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.dom4j.DocumentException;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class test {
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, BasKnowledgeInfoDaoImpl.FormatEexception, InterruptedException, ParseException {
//TODO









//selenium查看网页源码
//////
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.97973.com/ios/news.shtml");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc= Jsoup.parse(webElement.getAttribute("outerHTML"));
        System.out.println(doc);
//        String a=doc.select("pages f14").text();
//        System.out.println(a);
//

    }
}
