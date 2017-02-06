package Soider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/1/17.
 */
public class Spider58 {
    public static void main(String args[]) throws InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertBasPersonInfo="insert into bas_person_info(uuid,name,age,sex,household_register,liveplace,diploma,work_years,ptag,p_desc,source,url) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertBasPersonInfo);

        String inertBasOrganizeInfo="insert into bas_organize_info(oname,source,url,uuid) values(?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(inertBasOrganizeInfo);

        String insertPerOrganize="insert into per_organize(name,oname,rtype,rgrade,job,puuid,ouuid,source) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertPerOrganize);

        String insertPerDemandWork="insert into per_demand_work(dplace,dpay,industry,uuid) values(?,?,?,?)";
        PreparedStatement ps4=con.prepareStatement(insertPerDemandWork);

        String insertPerWorkInfo="insert into per_work_info(oname,job,work_time,income,w_desc,uuid) values(?,?,?,?,?,?)";
        PreparedStatement ps5=con.prepareStatement(insertPerWorkInfo);

        String insertPerEducationInfo="insert into per_education_info(school,major,diploma,end_date,event,uuid,type) values(?,?,?,?,?,?,?)";
        PreparedStatement ps6=con.prepareStatement(insertPerEducationInfo);

        String insertPerProjectInfo="insert into per_project_info(name,project,project_desc,role,project_time,uuid) values(?,?,?,?,?,?)";
        PreparedStatement ps7=con.prepareStatement(insertPerProjectInfo);

        String insertPerSkillInfo="insert into per_skill_info(specialty,uuid) values(?,?)";
        PreparedStatement ps8=con.prepareStatement(insertPerSkillInfo);

        String insertProOtherInfo="insert into pro_other_info(ptype,picture_url,source,url,uuid) values(?,?,?,?,?)";
        PreparedStatement ps9=con.prepareStatement(insertProOtherInfo);

