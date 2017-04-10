package SpiderUtils;

import GintongameSpider.SpiderLxm.SpiderUtil;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovon on 2017/3/1.
 */
public class BasCommonKnowledgeSpider {
    public static String oldurl=null;
    public static String anthor=null;
//         1.获取配置文件 xml是什么？怎么写？用处是什么？
    public static KnowledgeSpiderConfigMiNi praseXmlContentByWebName(String webName,String urlXml) throws IOException, DocumentException, BasKnowledgeInfoDaoImpl.FormatEexception {
//      2.解析配置文件  dom4j -> SAXReader
        KnowledgeSpiderConfigMiNi knowledgeSpiderConfigMiNi=new KnowledgeSpiderConfigMiNi();
        knowledgeSpiderConfigMiNi.webUrls = new ArrayList<Element>();
//        通过SAXReader读取解析的xml文件
        Document doc=SpiderUtil.getContent(urlXml);
//        获取xml中的根元素
        Element rootElement=doc.getRootElement();
//        获取根元素中的子元素
        Element childElement=rootElement.element(webName);
//         判断urls为空
        if(childElement.element("urls")==null||childElement.element("urls").elements().size()==0){
                throw new NullPointerException("urls is null");
        }
//        遍历urls下的子元素（url）
            for (Element ele : (List<Element>) (childElement.element("urls").elements())) {
                knowledgeSpiderConfigMiNi.webUrls.add(ele);
            }
        if(childElement.element("ptime")!=null){
            knowledgeSpiderConfigMiNi.ptime = childElement.element("ptime");
        }
        if(childElement.element("flag")!=null){
            knowledgeSpiderConfigMiNi.flag=childElement.element("flag");
        }
        if(childElement.element("childLink")!=null){
            knowledgeSpiderConfigMiNi.childLink=childElement.element("childLink");
        }
        if(childElement.element("nextPage")!=null){
            knowledgeSpiderConfigMiNi.nextPage=childElement.element("nextPage");
        }
        if(childElement.element("main")!=null){
            knowledgeSpiderConfigMiNi.main=childElement.element("main");
        }
        return knowledgeSpiderConfigMiNi;
    }
//创建网络爬虫引擎

//    selenium驱动器
        public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
        return new ChromeDriver();
    }
//    phantomjs驱动器
    public static WebDriver getPhantomjsDriver(){
        System.setProperty("phantomjs.binary.path", SpiderContant.phantomjsLinuxPath);
        return new PhantomJSDriver();
    }
