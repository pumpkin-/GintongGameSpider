package SpiderUtils;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.apache.xerces.impl.xpath.regex.Match;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by lenovon on 2017/3/1.
 */
public class BasCommonKnowledgeSpider {
//         1.获取配置文件 xml是什么？怎么写？用处是什么？
    public static KnowledgeSpiderConfig praseXmlContentByWebName(String webName) throws FileNotFoundException, DocumentException {
//      2.解析配置文件  dom4j -> SAXReader
        SAXReader saxReader=new SAXReader();
        KnowledgeSpiderConfig knowledgeSpiderConfig=new KnowledgeSpiderConfig();
        knowledgeSpiderConfig.webUrls = new ArrayList<Element>();
//        通过SAXReader读取解析的xml文件
        Document doc=saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/SpiderData/BasCommonKnowledgePattern.xml").getFile()));
//        获取xml中的根元素
        Element rootElement=doc.getRootElement();
//        获取根元素中的子元素
        Element childElement=rootElement.element(webName);
//         判断urls为空
        if(childElement.element("urls")==null||childElement.element("urls").elements().size()==0){
                throw new NullPointerException("urls is null");
        }else {
//        遍历urls下的子元素（url）
            for (Element ele : (List<Element>) (childElement.element("urls").elements())) {
                knowledgeSpiderConfig.webUrls.add(ele);
            }
        }
        return knowledgeSpiderConfig;
    }
//创建网络爬虫引擎

//    selenium驱动器
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
        return new ChromeDriver();
    }
//    phantomjs驱动器
    public static WebDriver getPhantomjsDriver(){
        System.setProperty("phantomjs.binary.path","/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        return new PhantomJSDriver();
    }
//    通过驱动器获取当前页面的document树
    public static JXDocument getJXDocument(WebDriver driver,String url){
        driver.get(url);
        JXDocument doc = new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
       return  doc;
    }
//    抓取文章的标题
    public static void ergodicUrl(WebDriver driver,String webName) throws FileNotFoundException, DocumentException, XpathSyntaxErrorException {
        JXDocument doc = getJXDocument(driver, "http://www.diankeji.com/news/31184.html");
//        System.out.println(doc.selNOne("//title"));
//        System.out.println(doc.selN("//p"));
//        System.out.println(doc.selNOne(Match()));
//        doc.selN("//p");
//        for(){
//
//        }
    }
    public static void main(String[] args) throws FileNotFoundException, DocumentException, XpathSyntaxErrorException {


        //3.装载到List
        //4.遍历
        //5.创建线程池  ThreadPooL
        //6.创建单线程   两种实现方式
        //7.创建爬虫引擎（Jsoup， phantomjs， chromedriver）(完成)
        //8.连接网络，并获取dom树   JXDomcument（完成）
        //9.复杂的解析过程
        //9.1 自动抓取标题  思路：h1-h4标签
        //9.2 自动抓取时间   思路：正则表达式
        //9.3.自动抓取正文    思路：自己配配置文件、 默认情况垃圾数据一把抓
        //10封装到javaBean -> list集合
        //10.5去重  编辑距离
        //11入库 mybatis
//        KnowledgeSpiderConfig knowledgeSpiderConfig=BasCommonKnowledgeSpider.praseXmlContentByWebName("spiderUrl");
//        System.out.println(knowledgeSpiderConfig);
//        JXDocument doc=BasCommonKnowledgeSpider.getJXDocument(getChromeDriver(), "http://mini.eastday.com/a/170302085910266.html?qid=zhinengsrf2037&vqid=znykb054");
//        System.out.println(doc);
        ExecutorService pool= Executors.newSingleThreadExecutor();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    BasCommonKnowledgeSpider.ergodicUrl(getChromeDriver(), "spiderUrl");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (XpathSyntaxErrorException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
