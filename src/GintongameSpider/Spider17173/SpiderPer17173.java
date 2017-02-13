package GintongameSpider.Spider17173;

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
import java.sql.SQLException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/1/9.
 */
public class SpiderPer17173 {
    public static void main(String args[]) throws InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertBasPersonInfo = "insert into bas_person_info(uuid,name,live_photo,source,url) values(?,?,?,?,?)";
        String updateBasPersonInfo = "update bas_person_info set sex=? where uuid=?";
        String updateBasPersonInfo2 = "update bas_person_info set birthday=? where uuid=?";
        String updateBasPersonInfo3 = "update bas_person_info set diploma=? where uuid=?";
        String updateBasPersonInfo4 = "update bas_person_info set work_years=? where uuid=?";
        String updateBasPersonInfo5 = "update bas_person_info set liveplace=? where uuid=?";
        String updateBasPersonInfo6 = "update bas_person_info set con_way=? where uuid=?";
        String updateBasPersonInfo7 = "update bas_person_info set p_desc=? where uuid=?";

        PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(insertBasPersonInfo);
        PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo);
        PreparedStatement ps3 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo2);
        PreparedStatement ps4 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo3);
        PreparedStatement ps5 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo4);
        PreparedStatement ps6 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo5);
        PreparedStatement ps7 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo6);
        PreparedStatement ps17 = (PreparedStatement) con.prepareStatement(updateBasPersonInfo7);


        String insertPerContractInfo = "insert into per_contract_info(uuid,`key`,`value`) values(?,?,?)";
        PreparedStatement ps8 = (PreparedStatement) con.prepareStatement(insertPerContractInfo);


        String insertPerDemandWork = "insert into per_demand_work(jtype,uuid) values(?,?)";
        String updatePerDemandWork = "update per_demand_work set dpay=? where uuid=?";
        String updatePerDemandWork2 = "update per_demand_work set djob=? where uuid=?";
        String updatePerDemandWork3 = "update per_demand_work set dplace=? where uuid=?";


        PreparedStatement ps9 = (PreparedStatement) con.prepareStatement(insertPerDemandWork);
        PreparedStatement ps10 = (PreparedStatement) con.prepareStatement(updatePerDemandWork);
        PreparedStatement ps11 = (PreparedStatement) con.prepareStatement(updatePerDemandWork2);
        PreparedStatement ps12 = (PreparedStatement) con.prepareStatement(updatePerDemandWork3);


        String insertPerEducationInfo = "insert into per_education_info(start_date,school,major,uuid,end_date) values(?,?,?,?,?)";
        PreparedStatement ps13 = (PreparedStatement) con.prepareStatement(insertPerEducationInfo);


        String insertPerWorkInfo = "insert into per_work_info(work_time,oname,job,w_desc,uuid) values(?,?,?,?,?)";
        PreparedStatement ps14 = (PreparedStatement) con.prepareStatement(insertPerWorkInfo);


        String insertPerSkillInfo = "insert into per_skill_info(specialty,uuid) values(?,?)";
        PreparedStatement ps15 = (PreparedStatement) con.prepareStatement(insertPerSkillInfo);


        String insertPerGameInfo = "insert into per_game_info(game_exp,uuid) values(?,?)";
        PreparedStatement ps16 = (PreparedStatement) con.prepareStatement(insertPerGameInfo);


        String insertProOtherInfo = "insert into pro_other_info(picture_url,url,uuid,pname,p_desc,source) values(?,?,?,?,?,?)";

        PreparedStatement ps18 = (PreparedStatement) con.prepareStatement(insertProOtherInfo);


        String insertBasOrganizeInfo = "insert into bas_organize_info(oname,uuid,source,url) values(?,?,?,?)";
        PreparedStatement ps21 = (PreparedStatement) con.prepareStatement(insertBasOrganizeInfo);


        String insertPerOrganize = "insert into per_organize(name,oname,rtype,rgrade,job,puuid,ouuid) values(?,?,?,?,?,?,?)";
        PreparedStatement ps22 = (PreparedStatement) con.prepareStatement(insertPerOrganize);


        String inertPerProduct = "insert into per_product(name,pname,rtype,puuid,pr_uuid) values(?,?,?,?,?)";
        PreparedStatement ps23 = (PreparedStatement) con.prepareStatement(inertPerProduct);


        System.setProperty("webdriver.chrome.driver", "E:/aaaa/chrom/chromedriver.exe"); //设定本地的火狐软件
        WebDriver driver = new ChromeDriver();                                                 //调用火狐浏览器

        driver.get("https://passport.17173.com/");


        driver.findElement(By.id("passport")).clear();                                               //获取id值
        driver.findElement(By.id("passport")).sendKeys("geek_sjn@163.com");                      //写入用户名
        driver.findElement(By.id("pw")).clear();
        driver.findElement(By.id("pw")).sendKeys("helloworld");
        driver.findElement(By.className("btn-submit")).click();
        Thread.sleep(2000);
        driver.get("http://job.17173.com/");
        Thread.sleep(2000);

        int a = 1;
        for (int i = 780; i <= 1635; i++) {
            driver.get("http://job.17173.com/mem/fresume_list.php?&page=" + i);
            Thread.sleep(2000);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            String aa = webElement.getAttribute("outerHTML");
            Document doc = Jsoup.parse(aa);
            String pp1 = doc.toString();
            String pp = doc.select("td").select("a").toString();
            Pattern pat = Pattern.compile(".+\"resume.+?\"", Pattern.CASE_INSENSITIVE);
            Matcher mat = pat.matcher(pp);
            while (mat.find()) {
                try{
                    String start_date = null;
                    String end_date = null;
                    String school = null;
                    String major = null;
                    String work_time = null;
                    String oname = null;
                    String job = null;
                    String rname = null;
                    String w_desc = null;
                    String pname = null;
                    String p_descc = null;
                    String zuolian = null;
                    String uuidr = UUID.randomUUID().toString();
                    String childLink = "http://job.17173.com/mem/" + mat.group(0).replace("<a href=\"", "").replace("\"", "");
                    driver.get(childLink);
                    WebElement webElement2 = driver.findElement(By.xpath("/html"));
                    String aa2 = webElement2.getAttribute("outerHTML");
                    Document doc2 = Jsoup.parse(aa2);
                    String str = doc2.select("tbody").toString();
                    Document ooo = Jsoup.parse(str);
                    Elements lll = ooo.select("tbody");
                    Elements touxiang1 = lll.get(4).select("td");
                    String touxiang = touxiang1.toString().replace("<td align=\"center\" bgcolor=\"#FFFFFF\"> <img src=\"", "").replace("\" width=\"150\"> </td>", "");
                    for (int y = 0; y <= 24; y++) {
                        Elements ee = lll.get(y).select("tr");
                        for (int ss = 0; ss < ee.size(); ss++) {
                            Elements rrr = ee.get(ss).select("td");
                            for (int rr = 0; rr < rrr.size(); rr++) {
                                if (y == 3 && rr == 1) {
                                    rname = rrr.get(rr).text();
                                    ps1.setString(1, uuidr);
                                    ps1.setString(2, rname);
                                    ps1.setString(3, touxiang);
                                    ps1.setString(4, "17173");
                                    ps1.setString(5, childLink);
                                    ps1.addBatch();
                                    if (a % 25 == 0) {
                                        ps1.executeBatch();
                                    }
                                } else if (y == 5 && rr == 1) {
                                    String xingbie = rrr.get(rr).text();
                                    ps2.setString(1, xingbie);
                                    ps2.setString(2, uuidr);
                                    ps2.addBatch();
                                    if (a % 25 == 0) {
                                        ps2.executeBatch();
                                    }
                                } else if (y == 6 && rr == 1) {
                                    String chusheng = rrr.get(rr).text();
                                    ps3.setString(1, chusheng);
                                    ps3.setString(2, uuidr);
                                    ps3.addBatch();
                                    if (a % 25 == 0) {
                                        ps3.executeBatch();
                                    }
                                } else if (y == 7 && rr == 1) {
                                    String xueli = rrr.get(rr).text();
                                    ps4.setString(1, xueli);
                                    ps4.setString(2, uuidr);
                                    ps4.addBatch();
                                    if (a % 25 == 0) {
                                        ps4.executeBatch();
                                    }
                                } else if (y == 8 && rr == 1) {
                                    String gongling = rrr.get(rr).text();
                                    ps5.setString(1, gongling);
                                    ps5.setString(2, uuidr);
                                    ps5.addBatch();
                                    if (a % 25 == 0) {
                                        ps5.executeBatch();
                                    }
                                } else if (y == 9 && rr == 1) {
                                    String dizhi = rrr.get(rr).text();
                                    ps6.setString(1, dizhi);
                                    ps6.setString(2, uuidr);
                                    ps6.addBatch();
                                    if (a % 25 == 0) {
                                        ps6.executeBatch();
                                    }
                                } else if (y == 10 && rr == 1) {
                                    String blog = rrr.get(rr).text();
                                    if (blog != null && blog.length() > 0) {
                                        ps8.setString(1, uuidr);
                                        ps8.setString(2, "blog");
                                        ps8.setString(3, blog);
                                        ps8.addBatch();
                                        if (a % 25 == 0) {
                                            ps8.executeBatch();
                                        }
                                    }
                                } else if (y == 11 && rr == 1) {
                                    String email = rrr.get(rr).text();
                                    if (email != null && email.length() > 0) {
                                        ps8.setString(1, uuidr);
                                        ps8.setString(2, "email");
                                        ps8.setString(3, email);
                                        ps8.addBatch();
                                        if (a % 25 == 0) {
                                            ps8.executeBatch();
                                        }
                                    }
                                } else if (y == 12 && rr == 1) {
                                    String qq = rrr.get(rr).text();
                                    if (qq != null && qq.length() > 0) {
                                        ps8.setString(1, uuidr);
                                        ps8.setString(2, "qq");
                                        ps8.setString(3, qq);
                                        ps8.addBatch();
                                        if (a % 25 == 0) {
                                            ps8.executeBatch();
                                        }
                                    }
                                } else if (y == 13 && rr == 1) {
                                    String dianhua = rrr.get(rr).text();
                                    ps7.setString(1, dianhua);
                                    ps7.setString(2, uuidr);
                                    ps7.addBatch();
                                    if (a % 25 == 0) {
                                        ps7.executeBatch();
                                    }
                                    ps8.setString(1, uuidr);
                                    ps8.setString(2, "mobile");
                                    ps8.setString(3, dianhua);
                                    ps8.addBatch();
                                    if (a % 25 == 0) {
                                        ps8.executeBatch();
                                    }
                                } else if (y == 14 && rr == 1) {
                                    String qiuzhileixing = rrr.get(rr).text();
                                    ps9.setString(1, qiuzhileixing);
                                    ps9.setString(2, uuidr);
                                    ps9.addBatch();
                                    if (a % 25 == 0) {
                                        ps9.executeBatch();
                                    }
                                } else if (y == 15 && rr == 1) {
                                    String qiwangxinzi = rrr.get(rr).text();
                                    ps10.setString(1, qiwangxinzi);
                                    ps10.setString(2, uuidr);
                                    ps10.addBatch();
                                    if (a % 25 == 0) {
                                        ps10.executeBatch();
                                    }
                                } else if (y == 16 && rr == 1) {
                                    String qiwangzhiwei = rrr.get(rr).text().replace("][", ",").replace("[", "").replace("]", "");
                                    ps11.setString(1, qiwangzhiwei);
                                    ps11.setString(2, uuidr);
                                    ps11.addBatch();
                                    if (a % 25 == 0) {
                                        ps11.executeBatch();
                                    }
                                } else if (y == 17 && rr == 1) {
                                    String qiwangdidian = rrr.get(rr).text().replace("][", ",").replace("[", "").replace("]", "");
                                    ps12.setString(1, qiwangdidian);
                                    ps12.setString(2, uuidr);
                                    ps12.addBatch();
                                    if (a % 25 == 0) {
                                        ps12.executeBatch();
                                    }
                                } else if (y == 20 && rr == 1) {
                                    String specialty1 = rrr.get(rr).text();
                                    if(specialty1!=null&&specialty1.length()>0) {
                                        ps15.setString(1, specialty1);
                                        ps15.setString(2, uuidr);
                                        ps15.addBatch();
                                        if (a % 25 == 0) {
                                            ps15.executeBatch();
                                        }
                                    }
                                } else if (y == 21 && rr == 1) {
                                    String specialty2 = rrr.get(rr).text();
                                    if(specialty2!=null&&specialty2.length()>0) {
                                        ps15.setString(1, specialty2);
                                        ps15.setString(2, uuidr);
                                        ps15.addBatch();
                                        if (a % 25 == 0) {
                                            ps15.executeBatch();
                                        }
                                    }
                                } else if (y == 22 && rr == 1) {
                                    String game_exp = rrr.get(rr).text();
                                    ps16.setString(1, game_exp);
                                    ps16.setString(2, uuidr);
                                    ps16.addBatch();
                                    if (a % 25 == 0) {
                                        ps16.executeBatch();
                                    }
                                } else if (y == 23 && rr == 1) {
                                    String p_desc = rrr.get(rr).text();
                                    ps17.setString(1, p_desc);
                                    ps17.setString(2, uuidr);
                                    ps17.addBatch();
                                    if (a % 25 == 0) {
                                        ps17.executeBatch();
                                    }
                                }
                            }
                        }
                    }


                    Elements eep3 = lll.get(24).select("tr");
                    String rro = eep3.select("td").toString();
                    Document qq = Jsoup.parse(rro);
                    Elements rrrr = qq.select("td");
                    for (int ui = 0; ui < rrrr.size(); ui++) {
                        Pattern pat6 = Pattern.compile("名.+?(?=<)", Pattern.CASE_INSENSITIVE);
                        Matcher mat6 = pat6.matcher(rrrr.get(ui).toString());

                        Pattern pat7 = Pattern.compile("简.+(?=<)", Pattern.CASE_INSENSITIVE);
                        Matcher mat7 = pat7.matcher(rrrr.get(ui).toString());
                        if (mat7.find()) {
                            p_descc = mat7.group(0).replace("简介： ", "").replace("简介：", "").replace("<br>", "");
                        }
                        Pattern patz = Pattern.compile("<a href=\"\\.\\..+?\"", Pattern.CASE_INSENSITIVE);
                        Matcher matz = patz.matcher(rrrr.get(ui).toString());
                        if (matz.find()) {
                            zuolian = "http://job.17173.com" + matz.group(0).replace("<a href=\"", "").replace("\"", "").replace("\\.\\.", "");
                        }
                        if (mat6.find()) {
                            String uuidz = UUID.randomUUID().toString();
                            pname = mat6.group(0).replace("名称：", "");
                            ps18.setString(1, zuolian);
                            ps18.setString(2, childLink);
                            ps18.setString(3, uuidz);
                            ps18.setString(4, pname);
                            ps18.setString(5, p_descc);
                            ps18.setString(6,"17173");
                            ps18.addBatch();

                            ps23.setString(1, rname);
                            ps23.setString(2, pname);
                            ps23.setString(3, "制作人");
                            ps23.setString(4, uuidr);
                            ps23.setString(5, uuidz);
                            ps23.addBatch();

                        }
                    }


                    Elements eep = lll.get(18).select("tr");
                    for (int ss = 1; ss < eep.size(); ss++) {
                        Elements rrr = eep.get(ss).select("td");
                        for (int rr = 0; rr < rrr.size(); rr++) {
                            if (rr == 0) {
                                start_date = rrr.get(rr).text().split("--",2)[0];
                                end_date = rrr.get(rr).text().split("--",2)[1];
                            } else if (rr == 1) {
                                school = rrr.get(rr).text();
                            } else if (rr == 2) {
                                major = rrr.get(rr).text();
                            }
                        }
                        if(school!=null&&school.length()>0) {
                            ps13.setString(1, start_date);
                            ps13.setString(2, school);
                            ps13.setString(3, major);
                            ps13.setString(4, uuidr);
                            ps13.setString(5,end_date);
                            ps13.addBatch();
                            if (a % 25 == 0) {
                                ps13.executeBatch();
                            }
                        }
                    }


                    Elements eep2 = lll.get(19).select("tr");
                    for (int ss = 1; ss < eep2.size(); ss++) {
                        Elements rrr = eep2.get(ss).select("td");
                        String uuidzz = UUID.randomUUID().toString();
                        for (int rr = 0; rr < rrr.size(); rr++) {
                            if (rr == 0) {
                                work_time = rrr.get(rr).text();
                            } else if (rr == 1) {
                                oname = rrr.get(rr).text();
                                if(oname!=null&&oname.length()>0) {
                                    ps21.setString(1, oname);
                                    ps21.setString(2, uuidzz);
                                    ps21.setString(3, "17173");
                                    ps21.setString(4, childLink);
                                    ps21.addBatch();
                                    if (a % 25 == 0) {
                                        ps21.executeBatch();
                                    }
                                }
                            } else if (rr == 2) {
                                job = rrr.get(rr).text();
                            } else if (rr == 3) {
                                w_desc = rrr.get(rr).text();
                            }
                        }
                        if(oname!=null&&oname.length()>0) {
                            ps14.setString(1, work_time);
                            ps14.setString(2, oname);
                            ps14.setString(3, job);
                            ps14.setString(4, w_desc);
                            ps14.setString(5, uuidr);
                            ps14.addBatch();
                            if (a % 25 == 0) {
                                ps14.executeBatch();
                            }
                            ps22.setString(1, rname);
                            ps22.setString(2, oname);
                            ps22.setString(3, "任职公司");
                            ps22.setString(4, "9");
                            ps22.setString(5, job);
                            ps22.setString(6, uuidr);
                            ps22.setString(7, uuidzz);
                            ps22.addBatch();
                            if (a % 25 == 0) {
                                ps22.executeBatch();
                            }
                        }
                    }
                    if (a % 25 == 0) {
                        ps18.executeBatch();
                    }
                    if (a % 25 == 0) {
                        ps23.executeBatch();
                    }
                    System.out.println(a + "+" + i);
                    a++;
                    System.out.println("------------------------------------------------------------");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
