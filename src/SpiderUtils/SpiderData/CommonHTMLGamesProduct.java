package SpiderUtils.SpiderData;

import JavaBean.BasProGameInfo;
import JavaBean.ProGameInfo;
import JavaBean.ProGameType;
import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.ProGameInfoDaoImpl;
import dao.impl.ProGameTypeDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovon on 2017/3/13.
 */
public class CommonHTMLGamesProduct {
    public static CommonHTMLGamesProductConfig parseConfigXmlByWebName(String webName) throws DocumentException {
        CommonHTMLGamesProductConfig commonHTMLGamesProductConfig=new CommonHTMLGamesProductConfig();
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read(StringUtils.class.getResourceAsStream(SpiderContant.CommonHTMLGamesProductXml));
        Element rootElement=doc.getRootElement();
        Element childElement=rootElement.element(webName);
        if(StringUtils.isNotEmpty(childElement.element("logo").getText())){
            commonHTMLGamesProductConfig.logo=childElement.element("logo");
        }
        if (StringUtils.isNotEmpty(childElement.element("title").getText())){
            commonHTMLGamesProductConfig.title=childElement.element("title");
        }
        if (StringUtils.isNotEmpty(childElement.element("develop_com").getText())){
            commonHTMLGamesProductConfig.develop_com=childElement.element("develop_com");
        }
        if (StringUtils.isNotEmpty(childElement.element("contentPic").getText())){
            commonHTMLGamesProductConfig.contentPic=childElement.element("contentPic");
        }
        if (StringUtils.isNotEmpty(childElement.element("content").getText())){
            commonHTMLGamesProductConfig.content=childElement.element("content");
        }
        if (StringUtils.isNotEmpty(childElement.element("childLink").getText())){
            commonHTMLGamesProductConfig.childLink=childElement.element("childLink");
        }
        if(StringUtils.isNotEmpty(childElement.element("nextPage").getText())){
            commonHTMLGamesProductConfig.nextPage=childElement.element("nextPage");
        }
        if(StringUtils.isNotEmpty(childElement.element("webURL").getText())){
            commonHTMLGamesProductConfig.webURL=childElement.element("webURL");
        }
        if(StringUtils.isNotEmpty(childElement.element("source").getText())){
            commonHTMLGamesProductConfig.source=childElement.element("source");
        }
        if(StringUtils.isNotEmpty(childElement.element("gtheme").getText())){
            commonHTMLGamesProductConfig.gtheme=childElement.element("gtheme");
        }
        if(StringUtils.isNotEmpty(childElement.element("gamespy").getText())){
            commonHTMLGamesProductConfig.gamespy=childElement.element("gamespy");
        }
        if (StringUtils.isNotEmpty(childElement.element("gameType").getText())){
            commonHTMLGamesProductConfig.gameType=childElement.element("gameType");
        }
        return commonHTMLGamesProductConfig;
    }
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url.trim()).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
    public static JXDocument listPageJsoup(JXDocument doc, CommonHTMLGamesProductConfig commonHTMLGamesProductConfig) throws XpathSyntaxErrorException, IOException {
        String next=null;
        String nexturl=null;
        JXDocument nextDocument=null;
        String oldurl=null;
        next=getTagOne(doc,commonHTMLGamesProductConfig.nextPage.getText()).toString();
        if (StringUtils.isNotEmpty(commonHTMLGamesProductConfig.nextPage.attributeValue("join"))) {
            if (next.toString().substring(0, 4).equals("http")) {
                nexturl = next.toString().replace("..", "");
            } else {
                nexturl = commonHTMLGamesProductConfig.nextPage.attributeValue("join") + next.toString().replace("..", "");
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
        int num=0;
        CommonHTMLGamesProductConfig commonHTMLGamesProductConfig=parseConfigXmlByWebName(WebName);
        JXDocument doc=getJXDocument(url);
        List<Object> list=doc.sel(commonHTMLGamesProductConfig.childLink.getText());
        while(true){
            num++;
            int i=0;
            List<Object> listURL=doc.sel(commonHTMLGamesProductConfig.childLink.getText());
            for (Object PageUrl:listURL){
                i++;
                if(StringUtils.isNotEmpty(commonHTMLGamesProductConfig.childLink.attributeValue("join"))){
                    childLink=commonHTMLGamesProductConfig.childLink.attributeValue("join")+PageUrl;
                }else{
                    childLink=(String)PageUrl;
                }
                JXDocument childDocument=getJXDocument(childLink);
                String logo=childDocument.sel(commonHTMLGamesProductConfig.logo.getText()).toString();
                String title=childDocument.sel(commonHTMLGamesProductConfig.title.getText()).toString();
                String contentPic=childDocument.sel(commonHTMLGamesProductConfig.contentPic.getText()).toString();
                List<JXNode> contents=childDocument.selN(commonHTMLGamesProductConfig.content.getText());
                String develop_com= childDocument.selOne(commonHTMLGamesProductConfig.develop_com.getText()).toString();
                String webURL=childDocument.selOne(commonHTMLGamesProductConfig.webURL.getText()).toString();
                String gtheme=childDocument.selOne(commonHTMLGamesProductConfig.gtheme.getText()).toString();
                String gamespy=childDocument.selOne(commonHTMLGamesProductConfig.gamespy.getText()).toString();
                String gameType=childDocument.selOne(commonHTMLGamesProductConfig.gameType.getText()).toString();
                String source=commonHTMLGamesProductConfig.source.getText();
                for(JXNode main:contents){
                    mains =("<p>"+main.getElement().text()+"</p>");
                    System.out.println(mains);
                }
                System.out.println(logo);
                System.out.println(title);
                System.out.println(contentPic);
                System.out.println(develop_com);
                System.out.println(webURL);
                System.out.println(source);
                System.out.println(gtheme);
                System.out.println(gamespy);
                System.out.println(gameType);
                ProGameInfoDaoImpl proGameInfoDaoImpl=new ProGameInfoDaoImpl();
                List<String> lists= proGameInfoDaoImpl.selectAllGame(source);
               if(!lists.contains(title)){
                   BasProGameInfo proGameInfo=new BasProGameInfo();
                   proGameInfo.setUuid(uuid);
                   proGameInfo.setUrl((String) PageUrl);
                   proGameInfo.setSource(source);
                   proGameInfo.setLogo(logo);
                   proGameInfo.setGname(title);
                   proGameInfo.setGtheme(gtheme);
                   proGameInfo.setGamespy(gamespy);
                   proGameInfo.setG_desc(mains);
                   proGameInfo.setWeb(webURL);
                   proGameInfo.setPicture(contentPic);
                   proGameInfoDaoImpl.insertGame(proGameInfo);
                   ProGameType proGameType=new ProGameType();
                   proGameType.setUuid(uuid);
                   if(gameType.contains("：")){
                       gameType=gameType.split("：")[1];
                   }
                   proGameType.setGtype(gameType);
                   ProGameTypeDaoImpl proGameTypeDaoImpl=new ProGameTypeDaoImpl();
                   proGameTypeDaoImpl.insertType(proGameType);
               }
                System.out.println("++++++++++++++-----------这是第" + num + "页的第" + i + "条数据---------------++++++++++++++++++++++");
            }
            doc=listPageJsoup(doc,commonHTMLGamesProductConfig);
        }
    }
}
