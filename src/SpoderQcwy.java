import com.mysql.jdbc.PreparedStatement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/1/12.
 */
public class SpoderQcwy {
    public static void main(String args[]) throws InterruptedException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/data_Yfjl?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertBasPersonInfo="insert into bas_person_info(uuid,age,sex,marital_status,employment,diploma,work_years,p_desc,source,url) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(insertBasPersonInfo);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,industry,source,url,uuid) values(?,?,?,?,?)";
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(insertBasOrganizeInfo);

        String insertPerOrganize="insert into per_organize(oname,rtype,rgrade,job,puuid,ouuid,source) values(?,?,?,?,?,?,?)";
        PreparedStatement ps3 = (PreparedStatement) con.prepareStatement(insertPerOrganize);

        String insertPerEducationInfo="insert into per_education_info(school,major,diploma,start_date,end_date,uuid,`type`) values(?,?,?,?,?,?,?)";
        PreparedStatement ps4 = (PreparedStatement) con.prepareStatement(insertPerEducationInfo);

        String insertPerWorkInfo="insert into per_work_info(oname,job,work_time,income,w_desc,uuid) values(?,?,?,?,?,?)";
        PreparedStatement ps5 = (PreparedStatement) con.prepareStatement(insertPerWorkInfo);

        String insertPerSkillInfo="insert into per_skill_info(specialty,uuid) values(?,?)";
        PreparedStatement ps6 = (PreparedStatement) con.prepareStatement(insertPerSkillInfo);

        String insertPerDemandWork="insert into per_demand_work(dplace,jtype,dpay,industry,uuid) values(?,?,?,?,?)";
        PreparedStatement ps8 = (PreparedStatement) con.prepareStatement(insertPerDemandWork);

        String insertPerProject="insert into per_project_info(project_time,project,project_desc,develop_tool,software,role,uuid) values(?,?,?,?,?,?,?)";
        PreparedStatement ps9 = (PreparedStatement) con.prepareStatement(insertPerProject);


