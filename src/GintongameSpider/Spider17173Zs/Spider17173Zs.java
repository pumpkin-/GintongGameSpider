package GintongameSpider.Spider17173Zs;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import SpiderUtils.SpiderContant;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/15.
 */
public class Spider17173Zs {
    private static List<ProKnowledge> proKnowledgeList=new ArrayList<ProKnowledge>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static List<String> ptimeList=new ArrayList<String>();
    private static List<String> authorList=new ArrayList<String>();

    public static void main(String args[]) throws IOException, ProKnowledgeImpl.FormatEexception {
        grabWeb();
    }

    public static void grabWeb() throws IOException, ProKnowledgeImpl.FormatEexception {
        System.setProperty("phantomjs.binary.path", "E:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        int a=1;
        for(int i=1;i<=3008;i++) {
            driver.get("http://search.17173.com/jsp/newslist.jsp?expression=newsChannel%3A10009%20AND%20(newsKind%3A10161)%20AND%20newsClass%3A1&highLights=newsTitle,newsContent&pageNo="+i);
            WebElement web = driver.findElement(By.xpath("/html"));
            int flag = 1;
            int flags=0;
            String html = web.getAttribute("outerHTML");
            Document doc = Jsoup.parse(html);
            Elements linkstime = doc.select("div[style=float: left; width: 200px;]");
            for (Element linktime : linkstime) {
                ptimeList.add(linktime.text());
            }
            Elements linksauthor = doc.select("div[style=float: left; width: 100px; height: 40px;]");
            for (Element linkauthor : linksauthor) {
                authorList.add(linkauthor.text());
            }
            Elements links = doc.select("div.removeItemSign a");
            for (Element link : links) {
                if (flags != 0) {
                    String childLink = link.attr("href");
                    Document doclink=Jsoup.connect(childLink).get();
                    dataClean(doclink,childLink,flag);
                }
                System.out.println(a+"+"+i);
                flag++;
                flags++;
                a++;
                System.out.println("-------------------------------------");
            }
            ptimeList.clear();
            authorList.clear();
        }
    }

    public static void dataClean(Document doc,String url,int flag) throws IOException, ProKnowledgeImpl.FormatEexception {
        String tag=null;
        String main=null;
        String type=null;
        String title=null;
        String puuid= UUID.randomUUID().toString();
        String kuuid=UUID.randomUUID().toString();
        try {
            type=doc.select("div.crumb.forsetLink1 a[target=_blank]").get(1).text();
        }catch (Exception e1){
            try {
                type = doc.select("div.gb-final-mod-crumbs a").get(2).text();
            }catch (Exception e2){
                try {
                    type = doc.select("div.gb-final-mod-crumbs span.gb-final-cur").get(0).text();
                }catch (Exception e3){
                    type=null;
                }
            }
        }
        if(StringUtils.isNotEmpty(doc.select("h1.article-tit.forsetLink3").text())) {
            title = doc.select("h1.article-tit.forsetLink3").text();
        }else{
            title=doc.select("span.gb-final-cur").text();
        }
        String author=authorList.get(flag);
        String test=doc.select("span.tag.forsetLink3 script").toString();
        String ptime=ptimeList.get(flag);

        Pattern pat=Pattern.compile(".*var _tags.*",Pattern.CASE_INSENSITIVE);
        Matcher mat=pat.matcher(test);
        while(mat.find()){
            tag=(mat.group(0).replace("var _tags = '","").replace("';","")).trim();
        }
        if(doc.select("div.vr-article-bd p")!=null&&doc.select("div.vr-article-bd p").toString().length()>0) {
            Elements linksmain = doc.select("div.vr-article-bd p");
            for (Element linkmain : linksmain) {
                if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                    main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                }
                if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                    main = (main + "\r\n" + "<img src=" + linkmain.select("img").attr("src") + ">").replace("null\r\n", "");
                }
            }
        }else{
            Elements linksmain = doc.select("div.gb-final-mod-article.gb-final-mod-article-p2em p");
            for (Element linkmain : linksmain) {
                if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                    main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                }
                if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                    main = (main + "\r\n" + "<img src=" + linkmain.select("a").attr("href") + ">").replace("null\r\n", "");
                }
            }
        }
        FileOutputStream output=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\a.txt",true);
        try {
            byte bt[] = (type+"\r\n").getBytes();
            output.write(bt,0,bt.length);
        }catch (Exception e){
            System.out.println("yy");
        }
        System.out.println(type);
        System.out.println(url);
        //storeToDatebase(title, ptime, type, tag, author, main, puuid, kuuid, url);
    }

    public static void storeToDatebase(String title,String ptime,String type,String tag,String author,String main,String puuid,String kuuid,String url) throws ProKnowledgeImpl.FormatEexception {
        ProKnowledge proKnowledge=new ProKnowledge();
        proKnowledge.setTitle(title);
        proKnowledge.setPtime(ptime);
        proKnowledge.setType(type);
        proKnowledge.setTag(tag);
        proKnowledge.setAuthor(author);
        proKnowledge.setMain(main);
        proKnowledge.setUrl(url);
        proKnowledge.setSource("17173");
        proKnowledge.setUuid(kuuid);
        proKnowledgeList.add(proKnowledge);

        PerKnowledge perKnow=new PerKnowledge();
        perKnow.setName(author);
        perKnow.setKname(title);
        perKnow.setRtype("原作者");
        perKnow.setPuuid(puuid);
        perKnow.setKuuid(kuuid);
        perKnow.setSource("17173");
        perKnowledgeList.add(perKnow);

        BasPersonInfo basPerson=new BasPersonInfo();
        basPerson.setUuid(puuid);
        basPerson.setName(author);
        basPerson.setSource("17173");
        basPerson.setUrl(url);
        basPersonInfoList.add(basPerson);

        if((proKnowledgeList.size()>0&&proKnowledgeList.size()% SpiderContant.insertBatchContant==0)) {
            ProKnowledgeImpl proknowimpl = new ProKnowledgeImpl();
            proknowimpl.insertBatchAutoDedup(proKnowledgeList);
            BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
            basperimpl.insertBatch(basPersonInfoList);
            PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
            perknowimpl.insertBatch(perKnowledgeList);
            proKnowledgeList.clear();
            basPersonInfoList.clear();
            perKnowledgeList.clear();
        }
    }
}
