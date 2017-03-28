package SpiderUtils;

import GintongameSpider.SpiderLgw.SpiderLgw;
    import GintongameSpider.SpiderMM.SpiderMaimai;
import GintongameSpider.SpiderTyc.SpiderTyc;
import JavaBean.BasOrganizeInfo;
import JavaBean.BaseKnowLedge;
import JavaBean.EcologyOrgData;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import dao.BasOrganizeInfoDao;
import dao.impl.BasOrganizeInfoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/20.
 */
public class SpiderOrganize {
    //组织生态的javabean
    private static EcologyOrgData ecologyOrgData;
    public static void main(String[] args) {
        /**
         * 1.解析配置文件，获取document对象 根据xml
         * 2.将document对象封装到javaBean  config  不要写内部类
         * 3.获取驱动器（3种）
         * 4.连接网页， 设置代理 返回网页document
         * 5.将doucment转换为JXDoc
         * 6.解析JXdoc （需调用其他模块的方法） 按照功能模块或者逻辑处理流程划分方法 知识解析，产品解析。。。
         * 7.封装到JavaBean  返回javaBean对象
         * 8.入库
         *
         */
    }

    /**
     * 类中的主函数，直接调用可以直接执行
     * @param companyName
     * @param filepath
     * @throws Exception
     */
    public  void mainProcess(String companyName,String filepath) throws Exception {
        String logo=null;
        String oIntroduct=null;
        String oIntroductPic=null;
        Document document=obtainDocFromXml(filepath);
        Element rootElement=document.getRootElement();
        Element element=rootElement.element(companyName);
        OrganizeSpiderConfig organizeSpiderConfig=parseOrganizeSpiderConfig(element);
        List<Element> knowLedgeList=organizeSpiderConfig.knowLedgeList;
        List<Element> proGameInfoList=organizeSpiderConfig.proGameInfoList;
        List<Element> personInfoList=organizeSpiderConfig.personInfoList;
        List<Element> organizeInfoList=organizeSpiderConfig.organizeInfoList;
        for(Element ele:knowLedgeList){
            //TODO 缺少知识接口
        }
        for(Element ele:proGameInfoList){
            //TODO 缺少产品接口
        }
        for(Element ele:personInfoList){
            //TODO 缺少人的接口
        }
        for(Element ele:organizeInfoList){
            //TODO 缺少组织的接口
        }
        if(organizeSpiderConfig.flag.getText().equals("jsoup")) {
            org.jsoup.nodes.Document ourlDocument = getDocumentByJsoup(organizeSpiderConfig.ourl.getText());
            JXDocument ourlJxDocument = docTransferToJXDoc(ourlDocument);
            if(StringUtils.isNotEmpty(organizeSpiderConfig.oLogo.getText())){
                if(StringUtils.isNotEmpty(organizeSpiderConfig.oLogoContect.getText())) {
                    logo = organizeSpiderConfig.oLogoContect.getText()+getInfomation(ourlJxDocument, organizeSpiderConfig.oLogo.getText());
                }else{
                    logo = getInfomation(ourlJxDocument, organizeSpiderConfig.oLogo.getText());
                }
            }
            String oIntroductPicConnext = organizeSpiderConfig.oIntroductPicConnext.getText();
            if(StringUtils.isNotEmpty(organizeSpiderConfig.oIntroductUrl.getText())) {
                org.jsoup.nodes.Document oIntroductUrlDocument = getDocumentByJsoup(organizeSpiderConfig.oIntroductUrl.getText());
                JXDocument oIntroductUrlJxDocument = docTransferToJXDoc(oIntroductUrlDocument);
                if (StringUtils.isNotEmpty(organizeSpiderConfig.oIntroduct.getText())) {
                    oIntroduct = getInfomation(oIntroductUrlJxDocument, organizeSpiderConfig.oIntroduct.getText());
                }
                List<Object> pictures = null;
                //System.out.println("最烦人的地方"+organizeSpiderConfig.oIntroductPic.getText());
                if (StringUtils.isNotEmpty(organizeSpiderConfig.oIntroductPic.getText())) {
                    pictures = oIntroductUrlJxDocument.sel(organizeSpiderConfig.oIntroductPic.getText());
                    StringBuffer sb = new StringBuffer();
                    if (oIntroductPicConnext == null) {
                        for (Object obj : pictures) {
                            sb.append(obj.toString() + ",");
                        }
                    } else {
                        for (Object obj : pictures) {
                            sb.append(oIntroductPicConnext + obj.toString() + ",");
                        }
                    }
                    String picture=sb.toString();
                    oIntroductPic = sb.toString().substring(0, picture.length()-1);
                }
            }
            System.out.println("Logo:" + logo);
            System.out.println("公司简介:" + oIntroduct);
            System.out.println("公司简介中的图片：" + oIntroductPic);
            SpiderTyc spiderTyc=new SpiderTyc();
            BasOrganizeInfo tycBasOrganizeInfo = spiderTyc.getBussinessDataByOne(organizeSpiderConfig.tycUrl.getText());
            tycBasOrganizeInfo.setLogo(logo);
            tycBasOrganizeInfo.setIntroduce(oIntroduct);
            tycBasOrganizeInfo.setPicture(oIntroductPic);
            tycBasOrganizeInfo.setWeb(organizeSpiderConfig.ourl.getText());
            BasOrganizeInfoDao basOrganizeInfoDao = new BasOrganizeInfoImpl();
            basOrganizeInfoDao.updateSingle(tycBasOrganizeInfo);
            //拉钩数据入库
            if(StringUtils.isNotEmpty(organizeSpiderConfig.lgwUrl.getText())) {
                SpiderLgw.getBussinessDataByOne(organizeSpiderConfig.lgwUrl.getText(), tycBasOrganizeInfo);
            }
            //微博数据入库
            //SpiderWm.getPerInfoDataByComName(organizeSpiderConfig.oname.getText(), tycBasOrganizeInfo.getUuid());
            //脉脉数据入库
            SpiderMaimai.getPerInfoDataByComName(organizeSpiderConfig.oname.getText(), tycBasOrganizeInfo.getUuid());
        }else if(organizeSpiderConfig.flag.getText().equals("selenium")){
            WebDriver driver=getDriver(SpiderContant.chromeWindowsPath);
            org.jsoup.nodes.Document ourlDocument = getDocumentBySelenium(driver, organizeSpiderConfig.ourl.getText());
            JXDocument ourlJxDocument = docTransferToJXDoc(ourlDocument);
            if(StringUtils.isNotEmpty(organizeSpiderConfig.oLogo.getText())){
                if(StringUtils.isNotEmpty(organizeSpiderConfig.oLogoContect.getText())) {
                    logo = organizeSpiderConfig.oLogoContect.getText()+getInfomation(ourlJxDocument, organizeSpiderConfig.oLogo.getText());
                }else{
                    logo = getInfomation(ourlJxDocument, organizeSpiderConfig.oLogo.getText());
                }
            }
            String oIntroductPicConnext = organizeSpiderConfig.oIntroductPicConnext.getText();
            org.jsoup.nodes.Document oIntroductUrlDocument = getDocumentBySelenium(driver, organizeSpiderConfig.oIntroductUrl.getText());
            JXDocument oIntroductUrlJxDocument = docTransferToJXDoc(oIntroductUrlDocument);
            if(StringUtils.isNotEmpty(organizeSpiderConfig.oIntroduct.getText())) {
                oIntroduct = getInfomation(oIntroductUrlJxDocument, organizeSpiderConfig.oIntroduct.getText());
            }
            List<Object> pictures=null;
            if(StringUtils.isNotEmpty(organizeSpiderConfig.oIntroductPic.getText())) {
                pictures = oIntroductUrlJxDocument.sel(organizeSpiderConfig.oIntroductPic.getText());
                StringBuffer sb = new StringBuffer();
                if (oIntroductPicConnext == null) {
                    for (Object obj : pictures) {
                        sb.append(obj.toString() + ",");
                    }
                } else {
                    for (Object obj : pictures) {
                        sb.append(oIntroductPicConnext + obj.toString() + ",");
                    }
                }
                String picture=sb.toString();
                oIntroductPic = sb.toString().substring(0, picture.length()-1);
            }
            System.out.println("Logo:" + logo);
            System.out.println("公司简介:" + oIntroduct);
            System.out.println("公司简介中的图片：" + oIntroductPic);
            driver.close();
            SpiderTyc spiderTyc=new SpiderTyc();
            BasOrganizeInfo tycBasOrganizeInfo = spiderTyc.getBussinessDataByOne(organizeSpiderConfig.tycUrl.getText());
            tycBasOrganizeInfo.setLogo(logo);
            tycBasOrganizeInfo.setIntroduce(oIntroduct);
            tycBasOrganizeInfo.setPicture(oIntroductPic);
            BasOrganizeInfoDao basOrganizeInfoDao = new BasOrganizeInfoImpl();
            basOrganizeInfoDao.updateSingle(tycBasOrganizeInfo);
            //拉钩数据入库
            if(StringUtils.isNotEmpty(organizeSpiderConfig.lgwUrl.getText())) {
                SpiderLgw.getBussinessDataByOne(organizeSpiderConfig.lgwUrl.getText(), tycBasOrganizeInfo);
            }
            //微博数据入库
            //SpiderWm.getPerInfoDataByComName(organizeSpiderConfig.oname.getText(), tycBasOrganizeInfo.getUuid());
            //脉脉数据入库
            SpiderMaimai.getPerInfoDataByComName(organizeSpiderConfig.oname.getText(), tycBasOrganizeInfo.getUuid());

        }else{
            throw new XpathSyntaxErrorException("you shuould chose jsoup or selenium");
        }
    }

