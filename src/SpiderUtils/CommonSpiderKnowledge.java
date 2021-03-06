package SpiderUtils;

import JavaBean.BasPersonInfo;
import JavaBean.BugData;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.BasPersonInfoImpl;
import dao.impl.BugDataImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * usage: 知识爬虫通用类
 * Created by Byron on 2017/2/24.
 */
public class CommonSpiderKnowledge {
    private static SimpleDateFormat simpleDateFormatchange=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    CommonSpiderKnowledge commonSpiderKnowledge = new CommonSpiderKnowledge();
    private static List<BasKnowledgeInfo> basKnowledgeInfoList =new ArrayList<BasKnowledgeInfo>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static BasKnowledgeInfoDaoImpl proknowimpl = new BasKnowledgeInfoDaoImpl();
    private static BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
    private static PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
    private static BugDataImpl bugDataimpl = new BugDataImpl();
    private static String oldurl=null;

    public static void main(String[] args) throws Exception {
//        ExecutorService pool= Executors.newFixedThreadPool(5);
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
////                    ergodicUrl("spiderZOL", 0, "no", SpiderContant.urlXml);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    /**
     * 通过xpath语法 获取document树的节点集合
     * @param document
     * @param xpath
     * @return
     * @throws cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException
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
     * 通过xpath语法 获取document树的节点
     */
    public static Object getTagOne(JXDocument document, String xpath) throws XpathSyntaxErrorException {
        Object obj=null;
        if(StringUtils.isNotEmpty(xpath)) {
            obj = document.selOne(xpath);
        }
        if(obj==null){
            obj="null";
        }
        return obj;
    }

    /**
     * 通过xpath语法 获取document树的jxnode节点
     */
    public static List<JXNode> getTagN(JXDocument document, String xpath) throws XpathSyntaxErrorException {
        List<JXNode> obj=null;
        if(StringUtils.isNotEmpty(xpath)) {
            obj = document.selN(xpath);
        }
        if(obj==null){
            throw new XpathSyntaxErrorException("xpath syntax error, check your xpath : " + xpath);
        }
        return obj;
    }


    /**
     * 通过驱动器获得当前页面的doucument树
     * @param driver
     * @return
     */
    public static JXDocument getJXDocument(WebDriver driver,String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
       return new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
    }
    /**
     * 通过驱动器获得当前页面的doucument树
     * @param url
     * @return
     */
    public static JXDocument getJXDocument(String url) throws IOException {
        JXDocument jxDocument=null;
        for(int a=1;a>=0;a++) {
            try {
                if(jxDocument!=null){
                    break;
                }
                if(a==100){
                    break;
                }
                org.jsoup.nodes.Document doc=Jsoup.connect(url.trim()).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get();
                jxDocument = new JXDocument(doc);
            } catch (Exception e) {
                System.out.println("read time out");
            }
        }
        return jxDocument;
    }

    /**
     * 解析全部配置文件 获取所有的spider节点
     * @return
     * @throws java.io.FileNotFoundException
     * @throws org.dom4j.DocumentException
     */
//    TODO
    public static List<KnowledgeSpiderConfig> parseAllConfigXml(String webname,String knowledgeConfigXmlPath) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        List<KnowledgeSpiderConfig> configs = new ArrayList<KnowledgeSpiderConfig>();
        Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource(knowledgeConfigXmlPath).getFile()));
        Element rootElemnt = dom.getRootElement();//获取根元素
        List<Element> childElements =rootElemnt.elements("spider");
        for(Element childElement:childElements) {
            //将解析完的一个爬虫配置文件添加到List中
            configs.add(parseKnowledgeSpiderConfig(childElement));
        }
        return configs;
    }

    /**
     * 解析全部配置文件 获取所有的spider节点
     * @return
     * @throws java.io.FileNotFoundException
     * @throws org.dom4j.DocumentException
     */
    public static List<KnowledgeSpiderConfig> parseAllConfigXml() throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        List<KnowledgeSpiderConfig> configs = new ArrayList<KnowledgeSpiderConfig>();
        Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        Element rootElemnt = dom.getRootElement();//获取根元素
        List<Element> childElements =rootElemnt.elements("spider");
        for(Element childElement:childElements) {
            //将解析完的一个爬虫配置文件添加到List中
            configs.add(parseKnowledgeSpiderConfig(childElement));
        }
            return configs;
    }

    /**
     * 解析单个节点
     * @param childElement
     * @return
     */
    public static KnowledgeSpiderConfig parseKnowledgeSpiderConfig(Element childElement) {
        KnowledgeSpiderConfig knowledgeSpiderConfig = new KnowledgeSpiderConfig();
        knowledgeSpiderConfig.webUrls = new ArrayList<Element>();
        //获取当前网站的所有子链接 并添加到javaBean中
        if (childElement.element("urls") == null || childElement.element("urls").elements().size() == 0) {
            throw new NullPointerException("can't find corret web urls, please check your <urls> tag in your BasKnowledgePattern.xml");
        }
        for (Element ele : (List<Element>) (childElement.element("urls")).elements()) {
            knowledgeSpiderConfig.webUrls.add(ele);
        }

        if(childElement.element("childLink")!=null){
            knowledgeSpiderConfig.childLink = childElement.element("childLink");
        }

        if (childElement.element("next") != null) {
            knowledgeSpiderConfig.nextPage = childElement.element("next");
        }
        if (childElement.element("author") != null) {
            knowledgeSpiderConfig.author = childElement.element("author");
        }
        if (childElement.element("title") != null) {
            knowledgeSpiderConfig.title = childElement.element("title");
        }
        if (childElement.element("cover") != null) {
            knowledgeSpiderConfig.cover = childElement.element("cover");
        }
        if (childElement.element("tag") != null) {
            knowledgeSpiderConfig.tag = childElement.element("tag");
        }
        if (childElement.element("main") != null) {
            knowledgeSpiderConfig.main = childElement.element("main");
        }
        if (childElement.element("mainpic") != null) {
            knowledgeSpiderConfig.mainPicture = childElement.element("mainpic");
        }
        if (childElement.element("ptime") != null) {
            knowledgeSpiderConfig.ptime = childElement.element("ptime");
        }
        if (childElement.element("type") != null) {
            knowledgeSpiderConfig.type = childElement.element("type");
        }
        if (childElement.element("source") != null) {
            knowledgeSpiderConfig.source = childElement.element("source");
        }
        if (childElement.element("authorurl") != null) {
            knowledgeSpiderConfig.authorUrl = childElement.element("authorurl");
        }
        if (childElement.element("chose") != null) {
            knowledgeSpiderConfig.chose = childElement.element("chose");
        }
        if(childElement.element("flag")!=null){
            knowledgeSpiderConfig.flag=childElement.element("flag");
        }
        if(childElement.element("childLink") != null) {
            knowledgeSpiderConfig.childLink = childElement.element("childLink");
        }
        if(childElement.element("childnext") != null) {
            knowledgeSpiderConfig.childnext = childElement.element("childnext");
        }

        if(childElement.element("nextpage")!=null){
            knowledgeSpiderConfig.nextPage=childElement.element("nextpage");
        }
        return knowledgeSpiderConfig;
    }

    /**
     * 解析单个配置文件
     * @return
     */

    public static KnowledgeSpiderConfig parseConfigXmlByWebName(String webName) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
