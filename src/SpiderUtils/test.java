package SpiderUtils;

import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
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

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class test {
    static List<org.dom4j.Element> books;
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {
       /* FileInputStream inputStream=new FileInputStream(test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile());
        System.out.println(test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile().toString());
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


        SpiderUtils.getElements("windows","spiderYmxk",0,"no");


     /*System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.mofang.com/news");
       *JavascriptExecutor executorChildnext = (JavascriptExecutor) driver;
        executorChildnext.executeScript("$('span.pagecss a.p1.nexe').click()");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
        JXDocument jxDocument=new JXDocument(doc);

        System.out.println(jxDocument.sel("//dd[@class='public-tabs-title']/a/@href"));*/



    }

}