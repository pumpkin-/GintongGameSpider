package SpiderUtils;

import JavaBean.OrganizeConfigure;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.print.Doc;
import javax.swing.text.Document;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * usage: 知识爬虫通用类
 * Created by Byron on 2017/2/24.
 */
public class CommonSpiderKnowledge {

    CommonSpiderKnowledge commonSpiderKnowledge = new CommonSpiderKnowledge();

    public static void main(String[] args) throws FileNotFoundException, DocumentException {


        //1.获取驱动器
        //2.解析配置文件
//        List<KnowledgeSpiderConfig> configs = parseAllConfigXml();
//        for(KnowledgeSpiderConfig config : configs) {
//            System.out.println(config);
//        }
      KnowledgeSpiderConfig config  = parseConfigXmlByWebName("spiderYmxk", 0);
       System.out.println(config);
        //3.获取页面列表
        //4.遍历页面列表, 获取详情页
            //解析document单个标签
            //异常检查
            //数据清洗
            //入库

    }

    public static void storeToDataBase() {

    }

    /**
     * 通过xpath语法 获取document树的节点
     * @param document
     * @param xpath
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static  Object getTag(JXDocument document, String xpath) throws XpathSyntaxErrorException {
        Object obj = null;
        if(StringUtils.isNotEmpty(xpath)) {
            obj = document.sel(xpath);
        }
        if (obj == null) {
            throw new XpathSyntaxErrorException("xpath syntax error, check your xpath : " + xpath);
        }
        return obj;
    }

    /**
     * 通过驱动器获得当前页面的doucument树
     * @param driver
     * @return
     */
    public static JXDocument getJXDocument(WebDriver driver) {
       return new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
    }
    /**
     * 通过驱动器获得当前页面的doucument树
     * @param url
     * @return
     */
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.parse(Jsoup.connect(url).get().outerHtml()));
    }
    /**
     * 解析全部配置文件 获取所有的spider节点
     * @return
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public static List<KnowledgeSpiderConfig> parseAllConfigXml() throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();

        List<KnowledgeSpiderConfig> configs = new ArrayList<KnowledgeSpiderConfig>();
        org.dom4j.Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        Element rootElemnt = dom.getRootElement();//获取根元素
        List<Element> childElements =rootElemnt.elements("spider");
        for(Element childElement:childElements) {

            KnowledgeSpiderConfig knowledgeSpiderConfig = new KnowledgeSpiderConfig();
            knowledgeSpiderConfig.webUrls = new ArrayList<String>();
            //获取当前网站的所有子链接 并添加到javaBean中
            if (childElement.element("urls") == null || childElement.element("urls").elements().size() == 0) {
                throw new NullPointerException("can't find corret web urls, please check your <urls> tag in your BasKnowledgePattern.xml");
            }
            for (Element ele : (List<Element>) (childElement.element("urls")).elements()) {
                knowledgeSpiderConfig.webUrls.add(ele.getText());
            }
            //TODO 不懂什么意思
            Element childLink = childElement.element("childLink");

            if (childElement.element("next") != null) {
                knowledgeSpiderConfig.nextPage = childElement.element("next").getText();
            }
            //TODO 不懂什么意思
            Element nextflagi = childElement.element("nextflag");
            if (childElement.element("author") != null) {
                knowledgeSpiderConfig.author = childElement.element("author").getText();
            }
            if (childElement.element("title") != null) {
                knowledgeSpiderConfig.title = childElement.element("title").getText();
            }
            if (childElement.element("cover") != null) {
                knowledgeSpiderConfig.cover = childElement.element("cover").getText();
            }
            if (childElement.element("tag") != null) {
                knowledgeSpiderConfig.tag = childElement.element("tag").getText();
            }
            if (childElement.element("main") != null) {
                knowledgeSpiderConfig.main = childElement.element("main").getText();
            }
            if (childElement.element("mainpic") != null) {
                knowledgeSpiderConfig.mainPicture = childElement.element("mainpic").getText();
            }
            if (childElement.element("ptime") != null) {
                knowledgeSpiderConfig.ptime = childElement.element("ptime").getText();
            }
            if (childElement.element("type") != null) {
                knowledgeSpiderConfig.type = childElement.element("type").getText();
            }
            if (childElement.element("source") != null) {
                knowledgeSpiderConfig.source = childElement.element("source").getText();
            }
            if (childElement.element("authorurl") != null) {
                knowledgeSpiderConfig.authorUrl = childElement.element("authorurl").getText();
            }
            //TODO 不懂什么意思
            Element childnexti = childElement.element("childnext");
            Element childnextflagi = childElement.element("childnextflag");
            if (childElement.element("more") != null) {
                knowledgeSpiderConfig.more = childElement.element("more").getText();
            }
            //TODO 不懂什么意思
            Element moreflag = childElement.element("moreflag");

            //将解析完的一个爬虫配置文件添加到List中
            configs.add(knowledgeSpiderConfig);
        }
            return configs;
    }

    /**
     * 解析单个配置文件
     * @return
     */
    public static KnowledgeSpiderConfig parseConfigXmlByWebName(String webName, int fromPageNum) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        KnowledgeSpiderConfig knowledgeSpiderConfig = new KnowledgeSpiderConfig();
        knowledgeSpiderConfig.webUrls = new ArrayList<String>();

        org.dom4j.Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        Element rootElemnt = dom.getRootElement();//获取根元素
        Element childElement = (Element) rootElemnt.elements(webName).get(0);
            //获取当前网站的所有子链接 并添加到javaBean中
            if(childElement.element("urls") == null || childElement.element("urls").elements().size() == 0) {
                throw new NullPointerException("can't find corret web urls, please check your <urls> tag in your BasKnowledgePattern.xml");
            }
            for (Element ele : (List<Element>)(childElement.element("urls")).elements()) {
                knowledgeSpiderConfig.webUrls.add(ele.getText());
            }
            //TODO 不懂什么意思
            Element childLink=childElement.element("childLink");

            if (childElement.element("next") != null) {
                knowledgeSpiderConfig.nextPage = childElement.element("next").getText();
            }
            //TODO 不懂什么意思
            Element nextflagi=childElement.element("nextflag");
            if (childElement.element("author") != null) {
                knowledgeSpiderConfig.author = childElement.element("author").getText();
            }
            if(childElement.element("title") != null) {
                knowledgeSpiderConfig.title = childElement.element("title").getText();
            }
            if(childElement.element("cover") != null) {
                knowledgeSpiderConfig.cover = childElement.element("cover").getText();
            }
            if(childElement.element("tag") != null) {
                knowledgeSpiderConfig.tag = childElement.element("tag").getText();
            }
            if(childElement.element("main") != null) {
                knowledgeSpiderConfig.main = childElement.element("main").getText();
            }
            if(childElement.element("mainpic") != null) {
                knowledgeSpiderConfig.mainPicture = childElement.element("mainpic").getText();
            }
            if(childElement.element("ptime") != null) {
                knowledgeSpiderConfig.ptime = childElement.element("ptime").getText();
            }
            if(childElement.element("type") != null) {
                knowledgeSpiderConfig.type = childElement.element("type").getText();
            }
            if(childElement.element("source") != null) {
                knowledgeSpiderConfig.source = childElement.element("source").getText();
            }
           if(childElement.element("authorurl") != null) {
               knowledgeSpiderConfig.authorUrl = childElement.element("authorurl").getText();
           }
           //TODO 不懂什么意思
            Element childnexti=childElement.element("childnext");
            Element childnextflagi=childElement.element("childnextflag");
            if(childElement.element("more") != null) {
                knowledgeSpiderConfig.more = childElement.element("more").getText();
            }
            //TODO 不懂什么意思
            Element moreflag=childElement.element("moreflag");

            return knowledgeSpiderConfig;
    }

//--------------------------------------------------
    /**
     * 获取phantomJs驱动器
     * @return
     */
    public static WebDriver getPhantomDriver() {
        System.setProperty("phantomjs.binary.path", "/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        return new PhantomJSDriver();
    }

    /**
     * 获取selenium驱动器
     * @return
     */
    public static WebDriver getSeleniumDriver() {
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        return new ChromeDriver();
    }

    /**
     * 获取当前系统版本名称
     * @return Windows 7  Windows 8  or Linux etc..
     */
    public static String getOSName() {
        return System.getProperty("os.name");
    }

}