//        配置文件对应的JavaBean
        KnowledgeSpiderConfig knowledgeSpiderConfig = new KnowledgeSpiderConfig();

        knowledgeSpiderConfig.webUrls = new ArrayList<Element>();

//        org.dom4j.Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        Document dom=saxReader.read(SpiderUtils.class.getResourceAsStream("/SpiderUtils/BasKnowledgePattern.xml"));
        Element rootElemnt = dom.getRootElement();//获取根元素
        Element childElement = rootElemnt.element(webName);

            //获取当前网站的所有子链接 并添加到javaBean中
            if(childElement.element("urls") == null || childElement.element("urls").elements().size() == 0) {
                throw new NullPointerException("can't find corret web urls, please check your <urls> tag in your BasKnowledgePattern.xml");
            }
//        获取当前元素urls下的所有子元素
            for (Element ele : (List<Element>)(childElement.element("urls")).elements()) {
                knowledgeSpiderConfig.webUrls.add(ele);
            }

            if (childElement.element("next") != null) {
                knowledgeSpiderConfig.nextPage = childElement.element("next");
            }

            if (childElement.element("author") != null) {
                knowledgeSpiderConfig.author = childElement.element("author");
            }
            if(childElement.element("title") != null) {
                knowledgeSpiderConfig.title = childElement.element("title");
            }
            if(childElement.element("cover") != null) {
                knowledgeSpiderConfig.cover = childElement.element("cover");
            }
            if(childElement.element("tag") != null) {
                knowledgeSpiderConfig.tag = childElement.element("tag");
            }
            if(childElement.element("main") != null) {
                knowledgeSpiderConfig.main = childElement.element("main");
            }
            if(childElement.element("mainpic") != null) {
                knowledgeSpiderConfig.mainPicture = childElement.element("mainpic");
            }
            if(childElement.element("ptime") != null) {
                knowledgeSpiderConfig.ptime = childElement.element("ptime");
            }
            if(childElement.element("type") != null) {
                knowledgeSpiderConfig.type = childElement.element("type");
            }
            if(childElement.element("source") != null) {
                knowledgeSpiderConfig.source = childElement.element("source");
            }
           if(childElement.element("authorurl") != null) {
               knowledgeSpiderConfig.authorUrl = childElement.element("authorurl");
           }
        if(childElement.element("childLink") != null) {
            knowledgeSpiderConfig.childLink = childElement.element("childLink");
        }
        if(childElement.element("childnext") != null) {
            knowledgeSpiderConfig.childnext = childElement.element("childnext");
        }

            if(childElement.element("chose") != null) {
                knowledgeSpiderConfig.chose = childElement.element("chose");
            }
        if(childElement.element("flag")!=null){
            knowledgeSpiderConfig.flag=childElement.element("flag");
        }
        if(childElement.element("nextpage")!=null){
            knowledgeSpiderConfig.nextPage=childElement.element("nextpage");
        }

            return knowledgeSpiderConfig;
    }
    public static KnowledgeSpiderConfig parseConfigXmlByWebName(String webName,String urlXml) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
