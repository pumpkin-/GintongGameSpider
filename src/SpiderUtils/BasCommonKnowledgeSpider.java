package SpiderUtils;

import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
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
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        if(childElement.element("ptime")!=null){
            knowledgeSpiderConfig.ptime = childElement.element("ptime");
        }
        if(childElement.element("flag")!=null){
            knowledgeSpiderConfig.flag=childElement.element("flag");
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
        System.setProperty("phantomjs.binary.path",SpiderContant.phantomjsLinuxPath);
        return new PhantomJSDriver();
    }
//    通过驱动器获取当前页面的document树
    public static JXDocument getJXDocument(WebDriver driver,String url){
        driver.get(url);
        JXDocument doc = new JXDocument(Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML")));
       return  doc;
    }
//    抓取文章的标题
    public static void ergodicUrl(WebDriver driver,String webName) throws Exception {
        String title=null;
        String content=null;
        String ptime=null;
        String contentImgUrl=null;
        KnowledgeSpiderConfig knowledgeSpiderConfig= BasCommonKnowledgeSpider.praseXmlContentByWebName(webName);
        for(Element url: knowledgeSpiderConfig.webUrls) {
            JXDocument doc = getJXDocument(driver, url.getText());
            title =doc.selNOne("//title/text()").toString();
           content=doc.selN("//p//text()").toString();
           String partUrl= url.getText().trim().replaceAll("(http:)\\/\\/(.*)\\/(.*)", "$2");
            String[] sbuUrl=partUrl.split("/");
            System.out.println(sbuUrl[0]);
           List<JXNode> list= doc.selN("//p/parent::div//img/@src");
            for(JXNode lists:list){
                if(!(lists.toString().substring(0, 4).equals("http"))){
                    if(lists.toString().contains("//")){
                        System.out.println("图片路径："+lists);
                    }else{
                        contentImgUrl=sbuUrl[0]+lists;
                        System.out.println("补充图片路径："+contentImgUrl);
                    }
                }else{
                    contentImgUrl=lists.toString();
                    System.out.println("全图片路径："+contentImgUrl);
                }
            }


            if(StringUtils.isEmpty(knowledgeSpiderConfig.ptime.getText())){
                Pattern pattern = Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
                Matcher match = pattern.matcher(doc.selN("//body/allText()").toString());
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
                if((String) doc.selOne(knowledgeSpiderConfig.ptime.getText())==null){
                    Pattern pattern = Pattern.compile("[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}\\D\\d{1,2}\\D\\d{1,2}\\D\\d{0,2}|[0-9]{4}\\D[0-9]{1,2}\\D[0-9]{1,2}");
                    Matcher match = pattern.matcher(doc.selN("//body/allText()").toString());
                    if (match.find()) {
                        ptime=match.group(0);
                        if(ptime.contains("/")||ptime.contains("年")||ptime.contains("月")||ptime.contains("日")){
                            ptime=ptime.replaceAll("/","-");
                            ptime=ptime.replace("年", "-");
                            ptime=ptime.replace("月", "-");
                            ptime=ptime.replace("日", "-");
                        }
                    }
                }else {
                    ptime=doc.selOne(knowledgeSpiderConfig.ptime.getText()).toString();
                    if(ptime.contains("/")||ptime.contains("年")||ptime.contains("月")||ptime.contains("日")){
                        ptime=ptime.replaceAll("/","-");
                        ptime=ptime.replace("年", "-");
                        ptime=ptime.replace("月", "-");
                        ptime=ptime.replace("日", "-");
                    }
                }
            }
            System.out.println("标题：" + title);
            System.out.println("正文:"+content);
            System.out.println("时间："+ptime);
        }

        storeToDatabase(depositJavabean(title,ptime,content,"null"));
    }

    /**
     * 向JavaBean中放数据
     * @param title
     * @param ptime
     * @param main
     * @param source
     */
    public static ProKnowledge depositJavabean(String title, String ptime, String main, String source ){
        ProKnowledge proKnowledge = new ProKnowledge();
        proKnowledge.setTitle(title);
        proKnowledge.setPtime(ptime);
        proKnowledge.setMain(main);
        proKnowledge.setSource(source);
        proKnowledge.setUuid(UUID.randomUUID().toString());
        return proKnowledge;
    }

    /**
     * 写入数据库
     * @param knowledge
     * @throws ProKnowledgeImpl.FormatEexception
     */
    public static void storeToDatabase(ProKnowledge knowledge) throws Exception {
        ProKnowledgeImpl proImpl = new ProKnowledgeImpl();
        if(LevenshteinDis.isExist(knowledge))
             proImpl.insert(knowledge);
    }

    public static void main(String[] args) throws FileNotFoundException, DocumentException, XpathSyntaxErrorException {
        ExecutorService pool= Executors.newSingleThreadExecutor();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    BasCommonKnowledgeSpider.ergodicUrl(getChromeDriver(),"spiderUrl");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
