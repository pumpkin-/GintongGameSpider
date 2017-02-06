package pk;

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
import java.util.UUID;

/**
 * Created by 孙鸿宇 on 2017/1/22.
 */
public class SpiderMl {
    public static void main(String args[]) throws InterruptedException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String driver1="com.mysql.jdbc.Driver";   //链接驱动
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";  //链接url
        String username="gtcom";        //账户
        String password="admin@gt.com1";        //密码
        Class.forName(driver1).newInstance();       //链接
        Connection con = DriverManager.getConnection(url, username, password);      //获取一个链接

        //组织表插入并创建执行对象
        String insertBasOrganizeInfo="insert into bas_organize_info(oname,shortname,fullname,web,industry,scale,introduce,address,logo,source,url,uuid,financing_info,picture,financing_stage,company_nature,corporate_culture) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertBasOrganizeInfo);

        //人表插入并创建执行对象
        String insertBasPersonInfo="insert into bas_person_info(uuid,name,p_desc,source,url,live_photo) values(?,?,?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertBasPersonInfo);

        //产品表插入并创建执行对象
        String insertProOtherInfo="insert into pro_other_info(p_desc,picture_url,web,source,uuid,url) values(?,?,?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertProOtherInfo);

        //人与组织关系表插入并创建执行对象
        String insertPerOrganize="insert into per_organize(name,oname,rtype,rgrade,job,puuid,ouuid,source) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps4=con.prepareStatement(insertPerOrganize);


