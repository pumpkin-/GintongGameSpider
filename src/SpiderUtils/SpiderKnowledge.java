package SpiderUtils;


import JavaBean.BasProGameInfo;
import JavaBean.OrgKnowledge;
import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.*;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovon on 2017/3/15.
 */
public class SpiderKnowledge {
    static SimpleDateFormat simpleDateFormatchange=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static  List<String> hrefList=new ArrayList<String>();
    public static List<String> ptimeList=new ArrayList<String>();
    public static ProKnowledgeImpl proKnowledgeImpl=new ProKnowledgeImpl();
    public static List<String> list=null;
    /**
     * 1、获取xml
     * @param xmlPath
     * @return
     */
    public static  Document obtainKnowledgeXml(String xmlPath){
        Document doc= null;
        try {
            doc =new SAXReader().read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource(xmlPath).getFile()));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 2、解析xml
     * @param WebName
     * @param xmlPath
     * @return
     */
    public static  KnowledgeSpiderConfig parseKnowledgeXmlByName(String WebName,String xmlPath){
        KnowledgeSpiderConfig knowledgeSpiderConfig=new KnowledgeSpiderConfig();
        knowledgeSpiderConfig.webUrls=new ArrayList<Element>();
        Document doc=obtainKnowledgeXml(xmlPath);
        Element  rootElement=doc.getRootElement();
        Element childElement=rootElement.element(WebName);
        if(StringUtils.isNotEmpty(childElement.element("title").getText())){
            knowledgeSpiderConfig.title=childElement.element("title");

        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("author"))){
            knowledgeSpiderConfig.author=childElement.element("author");

        }
        if(knowledgeSpiderConfig.isNotEmpty(childElement.element("authorurl"))){
            knowledgeSpiderConfig.authorUrl=childElement.element("authorurl");

        }
        if(knowledgeSpiderConfig.isNotEmpty(childElement.element("cover"))){
            knowledgeSpiderConfig.cover=childElement.element("cover");

        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("ptime"))){
            knowledgeSpiderConfig.ptime=childElement.element("ptime");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("tag"))){
            knowledgeSpiderConfig.tag=childElement.element("tag");
        }
        if(knowledgeSpiderConfig.isNotEmpty(childElement.element("main"))){
            knowledgeSpiderConfig.main=childElement.element("main");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("mainpic"))){
            knowledgeSpiderConfig.mainPicture=childElement.element("mainpic");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("type"))){
            knowledgeSpiderConfig.type=childElement.element("type");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("source"))){
            knowledgeSpiderConfig.source=childElement.element("source");
        }
        if(knowledgeSpiderConfig.isNotEmpty(childElement.element("childLink"))){
            knowledgeSpiderConfig.childLink=childElement.element("childLink");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("nextpage"))){
            knowledgeSpiderConfig.nextPage=childElement.element("nextpage");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("flag"))){
            knowledgeSpiderConfig.flag=childElement.element("flag");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("childnext"))){
            knowledgeSpiderConfig.childnext=childElement.element("childnext");
        }
        if (knowledgeSpiderConfig.isNotEmpty(childElement.element("chose"))){
            knowledgeSpiderConfig.chose=childElement.element("chose");
        }
        if(StringUtils.isEmpty(childElement.element("urls").getText())){
            throw new NullPointerException("urls is null");
        }
        for (Element element: (List<Element>)(childElement.element("urls").elements())){
            knowledgeSpiderConfig.webUrls.add(element);
        }
        return knowledgeSpiderConfig;
    }

    /**
     *
     * @param childElement
     * @return
     */
    public static  KnowledgeSpiderConfig parseKnowledgeXmlByName(Element childElement,String uuid){
        KnowledgeSpiderConfig knowledgeSpiderConfig=new KnowledgeSpiderConfig();
        knowledgeSpiderConfig.webUrls=new ArrayList<Element>();
        if(StringUtils.isNotEmpty(childElement.element("title").getText())){
            knowledgeSpiderConfig.title=childElement.element("title");
            System.out.println("title:"+childElement.element("title").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("author").getText())){
            knowledgeSpiderConfig.author=childElement.element("author");
            System.out.println("author:"+childElement.element("author").getText());
        }
        if(StringUtils.isNotEmpty(childElement.element("authorurl").getText())){
            knowledgeSpiderConfig.authorUrl=childElement.element("authorurl");
            System.out.println("authorurl:"+childElement.element("authorurl").getText());
        }
        if(StringUtils.isNotEmpty(childElement.element("cover").getText())){
            knowledgeSpiderConfig.cover=childElement.element("cover");
            System.out.println("cover:"+childElement.element("cover").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("ptime").getText())){
            knowledgeSpiderConfig.ptime=childElement.element("ptime");
            System.out.println("ptime:"+childElement.element("ptime").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("tag").getText())){
            knowledgeSpiderConfig.tag=childElement.element("tag");
            System.out.println("tag:"+childElement.element("tag"));
        }
        if(StringUtils.isNotEmpty(childElement.element("main").getText())){
            knowledgeSpiderConfig.main=childElement.element("main");
            System.out.println("main:"+childElement.element("main").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("mainpic").getText())){
            knowledgeSpiderConfig.mainPicture=childElement.element("mainpic");
            System.out.println("mainpic:"+childElement.element("mainpic").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("type").getText())){
            knowledgeSpiderConfig.type=childElement.element("type");
            System.out.println("type:"+childElement.element("type").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("source").getText())){
            knowledgeSpiderConfig.source=childElement.element("source");
            System.out.println("source:"+childElement.element("source").getText());
        }
        if(StringUtils.isNotEmpty(childElement.element("childLink").getText())){
            knowledgeSpiderConfig.childLink=childElement.element("childLink");
            System.out.println("childLink:"+childElement.element("childLink").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("nextpage").getText())){
            knowledgeSpiderConfig.nextPage=childElement.element("nextpage");
            System.out.println("nextPage:"+childElement.element("nextpage").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("flag").getText())){
            knowledgeSpiderConfig.flag=childElement.element("flag");
            System.out.println("flag:"+childElement.element("flag").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("childnext").getText())){
            knowledgeSpiderConfig.childnext=childElement.element("childnext");
            System.out.println("childnext:"+childElement.element("childnext").getText());
        }
        if (StringUtils.isNotEmpty(childElement.element("chose").getText())){
            knowledgeSpiderConfig.chose=childElement.element("chose");
            System.out.println("chose:"+childElement.element("chose").getText());
        }
        if(StringUtils.isEmpty(childElement.element("urls").getText())){
            throw new NullPointerException("urls is null");
        }

        for (Element element: (List<Element>)(childElement.element("urls").elements())){
            knowledgeSpiderConfig.webUrls.add(element);
        }
        return knowledgeSpiderConfig;
    }
    /**
     * 获取phantomJs驱动器
     * @return
     */
    public static WebDriver getPhantomDriver() {
        System.setProperty("phantomjs.binary.path",SpiderContant.phantomjsLinuxPath);
        return new PhantomJSDriver();
    }

    /**
     * 获取selenium驱动器
     * @return
     */
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        return new ChromeDriver();
    }
    /**
     * 通过驱动器获得当前页面的doucument树  jsoup
     * @param url
     * @return
     */
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
    /**
     * 通过驱动器获得当前页面的doucument树 selenium
     * @param driver
     * @return
     */
    public static JXDocument getJXDocument(WebDriver driver,String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
        return new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
    }

    /**
     *
     * @param WebName
     * @param xmlPath
     * @throws IOException
     * @throws InterruptedException
     * @throws XpathSyntaxErrorException
     */
    public static void ergodicUrl(String WebName,String xmlPath) throws IOException, InterruptedException, XpathSyntaxErrorException {
        String childLink = null;
        JXDocument doc = null;
        String main = null;
        String author=null;
        String title=null;
        String cover=null;
        String ptimetest=null;
        String ptime=null;
        String authorurl=null;
        String tag=null;
        String type = null;
        String source=null;
        KnowledgeSpiderConfig knowledgeSpiderConfig = parseKnowledgeXmlByName(WebName, xmlPath);
        for (Element url : knowledgeSpiderConfig.webUrls) {
            if (knowledgeSpiderConfig.flag.getText().equals("jsoup")) {
                doc = getJXDocument(url.getText().trim());
                try {
                    while (true) {
                        List<Object> childLinks = doc.sel(knowledgeSpiderConfig.childLink.getText());
                        for (Object childlink : childLinks) {
                            if (StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                                childLink = knowledgeSpiderConfig.childLink.attributeValue("join") + childlink;
                                System.out.println(childLink);
                            } else{
                                childLink = (String) childlink;
                                System.out.println(childLink);
                            }
                            source=knowledgeSpiderConfig.source.getText();
                            System.out.println(source);
                            JXDocument childDocumet = getJXDocument(childLink);
                            clearType(childDocumet,knowledgeSpiderConfig);
                            clearTag(childDocumet,knowledgeSpiderConfig);
//                            clearTime(childDocumet,knowledgeSpiderConfig);
                            clearCover(doc,knowledgeSpiderConfig);
//                            clearAnthor(childDocumet,knowledgeSpiderConfig);
                            clearTitle(childDocumet,knowledgeSpiderConfig);
                            clearMain(childDocumet,knowledgeSpiderConfig);
                        }
                        doc = listPageJsoup(doc, knowledgeSpiderConfig);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (knowledgeSpiderConfig.flag.getText().equals("selenium")) {
                WebDriver driver = getChromeDriver();
                doc = getJXDocument(driver, url.getText().trim());
                try {
                    while(true){
                    List<Object> childLinks = doc.sel(knowledgeSpiderConfig.childLink.getText());
                    for (Object childlink : childLinks) {
                        if (StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                            childLink = knowledgeSpiderConfig.childLink.attributeValue("join") + childlink;
                            System.out.println(childLink);
                        }else {
                            childLink = childlink.toString();
                            System.out.println(childLink);
                        }
                        source=knowledgeSpiderConfig.source.getText();
                        System.out.println(source);
                        JXDocument childDocumet = getJXDocument(childLink);
                        clearType(childDocumet,knowledgeSpiderConfig);
                        clearTag(childDocumet,knowledgeSpiderConfig);
//                        clearTime(childDocumet,knowledgeSpiderConfig);
                        clearCover(doc,knowledgeSpiderConfig);
//                        clearAnthor(childDocumet,knowledgeSpiderConfig);
                        clearTitle(childDocumet,knowledgeSpiderConfig);
                        clearMain(childDocumet,knowledgeSpiderConfig);

                    }
                    doc = listPageSelenium(driver, knowledgeSpiderConfig);
                }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过
     * @param childElement
     * @param uuid
     * @throws IOException
     * @throws InterruptedException
     * @throws XpathSyntaxErrorException
     */
    public static void ergodicUrl(Element childElement,String uuid) throws IOException, InterruptedException, XpathSyntaxErrorException {
        String childLink = null;
        JXDocument doc = null;
        String main = null;
        String author=null;
        String title=null;
        String cover=null;
        String ptime=null;
        String authorurl=null;
        String tag=null;
        String type = null;
        String source=null;
//        String WebName=null;
//        String xmlPath=null;
        KnowledgeSpiderConfig knowledgeSpiderConfig = parseKnowledgeXmlByName(childElement, uuid);
        for (Element url : knowledgeSpiderConfig.webUrls) {
            if (knowledgeSpiderConfig.flag.getText().equals("jsoup")) {
                doc = getJXDocument(url.getText().trim());
                try {
                    while (true) {
                        List<Object> childLinks = doc.sel(knowledgeSpiderConfig.childLink.getText());
                        for (Object childlink : childLinks) {
                            if (StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                                childLink = knowledgeSpiderConfig.childLink.attributeValue("join") + childlink;
                                System.out.println(childLink);
                            } else{
                                childLink = (String) childlink;
                                System.out.println(childLink);
                            }
                            source=knowledgeSpiderConfig.source.getText();
                            System.out.println(source);
                            JXDocument childDocumet = getJXDocument(childLink);
                            clearType(childDocumet,knowledgeSpiderConfig);
                            clearTag(childDocumet,knowledgeSpiderConfig);
//                            clearTime(childDocumet,knowledgeSpiderConfig);
                            clearCover(doc,knowledgeSpiderConfig);
//                            clearAnthor(childDocumet,knowledgeSpiderConfig);
                            clearTitle(childDocumet,knowledgeSpiderConfig);
                            clearMain(childDocumet,knowledgeSpiderConfig);
//                            TODO
                            String knowledgeUUID=UUID.randomUUID().toString();
                            ProKnowledge perKnowledge=depositJavabean(knowledgeUUID,title,ptime, type,cover,tag,author,main,childLink,source,authorurl);
                            storeToDatabase(perKnowledge,uuid);
                            OrgKnowledge orgKnowledge=new OrgKnowledge();
                            orgKnowledge.setOuuid(uuid);
                            orgKnowledge.setTitle(title);
                            orgKnowledge.setKuuid(knowledgeUUID);
                            orgKnowledge.setSource(source);
                            OrgKnowledgeImpl orgKnowledgeImpl=new OrgKnowledgeImpl();
                            orgKnowledgeImpl.insert(orgKnowledge);
                        }
                        doc = listPageJsoup(doc, knowledgeSpiderConfig);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (knowledgeSpiderConfig.flag.getText().equals("selenium")) {
                WebDriver driver = getChromeDriver();
                doc = getJXDocument(driver, url.getText().trim());
                try {
                    while(true){
                        List<Object> childLinks = doc.sel(knowledgeSpiderConfig.childLink.getText());
                        for (Object childlink : childLinks) {
                            if (StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                                childLink = knowledgeSpiderConfig.childLink.attributeValue("join") + childlink;
                                System.out.println(childLink);
                            }else {
                                childLink = childlink.toString();
                                System.out.println(childLink);
                            }
                            source=knowledgeSpiderConfig.source.getText();
                            System.out.println(source);
                            JXDocument childDocumet = getJXDocument(childLink);
                            clearType(childDocumet,knowledgeSpiderConfig);
                            clearTag(childDocumet,knowledgeSpiderConfig);
//                            clearTime(childDocumet,knowledgeSpiderConfig);
                            clearCover(doc,knowledgeSpiderConfig);
//                            clearAnthor(childDocumet,knowledgeSpiderConfig);
                            clearTitle(childDocumet,knowledgeSpiderConfig);
                            clearMain(childDocumet,knowledgeSpiderConfig);
//                            TODO
                            String knowledgeUUID=UUID.randomUUID().toString();
                            ProKnowledge perKnowledge=depositJavabean(knowledgeUUID,title,ptime, type,cover,tag,author,main,childLink,source,authorurl);
                            storeToDatabase(perKnowledge,uuid);
                            OrgKnowledge orgKnowledge=new OrgKnowledge();
                            orgKnowledge.setOuuid(uuid);
                            orgKnowledge.setTitle(title);
                            orgKnowledge.setKuuid(knowledgeUUID);
                            orgKnowledge.setSource(source);
                            OrgKnowledgeImpl orgKnowledgeImpl=new OrgKnowledgeImpl();
                            orgKnowledgeImpl.insert(orgKnowledge);
                        }
                        doc = listPageSelenium(driver, knowledgeSpiderConfig);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 通过xpath语法  获取document树的节点  jsoup
     * @param doc
     * @param xpath
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static Object getTagOne(JXDocument doc,String xpath) throws XpathSyntaxErrorException {
        Object obj=null;
        if (StringUtils.isNotEmpty(xpath)){
            obj=doc.selOne(xpath);
        }
        if (obj==null){
            obj="null";
        }
        return obj;
    }

    /**
     * jsoup翻页
     * @param doc
     * @param knowledgeSpiderConfig
     * @return
     * @throws XpathSyntaxErrorException
     * @throws IOException
     */
    public static JXDocument listPageJsoup(JXDocument doc,KnowledgeSpiderConfig knowledgeSpiderConfig) throws XpathSyntaxErrorException, IOException {
        String next=null;
        String nexturl=null;
        JXDocument nextDocument=null;
        String oldurl=null;
        next=getTagOne(doc,knowledgeSpiderConfig.nextPage.getText()).toString();
        if (StringUtils.isNotEmpty(knowledgeSpiderConfig.nextPage.attributeValue("join"))) {
            if (next.toString().substring(0, 4).equals("http")) {
                nexturl = next.toString().replace("..", "");
            } else {
                nexturl = knowledgeSpiderConfig.nextPage.attributeValue("join") + next.toString().replace("..", "");
            }
        } else {
            nexturl = next.toString().replace("..", "");
        }
        if(nexturl.equals(oldurl)){
            nextDocument=null;
        }else{
            nextDocument = getJXDocument(nexturl);
        }
        System.out.println("---------------"+next);
        return nextDocument;
    }

    /**
     * selenium翻页
     * @param driver
     * @param knowledgeSpiderConfig
     * @return
     * @throws InterruptedException
     */
    public static JXDocument listPageSelenium(WebDriver driver,KnowledgeSpiderConfig knowledgeSpiderConfig) throws InterruptedException {
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript(knowledgeSpiderConfig.nextPage.getText());
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if (handle.equals(handle)){
                continue;
            }else{
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement element=driver.findElement(By.xpath("/html"));

        return new JXDocument(Jsoup.parse(element.getAttribute("outerHTML")));
    }

    /**
     * 点击更多
     * @param driver
     * @param knowledgeSpiderConfig
     * @return
     * @throws InterruptedException
     */
    public static JXDocument clickMore(WebDriver driver,KnowledgeSpiderConfig knowledgeSpiderConfig) throws InterruptedException {
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript(knowledgeSpiderConfig.chose.getText());
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("/html"));
        return new JXDocument(Jsoup.parse(element.getAttribute("outerHTML")));
    }

    /**
     * 滑轮滚动
     * @param driver
     * @return
     * @throws InterruptedException
     */
    public static JXDocument slidingRoller(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("$(window).scrollTop(30000)");
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("/html"));
        return new JXDocument(Jsoup.parse(element.getAttribute("outerHTML")));
    }

    /**通过xpath语法，获取document树的结点
     *
     * @param document
     * @param xpath
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static List<JXNode> getTagN(JXDocument document,String xpath) throws XpathSyntaxErrorException {
        List<JXNode> obj=null;
        if (StringUtils.isNotEmpty(xpath)){
            obj=document.selN(xpath);
        }
        if (obj==null){
            throw new XpathSyntaxErrorException("xpath syntax error, check your xpath : " + xpath);
        }
        return obj;
    }
    /**
     * 通过xpath语法 获取document树的节点集合
     * @param document
     * @param xpath
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static  List<Object> getTag(JXDocument document, String xpath) throws XpathSyntaxErrorException {
        List<Object> obj = null;
        if(StringUtils.isNotEmpty(xpath)) {
            obj = document.sel(xpath);
        }
        if (obj == null) {
            throw new XpathSyntaxErrorException("xpath syntax error, check your xpath : " + xpath);
        }
        return obj;
    }

    /**
     * 清洗详情页的正文
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static boolean clearMain(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig) throws XpathSyntaxErrorException {
        String main=null;
        String mainPicture=null;
        if (knowledgeSpiderConfig.childnext==null){
            List<JXNode> mainList=getTagN(childDocumet,knowledgeSpiderConfig.main.getText());
            for(JXNode objmian:mainList) {
                if (StringUtils.isNotEmpty(objmian.getElement().text())) {
                    main = ("<p>" + objmian.getElement().text() + "</p>");
                }
                if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.mainPicture)) {
                    mainPicture = objmian.sel(knowledgeSpiderConfig.mainPicture.getText()).toString();
                    if (objmian.sel(knowledgeSpiderConfig.mainPicture.getText()).size() > 0) {
                        if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.attributeValue("join"))) {
                            main = ("<p>" + objmian.getElement().text() + "</p>\r\n" + ("<img src=\"" + knowledgeSpiderConfig.mainPicture.attributeValue("join") + mainPicture) + "\">").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                        } else {
                            main = ("<p>" + objmian.getElement().text() + "</p>\r\n" + "<img src=\"" + mainPicture + "\">").replace("[", "").replace("]", "").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                        }
                    } else {
                        if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.attributeValue("join"))) {
                            main = ("<p>" + objmian.getElement().text() + "</p>").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                        } else {
                            main = ("<p>" + objmian.getElement().text() + "</p>").replace("[", "").replace("]", "").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                        }
                    }

                } else {
                    List<JXNode> mainLists = getTagN(childDocumet, knowledgeSpiderConfig.main.getText());
                    for (JXNode objmians : mainLists) {
                        if (StringUtils.isNotEmpty(objmian.getElement().text())) {
                            main = ("<p>" + objmians.getElement().text() + "</p>");
                        }
                    }
                    System.out.println(main);
                }
            }
        }
        return true;
    }

    /**
     * 清洗作者信息
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearAnthor(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String anthor=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.author)) {
            try {
                System.out.println(knowledgeSpiderConfig.author.getText());
                anthor = childDocumet.selOne(knowledgeSpiderConfig.author.getText()).toString();
//                Pattern pattern=Pattern.compile(".*作者.*");
//                Matcher matcher=pattern.matcher(anthor);
//                if (matcher.find()){
//                    anthor=matcher.group(0);
//                 }
            } catch (XpathSyntaxErrorException e) {
                e.printStackTrace();
            }
            System.out.println(anthor);
        }
        return true;
    }
    /**
     * 清洗文章标题
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearTitle(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String title=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.title)) {
            try {
                title = childDocumet.selOne(knowledgeSpiderConfig.title.getText()).toString();
            } catch (XpathSyntaxErrorException e) {
                System.out.println("check your Xpath");
            }
            System.out.println(title);

        }
        return true;
    }

    /**
     * 清洗作者链接
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearAnthorUrl(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String anthorurl=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.authorUrl)) {
            try {
                anthorurl = childDocumet.selOne(knowledgeSpiderConfig.authorUrl.getText()).toString();
            } catch (XpathSyntaxErrorException e) {
                System.out.println("check your anthorurl xpath");
            }
            System.out.println(anthorurl);
        }
        return true;
    }

    /**
     * 清洗封面图片
     * @param doc
     * @param knowledgeSpiderConfig
     * @return
     * @throws XpathSyntaxErrorException
     */
    public static boolean clearCover(JXDocument doc,KnowledgeSpiderConfig knowledgeSpiderConfig) throws XpathSyntaxErrorException {
        String cover=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.cover)) {
            if (StringUtils.isNotEmpty(knowledgeSpiderConfig.cover.attributeValue("join"))) {
                cover = doc.selOne(knowledgeSpiderConfig.cover.attributeValue("join") + knowledgeSpiderConfig.cover.getText()).toString();
                System.out.println(cover);
            }
        } else {
            if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.cover)) {
                cover = doc.selOne(knowledgeSpiderConfig.cover.getText()).toString();
                System.out.println(cover);
            }
        }
        return true;
    }

    /**
     * 清洗文章时间
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearTime(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String ptime=null;
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(knowledgeSpiderConfig.ptime.attributeValue("timeFormat"));
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.ptime)) {
            try {
                System.out.println(knowledgeSpiderConfig.ptime.getText());
                ptime = childDocumet.selOne(knowledgeSpiderConfig.ptime.getText()).toString();
//                Pattern pattern=Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
//                Matcher matcher=pattern.matcher(ptime);
//                if(matcher.find()){
//                    ptime=matcher.group(0);
//                }
                    ptime=ptime.replaceAll("\\D", " ");
                    date =simpleDateFormat.parse(ptime);
                    ptime=simpleDateFormatchange.format(date);

            } catch (XpathSyntaxErrorException e) {
                System.out.println("check your ptime Xpath");
            } catch (ParseException e) {
                System.out.println("time format is failed");
            }
            System.out.println(ptime);
        }
        return true;
    }

    /**
     * 清洗文章标签
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearTag(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String tag=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.tag)) {
            try {
                tag = childDocumet.selOne(knowledgeSpiderConfig.tag.getText()).toString();
            } catch (XpathSyntaxErrorException e) {
                e.printStackTrace();
            }
            System.out.println(tag);
        }
        return true;
    }

    /**
     * 清理文章类型
     * @param childDocumet
     * @param knowledgeSpiderConfig
     * @return
     */
    public static boolean clearType(JXDocument childDocumet,KnowledgeSpiderConfig knowledgeSpiderConfig){
        String type=null;
        if (knowledgeSpiderConfig.isNotEmpty(knowledgeSpiderConfig.type)) {
            try {
                type = childDocumet.selOne(knowledgeSpiderConfig.type.getText()).toString();
            } catch (XpathSyntaxErrorException e) {
                e.printStackTrace();
            }
            System.out.println(type);
        }
        return true;
    }

    /**
     * 向JavaBean中放入数据
     * @param title
     * @param ptime
     * @param type
     * @param cover
     * @param tag
     * @param author
     * @param main

     * @param childLink
     * @param source
     * @param authorurl
     * @return
     */
    public static ProKnowledge depositJavabean(String knowledgeUUID,String title, String ptime, String type, String cover, String tag, String author, String main,String childLink, String source, String authorurl) throws ParseException, SpiderUtils.FormatEexception, LevenshteinDis.FormatEexception, SpiderUtils.FormatEexception,LevenshteinDis.FormatEexception {
        ProKnowledge proKnowledge = new ProKnowledge();
        proKnowledge.setTitle(title);
        proKnowledge.setPtime(ptime);
        proKnowledge.setType(type);
        proKnowledge.setCover(cover);
        proKnowledge.setTag(tag);
        proKnowledge.setAuthor(author);
        proKnowledge.setMain(main);
        proKnowledge.setUrl(childLink);
        proKnowledge.setSource(source);
        proKnowledge.setUuid(knowledgeUUID);
        return proKnowledge;
    }

    /**
     * 单条数据放入数据库
     * @param perKnowledge
     * @throws Exception
     */
    public static void storeToDatabase(ProKnowledge perKnowledge,String uuid) throws Exception {
        ProKnowledgeImpl perKnowledgeImpl=new ProKnowledgeImpl();
        perKnowledgeImpl.insert(perKnowledge);
    }

    /**
     * 通过公司名查找公司信息
     * @param companyName
     * @param uuid
     * @param isTrue
     * @throws InterruptedException
     */
    public static void fecthNewsByCompanyName(String companyName,String uuid,boolean isTrue) throws InterruptedException {
        String source="百度搜索_"+companyName;
        WebDriver driver=getChromeDriver();
        String url="http://news.baidu.com/ns?ct=1&rn=20&ie=utf-8&bs=intitle"+companyName+"&rsv_bp=1&sr=0&cl=2&f=8&prevct=no&tn=newstitle&word="+companyName+"&rsv_sug3=11&rsv_sug4=107&rsv_sug1=11&rsv_sug2=0&inputT=4581&rsv_sug=1";
        driver.get(url);
        WebElement element=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(element.getAttribute("outerHTML"));
        getFirstPage(doc,driver);
       try{
           String urlnext="http://news.baidu.com/ns?word=title%3A%28"+companyName+"%29&pn=20&cl=2&ct=0&tn=newstitle&rn=20&ie=utf-8&bt=0&et=0";
           driver.get(urlnext);
           WebElement elements=driver.findElement(By.xpath("/html"));
           org.jsoup.nodes.Document docnext=Jsoup.parse(elements.getAttribute("outerHTML"));
           getAllPageURL(docnext, driver);
       }catch(Exception e){
       }
        System.out.println("一共有数据"+hrefList.size()+"条");
        System.out.println("开始解析数据：");
        int i=0;
        for(int j=0;j<hrefList.size();j++){
            i++;
            try{
                    driver.get(hrefList.get(j));
                    WebElement elementDetails=driver.findElement(By.xpath("/html"));
                    org.jsoup.nodes.Document documentDetails= Jsoup.parse(elementDetails.getAttribute("outerHTML"));
                    String title=documentDetails.select("title").text();
                    System.out.println(title);
                    String time=documentDetails.select("span[class=date]").text();
                    System.out.println(time);
                    Elements elementMain=documentDetails.select("p");
                    String main=null;
                    String imgSrc=null;
                    for( org.jsoup.nodes.Element elementMains:elementMain){
                        main="<p>"+elementMains.text()+"</p>";
                        Elements elementImg=elementMains.select("img");
                        for(org.jsoup.nodes.Element elementImgs:elementImg){
                            imgSrc=elementImgs.attr("src");
                            System.out.println("<img src=\""+imgSrc+"\"/>");
                        }
                        System.out.println(main);
                    }
                System.out.println(hrefList.get(j));
               if(isTrue==true){
                       ProKnowledge proKnowledge = new ProKnowledge();
                       proKnowledge.setPtime(ptimeList.get(j));
                       System.out.println(ptimeList.get(j));
                       proKnowledge.setSource(source);
                       proKnowledge.setUrl(hrefList.get(j));
                       proKnowledge.setTitle(title);
                       proKnowledge.setUuid(uuid);
                       proKnowledge.setMain(main);
                       ProKnowledgeImpl proKnowledgeImpl = new ProKnowledgeImpl();
                       proKnowledgeImpl.insert(proKnowledge);
               }else {
                   list=proKnowledgeImpl.selectBySource(source);
                   for(String ptimelist:ptimeList){
                       int result=ptimelist.compareTo(list.toString());
                       if(result>0){
                           ProKnowledge proKnowledge=new ProKnowledge();
                           proKnowledge.setPtime(parsePtime(ptimelist));
                           proKnowledge.setSource(source);
                           proKnowledge.setUrl(hrefList.get(j));
                           proKnowledge.setTitle(title);
                           proKnowledge.setUuid(uuid);
                           proKnowledge.setMain(main);
                           ProKnowledgeImpl proKnowledgeImpl=new ProKnowledgeImpl();
                           proKnowledgeImpl.insert(proKnowledge);
                           System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
                       }
                   }
               }
                System.out.println("---------------------这是第"+i+"条数据----------------------");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取第一页的信息
     * @param doc
     * @param driver
     */
    public static void getFirstPage(org.jsoup.nodes.Document doc,WebDriver driver){
        Elements elementsPtime=doc.select("div[class=c-title-author]");
        for(org.jsoup.nodes.Element elementsPtimes:elementsPtime){
            String ptime=elementsPtimes.text().replace(Jsoup.parse("&nbsp;&nbsp;").text(),"-").split("-")[1];
            ptimeList.add(ptime);
        }
        Elements elementsHref=doc.select("h3[class=c-title] a");
        for(org.jsoup.nodes.Element elementHrefs:elementsHref){
            String href=elementHrefs.attr("href");
            hrefList.add(href);
        }
    }

    /**
     * 转化时间格式
     * @param ptime
     * @return
     * @throws ParseException
     */
    public static String parsePtime(String ptime) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=  simpleDateFormat.parse(ptime);
        ptime=simpleDateFormat1.format(date);
        return ptime;
    }

    /**
     * 得到所有的信息
     * @param doc
     * @param driver
     * @throws InterruptedException
     */
    public static void getAllPageURL(org.jsoup.nodes.Document doc,WebDriver driver) throws InterruptedException {
        while(true){
            getFirstPage(doc,driver);
            Elements elementsHref=doc.select("h3[class=c-title] a");
            for(org.jsoup.nodes.Element elementHrefs:elementsHref){
                String href=elementHrefs.attr("href");
                hrefList.add(href);
            }
            doc= listSeleniumPage(driver);
        }
    }
    /**
     * 返回页面的Document
     * @return
     */
    public static org.jsoup.nodes.Document returnPageDocument(WebDriver driver){
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handle.equals(handles)){
                continue;
            }else{
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc=Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        return doc;
    }

    /**
     * selenium方法翻页
     * @param driver
     * @return
     */
    public static org.jsoup.nodes.Document listSeleniumPage(WebDriver driver){
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("document.getElementsByClassName('n')[1].click()");
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handle.equals(handles)){
                continue;
            }else{
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement webElementMain=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document docs= Jsoup.parse(webElementMain.getAttribute("outerHTML"));
        return docs;
    }
    /**
     *
     * @param arg
     */
    public static void main(String arg[]){
        String WebName="spiderYWW";
        Document doc=obtainKnowledgeXml(SpiderContant.urlXml);
        Element  rootElement=doc.getRootElement();
        Element childElement=rootElement.element(WebName);
        String uuid=UUID.randomUUID().toString();
        try {
//            ergodicUrl("spiderHXW",SpiderContant.PerKnowledgePatternPath);
//            ergodicUrl(childElement,uuid);
            String name="完美世界";
            fecthNewsByCompanyName(name,UUID.randomUUID().toString(),true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