//        配置文件对应的JavaBean
        KnowledgeSpiderConfig knowledgeSpiderConfig = new KnowledgeSpiderConfig();

        knowledgeSpiderConfig.webUrls = new ArrayList<Element>();

        Document dom =  saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource(urlXml).getFile()));
        Element rootElemnt = dom.getRootElement();//获取根元素
        Element childElement = rootElemnt.element(webName);

        //获取当前网站的所有子链接 并添加到javaBean中
        if(childElement.element("urls") == null || childElement.element("urls").elements().size() == 0) {
            throw new NullPointerException("can't find corret web urls, please check your <urls> tag in your BasKnowledgePattern.xml");
        }
//        获取当前元素urls下的所有子元素
        for (Element ele : (List<Element>)(childElement.element("urls")).elements()) {
            knowledgeSpiderConfig.webUrls.add(ele);
        }

        if (childElement.element("next") != null) {
            knowledgeSpiderConfig.nextPage = childElement.element("next");
        }

        if (childElement.element("author") != null) {
            knowledgeSpiderConfig.author = childElement.element("author");
        }
        if(childElement.element("title") != null) {
            knowledgeSpiderConfig.title = childElement.element("title");
        }
        if(childElement.element("cover") != null) {
            knowledgeSpiderConfig.cover = childElement.element("cover");
        }
        if(childElement.element("tag") != null) {
            knowledgeSpiderConfig.tag = childElement.element("tag");
        }
        if(childElement.element("main") != null) {
            knowledgeSpiderConfig.main = childElement.element("main");
        }
        if(childElement.element("mainpic") != null) {
            knowledgeSpiderConfig.mainPicture = childElement.element("mainpic");
        }
        if(childElement.element("ptime") != null) {
            knowledgeSpiderConfig.ptime = childElement.element("ptime");
        }
        if(childElement.element("type") != null) {
            knowledgeSpiderConfig.type = childElement.element("type");
        }
        if(childElement.element("source") != null) {
            knowledgeSpiderConfig.source = childElement.element("source");
        }
        if(childElement.element("authorurl") != null) {
            knowledgeSpiderConfig.authorUrl = childElement.element("authorurl");
        }
        if(childElement.element("childLink") != null) {
            knowledgeSpiderConfig.childLink = childElement.element("childLink");
        }
        if(childElement.element("childnext") != null) {
            knowledgeSpiderConfig.childnext = childElement.element("childnext");
        }

        if(childElement.element("chose") != null) {
            knowledgeSpiderConfig.chose = childElement.element("chose");
        }
        if(childElement.element("flag")!=null){
            knowledgeSpiderConfig.flag=childElement.element("flag");
        }
        if(childElement.element("nextpage")!=null){
            knowledgeSpiderConfig.nextPage=childElement.element("nextpage");
        }

        return knowledgeSpiderConfig;
    }
    /**
     * 遍历urls内部url
     */
    public static void ergodicUrl(String webname,int fromPageNum,String orgflag) throws Exception {
        System.out.println("Start parsing XML file");
        KnowledgeSpiderConfig knowledgeSpiderConfig=parseConfigXmlByWebName(webname);
        for(Element url:knowledgeSpiderConfig.webUrls){
            if(knowledgeSpiderConfig.flag.getText().equals("jsoup")) {
                System.out.println("Get details1 page");
                System.out.println("111111111111111111111"+url.getText().trim());
                ergodicDetails(knowledgeSpiderConfig, url.getText().trim(), orgflag, fromPageNum);
                fromPageNum=0;
            }else if(knowledgeSpiderConfig.flag.getText().equals("selenium")){
                System.out.println("Get details2 page");
                WebDriver driver=getChromeDriver();
                ergodicDetails(knowledgeSpiderConfig, orgflag, fromPageNum,driver,url.getText().trim());
                fromPageNum=0;
                driver.close();
            }else{
                throw new XpathSyntaxErrorException("you shuould chose jsoup or selenium");
            }
        }
    }

