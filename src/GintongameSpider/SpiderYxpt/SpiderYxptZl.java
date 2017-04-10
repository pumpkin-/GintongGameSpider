package GintongameSpider.SpiderYxpt;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import SpiderUtils.SpiderUtils;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/15.
 */
public class SpiderYxptZl {
    private static List<BasKnowledgeInfo> basKnowledgeInfoList =new ArrayList<BasKnowledgeInfo>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static List<String> authorlist=new ArrayList<String>();
    private static int fg=0;
    private static BasKnowledgeInfoDaoImpl proknowimpl = new BasKnowledgeInfoDaoImpl();
    private static PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
    private static BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();

    public static void main(String args[]) throws IOException, BasKnowledgeInfoDaoImpl.FormatEexception {
        grabWeb();
    }

    public static void grabWeb() throws IOException, BasKnowledgeInfoDaoImpl.FormatEexception {
        int a=1;
        for(int i=1;i>0;i++) {
            Document doc = Jsoup.connect("http://youxiputao.com/article/index/page/" + i).get();
            Elements links = doc.select("h4>a");
            Elements linksauthor=doc.select("div.news-info-box span.pull-right");
            for(Element linkauthor:linksauthor){
                authorlist.add((linkauthor.text().split("·",2)[0]).trim());
            }
            for (Element link : links) {
                int flag=0;
                String childLink = "http://youxiputao.com" + link.attr("href");
                Document docchildlink = Jsoup.connect(childLink).get();
                dataClean(docchildlink,childLink,flag);
                System.out.println(a + "+" + i);
                flag++;
                a++;
                System.out.println("-------------------------------------");
            }
            if(!doc.select("li.next.disabled").isEmpty()){
                System.exit(0);
            }
        }
    }

    public static void dataClean(Document doc,String url,int flag) throws IOException, BasKnowledgeInfoDaoImpl.FormatEexception {
        String tag=null;
        String main=null;
        String cover=null;
        String kuuid= UUID.randomUUID().toString();
        String puuid=UUID.randomUUID().toString();
        String title=doc.select("h2.title").text();
        String ptime=doc.select("div.pull-left>div.time").text().split(" ",3)[2];
        String type=null;
        if(doc.select("a.tag").text().equals("深度")){
            type="干货";
        }else if(doc.select("a.tag").text().equals("资讯")){
            type="产业";
        }else if(doc.select("a.tag").text().equals("demowall")||doc.select("a.tag").text().equals("酷玩")){
            type="产品";
        }else if(doc.select("a.tag").text().equals("专栏")||doc.select("a.tag").text().equals("葡萄观察")){
            type="行业";
        }
        String author=authorlist.get(flag);
        if(doc.select("div.cover img").attr("src")!=null&&doc.select("div.cover img").attr("src").length()>0) {
            cover =  doc.select("div.cover img").attr("src");
        }
        Elements linkstag=doc.select("div.tag>div.pull-left>a.btn.btn-default");
        for(Element linktag:linkstag){
            tag=(tag+","+linktag.text()).replace("null,","");
        }
        Elements linksmain=doc.select("div.info p");
        for(Element linkmain:linksmain){
            if(linkmain.text()!=null&&linkmain.text().length()>0&&!linkmain.text().contains("文章来源")){
                main=(main+"\r\n"+linkmain.text()).replace("null\r\n", "");
            }
            if(linkmain.select("img").attr("src")!=null&&linkmain.select("img").attr("src").length()>0){
                main=(main+"\r\n"+"<img src=\""+linkmain.select("img").attr("src")+"\">").replace("null\r\n","");
            }
        }
        try {
            storeToDatebase(title,ptime,type,cover,tag,author,main,puuid,kuuid,url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void storeToDatebase(String title,String ptime,String type,String cover,String tag,String author,String main,String puuid,String kuuid,String url) throws BasKnowledgeInfoDaoImpl.FormatEexception, SpiderUtils.FormatEexception, ParseException {
        BasKnowledgeInfo basKnowledgeInfo =new BasKnowledgeInfo();
        basKnowledgeInfo.setTitle(title);
        basKnowledgeInfo.setPtime(ptime+" 00:00:00");
        basKnowledgeInfo.setType(type);
        basKnowledgeInfo.setCover(cover);
        basKnowledgeInfo.setTag(tag);
        basKnowledgeInfo.setAuthor(author);
        basKnowledgeInfo.setMain(main);
        basKnowledgeInfo.setUrl(url);
        basKnowledgeInfo.setSource("游戏葡萄");
        basKnowledgeInfo.setUuid(kuuid);
        basKnowledgeInfoList.add(basKnowledgeInfo);

        PerKnowledge perKnow=new PerKnowledge();
        perKnow.setName(author);
        perKnow.setKname(title);
        perKnow.setRtype("原作者");
        perKnow.setPuuid(puuid);
        perKnow.setKuuid(kuuid);
        perKnow.setSource("鸟哥笔记");
        perKnowledgeList.add(perKnow);

        BasPersonInfo basPerson=new BasPersonInfo();
        basPerson.setUuid(puuid);
        basPerson.setName(author);
        basPerson.setSource("鸟哥笔记");
        basPerson.setUrl(url);
        basPersonInfoList.add(basPerson);



        Map map=proknowimpl.insertBatchAutoDedup(basKnowledgeInfoList,basPersonInfoList,perKnowledgeList);
        if(((List<String>)map.get(2)).get(0).equals("false")) {
            System.exit(0);
        }
        if(((List<Integer>) map.get(4)).get(0)!=0) {
            basperimpl.insertBatch(basPersonInfoList);
            perknowimpl.insertBatch(perKnowledgeList);
        }
        basKnowledgeInfoList.clear();
        basPersonInfoList.clear();
        perKnowledgeList.clear();

    }
}
