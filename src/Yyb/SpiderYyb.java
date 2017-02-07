package Yyb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;


/**
 * Created by lenovo on 2017/2/7.
 */
public class SpiderYyb {
    public static void main(String args[]) throws InterruptedException, ParseException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String url="C:/Users/lenovo/Desktop/a/a.txt";
        Spider zq=new Spider();
        zq.zhua(url);
    }
}
class Spider{
    public void zhua(String url) throws InterruptedException, ParseException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.setProperty("phantomjs.binary.path", "E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://sj.qq.com/myapp/category.htm?orgame=2");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        int a=1;
        int b=0;
        for(int x=1;x>0;x++) {
            executor.executeScript("$('div.load-more-btn a').click()");
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc= Jsoup.parse(aa);
            if(doc.select("div.load-more-btn a").isEmpty()){
                break;
            }
        }
        WebElement webElement = driver.findElement(By.xpath("/html"));
        String aa = webElement.getAttribute("outerHTML");
        Document doc= Jsoup.parse(aa);
        Elements links=doc.select("div.app-info.clearfix>a");
        for(Element link:links){
            String childLink="http://sj.qq.com/myapp/"+link.attr("href");
            FileOutputStream fileout=new FileOutputStream(url,true);
            byte bt[] =(childLink+"\r\n").getBytes();
            fileout.write(bt,0,bt.length);
            driver.get(childLink);
            WebElement webElement1 = driver.findElement(By.xpath("/html"));
            String aa1 = webElement1.getAttribute("outerHTML");
            Document doc1= Jsoup.parse(aa1);
            Qx q=new Qx();
            q.qx(doc1,childLink,a,b);
            System.out.println(a);
            a++;
            System.out.println("-------------------------");
        }
    }
}
class Qx{
    public void qx(Document doc,String childLink,int a,int b) throws ParseException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String ouuid= UUID.randomUUID().toString();
        String pr_uuid=UUID.randomUUID().toString();
        String logo=doc.select("div.det-icon>img").attr("src");
        String name=doc.select("div.det-name-int").text();
        String dx=doc.select("div.det-size").text();
        String fl=doc.select("div.det-type-box a.det-type-link").text();
        String picture=null;
        String bb=null;
        String kfs=null;
        Elements linksjt=doc.select("span#J_PicTurnImgBox.pic-turn-img-box>div.pic-img-box>img");
        for(Element linkjt:linksjt){
            picture=(picture+","+linkjt.attr("data-src")).replace("null,","");
        }
        try {
            bb = doc.select("div.det-othinfo-container.J_Mod>div.det-othinfo-data").get(0).text();
        }catch (Exception e1){
            bb=null;
        }
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String gxtime=doc.select("div.det-othinfo-container.J_Mod>div.det-othinfo-data#J_ApkPublishTime").text().replace("年","-").replace("月","-").replace("日","");
        try {
            kfs = doc.select("div.det-othinfo-container.J_Mod>div.det-othinfo-data").get(2).text();
        }catch (Exception e2){
            kfs=null;
        }
        String g_desc=doc.select("div.det-intro-text>div.det-app-data-info").text();
        String xzlink=doc.select("div.det-ins-btn-box a.det-down-btn").attr("data-apkUrl");

        Mysql mysql=new Mysql();
        mysql.rk(name,logo,bb,picture,fl,kfs,g_desc,childLink,ouuid,dx,gxtime,xzlink,pr_uuid,a,b);
    }
}
class Zl{
    public void spider(String url) throws ParseException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.setProperty("phantomjs.binary.path", "E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://sj.qq.com/myapp/category.htm?orgame=2");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        int c=1;
        for(int x=1;x>0;x++) {
            executor.executeScript("$('div.load-more-btn a').click()");
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc= Jsoup.parse(aa);
            if(doc.select("div.load-more-btn a").isEmpty()){
                break;
            }
        }
        WebElement webElement = driver.findElement(By.xpath("/html"));
        String aa = webElement.getAttribute("outerHTML");
        Document doc= Jsoup.parse(aa);
        Elements links=doc.select("div.app-info.clearfix>a");
        for(Element link:links){
            String childLink="http://sj.qq.com/myapp/"+link.attr("href");
            File file=new File(url);
            FileInputStream ff=new FileInputStream(file);
            InputStreamReader rr=new InputStreamReader(ff);
            BufferedReader buffer=new BufferedReader(rr);
            StringBuffer sb=new StringBuffer();
            String line=null;
            boolean br=true;
            while ((line=buffer.readLine())!=null) {
                if(childLink.equals(line)){
                    br=false;
                }
            }
            if(br==true){
                int a=1;
                int b=1;
                driver.get(childLink);
                WebElement webElement1 = driver.findElement(By.xpath("/html"));
                String aa1 = webElement1.getAttribute("outerHTML");
                Document doc1= Jsoup.parse(aa1);
                Qx qq=new Qx();
                qq.qx(doc1,childLink,a,b);
                FileOutputStream fileout=new FileOutputStream(url,true);
                byte bt[] =(childLink+"\r\n").getBytes();
                fileout.write(bt,0,bt.length);
                System.out.println(c);
                c++;
                System.out.println("-----------------------------------");
            }
        }
    }
}
class Mysql{
    public void rk(String pr_name,String logo,String version,String picture,String gtheme,String develop_com,String g_desc,String url,String ouuid,String game_size,String web_update_time,String download_link,String pr_uuid,int a,int b) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url1="jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url1, username, password);

        String insertProGameInfo="insert into pro_game_info(gname,logo,version,picture,gtheme,develop_com,g_desc,url,source,uuid,game_size,web_update_time,download_link) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(insertProGameInfo);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertOrgProduct);

        ps.setString(1,pr_name);
        ps.setString(2,logo);
        ps.setString(3,version);
        ps.setString(4,picture);
        ps.setString(5,gtheme);
        ps.setString(6,develop_com);
        ps.setString(7,g_desc);
        ps.setString(8,url);
        ps.setString(9,"应用宝");
        ps.setString(10,pr_uuid);
        ps.setString(11,game_size);
        ps.setString(12,web_update_time);
        ps.setString(13,download_link);
        ps.addBatch();

        ps1.setString(1,develop_com);
        ps1.setString(2,"应用宝");
        ps1.setString(3,url);
        ps1.setString(4,ouuid);
        ps1.addBatch();

        ps2.setString(1,develop_com);
        ps2.setString(2,pr_name);
        ps2.setString(3,"开发商");
        ps2.setString(4,ouuid);
        ps2.setString(5,pr_uuid);
        ps2.setString(6,"应用宝");
        ps2.addBatch();

        if(a%10==0||b%1==0){
            ps.executeBatch();
            ps1.executeBatch();
            ps2.executeBatch();
        }
    }
}