//    jsoup
    public static JXDocument getJXDocument(String url) throws IOException {
            JXDocument jxDocument=new JXDocument(Jsoup.connect(url.trim()).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
        return jxDocument;
    }
//    通过驱动器获取当前页面的document树
    public static JXDocument getJXDocument(WebDriver driver,String url){
        driver.get(url);
        JXDocument doc = new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
       return  doc;
    }
//    要实现的内容方法
    public static KnowledgeSpiderConfigMiNi ergodicUrl(String webName,String urlXml) throws Exception {
        int i=0;
//        定义标题变量
        String title=null;
//        定义正文变量
        String content=null;
//        定义正文时间变量
        String ptime=null;
//        定义拼接正文图片变量
        String contentImgUrl=null;
//      定义子链接变量
        String childLink=null;
        String next=null;
//        调用解析单个xml配置文件的方法praseXmlContentByWebName，参数webName
        KnowledgeSpiderConfigMiNi knowledgeSpiderConfigMiNi= BasCommonKnowledgeSpider.praseXmlContentByWebName(webName,urlXml);
//        forEach方法循环遍历knowledgeSpiderConfig.webUrls的url

        for(Element url: knowledgeSpiderConfigMiNi.webUrls) {
//            判断xml中的文件flag标签是否是jsoup
            if(knowledgeSpiderConfigMiNi.flag.getText().trim().equals("jsoup")) {
                int numPage=0;
                if(url.attributeValue("page")==null){

                JXDocument doc = BasCommonKnowledgeSpider.getJXDocument(url.getText().trim());
                while (true) {
//                通过url
                    int iNum=0;
                    numPage++;
                    List<Object> detailsUrls = doc.sel(knowledgeSpiderConfigMiNi.childLink.getText());
                    for (Object details : detailsUrls) {
                        iNum++;
                        if (StringUtils.isNotEmpty(knowledgeSpiderConfigMiNi.childLink.attributeValue("join"))) {
                            childLink = knowledgeSpiderConfigMiNi.childLink.attributeValue("join") + details;
                            JXDocument doc1 = getJXDocument(childLink);
                            title = doc1.selNOne("//title/text()").toString();
                            content = doc1.selN("//p//text()").toString();
                            String hearUrl = url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                            String partUrl = url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                            String[] sbuUrl = partUrl.split("/");
                            List<JXNode> list = doc1.selN("//p/parent::div//img/@src");
                            for (JXNode lists : list) {
                                if (!(lists.toString().substring(0, 4).equals("http"))) {
                                    if (lists.toString().contains("//")) {
                                        System.out.println("图片路径：" + lists);
                                    } else {
                                        contentImgUrl = sbuUrl[0] + lists;
                                        System.out.println("补充图片路径：" + contentImgUrl);
//                                        SpiderUtil.isUrlCorrect(contentImgUrl);
                                    }
                                } else {
                                    contentImgUrl = lists.toString();
                                    System.out.println("全图片路径：" + contentImgUrl);
                                }
                            }
                            if (StringUtils.isEmpty(knowledgeSpiderConfigMiNi.ptime.getText())) {
                                Pattern pattern = Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
                                Matcher match = pattern.matcher(doc1.selN("//body/allText()").toString());
                                if (match.find()) {
                                    ptime = match.group(0);
                                    if (ptime.contains("/") || ptime.contains("年") || ptime.contains("月") || ptime.contains("日")) {
                                        ptime = ptime.replaceAll("/", "-");
                                        ptime = ptime.replace("年", "-");
                                        ptime = ptime.replace("月", "-");
                                        ptime = ptime.replace("日", "-");
                                    }
                                }
                            } else {
                                ptime = doc1.selOne(knowledgeSpiderConfigMiNi.ptime.getText()).toString();
                                if (ptime.contains("/") || ptime.contains("年") || ptime.contains("月") || ptime.contains("日")) {
                                    ptime = ptime.replaceAll("/", "-");
                                    ptime = ptime.replace("年", "-");
                                    ptime = ptime.replace("月", "-");
                                    ptime = ptime.replace("日", "-");
                                }
                            }
                            System.out.println(ptime);
                            System.out.println(title);
                            System.out.println(content);
                            System.out.println(childLink);

                        } else {
                            childLink = (String) details;
                            JXDocument doc1 = getJXDocument(childLink);
                            title = doc1.selNOne("//title/text()").toString();
                            content = doc1.selN("//p//text()").toString();
                            String hearUrl = url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                            String partUrl = url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                            String[] sbuUrl = partUrl.split("/");
                            List<JXNode> list = doc.selN("//p/parent::div//img/@src");
                            for (JXNode lists : list) {
                                if (!(lists.toString().substring(0, 4).equals("http"))) {
                                    if (lists.toString().contains("//")) {
                                        System.out.println("图片路径：" + lists);
                                    } else {
                                        contentImgUrl = sbuUrl[0] + lists;
                                        System.out.println("补充图片路径：" + contentImgUrl);
                                        SpiderUtil.isUrlCorrect(contentImgUrl);
                                    }
                                } else {
                                    contentImgUrl = lists.toString();
                                    System.out.println("全图片路径：" + contentImgUrl);
                                }
                            }
                            System.out.println(title);
                            System.out.println(content);
                            System.out.println(childLink);
                        }
                        System.out.println("--------------这是第"+numPage+"页的第"+iNum+"条数据-----------------");
                    }
                    doc = listPageJsoup(doc, knowledgeSpiderConfigMiNi);

                }
            }else{
                    int fromPageNum=0;
                    List<String> list=allpage(url.getText().trim(),url.attributeValue("page"),fromPageNum);
                    i++;
                    int page=0;
                    for (String urls:list){
                        int num=0;
                        page++;
                        System.out.println("----+++++----+++++-----+++++------++++"+urls);
                        JXDocument doc=getJXDocument(urls);
                        List<Object> detailsUrls=doc.sel(knowledgeSpiderConfigMiNi.childLink.getText());
                        for (Object details : detailsUrls) {
                            num++;
                            if (StringUtils.isNotEmpty(knowledgeSpiderConfigMiNi.childLink.attributeValue("join"))) {
                                if(details.toString().contains("..")){
                                    details=details.toString().replace("..", "");
                                }
                                childLink = knowledgeSpiderConfigMiNi.childLink.attributeValue("join") + details;
                                JXDocument doc1 = getJXDocument(childLink);
                                title = doc1.selNOne("//title/text()").toString();
                                content = doc1.selN("//p//text()").toString();
                                String hearUrl = url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                                String partUrl = url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                                String[] sbuUrl = partUrl.split("/");
                                List<JXNode> listSrc = doc1.selN("//p/parent::div//img/@src");
                                for (JXNode lists : listSrc) {
                                    if (!(lists.toString().substring(0, 4).equals("http"))) {
                                        if (lists.toString().contains("//")) {
                                            System.out.println("图片路径：" + lists);
                                        } else {
                                            contentImgUrl = sbuUrl[0] + lists;
                                            System.out.println("补充图片路径：" + contentImgUrl);
                                        }
                                    } else {
                                        contentImgUrl = lists.toString();
                                        System.out.println("全图片路径：" + contentImgUrl);
                                    }
                                }
                                if (StringUtils.isEmpty(knowledgeSpiderConfigMiNi.ptime.getText())) {
                                    Pattern pattern = Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
                                    Matcher match = pattern.matcher(doc1.selN("//body/allText()").toString());
                                    if (match.find()) {
                                        ptime = match.group(0);
                                        if (ptime.contains("/") || ptime.contains("年") || ptime.contains("月") || ptime.contains("日")) {
                                            ptime = ptime.replaceAll("/", "-");
                                            ptime = ptime.replace("年", "-");
                                            ptime = ptime.replace("月", "-");
                                            ptime = ptime.replace("日", "-");
                                        }
                                    }
                                } else {
                                    ptime = doc1.selOne(knowledgeSpiderConfigMiNi.ptime.getText()).toString();
                                    if (ptime.contains("/") || ptime.contains("年") || ptime.contains("月") || ptime.contains("日")) {
                                        ptime = ptime.replaceAll("/", "-");
                                        ptime = ptime.replace("年", "-");
                                        ptime = ptime.replace("月", "-");
                                        ptime = ptime.replace("日", "-");
                                    }
                                }
                                System.out.println(ptime);
                                System.out.println(title);
                                System.out.println(content);
                                System.out.println(childLink);

                            } else {
                                childLink = (String) details;
                               try{
                                   JXDocument doc1 = getJXDocument(childLink);
                                   title = doc1.selNOne("//title/text()").toString();
                                   content = doc1.selN("//p//text()").toString();
                                   String hearUrl = url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                                   String partUrl = url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                                   String[] sbuUrl = partUrl.split("/");
                                   List<JXNode> listsrc = doc.selN("//p/parent::div//img/@src");
                                   for (JXNode lists : listsrc) {
                                       if (!(lists.toString().substring(0, 4).equals("http"))) {
                                           if (lists.toString().contains("//")) {
                                               System.out.println("图片路径：" + lists);
                                           } else {
                                               contentImgUrl = sbuUrl[0] + lists;
                                               System.out.println("补充图片路径：" + contentImgUrl);
                                               SpiderUtil.isUrlCorrect(contentImgUrl);
                                           }
                                       } else {
                                           contentImgUrl = lists.toString();
                                           System.out.println("全图片路径：" + contentImgUrl);
                                       }
                                   }
                                   System.out.println(title);
                                   System.out.println(content);
                                   System.out.println(childLink);
                               }catch(Exception e){

                               }
                            }
                            System.out.println("------------------------这是第"+page+"页的第"+num+"条数据---------------------------");
                        }
                    }
                }
            }else {
                int nums=0;
                    WebDriver driver=getChromeDriver();
                    JXDocument doc = getJXDocument(driver, url.getText());
                while(true){
                    int s=0;
                    List<Object> detailsUrls=doc.sel(knowledgeSpiderConfigMiNi.childLink.getText());
                    for(Object details:detailsUrls){
                        s++;
                        if (StringUtils.isNotEmpty(knowledgeSpiderConfigMiNi.childLink.attributeValue("join"))){
                            childLink=knowledgeSpiderConfigMiNi.childLink.attributeValue("join")+details;
                            JXDocument doc1=getJXDocument(childLink);
                            title =doc1.selNOne("//title/text()").toString();
                            content=doc1.selN("//p//text()").toString();
                            String hearUrl= url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                            String partUrl= url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                            String[] sbuUrl=partUrl.split("/");
                            List<JXNode> list= doc1.selN("//p/parent::div//img/@src");
                            for(JXNode lists:list){
                                if(!(lists.toString().substring(0, 4).equals("http"))){
                                    if(lists.toString().contains("//")){
                                        System.out.println("图片路径："+lists);
                                    }else{
                                        contentImgUrl=sbuUrl[0]+lists;
                                        System.out.println("补充图片路径："+contentImgUrl);
                                        try{
                                            SpiderUtil.isUrlCorrect(contentImgUrl);
                                        }catch (Exception e){
                                        }
                                    }
                                }else{
                                    contentImgUrl=lists.toString();
                                    System.out.println("全图片路径："+contentImgUrl);
                                }
                            }
                            if(StringUtils.isEmpty(knowledgeSpiderConfigMiNi.ptime.getText())){
                                Pattern pattern = Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
                                Matcher match = pattern.matcher(doc1.selN("//body/allText()").toString());
                                if (match.find()) {
                                    ptime=match.group(0);
                                    if(ptime.contains("/")||ptime.contains("年")||ptime.contains("月")||ptime.contains("日")){
                                        ptime=ptime.replaceAll("/","-");
                                        ptime=ptime.replace("年", "-");
                                        ptime=ptime.replace("月", "-");
                                        ptime=ptime.replace("日", "-");
                                    }
                                }
                            }else{
                                ptime=doc1.selOne(knowledgeSpiderConfigMiNi.ptime.getText()).toString();
                                if(ptime.contains("/")||ptime.contains("年")||ptime.contains("月")||ptime.contains("日")){
                                    ptime=ptime.replaceAll("/","-");
                                    ptime=ptime.replace("年", "-");
                                    ptime=ptime.replace("月", "-");
                                    ptime=ptime.replace("日", "-");
                                }
                            }
                            System.out.println(ptime);
                            System.out.println(title);
                            System.out.println(content);
                            System.out.println(childLink);
                        }else{
                            childLink= (String) details;
                            JXDocument doc1=getJXDocument(childLink);
                            title =doc1.selNOne("//title/text()").toString();
                            content=doc1.selN("//p//text()").toString();
                            String hearUrl= url.getText().trim().replaceAll("(http:\\/\\/)(.*)\\/(.*)", "$1");
                            String partUrl= url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
                            String[] sbuUrl=partUrl.split("/");
                            List<JXNode> list= doc.selN("//p/parent::div//img/@src");
                            for(JXNode lists:list){
                                if(!(lists.toString().substring(0, 4).equals("http"))){
                                    if(lists.toString().contains("//")){
                                        System.out.println("图片路径："+lists);
                                    }else{
                                        contentImgUrl=sbuUrl[0]+lists;
                                        System.out.println("补充图片路径："+contentImgUrl);
//                                        SpiderUtil.isUrlCorrect(contentImgUrl);
                                    }
                                }else{
                                    contentImgUrl=lists.toString();
                                    System.out.println("全图片路径："+contentImgUrl);

                                }
                            }
                            System.out.println(title);
                            System.out.println(content);
                            System.out.println(childLink);
                        }
                        SpiderUtil.storeToDatabase(SpiderUtil.depositJavabean(title,ptime,content,"null",anthor));
                        System.out.println("------------这是第"+nums+"的第"+s+"条数据--------------------");
                    }
                    doc=listPageSelenium(driver,knowledgeSpiderConfigMiNi);
                    nums++;
                }

            }
        }

        return knowledgeSpiderConfigMiNi;
    }
    /**
     * 通过xpath语法 获取document树的节点  jsoup
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
    public static JXDocument listPageJsoup(JXDocument doc,KnowledgeSpiderConfigMiNi knowledgeSpiderConfig) throws XpathSyntaxErrorException, IOException {
        String next=null;
        String nexturl=null;
        JXDocument nextDocument=null;
        String oldurl=null;
        next=getTagOne(doc,knowledgeSpiderConfig.nextPage.getText()).toString();
        System.out.println();
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
        oldurl=nexturl;
        return nextDocument;
    }


    /**
     * 通过xpath语法 获取document树的节点 selenium
     * @param document
     * @param xpath
     * @return
     * @throws XpathSyntaxErrorException
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
     * selenium翻页
     * @param driver
     * @param knowledgeSpiderConfig
     * @return
     * @throws InterruptedException
     */
    public static JXDocument listPageSelenium(WebDriver driver,KnowledgeSpiderConfigMiNi knowledgeSpiderConfig) throws InterruptedException {
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript(knowledgeSpiderConfig.nextPage.getText().trim());
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
     * 获取全部的链接
     * @param dynamicURL 链接
     * @param allpage 页数
     * @return 全部的链接
     */
//    TODO
    public static List  allpage(String dynamicURL,String allpage,int fromPageNum){
        List<String>list=new ArrayList<String>();
        int pages=Integer.parseInt(allpage);
        String page;
        if(fromPageNum==0){
            fromPageNum=fromPageNum+1;
        }
        for(int i=fromPageNum;i<pages+1;i++) {
            page = i+ "";
            try {
                list.add(dynamicURL.replace("$(page)", page));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;

    }
}