        String insertBugData="insert into bug_data(uuid,`exception`) values(?,?)";
        PreparedStatement ps10 = (PreparedStatement) con.prepareStatement(insertBugData);


        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String dl = null;
        driver.get("http://www.yifengjianli.com/base/signin");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("1289121695@qq.com");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.className("sign-btn")).click();
        Thread.sleep(5000);
        try {
            WebElement web = driver.findElement(By.className("sign-btn"));
            dl = web.getText();
        }catch (Exception e){
            dl = null;
        }
        while(dl!=null) {
            Thread.sleep(2000);
            driver.findElement(By.id("email")).clear();                                               //获取id值
            driver.findElement(By.id("email")).sendKeys("1289121695@qq.com");                      //写入用户名
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys("123456");
            Thread.sleep(2000);
            driver.findElement(By.className("sign-btn")).click();
            Thread.sleep(5000);
            try {
                WebElement web1 = driver.findElement(By.className("sign-btn"));
                dl = web1.getText();
            }catch(Exception e1){
                dl = null;
            }
        }
        /*Pd pd=new Pd();
        Thread.sleep(2000);
        driver.get("http://www.yifengjianli.com/userset/superPool51Job");
        Thread.sleep(2000);
        driver.findElement(By.className("yf-btn-blue2")).click();
        Thread.sleep(5000);
        for(int kflag=1;kflag<=20;kflag++){
            pd.panduan((Element) driver.findElement(By.className("am-pagination-last")));
            driver.findElement(By.className("am-pagination-last")).click();
            Thread.sleep(2000);
        }

        int accountflag=0;
        int dianji=30;
        String zhanghu[]=new String[]{""};
        String mima[]=new String[]{""};*/
        /*for(int i=21;i<=250;i++) {
            Thread.sleep(10000);
            WebElement webElement2 = driver.findElement(By.xpath("/html"));
            String aa2 = webElement2.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa2);
            Elements links = doc.select("td[style=max-width:260px;padding-left:28px!important;padding-right:25px;position:relative]>a[ng-style={'color': item.isRead=='1'||item.isDownLoad=='1'?'rgb(129, 42, 208)':''}]");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.open('" + "https://www.baidu.com/" + "')");
            Thread.sleep(2000);
            String handle=driver.getWindowHandle();
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handle)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }*/
           // for (Element link : links) {
        for(int i=1;i<30000;i++) {
            String uuidr = UUID.randomUUID().toString();
            try {
                String hun = null;
                String zhi = null;
                String childLink = "http://www.yifengjianli.com/jobResume/jobDetail?joburl=L0NhbmRpZGF0ZS9SZXN1bWVWaWV3LmFzcHg/aGlkVXNlcklEPTExMzUxMTM1NiZoaWRFdmVudHM9MjMmaGlkS2V5PWQ1NjZkOWU0ZGJjM2FlYmM2NWY4ZWE2OGIwMTI1NGUzJnY9MQ==&city=%u676D%u5DDE&keyword=%E6%B8%B8%E6%88%8F&resumeId=336107072&searchId=" + i;
                driver.get(childLink);
                Thread.sleep(10000);
                WebElement webElement5 = driver.findElement(By.xpath("/html"));
                String aa5 = webElement5.getAttribute("outerHTML");
                Document doc2 = Jsoup.parse(aa5);
                String sex = doc2.select("span[ng-bind=userInfo.resume.sex == 2? '女' : '男'].ng-binding").toString().replace("<span ng-bind=\"userInfo.resume.sex == 2? '女' : '男'\" class=\"ng-binding\">", "").replace("</span>", "");
                String hunyinzhuangk = doc2.select("span[ng-bind=!userInfo.resume.maritalStatus?'未填':userInfo.resume.maritalStatus == 1?'未婚': userInfo.resume.maritalStatus == 2? '已婚' : '离异']").toString().replace("<span ng-if=\"userInfo.resume.maritalStatus\" ng-bind=\"!userInfo.resume.maritalStatus?'未填':userInfo.resume.maritalStatus == 1?'未婚': userInfo.resume.maritalStatus == 2? '已婚' : '离异'\" class=\"ng-scope ng-binding\">", "").replace("</span>", "");
                if (hunyinzhuangk.equals("已婚")) {
                    hun = "1";
                } else if (hunyinzhuangk.equals("未婚")) {
                    hun = "0";
                } else if (hunyinzhuangk.equals("离异")) {
                    hun = "3";
                }
                String gongling = doc2.select("p>span[ng-bind-template]").get(0).attr("ng-bind-template").toString().replace("工作经验", "");
                String age = doc2.select("p>span[ng-bind-template]").get(1).attr("ng-bind-template").toString().split("岁", 2)[0];
                System.out.println(age);
                String xueli = doc2.select("p>span[ng-bind-template]").get(2).attr("ng-bind-template").toString().split("：", 2)[0];
                String qwgzxz = doc2.select("span[ng-bind=userInfo.resume.expectWorkType]").text();
                String qwgzcs = doc2.select("span[ng-bind=userInfo.resume.expectCity]").text();
                String qwyx = doc2.select("span[ng-bind=userInfo.resume.expectSalary]").text();
                String mqzk = doc2.select("span[ng-bind=userInfo.resume.jobState]").text();
                if (mqzk.contains("在职")) {
                    zhi = "1";
                } else if (mqzk.contains("离职")) {
                    zhi = "0";
                }
                String qwcszy = doc2.select("span[ng-bind=userInfo.resume.jobTitle]").text().split(" ", 2)[0];
                String zwpj = doc2.select("pre[ng-bind=userInfo.resume.selfEvaluate]").text();
                System.out.println(qwcszy);

                Elements links2 = doc2.select("div[ng-if=userInfo.resume.workList.length] ul.ng-scope");
                for (Element e : links2) {
                    String uuidgs = UUID.randomUUID().toString();
                    String gzsj = e.select("span").attr("ng-bind-template");
                    String oname = e.select("span[ng-bind=item.compName]").text();
                    String gshy = e.select("span[ng-if=item.compIndustry]").attr("ng-bind-template").replace("|", "");
                    String gszw = e.select("span[ng-bind=item.jobTitle]").text().replace("|", "");
                    String gssr = e.select("span[ng-if=item.salary]").attr("ng-bind-template").replace("|", "").replace("元", "").replace("月", "").replace("/", "");
                    String gzms = e.select("pre[ng-bind=item.workDesc]").text();

                    ps2.setString(1, oname);
                    ps2.setString(2, gshy);
                    ps2.setString(3, "亿封简历-前程无忧");
                    ps2.setString(4, childLink);
                    ps2.setString(5, uuidgs);
                    ps2.addBatch();

                    ps3.setString(1, oname);
                    ps3.setString(2, "任职公司");
                    ps3.setString(3, "9");
                    ps3.setString(4, gszw);
                    ps3.setString(5, uuidr);
                    ps3.setString(6, uuidgs);
                    ps3.setString(7, "亿封简历-前程无忧");
                    ps3.addBatch();

                    ps5.setString(1, oname);
                    ps5.setString(2, gszw);
                    ps5.setString(3, gzsj);
                    ps5.setString(4, gssr);
                    ps5.setString(5, gzms);
                    ps5.setString(6, uuidr);
                    ps5.addBatch();
                }

                Elements links3 = doc2.select("div[ng-if=userInfo.resume.projectList.length] ul.ng-scope");
                for (Element e1 : links3) {
                    String xmsj = e1.select("span").attr("ng-bind-template");
                    String xmmc = e1.select("span[ng-bind=item.projectName]").text();
                    String xmms = e1.select("pre[ng-bind=item.projectDesc]").text();
                    String kfgj = e1.select("span[ng-bind=item.hardware]").text();
                    String rjhj = e1.select("span[ng-bind=item.devTools]").text();
                    String zrms = e1.select("span[ng-bind=item.responsibilityDesc]").text();
                    System.out.println(xmsj);
                    System.out.println(kfgj);
                    System.out.println(zrms);

                    ps9.setString(1, xmsj);
                    ps9.setString(2, xmmc);
                    ps9.setString(3, xmms);
                    ps9.setString(4, kfgj);
                    ps9.setString(5, rjhj);
                    ps9.setString(6, zrms);
                    ps9.setString(7, uuidr);
                    ps9.addBatch();
                }

                Elements links4 = doc2.select("div[ng-if=userInfo.resume.eduList.length] ul.resuem-ul");
                for (Element e2 : links4) {
                    String jysj = e2.select("span").attr("ng-bind-template");
                    String start_date = jysj.split("—", 2)[0];
                    String end_date = jysj.split("—", 2)[1];
                    String xx = e2.select("span[ng-bind=item.schoolName]").text();
                    String zy = e2.select("span[ng-bind=item.specialty]").text();
                    System.out.println(zy);

                    ps4.setString(1, xx);
                    ps4.setString(2, zy);
                    ps4.setString(3, xueli);
                    ps4.setString(4, start_date);
                    ps4.setString(5, end_date);
                    ps4.setString(6, uuidr);
                    ps4.setString(7, "2");
                    ps4.addBatch();
                }

                Elements links7 = doc2.select("div[ng-if=userInfo.resume.skillsList.length] ul.ng-scope");
                for (Element e5 : links7) {
                    String jn = e5.select("span[ng-bind=item.skillName]").text();
                    String cd = e5.select("span[ng-bind=item.masterDegree]").text();
                    String zwjn = jn + "," + cd;

                    ps6.setString(1, zwjn);
                    ps6.setString(2, uuidr);
                    ps6.addBatch();
                }

                ps1.setString(1, uuidr);
                ps1.setString(2, age);
                ps1.setString(3, sex);
                ps1.setString(4, hun);
                ps1.setString(5, zhi);
                ps1.setString(6, xueli);
                ps1.setString(7, gongling);
                ps1.setString(8, zwpj);
                ps1.setString(9, "亿封简历-前程无忧");
                ps1.setString(10, childLink);
                ps1.addBatch();

                ps8.setString(1, qwgzcs);
                ps8.setString(2, qwgzxz);
                ps8.setString(3, qwyx);
                ps8.setString(4, qwcszy);
                ps8.setString(5, uuidr);
                ps8.addBatch();

                if (i % 25 == 0) {
                    ps1.executeBatch();
                    ps2.executeBatch();
                    ps3.executeBatch();
                    ps4.executeBatch();
                    ps5.executeBatch();
                    ps6.executeBatch();
                    ps8.executeBatch();
                    ps9.executeBatch();
                }
                System.out.println(i);
                System.out.println("-----------------------------------------");
            } catch (Exception e) {
                ps10.setString(1, uuidr);
                ps10.setString(2, e.getMessage());
                ps10.executeUpdate();
                System.out.println(i+"yc");
                System.out.println("-----------------------------------------");
            }
        }
          //}
            /*String handle2=driver.getWindowHandle();
            driver.close();
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handle2)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }
            driver.manage().deleteAllCookies();
            Thread.sleep(2000);
            if(i%10==0) {
                JavascriptExecutor executor2 = (JavascriptExecutor) driver;
                executor2.executeScript("$('span.yf-ml20').click()");
                Thread.sleep(5000);
                driver.get("http://www.yifengjianli.com/base/signin");
                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys(zhanghu[accountflag]);
                driver.findElement(By.id("pwd")).clear();
                driver.findElement(By.id("pwd")).sendKeys(mima[accountflag]);
                Thread.sleep(2000);
                driver.findElement(By.className("sign-btn")).click();
                Thread.sleep(5000);
                try {
                    WebElement web = driver.findElement(By.className("sign-btn"));
                    dl = web.getText();
                } catch (Exception e) {
                    dl = null;
                }
                while (dl != null) {
                    Thread.sleep(2000);
                    driver.findElement(By.id("email")).clear();
                    driver.findElement(By.id("email")).sendKeys(zhanghu[accountflag]);
                    driver.findElement(By.id("pwd")).clear();
                    driver.findElement(By.id("pwd")).sendKeys(mima[accountflag]);
                    Thread.sleep(2000);
                    driver.findElement(By.className("sign-btn")).click();
                    Thread.sleep(5000);
                    try {
                        WebElement web1 = driver.findElement(By.className("sign-btn"));
                        dl = web1.getText();
                    } catch (Exception e1) {
                        dl = null;
                    }
                }
                accountflag++;
                Thread.sleep(2000);
                driver.get("http://www.yifengjianli.com/userset/superPool51Job");
                Thread.sleep(5000);
                pd.panduan((Element) driver.findElement(By.className("yf-btn-blue2")));
                driver.findElement(By.className("yf-btn-blue2")).click();
                Thread.sleep(2000);
                for(int we=1;we<dianji;we++){
                    pd.panduan((Element) driver.findElement(By.className("am-pagination-last")));
                    driver.findElement(By.className("am-pagination-last")).click();
                    Thread.sleep(2000);
                }
                dianji=dianji+10;
            }
            if(i<251) {
                pd.panduan((Element) driver.findElement(By.className("am-pagination-last")));
                driver.findElement(By.className("am-pagination-last")).click();
            }
        }
        driver.close();*/
    }
}

