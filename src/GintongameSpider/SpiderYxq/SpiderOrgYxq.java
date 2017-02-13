package GintongameSpider.SpiderYxq;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 孙鸿宇 on 2017/1/9.
 */
public class SpiderOrgYxq {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String select="select * from bas_organize_info where source='游戏圈'";
        PreparedStatement ps= (PreparedStatement) con.prepareStatement(select);


        String select2="select * from org_product";
        PreparedStatement pss= (PreparedStatement) con.prepareStatement(select2);




        String insertBasOrganizeInfo="insert into bas_organize_info(oname,introduce,source,uuid,url) values(?,?,?,?,?)";
        String updateBasOrganizeInfo="update bas_organize_info set con_way=? where uuid=?";
        String updateBasOrganizeInfo2="update bas_organize_info set industry=? where uuid=?";
        String updateBasOrganizeInfo3="update bas_organize_info set scale=? where uuid=?";
        String updateBasOrganizeInfo4="update bas_organize_info set address=? where uuid=?";
        String updateBasOrganizeInfo5="update bas_organize_info set stime=? where uuid=?";

        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(insertBasOrganizeInfo);
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo);
        PreparedStatement ps3 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo2);
        PreparedStatement ps4 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo3);
        PreparedStatement ps5 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo4);
        PreparedStatement ps6 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo5);


        String insertProOtherInfo="insert into pro_other_info(pname,ptype,source,uuid,url,web) values(?,?,?,?,?,?)";
        PreparedStatement ps7 = (PreparedStatement) con.prepareStatement(insertProOtherInfo);


        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid) values(?,?,?,?,?)";
        PreparedStatement ps8 = (PreparedStatement) con.prepareStatement(insertOrgProduct);



        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe"); //设定本地的火狐软件
        WebDriver driver = new ChromeDriver();                                                 //调用火狐浏览器

        driver.get("http://www.syqnr.com/user/login");


        driver.findElement(By.id("email")).clear();                                               //获取id值
        driver.findElement(By.id("email")).sendKeys("wangfei847782566@163.com");                      //写入用户名
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("5459146");
        driver.findElement(By.id("dosubmit")).click();



        int a=1;
        for(int i=500;i<=800;i++) {
            driver.get("http://www.syqnr.com/company/index/0-0-0/"+i);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa);
            Elements links=doc.select("h3").select("a.name");
            for(Iterator<Element> element=links.iterator();element.hasNext();) {
                try{
                    ResultSet rs = ps.executeQuery();
                    ResultSet rss = pss.executeQuery();
                    int pu = 0;
                    int po = 0;
                    String uuidjiu = null;
                    String chanpinlianjie = null;
                    String chanpinming = null;
                    String chanpinleixing = null;
                    String uuid = UUID.randomUUID().toString();
                    Element e = element.next();
                    String childLink = e.attr("href");
                    driver.get(childLink);
                    WebElement webElement1 = driver.findElement(By.xpath("/html"));
                    String bb = webElement1.getAttribute("outerHTML");
                    Document doc1 = Jsoup.parse(bb);
                    String xinxi = doc1.select("li").outerHtml();
                    String gongsiming = doc1.select("div.info-rgt").select("h1").toString().replace("<h1>", "").replace("</h1>", "").replaceAll("<a.+</a>", "");                       //公司名
                    String gongsijianjie = doc1.select("div.pdesc").toString().replace("<div class=\"pdesc\">", "").replace("</div>", "").trim();        //公司简介
                    Elements linkk = doc1.select("dd");
                    for (int x = 0; x < linkk.size(); x++) {
                        Pattern patz = Pattern.compile("http.+/product/view.+\\d\"", Pattern.CASE_INSENSITIVE);
                        Matcher matz = patz.matcher(linkk.get(x).toString());
                        if (matz.find()) {
                            chanpinlianjie = matz.group(0).replace("\"", "");
                            System.out.println(chanpinlianjie);
                        }
                        Pattern pata = Pattern.compile("<h4>.+</h4>", Pattern.CASE_INSENSITIVE);
                        Matcher mata = pata.matcher(linkk.get(x).toString().trim());
                        Pattern patb = Pattern.compile("类型：.+", Pattern.CASE_INSENSITIVE);
                        Matcher matb = patb.matcher(linkk.get(x).toString());
                        if (matb.find()) {
                            chanpinleixing = matb.group(0).replace("类型：", "").trim();
                            System.out.println(chanpinleixing);
                        }
                        if (mata.find()) {
                            String uuidchan = UUID.randomUUID().toString();
                            chanpinming = mata.group(0).replace("<h4>", "").replace("</h4>", "").trim();
                            System.out.println(chanpinming);
                            ps7.setString(1, chanpinming);
                            ps7.setString(2, chanpinleixing);
                            ps7.setString(3, "游戏圈");
                            ps7.setString(4, uuidchan);
                            ps7.setString(5, childLink);
                            ps7.setString(6, chanpinlianjie);
                            ps7.addBatch();
                            while (rss.next()) {
                                String gsj = rss.getString(rss.findColumn("oname"));
                                String cpj = rss.getString(rss.findColumn("pname"));
                                if (gsj.equals(gongsiming) && cpj.equals(chanpinming)) {
                                    po = 1;
                                }
                            }
                            if (po == 0) {
                                ps8.setString(1, gongsiming);
                                ps8.setString(2, chanpinming);
                                ps8.setString(3, "游戏平台运营");
                                ps8.setString(4, uuid);
                                ps8.setString(5, uuidchan);
                                ps8.addBatch();
                            }
                        }
                    }
                    Pattern pat = Pattern.compile("<li.*em.+</li>", Pattern.CASE_INSENSITIVE);
                    Matcher mat = pat.matcher(xinxi);
                    while (rs.next()) {
                        String gs = rs.getString(rs.findColumn("oname"));
                        if (gs.equals(gongsiming)) {
                            pu = 1;
                            uuidjiu = rs.getString(rs.findColumn("uuid"));
                            // System.out.println(pu);
                        }
                    }
                    System.out.println(pu);
                    if (pu == 0) {
                        ps1.setString(1, gongsiming);
                        ps1.setString(2, gongsijianjie);
                        ps1.setString(3, "游戏圈");
                        ps1.setString(4, uuid);
                        ps1.setString(5, childLink);
                        ps1.addBatch();

                        while (mat.find()) {
                            if (mat.group(0).contains("商务电话：")) {
                                String dianhua = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("商务电话：", "").trim();
                                ps2.setString(1, dianhua);
                                ps2.setString(2, uuid);
                                ps2.addBatch();

                            } else if (mat.group(0).contains("类型：")) {
                                String leixing = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("类型：", "").trim();
                                ps3.setString(1, leixing);
                                ps3.setString(2, uuid);
                                ps3.addBatch();

                            } else if (mat.group(0).contains("规模：")) {
                                String guimo = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("规模：", "").trim();
                                ps4.setString(1, guimo);
                                ps4.setString(2, uuid);
                                ps4.addBatch();

                            } else if (mat.group(0).contains("地点：")) {
                                String didian = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("地点：", "").trim();
                                ps5.setString(1, didian);
                                ps5.setString(2, uuid);
                                ps5.addBatch();

                            } else if (mat.group(0).contains("成立时间：")) {
                                String chenglishijian = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("成立时间：", "").replace("年", "").trim();
                                ps6.setString(1, chenglishijian);
                                ps6.setString(2, uuid);
                                ps6.addBatch();
                            }
                        }
                    } else if (pu == 1) {
                        while (mat.find()) {
                            if (mat.group(0).contains("商务电话：")) {
                                String dianhua = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("商务电话：", "").trim();
                                ps2.setString(1, dianhua);
                                ps2.setString(2, uuidjiu);
                                ps2.addBatch();

                            } else if (mat.group(0).contains("类型：")) {
                                String leixing = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("类型：", "").trim();
                                ps3.setString(1, leixing);
                                ps3.setString(2, uuidjiu);
                                ps3.addBatch();

                            } else if (mat.group(0).contains("规模：")) {
                                String guimo = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("规模：", "").trim();
                                ps4.setString(1, guimo);
                                ps4.setString(2, uuidjiu);
                                ps4.addBatch();

                            } else if (mat.group(0).contains("地点：")) {
                                String didian = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("地点：", "").trim();
                                ps5.setString(1, didian);
                                ps5.setString(2, uuidjiu);
                                ps5.addBatch();

                            } else if (mat.group(0).contains("成立时间：")) {
                                String chenglishijian = mat.group(0).replace("<li>", "").replace("<em>", "").replace("</em>", "").replace("<span>", "").replaceAll("<a.+?>", "").replace("</a>", "").replace("</span>", "").replace("</li>", "").replace("成立时间：", "").replace("年", "").trim();
                                ps6.setString(1, chenglishijian);
                                ps6.setString(2, uuidjiu);
                                ps6.addBatch();
                            }
                        }
                    }
                    if (a % 25 == 0) {
                        ps1.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps7.executeBatch();
                        System.out.println(chanpinming);
                    }
                    if (a % 25 == 0) {
                        ps8.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps2.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps3.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps4.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps5.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps6.executeBatch();
                    }
                    System.out.println(a + "+" + i);
                    a++;
                    System.out.println("------------------------------------------------------");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        driver.close();
    }
}
