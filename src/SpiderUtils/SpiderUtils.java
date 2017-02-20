package SpiderUtils;

import JavaBean.BasPersonInfo;
import JavaBean.BaseKnowLedge;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.BasPersonInfoImpl;
import dao.impl.PerKnowledgeImpl;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2017/2/17.
 */
public class SpiderUtils {
    private static BaseKnowLedge baseKnowledge=new BaseKnowLedge();
    private static SAXReader sax=new SAXReader();
    private static List<ProKnowledge> proKnowledgeList=new ArrayList<ProKnowledge>();
    private static List<BasPersonInfo> basPersonInfoList=new ArrayList<BasPersonInfo>();
    private static List<PerKnowledge> perKnowledgeList=new ArrayList<PerKnowledge>();
    private static ProKnowledgeImpl proknowimpl = new ProKnowledgeImpl();
    private static BasPersonInfoImpl basperimpl = new BasPersonInfoImpl();
    private static PerKnowledgeImpl perknowimpl = new PerKnowledgeImpl();
    private static SimpleDateFormat simpleDateFormatchange=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    public static void getElements(String flag,String element) throws FormatEexception, DocumentException, ParserConfigurationException, XpathSyntaxErrorException, FileNotFoundException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {
        baseKnowledge.setInputStream(new FileInputStream(SpiderUtils.class.getClassLoader().getResource("SpiderUtils/BasKnowledgePattern.xml").getFile()));
        baseKnowledge.setDocsax(sax.read(baseKnowledge.getInputStream()));
        baseKnowledge.setRoot(baseKnowledge.getDocsax().getRootElement());//获取根元素
        Element childElement = baseKnowledge.getRoot().element(element);
        Element classifiedLink=childElement.element("urls");
        List<Element> classifiedlist=classifiedLink.elements();
        Element childLink=childElement.element("childLink");
        Element next=childElement.element("next");
        Element nextflagi=childElement.element("nextflag");

        Element authori = childElement.element("author");
        Element titlei = childElement.element("title");
        Element coveri = childElement.element("cover");
        Element tagi = childElement.element("tag");
        Element maini = childElement.element("main");
        Element mainipic = childElement.element("mainpic");
        Element ptimei = childElement.element("ptime");
        Element typei = childElement.element("type");
        Element sourcei = childElement.element("source");
        Element authorurli = childElement.element("authorurl");
        Element childnexti=childElement.element("childnext");
        Element childnextflagi=childElement.element("childnextflag");


        String author=null;
        String title=null;
        String cover=null;
        String ptimetest=null;
        String ptime=null;
        String authorurl=null;
        String Mosaic=null;

        int a=1;
        for(Element ele:classifiedlist){
            SpiderUtils.getDocument(flag, ele.getText().trim());
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


                List<Object> authorlist=null;
                List<Object> titlelist=null;
                List<Object> coverlist=null;
                List<Object> ptimetestlist=null;
                List<Object> ptimelist=new ArrayList<Object>();
                List<Object> authorurllist=null;
                if(StringUtils.isNotEmpty(authorurli.getText())) {
                    if (jxDocument.selN(authorurli.getText()).size() > 0) {
                        authorurllist = jxDocument.sel(authorurli.getText());
                    }
                }
                if(StringUtils.isNotEmpty(authori.getText())) {
                    if (jxDocument.selN(authori.getText()).size() > 0) {
                        authorlist = jxDocument.sel(authori.getText());
                    }
                }
                if(StringUtils.isNotEmpty(titlei.getText())) {
                    if (jxDocument.selN(titlei.getText()).size() > 0) {
                        titlelist = jxDocument.sel(titlei.getText());
                    }
                }
                if(StringUtils.isNotEmpty(coveri.getText())) {
                    if (jxDocument.selN(coveri.getText()).size() > 0) {
                        coverlist = jxDocument.sel(coveri.getText());
                    }
                }
                if(StringUtils.isNotEmpty(ptimei.getText())) {
                    if (jxDocument.selN(ptimei.getText()).size() > 0) {
                        ptimetestlist = jxDocument.sel(ptimei.getText());
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ptimei.attributeValue("timeFormat"));
                        for (int size = 0; size < ptimetestlist.size(); size++) {
                            Date date = simpleDateFormat.parse((String) ptimetestlist.get(size).toString().replaceAll("\\D", " ").trim());
                            ptimelist.add(simpleDateFormatchange.format(date));
                        }
                    }
                }


                for (Object obj : childlist) {
                    try {
                        String tag = null;
                        String main = null;
                        String type = null;
                        String child=null;
                        if(StringUtils.isNotEmpty(childLink.attributeValue("Mosaic"))) {
                            child = childLink.attributeValue("Mosaic") + obj;
                        }else{
                            child= (String) obj;
                        }
                        int fg=0;
                        baseKnowledge.getDriver().get((String) child);
                        baseKnowledge.setWebElement(baseKnowledge.getDriver().findElement(By.xpath("/html")));
                        JXDocument jxDocumentChild = new JXDocument(Jsoup.parse(baseKnowledge.getWebElement().getAttribute("outerHTML")));
                        String puuid = UUID.randomUUID().toString();
                        String kuuid = UUID.randomUUID().toString();


                        if(StringUtils.isNotEmpty(authori.getText())) {
                            if (jxDocument.selN(authori.getText()).size() <= 0) {
                                author = (String) jxDocumentChild.selOne(authori.getText()).toString().replace("作者：","");
                            } else {
                                author = (String) authorlist.get(fg).toString().replace("作者：","");
                            }
                        }else{
                            author=null;
                        }
                        if(StringUtils.isNotEmpty(authorurli.getText())) {
                            if (jxDocument.selN(authorurli.getText()).size() <= 0) {
                                authorurl = (String) jxDocumentChild.selOne(authorurli.getText());
                            } else {
                                authorurl = (String) authorurllist.get(fg);
                            }
                        }else{
                            authorurl= (String) child;
                        }
                        if(StringUtils.isNotEmpty(titlei.getText())) {
                            if (jxDocument.selN(titlei.getText()).size() <= 0) {
                                title = (String) jxDocumentChild.selOne(titlei.getText());
                            } else {
                                title = (String) titlelist.get(fg);
                            }
                        }else{
                            title=null;
                        }
                        if(StringUtils.isNotEmpty(coveri.getText())) {
                            if (jxDocument.selN(coveri.getText()).size() <= 0) {
                                if(StringUtils.isNotEmpty((String) jxDocumentChild.selOne(coveri.getText()))) {
                                    cover = "<img src=\"" + jxDocumentChild.selOne(coveri.getText()) + "\">";
                                }else{
                                    cover=null;
                                }
                            } else {
                                if(StringUtils.isNotEmpty((String) coverlist.get(fg))) {
                                    cover = (String) "<img src=\"" + coverlist.get(fg) + "\">";
                                }else{
                                    cover=null;
                                }
                            }
                        }else{
                            cover=null;
                        }
                        if(StringUtils.isNotEmpty(ptimei.getText())) {
                            if (jxDocument.selN(ptimei.getText()).size() <= 0) {
                                ptimetest = jxDocumentChild.selOne(ptimei.getText()).toString().replaceAll("\\D", " ").trim();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ptimei.attributeValue("timeFormat"));
                                Date date = simpleDateFormat.parse(ptimetest);
                                ptime = simpleDateFormatchange.format(date);
                            } else {
                                ptime = (String) ptimelist.get(fg);
                            }
                        }else{
                            ptime=null;
                        }

                        String source = sourcei.getText();



                        System.out.println(author);
                        System.out.println(title);
                        System.out.println(cover);
                        System.out.println(ptime);
                        System.out.println(source);

                        if(StringUtils.isNotEmpty(typei.getText())) {
                            List<Object> typelist = jxDocumentChild.sel(typei.getText());
                            for (Object objtype : typelist) {
                                type = (type + "," + objtype).replace("null,", "");
                            }
                        }else{
                            type=null;
                        }
                        if(StringUtils.isNotEmpty(tagi.getText())) {
                            List<Object> taglist = jxDocumentChild.sel(tagi.getText());
                            for (Object objtag : taglist) {
                                tag = (tag + "," + objtag).replace("null,", "");
                            }
                        }else{
                            tag=null;
                        }

                        if(StringUtils.isNotEmpty(jxDocumentChild.selOne(childnextflagi.getText()).toString())) {
                            for(int x=1;x>0;x++) {
                                List<JXNode> mainlist = jxDocumentChild.selN(maini.getText());
                                for (JXNode objmain : mainlist) {
                                    if (StringUtils.isNotEmpty(objmain.getElement().text())) {
                                        main = (main + "\r\n<p>" + objmain.getElement().text() + "</p>").replace("null\r\n", "").replace(Jsoup.parse("&nbsp;").text(), "");
                                    }
                                    if (objmain.sel(mainipic.getText()).size() > 0) {
                                        main = (main + "\r\n<img src=\"" + objmain.sel(mainipic.getText()).get(0) + "\">");
                                    }
                                }
                                if(StringUtils.isEmpty(jxDocumentChild.selOne(childnextflagi.getText()).toString())){
                                    break;
                                }
                                JavascriptExecutor executorChildnext = (JavascriptExecutor) baseKnowledge.getDriver();
                                executorChildnext.executeScript(childnexti.getText());
                            }
                        }


                        System.out.println(main);
                        System.out.println(tag);
                        System.out.println(type);
                        dataClean(title, ptime, type, cover, tag, author, main, puuid, kuuid, (String) child, source,authorurl);
                        System.out.println(a + "+" + i);
                        a++;
                        fg++;
                        System.out.println("---------------------------------");
                    }catch (Exception e){
                        System.out.println("exception");
                    }
                }
                storeToDatebase(flag,author);
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

