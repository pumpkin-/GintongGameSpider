package GintongameSpider.SpiderLxm;

import JavaBean.ProKnowledge;
import SpiderUtils.BaseKnowledgeSpider;
import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 刘雪明 on 2017/3/13.
 */
public class SpiderUtil {
    /**
     * 判断当前url是否能够访问成功
     * @param url
     * @return
     * @throws java.io.IOException
     */
    public static boolean isUrlCorrect(String url) throws IOException {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "changyan.sohu.com");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        header.put("Accept", "text/*,application/xml,application/xhtml+xml,image/webp,image/*,*/*;q=0.8,application/xml;q=0.9,*/*;q=0.8");
        header.put("Accept-Language", "zh-CN,zh;q=0.8");
        header.put("Accept-Charset", "	GB2312,utf-8;q=0.7,*;q=0.7");
        header.put("Connection", "keep-alive");
        int statusCode = Jsoup.connect(url) .data(header).ignoreContentType(true).timeout(10000).execute().statusCode();
        System.out.println("当前url返回的状态码 ： " + statusCode);
        if(statusCode>=200 && statusCode <= 399)
            return true;

        return false;
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
    static List<org.dom4j.Element> books;
 public static Document getContent(String url) throws DocumentException, IOException, ProKnowledgeImpl.FormatEexception {
     SAXReader saxReader=new SAXReader();
     Document doc=saxReader.read(new FileInputStream(SpiderUtils.class.getClassLoader().getResource(url).getFile()));
     return doc;
 }
}
