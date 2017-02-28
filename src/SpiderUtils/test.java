
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



        /*org.jsoup.nodes.Document doc1=Jsoup.connect("http://news.yzz.cn/ku/shsj/#p=503_132712_713ea.jpg")
                         .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).get();
        JXDocument jxDocument=new JXDocument(doc1);
        System.out.println(doc1.outerHtml());*/
        //System.out.println(jxDocument.sel("//div[@class='page-number pageNumber']/ul[@class='clearfix']/li/a[text()*='下一页']/@href"));




        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://news.yzz.cn/ku/hlsgsd/");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
        JXDocument jxDocument=new JXDocument(doc);
        System.out.println(doc.outerHtml());



//


     /*System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://news.yzz.cn/ku/shsj/#p=503_132712_713ea.jpg");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
        JXDocument jxDocument=new JXDocument(doc);
        System.out.println(doc.outerHtml());
        System.out.println(jxDocument.sel("//div[@class='nph_photo_next']/a/@href"));*/

//        System.out.println(jxDocument.sel("//dd[@class='public-tabs-title']/a/@href"));


        /*Connection.Response res=Jsoup.connect("http://www.appgame.com/archives/620651.html").ignoreContentType(true).execute();
        String body = res.body();
        JSONObject json = new JSONObject(true);
        //JSON json1= com.sun.org
        System.out.println(body);*/

    }

}