//    public static void ergodicUrl(String webname,int fromPageNum,String orgflag,String urlXml) throws Exception {
//        System.out.println("Start parsing XML file");
//        KnowledgeSpiderConfig knowledgeSpiderConfig=parseConfigXmlByWebName(webname,urlXml);
//        for(Element url:knowledgeSpiderConfig.webUrls){
//            if(knowledgeSpiderConfig.flag.getText().equals("jsoup")) {
//                System.out.println("Get details page");
//                ergodicDetails(knowledgeSpiderConfig, url.getText().trim(), orgflag, fromPageNum);
//                fromPageNum=0;
//            }else if(knowledgeSpiderConfig.flag.getText().equals("selenium")){
//                System.out.println("Get details page");
//                WebDriver driver=getChromeDriver();
//                ergodicDetails(knowledgeSpiderConfig, orgflag, fromPageNum,driver,url.getText().trim());
//                fromPageNum=0;
//                driver.close();
//            }else{
//                throw new XpathSyntaxErrorException("you shuould chose jsoup or selenium");
//            }
//        }
//    }

    /**
     * 通过url获取详情页 Jsoup
     */
    public static void ergodicDetails(KnowledgeSpiderConfig knowledgeSpiderConfig,String startUrl,String orgflag,int formpage) throws Exception {
        JXDocument doc=null;
        String childLink=null;
        Map<String,List<Object>> map=new HashMap<String, List<Object>>();
        System.out.println("Start getting starturl's DOM tree");
        doc=getJXDocument(startUrl);
        System.out.println("解析成功");
        //条数
        int a=1;
        //页数
        int i=1;
        //断点翻页
        for(int x=1;x<formpage;x++){
            System.out.println("Start page break");
            System.out.println("now"+"  "+x);
            doc=listPageJsoup(doc, knowledgeSpiderConfig);
            i=x+1;
        }
        while(true){
            int fg=0;
            //获取详情页列表
            List<Object> detailsUrls=doc.sel(knowledgeSpiderConfig.childLink.getText());
            //判断author列表页是否可以获取
            System.out.println("Start list page data");
            map=dataCleanList(knowledgeSpiderConfig,doc);
            System.out.println("Start traversal details page");
            for(Object details:detailsUrls){
                if(StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                    if(details.toString().substring(0,4).equals("http")) {
                        childLink = details.toString();
                    }else{
                        childLink=knowledgeSpiderConfig.childLink.attributeValue("join") + details.toString();
                    }
                }else{
                    childLink= details.toString();
                }
                System.out.println(childLink);
                System.out.println("Get details page DOM tree");
                JXDocument childDocumet=getJXDocument(childLink);
                System.out.println("Start cleaning") ;
                dataCleanDetails(knowledgeSpiderConfig, childDocumet, map, fg, childLink, i, a);
                a++;
                fg++;
            }
            System.out.println("Start storage");
            try {
                storeToDatebaseLocal(orgflag);
            }catch (Exception e){
                System.out.println("exception");
            }
            try {
                i++;
                System.out.println("Start listpage");
                doc = listPageJsoup(doc, knowledgeSpiderConfig);
                if(doc==null){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Page failure or To the next page");
                break;
            }
        }
    }

    /**
     * 翻页 Jsoup
     * @param doc
     * @param knowledgeSpiderConfig
     * @return
     * @throws cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException
     * @throws java.io.IOException
     */
    public static JXDocument listPageJsoup(JXDocument doc,KnowledgeSpiderConfig knowledgeSpiderConfig) throws XpathSyntaxErrorException, IOException {
        String nexturl=null;
        String next=null;
        JXDocument nextDocument=null;
        next = getTagOne(doc, knowledgeSpiderConfig.nextPage.getText()).toString();
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
        oldurl=nexturl;
        return nextDocument;
    }

    /**
     * 根据url获取详情页 selenium
     */
    public static void ergodicDetails(KnowledgeSpiderConfig knowledgeSpiderConfig,String orgflag,int formpage,WebDriver driver,String startUrl) throws Exception {
        JXDocument doc=null;
        String childLink=null;
        Map<String,List<Object>> map=new HashMap<String, List<Object>>();
        System.out.println("");
        doc=getJXDocument(driver,startUrl);

        //页数
        int i=1;
        //条数
        int a=1;
        //断点翻页
        for(int x=1;x<formpage;x++){
            System.out.println("Start page break");
            System.out.println("now"+"  "+x);
            doc=listPageSelenium(knowledgeSpiderConfig,driver);
            i=x+1;
        }
        //点击更多
        if(knowledgeSpiderConfig.chose.attributeValue("demand").equals("clickMore")){
            while(true) {
                try {
                    System.out.println("Start clicking more");
                    doc = clickMore(knowledgeSpiderConfig, driver);
                }catch (Exception e){
                    System.out.println("More clicks or no more buttons");
                    break;
                }
                Thread.sleep(1000);
            }                                   //滑动滚轮
        }else if(knowledgeSpiderConfig.chose.attributeValue("demand").equals("slidingRoller")){
            for(int s=0;s<Integer.parseInt(knowledgeSpiderConfig.chose.getText());s++){
                try {
                    System.out.println("Start slide roller");
                    System.out.println("now"+"  "+s);
                    doc = slidingRoller(driver);
                }catch (Exception e){
                    System.out.println("More clicks or no more buttons");
                    break;
                }
                Thread.sleep(1000);
            }
        }else if(StringUtils.isEmpty(knowledgeSpiderConfig.chose.attributeValue("demand"))){
            System.out.println("you are no demand");
        }else{
            throw new XpathSyntaxErrorException("you shuould chose clickMore or slidingRoller");
        }
        while(true){
            int fg=0;
            //获取详情页列表
            List<Object> detailsUrls=doc.sel(knowledgeSpiderConfig.childLink.getText());
            //判断author列表页是否可以获取
            System.out.println("Start list page data");
            map=dataCleanList(knowledgeSpiderConfig,doc);
            System.out.println("Start traversal details page");
            for(Object details:detailsUrls){
                if(StringUtils.isNotEmpty(knowledgeSpiderConfig.childLink.attributeValue("join"))) {
                    if(details.toString().substring(0,4).equals("http")) {
                        childLink = details.toString();
                    }else{
                        childLink=knowledgeSpiderConfig.childLink.attributeValue("join") + details.toString();
                    }
                }else{
                    childLink= details.toString();
                }
                System.out.println("Get details page DOM tree");
                JXDocument childDocumet=getJXDocument(childLink);
                System.out.println("Start cleaning");
                dataCleanDetails(knowledgeSpiderConfig,childDocumet,map,fg,childLink,i,a);
                fg++;
                a++;
            }
            System.out.println("Start storage");
            try {
                storeToDatebaseLocal(orgflag);
            }catch (Exception e){
                System.out.println("exception");
            }
            try {
                i++;
                System.out.println("Start listpage");
                if(StringUtils.isEmpty(knowledgeSpiderConfig.nextPage.getText())){
                    System.out.println("Page failure or To the last page");
                    break;
                }
                doc = listPageSelenium(knowledgeSpiderConfig, driver);
            }catch (Exception e){
                System.out.println("Page failure or To the last page");
                break;
            }
        }
    }

    /**
     * 翻页 selenium
     */
    public static JXDocument listPageSelenium(KnowledgeSpiderConfig knowledgeSpiderConfig,WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript(knowledgeSpiderConfig.nextPage.getText());
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        JXDocument jxDocument=new JXDocument(Jsoup.parse(webElement.getAttribute("outerHTML")));
        return jxDocument;
    }

    /**
     * 点击更多
     */
    public static JXDocument clickMore(KnowledgeSpiderConfig knowledgeSpiderConfig,WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript(knowledgeSpiderConfig.chose.getText());
        Thread.sleep(2000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        JXDocument nextDocument=new JXDocument(Jsoup.parse(webElement.getAttribute("outerHTML")));
        return nextDocument;
    }

    /**
     * 滑动滚轮
     */
    public static JXDocument slidingRoller(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("$(window).scrollTop(30000)");
        Thread.sleep(2000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        JXDocument nextDocument=new JXDocument(Jsoup.parse(webElement.getAttribute("outerHTML")));
        return nextDocument;
    }

    /**
     * 清洗数据 列表页
     */
    public static Map<String,List<Object>> dataCleanList(KnowledgeSpiderConfig knowledgeSpiderConfig,JXDocument doc) throws XpathSyntaxErrorException, ParseException {
        List<Object> currentPageAuthorList=null;
        List<Object> currentPageTitleList=null;
        List<Object> currentPageCoverList=null;
        List<Object> currentPagePtimetestList=null;
        List<Object> currentPagePtimeList=new ArrayList<Object>();
        List<Object> currentPageAuthorurlList=null;
        List<Object> currentPageTagsList=null;
        List<Object> currentPageTypesList=null;
        Map<String,List<Object>> map=new HashMap<String, List<Object>>();

        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.tag.getText())) {
            if (getTag(doc,knowledgeSpiderConfig.tag.getText()).size() > 0){
                currentPageTagsList = getTag(doc, knowledgeSpiderConfig.tag.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.type.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.type.getText()).size() > 0){
                currentPageTypesList = getTag(doc, knowledgeSpiderConfig.type.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.authorUrl.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.authorUrl.getText()).size() > 0) {
                currentPageAuthorurlList = getTag(doc, knowledgeSpiderConfig.authorUrl.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.author.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.author.getText()).size() > 0) {
                currentPageAuthorList=getTag(doc, knowledgeSpiderConfig.author.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.title.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.title.getText()).size() > 0) {
                currentPageTitleList = getTag(doc, knowledgeSpiderConfig.title.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.cover.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.cover.getText()).size() > 0) {
                currentPageCoverList = getTag(doc, knowledgeSpiderConfig.cover.getText());
            }
        }
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.ptime.getText())) {
            if (getTag(doc, knowledgeSpiderConfig.ptime.getText()).size() > 0) {
                currentPagePtimetestList = getTag(doc, knowledgeSpiderConfig.ptime.getText());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(knowledgeSpiderConfig.ptime.attributeValue("timeFormat"));
                for (int size = 0; size < currentPagePtimetestList.size(); size++) {
                    Date date = simpleDateFormat.parse((String) currentPagePtimetestList.get(size).toString().replaceAll("\\D", " ").trim());
                    currentPagePtimeList.add(simpleDateFormatchange.format(date));
                }
            }
        }

        map.put("author",currentPageAuthorList);
        map.put("title",currentPageTitleList);
        map.put("cover",currentPageCoverList);
        map.put("ptime",currentPagePtimeList);
        map.put("tag",currentPageTagsList);
        map.put("type",currentPageTypesList);
        map.put("authorurl",currentPageAuthorurlList);
        map.put("ptimetest",currentPagePtimetestList);
        return map;
    }


    /**
     * 清洗数据 详情页
     */
    public static void dataCleanDetails (KnowledgeSpiderConfig knowledgeSpiderConfig,JXDocument childDocumet,Map<String,List<Object>> map,int fg,String childLink,int i,int a) throws Exception {
        String main = null;
        String author=null;
        String title=null;
        String cover=null;
        String ptimetest=null;
        String ptime=null;
        String authorurl=null;
        String tag=null;
        String type = null;
        String puuid = UUID.randomUUID().toString();
        String kuuid = UUID.randomUUID().toString();


        //作者
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.author.getText())) {
            if (map.get("author")==null||map.get("author").size()<=1) {
                String test[] = getTagOne(childDocumet,knowledgeSpiderConfig.author.getText()).toString().split(" +");
                if(test.length>1) {
                    for (int y = 0; y < test.length; y++) {
                        Pattern pat = Pattern.compile(".*作者.*");
                        Matcher mat = pat.matcher(test[y]);
                        while (mat.find()) {
                            author = mat.group(0).replace("作者：", "").replace("频道作者：", "");
                        }
                    }
                }else{
                    author=getTagOne(childDocumet,knowledgeSpiderConfig.author.getText()).toString();
                }
            } else {
                try {
                    author = map.get("author").get(fg).toString().replace("作者：", "").replace("频道作者：", "");
                }catch (Exception e){
                    author=null;
                }
            }
        }else{
            author=null;
        }
        //作者链接
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.authorUrl.getText())) {
            if (map.get("authorurl")==null||map.get("authorurl").size()<=1) {
                authorurl = getTagOne(childDocumet,knowledgeSpiderConfig.authorUrl.getText()).toString();
            } else {
                try {
                    authorurl = map.get("authorurl").get(fg).toString();
                }catch (Exception e){
                    authorurl=null;
                }
            }
        }else{
            authorurl= childLink;
        }
        //标题
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.title.getText())) {
            if (map.get("title")==null||map.get("title").size()<=1) {
                title =getTagOne(childDocumet,knowledgeSpiderConfig.title.getText()).toString();
            } else {
                try {
                    title = map.get("title").get(fg).toString();
                }catch (Exception e){
                    title=null;
                }
            }
        }else{
            title=null;
        }
        //封面
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.cover.getText())) {
            if (map.get("cover")==null||map.get("cover").size()<=1) {
                if(StringUtils.isNotEmpty(knowledgeSpiderConfig.cover.attributeValue("join"))) {
                    cover = knowledgeSpiderConfig.cover.attributeValue("join")+getTagOne(childDocumet,knowledgeSpiderConfig.cover.getText()).toString();
                }else{
                    cover=getTagOne(childDocumet,knowledgeSpiderConfig.cover.getText()).toString();
                }
            } else {
                try {
                    if(StringUtils.isNotEmpty(knowledgeSpiderConfig.cover.attributeValue("join"))) {
                        cover = knowledgeSpiderConfig.cover.attributeValue("join")+map.get("cover").get(fg).toString();
                    }else{
                        cover=map.get("cover").get(fg).toString();
                    }
                }catch (Exception e){
                    cover=null;
                }
            }
        }else{
            cover=null;
        }
        //发布时间
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.ptime.getText())) {
            if (map.get("ptime")==null||map.get("ptime").size()<=1) {
                ptimetest = getTag(childDocumet, knowledgeSpiderConfig.ptime.getText()).toString().replaceAll("\\D", " ").trim();
                if (ptimetest.contains("  ")){
                    ptimetest=ptimetest.split("  ")[0];
                    System.out.println("------+++++++++++-----"+ptimetest+"-----------");
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(knowledgeSpiderConfig.ptime.attributeValue("timeFormat"));
                if(StringUtils.isNotEmpty(ptimetest)) {
                    System.out.println(ptimetest);
                    Date date = simpleDateFormat.parse(ptimetest);
                    System.out.println(date);
                    ptime = simpleDateFormatchange.format(date);
                    System.out.println(ptime);
                }
            } else {
                try {
                    ptime = map.get("ptime").get(fg).toString();
                }catch (Exception e){
                    ptime=null;
                }
            }
        }else{
            ptime=null;
        }

        //来源
        String source = knowledgeSpiderConfig.source.getText();



        System.out.println(author);
        System.out.println(title);
        System.out.println(cover);
        System.out.println(ptime);
        System.out.println(source);

        //类别
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.type.getText())) {
            if (map.get("type")==null||map.get("type").size()<=1) {
                List<Object> typelist = getTag(childDocumet,knowledgeSpiderConfig.type.getText());
                for (Object objtype : typelist) {
                    type = (type + "," + objtype).replace("null,", "");
                }
            } else {
                try {
                    type = (type + "," + map.get("type").get(fg)).replace("null,", "").replace(" ", ",");
                }catch (Exception e){
                    type=null;
                }
            }
        }else{
            type=null;
        }

        //标签
        if(StringUtils.isNotEmpty(knowledgeSpiderConfig.tag.getText())) {
            if (map.get("tag")==null||map.get("tag").size()<=1) {
                List<Object> taglist = getTag(childDocumet, knowledgeSpiderConfig.tag.getText());
                for (Object objtag : taglist) {
                    tag = (tag + "," + objtag).replace("null,", "");
                }
            } else {
                try {
                    tag = (tag + "," + map.get("tag").get(fg)).replace("null,", "").replace(" ", ",");
                }catch (Exception e){
                    tag=null;
                }
            }
        }else{
            tag=null;
        }
        //正文
        if(StringUtils.isEmpty(knowledgeSpiderConfig.childnext.getText())) {
            List<JXNode> mainlist = getTagN(childDocumet,knowledgeSpiderConfig.main.getText());
            for (JXNode objmain : mainlist) {

                if (StringUtils.isNotEmpty(objmain.getElement().text())) {
                    main = (main + "\r\n<p>" + objmain.getElement().text() + "</p>").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                }
                if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.getText())) {
                    if(objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).size()>0) {
                        try {
                            if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.attributeValue("join"))) {
                                if (!objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0).toString().substring(0, 4).equals("http")) {
                                    main = (main + "\r\n<img src=\"" + knowledgeSpiderConfig.mainPicture.attributeValue("join") + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                                } else {
                                    main = (main + "\r\n<img src=\"" + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                                }
                            } else {
                                main = (main + "\r\n<img src=\"" + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                            }
                        }catch (Exception e){
                            System.out.println("mainpic is null");
                        }
                    }
                }
            }
        }else{
            for(int x=1;x>0;x++) {
                System.out.println("-------------------"+knowledgeSpiderConfig.main.getText());
                List<JXNode> mainlist =getTagN(childDocumet, knowledgeSpiderConfig.main.getText());
                for (JXNode objmain : mainlist) {
                    if (StringUtils.isNotEmpty(objmain.getElement().text())) {
                        main = (main + "\r\n<p>" + objmain.getElement().text() + "</p>").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                    }
                    if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.getText())) {
                        if(objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).size()>0) {
                            try {
                                if (StringUtils.isNotEmpty(knowledgeSpiderConfig.mainPicture.attributeValue("join"))) {
                                    if (!objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0).toString().substring(0, 4).equals("http")) {
                                        main = (main + "\r\n<img src=\"" + knowledgeSpiderConfig.mainPicture.attributeValue("join") + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                                    } else {
                                        main = (main + "\r\n<img src=\"" + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                                    }
                                } else {
                                    main = (main + "\r\n<img src=\"" + objmain.sel(knowledgeSpiderConfig.mainPicture.getText()).get(0) + "\">");
                                }
                            }catch (Exception e){
                                System.out.println("mainpic is null");
                            }
                        }
                    }
                }
                try {
                    String childnext = null;
                    String childnexturl=null;
                    childnext = getTagOne(childDocumet, knowledgeSpiderConfig.childnext.getText()).toString();
                    if (StringUtils.isNotEmpty(knowledgeSpiderConfig.childnext.attributeValue("join"))) {
                        if (childnext.toString().substring(0, 4).equals("http")) {
                            childnexturl = childnext.toString();
                        } else {
                            childnexturl = knowledgeSpiderConfig.childnext.attributeValue("join") + childnext.toString();
                        }
                    } else {
                        childnexturl = childnext.toString();
                    }
                    JXDocument nextDocument = getJXDocument(childnexturl);
                    childDocumet = nextDocument;
                }catch (Exception e){
                    break;
                }
            }
        }
        System.out.println(main);
        System.out.println(tag);
        System.out.println(type);