    /**
     * 获取xml对应的dom树
     *
     * @param
     * @return
     */
    public  Document obtainDocFromXml(String filePath) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(SpiderOrganize.class.getResourceAsStream(filePath));
            System.out.println("文件解析完成!");
            return document;
        }catch (Exception e){
            System.out.println("配置文件获取错误！");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解析单个节点
     * @param childElement
     * @return
     */
    public  OrganizeSpiderConfig parseOrganizeSpiderConfig(Element childElement) {
        OrganizeSpiderConfig organizeSpiderConfig= new OrganizeSpiderConfig();
        organizeSpiderConfig.knowLedgeList=new ArrayList<Element>();
        organizeSpiderConfig.proGameInfoList=new ArrayList<Element>();
        organizeSpiderConfig.personInfoList=new ArrayList<Element>();
        organizeSpiderConfig.organizeInfoList=new ArrayList<Element>();
        for(Element ele : (List<Element>)(childElement.element("knowledges").elements())){
            organizeSpiderConfig.knowLedgeList.add(ele);
        }
        for(Element ele : (List<Element>)(childElement.element("products").elements())){
            organizeSpiderConfig.proGameInfoList.add(ele);
        }
        for(Element ele : (List<Element>)(childElement.element("persons").elements())){
            organizeSpiderConfig.personInfoList.add(ele);
        }
        for(Element ele : (List<Element>)(childElement.element("organizes").elements())){
            organizeSpiderConfig.organizeInfoList.add(ele);
        }
        if(childElement.element("oname")!=null){
            organizeSpiderConfig.oname = childElement.element("oname");
        }
        if(childElement.element("ourl")!=null){
            organizeSpiderConfig.ourl = childElement.element("ourl");
        }
        if(childElement.element("oLogo")!=null){
            organizeSpiderConfig.oLogo = childElement.element("oLogo");
        }
        if(childElement.element("oLogoContect")!=null){
            organizeSpiderConfig.oLogoContect = childElement.element("oLogoContect");
        }
        if(childElement.element("tycUrl")!=null){
            organizeSpiderConfig.tycUrl = childElement.element("tycUrl");
        }
        if(childElement.element("oIntroductUrl")!=null){
            organizeSpiderConfig.oIntroductUrl = childElement.element("oIntroductUrl");
        }
        if(childElement.element("oIntroduct")!=null){
            organizeSpiderConfig.oIntroduct = childElement.element("oIntroduct");
        }
        if(childElement.element("oIntroductPic")!=null){
            organizeSpiderConfig.oIntroductPic = childElement.element("oIntroductPic");
        }
        if(childElement.element("oIntroductPicConnext")!=null){
            organizeSpiderConfig.oIntroductPicConnext = childElement.element("oIntroductPicConnext");
        }
        if(childElement.element("lgwUrl")!=null){
            organizeSpiderConfig.lgwUrl = childElement.element("lgwUrl");
        }
        if(childElement.element("flag")!=null){
            organizeSpiderConfig.flag = childElement.element("flag");
        }
        return organizeSpiderConfig;
    }


    /**
     * 获取selenium驱动 chrome
     * @return
     */
    public  WebDriver getDriver(String driverPath){
        if(driverPath.contains("chromedriver")){
            System.setProperty("webdriver.chrome.driver",driverPath);
            return new ChromeDriver();
        }else{
            System.setProperty("phantomjs.binary.path", driverPath);
            return new PhantomJSDriver();
        }
    }

    /**
     * 通过jsoup连接网页， 设置代理 返回网页document
     * @param url
     * @return
     * @throws IOException
     */
    public  org.jsoup.nodes.Document getDocumentByJsoup(String url) throws IOException {
        return Jsoup.connect(url).
                userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                .timeout(100000).get();
    }
    /**
     * 通过驱动器获得当前页面的doucument树
     * @param driver
     * @return
     */
    public  org.jsoup.nodes.Document getDocumentBySelenium(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
        return Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML"));
    }

    /**
     * 将Document转化成JXDocument
     * @param document
     * @return
     */
    public  JXDocument docTransferToJXDoc(org.jsoup.nodes.Document document){
        return new JXDocument(document);
    }

    /**
     * 解析JXdocument根据并将得到的数据存入javabean中
     * @param jxDocument
     * @return
     */
    public  String getInfomation(JXDocument jxDocument, String xpath) throws XpathSyntaxErrorException {
        String information=null;
        if(StringUtils.isNotEmpty(xpath)) {
            if(jxDocument.sel(xpath).size()>0) {
                information = jxDocument.sel(xpath).get(0).toString();
            }
            //System.out.println(information);
        }
        return information;
    }


    /**
     * 人和组织信息入库
     * @param baseKnowLedge
     * @param ouuid
     */
    public  void org_PerInfoStoreToDataBase(BaseKnowLedge baseKnowLedge,String ouuid){
        //跟上面差不多
    }



}