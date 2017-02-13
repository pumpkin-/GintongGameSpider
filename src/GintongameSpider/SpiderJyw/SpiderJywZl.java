package GintongameSpider.SpiderJyw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/11.
 */
public class SpiderJywZl {
    public static void main(String args[]) throws InterruptedException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        String url= "/Spider/SpiderJyw/url";
        File file=new File("/Spider/SpiderJyw/url");
        Zl zl=new Zl();
        zl.zlSpider(url);
    }
}
class Zl{
    public void zlSpider(String url) throws IOException, InterruptedException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.setProperty("phantomjs.binary.path", "/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        WebDriver driver=new PhantomJSDriver();
        int c=1;
        for(int z=2;z<=3;z++){
            for(int i=1;i>0;i++){
                driver.get("http://www.9game.cn/category/"+z+"_0_0_0_0_"+i+"/");
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                for(int x=0;x<3;x++){
                    executor.executeScript("$(window).scrollTop(30000)");
                    Thread.sleep(1000);
                }
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc= Jsoup.parse(aa);
                Elements links=doc.select("a.info");
                for(Element link:links) {
                    String childLink=link.attr("href");
                    File file=new File(url);
                    FileInputStream filein=new FileInputStream(file);
                    InputStreamReader in=new InputStreamReader(filein);
                    BufferedReader bs=new BufferedReader(in);
                    String line=null;
                    boolean br=true;
                    while((line=bs.readLine())!=null){
                        if(childLink.equals(line)){
                            br=false;
                        }
                    }
                    if(br==true){
                        int a=1;
                        int b=1;
                        FileOutputStream fileout=new FileOutputStream(url,true);
                        byte[] bt=(childLink+"\r\n").getBytes();
                        fileout.write(bt,0,bt.length);
                        driver.get(childLink);
                        WebElement webElement1 = driver.findElement(By.xpath("/html"));
                        String aa1 = webElement1.getAttribute("outerHTML");
                        Document doc1=Jsoup.parse(aa1);
                        QxZl qxZl =new QxZl();
                        qxZl.qxsj(doc1,a,b,childLink);
                        System.out.println(c+"+"+i);
                        c++;
                        System.out.println("------------------------");
                    }
                }
                if(!doc.select("span.change").isEmpty()){
                    break;
                }
            }
        }
        driver.quit();
        System.exit(0);
    }
}
class QxZl {
    public void qxsj(Document doc,int a,int b,String childLink) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String ouuid= UUID.randomUUID().toString();
        String pr_uuid=UUID.randomUUID().toString();
        String pr_name=doc.select("div.title>h1.h1-title").text();
        String logo=doc.select("div.box-text>div.info>span.img img").attr("src");
        String lx=null;
        String az_yyjd=null;
        String pg_yyjd=null;
        try {
            lx = doc.select("div.p-des>p").get(0).text().split(":", 2)[1].trim();
        }catch (Exception e1){
            lx=null;
        }
        try {
            az_yyjd = doc.select("div.p-des>p").get(1).text().split(":", 2)[1].trim();
        }catch (Exception e2){
            az_yyjd="尚未开始";
        }
        try {
            pg_yyjd = doc.select("div.p-des>p").get(2).text().split(":", 2)[1].trim();
        }catch (Exception e3){
            pg_yyjd="尚未开始";
        }
        String desc=doc.select("div.tips p").text();
        String kfs=doc.select("div.tips div.company").text().replace("开发者：", "");
        String az_xalink="http://www.9game.cn"+doc.select("a[ajaxName=androidDownBtn]").attr("href");
        String pg_xzlink="http://www.9game.cn"+doc.select("a[ajaxName=iosDownBtn]").attr("href");
        Elements linksjt=doc.select("div.special-img.tall>span>img");
        String picture=null;
        for(Element linkjt:linksjt){
            picture=(picture+","+linkjt.attr("src")).replace("null,","");
        }
        MysqlZl mysqlZl =new MysqlZl();
        mysqlZl.rk(pr_name,logo,picture,az_yyjd,lx,kfs,desc,childLink,pr_uuid,az_xalink,ouuid,pg_yyjd,pg_xzlink,a,b);
    }
}
class MysqlZl {
    public void rk(String pname,String logo,String picture,String dpprogress,String gtheme,String develop_com,String g_desc,String childLink,String pr_uuid,String download_link,String ouuid,String pg_yyjd,String pg_xzlink,int a,int b) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url1="jdbc:mysql://10.10.128.206:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url1, username, password);

        String insertProGameInfo="insert into pro_game_info(gname,logo,picture,dpprogress,gtheme,develop_com,g_desc,url,source,uuid,download_link) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertProGameInfo);

        String insertProGamePlatform="insert into pro_game_platform(uuid,platform,dpprogress,download_link) values(?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertProGamePlatform);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps4=con.prepareStatement(insertOrgProduct);

        if(pname!=null&&pname.length()>0) {
            ps1.setString(1, pname);
            ps1.setString(2, logo);
            ps1.setString(3, picture);
            ps1.setString(4, dpprogress);
            ps1.setString(5, gtheme);
            ps1.setString(6, develop_com);
            ps1.setString(7, g_desc);
            ps1.setString(8, childLink);
            ps1.setString(9, "九游");
            ps1.setString(10, pr_uuid);
            ps1.setString(11, download_link);
            ps1.addBatch();

            ps2.setString(1, pr_uuid);
            ps2.setString(2, "安卓");
            ps2.setString(3, dpprogress);
            ps2.setString(4, download_link);
            ps2.addBatch();

            ps2.setString(1, pr_uuid);
            ps2.setString(2, "苹果");
            ps2.setString(3, pg_yyjd);
            ps2.setString(4, pg_xzlink);
            ps2.addBatch();

            ps3.setString(1, develop_com);
            ps3.setString(2, "九游");
            ps3.setString(3, childLink);
            ps3.setString(4, ouuid);
            ps3.addBatch();

            ps4.setString(1, develop_com);
            ps4.setString(2, pname);
            ps4.setString(3, "开发商");
            ps4.setString(4, ouuid);
            ps4.setString(5, pr_uuid);
            ps4.setString(6, "九游");
            ps4.addBatch();
        }else{
            System.out.println(childLink);
        }

        if(a%10==0||b%1==0){
            ps1.executeBatch();
            ps2.executeBatch();
            ps3.executeBatch();
            ps4.executeBatch();
        }
    }
}
