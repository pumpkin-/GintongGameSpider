package GintongameSpider.SpiderYxdg;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import SpiderUtils.SpiderContant;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/16.
 */
public class SpiderYxdg {
    private static List<ProKnowledge> proKnowledgeList=new ArrayList<ProKnowledge>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static List<String> coverlist=new ArrayList<String>();
    private static ProKnowledgeImpl proknowimpl = new ProKnowledgeImpl();
    private static BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
    private static PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
    private static String[] link=new String[]{"http://www.gamelook.com.cn/category/news","http://www.gamelook.com.cn/category/%E6%B8%B8%E6%88%8F%E8%BF%90%E8%90%A5","http://www.gamelook.com.cn/category/%E6%B8%B8%E6%88%8F%E5%BC%80%E5%8F%91","http://www.gamelook.com.cn/category/%E4%BA%BA%E5%8A%9B%E8%B5%84%E6%BA%90","http://www.gamelook.com.cn/category/%E7%BD%91%E9%A1%B5%E6%B8%B8%E6%88%8F-2","http://www.gamelook.com.cn/category/%E2%98%85%E6%89%8B%E6%9C%BA%E6%B8%B8%E6%88%8F","http://www.gamelook.com.cn/category/%E8%B5%84%E6%9C%AC%E5%B8%82%E5%9C%BA%E5%88%9B%E4%B8%9A","http://www.gamelook.com.cn/category/%E6%8A%95%E8%B5%84%E5%88%9B%E4%B8%9A","http://www.gamelook.com.cn/category/wiixboxps3","http://www.gamelook.com.cn/category/%E8%A7%82%E7%82%B9%E5%88%86%E6%9E%90%E8%AF%84%E6%B5%8B","http://www.gamelook.com.cn/category/%E8%B5%84%E6%9C%AC%E5%B8%82%E5%9C%BA","http://www.gamelook.com.cn/category/vrar%E6%B8%B8%E6%88%8F"};

    public static void main(String args[]) throws IOException, ProKnowledgeImpl.FormatEexception {
        grabWeb();
    }

    public static void grabWeb() throws IOException, ProKnowledgeImpl.FormatEexception {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver = new ChromeDriver();
        int a=1;
        for(int z=0;z<link.length;z++){
            for(int i=55;i>0;i++){
                driver.get(link[z] + "/page/" + i);
                WebElement web=driver.findElement(By.xpath("/html"));
                String html=web.getAttribute("outerHTML");
                Document doc=Jsoup.parse(html);
                int flag=0;
                Elements linkscover=doc.select("div.entry-thumb img");
                for(Element linkcover:linkscover){
                    Pattern pat=Pattern.compile("(?<=\\?src=).+\\.jpg");
                    Matcher mat=pat.matcher(linkcover.attr("src"));
                    while(mat.find()) {
                        coverlist.add(mat.group(0));
                    }
                }
                Elements links=doc.select("div.entry-thumb a");
                for(Element link:links) {
                    try {
                        String childLink = link.attr("href");
                        driver.get(childLink);
                        WebElement webElement = driver.findElement(By.xpath("/html"));
                        String childHtml = webElement.getAttribute("outerHTML");
                        Document childDoc = Jsoup.parse(childHtml);
                        dataClean(flag, childDoc, childLink);
                        System.out.println(a + "+" + i);
                        a++;
                        flag++;
                        System.out.println("---------------------------------");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(Integer.parseInt(doc.select("div.pagenavi.clear a.current").text())==Integer.parseInt(doc.select("div.pagenavi.clear span").text().split("/",2)[1].trim())){
                    break;
                }
            }
        }
    }

    public static void dataClean(int flag,Document doc,String url) throws IOException, ProKnowledgeImpl.FormatEexception {
        String main=null;
        String tag=null;
        System.out.println(url);
        String kuuid= UUID.randomUUID().toString();
        String puuid=UUID.randomUUID().toString();
        String cover=coverlist.get(flag);
        System.out.println(cover);
        String title=doc.select("h1.entry-title").text();
        String author=doc.select("span.meta-author a").text();
        String authorurl=doc.select("span.meta-author a").attr("href");
        String ptime=doc.select("span.meta-date").text().split(" ",2)[1]+" 00:00:00";
        String type=doc.select("span.meta-cat a").text().replace(" ",",");
        Elements linksmain=doc.select("div.entry.entry-content p");
        for(Element linkmain:linksmain){
            if(StringUtils.isNotEmpty(linkmain.text())){
                main=(main+"\r\n<p>"+linkmain.text()+"</p>").replace("null\r\n","");
            }
            if(StringUtils.isNotEmpty(linkmain.select("img").attr("src"))){
                main=(main+"\r\n<img src=\""+linkmain.select("img").attr("src")+"\">");
            }
        }
        Elements linkstag=doc.select("div#entry-tags a");
        for(Element linktag:linkstag){
            tag=(tag+","+linktag.text()).replace("null,","");
        }
        storeToDatebase(title, ptime, type, cover, tag, author, main, puuid, kuuid, url, authorurl);
    }

    public static void storeToDatebase(String title,String ptime,String type,String cover,String tag,String author,String main,String puuid,String kuuid,String url,String authorurl) throws ProKnowledgeImpl.FormatEexception {
        ProKnowledge proKnowledge=new ProKnowledge();
        proKnowledge.setTitle(title);
        proKnowledge.setPtime(ptime);
        proKnowledge.setType(type);
        proKnowledge.setCover(cover);
        proKnowledge.setTag(tag);
        proKnowledge.setAuthor(author);
        proKnowledge.setMain(main);
        proKnowledge.setUrl(url);
        proKnowledge.setSource("游戏大观");
        proKnowledge.setUuid(kuuid);
        proKnowledgeList.add(proKnowledge);

        PerKnowledge perKnow=new PerKnowledge();
        perKnow.setName(author);
        perKnow.setKname(title);
        perKnow.setRtype("原作者");
        perKnow.setPuuid(puuid);
        perKnow.setKuuid(kuuid);
        perKnow.setSource("游戏大观");
        perKnowledgeList.add(perKnow);

        BasPersonInfo basPerson=new BasPersonInfo();
        basPerson.setUuid(puuid);
        basPerson.setName(author);
        basPerson.setUrl(authorurl);
        basPerson.setSource("游戏大观");
        basPerson.setUrl(url);
        basPersonInfoList.add(basPerson);

        if((proKnowledgeList.size()>0&&proKnowledgeList.size()% SpiderContant.insertBatchContant==0)) {
            Map map=proknowimpl.insertBatchAutoDedup(proKnowledgeList, basPersonInfoList, perKnowledgeList);
            if(((List<Integer>) map.get(4)).get(0)!=0) {
                basperimpl.insertBatch((List<BasPersonInfo>) map.get(1));
                perknowimpl.insertBatch((List<PerKnowledge>) map.get(3));
            }
            proKnowledgeList.clear();
            basPersonInfoList.clear();
            perKnowledgeList.clear();
        }
    }
}
