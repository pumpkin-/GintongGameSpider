package SpiderUtils;

import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import JavaBean.ProKnowledge;
import org.dom4j.io.SAXReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/11.
 */
public class SpiderContant {
    //持久化存储批量插入条数
    public static final int insertBatchContant = 5;
    public static final String phantomjsLinuxPath="D:/Spider/phantomjs-2.1.1-linux-x86_64/bin/phantomjs.exe";
    public static final String chromeWindowsPath= "E:/aaaa/chrom/chromedriver.exe";
    public static final String phantomJSWindowsPath="E:/phantomjs-2.1.1-windows/bin/phantomjs";
    public static final String xmlUrl="SpiderUtils/SpiderData/BasCommonKnowledgePattern.xml";
    public static final String urlXml="SpiderUtils/BasKnowledgePattern.xml";
    public static final String orgXmlPath="/SpiderUtils/BasOrganizePattern.xml";
    public static final String PerKnowledgePatternPath="SpiderUtils/PerKnowledgePattern.xml";
    public static final String CommonMoilbeGamesProductXml="/SpiderUtils/SpiderData/CommonMobileGamesProductPattern.xml";
    public static final String CommonHTMLGamesProductXml="/SpiderUtils/SpiderData/CommonHTMLGamesProductPattern.xml";
    public static final String CommonPCGamesProductXml="/SpiderUtils/SpiderData/CommonPCGamesProductPattern.xml";


}