//TODO
        depositJavabean(title, ptime, type, cover, tag, author, main, puuid, kuuid, (String) childLink, source, authorurl);

        System.out.println(a + "+" + i);
        System.out.println("---------------------------------");
    }

    /**
     * 向javabean中存入数据
     * @param title
     * @param ptime
     * @param type
     * @param cover
     * @param tag
     * @param author
     * @param main
     * @param puuid
     * @param kuuid
     * @param childLink
     * @param source
     * @param authorurl
     */
    public static void depositJavabean(String title, String ptime, String type, String cover, String tag, String author, String main, String puuid, String kuuid, String childLink, String source, String authorurl){
        BasKnowledgeInfo basKnowledgeInfo = new BasKnowledgeInfo();
        basKnowledgeInfo.setTitle(title);
        System.out.println("********************************"+ptime);
        basKnowledgeInfo.setPtime(ptime);
        basKnowledgeInfo.setType(type);
        basKnowledgeInfo.setCover(cover);
        basKnowledgeInfo.setTag(tag);
        basKnowledgeInfo.setAuthor(author);
        basKnowledgeInfo.setMain(main);
        basKnowledgeInfo.setUrl(childLink);
        basKnowledgeInfo.setSource(source);
        basKnowledgeInfo.setUuid(kuuid);
        BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl =new BasKnowledgeInfoDaoImpl();
        try {
            basKnowledgeInfoDaoImpl.insert(basKnowledgeInfo);
        } catch (BasKnowledgeInfoDaoImpl.FormatEexception formatEexception) {
            formatEexception.printStackTrace();
        }
        basKnowledgeInfoList.add(basKnowledgeInfo);
        if(StringUtils.isNotEmpty(author)) {
            PerKnowledge perKnow = new PerKnowledge();
            perKnow.setName(author);
            perKnow.setKname(title);
            perKnow.setRtype("原作者");
            perKnow.setPuuid(puuid);
            perKnow.setKuuid(kuuid);
            perKnow.setSource(source);
            perKnowledgeList.add(perKnow);
            BasPersonInfo basPerson = new BasPersonInfo();
            basPerson.setUuid(puuid);
            basPerson.setName(author);
            basPerson.setSource(source);
            basPerson.setUrl(authorurl);
            basPersonInfoList.add(basPerson);
            System.out.println("---------------存放bas_person_info表和per_knowledge表中-----------------");
        }else{
//            PerKnowledge perKnow = new PerKnowledge();
//            perKnow.setName("null");
//            perKnow.setKname(title);
//            perKnow.setRtype("原作者");
//            perKnow.setPuuid(puuid);
//            perKnow.setKuuid(kuuid);
//            perKnow.setSource(source);
//            perKnowledgeList.add(perKnow);
            BasPersonInfo basPerson = new BasPersonInfo();
            basPerson.setUuid(puuid);
            basPerson.setName("null");
            basPerson.setSource(source);
            basPerson.setUrl(authorurl);
            basPersonInfoList.add(basPerson);
            System.out.println("---------------作者为空，只存放bas_person_info表中-----------------");
        }
    }