    public static void dataClean(String title,String ptime,String type,String cover,String tag,String author,String main,String puuid,String kuuid,String url,String source,String authorurl) throws ProKnowledgeImpl.FormatEexception, FormatEexception {
        ProKnowledge proKnowledge = new ProKnowledge();
        proKnowledge.setTitle(title);
        proKnowledge.setPtime(ptime);
        proKnowledge.setType(type);
        proKnowledge.setCover(cover);
        proKnowledge.setTag(tag);
        proKnowledge.setAuthor(author);
        proKnowledge.setMain(main);
        proKnowledge.setUrl(url);
        proKnowledge.setSource(source);
        proKnowledge.setUuid(kuuid);
        proKnowledgeList.add(proKnowledge);

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
        }

    }

    public static void storeToDatebase(String flag,String author) throws FormatEexception, ProKnowledgeImpl.FormatEexception {
        if (flag.equals("windows")) {
            Map map = proknowimpl.insertBatchAutoDedup(proKnowledgeList, basPersonInfoList, perKnowledgeList);
            if (((List<Integer>) map.get(4)).get(0) != 0&&StringUtils.isNotEmpty(author)) {
                basperimpl.insertBatch((List<BasPersonInfo>) map.get(1));
                perknowimpl.insertBatch((List<PerKnowledge>) map.get(3));
            }
            proKnowledgeList.clear();
            basPersonInfoList.clear();
            perKnowledgeList.clear();
        } else if (flag.equals("linux")) {
            Map map = proknowimpl.insertBatchAutoDedup(proKnowledgeList, basPersonInfoList, perKnowledgeList);
            if (((List<String>) map.get(2)).get(0).equals("false")) {
                System.exit(0);
            }
            if (((List<Integer>) map.get(4)).get(0) != 0&&StringUtils.isNotEmpty(author)) {
                basperimpl.insertBatch(basPersonInfoList);
                perknowimpl.insertBatch(perKnowledgeList);
            }
            proKnowledgeList.clear();
            basPersonInfoList.clear();
            perKnowledgeList.clear();
        } else {
            throw new FormatEexception("You have to choose windows or linux");
        }
    }


}
