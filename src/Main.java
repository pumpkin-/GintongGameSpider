

import java.io.IOException;

import com.mysql.jdbc.PreparedStatement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main{
    public static void main(String args[]) throws Exception{
        try {
            System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe"); //设定本地的火狐软件
            WebDriver driver = new ChromeDriver();                                                 //调用火狐浏览器

            driver.get("http://www.syqnr.com/user/login");


            driver.findElement(By.id("email")).clear();                                               //获取id值
            driver.findElement(By.id("email")).sendKeys("wangfei847782566@163.com");                      //写入用户名
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("5459146");
            driver.findElement(By.id("dosubmit")).click();

            String driver1 = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100";
            String username = "gtcom";
            String password = "admin@gt.com1";
            Class.forName(driver1).newInstance();
            Connection con = DriverManager.getConnection(url, username, password);


            String insertBasPersonInfo = "insert into bas_person_info(uuid,name,source,url) values(?,?,?,?)";
            String updateBasPersonInfo = "update bas_person_info set con_way=? where uuid=?";
            String updateBasPersonInfo2 = "update bas_person_info set liveplace=? where uuid=?";

            String insertPerContractInfo = "insert into per_contract_info(uuid,`key`,`value`) values(?,?,?)";

            String insertPerWorkInfo = "insert into per_work_info(oname,wtype,uuid) values(?,?,?)";
            String updatePerWorkInfo = "update per_work_info set company_addr=? where uuid=?";
            String updatePerWorkInfo2 = "update per_work_info set w_desc=? where uuid=?";

            String insertPerOrganize = "insert into per_organize(name,rtype,rgrade,puuid,ouuid,oname) values(?,?,?,?,?,?)";
            String updatePerOrganize2 = "update per_organize set job=? where puuid=?";



            String insertOrgDemandMap = "insert into org_demand_map(uuid,demand_type,insert_time,demand_content) values(?,?,?,?)";

            String insertBasOrganizeInfo = "insert into bas_organize_info(oname,source,uuid,url) values(?,?,?,?)";
            String updateBasOrganizeInfo = "update bas_organize_info set shortname=? where uuid=?";
            String updateBasOrganizeInfo2 = "update bas_organize_info set introduce=? where uuid=?";
            String updateBasOrganizeInfo3 = "update bas_organize_info set address=? where uuid=?";


            PreparedStatement s11 = (PreparedStatement) con.prepareStatement(insertBasPersonInfo);
            PreparedStatement s12 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo);
            PreparedStatement s13 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo2);

            PreparedStatement s21 = (PreparedStatement) con.prepareStatement(insertPerContractInfo);

            PreparedStatement s31 = (PreparedStatement) con.prepareStatement(insertPerWorkInfo);
            PreparedStatement s32 = (PreparedStatement) con.prepareStatement(updatePerWorkInfo);
            PreparedStatement s33 = (PreparedStatement) con.prepareStatement(updatePerWorkInfo2);

            PreparedStatement s41 = (PreparedStatement) con.prepareStatement(insertPerOrganize);
            PreparedStatement s42 = (PreparedStatement) con.prepareStatement(updatePerOrganize2);


            PreparedStatement s61 = (PreparedStatement) con.prepareStatement(insertOrgDemandMap);

            PreparedStatement s71 = (PreparedStatement) con.prepareStatement(insertBasOrganizeInfo);
            PreparedStatement s72 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo);
            PreparedStatement s73 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo2);
            PreparedStatement s74 = (PreparedStatement) con.prepareStatement(updateBasOrganizeInfo3);


            for (int i = 424; i <= 2000; i++) {
                int a = 1;
                driver.get("http://www.syqnr.com/card/index/0-0/" + i);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc = Jsoup.parse(aa);
                Elements links = doc.select("a.pa10");
                for (Iterator<Element> element = links.iterator(); element.hasNext(); ) {
                    long msec = System.currentTimeMillis();
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.setTimeInMillis(msec);
                    String dateStr = dateformat.format(gc.getTime());
                    String uuid1 = UUID.randomUUID().toString();
                    String uuid2 = UUID.randomUUID().toString();

                    Element e = (Element) element.next();
                    String childLink = e.attr("href");
                    driver.get(childLink);
                    WebElement webElement2 = driver.findElement(By.xpath("/html"));
                    String bb = webElement2.getAttribute("outerHTML");
                    Document doc1 = Jsoup.parse(bb);
                    String name = doc1.select("div.info-rgt").select("h1").text();
                    String urlname = doc1.select("ul").select("a.down").attr("href");
                    String gongsilianjie = doc1.select("ul").select("span").select("a").attr("href");
                    s11.setString(1, uuid1);
                    s11.setString(2, name);
                    s11.setString(3, "游戏圈");
                    s11.setString(4, urlname);
                    s11.addBatch();
                    if (a % 10 == 0) {
                        s11.executeBatch();
                    }



                    Elements link1 = doc1.select("ul");
                    Pattern pat = Pattern.compile("<li> .+ </li>", Pattern.CASE_INSENSITIVE);
                    Matcher mat = pat.matcher(link1.outerHtml());
                    while (mat.find()) {
                        if (mat.group(0).contains("所在地：")) {
                            System.out.println(mat.group(0).replace("<li> <em>所在地：</em> <span>", "").replace("</span> </li>", ""));
                            s13.setString(1, mat.group(0).replace("<li> <em>所在地：</em> <span>", "").replace("</span> </li>", ""));
                            s13.setString(2, uuid1);
                            s13.addBatch();
                            if (a % 10 == 0) {
                                s13.executeBatch();
                            }
                        } else if (mat.group(0).contains("公司：")) {
                            s31.setString(1, mat.group(0).replace("<li> <em>公司：</em> <span>", "").replaceAll("<a.+?>", "").replace("</a></span> </li>", ""));
                            s31.setString(2, "工作");
                            s31.setString(3, uuid1);
                            s31.addBatch();
                            if (a % 10 == 0) {
                                s31.executeBatch();
                            }
                            s71.setString(1, mat.group(0).replace("<li> <em>公司：</em> <span>", "").replaceAll("<a.+?>", "").replace("</a></span> </li>", ""));
                            s71.setString(2, "游戏圈");
                            s71.setString(3, uuid2);
                            s71.setString(4, gongsilianjie);
                            s71.addBatch();
                            if (a % 10 == 0) {
                                s71.executeBatch();
                            }
                            s41.setString(1, name);
                            s41.setString(2, "任职公司");
                            s41.setString(3, "9");
                            s41.setString(4, uuid1);
                            s41.setString(5, uuid2);
                            s41.setString(6, mat.group(0).replace("<li> <em>公司：</em> <span>", "").replaceAll("<a.+?>", "").replace("</a></span> </li>", ""));
                            s41.addBatch();
                            if (a % 10 == 0) {
                                s41.executeBatch();
                            }
                            s72.setString(1, mat.group(0).replace("<li> <em>公司：</em> <span>", "").replaceAll("<a.+?>", "").replace("</a></span> </li>", ""));
                            s72.setString(2, uuid2);
                            s72.addBatch();
                            if (a % 10 == 0) {
                                s72.executeBatch();
                            }

                        } else if (mat.group(0).contains("职务：")) {
                            s42.setString(1, mat.group(0).replace("<li> <em>职务：</em> <span>", "").replace("</span> </li>", ""));
                            s42.setString(2, uuid1);
                            s42.addBatch();
                            if (a % 10 == 0) {
                                s42.executeBatch();
                            }
                        } else if (mat.group(0).contains("联系电话：")) {
                            System.out.println(mat.group(0).replace("<li> <em>联系电话：</em> <span>", "").replace("</span> </li>", ""));
                            String mobile = mat.group(0).replace("<li> <em>联系电话：</em> <span>", "").replace("</span> </li>", "");
                            s12.setString(1, mat.group(0).replace("<li> <em>联系电话：</em> <span>", "").replace("</span> </li>", ""));
                            s12.setString(2, uuid1);
                            s12.addBatch();
                            if (a % 10 == 0) {
                                s12.executeBatch();
                            }
                            s21.setString(1, uuid1);
                            s21.setString(2, "mobile");
                            s21.setString(3, mobile);
                            s21.addBatch();
                            if (a % 10 == 0) {
                                s21.executeBatch();
                            }
                        } else if (mat.group(0).contains("联系邮箱：")) {
                            s21.setString(1, uuid1);
                            s21.setString(2, "email");
                            s21.setString(3, mat.group(0).replace("<li> <em>联系邮箱：</em> <span>", "").replace("</span> </li>", ""));
                            s21.addBatch();
                            if (a % 10 == 0) {
                                s21.executeBatch();
                            }
                        } else if (mat.group(0).contains("QQ：")) {
                            s21.setString(1, uuid1);
                            s21.setString(2, "QQ");
                            s21.setString(3, mat.group(0).replace("<li> <em>QQ：</em> <span>", "").replace("</span> </li>", ""));
                            s21.addBatch();
                            if (a % 10 == 0) {
                                s21.executeBatch();
                            }
                        } else if (mat.group(0).contains("地址：")) {
                            s32.setString(1, mat.group(0).replace("<li> <em>地址：</em> <span>", "").replace("</span> </li>", ""));
                            s32.setString(2, uuid1);
                            s32.addBatch();
                            if (a % 10 == 0) {
                                s32.executeBatch();
                            }
                            s74.setString(1, mat.group(0).replace("<li> <em>地址：</em> <span>", "").replace("</span> </li>", ""));
                            s74.setString(2, uuid2);
                            s74.addBatch();
                            if (a % 10 == 0) {
                                s74.executeBatch();
                            }
                        } else if (mat.group(0).contains("专注于：")) {
                            s33.setString(1, mat.group(0).replace("<li> <em>专注于：</em> <span>", "").replace("</span> </li>", ""));
                            s33.setString(2, uuid1);
                            s33.addBatch();
                            if (a % 10 == 0) {
                                s33.executeBatch();
                            }
                            s73.setString(1, mat.group(0).replace("<li> <em>专注于：</em> <span>", "").replace("</span> </li>", ""));
                            s73.setString(2, uuid2);
                            s73.addBatch();
                            if (a % 10 == 0) {
                                s73.executeBatch();
                            }
                        } else if (mat.group(0).contains("我在找：")) {
                            String neirong=mat.group(0).replace("<li> <em>我在找：</em> <span>", "").replace("</span> </li>", "");
                            if(neirong!=null) {
                                s61.setString(1, uuid2);
                                s61.setString(2, "工作");
                                s61.setString(3, dateStr);
                                s61.setString(4, neirong);
                                s61.addBatch();
                                if (a % 10 == 0) {
                                    s61.executeBatch();
                                }
                            }
                        }
                    }
                    System.out.println(a + "+" + i);
                    a++;
                    System.out.println("------------------------------------------------------");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }





        //driver.close();
    }
}
