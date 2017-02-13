package GintongameSpider.SpiderWdj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/11.
 */
public class SpiderWdjZl {
    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InterruptedException {
        String url = "/Spider/SpiderWdj/url";
        File file=new File("/Spider/SpiderWdj/url");
        Zl zl=new Zl();
        zl.zxzl(url);
    }
}
class Zl{
    public void zxzl(String url) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Document doc = Jsoup.connect("http://www.wandoujia.com/category/game").timeout(50000).get();
        Elements links=doc.select("ul.clearfix.tag-box>li>a");
        int c=1;
        for(Element link:links) {
            String childLink = link.attr("href");
            for (int i = 1; i <= 50; i++) {
                Document doc2 = Jsoup.connect(childLink + "_" + i).timeout(50000).get();
                Elements links2 = doc2.select("h2.app-title-h2>a");
                for (Element link2 : links2) {
                    String childLink2 = link2.attr("href");
                    File file=new File(url);
                    FileInputStream ff=new FileInputStream(file);
                    InputStreamReader rr=new InputStreamReader(ff);
                    BufferedReader buffer=new BufferedReader(rr);
                    StringBuffer sb=new StringBuffer();
                    String line=null;
                    boolean br=true;
                    while ((line=buffer.readLine())!=null) {
                        if(childLink2.equals(line)){
                            br=false;
                        }
                    }
                    if(br==true){
                        int a=1;
                        int b=1;
                        QxlZl qq=new QxlZl();
                        Document doc3 = Jsoup.connect(childLink2).timeout(50000).get();
                        qq.qx(doc3,childLink2,a,b);
                        FileOutputStream fileout=new FileOutputStream(url,true);
                        byte bt[] =(childLink2+"\r\n").getBytes();
                        fileout.write(bt,0,bt.length);
                        System.out.println(c);
                        c++;
                        System.out.println("---------------------------");
                    }
                }
                if(!doc2.select("a.page-item.next-page.next-disabled").isEmpty()){
                    break;
                }
            }
        }
        System.exit(0);
    }
}

class QxlZl {
    public void qx(Document doc3,String childLink,int a,int b) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String ouuid= UUID.randomUUID().toString();
        String pr_uuid=UUID.randomUUID().toString();
        String picture=null;
        String fenlei=null;
        String tag=null;
        String kaifas=null;
        String banben=null;
        String logo=doc3.select("div.app-icon>img").attr("src");
        String name=doc3.select("div.app-info>p.app-name>span.title").text();
        String jianjie1=doc3.select("div.app-info>p.tagline").text();
        String jianjie2=doc3.select("div.editorComment>div.con").text();
        Elements linksjt=doc3.select("div.overview>img");
        for(Element linkjt:linksjt){
            picture=(picture+","+linkjt.attr("src")).replace("null,","");
        }

        String jianjie3=doc3.select("div.desc-info>div.con").text();
        String jianjie=jianjie3+jianjie2+jianjie1;
        String daxiao=doc3.select("dl.infos-list dd:has(meta)").text();
        Elements linksfl=doc3.select("dl.infos-list dd.tag-box>a");
        for(Element linkfl:linksfl){
            fenlei=(fenlei+","+linkfl.text()).replace("null,","");
        }
        Elements linkstag=doc3.select("dl.infos-list dd div.tag-box");
        for(Element linktag:linkstag){
            tag=(tag+","+linktag.text()).replace("null,","");
        }
        String gxtime=doc3.select("dl.infos-list dd>time#baidu_time").text().replace("年","-").replace("月","-").replace("日","");
        try {
            kaifas = doc3.select("dl.infos-list dd").get(6).text();
        }catch (Exception e1){
            kaifas=null;
        }
        try {
            banben = doc3.select("dl.infos-list dd").get(4).text();
        }catch (Exception e2){
            banben=null;
        }
        String xzlink=doc3.select("div.qr-info>a").attr("href");

        MysqlZl mysqlZl =new MysqlZl();
        mysqlZl.Rk(name, logo, banben, tag, picture, fenlei, kaifas, jianjie, childLink, ouuid, daxiao, gxtime, xzlink, pr_uuid, a, b);
    }
}
class MysqlZl {
    public void Rk(String pr_name, String logo, String version, String gtags, String picture, String gtheme, String develop_com, String g_desc, String url, String ouuid, String game_size, String web_update_time, String download_link, String pr_uuid, int a, int b) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String driver1="com.mysql.jdbc.Driver";
        String url1="jdbc:mysql://10.10.128.206:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url1, username, password);

        String insertProGameInfo="insert into pro_game_info(gname,logo,version,gtags,picture,gtheme,develop_com,g_desc,url,source,uuid,game_size,web_update_time,download_link) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(insertProGameInfo);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertBasOrganizeInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertOrgProduct);

        ps.setString(1,pr_name);
        ps.setString(2,logo);
        ps.setString(3,version);
        ps.setString(4,gtags);
        ps.setString(5,picture);
        ps.setString(6,gtheme);
        ps.setString(7,develop_com);
        ps.setString(8,g_desc);
        ps.setString(9,url);
        ps.setString(10,"豌豆荚");
        ps.setString(11,pr_uuid);
        ps.setString(12,game_size);
        ps.setString(13,web_update_time);
        ps.setString(14,download_link);
        ps.addBatch();

        ps1.setString(1,develop_com);
        ps1.setString(2,"豌豆荚");
        ps1.setString(3,url);
        ps1.setString(4,ouuid);
        ps1.addBatch();

        ps2.setString(1,develop_com);
        ps2.setString(2,pr_name);
        ps2.setString(3,"开发商");
        ps2.setString(4,ouuid);
        ps2.setString(5,pr_uuid);
        ps2.setString(6,"豌豆荚");
        ps2.addBatch();

        if(a%10==0||b%1==0){
            ps.executeBatch();
            ps1.executeBatch();
            ps2.executeBatch();
        }
    }
}

