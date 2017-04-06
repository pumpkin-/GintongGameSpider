package SpiderTYC;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by lenovo on 2017/1/11.
 */
public class SpiderTyc {
    public static void main(String args[]) throws IOException, InterruptedException {
        /*Runtime rt = Runtime.getRuntime();
        String exec = "/Users/lenovo/phantomjs/bin/phantomjs /Users/lenovo/phantomjs/code.js http://www.tianyancha.com/company/445476096";

        Process p = rt.exec(exec);
        InputStream is = p.getInputStream();

        Document doc = Jsoup.parse(is, "UTF-8", "http://www.tianyancha.com/company/5176430");
        System.out.println(doc.outerHtml());
        String childLink=doc.select("a").toString();
        Pattern pat = Pattern.compile("<h4>.+</h4>", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(childLink);*/


        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*driver.get("http://www.tianyancha.com/search?key=%E6%B8%B8%E6%88%8F&checkFrom=searchBox");
        Thread.sleep(20000);
        WebElement webElement2 = driver.findElement(By.xpath("/html"));
        String aa2 = webElement2.getAttribute("outerHTML");
        Document doc=Jsoup.parse(aa2);
        Elements links=doc.select("a.query_name.search-new-color[ng-click=$event.preventDefault();goToCompany(node.id);inClick=true;]");
        for(Element link:links){
            System.out.println(link.attr("href"));
        }*/
        driver.get("http://www.tianyancha.com/company/25693490");
        //Thread.sleep(2000);
        WebElement webElement2 = driver.findElement(By.xpath("/html"));
        String aa2 = webElement2.getAttribute("outerHTML");
        Document doc=Jsoup.parse(aa2);
        System.out.println(doc.outerHtml());


    }


}