        int a=1;
        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");    //设置chrom浏览器路径
        WebDriver driver = new ChromeDriver();      //新建一个driver
        driver.get("http://www.molie.com/companyList.htm");     //连接到列表页
        for(int i=1;i<=21;i++) {
            Thread.sleep(2000);
            WebElement webElement2 = driver.findElement(By.xpath("/html"));
            String aa2 = webElement2.getAttribute("outerHTML");
            Document doc2 = Jsoup.parse(aa2);                       //获取到当前页面源代码并返回一个document
            Elements linksch = doc2.select("div.li-mid>h2>a");      //创建一个element对象
            JavascriptExecutor executor2 = (JavascriptExecutor) driver;     //获取选择器script框架
            executor2.executeScript("window.open('" + "https://www.baidu.com/" + "')");     //执行js语言，新开一个tab
            String handle = driver.getWindowHandle();           //获取当前页面句柄
            for (String handles : driver.getWindowHandles()) {      //循环判断，直至与当前页面句柄不同，并将driver转入
                if (handles.equals(handle)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }


            for (Element linkch : linksch) {                                        //循环访问子链接
                String ouuid= UUID.randomUUID().toString();
                String childLink="http://www.molie.com" + linkch.attr("href");
                driver.get(childLink);
                Thread.sleep(1000);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("$('.nav.nav-tabs a').eq(1).click()");
                Thread.sleep(2000);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                String aa = webElement.getAttribute("outerHTML");
                Document doc = Jsoup.parse(aa);
                String logo = doc.select("div.useravatar-b>img[id=logo_img]").attr("src");
                String shortname = doc.select("div.f24[id=companyBrandName]").text();
                String fullname = doc.select("p.mt10[id=companyName]").text();
                String scale = doc.select("div[id=companyScale]").text();
                String financing_stage = doc.select("div[id=developeStage]").text();
                String financing_info = doc.select("div[id=financingStage]").text();
                String company_nature = doc.select("div[id=companyNature]").text();
                String web = doc.select("div.mt15.f16>span.ico-s.ico-homepage.ml20>a").attr("href");
                String industry = doc.select("div.ico-s.ico-label.mt15>span.mr20").text();
                String address = doc.select("div.wordbreak>i.fcthree.word-break[id=companyAddress]").text();
                String introduce2 = doc.select("meta[name=description]").attr("content");
                String introduce1 = doc.select("div[id=companyJS]").text().replace(Jsoup.parse("&nbsp;").text(), "").trim();
                String introduce = introduce1.replace("公司简介","").replace("：","").trim() + "," + introduce2;

                Elements linksr = doc.select("div.showdata.comedit.text-p>ul.media-list.pdl80[id=foundTeamList]>li.media");
                for (Element linkr : linksr) {
                    String uuid=UUID.randomUUID().toString();
                    String live_photo = "http://www.molie.com" + linkr.select("div.pull-left.img80>img").attr("src");
                    String name = linkr.select("span").text();
                    String job = linkr.select("i.f16.fctwo.ml10").text();
                    String p_desc = linkr.select("div.f16>p").text();

                    if(name!=null&&name.length()>0) {
                        ps2.setString(1, uuid);
                        ps2.setString(2, name);
                        ps2.setString(3, p_desc);
                        ps2.setString(4, "魔猎");
                        ps2.setString(5, childLink);
                        ps2.setString(6, live_photo);
                        ps2.addBatch();

                        ps4.setString(1, name);
                        ps4.setString(2, shortname);
                        ps4.setString(3, "任职公司");
                        ps4.setString(4, "9");
                        ps4.setString(5, job);
                        ps4.setString(6, uuid);
                        ps4.setString(7, ouuid);
                        ps4.setString(8, "魔猎");
                        ps4.addBatch();
                    }

                }
                String corporate_culture = doc.select("div.wordbreak[id=companyWH]").text().trim();
                String picture1 = null;
                String picture=null;

                JavascriptExecutor executor1 = (JavascriptExecutor) driver;
                executor1.executeScript("$('.nav.nav-tabs a').eq(3).click()");
                Thread.sleep(2000);
                WebElement webElement1 = driver.findElement(By.xpath("/html"));
                String aa1 = webElement1.getAttribute("outerHTML");
                Document doc1 = Jsoup.parse(aa1);

                Elements linkst = doc1.select("div.showdata>ul.zplist.clearfix>li");
                for (Element linkt : linkst) {
                    picture1 = picture1 + "," + "http://www.molie.com" + linkt.select("img").attr("src");
                }
                try {
                    picture = picture1.replace("null,", "");
                }catch (Exception e1){
                    picture=null;
                }

                Elements linksc = doc1.select("div.carousel-inner[id=productList]>div.item");
                for (Element linkc : linksc) {
                    String pr_uuid=UUID.randomUUID().toString();
                    String picture_url = "http://www.molie.com" + linkc.select("div.slidemediaimg.pull-left>img").attr("src");
                    String p_desc = linkc.select("div.slidemediatext.f16.wordbreak>p:not(.text-right)").text();
                    String pr_web = linkc.select("div.slidemediatext.f16.wordbreak>p:has(a)>a").attr("href");

                    if(p_desc!=null&&p_desc.length()>0) {
                        ps3.setString(1, p_desc);
                        ps3.setString(2, picture_url);
                        ps3.setString(3, pr_web);
                        ps3.setString(4, "魔猎");
                        ps3.setString(5, pr_uuid);
                        ps3.setString(6, childLink);
                        ps3.addBatch();                 //提交队列
                    }

                }

                ps1.setString(1,shortname);
                ps1.setString(2,shortname);
                ps1.setString(3,fullname);
                ps1.setString(4,web);
                ps1.setString(5,industry);
                ps1.setString(6,scale);
                ps1.setString(7,introduce);
                ps1.setString(8,address);
                ps1.setString(9,logo);
                ps1.setString(10,"魔猎");
                ps1.setString(11,childLink);
                ps1.setString(12,ouuid);
                ps1.setString(13,financing_info);
                ps1.setString(14,picture);
                ps1.setString(15,financing_stage);
                ps1.setString(16,company_nature);
                ps1.setString(17,corporate_culture);
                ps1.addBatch();

                if(a%25==0){
                    ps1.executeBatch();                 //批量执行
                    ps2.executeBatch();
                    ps3.executeBatch();
                    ps4.executeBatch();
                }

                System.out.println(a+"+"+i);
                a++;
                System.out.println("----------------------------------");

            }
            String handlet = driver.getWindowHandle();
            driver.close();                                 //关闭当前driver
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handlet)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }
            Thread.sleep(2000);
            if(i<21) {
                driver.findElement(By.className("ico-next")).click();       //点击下一页
            }
        }





    }
}
