package GintongameSpider.Spider17173;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/1/19.
 */
public class SpiderYx17173 {
    public static void DY() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertProGameInfo="insert into pro_game_info(gname,logo,gstyle,gtags,picture,gtheme,charge_mode,develop_com,beta_time,web,url,source,uuid,operator,g_desc,gamespy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo2="insert into pro_game_info(gname,logo,gstyle,gtags,picture,gtheme,charge_mode,develop_com,test_time,web,url,source,uuid,operator,g_desc,gamespy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo3="insert into pro_game_info(gname,logo,gstyle,gtags,picture,gtheme,charge_mode,develop_com,betatest_time,web,url,source,uuid,operator,g_desc,gamespy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo4="insert into pro_game_info(gname,logo,gstyle,gtags,picture,gtheme,charge_mode,develop_com,ziliaopian,web,url,source,uuid,operator,g_desc,gamespy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfote="insert into pro_game_info(gname,logo,gstyle,gtags,picture,gtheme,charge_mode,develop_com,web,url,source,uuid,operator,g_desc,gamespy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps1=con.prepareStatement(insertProGameInfo);
        PreparedStatement ps2=con.prepareStatement(insertProGameInfo2);
        PreparedStatement ps3=con.prepareStatement(insertProGameInfo3);
        PreparedStatement ps4=con.prepareStatement(insertProGameInfo4);
        PreparedStatement pste=con.prepareStatement(insertProGameInfote);


        String insertProGamePlatform="insert into pro_game_platform(uuid,platform) values(?,?)";
        PreparedStatement ps5=con.prepareStatement(insertProGamePlatform);

        String insertProGameType="insert into pro_game_type(uuid,gtype) values(?,?)";
        PreparedStatement ps6=con.prepareStatement(insertProGameType);


        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement psd1=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement psd2=con.prepareStatement(insertOrgProduct);


        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        int a=1;
        for(int i=1;i<=124;i++) {
            driver.get("http://newgame.17173.com/game-list.html?page="+i);
            WebElement webElement5 = driver.findElement(By.xpath("/html"));
            String aa5 = webElement5.getAttribute("outerHTML");
            Document doc2 = Jsoup.parse(aa5);
            Elements links = doc2.select("div.c1>a");
            for (Element link : links) {
                String uuid= UUID.randomUUID().toString();
                String uuidgs=UUID.randomUUID().toString();
                int ce=0;
                String childLink = link.attr("href");
                driver.get(childLink);
                WebElement webElement6 = driver.findElement(By.xpath("/html"));
                String aa6 = webElement6.getAttribute("outerHTML");
                Document doc3 = Jsoup.parse(aa6);
                String name = doc3.select("h1.tit").text();
                String ceshishijian=null;
                String ceshiqingkuang=null;
                try {
                    ceshishijian = doc3.select("span.ex").get(ce).text().substring(5, 21);
                }catch (Exception e1){
                    ceshishijian=null;
                }
                try {
                    ceshiqingkuang = doc3.select("span.ex").get(ce).text().substring(22);
                }catch (Exception e2){
                    ceshiqingkuang=null;
                }
                String pingtai=null;
                String huamian=null;
                String huafeng=null;
                String kaifashang=null;
                String ticai=null;
                String moshi=null;
                String shoufei=null;
                String leixing=null;
                String tezheng=null;
                String guanwang1=null;
                try {
                    pingtai = doc3.select("span.con").get(0).select("a").attr("title");
                }catch (Exception e15){
                    pingtai=null;
                }
                try {
                    huamian = doc3.select("span.con").get(1).select("a").attr("title");
                }catch (Exception e16){
                    huamian=null;
                }
                String logo=doc3.select("div.avatar-box>img").attr("src");
                try {
                    huafeng = doc3.select("span.con").get(3).select("a").attr("title");
                }catch (Exception e17){
                    huafeng=null;
                }
                try {
                    kaifashang = doc3.select("span.con").get(4).select("a").attr("title");
                }catch (Exception e18){
                    kaifashang=null;
                }
                try {
                    ticai = doc3.select("span.con").get(5).select("a").attr("title");
                }catch (Exception e19){
                    ticai=null;
                }
                String yunyingshang = doc3.select("ul.test-info-list a").attr("title");
                try {
                    moshi = doc3.select("span.con").get(6).select("a").attr("title");
                }catch (Exception e20){
                    moshi=null;
                }
                try {
                    shoufei = doc3.select("span.con").get(7).text().replace(" ", ",");
                }catch (Exception e21){
                    shoufei=null;
                }
                try {
                    leixing = doc3.select("span.con").get(8).select("a").attr("title");
                }catch (Exception e22){
                    leixing=null;
                }
                String leixingz=moshi+","+leixing;
                //String zhuce = doc3.select("span.con").get(9).text().replace(" ", ",");

                try {
                    Elements linksg = doc3.select("span.con").get(10).select("a");
                    String guanwang = "null";
                    for (Element linkg : linksg) {
                        guanwang = guanwang + "," + linkg.attr("href");
                    }
                    guanwang1 = guanwang.replace("null,", "");
                }catch (Exception e23){
                    guanwang1=null;
                }
                //String zhuanqu = doc3.select("span.con").get(11).text().replace(" ", ",");
                try {
                    tezheng = doc3.select("span.con").get(12).select("a").text().replace(" ", ",");
                }catch (Exception e24){
                    tezheng=null;
                }
                String youxijianjie = doc3.select("div.pop-bd>p.txt").text();

                Elements linksp=doc3.select("div.bd>div.box-lightbox>ul.list-gallery.js-lightbox.roundabout-holder a");
                String jietu = "null";
                for(Element linkp:linksp){
                    String tupian=linkp.attr("href");
                    driver.get(tupian);
                    Thread.sleep(1000);
                    driver.get(tupian);
                    WebElement webElementt = driver.findElement(By.xpath("/html"));
                    String aat = webElementt.getAttribute("outerHTML");
                    Document doct = Jsoup.parse(aat);
                    jietu=jietu+","+doct.select("div.ad-image>img").attr("src");
                }
                String jietu1=jietu.replace("null,","");
                ce++;

                if(ceshiqingkuang!=null&&ceshiqingkuang.contains("公测")){
                    ps1.setString(1,name);
                    ps1.setString(2,logo);
                    ps1.setString(3,huafeng);
                    ps1.setString(4,tezheng);
                    ps1.setString(5,jietu1);
                    ps1.setString(6,ticai);
                    ps1.setString(7,shoufei);
                    ps1.setString(8,kaifashang);
                    ps1.setString(9,ceshishijian);
                    ps1.setString(10,guanwang1);
                    ps1.setString(11,childLink);
                    ps1.setString(12,"17173-DY");
                    ps1.setString(13,uuid);
                    ps1.setString(14,yunyingshang);
                    ps1.setString(15,youxijianjie);
                    ps1.setString(16,huamian);
                    ps1.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("内测")){
                    ps2.setString(1,name);
                    ps2.setString(2,logo);
                    ps2.setString(3,huafeng);
                    ps2.setString(4,tezheng);
                    ps2.setString(5,jietu1);
                    ps2.setString(6,ticai);
                    ps2.setString(7,shoufei);
                    ps2.setString(8,kaifashang);
                    ps2.setString(9,ceshishijian);
                    ps2.setString(10,guanwang1);
                    ps2.setString(11,childLink);
                    ps2.setString(12,"17173-DY");
                    ps2.setString(13,uuid);
                    ps2.setString(14,yunyingshang);
                    ps2.setString(15,youxijianjie);
                    ps2.setString(16,huamian);
                    ps2.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("封测")){
                    ps3.setString(1,name);
                    ps3.setString(2,logo);
                    ps3.setString(3,huafeng);
                    ps3.setString(4,tezheng);
                    ps3.setString(5,jietu1);
                    ps3.setString(6,ticai);
                    ps3.setString(7,shoufei);
                    ps3.setString(8,kaifashang);
                    ps3.setString(9,ceshishijian);
                    ps3.setString(10,guanwang1);
                    ps3.setString(11,childLink);
                    ps3.setString(12,"17173-DY");
                    ps3.setString(13,uuid);
                    ps3.setString(14,yunyingshang);
                    ps3.setString(15,youxijianjie);
                    ps3.setString(16,huamian);
                    ps3.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("资料片")){
                    ps4.setString(1,name);
                    ps4.setString(2,logo);
                    ps4.setString(3,huafeng);
                    ps4.setString(4,tezheng);
                    ps4.setString(5,jietu1);
                    ps4.setString(6,ticai);
                    ps4.setString(7,shoufei);
                    ps4.setString(8,kaifashang);
                    ps4.setString(9,ceshishijian);
                    ps4.setString(10,guanwang1);
                    ps4.setString(11,childLink);
                    ps4.setString(12,"17173-DY");
                    ps4.setString(13,uuid);
                    ps4.setString(14,yunyingshang);
                    ps4.setString(15,youxijianjie);
                    ps4.setString(16,huamian);
                    ps4.addBatch();
                }else{
                    pste.setString(1,name);
                    pste.setString(2,logo);
                    pste.setString(3,huafeng);
                    pste.setString(4,tezheng);
                    pste.setString(5,jietu1);
                    pste.setString(6,ticai);
                    pste.setString(7,shoufei);
                    pste.setString(8,kaifashang);
                    pste.setString(9,guanwang1);
                    pste.setString(10,childLink);
                    pste.setString(11,"17173-DY");
                    pste.setString(12,uuid);
                    pste.setString(13,yunyingshang);
                    pste.setString(14,youxijianjie);
                    pste.setString(15,huamian);
                    pste.addBatch();
                }

                if(pingtai!=null&&pingtai.length()>0) {
                    ps5.setString(1, uuid);
                    ps5.setString(2, pingtai);
                    ps5.addBatch();
                }

                if(leixingz!=null&&leixingz.length()>0) {
                    ps6.setString(1, uuid);
                    ps6.setString(2, leixingz);
                    ps6.addBatch();
                }

                if(kaifashang!=null&&kaifashang.length()>0){
                    psd1.setString(1,kaifashang);
                    psd1.setString(2,"17173-DY");
                    psd1.setString(3,childLink);
                    psd1.setString(4,uuidgs);
                    psd1.addBatch();

                    psd2.setString(1,kaifashang);
                    psd2.setString(2,name);
                    psd2.setString(3,"开发商");
                    psd2.setString(4,uuidgs);
                    psd2.setString(5,uuid);
                    psd2.addBatch();
                }
                System.out.println(a + "+" + i+"DY");
                a++;
                System.out.println("-------------------------------------------");

                if(a%25==0){
                    ps1.executeBatch();
                    ps2.executeBatch();
                    ps3.executeBatch();
                    ps4.executeBatch();
                    ps5.executeBatch();
                    ps6.executeBatch();
                    psd1.executeBatch();
                    psd2.executeBatch();
                }
            }
        }
    }
    public static void SY() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String insertProGamePlatform="insert into pro_game_platform(uuid,platform) values(?,?)";
        PreparedStatement ps5=con.prepareStatement(insertProGamePlatform);

        String insertProGameType="insert into pro_game_type(uuid,gtype) values(?,?)";
        PreparedStatement ps6=con.prepareStatement(insertProGameType);


        String insertProGameInfo5="insert into pro_game_info(gname,logo,language,network_type,gtags,picture,develop_com,g_desc,beta_time,url,source,uuid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo6="insert into pro_game_info(gname,logo,language,network_type,gtags,picture,develop_com,g_desc,test_time,url,source,uuid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo7="insert into pro_game_info(gname,logo,language,network_type,gtags,picture,develop_com,g_desc,betatest_time,url,source,uuid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo8="insert into pro_game_info(gname,logo,language,network_type,gtags,picture,develop_com,g_desc,ziliaopian,url,source,uuid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertProGameInfo9="insert into pro_game_info(gname,logo,language,network_type,gtags,picture,develop_com,g_desc,url,source,uuid) values(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps7=con.prepareStatement(insertProGameInfo5);
        PreparedStatement ps8=con.prepareStatement(insertProGameInfo6);
        PreparedStatement ps9=con.prepareStatement(insertProGameInfo7);
        PreparedStatement ps10=con.prepareStatement(insertProGameInfo8);
        PreparedStatement ps11=con.prepareStatement(insertProGameInfo9);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement pss1=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement pss2=con.prepareStatement(insertOrgProduct);



        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        int b=1;
        for(int x=1;x<=1587;x++) {
            driver.get("http://newgame.17173.com/shouyou-list.html?page=" + x);
            WebElement webElement10 = driver.findElement(By.xpath("/html"));
            String aa10 = webElement10.getAttribute("outerHTML");
            Document doc10 = Jsoup.parse(aa10);
            Elements links10 = doc10.select("h2.tit>a");
            for (Element link : links10) {
                String uuidgs=UUID.randomUUID().toString();
                String uuid=UUID.randomUUID().toString();
                int ce=0;
                String childLink = "http://newgame.17173.com" + link.attr("href");
                driver.get(childLink);
                WebElement webElement11 = driver.findElement(By.xpath("/html"));
                String aa11 = webElement11.getAttribute("outerHTML");
                Document doc11 = Jsoup.parse(aa11);
                String logo = doc11.select("div.game-img>img").attr("src");
                String name = doc11.select("h1.cn").text();
                String biaoqian = doc11.select("p.tags").text().replace(" ",",");
                String ceshishijian=null;
                String ceshiqingkuang=null;
                String leixing=null;
                String kaifashang=null;
                String yuyan=null;
                String lianwang=null;
                try {
                    ceshishijian = doc10.select("span.ex").get(ce).text().substring(5, 21);
                }catch (Exception e1){
                    ceshishijian=null;
                }
                try {
                    ceshiqingkuang = doc10.select("span.ex").get(ce).text().substring(22);
                }catch (Exception e2){
                    ceshiqingkuang=null;
                }
                try {
                    leixing = doc11.select("tbody>tr").get(0).select("td").get(0).text().replace("类型：", "").replace(" ", ",");
                }catch (Exception e5){
                    leixing=null;
                }
                try {
                    kaifashang = doc11.select("tbody>tr").get(0).select("td").get(1).text().replace("开发商：", "").replace(" ", ",");
                }catch (Exception e6){
                    kaifashang=null;
                }
                try {
                    yuyan = doc11.select("tbody>tr").get(1).select("td").get(0).text().replace("语言：", "").replace(" ", ",");
                }catch (Exception e7){
                    yuyan=null;
                }
                try {
                    lianwang = doc11.select("tbody>tr").get(1).select("td").get(1).text().replace("联网：", "");
                }catch (Exception e8){
                    lianwang=null;
                }
                String youxijianjie = doc11.select("div.clearfix>div.text-box>div.text-box-in>p").text();

                String jietu="null";
                Elements linkst=doc11.select("div.pic-box>a");
                for(Element linkt:linkst){
                    jietu=jietu+","+linkt.attr("href");
                }
                String jietu1=jietu.replace("null,","");

                String  flag="0";
                if(lianwang.equals("是")){
                    flag="2";
                }else if(lianwang.equals("否")){
                    flag="1";
                }
                ce++;
                if(ceshiqingkuang!=null&&ceshiqingkuang.contains("公测")) {
                    ps7.setString(1, name);
                    ps7.setString(2, logo);
                    ps7.setString(3, yuyan);
                    ps7.setString(4, flag);
                    ps7.setString(5, biaoqian);
                    ps7.setString(6, jietu1);
                    ps7.setString(7, kaifashang);
                    ps7.setString(8, youxijianjie);
                    ps7.setString(9, ceshishijian);
                    ps7.setString(10,childLink);
                    ps7.setString(11,"17173-SY");
                    ps7.setString(12,uuid);
                    ps7.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("内测")){
                    ps8.setString(1, name);
                    ps8.setString(2, logo);
                    ps8.setString(3, yuyan);
                    ps8.setString(4, flag);
                    ps8.setString(5, biaoqian);
                    ps8.setString(6, jietu1);
                    ps8.setString(7, kaifashang);
                    ps8.setString(8, youxijianjie);
                    ps8.setString(9, ceshishijian);
                    ps8.setString(10,childLink);
                    ps8.setString(11,"17173-SY");
                    ps8.setString(12,uuid);
                    ps8.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("封测")){
                    ps9.setString(1, name);
                    ps9.setString(2, logo);
                    ps9.setString(3, yuyan);
                    ps9.setString(4, flag);
                    ps9.setString(5, biaoqian);
                    ps9.setString(6, jietu1);
                    ps9.setString(7, kaifashang);
                    ps9.setString(8, youxijianjie);
                    ps9.setString(9, ceshishijian);
                    ps9.setString(10,childLink);
                    ps9.setString(11,"17173-SY");
                    ps9.setString(12,uuid);
                    ps9.addBatch();
                }else if(ceshiqingkuang!=null&&ceshiqingkuang.contains("资料片")){
                    ps10.setString(1, name);
                    ps10.setString(2, logo);
                    ps10.setString(3, yuyan);
                    ps10.setString(4, flag);
                    ps10.setString(5, biaoqian);
                    ps10.setString(6, jietu1);
                    ps10.setString(7, kaifashang);
                    ps10.setString(8, youxijianjie);
                    ps10.setString(9, ceshishijian);
                    ps10.setString(10,childLink);
                    ps10.setString(11,"17173-SY");
                    ps10.setString(12,uuid);
                    ps10.addBatch();
                }else{
                    ps11.setString(1, name);
                    ps11.setString(2, logo);
                    ps11.setString(3, yuyan);
                    ps11.setString(4, flag);
                    ps11.setString(5, biaoqian);
                    ps11.setString(6, jietu1);
                    ps11.setString(7, kaifashang);
                    ps11.setString(8, youxijianjie);
                    ps11.setString(9,childLink);
                    ps11.setString(10,"17173-SY");
                    ps11.setString(11,uuid);
                    ps11.addBatch();
                }

                ps5.setString(1,uuid);
                ps5.setString(2,"移动端");
                ps5.addBatch();

                if(leixing!=null&&leixing.length()>0) {
                    ps6.setString(1, uuid);
                    ps6.setString(2, leixing);
                    ps6.addBatch();
                }

                if(kaifashang!=null&&kaifashang.length()>0){
                    pss1.setString(1,kaifashang);
                    pss1.setString(2,"17173-SY");
                    pss1.setString(3,childLink);
                    pss1.setString(4,uuidgs);
                    pss1.addBatch();

                    pss2.setString(1,kaifashang);
                    pss2.setString(2,name);
                    pss2.setString(3,"开发商");
                    pss2.setString(4,uuidgs);
                    pss2.setString(5,uuid);
                    pss2.addBatch();
                }
                System.out.println(b + "+" + x+"SY");
                b++;
                System.out.println("-------------------------------------------");

                if(b%25==0){
                    ps7.executeBatch();
                    ps8.executeBatch();
                    ps9.executeBatch();
                    ps10.executeBatch();
                    ps11.executeBatch();
                    ps5.executeBatch();
                    ps6.executeBatch();
                    pss1.executeBatch();
                    pss2.executeBatch();
                }
            }
        }
    }
    public static void VR() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String insertProGamePlatform="insert into pro_game_platform(uuid,platform) values(?,?)";
        PreparedStatement ps5=con.prepareStatement(insertProGamePlatform);

        String insertProGameType="insert into pro_game_type(uuid,gtype) values(?,?)";
        PreparedStatement ps6=con.prepareStatement(insertProGameType);

        String insertProGameInfo10="insert into pro_game_info(gname,gename,logo,language,gtags,picture,gtheme,price,develop_com,g_desc,ptime,web,url,source,uuid,yunyingshang) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps12=con.prepareStatement(insertProGameInfo10);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement psv1=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement psv2=con.prepareStatement(insertOrgProduct);



        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        int c=1;
        for(int y=1;y<=29;y++) {
            driver.get("http://newgame.17173.com/vr-list.html?template=newgame&page="+y);
            WebElement webElement12 = driver.findElement(By.xpath("/html"));
            String aa12 = webElement12.getAttribute("outerHTML");
            Document doc12 = Jsoup.parse(aa12);
            Elements links12 = doc12.select("div.c1>a");
            for (Element link : links12) {
                String uuidgs=UUID.randomUUID().toString();
                String uuid=UUID.randomUUID().toString();
                String childLink = link.attr("href");
                driver.get("http://newgame.17173.com/game-info-5002306.html");
                WebElement webElement13 = driver.findElement(By.xpath("/html"));
                String aa13 = webElement13.getAttribute("outerHTML");
                Document doc13 = Jsoup.parse(aa13);
                String kaifashang=null;
                String yunyingshang=null;
                String guanwang=null;
                String shebei=null;
                String leixing=null;
                String ticai=null;
                String yuyan=null;
                String shebei1="null";

                String logo=doc13.select("div.game-pic>p.avatar>img").attr("src");
                try {
                    kaifashang = doc13.select("ul.list>li").get(0).select("div.detail").text().replace(" ", ",");
                }catch (Exception e9){
                    kaifashang=null;
                }
                try {
                    yunyingshang = doc13.select("ul.list>li").get(1).select("div.detail").text().replace(" ", ",");
                }catch (Exception e10){
                    yunyingshang=null;
                }
                try {
                    guanwang = doc13.select("ul.list>li").get(2).select("div.detail>a").attr("href");
                }catch (Exception e11){
                    guanwang=null;
                }
                String name=doc13.select("h1.name").text().replace("下载","").replace("VR","");
                String ename=doc13.select("p.en").text().replace("SIMILAR VR GAMES","").replace("NEWS","").replace("METRIC","").replace("REVIEWS","").replace("VR","");
                String shangshishijian=doc13.select("p.detail-txt").text();
                String jiage=doc13.select("p.txt").text().split(" ",2)[0];
                try {
                    for(int ts=0;ts<doc13.select("div.eqpt").get(0).select("a").size();ts++) {
                        shebei = shebei+","+doc13.select("div.eqpt").get(0).select("a").get(ts).attr("title");
                    }
                    shebei1=shebei.replace("null,","");
                }catch (Exception e12){
                    shebei1=null;
                }
                //String pingtai=doc13.select("div.eqpt").get(1).select("a").attr("title");
                try {
                    leixing = doc13.select("ul.list div.detail").get(4).select("a").text().replace(" ", ",");
                }catch (Exception e13){
                    leixing=null;
                }
                try {
                    ticai = doc13.select("ul.list div.detail").get(5).select("a").text().replace(" ", ",");
                }catch (Exception e14){
                    ticai=null;
                }
                // String wanjiarenshu=doc13.select("ul.list div.detail").get(6).select("span").text();
                //String kongzhishebei=doc13.select("ul.list div.detail").get(7).select("a").text().replace(" ", ",");
                String kongjian = "null";
                for(int u=0;u<doc13.select("ul.list div.detail").get(8).select("a").size();u++) {
                    kongjian=kongjian+","+doc13.select("ul.list div.detail").get(8).select("a").get(u).attr("title");
                }
                //String kongjian1=kongjian.replace("null,", "");
                try {
                    yuyan = doc13.select("ul.list div.detail").get(9).select("a").text().replace(" ", ",");
                }catch (Exception e15){
                    yuyan=null;
                }
                String guanjianzi=doc13.select("ul.list div.detail.tag").select("a").text().replace(" ", ",");
                String jianjie=doc13.select("div.mod-bd.js-show.hide>div.show-box>p").text();

                String jietu="null";
                Elements linkstt=doc13.select("span.avatar>img");
                for(Element linktt:linkstt){
                    jietu=jietu+","+linktt.attr("src");
                }
                String jietu1=jietu.replace("null,","");

                ps12.setString(1,name);
                ps12.setString(2,ename);
                ps12.setString(3,logo);
                ps12.setString(4,yuyan);
                ps12.setString(5,guanjianzi);
                ps12.setString(6,jietu1);
                ps12.setString(7,ticai);
                ps12.setString(8,jiage);
                ps12.setString(9,kaifashang);
                ps12.setString(10,jianjie);
                ps12.setString(11,shangshishijian);
                ps12.setString(12,guanwang);
                ps12.setString(13,childLink);
                ps12.setString(14,"17173-VR");
                ps12.setString(15,uuid);
                ps12.setString(16,yunyingshang);
                ps12.addBatch();

                if(shebei1!=null&&shebei1.length()>0) {
                    ps5.setString(1, uuid);
                    ps5.setString(2, shebei1);
                    ps5.addBatch();
                }

                if(leixing!=null&&leixing.length()>0) {
                    ps6.setString(1, uuid);
                    ps6.setString(2, leixing);
                    ps6.addBatch();
                }

                if(kaifashang!=null&&kaifashang.length()>0){
                    psv1.setString(1,kaifashang);
                    psv1.setString(2,"17173-DY");
                    psv1.setString(3,childLink);
                    psv1.setString(4,uuidgs);
                    psv1.addBatch();

                    psv2.setString(1,kaifashang);
                    psv2.setString(2,name);
                    psv2.setString(3,"开发商");
                    psv2.setString(4,uuidgs);
                    psv2.setString(5,uuid);
                    psv2.addBatch();
                }
                System.out.println(c + "+" + y+"VR");
                c++;
                System.out.println("-------------------------------------------");

                if(c%25==0) {
                    ps12.executeBatch();
                    ps5.executeBatch();
                    ps6.executeBatch();
                    psv1.executeBatch();
                    psv2.executeBatch();
                }
            }
        }
    }
    public static void main(String args[]) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException, InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                try {
                    DY();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                try {
                    SY();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadThree = new Thread(new Runnable() {
            public void run() {
                try {
                    VR();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