        String insertPerProduct="insert into per_product(name,rtype,puuid,pr_uuid,source) values(?,?,?,?,?)";
        PreparedStatement ps10=con.prepareStatement(insertPerProduct);




        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://passport.58.com/login/?path=http%3A//bj.58.com/%3Futm_source%3Dmarket%26spm%3Db-31580022738699-me-f-824.bdpz_biaoti&PGTID=0d100000-0000-106f-4105-021c5edaebf1&ClickID=1");
        driver.findElement(By.id("pwdLogin")).click();
        driver.findElement(By.id("usernameUser")).clear();
        driver.findElement(By.id("usernameUser")).sendKeys("15010455304");
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("document.getElementById('passwordUser').value='wf123456789'");
        Thread.sleep(2000);
        driver.findElement(By.id("btnSubmitUser")).click();
        Thread.sleep(2000);
        int a=1;
        for(int i=1;i<=100;i++) {
            driver.get("http://cq.58.com/searchjob/pn"+i+"/?complex=0&key=%E6%B8%B8%E6%88%8F&PGTID=0d302409-0002-5f07-9f8d-1abb8c372bbf&ClickID=1");
            WebElement webElement5 = driver.findElement(By.xpath("/html"));
            String aa5 = webElement5.getAttribute("outerHTML");
            Document doc2 = Jsoup.parse(aa5);
            Elements links = doc2.select("dt.w295>a");
            for (Element link : links) {
                String uuidr= UUID.randomUUID().toString();
                String childLink = "http:" + link.attr("href");
                driver.get(childLink);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc = Jsoup.parse(aa);
                String xueli;
                String worktime;
                String xianju;
                String ht;
                String qwhy;
                String qwdd;
                String qwxz;
                List<String> list = new ArrayList<String>();
                String name = doc.select("span.name").text();
                System.out.println(doc.select("span.sexAge").text());
                String sex = doc.select("span.sexAge").text().split("，", 2)[0].replace("（", "");
                String age = doc.select("span.sexAge").text().split("，", 2)[1].replace("）", "");
                try {
                    xueli = doc.select("div.expectTitle ul.expectDetail").get(0).select("li").get(0).text();
                } catch (Exception e1) {
                    xueli = null;
                }
                try {
                    worktime = doc.select("div.expectTitle ul.expectDetail").get(0).select("li").get(2).text().replace("工作经验","").replace("应届生","无");
                } catch (Exception e2) {
                    worktime = null;
                }
                try {
                    xianju = doc.select("div.expectTitle ul.expectDetail").get(0).select("li").get(4).text();
                } catch (Exception e3) {
                    xianju = null;
                }
                try {
                    ht = doc.select("div.expectTitle ul.expectDetail").get(0).select("li").get(6).text();
                } catch (Exception e4) {
                    ht = null;
                }
                try {
                    qwhy = doc.select("div.expectTitle ul.expectDetail").get(1).select("li").get(0).text().replace("求职","").trim();
                } catch (Exception e5) {
                    qwhy = null;
                }
                try {
                    qwdd = doc.select("div.expectTitle ul.expectDetail").get(1).select("li").get(2).text().replace("想在","").replace("工作","").trim();
                } catch (Exception e6) {
                    qwdd = null;
                }
                try {
                    qwxz = doc.select("div.expectTitle ul.expectDetail").get(1).select("li").get(4).text().replace("期望薪资","").trim();
                } catch (Exception e7) {
                    qwxz = null;
                }
                String ziwojieshao = doc.select("div.intrCon").text();
                String zxqk = doc.select("div.addcont.addatsch>div.infoview").text();
                for (int q = 0; q < doc.select("span.fl").size(); q++) {
                    list.add(doc.select("span.fl").get(q).text());
                }
                String biaoqian = list.toString().replace("[", "").replace("]", "");

                ps1.setString(1,uuidr);
                ps1.setString(2,name);
                ps1.setString(3,age);
                ps1.setString(4,sex);
                ps1.setString(5,ht);
                ps1.setString(6,xianju);
                ps1.setString(7,xueli);
                ps1.setString(8,worktime);
                ps1.setString(9,biaoqian);
                ps1.setString(10,ziwojieshao);
                ps1.setString(11,"58同城");
                ps1.setString(12,childLink);
                ps1.addBatch();

                ps4.setString(1,qwdd);
                ps4.setString(2,qwxz);
                ps4.setString(3,qwhy);
                ps4.setString(4,uuidr);
                ps4.addBatch();

                Elements links2 = doc.select("div.addcont.addexpe>div.infoview");
                for (Element link1 : links2) {
                    String uuidgs=UUID.randomUUID().toString();
                    String oname;
                    String gzsj;
                    String xzsp;
                    String zzzw;
                    String gzzz;
                    oname=link1.select("h4").text();
                    System.out.println(oname);
                    try {
                        gzsj = link1.select("span.std").get(0).text();
                    } catch (Exception e8) {
                        gzsj = null;
                    }
                    try {
                        xzsp = link1.select("span.std").get(1).text();
                    } catch (Exception e9) {
                        xzsp = null;
                    }
                    try {
                        zzzw = link1.select("span.std").get(2).text();
                    } catch (Exception e10) {
                        zzzw = null;
                    }
                    try {
                        gzzz = link1.select("span.std").get(3).text();
                    } catch (Exception e11) {
                        gzzz = null;
                    }

                    ps2.setString(1,oname);
                    ps2.setString(2,"58同城");
                    ps2.setString(3,childLink);
                    ps2.setString(4,uuidgs);
                    ps2.addBatch();

                    ps3.setString(1,name);
                    ps3.setString(2,oname);
                    ps3.setString(3,"任职公司");
                    ps3.setString(4,"9");
                    ps3.setString(5,zzzw);
                    ps3.setString(6,uuidr);
                    ps3.setString(7,uuidgs);
                    ps3.setString(8,"58同城");
                    ps3.addBatch();

                    ps5.setString(1,oname);
                    ps5.setString(2,zzzw);
                    ps5.setString(3,gzsj);
                    ps5.setString(4,xzsp);
                    ps5.setString(5,gzzz);
                    ps5.setString(6,uuidr);
                    ps5.addBatch();

                }
                Elements links3 = doc.select("div.addcont.addeduc ul.summ");
                for (Element link1 : links3) {
                    String end_date = null;
                    String school;
                    String major;
                    try {
                        end_date = link1.select("li").get(0).text();
                    }catch (Exception e20){
                        end_date=null;
                    }
                    try {
                        school = link1.select("li").get(1).text();
                    } catch (Exception e12) {
                        school = null;
                    }
                    try {
                        major = link1.select("li").get(2).text();
                    } catch (Exception e13) {
                        major = null;
                    }
                    System.out.println(school);
                    ps6.setString(1,school);
                    ps6.setString(2,major);
                    ps6.setString(3,xueli);
                    ps6.setString(4,end_date);
                    ps6.setString(5,zxqk);
                    ps6.setString(6,uuidr);
                    ps6.setString(7,"2");
                    ps6.addBatch();

                }
                Elements links4 = doc.select("div.addcont.addlan p");
                for (Element link1 : links4) {
                    String yynl = link1.text();
                    ps8.setString(1,yynl);
                    ps8.setString(2,uuidr);
                    ps8.addBatch();
                }

                Elements links5 = doc.select("div.addcont.addproj>div.infoview");
                for (Element link1 : links5) {
                    String xiangmum;
                    String xmsj;
                    String xmjj;
                    String ze;
                    xiangmum = link1.select("h4").text();
                    try {
                        xmsj = link1.select("span.std").get(0).text();
                    } catch (Exception e14) {
                        xmsj = null;
                    }
                    try {
                        xmjj = link1.select("span.std").get(1).text();
                    } catch (Exception e15) {
                        xmjj = null;
                    }
                    try {
                        ze = link1.select("span.std").get(2).text();
                    } catch (Exception e16) {
                        ze = null;
                    }

                    ps7.setString(1,name);
                    ps7.setString(2,xiangmum);
                    ps7.setString(3,xmjj);
                    ps7.setString(4,ze);
                    ps7.setString(5,xmsj);
                    ps7.setString(6,uuidr);
                    ps7.addBatch();

                }
                Elements links6 = doc.select("div.addcont.addAbility p");
                for (Element link1 : links6) {
                    String zyjn = link1.text();
                    ps8.setString(1,zyjn);
                    ps8.setString(2,uuidr);
                    ps8.addBatch();
                }

                Elements links7 = doc.select("div.addcont.addshowme li");
                for (Element link1 : links7) {
                    String uuidzp=UUID.randomUUID().toString();
                    String zplj = link1.select("img[src~=http.+jpg]").attr("src");
                    if(zplj!=null&&zplj.length()>0) {
                        ps9.setString(1, "图片作品");
                        ps9.setString(2, zplj);
                        ps9.setString(3, "58同城");
                        ps9.setString(4, childLink);
                        ps9.setString(5, uuidzp);
                        ps9.addBatch();

                        ps10.setString(1, name);
                        ps10.setString(2, "制作人");
                        ps10.setString(3, uuidr);
                        ps10.setString(4, uuidzp);
                        ps10.setString(5, "58同城");
                        ps10.addBatch();
                    }
                }

                if(a%25==0||a==28636){
                    ps1.executeBatch();
                    ps2.executeBatch();
                    ps3.executeBatch();
                    ps4.executeBatch();
                    ps5.executeBatch();
                    ps6.executeBatch();
                    ps7.executeBatch();
                    ps8.executeBatch();
                    ps9.executeBatch();
                    ps10.executeBatch();
                }
                Thread.sleep(2000);
                System.out.println(a+"+"+i);
                a++;
                System.out.println("-----------------------------------------------");
                if(a%50==0&&a%100!=0){
                    driver.manage().deleteAllCookies();
                    Thread.sleep(1000);
                    driver.get("https://passport.58.com/login/?path=http%3A//bj.58.com/%3Futm_source%3Dmarket%26spm%3Db-31580022738699-me-f-824.bdpz_biaoti&PGTID=0d100000-0000-106f-4105-021c5edaebf1&ClickID=1");
                    if(driver.findElement(By.id("pwdLogin")).isDisplayed()){
                        driver.findElement(By.id("pwdLogin")).click();
                    }
                    Thread.sleep(5000);
                    driver.findElement(By.id("usernameUser")).clear();
                    driver.findElement(By.id("usernameUser")).sendKeys("13717951934");
                    JavascriptExecutor executor3 = (JavascriptExecutor) driver;
                    executor3.executeScript("document.getElementById('passwordUser').value='123456shy'");
                    Thread.sleep(2000);
                    driver.findElement(By.id("btnSubmitUser")).click();
                    Thread.sleep(2000);
                }
                if(a%100==0){
                    driver.manage().deleteAllCookies();
                    Thread.sleep(1000);
                    driver.get("https://passport.58.com/login/?path=http%3A//bj.58.com/%3Futm_source%3Dmarket%26spm%3Db-31580022738699-me-f-824.bdpz_biaoti&PGTID=0d100000-0000-106f-4105-021c5edaebf1&ClickID=1");
                    if(driver.findElement(By.id("pwdLogin")).isDisplayed()){
                        driver.findElement(By.id("pwdLogin")).click();
                    }
                    Thread.sleep(5000);
                    driver.findElement(By.id("usernameUser")).clear();
                    driver.findElement(By.id("usernameUser")).sendKeys("15010455304");
                    JavascriptExecutor executor3 = (JavascriptExecutor) driver;
                    executor3.executeScript("document.getElementById('passwordUser').value='wf123456789'");
                    Thread.sleep(2000);
                    driver.findElement(By.id("btnSubmitUser")).click();
                    Thread.sleep(2000);
                }
            }
        }


    }
}
