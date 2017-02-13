package GintongameSpider;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by lenovo on 2017/1/20.
 */
public class SpiderLg {
    public static void main(String args[]) throws InterruptedException, ParseException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,fullname,web,industry,scale,introduce,address,logo,source,url,uuid,financing_info,picture,development_history) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertBasOrganizeInfo);

        String insertBasPersonInfo="insert into bas_person_info(uuid,name,p_desc,source,url,live_photo) values(?,?,?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertBasPersonInfo);

        String insertPerOrganize="insert into per_organize(name,oname,rtype,rgrade,job,puuid,ouuid,source) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertPerOrganize);

        String insertProOtherInfo="insert into pro_other_info(pname,ptype,p_desc,picture_url,source,uuid,url) values(?,?,?,?,?,?,?)";
        PreparedStatement ps4=con.prepareStatement(insertProOtherInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps5=con.prepareStatement(insertOrgProduct);





        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lagou.com/gongsi/0-0-31");
        int ar=1;
        for(int i=1;i<=20;i++) {
            Thread.sleep(5000);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa);
            Elements links = doc.select("dt.fl>a");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.open('" + "https://www.baidu.com/" + "')");
            String handle=driver.getWindowHandle();
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handle)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }
            for (Element link : links) {
                String uuidgs=UUID.randomUUID().toString();
                String childLink = "https:" + link.attr("href");
                driver.get(childLink);
                WebElement webElement1 = driver.findElement(By.xpath("/html"));
                String aa1 = webElement1.getAttribute("outerHTML");
                Document doc1 = Jsoup.parse(aa1);
                String logo = "https:" + doc1.select("div.top_info_wrap>img").attr("src");
                System.out.println(doc1.outerHtml());
                String guanwang = doc1.select("div.company_main>h1>a").attr("href");
                String quancheng = doc1.select("div.company_main>h1>a").attr("title");
                String jiancheng = doc1.select("div.company_main>h1>a").text();
                String gongsihangye = doc1.select("div.item_content>ul>li:has(i.type)>span").text();
                String rongzi = doc1.select("div.item_content>ul>li:has(i.process)>span").text();
                String guimo = doc1.select("div.item_content>ul>li:has(i.number)>span").text();
                String didian = doc1.select("div.item_content>ul>li:has(i.address)>span").text();

                Elements linksr=doc1.select("div.company_mangers_item>div.managelist_wrap>ul.manager_list>li.item_has.rotate_item");
                for(Element linkr:linksr){
                    String uuidr= UUID.randomUUID().toString();
                    String touxiang = "https:" + linkr.select("img").attr("src");
                    String name = linkr.select("span").text();
                    String zhiwu = linkr.select("p.item_manager_title").text();
                    String jianjie = linkr.select("div.mCSB_container.mCS_no_scrollbar").text();
                    ps2.setString(1,uuidr);
                    ps2.setString(2,name);
                    ps2.setString(3,jianjie);
                    ps2.setString(4,"拉勾");
                    ps2.setString(5,childLink);
                    ps2.setString(6,touxiang);
                    ps2.addBatch();

                    ps3.setString(1,name);
                    ps3.setString(2,jiancheng);
                    ps3.setString(3,"任职公司");
                    ps3.setString(4,"9");
                    ps3.setString(5,zhiwu);
                    ps3.setString(6,uuidr);
                    ps3.setString(7,uuidgs);
                    ps3.setString(8,"拉勾");
                    ps3.addBatch();
                }
                String gongsijianjie = doc1.select("div.item_content>div.company_intro_text>span.company_content").text().replace(Jsoup.parse("&nbsp;").text(), "").trim();
                String gongsitupian = null;
                String gongsitupian1 = null;
                String lishi = null;
                try {
                    for (int t = 0; t < doc1.select("div.item_content div.rotateImages_wrap>ul.company_img img").size(); t++) {
                        gongsitupian1 = gongsitupian1 + "," + doc1.select("div.item_content div.rotateImages_wrap>ul.company_img img").get(t).attr("src");
                    }
                    gongsitupian = gongsitupian1.replace("null,", "");
                } catch (Exception e1) {
                    gongsitupian = null;
                }
                if (doc1.select("ul.history_ul>li.history_li.clearfix") != null) {
                    for (int l = 0; l < doc1.select("ul.history_ul>li.history_li.clearfix").size(); l++) {
                        String shijian = null;
                        String riqi = null;
                        String shijianneirong = null;
                        String tian = null;
                        String yue = null;
                        String nian = null;
                        try {
                            tian = doc1.select("ul.history_ul>li.history_li.clearfix").get(l).select("div.li_date>p.date_day").text();
                            yue = doc1.select("ul.history_ul>li.history_li.clearfix").get(l).select("div.li_date>p.date_year").text().split(" ", 2)[1].substring(0, 3);
                            nian = doc1.select("ul.history_ul>li.history_li.clearfix").get(l).select("div.li_date>p.date_year").text().split(" ", 2)[0];
                            String riqiy = (nian + "-" + yue + "-" + tian);
                            Long tt = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH).parse(riqiy).getTime();
                            DateFormat df1 = new SimpleDateFormat("yyyy-MaiMaiDataParser-dd");
                            riqi = df1.format(new Date(tt));
                        } catch (Exception e2) {
                            riqi = null;
                        }
                        System.out.println(riqi);
                        try {
                            shijian = doc1.select("ul.history_ul>li.history_li.clearfix").get(l).select("p.desc_title.desc_hover.clearfix a").text();
                        } catch (Exception e3) {
                            shijian = null;
                        }
                        try {
                            shijianneirong = doc1.select("ul.history_ul>li.history_li.clearfix").get(l).select("div.desc_intro").text();
                        } catch (Exception e4) {
                            shijianneirong = null;
                        }
                        if (riqi!=null || shijian!=null || shijianneirong!=null) {
                            lishi = riqi + "&nbsp;" + shijian + "&nbsp;" + shijianneirong;
                        } else {
                            lishi = null;
                        }
                    }
                }

                try {
                    for (int a = 0; a < doc1.select("div.item_container div.product_content.product_item.clearfix").size(); a++) {
                        String uuidcp=UUID.randomUUID().toString();
                        String chanpintupian = "https:" + doc1.select("div.item_container div.product_content.product_item.clearfix").get(a).select("img").attr("src");
                        String chanpinming = doc1.select("div.item_container div.product_content.product_item.clearfix").get(a).select("a").text();
                        String chanpinbiaoqian = doc1.select("div.item_container div.product_content.product_item.clearfix").get(a).select("li").text();
                        String chanpinjianjie = doc1.select("div.item_container div.product_content.product_item.clearfix").get(a).select("div.mCSB_container").text();

                        ps4.setString(1,chanpinming);
                        ps4.setString(2,chanpinbiaoqian);
                        ps4.setString(3,chanpinjianjie);
                        ps4.setString(4,chanpintupian);
                        ps4.setString(5,"拉勾");
                        ps4.setString(6,uuidcp);
                        ps4.setString(7,childLink);
                        ps4.addBatch();

                        ps5.setString(1,jiancheng);
                        ps5.setString(2,jiancheng);
                        ps5.setString(3,"开发商");
                        ps5.setString(4,uuidgs);
                        ps5.setString(5,uuidcp);
                        ps5.setString(6,"拉勾");
                        ps5.addBatch();


                    }
                } catch (Exception e3) {
                    System.out.println("没有产品");
                }

                ps1.setString(1,jiancheng);
                ps1.setString(2,quancheng);
                ps1.setString(3,guanwang);
                ps1.setString(4,gongsihangye);
                ps1.setString(5,guimo);
                ps1.setString(6,gongsijianjie);
                ps1.setString(7,didian);
                ps1.setString(8,logo);
                ps1.setString(9,"拉勾");
                ps1.setString(10,childLink);
                ps1.setString(11,uuidgs);
                ps1.setString(12,rongzi);
                ps1.setString(13,gongsitupian);
                ps1.setString(14,lishi);
                ps1.addBatch();


                if(ar%25==0){
                    ps1.executeBatch();
                    ps2.executeBatch();
                    ps3.executeBatch();
                    ps4.executeBatch();
                    ps5.executeBatch();
                }

                System.out.println(ar+"+"+i);
                ar++;
                System.out.println("----------------------------------------");


            }
            String handlet = driver.getWindowHandle();
            driver.close();
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handlet)) {
                    continue;
                }
                driver.switchTo().window(handles);
            }
            Thread.sleep(2000);
            if(i<20) {
                driver.findElement(By.className("pager_next")).click();
            }
        }








    }
}
