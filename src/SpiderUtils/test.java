package SpiderUtils;
import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;

import com.google.gson.Gson;

import com.gargoylesoftware.htmlunit.activex.javascript.msxml.XMLSerializer;

import dao.impl.ProKnowledgeImpl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    static List<org.dom4j.Element> books;
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {
       /* FileInputStream inputStream=new FileInputStream(Test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile());
        System.out.println(Test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile().toString());
        SAXReader sax=new SAXReader();
        org.dom4j.Document doc=sax.read(inputStream);
        org.dom4j.Element root = doc.getRootElement();//获取根元素
        Element book2 = root.element("spider1");
        Element type = book2.element("type");//根据元素名获取子元素
        Element title = book2.element("title");
        Element urls = book2.element("urls");
         System.out.println("错误修改");
        List<Element> list=urls.elements();
        for(Element ele:list){
            System.out.println(ele.getText().trim());
        }
        Element publisher = book2.element("publisher");
        System.out.println("作者：" + title.getText());//获取元素值
        System.out.println("出版社："+urls.getText());
        System.out.println();*/
//
//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://maimai.cn/login");
//        Thread.sleep(10000);
//        driver.get("https://maimai.cn/web/search_center?type=contact&query=%E5%A4%9A%E7%9B%8A&highlight=true");
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        System.out.println(Jsoup.parse(webElement.getAttribute("outerHTML")));



        //SpiderUtils.getElements("windows","spiderYxgc",70,"no");
        //SpiderUtils.getElements("windows","spiderRwt",0,"no");
        //SpiderUtils.getElements("windows","spiderKdbs",0,"no");



//        ExecutorService singleThreadExecutor = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            final int u=i;
//            singleThreadExecutor.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(index);
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//            singleThreadExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(u);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }



//        String url="http://www.18touch.com/walkthrough/new/page/1";
//        org.jsoup.nodes.Document doc1=Jsoup.connect(url)
//                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).get();
//        JXDocument jxDocument=new JXDocument(doc1);
//        System.out.println(doc1.outerHtml());

//jsoup查看网页源码
//http://chanye.07073.com/     http://chanye.07073.com/shuju/1560716.html

      org.jsoup.nodes.Document doc1=Jsoup.connect("http://mpk.mumayi.com/tiyv-download-1.html")
                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                         .get();
        JXDocument doc=new JXDocument(doc1);
       System.out.println(doc1);
//       System.out.println(doc.sel("//div[@class='b']/a[1]text()"));

//
//       org.jsoup.nodes.Document doc1=Jsoup.connect("http://games.sina.com.cn/y/n/2017-03-01/fycaafp1372689.shtml")
//                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64thread_702254.html) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
//                         .get();
//     System.out.println(doc1.outerHtml());




//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://www.gameres.com/zuixin_1.html");


//      org.jsoup.nodes.Document doc1=Jsoup.connect("http://news.52pk.com/cyyw/20170216/6929920.shtml")
//
//                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
//                         .get();
//        JXDocument jxDocument=new JXDocument(doc1);
//
//     System.out.println(jxDocument.selOne("//div[@class='lt contentl']/h1/text()"));



//        JXDocument jxDocument=new JXDocument(doc1);
//        System.out.println(jxDocument.sel("//div[@class='page']/a[allText()*='>']/@href"));

//        http://www.gamerbbs.cn/news/1706.html
//        http://www.gamerbbs.cn/news/1707.html



//        org.jsoup.nodes.Document doc1=Jsoup.connect("")
//                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).get();
//        JXDocument jxDocument=new JXDocument(doc1);
//        System.out.println(doc1.outerHtml());




//        org.jsoup.nodes.Document doc1=Jsoup.connect("http://s.weibo.com/user/%25E6%25B8%25B8%25E6%2588%258FHR&Refer=SUer_box")
//                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).get();
//        System.out.println(doc1.outerHtml());
//        Pattern pat=Pattern.compile("<script>.+?\\(");
//        Matcher mat=pat.matcher(doc1.outerHtml());
//        String a=null;
//        for(int x=0;x<5;x++) {
//            if (mat.find()) {
//                if(x==2) {
//                    a=mat.group(0);
//                }
//            }
//        }
//        Pattern pat1=Pattern.compile("\\\\u[0-9,a-f,A-F]{4}");
//        Matcher mat1=pat1.matcher(a);
//        while(mat1.find()) {
//            String b=mat1.group(0);
//            int data = Integer.parseInt(b.replaceAll("\\\\u", ""), 16);
//            a =a.replace(b,String.valueOf((char)data));
//        }
//        System.out.println(a);
        /*while(mat.find()){
            String a=mat.group(0);
            Pattern pat1=Pattern.compile("\\\\u[0-9,a-f,A-F]{4}");
            Matcher mat1=pat1.matcher(a);
            while(mat1.find()) {
                String b=mat1.group(0);
                System.out.println(b);
                int data = Integer.parseInt(b.replace("\\u", ""), 16);
                String main =a.replace(b,String.valueOf((char)data));
            }
        }*/












//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://games.sina.cn/pc/newslist.d.html?cid=35435,35434,35436,35437,35439,35440,35441&page=1&pagesize=53");


        /*System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://news.yzz.cn/ku/hlsgsd/");

        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
        JXDocument jxDocument=new JXDocument(doc);
        System.out.println(doc.outerHtml());


//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://www.html5dw.com/news");
>>>>>>> d32140d7c5fb572cc6949998fd580002d3e38e94
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
//        JXDocument jxDocument=new JXDocument(doc);
//        System.out.println(doc.outerHtml());


//



//        System.out.println(jxDocument.sel("//div[@class='nph_photo_next']/a/@href"));

//        System.out.println(jxDocument.sel("//dd[@class='public-tabs-title']/a/@href"));


        /*Connection.Response res=Jsoup.connect("http://zhushou.360.cn/detail/index/soft_id/3485062").ignoreContentType(true).execute();
        String body = res.body();
        JSONObject json = new JSONObject(true);
        //JSON json1= com.sun.org
        System.out.println(body);*/

//selenium查看网页源码

//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
////        driver.get("http://zhushou.360.cn/list/index/cid/2?page=1");
//        driver.get("http://game.hiapk.com/role/10005218.html");
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        org.jsoup.nodes.Document doc2=Jsoup.parse(webElement.getAttribute("outerHTML"));
//        JXDocument jxDocument=new JXDocument(doc2);
//        System.out.println(doc2.outerHtml());

//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
////        driver.get("http://zhushou.360.cn/list/index/cid/2?page=1");
//        driver.get("http://play.91.com/iphone/Game/");
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        org.jsoup.nodes.Document doc2=Jsoup.parse(webElement.getAttribute("outerHTML"));
//        JXDocument jxDocument=new JXDocument(doc2);
//        System.out.println(doc2.outerHtml());
//

        // 要验证的字符串
//        String str = "http://sdw12/4344/fdfd/434fd/abc.html";
//
//        String re = "(h|t|t|p)/:(//{1}[a-zA-Z0-9]{2,}{3,}//$)";
//        // 编译正则表达式
//        Pattern pattern = Pattern.compile(re);
//
//        Matcher matcher = pattern.matcher(str);
//        // 字符串是否与正则表达式相匹配
//        boolean rs = matcher.matches();
//        System.out.println(rs);
    }
}
