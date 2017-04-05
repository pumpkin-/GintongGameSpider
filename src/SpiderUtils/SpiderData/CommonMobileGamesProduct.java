package SpiderUtils.SpiderData;

import JavaBean.BasProGameInfo;
import JavaBean.ProGamePlatform;
import JavaBean.ProGameType;
import SpiderUtils.KnowledgeSpiderConfig;
import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import dao.impl.ProGameInfoDaoImpl;
import dao.impl.ProGamePlatformDaoImpl;
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
public class CommonMobileGamesProduct {
    public static CommonMobileGamesProductConfig parseConfigXmlByWebName(String webName) throws DocumentException {
        CommonMobileGamesProductConfig commonMobileGamesProductConfig=new CommonMobileGamesProductConfig();
        commonMobileGamesProductConfig.webUrls=new ArrayList<Element>();
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read(StringUtils.class.getResourceAsStream(SpiderContant.CommonMoilbeGamesProductXml));
        Element rootElement=doc.getRootElement();
        Element childElement=rootElement.element(webName);
        if(StringUtils.isNotEmpty(childElement.element("logo").getText())){
            commonMobileGamesProductConfig.logo=childElement.element("logo");
        }
        if (StringUtils.isNotEmpty(childElement.element("title").getText())){
            commonMobileGamesProductConfig.title=childElement.element("title");
        }
        if(StringUtils.isNotEmpty(childElement.element("platform").getText())){
            commonMobileGamesProductConfig.platform=childElement.element("platform");
        }
        if(StringUtils.isNotEmpty(childElement.element("ptime").getText())){
            commonMobileGamesProductConfig.ptime=childElement.element("ptime");
        }
        if(StringUtils.isNotEmpty(childElement.element("tag").getText())){
            commonMobileGamesProductConfig.tag=childElement.element("tag");
        }
        if (StringUtils.isNotEmpty(childElement.element("operator").getText())){
           commonMobileGamesProductConfig.operator=childElement.element("operator");
        }
        if(StringUtils.isNotEmpty(childElement.element("down_Link_and").getText())){
           commonMobileGamesProductConfig.down_Link_and=childElement.element("down_Link_and");
        }
        if (StringUtils.isNotEmpty(childElement.element("down_Link_ios").getText())){
            commonMobileGamesProductConfig.down_Link_ios=childElement.element("down_Link_ios");
        }
        if (StringUtils.isNotEmpty(childElement.element("contentPic").getText())){
            commonMobileGamesProductConfig.contentPic=childElement.element("contentPic");
        }
        if (StringUtils.isNotEmpty(childElement.element("content").getText())){
            commonMobileGamesProductConfig.content=childElement.element("content");
        }
        if (StringUtils.isNotEmpty(childElement.element("childLink").getText())){
            commonMobileGamesProductConfig.childLink=childElement.element("childLink");
        }
        if(StringUtils.isNotEmpty(childElement.element("nextPage").getText())){
            commonMobileGamesProductConfig.nextPage=childElement.element("nextPage");
        }
        if(StringUtils.isNotEmpty(childElement.element("source").getText())){
            commonMobileGamesProductConfig.source=childElement.element("source");
        }
        return commonMobileGamesProductConfig;
    }

    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url.trim()).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
      public static void ergodicUrl(String WebName) throws DocumentException, IOException, XpathSyntaxErrorException {
          String childLink=null;
          String down_Link_ios=null;
          String mains=null;
          CommonMobileGamesProductConfig commonMobileGamesProductConfig=parseConfigXmlByWebName(WebName);
        for(Element ele:commonMobileGamesProductConfig.webUrls){
            JXDocument doc=getJXDocument(ele.getText().trim());
            int num=0;
            while(true){
                num++;
                int i=0;
                List<Object> listURL=doc.sel(commonMobileGamesProductConfig.childLink.getText());
                for (Object PageUrl:listURL){
                    i++;
                    if(StringUtils.isNotEmpty(commonMobileGamesProductConfig.childLink.attributeValue("join"))){
                        childLink=commonMobileGamesProductConfig.childLink.attributeValue("join")+PageUrl;
                    }else{
                        childLink=(String)PageUrl;
                    }
                    JXDocument childDocument=getJXDocument(childLink);
                    String logo=childDocument.sel(commonMobileGamesProductConfig.logo.getText()).toString();
                    String title=childDocument.sel(commonMobileGamesProductConfig.title.getText()).toString();
                    String contentPic=childDocument.sel(commonMobileGamesProductConfig.contentPic.getText()).toString();
                    String platfrom=childDocument.sel(commonMobileGamesProductConfig.platform.getText()).toString();
                    List<JXNode> contents=childDocument.selN(commonMobileGamesProductConfig.content.getText());
                    for(JXNode main:contents){
                        mains=("<p>"+main.getElement().text()+"</p>");
                        System.out.println(mains);
                    }
                    String tag=childDocument.sel(commonMobileGamesProductConfig.tag.getText()).toString();
                    String down_Link_and=childDocument.sel(commonMobileGamesProductConfig.down_Link_and.getText()).toString();
                    if(commonMobileGamesProductConfig.down_Link_ios!=null){
                        down_Link_ios=childDocument.sel(commonMobileGamesProductConfig.down_Link_ios.getText()).toString();
                        System.out.println(down_Link_ios);
                    }
                    String source=commonMobileGamesProductConfig.source.getText();
                    System.out.println(logo);
                    System.out.println(title);
                    System.out.println(contentPic);
                    System.out.println(platfrom);
                    System.out.println(tag);
                    System.out.println(down_Link_and);

                    System.out.println("++++++++++++++-----------这是第"+num+"页的第"+i+"条数据---------------++++++++++++++++++++++");
                }
                doc=listPageJsoup(doc,commonMobileGamesProductConfig);

            }
        }
      }

    public static JXDocument listPageJsoup(JXDocument doc, CommonMobileGamesProductConfig commonMobileGamesProductConfig) throws XpathSyntaxErrorException, IOException {
        String next=null;
        String nexturl=null;
        JXDocument nextDocument=null;
        String oldurl=null;
        next=getTagOne(doc,commonMobileGamesProductConfig.nextPage.getText()).toString();
        if (StringUtils.isNotEmpty(commonMobileGamesProductConfig.nextPage.attributeValue("join"))) {
            if (next.toString().substring(0, 4).equals("http")) {
                nexturl = next.toString().replace("..", "");
            } else {
                nexturl = commonMobileGamesProductConfig.nextPage.attributeValue("join") + next.toString().replace("..", "");
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
        CommonMobileGamesProductConfig commonMobileGamesProductConfig=parseConfigXmlByWebName(WebName);
        JXDocument doc=getJXDocument(url);
        List<Object> list=doc.sel(commonMobileGamesProductConfig.childLink.getText());
        while(true){
            num++;
            int i=0;
            List<Object> listURL=doc.sel(commonMobileGamesProductConfig.childLink.getText());
            for (Object PageUrl:listURL){
                i++;
                if(StringUtils.isNotEmpty(commonMobileGamesProductConfig.childLink.attributeValue("join"))){
                    childLink=commonMobileGamesProductConfig.childLink.attributeValue("join")+PageUrl;
                }else{
                    childLink=(String)PageUrl;
                }
                JXDocument childDocument=getJXDocument(childLink);
                String logo=childDocument.sel(commonMobileGamesProductConfig.logo.getText()).toString();
                String title=childDocument.sel(commonMobileGamesProductConfig.title.getText()).toString();
                String contentPic=childDocument.sel(commonMobileGamesProductConfig.contentPic.getText()).toString();
                String platfrom=childDocument.sel(commonMobileGamesProductConfig.platform.getText()).toString();
                List<JXNode> contents=childDocument.selN(commonMobileGamesProductConfig.content.getText());
                String source=commonMobileGamesProductConfig.source.getText();
                for(JXNode main:contents){
                    mains=("<p>"+main.getElement().text()+"</p>");
                    System.out.println(mains);
                }
                String tag=childDocument.sel(commonMobileGamesProductConfig.tag.getText()).toString();
                String down_Link_and=childDocument.sel(commonMobileGamesProductConfig.down_Link_and.getText()).toString();
                if(commonMobileGamesProductConfig.down_Link_ios!=null){
                    String down_Link_ios=childDocument.sel(commonMobileGamesProductConfig.down_Link_ios.getText()).toString();
                    System.out.println(down_Link_ios);
                }
                System.out.println(logo);
                System.out.println(title);
                System.out.println(contentPic);
                System.out.println(platfrom);
                System.out.println(tag);
                System.out.println(down_Link_and);
                System.out.println(source);
                BasProGameInfo basProGameInfo=new BasProGameInfo();
                basProGameInfo.setUrl(PageUrl.toString());
                basProGameInfo.setLogo(logo);
                basProGameInfo.setG_desc(mains);
                basProGameInfo.setSource(source);
                basProGameInfo.setUuid(uuid);
                basProGameInfo.setPicture(contentPic);
                basProGameInfo.setDownload_link(down_Link_and);
                ProGameInfoDaoImpl proGameInfoDaoImpl=new ProGameInfoDaoImpl();
                proGameInfoDaoImpl.insertGame(basProGameInfo);
                ProGamePlatform proGamePlatform=new ProGamePlatform();
                proGamePlatform.setUuid(uuid);
                proGamePlatform.setPlatform(platfrom);
                ProGamePlatformDaoImpl proGamePlatformDaoImpl=new ProGamePlatformDaoImpl();
                proGamePlatformDaoImpl.insertPlatform(proGamePlatform);
                System.out.println("++++++++++++++-----------这是第" + num + "页的第" + i + "条数据---------------++++++++++++++++++++++");
            }
            doc=listPageJsoup(doc,commonMobileGamesProductConfig);
        }
    }
}
