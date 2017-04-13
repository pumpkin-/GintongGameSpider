package SpiderUtils;

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

    //组织生态框架中脉脉微博人物的新增时间（2个月）
    public static final int ecologyOrgInsertPer=480;
    //组织生态框架中脉脉微博人物的更改时间时间（6个月）
    public static final int ecologyOrgUpdatePer=1440;
    //组织生态框架中知识的增量时间设置（2个月  ）
    public static final int ecologyOrgKnowledgeTime=480;

    public static final String PersonKnowledgeType="10001";
    public static final String OrgKnowledgeType="10002";
    public static final String ProductKnowledgeType="10003";

}
