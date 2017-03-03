package SpiderUtils;

import JavaBean.*;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import dao.ProGameInfoDao;
import dao.ProGamePlatformDao;
import dao.ProGameTypeDao;
import dao.impl.*;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 游戏产品信息爬取
 * Created by gao on 2017/2/21.
 */
public class SpiderProduct {

    public static void main(String[] args) throws Exception {
        //ergodicUrl("SpiderYYW",0);
        ergodicUrl("Spider52PK",0);
    }

    /**
     * 遍历urls内部url
     */
    public static void ergodicUrl(String webname,int fromPageNum) throws Exception {
        System.out.println("Start parsing XML file");
        Map<String, Object> map = getElement(webname);
        ExecutorService pool= Executors.newFixedThreadPool(3);
        List urlNodes= (List) map.get("urls");
        for(Object ele:urlNodes){
            if(map.get("flag").equals("jsoup")) {
                Element element= (Element) ele;
                String url=element.getText().trim();
                System.out.println(url);
                final Spider s=new Spider(map, url,fromPageNum);
                //运行线程
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        s.run();
                    }
                });
                fromPageNum=0;
            }else if(map.get("flag").equals("selenium")){
                Element element= (Element) ele;
                String url=element.getText().trim();
                System.out.println("Get details page");
                final Spider s=new Spider(map, url,fromPageNum);
                WebDriver driver=s.getChromeDriver();
                s.ergodicDetails(map, driver, url, fromPageNum);
                fromPageNum=0;
                driver.close();
            }else{
                throw new XpathSyntaxErrorException("you shuould chose jsoup or selenium");
            }
        }
    }




    /**
     * 获取配置文件中要爬取的信息
     *
     * @param targetNode 目标节点
     * @throws FileNotFoundException
     */
    public static Map<String, Object> getElement(String targetNode){
        try{
            SAXReader reader = new SAXReader();
            //获取配置文档dom树
            Document dom=reader.read(SpiderProduct.class.getClassLoader().getResource("SpiderUtils/BasProductPattern.xml").getPath());
            //获取目标配置节点
            Node target=dom.selectSingleNode("//"+targetNode);
            //获取起始url
            List urls=target.selectNodes("//"+targetNode+"//url");
            //获取网站源名称
            String source=target.selectSingleNode("//"+targetNode+"/source").getText();
            //获取ContentPath
            String contentPath=target.selectSingleNode("//"+targetNode+"/contentPath").getText();
            //图标
            String logo=target.selectSingleNode("//"+targetNode+"/logo").getText();
            //名称
            String gname=target.selectSingleNode("//"+targetNode+"/gname").getText();
            //版本
            String version=target.selectSingleNode("//"+targetNode+"/version").getText();
            //分类
            String network_type=target.selectSingleNode("//"+targetNode+"/network_type").getText();
            String ptimeStr=target.selectSingleNode("//"+targetNode+"/ptime/@formatStr").getText();
            String beta_timeStr=target.selectSingleNode("//"+targetNode+"/beta_time/@formatStr").getText();
            String test_timeStr=target.selectSingleNode("//"+targetNode+"/test_time/@formatStr").getText();
            String betatest_timeStr=target.selectSingleNode("//"+targetNode+"/betatest_time/@formatStr").getText();
            String set_timeStr=target.selectSingleNode("//"+targetNode+"/set_time/@formatStr").getText();
            //大小
            String game_size=target.selectSingleNode("//"+targetNode+"/game_size").getText();
            //系统
            List<Element> platforms=target.selectNodes("//"+targetNode+"/platform");
            //资费
            String charge_mode=target.selectSingleNode("//"+targetNode+"/charge_mode").getText();
            //作者
            String develop_com=target.selectSingleNode("//"+targetNode+"/develop_com").getText();
            //简介
            String g_desc=target.selectSingleNode("//"+targetNode+"/g_desc").getText();
            //游戏截图
            String picture=target.selectSingleNode("//"+targetNode+"/picture").getText();
            //详情页url
            String detailurl=target.selectSingleNode("//"+targetNode+"/detailurl").getText();
            //下一页
            String nextpage=target.selectSingleNode("//"+targetNode+"/nextpage").getText();
            //游戏类型
            List gtypes=target.selectNodes("//"+targetNode+"//gtype");
            //游戏状态
            String dpprogress=target.selectSingleNode("//"+targetNode+"/dpprogress").getText();
            //画面风格
            String gstyle=target.selectSingleNode("//"+targetNode+"/gstyle").getText();
            //画面方式
            String gamespy=target.selectSingleNode("//"+targetNode+"/gamespy").getText();
            //游戏题材
            String gtheme=target.selectSingleNode("//"+targetNode+"/gtheme").getText();
//            <!--游戏英语名字-->
            String gename=target.selectSingleNode("//"+targetNode+"/gename").getText();
//            <!--语言-->
            String language=target.selectSingleNode("//"+targetNode+"/language").getText();
//            <!--发行商-->
            String publisher=target.selectSingleNode("//"+targetNode+"/publisher").getText();
//            <!--发行区域-->
            String issue_area=target.selectSingleNode("//"+targetNode+"/issue_area").getText();
//            <!--标签-->
            String gtags=target.selectSingleNode("//"+targetNode+"/gtags").getText();
//            <!--游戏视角-->
            String viewpoint=target.selectSingleNode("//"+targetNode+"/viewpoint").getText();
//            <!--游戏引擎-->
            String engine=target.selectSingleNode("//"+targetNode+"/engine").getText();
//            <!--游戏品级-->
            String grade=target.selectSingleNode("//"+targetNode+"/grade").getText();
//            <!--产品团队规模-->
            String scale=target.selectSingleNode("//"+targetNode+"/scale").getText();
//            <!--产品需求-->
            String pdemand=target.selectSingleNode("//"+targetNode+"/pdemand").getText();
//            <!--价格-->
            String price=target.selectSingleNode("//"+targetNode+"/price").getText();
//            <!--初版出售时间-->
            String ptime=target.selectSingleNode("//"+targetNode+"/ptime").getText();
//            <!--公测时间-->
            String beta_time=target.selectSingleNode("//"+targetNode+"/beta_time").getText();
//            <!--内测时间-->
            String test_time=target.selectSingleNode("//"+targetNode+"/test_time").getText();
//            <!--封测时间-->
            String betatest_time=target.selectSingleNode("//"+targetNode+"/betatest_time").getText();
//            <!--立项时间-->
            String set_time=target.selectSingleNode("//"+targetNode+"/set_time").getText();
//            <!--游戏官网-->
            String web=target.selectSingleNode("//"+targetNode+"/web").getText();
//            <!--运营商-->
            String operator=target.selectSingleNode("//"+targetNode+"/operator").getText();
//            <!--资料片发布时间-->
            String films_time=target.selectSingleNode("//"+targetNode+"/films_time").getText();
//            <!--下载链接-->
            String download_link=target.selectSingleNode("//"+targetNode+"/download_link").getText();
            String flag=target.selectSingleNode("//"+targetNode+"/flag").getText();
            String moreclick= target.selectSingleNode("//"+targetNode+"/moreclick").getText();
            String slidingRoller= target.selectSingleNode("//"+targetNode+"/slidingRoller").getText();
            String contentPathnext= target.selectSingleNode("//"+targetNode+"/contentPathnext").getText();
            String flagchild=target.selectSingleNode("//"+targetNode+"/flagchild").getText();
            String contentPathpic=target.selectSingleNode("//"+targetNode+"/contentPathpic").getText();
            String nextpic=target.selectSingleNode("//"+targetNode+"/nextpic").getText();


            //将上面读到的配置文件中的xpath信息返回main方法
            Map<String, Object>map=new HashMap();

            map.put("nextpic",nextpic);
            map.put("contentPathpic",contentPathpic);
            map.put("flagchild",flagchild);
            map.put("contentPathnext",contentPathnext);
            map.put("flag",flag);
            map.put("moreclick",moreclick);
            map.put("slidingRoller",slidingRoller);
            map.put("urls",urls);
            map.put("source",source);
            map.put("contentPath",contentPath);
            map.put("logo",logo);
            map.put("gname",gname);
            map.put("version",version);
            map.put("network_type",network_type);
            map.put("game_size",game_size);
            map.put("platform",platforms);
            map.put("charge_mode",charge_mode);
            map.put("develop_com",develop_com);
            map.put("g_desc",g_desc);
            map.put("picture",picture);
            map.put("detailurl",detailurl);
            map.put("gtypes",gtypes);
            map.put("nextpage",nextpage);
            map.put("dpprogress",dpprogress);
            map.put("gstyle",gstyle);
            map.put("gamespy",gamespy);
            map.put("gename",gename);
            map.put("language",language);
            map.put("publisher",publisher);
            map.put("issue_area",issue_area);
            map.put("gtags",gtags);
            map.put("viewpoint",viewpoint);
            map.put("grade",grade);
            map.put("scale",scale);
            map.put("pdemand",pdemand);
            map.put("price",price);
            map.put("ptime",ptime);
            map.put("beta_time",beta_time);
            map.put("test_time",test_time);
            map.put("betatest_time",betatest_time);
            map.put("set_time",set_time);
            map.put("web",web);
            map.put("operator",operator);
            map.put("films_time",films_time);
            map.put("download_link",download_link);
            map.put("ptimeStr",ptimeStr);
            map.put("beta_timeStr",beta_timeStr);
            map.put("test_timeStr",test_timeStr);
            map.put("betatest_timeStr",betatest_timeStr);
            map.put("set_timeStr",set_timeStr);
            map.put("gtheme",gtheme);
            map.put("engine",engine);
            return map;
        }catch(DocumentException e){
            System.out.println("配置文件获取错误！");
            return null;
        }
    }
}

