package GintongameSpider.SpiderNgbjZl;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderContant;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.ProKnowledgeImpl;
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
 * Created by lenovo on 2017/2/11.
 */
public class SpiderNgbjZl {
    private static List<ProKnowledge> proKnowledges = new ArrayList<ProKnowledge>();
    private static List<PerKnowledge> perKnowledges = new ArrayList<PerKnowledge>();
    private static List<BasPersonInfo> basPersoninfos = new ArrayList<BasPersonInfo>();



    public static void main(String args[]) throws Exception {
        insertAdditionalData();
    }

    /**
     * 数据网页标签清洗
     * @param doc
     * @param childLink
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static List<String> dataClean(Document doc,String childLink,int b,int z) throws SQLException, IOException, ParseException {
        String kuuid = UUID.randomUUID().toString();
        String puuid = UUID.randomUUID().toString();
        Elements linkstp = doc.select("table.vwtb div");
        String main = null;
        String cover=null;
        String type = null;
        List<String> list=new ArrayList<String>();
        for (Element linktp : linkstp) {
            if (linktp.text() != null && linktp.text().length() > 0 && !linktp.text().contains("作者") && !linktp.text().contains("来源") && !linktp.text().contains("转载请") && !linktp.text().contains("微信号") && !linktp.text().contains("公众号")) {
                main = (main + "\n" + linktp.text()).replaceAll("null\n", "");
            }
            if (linktp.select("a").attr("href") != null && linktp.select("a").attr("href").length() > 0) {
                main = main + "\n" + ("<img src=\""+"http://www.niaogebiji.com/" + linktp.select("a").attr("href")+"\">");
            }
        }
        String title = doc.select("div.h.hm h1.ph").text();
        String author = doc.select("div.h.hm p.xg1 a[href=javascript:;]").text();
        if(z==0){
            type="APP运营";
        }else if(z==1){
            type="新媒体运营";
        }else if(z==2){
            type="手游运营";
        }else if(z==3){
            type="APP推广";
        }else if(z==4){
            type="渠道动态";
        }else if(z==5){
            type="手游推广";
        }else if(z==6){
            type="投融资";
        }else if(z==7){
            type="行业快讯";
        }else if(z==8){
            type="手游新闻";
        }
        if(doc.select("div[style=width:100%; text-align:center]>img").attr("src")!=null&&doc.select("div[style=width:100%; text-align:center]>img").attr("src").length()>0) {
            cover = "http://www.niaogebiji.com/" + doc.select("div[style=width:100%; text-align:center]>img").attr("src");
        }
        String ptime = doc.select("span[style=float: right]").text();

        if(b==1) {
            storeToDatebase(kuuid, puuid, author, title, cover, ptime, type, childLink, main);
        }
        list.add(main);
        list.add(ptime);
        list.add(kuuid);
        return list;
    }

    /**
     * 增量查询
     * @throws IOException
     * @throws SQLException
     * @throws ParseException
     */
    public static void insertAdditionalData() throws IOException, SQLException, ParseException {
        System.setProperty("phantomjs.binary.path", "/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        WebDriver driver=new PhantomJSDriver();
        int c=1;
        String link[]=new String[]{"http://www.niaogebiji.com/portal.php?mod=list&catid=82","http://www.niaogebiji.com/portal.php?mod=list&catid=83","http://www.niaogebiji.com/portal.php?mod=list&catid=87","http://www.niaogebiji.com/portal.php?mod=list&catid=38","http://www.niaogebiji.com/portal.php?mod=list&catid=80","http://www.niaogebiji.com/portal.php?mod=list&catid=86","http://www.niaogebiji.com/portal.php?mod=list&catid=74","http://www.niaogebiji.com/portal.php?mod=list&catid=76","http://www.niaogebiji.com/portal.php?mod=list&catid=85"};
        for(int z=0;z<link.length;z++){
            for(int i=1;i>0;i++){
                driver.get(link[z]+"&page="+i);
                WebElement webElement = driver.findElement(By.xpath("/html"));
                Document doc= Jsoup.parse(webElement.getAttribute("outerHTML"));
                Elements links=doc.select("dt.xs2 a.xi2");
                for(Element link1:links){
                    int b=0;
                    String childLink=link1.attr("href");
                    driver.get(childLink);
                    WebElement webElement1 = driver.findElement(By.xpath("/html"));
                    Document doc1=Jsoup.parse(webElement1.getAttribute("outerHTML"));
                    List<String> text=dataClean(doc1,childLink,b,z);
                    SimpleDateFormat time=new SimpleDateFormat("yyyy-M-dd HH:mm");
                    SimpleDateFormat time1=new SimpleDateFormat("yyyy-MM-dd");
                    Date date=time.parse(text.get(1));
                    String timeto=time1.format(date);
                    if(text.get(0)!=null&&text.get(0).length()> 0 &&!LevenshteinDis.isExist(text.get(0), timeto,childLink,text.get(2))) {
                        b=1;
                        dataClean(doc1, childLink, b,z);
                    }else{
                        System.exit(0);
                    }
                    System.out.println(c+"+"+i);
                    c++;
                    System.out.println("------------------------");
                }
                if(doc.select("a.nxt").isEmpty()){
                    break;
                }
            }
        }
        driver.quit();
        System.exit(0);
    }

    public static void storeToDatebase(String kuuid,String puuid,String author,String title,String cover,String ptime,String type,String url,String main) throws SQLException, IOException, ParseException {
        SimpleDateFormat time=new SimpleDateFormat("yyyy-M-dd HH:mm");
        SimpleDateFormat time1=new SimpleDateFormat("yyyy-MM-dd");
        Date date=time.parse(ptime);
        String timeto=time1.format(date);
        if(main!=null&&main.length()>0&&!LevenshteinDis.isExist(main,timeto,url,kuuid)){
            ProKnowledge proKnow=new ProKnowledge();
            proKnow.setUuid(kuuid);
            proKnow.setAuthor(author);
            proKnow.setTitle(title);
            proKnow.setCover(cover);
            proKnow.setMain(main);
            proKnow.setPtime(ptime);
            proKnow.setType(type);
            proKnow.setUrl(url);
            proKnow.setSource("鸟哥笔记");
            proKnowledges.add(proKnow);
            System.out.println("插入数据");
            System.out.println(url);


            PerKnowledge perKnow=new PerKnowledge();
            perKnow.setName(author);
            perKnow.setName(title);
            perKnow.setRtype("原作者");
            perKnow.setPuuid(puuid);
            perKnow.setKuuid(kuuid);
            perKnow.setSource("鸟哥笔记");
            perKnowledges.add(perKnow);


            BasPersonInfo basPerson=new BasPersonInfo();
            basPerson.setUuid(puuid);
            basPerson.setName(author);
            basPerson.setSource("鸟哥笔记");
            basPerson.setUrl(url);
            basPersoninfos.add(basPerson);
        }
        if((proKnowledges.size()>0&&proKnowledges.size()% SpiderContant.insertBatchContant==0)) {
            ProKnowledgeImpl proknowimpl=new ProKnowledgeImpl();
            proknowimpl.insertBatch(proKnowledges);
            BasPersonInfoImpl basperimpl=new BasPersonInfoImpl();
            basperimpl.insertBatch(basPersoninfos);
            PerKnowledgeImpl perknowimpl=new PerKnowledgeImpl();
            perknowimpl.insertBatch(perKnowledges);
            proKnowledges.clear();
            perKnowledges.clear();
            basPersoninfos.clear();
        }
    }
}
