import com.mysql.jdbc.ResultSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class text {
   /* public static void main(String args[]) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        String driver1 = "com.mysql.jdbc.Driver";   //链接驱动
        String url = "jdbc:mysql://123.59.74.132:3306/big_data?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";  //链接url
        String url1 = "jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";  //链接url
        String username = "gtcom";        //账户
        String password = "admin@gt.com1";        //密码}
        Class.forName(driver1).newInstance();       //链接
        Connection con = DriverManager.getConnection(url, username, password);
        Connection con1 = DriverManager.getConnection(url1, username, password);

        String insertBasOrganizeInfo="insert into bas_organize_info(oname,web,introduce,logo,source,url,uuid) values(?,?,?,?,?,?,?)";
        PreparedStatement ps1=con1.prepareStatement(insertBasOrganizeInfo);

        String insertProGameInfo="insert into pro_game_info(gname,g_desc,url,source,uuid) values(?,?,?,?,?)";
        PreparedStatement ps2=con1.prepareStatement(insertProGameInfo);

        String insertOrgProduct="insert into org_product(oname,pname,rtype,ouuid,pr_uuid,source) values(?,?,?,?,?,?)";
        PreparedStatement ps3=con1.prepareStatement(insertOrgProduct);

        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        int qa = 1;
        for(int i=1;i<=8;i++) {
            driver.get("http://www.manew.com/forum-94-"+i+".html");
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa);
            Elements links = doc.select("a[onclick=atarget(this)].xst");
            for (Element link : links) {
                String ouuid = UUID.randomUUID().toString();
                String childLink = link.attr("href");
                if (qa != 1) {
                    driver.get(childLink);
                    WebElement webElement5 = driver.findElement(By.xpath("/html"));
                    String aa5 = webElement5.getAttribute("outerHTML");
                    Document doc2 = Jsoup.parse(aa5);
                    String a = doc2.select("td.t_f").toString();


                    String oname = doc2.select("span[id=thread_subject]").text();
                    String logo = doc2.select("ignore_js_op img").attr("file");

                    Pattern pat1 = Pattern.compile("<br>.+?(?=<br>)");
                    Matcher mat1 = pat1.matcher(a);
                    String web = null;
                    while (mat1.find()) {
                        if (mat1.group(0).contains("<strong>") && mat1.group(0).contains("官网")) {
                            web = mat1.group(0).replaceAll("<br>.+</strong>", "");
                        }
                    }



                    if (a.contains("介绍")) {
                        if (a.contains("公司介绍")||a.contains("企业介绍")) {
                            int t = a.indexOf("介绍");
                            int y = a.lastIndexOf("介绍");
                            String b = a.substring(t, y);
                            Pattern pat = Pattern.compile("<br>.+?(?=<br>)");
                            Matcher mat = pat.matcher(b);
                            String pp = null;
                            while (mat.find()) {
                                if (mat.group(0).replace("<br>", "") != null && mat.group(0).replace("<br>", "").replaceAll("\\s", "").length() > 0) {
                                    pp = pp + "," + mat.group(0).replace("<br>", "").replaceAll("\\s", "");
                                }
                            }
                            if(pp!=null&&pp.length()>0) {
                                for (int p = 1; p < pp.split(",《").length; p++) {
                                    String pr_uuid = UUID.randomUUID().toString();
                                    String pname = pp.split(",《")[p].replace("&nbsp;", "").replace(",", "").split("》", 2)[0];
                                    String p_desc = pp.split(",《")[p].replace("&nbsp;", "").replace(",", "").split("》", 2)[1].replaceAll("[^\\u4e00-\\u9fa5]", "");

                                    ps2.setString(1, pname);
                                    ps2.setString(2, p_desc);
                                    ps2.setString(3, childLink);
                                    ps2.setString(4, "游戏蛮牛");
                                    ps2.setString(5, pr_uuid);
                                    ps2.addBatch();

                                    ps3.setString(1, oname);
                                    ps3.setString(2, pname);
                                    ps3.setString(3, "开发商");
                                    ps3.setString(4, ouuid);
                                    ps3.setString(5, pr_uuid);
                                    ps3.setString(6, "游戏蛮牛");
                                    ps3.addBatch();

                                }
                            }
                            String c = a.substring(y);
                            String qiyejieshao1 = c.replace("&nbsp;", "").replace("企业介绍：", "").replace("<br>", "").replace("</td>", "").replace("</strong>", "").replace("介绍：", "").replaceAll("[^\\u4e00-\\u9fa5]", "").replaceAll("\\s", "");

                            ps1.setString(1, oname);
                            ps1.setString(2, web);
                            ps1.setString(3, qiyejieshao1);
                            ps1.setString(4, logo);
                            ps1.setString(5, "游戏蛮牛");
                            ps1.setString(6, childLink);
                            ps1.setString(7, ouuid);
                            ps1.addBatch();
                        }else{
                            int t = a.indexOf("介绍");
                            String b = a.substring(t);
                            Pattern pat = Pattern.compile("<br>.+?(?=<br>)");
                            Matcher mat = pat.matcher(b);
                            String pp = null;
                            while (mat.find()) {
                                if (mat.group(0).replace("<br>", "") != null && mat.group(0).replace("<br>", "").replaceAll("\\s", "").length() > 0) {
                                    pp = pp + "," + mat.group(0).replace("<br>", "").replaceAll("\\s", "").replace("</strong>","");
                                }
                            }
                            for (int p = 1; p < pp.split(",《").length; p++) {
                                String pr_uuid = UUID.randomUUID().toString();
                                String pname = pp.split(",《")[p].replace("&nbsp;", "").replace(",", "").split("》", 2)[0];
                                String p_desc = pp.split(",《")[p].replace("&nbsp;", "").replace(",", "").split("》", 2)[1];

                                ps2.setString(1, pname);
                                ps2.setString(2, p_desc);
                                ps2.setString(3, childLink);
                                ps2.setString(4, "游戏蛮牛");
                                ps2.setString(5, pr_uuid);
                                ps2.addBatch();

                                ps3.setString(1, oname);
                                ps3.setString(2, pname);
                                ps3.setString(3, "开发商");
                                ps3.setString(4, ouuid);
                                ps3.setString(5, pr_uuid);
                                ps3.setString(6, "游戏蛮牛");
                                ps3.addBatch();

                            }
                        }
                    } else {
                        try {
                            String qiyejieshao2 = doc2.select("td.t_f").text().replace(Jsoup.parse("&nbsp;").text(), "").split("注册帐号 x", 2)[1].replaceAll("\\s", "").trim();

                        ps1.setString(1, oname);
                        ps1.setString(2, web);
                        ps1.setString(3, qiyejieshao2);
                        ps1.setString(4, logo);
                        ps1.setString(5, "游戏蛮牛");
                        ps1.setString(6, childLink);
                        ps1.setString(7, ouuid);
                        ps1.addBatch();
                        }catch (Exception e){
                            ps1.setString(1, oname);
                            ps1.setString(2, web);
                            ps1.setString(3, "null");
                            ps1.setString(4, logo);
                            ps1.setString(5, "游戏蛮牛");
                            ps1.setString(6, childLink);
                            ps1.setString(7, ouuid);
                            ps1.addBatch();
                        }
                    }
                }

                if(qa%10==0){
                    ps1.executeBatch();
                    ps2.executeBatch();
                    ps3.executeBatch();
                }
                System.out.println(qa+"+"+i);
                qa++;
                System.out.println("--------------------------");
                Thread.sleep(2000);
            }
        }













    }*/


    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor())
                //从https://github.com/code4craft开始抓
                .addUrl("")
                        //设置Scheduler，使用Redis来管理URL队列
               // .setScheduler(new RedisScheduler("localhost"))
                        //设置Pipeline，将结果以json方式保存到文件
                .addPipeline(new JsonFilePipeline("D:/data/webmagic"))
                        //开启5个线程同时执行
                .thread(5)
                        //启动爬虫
                .run();
    }
}