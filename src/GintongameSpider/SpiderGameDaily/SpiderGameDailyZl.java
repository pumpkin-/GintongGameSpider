package GintongameSpider.SpiderGameDaily;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import SpiderUtils.LevenshteinDis;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 游戏日报爬虫 增量
 * Created by 丁全彬  on 2017/2/15.
 */
public class SpiderGameDailyZl {


    //网页抓取到数据的集合  批量存入数据库
    private static List<ProKnowledge> proKnowledges = new ArrayList<ProKnowledge>();
    private static List<PerKnowledge> perKnowledges = new ArrayList<PerKnowledge>();
    private static List<BasPersonInfo> basPersoninfos = new ArrayList<BasPersonInfo>();

    public static void main(String args[]){

        try{
            Spiser();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void Spiser() throws InterruptedException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        //加载驱动，创建链接
        System.setProperty("phantomjs.binary.path", "C://Users//123//Desktop//aaa//phantomjs-2.1.1-windows//bin//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        List<String> listurl = new ArrayList<String>();
        listurl.add("http://news.yxrb.net/yejie/");
        listurl.add("http://news.yxrb.net/yejie/2.html");

        for (String listuri:listurl) {

            driver.get(listuri);
            //获取网页源代码
            WebElement web = driver.findElement(By.xpath("/html"));
            String html = web.getAttribute("outerHTML");
            //获取dom元素
            Document doc = Jsoup.parse(html);
            Elements linkstime = doc.select("div.avatar-des span.time");
            List<String> list = new ArrayList<String>();
            for (Element linktime : linkstime) {
                list.add(linktime.text());
            }
            Elements links = doc.select("div.news-thumb");


            for (Element link : links) {

                //访问链接
                String url = link.select("a").attr("href");

                driver.get(link.select("a").attr("href"));
                WebElement web1 = driver.findElement(By.xpath("/html"));
                String html1 = web1.getAttribute("outerHTML");
                Document doc1 = Jsoup.parse(html1);
                //列表封面
                String img = "<img>" + link.select(".thumb").attr("src") + "</img>";
                System.out.println(img);

                //获取标题
                String title = doc1.select("head title").text();
                System.out.println(title);
                //作者
                String name = doc1.select(".post-meta span").select(".name").text();
                name=name.replace("作者：","");
                System.out.println(name);
                //发布时间
                int flag = 0;
                String time = list.get(flag);
                flag++;
                //标签
                Elements tags = doc1.select(".post-bottom a");
                String label=",";
                for(Element  tag:tags){
                    label+=tag.text();
                }
                label=label.substring(1,label.length()).trim();
                System.out.println(label);
                //获取正文
                String main = null;
                Document texts1 = Jsoup.parse(doc1.select("div.post-con.mobantu").toString().replace("<br>", "nbsp#").replace("&nbsp;", ""));
                Elements links3 = texts1.select("span[style=font-family:微软雅黑;]");
                main = doc1.select("blockquote").text();
                for (Element text : links3) {
                    if (text.text() != null && text.text().length() > 0) {
                        if(StringUtils.isNotEmpty(text.text().replaceAll("nbsp#", "\r\n"))) {
                            main = main + "\r\n" + "<p>" + text.text().replaceAll("nbsp#", "\r\n")+"</p>";
                        }
                    }
                    if (!text.select("img").isEmpty()) {
                        main = main + "\r\n" + "<img src="+text.select("img").attr("src")+">";
                    }
                }

                try {
                    //将时间转换格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date time1 = sdf.parse(time+" 00:00:00");
                    String time2=sdf.format(time1);

                if(LevenshteinDis.isExist(main,time2)){
                    driver.quit();
                    System.exit(0);
                }

                //去重复数据
                 if (main != null && main.length() > 0 && !LevenshteinDis.isExist(main, time)) {
                    //知识表映射
                    ProKnowledge pk = new ProKnowledge();
                     String kuuid = UUID.randomUUID().toString();
                    pk.setUuid(kuuid);
                    pk.setUrl(url);
                    pk.setCover(img);
                    pk.setTitle(title);
                    pk.setAuthor(name);
                    pk.setPtime(time2);
                    pk.setTag(label);
                    pk.setMain(main);
                     pk.setSource("游戏日报");
                    proKnowledges.add(pk);
                    //关系表映射
                    PerKnowledge perk = new PerKnowledge();
                    String puuid = UUID.randomUUID().toString();
                    String rtype = "原作者";
                    perk.setKuuid(kuuid);
                    perk.setPuuid(puuid);
                    perk.setName(name);
                    perk.setKname(title);
                    perk.setSource(url);
                    perk.setRtype(rtype);
                     perk.setSource("游戏日报");
                    perKnowledges.add(perk);
                    //人表映射
                    BasPersonInfo bp = new BasPersonInfo();
                    bp.setUuid(puuid);
                    bp.setName(name);
                    bp.setSource("游戏日报");
                    bp.setUrl(url);
                    basPersoninfos.add(bp);
                }

                //存入数据库
                if ((proKnowledges.size() > 0 && proKnowledges.size() % 1 == 0)) {
                    ProKnowledgeImpl proknowimpl = new ProKnowledgeImpl();
                    proknowimpl.insertBatch(proKnowledges);
                    BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
                    basperimpl.insertBatch(basPersoninfos);
                    PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
                    perknowimpl.insertBatch(perKnowledges);
                    proKnowledges.clear();
                    perKnowledges.clear();
                    basPersoninfos.clear();
                }


                } catch (ParseException e) {
                    e.printStackTrace();

                }

            }


        }
        //关闭连接
        driver.quit();
        //退出程序
        System.exit(0);
    }


}
