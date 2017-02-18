package GintongameSpider.SpiderAmuseAmusement;

import JavaBean.BasPersonInfo;
import JavaBean.BasProGameInfo;
import dao.ProGameInfoDao;
import dao.impl.ProGameInfoDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 逗游
 * Created by 丁全彬 on 2017/2/17.
 */
public class SpiderAmuseAmusement {
    /*
    获取标签里的内容
     */
    public static String  label (Elements infodiv,int index) {
        Elements a = infodiv.get(index).select("a");
        String string = "";
        if (a != null) {
            for (Element elm : a) {
                if (elm.text() == null || elm.text() == "") {
                    break;
                } else {
                    string += elm.select("a").text().trim() + ",";
                }
            }
            if(string!=""){
                string = string.substring(0, string.length() - 1);
            }

        }
        return string;
    }

    /*
    获取网页的doc
     */
    public static Document document (WebDriver driver,String url){
        driver.get(url);
        WebElement web = driver.findElement(By.xpath("/html"));
        String html = web.getAttribute("outerHTML");
        Document doc = Jsoup.parse(html);
        return doc;
    }
    /*
    抓取详情页单个页面呢游戏数据
     */
    public static Map<String,String> gameData(Map <String,String>map, WebDriver driver,String url){
        driver.get(url);
        WebElement web = driver.findElement(By.xpath("/html"));
        String html = web.getAttribute("outerHTML");
        Document doc = Jsoup.parse(html);
        Elements div=doc.select("#game_info");
        //游戏的链接
        map.put("url", url);
        //游戏图片，
        String img="<img src="+div.select("img").attr("src")+">";
       // System.out.println("游戏图片："+img);
        map.put("img",img);
        // 游戏名称，
        String gamename = div.select("h1").text();
        map.put("gamename", gamename);
        //System.out.println("游戏名称："+ gamename);
        // 类型
        Elements infodiv = div.select(".info div");
        String type =  label(infodiv,0);
        map.put("type", type);
       // System.out.println("游戏类型："+ type);

        // 画面，
        String frame = label(infodiv,2);
        map.put("frame", frame);
        System.out.println("游戏画面："+ frame);
        // 厂商，
        String factory=label(infodiv,4);
        map.put("factory",factory);
        System.out.println("游戏厂商："+ factory);
        // 语言，
        String  language=label(infodiv,1);
        map.put("language",language);
        System.out.println("游戏语言："+ language);
        // 题材，
        String theme=label(infodiv,3);
        map.put("theme",theme);
        System.out.println("游戏题材："+ theme);
        // 上市，
        String listed=label(infodiv, 5);
        map.put("listed",listed);
        System.out.println("游戏上市："+ listed);
        // 标签
        String  tag=label(infodiv,6);
        map.put("listed",tag);
        System.out.println("游戏标签："+ tag);
        // 截图，
        Elements screenshotDiv=doc.select("#game_screenshot a").select("img");
        System.out.println("大小是：" + screenshotDiv.size());
        String screenshot="";
        int i=0;
        for(Element elm:screenshotDiv){
            if(i!=2){
                screenshot+="<img src=\""+elm.attr("src")+"\">"+"\r\n";
                i++;
                continue;
            }
            screenshot+="<img src=\""+elm.attr("ssrc")+"\">"+"\r\n";

        }
        map.put("screenshot",screenshot);
        System.out.println("游戏截图：" + screenshot);
        // 简介，
        String synopsis="";
        Elements synopsisP=doc.select("#game_introduction").select(".content p");
        for(Element p:synopsisP ){

            if(p.text()!=null|| p.text()!=""){
                synopsis+="<p>"+p.text()+"</p>"+"\r\n";
            }

        }
        map.put("synopsis",synopsis);
        System.out.println("简介："+synopsis);
        return map;
    }

    public static void main(String args[]) {
        //单机游戏抓取
         gameinFormation("http://www.doyo.cn/danji/list",557);



    }
    /*
     */
    public  static void gameinFormation(String url,int pageNum){
        System.setProperty("phantomjs.binary.path", "C://Users//123//Desktop//aaa//phantomjs-2.1.1-windows//bin//phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        Map<String,String>map=new HashMap<String, String>();
        String urls;
        String pagingPath;
        for(int i=1;i<pageNum+1;i++){
            //翻页url
            pagingPath="http://www.doyo.cn/danji/list?p="+i;
            //获取单机游戏doc
            Document doc=document(driver,url);
            Elements as =doc.select(".list a");
            //获取一个页面每个游戏的链接 进行遍历 获取数据
            for(Element a:as){
                //获取每个 游戏的链接
                urls="http://www.doyo.cn"+a.attr("href");
                //抓取每个游戏的数据
                map=gameData(map,driver,urls);
                //存入数据库
                BasProGameInfo pgi=new BasProGameInfo();
                String uuid=UUID.randomUUID().toString();
                pgi.setUuid(uuid);
                pgi.setGname(map.get("gamename"));
                pgi.setLogo(map.get("img"));
                pgi.setGstyle(map.get("type"));
                pgi.setGtags(map.get("tag"));
                pgi.setPicture(map.get("screenshot"));
                pgi.setGtheme(map.get("theme"));
                pgi.setDevelop_com(map.get("factory"));
                pgi.setG_desc(map.get("synopsis"));
                pgi.setUrl(map.get("url"));
                pgi.setSource("逗游");
                pgi.setGamespy(map.get("frame"));
                pgi.setPtime(map.get("listed"));
                ProGameInfoDaoImpl insert=new ProGameInfoDaoImpl();
                insert.insertGame(pgi);
                //清空集合
                map.clear();
            };

        }
        //关闭连接
        driver.quit();

    }


}
