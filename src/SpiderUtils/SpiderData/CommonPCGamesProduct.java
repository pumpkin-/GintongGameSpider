package SpiderUtils.SpiderData;

import JavaBean.BasProGameInfo;
import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import com.inet.tds.e;
import dao.impl.ProGameInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

/**
 * Created by lenovon on 2017/3/13.
 */
public class CommonPCGamesProduct {
    public static CommonPCGamesProductConfig parseConfigXmlByWebName(String webName) throws DocumentException {
        CommonPCGamesProductConfig commonPCGamesProductConfig=new CommonPCGamesProductConfig();
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read(StringUtils.class.getResourceAsStream(SpiderContant.CommonPCGamesProductXml));
        Element rootElement=doc.getRootElement();
        Element childElement=rootElement.element(webName);
        if(StringUtils.isNotEmpty(childElement.element("logo").getText())){
            commonPCGamesProductConfig.logo=childElement.element("logo");
        }
        if (StringUtils.isNotEmpty(childElement.element("title").getText())){
            commonPCGamesProductConfig.title=childElement.element("title");
        }
        if (StringUtils.isNotEmpty(childElement.element("develop_com").getText())){
            commonPCGamesProductConfig.develop_com=childElement.element("develop_com");
        }
        if (StringUtils.isNotEmpty(childElement.element("contentPic").getText())){
            commonPCGamesProductConfig.contentPic=childElement.element("contentPic");
        }
        if (StringUtils.isNotEmpty(childElement.element("content").getText())){
            commonPCGamesProductConfig.content=childElement.element("content");
        }
        if (StringUtils.isNotEmpty(childElement.element("childLink").getText())){
            commonPCGamesProductConfig.childLink=childElement.element("childLink");
        }
        if(StringUtils.isNotEmpty(childElement.element("nextPage").getText())){
            commonPCGamesProductConfig.nextPage=childElement.element("nextPage");
        }
        if(StringUtils.isNotEmpty(childElement.element("webURL").getText())){
            commonPCGamesProductConfig.webURL=childElement.element("webURL");
        }
        if(StringUtils.isNotEmpty(childElement.element("source").getText())){
            commonPCGamesProductConfig.source=childElement.element("source");
        }
        return commonPCGamesProductConfig;
    }
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url.trim()).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
    public static JXDocument listPageJsoup(JXDocument doc, CommonPCGamesProductConfig commonPCGamesProductConfig) throws XpathSyntaxErrorException, IOException {
        String next=null;
        String nexturl=null;
        JXDocument nextDocument=null;
        String oldurl=null;
        next=getTagOne(doc,commonPCGamesProductConfig.nextPage.getText()).toString();
        if (StringUtils.isNotEmpty(commonPCGamesProductConfig.nextPage.attributeValue("join"))) {
            if (next.toString().substring(0, 4).equals("http")) {
                nexturl = next.toString().replace("..", "");
            } else {
                nexturl = commonPCGamesProductConfig.nextPage.attributeValue("join") + next.toString().replace("..", "");
            }
        } else {
            nexturl = next.toString().replace("..", "");
        }
        if(nexturl.equals(oldurl)){
            nextDocument=null;
        }else{
            nextDocument = getJXDocument(nexturl);
        }
        return nextDocument;
    }

    public static Object getTagOne(JXDocument doc,String xpath) throws XpathSyntaxErrorException {
        Object obj=null;
        if (StringUtils.isNotEmpty(xpath)){
            obj=doc.selOne(xpath);
        }
        if (obj==null){
            obj="null";
        }
        return obj;
    }
    public static void ergodicUrl(String WebName,String url,String uuid) throws DocumentException, IOException, XpathSyntaxErrorException {
        String childLink=null;
        String mains=null;
        String webURL=null;
        int num=0;
        CommonPCGamesProductConfig commonPCGamesProductConfig=parseConfigXmlByWebName(WebName);
        JXDocument doc=getJXDocument(url);
        List<Object> list=doc.sel(commonPCGamesProductConfig.childLink.getText());
        while(true){
            num++;
            int i=0;
            List<Object> listURL=doc.sel(commonPCGamesProductConfig.childLink.getText());
            for (Object PageUrl:listURL){
                i++;
                if(StringUtils.isNotEmpty(commonPCGamesProductConfig.childLink.attributeValue("join"))){
                    childLink=commonPCGamesProductConfig.childLink.attributeValue("join")+PageUrl;
                }else{
                    childLink=(String)PageUrl;
                }
                JXDocument childDocument=getJXDocument(childLink);
                String logo=childDocument.sel(commonPCGamesProductConfig.logo.getText()).toString();
                String title=childDocument.sel(commonPCGamesProductConfig.title.getText()).toString();
                String contentPic=childDocument.sel(commonPCGamesProductConfig.contentPic.getText()).toString();
                List<JXNode> contents=childDocument.selN(commonPCGamesProductConfig.content.getText());
                    String develop_com= childDocument.selN(commonPCGamesProductConfig.develop_com.getText()).toString();
                    System.out.println(develop_com);
                   if (childDocument.selOne(commonPCGamesProductConfig.webURL.getText())!=null){
                       webURL=childDocument.selOne(commonPCGamesProductConfig.webURL.getText()).toString();
                       System.out.println(webURL);
                   }

                String source=commonPCGamesProductConfig.source.getText();
                for(JXNode main:contents){
                    mains=("<p>"+main.getElement().text()+"</p>");
                    System.out.println(mains);
                }
                System.out.println(logo);
                System.out.println(title);
                System.out.println(contentPic);
                System.out.println(source);
                BasProGameInfo basProGameInfo=new BasProGameInfo();
                basProGameInfo.setLogo(logo);
                basProGameInfo.setG_desc(mains);
                basProGameInfo.setGname(title);
                basProGameInfo.setWeb(webURL);
                basProGameInfo.setPicture(contentPic);
                ProGameInfoDaoImpl proGameInfoDaoImpl=new ProGameInfoDaoImpl();
                proGameInfoDaoImpl.insertGame(basProGameInfo);
                System.out.println("++++++++++++++-----------这是第"+num+"页的第"+i+"条数据---------------++++++++++++++++++++++");
            }
            doc=listPageJsoup(doc,commonPCGamesProductConfig);
        }
    }
}
