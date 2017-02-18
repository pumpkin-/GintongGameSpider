package SpiderUtils;

import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class test {
    static List<org.dom4j.Element> books;
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {
        /*FileInputStream inputStream=new FileInputStream(test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile());
        System.out.println(test.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile().toString());
        SAXReader sax=new SAXReader();
        org.dom4j.Document doc=sax.read(inputStream);
        org.dom4j.Element root = doc.getRootElement();//获取根元素
        Element book2 = root.element("spider1");
        Element type = book2.element("type");//根据元素名获取子元素
        Element title = book2.element("title");
        Element urls = book2.element("urls");
        List<Element> list=urls.elements();
        for(Element ele:list){
            System.out.println(ele.getText().trim());
        }
        Element publisher = book2.element("publisher");
        System.out.println("作者：" + title.getText());//获取元素值
        System.out.println("出版社："+urls.getText());*/

     // SpiderUtils.getElements("windows","spider1");


       /* org.jsoup.nodes.Document doc=Jsoup.connect("http://news.17173.com/content/02172017/144428249.shtml").get();
        JXDocument jx=new JXDocument(doc);
        System.out.println(doc.outerHtml());
        System.out.println(jx.selOne("//html"));*/

        ProKnowledgeImpl proKnowledge=new ProKnowledgeImpl();
        List<ProKnowledge> list=proKnowledge.select();
        for(ProKnowledge li:list){
            try {
                System.out.println(li.getMain().replace("<img src=","<img src=\"").replace(">","\">"));
              //  System.out.println(li.getCover());
            }catch (Exception e){
                System.out.println("null");
            }
        }
    }
}