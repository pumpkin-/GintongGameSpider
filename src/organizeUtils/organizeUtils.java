package organizeUtils;

import JavaBean.OrganizeConfigure;
import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import java.io.*;
import java.text.ParseException;
import java.util.List;

/**
 * Created by lenovo on 2017/2/21.
 */
public class organizeUtils {
    public static void getElement(String flag,String element) throws IOException, DocumentException, SpiderUtils.FormatEexception, InterruptedException, XpathSyntaxErrorException, ProKnowledgeImpl.FormatEexception, ParseException {


        SAXReader saxReader = new SAXReader();
        InputStream fileInputStream=new FileInputStream("C:\\Users\\lenovo\\Desktop\\GintongGameSpider\\src\\organizeUtils\\BasKnowledgePattern.xml");
        Document docsax=saxReader.read(fileInputStream);
        Element root=docsax.getRootElement();
        Element website=root.element(element).element("knowledge").element("website");
        Element childLink=website.element("childLink");
        Element next=website.element("next");
        Element nextflagi=website.element("nextflag");

        Element authori = website.element("author");
        Element titlei = website.element("title");
        Element coveri = website.element("cover");
        Element tagi = website.element("tag");
        Element maini = website.element("main");
        Element mainipic = website.element("mainpic");
        Element ptimei = website.element("ptime");
        Element typei = website.element("type");
        Element sourcei = website.element("source");
        Element authorurli = website.element("authorurl");
        Element childnexti=website.element("childnext");
        Element childnextflagi=website.element("childnextflag");
        Element url=website.element("url");
        OrganizeConfigure organizeConfigure=new OrganizeConfigure();
        organizeConfigure.setChildLink(childLink);
        organizeConfigure.setNext(next);
        organizeConfigure.setNextflagi(nextflagi);
        organizeConfigure.setAuthori(authori);
        organizeConfigure.setTitlei(titlei);
        organizeConfigure.setCoveri(coveri);
        organizeConfigure.setTagi(tagi);
        organizeConfigure.setMaini(maini);
        organizeConfigure.setMainipic(mainipic);
        organizeConfigure.setPtimei(ptimei);
        organizeConfigure.setTypei(typei);
        organizeConfigure.setSourcei(sourcei);
        organizeConfigure.setAuthorurli(authorurli);
        organizeConfigure.setChildnexti(childnexti);
        organizeConfigure.setChildnextflagi(childnextflagi);
        organizeConfigure.setFlag(flag);

        OutputFormat format = OutputFormat.createPrettyPrint();
        // 利用格式化类对编码进行设置
        format.setEncoding("GBK");
        FileOutputStream output = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\GintongGameSpider\\src\\organizeUtils\\BasKnowledgePattern.xml");
        XMLWriter writer = new XMLWriter(output, format);

        writer.write(docsax);
        writer.flush();
        writer.close();
        SpiderUtils.getDocument(flag, url.getText());
        SpiderUtils.getData(organizeConfigure);
    }

    public static void main(String args[]) throws IOException, DocumentException, SAXException {

    }
}
