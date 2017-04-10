package organizeUtils;

import JavaBean.*;
import SpiderUtils.SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.BasOrganizeInfoImpl;
import dao.impl.OrgKnowledgeImpl;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/21.
 */
public class organizeUtils {
    private static BasOrganizeInfoImpl basOrganizeInfo=new BasOrganizeInfoImpl();
    private static OrgKnowledgeImpl orgKnowledgeimpl=new OrgKnowledgeImpl();
    private static List<BasKnowledgeInfo> basKnowledgeInfoList =new ArrayList<BasKnowledgeInfo>();

    public static void getElement(String flag,String element,int page,String orgflag) throws IOException, DocumentException, SpiderUtils.FormatEexception, InterruptedException, XpathSyntaxErrorException, BasKnowledgeInfoDaoImpl.FormatEexception, ParseException {
        SAXReader saxReader = new SAXReader();
        InputStream fileInputStream=new FileInputStream("C:\\Users\\lenovo\\Desktop\\GintongGameSpider\\src\\organizeUtils\\BasKnowledgePattern.xml");
        Document docsax=saxReader.read(fileInputStream);
        Element root=docsax.getRootElement();
        Element uuidi=root.element(element).element("uuid");
        Element onamei=root.element(element).element("oname");
        Element website=root.element(element).element("knowledge").element("website");
        Element classifiedLink=website.element("urls");
        List<Element> classifiedlist=classifiedLink.elements();
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
        Element morei=website.element("more");
        Element moreflag=website.element("moreflag");

        OrganizeConfigure organizeConfigure=new OrganizeConfigure();
        organizeConfigure.setPage(page);
        organizeConfigure.setMore(morei);
        organizeConfigure.setMoreflag(moreflag);
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

      /*  OutputFormat format = OutputFormat.createPrettyPrint();
        // 利用格式化类对编码进行设置
        format.setEncoding("GBK");
        FileOutputStream output = new FileOutputStream("C:\\Users\\lenovo\\Desktop\\GintongGameSpider\\src\\organizeUtils\\BasKnowledgePattern.xml");
        XMLWriter writer = new XMLWriter(output, format);

        writer.write(docsax);
        writer.flush();
        writer.close();*/

        for(Element ele:classifiedlist){
            SpiderUtils.getDocument(flag, ele.getText().trim());
            basKnowledgeInfoList =SpiderUtils.getData(organizeConfigure,orgflag);
        }
        storeOrg(uuidi.getText(),onamei.getText(), basKnowledgeInfoList);
        SpiderUtils.baseKnowledge.getDriver().close();
        System.exit(0);
    }

    public static void storeOrg(String uuid,String oname,List<BasKnowledgeInfo> basKnowledgeInfoListq) throws FileNotFoundException, DocumentException {
        if(StringUtils.isEmpty(uuid)){
            String ouuid= UUID.randomUUID().toString();
            BasOrganizeInfo basOrganizeInfos=new BasOrganizeInfo();
            basOrganizeInfos.setOname(oname);
            basOrganizeInfos.setUuid(ouuid);
            basOrganizeInfos.setCompany_nature("gintong");
            basOrganizeInfo.insertSingle(basOrganizeInfos);
            for(int x=0;x< basKnowledgeInfoListq.size();x++) {
                OrgKnowledge orgKnowledge = new OrgKnowledge();
                orgKnowledge.setOname(oname);
                orgKnowledge.setOuuid(ouuid);
                orgKnowledge.setKuuid(basKnowledgeInfoListq.get(x).getUuid());
                orgKnowledge.setTitle(basKnowledgeInfoListq.get(x).getTitle());
                orgKnowledgeimpl.insert(orgKnowledge);
            }
        }

    }

}