//爬虫内部线程类
class Spider{
    private static Map<String, Object> map=null;
    private static String startUrl;
    private static int formpage;
    public Spider(Map<String, Object> map,String startUrl,int formpage) {
        this.map=map;
        this.startUrl=startUrl;
        this.formpage=formpage;
    }

    /**
     * 获取selenium驱动 chrome
     */
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
        return new ChromeDriver();
    }

    /**
     * 获取selenium驱动 phantomjs
     */
    public static WebDriver getPhantomDriver(){
        System.setProperty("phantomjs.binary.path", "/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
        return new PhantomJSDriver();
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
        return new JXDocument(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").timeout(100000).get());
    }

    /**
     * 根据url获取详情页 selenium
     */
    public static void ergodicDetails(Map<String, Object> map,WebDriver driver,String startUrl,int formpage) throws Exception {
        JXDocument doc=null;
        System.out.println("Start getting starturl's DOM tree");
        doc=getJXDocument(driver,startUrl);
        //页数
        int i=1;
        //条数
        int a=1;
        //断点翻页
        for(int x=1;x<formpage;x++){
            System.out.println("Start page break");
            System.out.println("now"+"  "+x);
            doc=listPageSelenium(map,driver);
            i=x+1;
        }
        //点击更多
        if(StringUtils.isNotEmpty(map.get("moreclick").toString())){
            while(true) {
                try {
                    System.out.println("Start clicking more");
                    doc = clickMore(map, driver);
                }catch (Exception e){
                    System.out.println("More clicks or no more buttons");
                    break;
                }
                Thread.sleep(1000);
            }                                   //滑动滚轮
        }else if(StringUtils.isNotEmpty(map.get("slidingRoller").toString())){
            for(int s=0;s<Integer.parseInt(map.get("slidingRoller").toString());s++){
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
        }
        while(true){
            //获取详情页列表
            List<Object> detailsUrls=doc.sel(map.get("detailurl").toString());
            System.out.println("Start traversal details page");
            for(Object details:detailsUrls){
                String childLink=null;
                JXDocument childDocumet=null;
                if(StringUtils.isNotEmpty(map.get("contentPath").toString())){
                    childLink=map.get("contentPath").toString()+details.toString();
                }else{
                    childLink=details.toString();
                }
                System.out.println("Get details page DOM tree");
                if(map.get("flagchild").toString().equals("jsoup")) {
                    childDocumet = getJXDocument(childLink);
                }else{
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("window.open('" + "https://www.baidu.com/" + "')");
                    String handle = driver.getWindowHandle();
                    for (String handles : driver.getWindowHandles()) {
                        if (handles.equals(handle)) {
                            continue;
                        }
                        driver.switchTo().window(handles);
                    }
                    childDocumet = getJXDocument(driver,childLink);
                }
                System.out.println("Start cleaning");
                Spider.parsePage(childDocumet, map,childLink);
                System.out.println(a+"+"+i);
                a++;
                System.out.println("-------------------------------");
            }
            try {
                i++;
                if(map.get("flagchild").toString().equals("selenium")) {
                    String handle2 = driver.getWindowHandle();
                    driver.close();
                    Thread.sleep(2000);
                    for (String handles : driver.getWindowHandles()) {
                        if (handles.equals(handle2)) {
                            continue;
                        }
                        driver.switchTo().window(handles);
                    }
                    System.out.println("Start listpage");
                    if (StringUtils.isEmpty(map.get("nextpage").toString())) {
                        System.out.println("Page failure or To the last page");
                        break;
                    }
                    doc = listPageSelenium(map, driver);
                }else{
                    System.out.println("Start listpage");
                    if (StringUtils.isEmpty(map.get("nextpage").toString())) {
                        System.out.println("Page failure or To the last page");
                        break;
                    }
                    doc = listPageSelenium(map, driver);
                }
            }catch (Exception e){
                System.out.println("Page failure or To the last page");
                break;
            }
        }
    }

    /**
     * 翻页 selenium
     */
    public static JXDocument listPageSelenium(Map<String, Object> map,WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript(map.get("nextpage").toString());
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
    public static JXDocument clickMore(Map<String, Object> map,WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript(map.get("moreclick").toString());
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
     * 获取dom
     */
    public org.jsoup.nodes.Document getDocument(String url){
        try{
            org.jsoup.nodes.Document document=Jsoup.connect(url)
                    .userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)")
                    .get();
            return document;
        }catch (Exception e){
            throw new RuntimeException("===============连接网页:"+url+"失败！！！========================");
        }
    }

    //线程执行内容
    public void run() {
        JXDocument doc=null;
        org.jsoup.nodes.Document document=null;
        try{
            document=getDocument(startUrl);
            doc=new JXDocument(document);
        }catch(Exception e){
            e.printStackTrace();
        }

        //条数
        int a=1;
        //页数
        int i=1;
        while(true){
            WebDriver driver=null;
            if(map.get("flagchild").toString().equals("selenium")){
                driver=getChromeDriver();
            }
            //断点翻页
            for(int x=1;x<formpage;x++){
                System.out.println("Start page break");
                System.out.println("now"+"  "+x);
                doc=listPageJsoup(doc);
                i=x+1;
            }

            //调用下面的方法获取详情页的url列表
            List<String>detailUrls=getDetailUrls(doc,map.get("detailurl").toString());
            for(String detailUrl:detailUrls){
                try{
                    if(map.get("flagchild").toString().equals("jsoup")) {
                        org.jsoup.nodes.Document document1 = getDocument(map.get("contentPath").toString() + detailUrl);
                        //解析详情页面并且存储进数据库
                        parsePage(new JXDocument(document1), map,map.get("contentPath").toString() + detailUrl);
                        System.out.println(Thread.currentThread().getName());
                    }else{
                        System.out.println(map.get("contentPath").toString() + detailUrl);
                        JXDocument childDocumet = getJXDocument(driver,map.get("contentPath").toString() + detailUrl);
                        parsePage(childDocumet, map,map.get("contentPath").toString() + detailUrl);
                        System.out.println(Thread.currentThread().getName());
                    }
                }catch(Exception e){
                        e.printStackTrace();
                }
                System.out.println(a+"+"+i);
                a++;
                System.out.println("---------------------------------------");
            }
            if(map.get("flagchild").toString().equals("selenium")){
                driver.close();
            }
            doc=listPageJsoup(doc);
            i++;
        }
    }

    public static JXDocument listPageJsoup(JXDocument doc){
        String next=null;
        //进入下一页
        try{
            String nextUrl=null;
            try {
                //若获取下一页失败，则停止当前线程
                nextUrl = doc.sel(map.get("nextpage").toString()).get(0).toString();
            }catch (Exception e){
                return doc;
            }
            next=map.get("contentPathnext").toString()+nextUrl;
            System.out.println(next);
            org.jsoup.nodes.Document nextdocument=Jsoup.connect(next)
                    .userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)")
                    .get();
            doc=new JXDocument(nextdocument);
        }catch(Exception e){
            System.err.println(Thread.currentThread().getName()+"进入下一页错误");
        }
        return doc;
    }

    /**
     * 获取每页列表中的详情页的url
     */
    public  List<String>getDetailUrls(JXDocument document, String detailurl){
        List<Object>urllist= null;
        try {
            urllist = document.sel(detailurl);
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
        //存储每页中列表上跳转到详情页的链接
        List<String>detailUrls=new ArrayList();
        for(Object detailUrl:urllist){
            detailUrls.add((String)detailUrl);
        }
        return detailUrls;
    }

    /**
     * 解析页面获取相应的字段
     *
     * @param document
     */
    public static void parsePage(JXDocument document, Map map,String childLink){
        String logo=null;
        String name=null;
        String version=null;
        String time=null;
        String game_size=null;
        String platform=null;
        String charge_mode=null;
        String develop_com=null;
        String g_desc=null;
        String screenShots=null;
        String network_type=null;
        String source=null;
        StringBuffer gtypes=new StringBuffer();
        String dpprogress=null;
        String gstyle=null;
        String gamespy=null;
        String gtheme=null;
        String totalServer=null;
        //创建数据库表对象
        BasProGameInfo gameInfo=new BasProGameInfo();
        ProGameType progtypes=new ProGameType();
        BasOrganizeInfo basOrganizeInfo=new BasOrganizeInfo();
        OrgProduct orgProduct=new OrgProduct();
        BasOrganizeInfo basOrganizeInfo2=new BasOrganizeInfo();
        OrgProduct orgProduct2=new OrgProduct();
        BasOrganizeInfo basOrganizeInfo3=new BasOrganizeInfo();
        OrgProduct orgProduct3=new OrgProduct();
        List<ProGamePlatform> list1=new ArrayList<ProGamePlatform>();

        try{
            //源网站名称
            if(StringUtils.isNoneEmpty(map.get("source").toString())){
                source=map.get("source").toString();
                System.out.println(source);
                gameInfo.setSource(source);
                orgProduct.setSource(source);
                basOrganizeInfo.setSource(source);
                orgProduct2.setSource(source);
                basOrganizeInfo2.setSource(source);
                orgProduct3.setSource(source);
                basOrganizeInfo3.setSource(source);
            }
            //图标logo
            logo=map.get("contentPath").toString()+getInfomation(document,"logo");
            if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                logo = Jsoup.connect(logo).ignoreContentType(true).get().location();
            }
            gameInfo.setLogo(logo);
            //名称gname
            if(StringUtils.isNoneEmpty(map.get("gname").toString())){
                if(document.sel(map.get("gname").toString()).size()>0) {
                    name = document.sel(map.get("gname").toString()).get(0).toString();
                }
                System.out.println(name);
                gameInfo.setGname(name);
                orgProduct.setPname(name);
                orgProduct2.setPname(name);
                orgProduct3.setPname(name);
            }
            //版本version
            if(StringUtils.isNoneEmpty(map.get("version").toString())){
                if(document.sel(map.get("version").toString()).size()>0) {
                    version = document.sel(map.get("version").toString()).get(0).toString();
                }
                version=version.substring(1,version.lastIndexOf(")"));
                System.out.println(version);
                gameInfo.setVersion(version);
            }
            //分类(网络类型)
            if(StringUtils.isNotEmpty(map.get("network_type").toString())){
                network_type = document.sel(map.get("network_type").toString()).get(0).toString();
                //如果是安卓市场的信息，则需要做进一步处理
                if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                    network_type=network_type.split("\\：")[1];
                }
                System.out.println(network_type);
                gameInfo.setNetwork_type(getNetType(network_type));
            }else{
                network_type="0";
                gameInfo.setNetwork_type(getNetType(network_type));
            }
            //操作系统
            if(StringUtils.isNoneEmpty(map.get("platform").toString())){
                List<Element> platforms= (List<Element>) map.get("platforms");
                if(platforms!=null&&platforms.size()>0){
                    for(int x=0;x<platforms.size();x++){
                        ProGamePlatform proPlatform=new ProGamePlatform();
                        proPlatform.setPlatform(platforms.get(x).getText());
                        list1.add(proPlatform);
                    }
                }
            }
            //大小game_size
            if(StringUtils.isNotEmpty(map.get("game_size").toString())){
                List<Object> list= document.sel(map.get("game_size").toString());
                if(list!=null&&list.size()>0) {
                    for(int x=0;x<list.size();x++){
                        if(list1!=null&&list1.size()>0) {
                            list1.get(x).setGame_size(list.get(x).toString());
                        }
                        System.out.println(list.get(x).toString());
                        gameInfo.setGame_size(list.get(x).toString());
                    }
                }
            }
            //资费charge_mode
            if(StringUtils.isNotEmpty(map.get("charge_mode").toString())){
                if(document.sel(map.get("charge_mode").toString()).size()>0) {
                    charge_mode = document.sel(map.get("charge_mode").toString()).get(0).toString();
                }
                System.out.println(charge_mode);
                gameInfo.setCharge_mode(charge_mode);
            }
            //游戏研发公司（作者）develop_com
            if(StringUtils.isNotEmpty(map.get("develop_com").toString())){
                if(document.sel(map.get("develop_com").toString()).size()>0) {
                    develop_com = document.sel(map.get("develop_com").toString()).get(0).toString();
                }
                if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                    develop_com=develop_com.split("\\：")[1];
                }
                System.out.println(develop_com);
                basOrganizeInfo.setOname(develop_com);
                orgProduct.setOname(develop_com);
                orgProduct.setRtype("开发商");
            }

            //简介g_desc
            if(StringUtils.isNotEmpty(map.get("g_desc").toString())){
                if(document.sel(map.get("g_desc").toString()).size()>0) {
                    g_desc = document.sel(map.get("g_desc").toString()).get(0).toString();
                }
                System.out.println(g_desc);
                gameInfo.setG_desc(g_desc);
            }
            //游戏类型
            List<Element> eles= (List<Element>) map.get("gtypes");
            for (Element gtype : eles) {
                String gtypeStr=gtype.getText().trim();
                if(StringUtils.isNotEmpty(gtypeStr)) {
                    gtypes.append(document.sel(gtypeStr) + ",").toString();
                }

            }
            System.out.println(gtypes.toString().replace("[", "").replace("]", ""));
            progtypes.setGtype(gtypes.toString().replace("[", "").replace("]", ""));
            //游戏状态(研发进度)
            if(StringUtils.isNotEmpty(map.get("dpprogress").toString())){
                if(document.sel(map.get("dpprogress").toString()).size()>0) {
                    List<Object> list= document.sel(map.get("dpprogress").toString());
                    for(int x=0;x<list.size();x++){
                        if(list1!=null&&list1.size()>0) {
                            list1.get(x).setDpprogress(list.get(x).toString());
                        }
                        System.out.println(list.get(x).toString());
                        gameInfo.setDpprogress(list.get(x).toString());
                    }
                }
            }
            //画面风格
            if(StringUtils.isNotEmpty(map.get("gstyle").toString())){
                if(document.sel(map.get("gstyle").toString()).size()>0) {
                    gstyle = document.sel(map.get("gstyle").toString()).get(0).toString();
                }
                System.out.println(gstyle);
                gameInfo.setGstyle(gstyle);
            }
            //画面方式2D,3D
            if(StringUtils.isNotEmpty(map.get("gamespy").toString())){
                if(document.sel(map.get("gamespy").toString()).size()>0) {
                    gamespy = document.sel(map.get("gamespy").toString()).get(0).toString();
                }
                System.out.println(gamespy);
                gameInfo.setGamespy(gamespy);
            }
            //游戏题材
            if(StringUtils.isNotEmpty(map.get("gtheme").toString())){
                if(document.sel(map.get("gtheme").toString()).size()>0) {
                    gtheme = document.sel(map.get("gtheme").toString()).get(0).toString();
                }
                System.out.println(gtheme);
                gameInfo.setGtheme(gtheme);
            }
            //游戏英语名字
            String gename=getInfomation(document,"gename");
            gameInfo.setGename(gename);
//            <!--语言-->
            String language=getInfomation(document,"language");
            gameInfo.setLanguage(language);
//            <!--发行商-->
            String publisher=getInfomation(document,"publisher");
            gameInfo.setPublisher(publisher);
            basOrganizeInfo2.setOname(publisher);
            orgProduct2.setOname(publisher);
            orgProduct2.setRtype("发行商");
//            <!--发行区域-->
            String issue_area=getInfomation(document,"issue_area");
            gameInfo.setIssue_area(issue_area);
//            <!--标签-->
            String gtags=getInfomation(document,"gtags");
            gameInfo.setGtags(gtags);
//            <!--游戏视角-->
            String viewpoint=getInfomation(document,"viewpoint");
            gameInfo.setViewpoint(viewpoint);
//            <!--游戏引擎-->
            String engine=getInfomation(document,"engine");
            gameInfo.setEngine(engine);
//            <!--游戏品级-->
            String grade=getInfomation(document,"grade");
            gameInfo.setGrade(grade);
//            <!--产品团队规模-->
            String scale=getInfomation(document,"scale");
            gameInfo.setScale(scale);
//            <!--产品需求-->
            String pdemand=getInfomation(document,"pdemand");
            gameInfo.setPdemand(pdemand);
//            <!--价格-->
            String price=getInfomation(document,"price");
            gameInfo.setPrice(price);
//            <!--初版出售时间-->
            String ptime=getInfomation(document,"ptime");
            gameInfo.setPtime(ptime);
//            if(map.get("ptimeStr").toString()!=""){
//                gameInfo.setPtime(strToDate(ptime,map.get("ptimeStr").toString()));
//            }
//            <!--公测时间-->
            String beta_time=getInfomation(document,"beta_time");
            if(map.get("beta_timeStr").toString()!=""){
                gameInfo.setBeta_tume(strToDate(beta_time,map.get("beta_timeStr").toString()));
            }
//            <!--内测时间-->
            String test_time=getInfomation(document,"test_time");
            if(map.get("test_timeStr").toString()!=""){
                gameInfo.setTest_time(strToDate(test_time,map.get("test_timeStr").toString()));
            }
//            <!--封测时间-->
            String betatest_time=getInfomation(document,"betatest_time");
            if(map.get("betatest_timeStr").toString()!=""){
                gameInfo.setBetatest_time(strToDate(betatest_time,map.get("betatest_timeStr").toString()));
            }
//            <!--立项时间-->
            String set_time=getInfomation(document,"set_time");
            if(map.get("set_timeStr").toString()!=""){
                gameInfo.setSet_time(strToDate(set_time,map.get("set_timeStr").toString()));
            }
//            <!--游戏官网-->
            String web=getInfomation(document,"web");
            gameInfo.setWeb(web);
//            <!--运营商-->
            String operator=getInfomation(document,"operator");
            gameInfo.setOperator(operator);
            orgProduct3.setOname(operator);
            basOrganizeInfo3.setOname(operator);
            orgProduct3.setRtype("运营商");

//            <!--资料片发布时间-->
            String films_time=getInfomation(document,"films_time");
            gameInfo.setFilms_time(films_time);
//            <!--下载链接-->
            if(StringUtils.isNotEmpty(map.get("download_link").toString())){
                if(document.sel(map.get("download_link").toString()).size()>0) {
                    List<Object> list= document.sel(map.get("download_link").toString());
                    for(int x=0;x<list.size();x++){
                        if(list1!=null&&list1.size()>0) {
                            list1.get(x).setDownloadLink(list.get(x).toString());
                        }
                        System.out.println(list.get(x).toString());
                        gameInfo.setDownload_link(list.get(x).toString());
                    }
                }
            }
            //游戏截图picture
            if(StringUtils.isNotEmpty(map.get("picture").toString())){
                if(StringUtils.isEmpty(map.get("nextpic").toString())) {
                    List<Object> liEles = document.sel(map.get("picture").toString());
                    //多个游戏截图用“,”分隔连接为一个StringBuffer
                    StringBuffer screenBuffer = new StringBuffer();
                    for (Object ele : liEles) {
                        screenBuffer.append(ele.toString() + ",");
                    }
                    screenShots = screenBuffer.toString();
                    System.out.println(screenShots);
                    gameInfo.setPicture(screenShots);
                }else{
                    StringBuffer screenBuffer = new StringBuffer();
                    WebDriver driver=getChromeDriver();
                    String startpic=map.get("contentPathpic").toString() + document.selOne(map.get("nextpic").toString()).toString();
                    while(true){
                        List<Object> liEles = document.sel(map.get("picture").toString());
                        screenBuffer.append(liEles.toString().replace("[", "").replace("]","")+",");
                        try {
                            System.out.println(screenBuffer.toString());
                            driver.get(document.selOne(map.get("nextpic").toString()).toString());
                            Thread.sleep(2000);
                            JXDocument jxDocument = new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
                            document = jxDocument;
                            if((map.get("contentPathpic").toString() + document.selOne(map.get("nextpic").toString()).toString()).equals(startpic)){
                                driver.close();
                                break;
                            }
                        }catch (Exception e){
                            driver.close();
                            break;
                        }
                    }
                    screenShots = screenBuffer.toString();
                    gameInfo.setPicture(screenShots);
                }
            }
            //存入数据库
            storeToDataBase(gameInfo,progtypes,list1,basOrganizeInfo,orgProduct,basOrganizeInfo2,orgProduct2,basOrganizeInfo3,orgProduct3);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过xpath来获取相对应的网页信息
     */
    public static String getInfomation(JXDocument document, String xpath) throws XpathSyntaxErrorException {
        String information=null;
        String path=map.get(xpath).toString();
            if(StringUtils.isNotEmpty(path)) {
                if(document.sel(map.get(xpath).toString()).size()>0) {
                    information = document.sel(map.get(xpath).toString()).get(0).toString();
                }
                System.out.println(information);
            }
        return information;
    }

    /**
     *将数据存入mysql数据库中
     */
    public static void storeToDataBase(BasProGameInfo gameInfo, ProGameType gtypes, List<ProGamePlatform> list,BasOrganizeInfo basOrganizeInfo,OrgProduct orgProduct,BasOrganizeInfo basOrganizeInfo2,OrgProduct orgProduct2,BasOrganizeInfo basOrganizeInfo3,OrgProduct orgProduct3){
        //网站源链接
        gameInfo.setUrl(startUrl);
        String uuid=UUID.randomUUID().toString();
        //uuid
        gameInfo.setUuid(uuid);
        //用dao层接口插入数据库
        ProGameInfoDao infoDao=new ProGameInfoDaoImpl();
        infoDao.insertGame(gameInfo);

        //插入游戏类型
        ProGameTypeDao typeDao=new ProGameTypeDaoImpl();
        gtypes.setUuid(uuid);
        typeDao.insertType(gtypes);

        //插入组织表
        basOrganizeInfo.setUrl(startUrl);
       String ouuid=UUID.randomUUID().toString();
        basOrganizeInfo.setUuid(ouuid);

        basOrganizeInfo2.setUrl(startUrl);
        String ouuid2=UUID.randomUUID().toString();
        basOrganizeInfo2.setUuid(ouuid2);

        basOrganizeInfo3.setUrl(startUrl);
        String ouuid3=UUID.randomUUID().toString();
        basOrganizeInfo3.setUuid(ouuid3);

        //插入组织与产品关系表
        orgProduct.setOuuid(ouuid);
        orgProduct2.setOuuid(ouuid2);
        orgProduct3.setOuuid(ouuid3);
        orgProduct.setPr_uuid(uuid);
        orgProduct2.setPr_uuid(uuid);
        orgProduct3.setPr_uuid(uuid);

        BasOrganizeInfoImpl basOrganizeInfo1=new BasOrganizeInfoImpl();
        OrgProductDaoImpl orgProductDao=new OrgProductDaoImpl();
        if(StringUtils.isNotEmpty(basOrganizeInfo.getOname())){
            basOrganizeInfo1.insertSingle(basOrganizeInfo);
            orgProductDao.insertOPDuct(orgProduct);
        }
        if(StringUtils.isNotEmpty(basOrganizeInfo2.getOname())){
            basOrganizeInfo1.insertSingle(basOrganizeInfo2);
            orgProductDao.insertOPDuct(orgProduct2);
        }
        if(StringUtils.isNotEmpty(basOrganizeInfo3.getOname())){
            basOrganizeInfo1.insertSingle(basOrganizeInfo3);
            orgProductDao.insertOPDuct(orgProduct3);
        }



        //插入游戏平台（研发公司）
        ProGamePlatformDao platformDao = new ProGamePlatformDaoImpl();
        for(int x=0;x<list.size();x++) {
            list.get(x).setUuid(uuid);
            platformDao.insertPlatform(list.get(x));
        }

    }

    /**
     * 将时间字符串格式化为想要的格式化字符串
     */
    public static String timeFormat(String time, String formatStr)throws ParseException{
            SimpleDateFormat parse=new SimpleDateFormat(formatStr);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date dateTemp=parse.parse(time);
            String date=format.format(dateTemp);
            return date;
    }

    /**
     *将字符串转换为Date类型
     */
    public static Date strToDate(String time, String formatStr)throws ParseException{
        SimpleDateFormat parse=new SimpleDateFormat(formatStr);
        Date date=parse.parse(time);
        return date;
    }

    /**
     * 通过游戏分类字段获取对应的游戏的网络类型
     */
    public static String getNetType(String network_type){
        if(map.get("source").toString()=="游戏观察"){
            return "2";
        }
        if(network_type.equals("网络游戏")||network_type=="网络游戏"){
            return "2";
        }else{
            return "0";
        }
    }
}


