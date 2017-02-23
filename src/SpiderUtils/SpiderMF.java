package SpiderUtils;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by 123 on 2017/2/22.
 */
public class SpiderMF {
    public static void main(String[] args) throws InterruptedException {
        try {
            SpiderUtils.getElements("windows", "spiderMf", 0,"no");

        }catch (Exception e){
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(2000);
        WebElement web=driver.findElement(By.xpath("/html"));
        JavascriptExecutor executormore = (JavascriptExecutor) driver;
        executormore.executeScript("$('#u1 > a:nth-child(2)')[0].click()");

    }
}
