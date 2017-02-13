package GintongameSpider.SpiderTaptap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.*;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/11.
 */
public class SpiderTaptapZl {
    public static void main(String args[]) throws InterruptedException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        String url= "/Spider/SpiderTaptap/url";
        File file=new File("/Spider/SpiderTaptap/url");
        Zl zl=new Zl();
        zl.zlsj(url);
    }
}
class Zl{
    public void zlsj(String url) throws InterruptedException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.setProperty("phantomjs.binary.path", "/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        WebDriver driver=new PhantomJSDriver();
        int c=1;
        String[] tagz=new String[]{"生存","二次元","卡牌","音乐","竞速","策略","设计","up主推荐","休闲","多人","冒险","益智","中文","养成","像素","文字","街机","有毒","放置","恐怖","体育","经营","恋爱","解密","战棋","付费","沙盒","单机游戏","赛车","文字游戏","经营模拟","io","乙女","多人对战","探险","僵尸","开罗","桌面和棋类","模拟经营","射击游戏","格斗","自由","多人联机","独立游戏","跑酷","美少女","塔防","三国","枪战","火柴人","东方","知识问答","推理","联网","第一人称设计","教育","多人在线","虐心","多人合作","武侠","科幻","智力","删档测试","搞笑","魔性","猫","机甲","剧情","像素风","足球","挂机","点击","创意","弹珠","弹幕","技术党"};
        for(int i=0;i<tagz.length;i++){
            driver.get("https://www.taptap.com/search/tags?kw="+ URLEncoder.encode(tagz[i], "UTF-8"));
            for(int z=1;z>0;z++){
                driver.findElement(By.className("btn-lg")).click();
                Thread.sleep(1000);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc= Jsoup.parse(aa);
                System.out.println(doc.select("button.btn-lg"));
                if(doc.select("button.btn-lg[style=display: inline-block;]").isEmpty()){
                    break;
                }
            }
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc=Jsoup.parse(aa);
            Elements links=doc.select("div.taptap-app-card a.app-card-left");
            for(Element link:links){
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
        }
        driver.quit();
        System.exit(0);
    }
}
class QxZl {
    public void qxsj(Document doc,int a,int b,String childLink) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String ouuid= UUID.randomUUID().toString();
        String pr_uuid=UUID.randomUUID().toString();
        String language=null;
        String picture=null;
        String pgname1=null;
        String pgname=null;
        String size=null;
        String tag=null;
        String logo=doc.select("img[itemprop=image]").attr("src");
        String pname=doc.select("h1[itemprop=name]").text();

        pgname1=doc.select("div.main-header-text h2").text();
        if(pgname1.getBytes().length==pgname1.length()){
            pgname=pgname1;
        }else{
            pgname=null;
        }

        String kfs=doc.select("span[itemprop=name]").text();

        Elements linksyy=doc.select("ul.list-unstyled.main-body-additional span");
        for(Element linkyy:linksyy){
            if(linkyy.text().contains("文")) {
                language = (language + "," + linkyy.text()).replace("null,", "");
            }
        }
        String desc=doc.select("div.body-description-paragraph").text();
        try {
            size = doc.select("span.info-item-content").get(0).text();
            if(size.contains("年")||size.contains("月")||size.contains("日")){
                size=null;
            }
        }catch (Exception e1){
            size=null;
        }
        String bb=doc.select("span[itemprop=softwareVersion]").text();
        String gxtime=doc.select("span[itemprop=datePublished]").text().replace("年","-").replace("月","-").replace("日","");
        Elements linksjt=doc.select("ul.list-unstyled#imageShots a");
        for(Element linkjt:linksjt){
            picture=(picture+","+linkjt.attr("href")).replace("null,","");
        }
        Elements linkstag=doc.select("div.modal-body>ul a");
        for(Element linktag:linkstag){
            tag=(tag+","+linktag.text()).replace("null,","");
        }
        MysqlZl mysqlZl =new MysqlZl();
        mysqlZl.rk(pname,logo,picture,kfs,desc,childLink,pr_uuid,ouuid,a,b,pgname,bb,language,tag,size,gxtime);
    }
}
class MysqlZl {
    public void rk(String pname,String logo,String picture,String develop_com,String g_desc,String childLink,String pr_uuid,String ouuid,int a,int b,String gename,String version,String language,String gtags,String game_size,String web_update_time) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url1="jdbc:mysql://10.10.128.206:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url1, username, password);

        String insertProGameInfo="insert into pro_game_info(gname,gename,logo,version,"+"`"+"language"+"`"+",picture,gtags,develop_com,g_desc,url,source,uuid,game_size,web_update_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertProGameInfo);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertOrgProduct);

        ps1.setString(1,pname);
        ps1.setString(2,gename);
        ps1.setString(3,logo);
        ps1.setString(4,version);
        ps1.setString(5,language);
        ps1.setString(6,picture);
        ps1.setString(7,gtags);
        ps1.setString(8,develop_com);
        ps1.setString(9,g_desc);
        ps1.setString(10,childLink);
        ps1.setString(11,"taptap");
        ps1.setString(12,pr_uuid);
        ps1.setString(13,game_size);
        ps1.setString(14,web_update_time);
        ps1.addBatch();

        ps2.setString(1,develop_com);
        ps2.setString(2,"taptap");
        ps2.setString(3,childLink);
        ps2.setString(4,ouuid);
        ps2.addBatch();

        ps3.setString(1,develop_com);
        ps3.setString(2,pname);
        ps3.setString(3,"开发商");
        ps3.setString(4,ouuid);
        ps3.setString(5,pr_uuid);
        ps3.setString(6,"taptap");
        ps3.addBatch();

        if(a%10==0||b%1==0){
            ps1.executeBatch();
            ps2.executeBatch();
            ps3.executeBatch();
        }

    }
}

