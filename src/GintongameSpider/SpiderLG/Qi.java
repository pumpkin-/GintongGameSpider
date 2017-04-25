package GintongameSpider.SpiderLG;

import JavaBean.QiYeCha;
import SpiderUtils.SpiderContant;
import dao.QiYeChaDao;
import dao.impl.QiYeChaImpl;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/23.
 */
public class Qi {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();
        List<String> urlList=new ArrayList<String>();
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        for(int i=1;i<14;i++){
            driver.get("http://www.qichacha.com/album_index.shtml?p="+i);
            WebElement webElement=driver.findElement(By.xpath("/html"));
            org.jsoup.nodes.Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
            Elements elements=doc.select("div.thumbnail");
            for(Element element:elements){
                String url="http://www.qichacha.com"+element.select("a").attr("href");
                System.out.println(url);
                urlList.add(url);
            }
            System.out.println("第"+i+"页加载完成---------------------------------------------");
        }
        QiYeChaDao qiYeChaDao=new QiYeChaImpl();

        for(String url :urlList){
            int n=0;
            driver.get(url);
            WebElement webElement=driver.findElement(By.xpath("/html"));
            org.jsoup.nodes.Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
            String next=doc.select("a.next").text();
            Boolean forever=false;
            if(StringUtils.isNotEmpty(doc.select("div[class=text-left m-t-lg m-b-lg]").text())) {
                forever=true;
                while (StringUtils.isNotEmpty(next)) {
                    Elements elements = doc.select("span.clear");
                    for (Element element : elements) {
                        QiYeCha qiYeCha=new QiYeCha();
                        n++;
                        String name = element.text();
                        qiYeCha.setName(name);
                        qiYeChaDao.insertName(qiYeCha);
                        System.out.println(name + "--" + n);
                    }
                    System.out.println("下一页" + doc.select("a.next").text());

                    javascriptExecutor.executeScript("document.getElementsByClassName(\"next\")[0].click()");
                    String handle = driver.getWindowHandle();
                    for (String handles : driver.getWindowHandles()) {
                        if (handles.equals(handle)) {
                            continue;
                        } else {
                            driver.close();
                            driver.switchTo().window(handles);
                        }
                    }
                    Thread.sleep(1000);
                    WebElement webElementMain = driver.findElement(By.xpath("/html"));
                    doc = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
                    next = doc.select("a.next").text();
                }
            }else{
                Elements elements = doc.select("span.clear");
                for (Element element : elements) {
                    QiYeCha qiYeCha=new QiYeCha();
                    n++;
                    String name = element.text();
                    qiYeCha.setName(name);
                    qiYeChaDao.insertName(qiYeCha);
                    System.out.println(name + "--" + n);
                }
            }
            if(forever==true){
                Elements elements = doc.select("span.clear");
                for (Element element : elements) {
                    QiYeCha qiYeCha=new QiYeCha();
                    n++;
                    String name = element.text();
                    qiYeCha.setName(name);
                    qiYeChaDao.insertName(qiYeCha);
                    System.out.println(name + "--" + n);
                }
            }
            System.out.println(url+"---------------------------------------------------------------");
        }



    }
}
