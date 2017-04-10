package SpiderUtils;

import JavaBean.BasPersonInfo;
import JavaBean.BaseKnowLedge;
import JavaBean.PerKnowledge;
import JavaBean.BasKnowledgeInfo;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/17.
 */
public class KnowledgeSpiderPattern {
    private static BaseKnowLedge baseKnowledge=new BaseKnowLedge();
    private static SAXReader sax=new SAXReader();
    private static List<BasKnowledgeInfo> basKnowledgeInfoList =new ArrayList<BasKnowledgeInfo>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static BasKnowledgeInfoDaoImpl proknowimpl = new BasKnowledgeInfoDaoImpl();
    private static BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
    private static PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
    private static SimpleDateFormat simpleDateFormatchange=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //1.先获取第一页的列表页
    }

    public static class FormatEexception extends Exception
    {
        public FormatEexception(String msg)
        {
            super(msg);
        }
    }

    public static void getDocument(String flag,String url) throws FormatEexception {
        if (flag.equals("windows")) {
            System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
            baseKnowledge.setDriver(new ChromeDriver());
            baseKnowledge.getDriver().get(url);
        }else if(flag.equals("linux")){
            System.setProperty("phantomjs.binary.path",SpiderContant.phantomjsLinuxPath );
            baseKnowledge.setDriver(new PhantomJSDriver());
            baseKnowledge.getDriver().get(url);
        }else{
            throw new FormatEexception("You have to choose windows or linux");
        }
    }


    public static void getElements(String flag,String element) throws FormatEexception, DocumentException, ParserConfigurationException, XpathSyntaxErrorException, FileNotFoundException, BasKnowledgeInfoDaoImpl.FormatEexception, InterruptedException, ParseException {
        baseKnowledge.setInputStream(new FileInputStream(KnowledgeSpiderPattern.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        baseKnowledge.setDocsax(sax.read(baseKnowledge.getInputStream()));
        baseKnowledge.setRoot(baseKnowledge.getDocsax().getRootElement());//获取根元素
        Element childElement = baseKnowledge.getRoot().element(element);
        Element classifiedLink=childElement.element("urls");
        List<Element> classifiedlist=classifiedLink.elements();
        Element childLink=childElement.element("childLink");
        Element next=childElement.element("next");
        Element nextflagi=childElement.element("nextflag");
        int a=1;
        for(Element ele:classifiedlist){
            KnowledgeSpiderPattern.getDocument(flag, ele.getText().trim());
            for(int i=1;i>0;i++) {
                baseKnowledge.setWebElement(baseKnowledge.getDriver().findElement(By.xpath("/html")));
                JXDocument jxDocument =new JXDocument(Jsoup.parse(baseKnowledge.getWebElement().getAttribute("outerHTML")));
                JavascriptExecutor executor = (JavascriptExecutor) baseKnowledge.getDriver();
                executor.executeScript("window.open('" + "https://www.baidu.com/" + "')");
                String handle = baseKnowledge.getDriver().getWindowHandle();
                for (String handles : baseKnowledge.getDriver().getWindowHandles()) {
                    if (handles.equals(handle)) {
                        continue;
                    }
                    baseKnowledge.getDriver().switchTo().window(handles);
                }
                List<Object> childlist = jxDocument.sel(childLink.getText());
                for (Object obj : childlist) {

                    baseKnowledge.getDriver().get((String) obj);
                    baseKnowledge.setWebElement((WebElement) baseKnowledge.getDriver().findElement(By.xpath("/html")));
                    JXDocument jxDocumentChild=new JXDocument(Jsoup.parse(baseKnowledge.getWebElement().getAttribute("outerHTML")));
                    Element authori=childElement.element("author");
                    Element titlei = childElement.element("title");
                    Element coveri=childElement.element("cover");
                    Element tagi=childElement.element("tag");
                    Element maini=childElement.element("main");
                    Element mainipic=childElement.element("mainpic");
                    Element ptimei=childElement.element("ptime");
                    Element typei = childElement.element("type");
                    Element sourcei=childElement.element("source");


                    String puuid= UUID.randomUUID().toString();
                    String kuuid=UUID.randomUUID().toString();
                    String tag=null;
                    String main=null;
                    String type=null;
                    String author= (String) jxDocumentChild.selOne(authori.getText());
                    String title= (String) jxDocumentChild.selOne(titlei.getText());
                    String cover= "<img src=\""+jxDocumentChild.selOne(coveri.getText())+"\">";
                    String ptimetest=jxDocumentChild.selOne(ptimei.getText()).toString().replaceAll("\\D"," ").trim();
                    String source=sourcei.getText();

                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat(ptimei.attributeValue("timeFormat"));
                    Date date=simpleDateFormat.parse(ptimetest);
                    String ptime=simpleDateFormatchange.format(date);

                    System.out.println(author);
                    System.out.println(title);
                    System.out.println(cover);
                    System.out.println(ptime);
                    System.out.println(source);


                    List<Object> typelist=jxDocumentChild.sel(typei.getText());
                    for(Object objtype:typelist){
                        type=(type+","+objtype).replace("null,","");
                    }
                    List<Object> taglist=jxDocumentChild.sel(tagi.getText());
                    for(Object objtag:taglist){
                        tag=(tag+","+objtag).replace("null,","");
                    }



                    List<JXNode> mainlist=jxDocumentChild.selN(maini.getText());
                    for(JXNode objmain:mainlist){
                        if(StringUtils.isNotEmpty(objmain.getElement().text())) {
                            main = (main + "\r\n<p>" + objmain.getElement().text() + "</p>").replace("null\r\n", "");
                        }
                        if(objmain.sel(mainipic.getText()).size()>0){
                            main=(main+"\r\n<img src=\""+objmain.sel(mainipic.getText()).get(0)+"\">");
                        }
                    }



                    System.out.println(main);
                    System.out.println(tag);
                    System.out.println(type);
                    storeToDatebase(title, ptime, type, cover, tag, author, main, puuid, kuuid, (String) obj, source,flag);
                    System.out.println(a + "+" + i);
                    a++;
                    System.out.println("---------------------------------");

                }
                String handle2 = baseKnowledge.getDriver().getWindowHandle();
                baseKnowledge.getDriver().close();
                Thread.sleep(2000);
                for (String handles : baseKnowledge.getDriver().getWindowHandles()) {
                    if (handles.equals(handle2)) {
                        continue;
                    }
                    baseKnowledge.getDriver().switchTo().window(handles);
                }

                if(StringUtils.isEmpty( jxDocument.selOne(nextflagi.getText()).toString())){
                    break;
                }
                System.out.println(jxDocument.selOne(nextflagi.getText()));
                JavascriptExecutor executornext = (JavascriptExecutor) baseKnowledge.getDriver();
                executornext.executeScript(next.getText());
                String handle3 = baseKnowledge.getDriver().getWindowHandle();
                for (String handles : baseKnowledge.getDriver().getWindowHandles()) {
                    if (handles.equals(handle3)) {
                        continue;
                    }else {
                        baseKnowledge.getDriver().close();
                        baseKnowledge.getDriver().switchTo().window(handles);
                    }
                }
            }
        }
    }

    public static void storeToDatebase(String title,String ptime,String type,String cover,String tag,String author,String main,String puuid,String kuuid,String url,String source,String flag) throws BasKnowledgeInfoDaoImpl.FormatEexception, FormatEexception {
        BasKnowledgeInfo basKnowledgeInfo =new BasKnowledgeInfo();
        basKnowledgeInfo.setTitle(title);
        basKnowledgeInfo.setPtime(ptime);
        basKnowledgeInfo.setType(type);
        basKnowledgeInfo.setCover(cover);
        basKnowledgeInfo.setTag(tag);
        basKnowledgeInfo.setAuthor(author);
        basKnowledgeInfo.setMain(main);
        basKnowledgeInfo.setUrl(url);
        basKnowledgeInfo.setSource(source);
        basKnowledgeInfo.setUuid(kuuid);
        basKnowledgeInfoList.add(basKnowledgeInfo);

        PerKnowledge perKnow=new PerKnowledge();
        perKnow.setName(author);
        perKnow.setKname(title);
        perKnow.setRtype("原作者");
        perKnow.setPuuid(puuid);
        perKnow.setKuuid(kuuid);
        perKnow.setSource(source);
        perKnowledgeList.add(perKnow);

        BasPersonInfo basPerson=new BasPersonInfo();
        basPerson.setUuid(puuid);
        basPerson.setName(author);
        basPerson.setSource(source);
        basPerson.setUrl(url);
        basPersonInfoList.add(basPerson);



       /* if(flag.equals("windows")) {
            if ((proKnowledgeList.size() > 0 && proKnowledgeList.size() % SpiderContant.insertBatchContant == 0)) {
                if (proknowimpl.insertBatchAutoDedup(proKnowledgeList).get(1).equals("true")) {
                    basperimpl.insertBatch(basPersonInfoList);
                    perknowimpl.insertBatch(perKnowledgeList);
                }
                proKnowledgeList.clear();
                basPersonInfoList.clear();
                perKnowledgeList.clear();
            }
        }else if(flag.equals("linux")){
            if(proknowimpl.insertBatchAutoDedup(proKnowledgeList).get(2).equals("false")) {
                System.exit(0);
            }
            basperimpl.insertBatch(basPersonInfoList);
            perknowimpl.insertBatch(perKnowledgeList);
            proKnowledgeList.clear();
            basPersonInfoList.clear();
            perKnowledgeList.clear();
        }else{
            throw new FormatEexception("You have to choose windows or linux");
        }*/
    }

}