/**
 *
 */


    /**
     * 数据入库 全量
     */
    public static List storeToDatebaseLocal(String orgflag)throws Exception {
        List<BasKnowledgeInfo> basKnowledgeInfoListq =new ArrayList<BasKnowledgeInfo>();
        Map map = proknowimpl.insertBatchAutoDedup(basKnowledgeInfoList, basPersonInfoList, perKnowledgeList);
        basKnowledgeInfoListq = (List<BasKnowledgeInfo>) map.get(5);
        if (((List<Integer>) map.get(4)).get(0) != 0&&basPersonInfoList.size()>0) {
            basperimpl.insertBatch((List<BasPersonInfo>) map.get(1));
            perknowimpl.insertBatch((List<PerKnowledge>) map.get(3));
        }
        if(orgflag.equals("no")) {
            basKnowledgeInfoList.clear();
        }
        basPersonInfoList.clear();
        perKnowledgeList.clear();
        return basKnowledgeInfoListq;
    }


    /**
     * 数据入库 增量
     *
     */
    public static void storeToDatebaseLocalLinux(String orgflag) throws Exception {
        Map map = proknowimpl.insertBatchAutoDedup(basKnowledgeInfoList, basPersonInfoList, perKnowledgeList);
        if (((List<String>) map.get(2)).get(0).equals("false")) {
            System.exit(0);
        }
        if (((List<Integer>) map.get(4)).get(0) != 0&&basPersonInfoList.size()>0) {
            basperimpl.insertBatch(basPersonInfoList);
            perknowimpl.insertBatch(perKnowledgeList);
        }
        basKnowledgeInfoList.clear();
        basPersonInfoList.clear();
        perKnowledgeList.clear();
    }



    public static void storeBugdata(String key,String value,String uuid,String source){
        BugData bugData=new BugData();
        bugData.setKey(key);
        bugData.setValue(value);
        bugData.setUuid(uuid);
        bugData.setSource(source);
        bugDataimpl.insert(bugData);
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
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
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
