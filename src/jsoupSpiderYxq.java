import com.mysql.jdbc.PreparedStatement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/1/7.
 */
public class jsoupSpiderYxq {
    public static void main(String args[]) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        try {
            String driver1 = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100";
            String username = "gtcom";
            String password = "admin@gt.com1";
            Class.forName(driver1).newInstance();
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "insert into linshi(html_yxq_gs) values(?)";

            PreparedStatement s11 = (PreparedStatement) con.prepareStatement(sql);


            System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe"); //设定本地的火狐软件
            WebDriver driver = new ChromeDriver();                                                 //调用火狐浏览器

            driver.get("http://www.syqnr.com/user/login");


            driver.findElement(By.id("email")).clear();                                               //获取id值
            driver.findElement(By.id("email")).sendKeys("wangfei847782566@163.com");                      //写入用户名
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("5459146");
            driver.findElement(By.id("dosubmit")).click();

            int a = 1;

            for (int i = 36; i <= 8000; i++) {

                driver.get("http://www.syqnr.com/company/index/0-0-0/" + i);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc = Jsoup.parse(aa);
                Elements links = doc.select("h3").select("a");
                for (Iterator<Element> element = links.iterator(); element.hasNext(); ) {
                    Element e = element.next();
                    String childLink = e.attr("href");
                    driver.get(childLink);
                    WebElement webElement1 = driver.findElement(By.xpath("/html"));
                    String bb = webElement1.getAttribute("outerHTML");
                    s11.setString(1, bb);
                    s11.addBatch();
                    if (a % 15 == 0) {
                        s11.executeBatch();
                    }
                    System.out.println(a+"+"+i);
                    a++;
                    int max = 20000;
                    int min = 10000;
                    Random random = new Random();
                    int s = random.nextInt(max) % (max - min + 1) + min;
                    Thread.sleep(s);
                }
            }
        }catch(Exception e){
            System.out.println("异常");
        }













        /*Document doc2=Jsoup.parse(bb);
        System.out.println(bb);
        System.out.println("-------------------------------------------");
        System.out.println(doc2.select("h1").select("a").attr("href"));
        System.out.println(doc2.select("h1").select("meta[class=url]"));
        String xinxi=doc2.select("li").outerHtml();
        Pattern pat= Pattern.compile("<li.*em.+</li>",Pattern.CASE_INSENSITIVE);
        Matcher mat=pat.matcher(xinxi);*/
        /*while(mat.find()){
            if(mat.group(0).contains("商务电话：")){
                System.out.println(mat.group(0).replace("<li>","").replace("<em>","").replace("</em>","").replace("<span>","").replaceAll("<a.+?>","").replace("</a>","").replace("</span>","").replace("</li>","").replace("商务电话：","").trim());
            }else if(mat.group(0).contains("类型：")){
                System.out.println(mat.group(0).replace("<li>","").replace("<em>","").replace("</em>","").replace("<span>","").replaceAll("<a.+?>","").replace("</a>","").replace("</span>","").replace("</li>","").replace("类型：","").trim());
            }else if(mat.group(0).contains("规模：")){
                System.out.println(mat.group(0).replace("<li>","").replace("<em>","").replace("</em>","").replace("<span>","").replaceAll("<a.+?>","").replace("</a>","").replace("</span>","").replace("</li>","").replace("规模：","").trim());
            }else if(mat.group(0).contains("地点：")){
                System.out.println(mat.group(0).replace("<li>","").replace("<em>","").replace("</em>","").replace("<span>","").replaceAll("<a.+?>","").replace("</a>","").replace("</span>","").replace("</li>","").replace("地点：","").trim());
            }else if(mat.group(0).contains("成立时间：")){
                System.out.println(mat.group(0).replace("<li>","").replace("<em>","").replace("</em>","").replace("<span>","").replaceAll("<a.+?>","").replace("</a>","").replace("</span>","").replace("</li>","").replace("成立时间：","").trim());
            }
        }*/
        //driver.close();
        /*for(int i=1;i<=80;i++) {
            driver.get("http://www.syqnr.com/company/index/0-0-0/"+i);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa);
            Elements links=doc.select("h3").select("a");
            for(Iterator<Element> element=links.iterator();element.hasNext();){
                Element e=element.next();
                String childLink=e.attr("href");
                driver.get(childLink);
                WebElement webElement1=driver.findElement(By.xpath("/html"));
                String bb=webElement1.getAttribute("outerHTML");
                Document doc2=Jsoup.parse(bb);
            }
        }*/


    }

}
