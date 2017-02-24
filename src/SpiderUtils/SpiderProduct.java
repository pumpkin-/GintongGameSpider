package SpiderUtils;

import JavaBean.BasProGameInfo;
import JavaBean.ProGamePlatform;
import JavaBean.ProGameType;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import dao.ProGameInfoDao;
import dao.ProGamePlatformDao;
import dao.ProGameTypeDao;
import dao.impl.ProGameInfoDaoImpl;
import dao.impl.ProGamePlatformDaoImpl;
import dao.impl.ProGameTypeDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 游戏产品信息爬取
 * Created by gao on 2017/2/21.
 */
public class SpiderProduct {

    public static void main(String[] args) throws FileNotFoundException, XpathSyntaxErrorException {
        //调用下面的方法获取配置文件中的信息,此处参数为配置文件中二级标签名
        Map<String, Object> map = getElement("spiderAZSC");
        //创建线程池
        ExecutorService pool= Executors.newFixedThreadPool(3);
        List urlNodes= (List) map.get("urls");
        for(Object ele:urlNodes){
            Element element= (Element) ele;
            String url=element.getText().trim();
            System.out.println(url);
            //运行线程
            pool.submit(new Spider(map,url));
        }
//        // 停止加入新的线程
//        pool.shutdown();
//        while (!pool.isTerminated()) {
//            // 如果所有线程执行完成,那么挑出该循环.
//        }
    }
    /**
     * 获取配置文件中要爬取的信息
     *
     * @param targetNode 目标节点
     * @throws FileNotFoundException
     */
    public static Map<String, Object>getElement(String targetNode){
        try{
            SAXReader reader = new SAXReader();
            //获取配置文档dom树
            Document dom=reader.read(SpiderProduct.class.getClassLoader().getResource("SpiderUtils/BasProductPattern.xml").getPath());
            //获取目标配置节点
            Node target=dom.selectSingleNode("//"+targetNode);
            //获取起始url
            List urls=target.selectNodes("//"+targetNode+"//url");
            //获取网站源名称
            String source=target.selectSingleNode("//"+targetNode+"/source").getText();
            //获取ContentPath
            String contentPath=target.selectSingleNode("//"+targetNode+"/contentPath").getText();
            //图标
            String logo=target.selectSingleNode("//"+targetNode+"/logo").getText();
            //名称
            String gname=target.selectSingleNode("//"+targetNode+"/gname").getText();
            //版本
            String version=target.selectSingleNode("//"+targetNode+"/version").getText();
            //分类
            String network_type=target.selectSingleNode("//"+targetNode+"/network_type").getText();
            //时间
            String web_update_time=target.selectSingleNode("//"+targetNode+"/web_update_time").getText();
            //时间格式化字符串
            String formatStr=target.selectSingleNode("//"+targetNode+"/web_update_time/@formatStr").getText();
            String ptimeStr=target.selectSingleNode("//"+targetNode+"/ptime/@formatStr").getText();
            String beta_timeStr=target.selectSingleNode("//"+targetNode+"/beta_time/@formatStr").getText();
            String test_timeStr=target.selectSingleNode("//"+targetNode+"/test_time/@formatStr").getText();
            String betatest_timeStr=target.selectSingleNode("//"+targetNode+"/betatest_time/@formatStr").getText();
            String set_timeStr=target.selectSingleNode("//"+targetNode+"/set_time/@formatStr").getText();
            //大小
            String game_size=target.selectSingleNode("//"+targetNode+"/game_size").getText();
            //系统
            String platform=target.selectSingleNode("//"+targetNode+"/platform").getText();
            //资费
            String charge_mode=target.selectSingleNode("//"+targetNode+"/charge_mode").getText();
            //作者
            String develop_com=target.selectSingleNode("//"+targetNode+"/develop_com").getText();
            //简介
            String g_desc=target.selectSingleNode("//"+targetNode+"/g_desc").getText();
            //游戏截图
            String picture=target.selectSingleNode("//"+targetNode+"/picture").getText();
            //详情页url
            String detailurl=target.selectSingleNode("//"+targetNode+"/detailurl").getText();
            //下一页
            String nextpage=target.selectSingleNode("//"+targetNode+"/nextpage").getText();
            //游戏类型
            List gtypes=target.selectNodes("//"+targetNode+"//gtype");
            //游戏状态
            String dpprogress=target.selectSingleNode("//"+targetNode+"/dpprogress").getText();
            //画面风格
            String gstyle=target.selectSingleNode("//"+targetNode+"/gstyle").getText();
            //画面方式
            String gamespy=target.selectSingleNode("//"+targetNode+"/gamespy").getText();
            //游戏题材
            String gtheme=target.selectSingleNode("//"+targetNode+"/gtheme").getText();
            //开服总数
            String totalServer=target.selectSingleNode("//"+targetNode+"/totalServer").getText();
//            <!--游戏英语名字-->
            String gename=target.selectSingleNode("//"+targetNode+"/gename").getText();
//            <!--语言-->
            String language=target.selectSingleNode("//"+targetNode+"/language").getText();
//            <!--发行商-->
            String publisher=target.selectSingleNode("//"+targetNode+"/publisher").getText();
//            <!--发行区域-->
            String issue_area=target.selectSingleNode("//"+targetNode+"/issue_area").getText();
//            <!--标签-->
            String gtags=target.selectSingleNode("//"+targetNode+"/gtags").getText();
//            <!--游戏视角-->
            String viewpoint=target.selectSingleNode("//"+targetNode+"/viewpoint").getText();
//            <!--游戏引擎-->
            String engine=target.selectSingleNode("//"+targetNode+"/engine").getText();
//            <!--游戏品级-->
            String grade=target.selectSingleNode("//"+targetNode+"/grade").getText();
//            <!--产品团队规模-->
            String scale=target.selectSingleNode("//"+targetNode+"/scale").getText();
//            <!--产品需求-->
            String pdemand=target.selectSingleNode("//"+targetNode+"/pdemand").getText();
//            <!--价格-->
            String price=target.selectSingleNode("//"+targetNode+"/price").getText();
//            <!--初版出售时间-->
            String ptime=target.selectSingleNode("//"+targetNode+"/ptime").getText();
//            <!--公测时间-->
            String beta_time=target.selectSingleNode("//"+targetNode+"/beta_time").getText();
//            <!--内测时间-->
            String test_time=target.selectSingleNode("//"+targetNode+"/test_time").getText();
//            <!--封测时间-->
            String betatest_time=target.selectSingleNode("//"+targetNode+"/betatest_time").getText();
//            <!--立项时间-->
            String set_time=target.selectSingleNode("//"+targetNode+"/set_time").getText();
//            <!--游戏官网-->
            String web=target.selectSingleNode("//"+targetNode+"/web").getText();
//            <!--运营商-->
            String operator=target.selectSingleNode("//"+targetNode+"/operator").getText();
//            <!--资料片发布时间-->
            String films_time=target.selectSingleNode("//"+targetNode+"/films_time").getText();
//            <!--下载链接-->
            String download_link=target.selectSingleNode("//"+targetNode+"/download_link").getText();





            //将上面读到的配置文件中的xpath信息返回main方法
            Map<String, Object>map=new HashMap();

            map.put("urls",urls);
            map.put("source",source);
            map.put("contentPath",contentPath);
            map.put("logo",logo);
            map.put("gname",gname);
            map.put("version",version);
            map.put("network_type",network_type);
            map.put("web_update_time",web_update_time);
            map.put("formatStr",formatStr);
            map.put("game_size",game_size);
            map.put("platform",platform);
            map.put("charge_mode",charge_mode);
            map.put("develop_com",develop_com);
            map.put("g_desc",g_desc);
            map.put("picture",picture);
            map.put("detailurl",detailurl);
            map.put("gtypes",gtypes);
            map.put("nextpage",nextpage);
            map.put("dpprogress",dpprogress);
            map.put("gstyle",gstyle);
            map.put("gamespy",gamespy);
            map.put("totalServer",totalServer);
            map.put("gename",gename);
            map.put("language",language);
            map.put("publisher",publisher);
            map.put("issue_area",issue_area);
            map.put("gtags",gtags);
            map.put("viewpoint",viewpoint);
            map.put("grade",grade);
            map.put("scale",scale);
            map.put("pdemand",pdemand);
            map.put("price",price);
            map.put("ptime",ptime);
            map.put("beta_time",beta_time);
            map.put("test_time",test_time);
            map.put("betatest_time",betatest_time);
            map.put("set_time",set_time);
            map.put("web",web);
            map.put("operator",operator);
            map.put("films_time",films_time);
            map.put("download_link",download_link);
            map.put("ptimeStr",ptimeStr);
            map.put("beta_timeStr",beta_timeStr);
            map.put("test_timeStr",test_timeStr);
            map.put("betatest_timeStr",betatest_timeStr);
            map.put("set_timeStr",set_timeStr);
            map.put("gtheme",gtheme);
            map.put("engine",engine);
            return map;
        }catch(DocumentException e){
            System.out.println("配置文件获取错误！");
            return null;
        }
    }
}

//爬虫内部线程类
class Spider implements Runnable{
    private Map<String, Object> map=null;
    private String startUrl;
    public Spider(Map<String, Object> map,String startUrl) {
        this.map=map;
        this.startUrl=startUrl;
    }

    /**
     * 获取dom
     */
    public org.jsoup.nodes.Document getDocument(String url){
        try{
            org.jsoup.nodes.Document document=Jsoup.connect(url)
                    .userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)")
                    .get();
            return document;
        }catch (Exception e){
            throw new RuntimeException("===============连接网页:"+url+"失败！！！========================");
        }
    }

    //线程执行内容
    public void run() {
        JXDocument doc=null;
        org.jsoup.nodes.Document document=null;
        try{
            document=getDocument(startUrl);
            doc=new JXDocument(document);
        }catch(Exception e){
            e.printStackTrace();
        }

        while(true){
            //调用下面的方法获取详情页的url列表
            List<String>detailUrls=getDetailUrls(doc,map.get("detailurl").toString());
            for(String detailUrl:detailUrls){
                try{
                    org.jsoup.nodes.Document document1=getDocument(map.get("contentPath").toString()+detailUrl);
                    //解析详情页面并且存储进数据库
                    parsePage(new JXDocument(document1),map);
                    System.out.println(Thread.currentThread().getName());
                }catch(Exception e){
                        e.printStackTrace();
                }
            }
            String next=null;
            //进入下一页
            try{
                String nextUrl=null;
                try {
                    //若获取下一页失败，则停止当前线程
                    nextUrl = doc.sel(map.get("nextpage").toString()).get(0).toString();
                }catch (Exception e){
                    return;
                }
                next=map.get("contentPath").toString()+nextUrl;
                org.jsoup.nodes.Document nextdocument=Jsoup.connect(next)
                        .userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)")
                        .get();
                doc=new JXDocument(nextdocument);
            }catch(Exception e){
                System.err.println(Thread.currentThread().getName()+"进入下一页错误");
            }
        }
    }



    /**
     * 获取每页列表中的详情页的url
     */
    public  List<String>getDetailUrls(JXDocument document, String detailurl){
        List<Object>urllist= null;
        try {
            urllist = document.sel(detailurl);
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
        //存储每页中列表上跳转到详情页的链接
        List<String>detailUrls=new ArrayList();
        for(Object detailUrl:urllist){
            detailUrls.add((String)detailUrl);
        }
        return detailUrls;
    }

    /**
     * 解析页面获取相应的字段
     *
     * @param document
     */
    public  void parsePage(JXDocument document, Map map){
        String logo=null;
        String name=null;
        String version=null;
        String time=null;
        String game_size=null;
        String platform=null;
        String charge_mode=null;
        String develop_com=null;
        String g_desc=null;
        String screenShots=null;
        String network_type=null;
        String source=null;
        StringBuffer gtypes=new StringBuffer();
        String dpprogress=null;
        String gstyle=null;
        String gamespy=null;
        String gtheme=null;
        String totalServer=null;
        //创建数据库表对象
        BasProGameInfo gameInfo=new BasProGameInfo();
        ProGamePlatform proPlatform=new ProGamePlatform();
        ProGameType progtypes=new ProGameType();
        try{
            //源网站名称
            if(StringUtils.isNoneEmpty(map.get("source").toString())){
                source=map.get("source").toString();
                System.out.println(source);
                gameInfo.setSource(source);
            }
            //图标logo
            logo=map.get("contentPath").toString()+getInfomation(document,"logo");
            if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                logo = Jsoup.connect(logo).ignoreContentType(true).get().location();
            }
            gameInfo.setLogo(logo);
            //名称gname
            if(StringUtils.isNoneEmpty(map.get("gname").toString())){
                name=document.sel(map.get("gname").toString()).get(0).toString();
                System.out.println(name);
                gameInfo.setGname(name);
            }
            //版本version
            if(StringUtils.isNoneEmpty(map.get("version").toString())){
                version=document.sel(map.get("version").toString()).get(0).toString();
                version=version.substring(1,version.lastIndexOf(")"));
                System.out.println(version);
                gameInfo.setVersion(version);
            }
            //分类(网络类型)
            if(StringUtils.isNotEmpty(map.get("network_type").toString())){
                network_type = document.sel(map.get("network_type").toString()).get(0).toString();
                //如果是安卓市场的信息，则需要做进一步处理
                if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                    network_type=network_type.split("\\：")[1];
                }
                System.out.println(network_type);
                gameInfo.setNetwork_type(getNetType(network_type));
            }
            //setWeb_update_time
            if(StringUtils.isNotEmpty(map.get("web_update_time").toString())){
                String timeStr=document.sel(map.get("web_update_time").toString()).get(0).toString().split("\\：")[1];
                time=timeFormat(timeStr,map.get("formatStr").toString());
                System.out.println(time);
                gameInfo.setWeb_update_time(time);
            }
            //大小game_size
            if(StringUtils.isNotEmpty(map.get("game_size").toString())){
                game_size=document.sel(map.get("game_size").toString()).get(0).toString().split("\\：")[1];
                System.out.println(game_size);
                gameInfo.setGame_size(game_size);
            }
            //操作系统
            if(StringUtils.isNoneEmpty(map.get("platform").toString())){
                platform=document.sel(map.get("platform").toString()).get(0).toString();
                if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                    platform=platform.split("\\：")[1];
                }
                System.out.println(platform);
                proPlatform.setPlatform(platform);
            }
            //资费charge_mode
            if(StringUtils.isNotEmpty(map.get("charge_mode").toString())){
                charge_mode=document.sel(map.get("charge_mode").toString()).get(0).toString().split("\\：")[1];
                System.out.println(charge_mode);
                gameInfo.setCharge_mode(charge_mode);
            }
            //游戏研发公司（作者）develop_com
            if(StringUtils.isNotEmpty(map.get("develop_com").toString())){
                develop_com=document.sel(map.get("develop_com").toString()).get(0).toString();
                if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                    develop_com=develop_com.split("\\：")[1];
                }
                System.out.println(develop_com);
                gameInfo.setDevelop_com(develop_com);
            }

            //简介g_desc
            if(StringUtils.isNotEmpty(map.get("g_desc").toString())){
                g_desc=document.sel(map.get("g_desc").toString()).get(0).toString();
                System.out.println(g_desc);
                gameInfo.setG_desc(g_desc);
            }
            //游戏类型
            List<Element> eles= (List<Element>) map.get("gtypes");
            for (Element gtype : eles) {
                String gtypeStr=gtype.getText().trim();
                if(StringUtils.isNotEmpty(gtypeStr)) {
                    gtypes.append(document.sel(gtypeStr) + ",");
                }

            }
            System.out.println(gtypes);
            progtypes.setGtype(gtypes.toString());
            //游戏状态(研发进度)
            if(StringUtils.isNotEmpty(map.get("dpprogress").toString())){
                dpprogress=document.sel(map.get("dpprogress").toString()).get(0).toString();
                System.out.println(dpprogress);
                gameInfo.setDpprogress(dpprogress);
                proPlatform.setDpprogress(dpprogress);
            }
            //画面风格
            if(StringUtils.isNotEmpty(map.get("gstyle").toString())){
                gstyle=document.sel(map.get("gstyle").toString()).get(0).toString();
                System.out.println(gstyle);
                gameInfo.setGstyle(gstyle);
            }
            //画面方式2D,3D
            if(StringUtils.isNotEmpty(map.get("gamespy").toString())){
                gamespy=document.sel(map.get("gamespy").toString()).get(0).toString();
                System.out.println(gamespy);
                gameInfo.setGamespy(gamespy);
            }
            //游戏题材
            if(StringUtils.isNotEmpty(map.get("gtheme").toString())){
                gtheme=document.sel(map.get("gtheme").toString()).get(0).toString();
                System.out.println(gtheme);
                gameInfo.setGtheme(gtheme);
            }
            //开服总数
            if(StringUtils.isNotEmpty(map.get("totalServer").toString())){
                totalServer=document.sel(map.get("totalServer").toString()).get(0).toString();
                System.out.println(totalServer);
            }
            //游戏英语名字
            String gename=getInfomation(document,"gename");
            gameInfo.setGename(gename);
//            <!--语言-->
            String language=getInfomation(document,"language");
            gameInfo.setLanguage(language);
//            <!--发行商-->
            String publisher=getInfomation(document,"publisher");
            gameInfo.setPublisher(publisher);
//            <!--发行区域-->
            String issue_area=getInfomation(document,"issue_area");
            gameInfo.setIssue_area(issue_area);
//            <!--标签-->
            String gtags=getInfomation(document,"gtags");
            gameInfo.setGtags(gtags);
//            <!--游戏视角-->
            String viewpoint=getInfomation(document,"viewpoint");
            gameInfo.setViewpoint(viewpoint);
//            <!--游戏引擎-->
            String engine=getInfomation(document,"engine");
            gameInfo.setEngine(engine);
//            <!--游戏品级-->
            String grade=getInfomation(document,"grade");
            gameInfo.setGrade(grade);
//            <!--产品团队规模-->
            String scale=getInfomation(document,"scale");
            gameInfo.setScale(scale);
//            <!--产品需求-->
            String pdemand=getInfomation(document,"pdemand");
            gameInfo.setPdemand(pdemand);
//            <!--价格-->
            String price=getInfomation(document,"price");
            gameInfo.setPrice(price);
//            <!--初版出售时间-->
            String ptime=getInfomation(document,"ptime");
            gameInfo.setPtime(ptime);
//            if(map.get("ptimeStr").toString()!=""){
//                gameInfo.setPtime(strToDate(ptime,map.get("ptimeStr").toString()));
//            }
//            <!--公测时间-->
            String beta_time=getInfomation(document,"beta_time");
            if(map.get("beta_timeStr").toString()!=""){
                gameInfo.setBeta_tume(strToDate(beta_time,map.get("beta_timeStr").toString()));
            }
//            <!--内测时间-->
            String test_time=getInfomation(document,"test_time");
            if(map.get("test_timeStr").toString()!=""){
                gameInfo.setTest_time(strToDate(test_time,map.get("test_timeStr").toString()));
            }
//            <!--封测时间-->
            String betatest_time=getInfomation(document,"betatest_time");
            if(map.get("betatest_timeStr").toString()!=""){
                gameInfo.setBetatest_time(strToDate(betatest_time,map.get("betatest_timeStr").toString()));
            }
//            <!--立项时间-->
            String set_time=getInfomation(document,"set_time");
            if(map.get("set_timeStr").toString()!=""){
                gameInfo.setSet_time(strToDate(set_time,map.get("set_timeStr").toString()));
            }
//            <!--游戏官网-->
            String web=getInfomation(document,"web");
            gameInfo.setWeb(web);
//            <!--运营商-->
            String operator=getInfomation(document,"operator");
            gameInfo.setOperator(operator);
//            <!--资料片发布时间-->
            String films_time=getInfomation(document,"films_time");
            gameInfo.setFilms_time(films_time);
//            <!--下载链接-->
            String download_link=getInfomation(document,"download_link");
            gameInfo.setDownload_link(download_link);
            //游戏截图picture
            if(StringUtils.isNotEmpty(map.get("picture").toString())){
                List<Object> liEles=document.sel(map.get("picture").toString());
                //多个游戏截图用“,”分隔连接为一个StringBuffer
                StringBuffer screenBuffer=new StringBuffer();
                for(Object ele:liEles){
                    //如果是安智市场的图片url需要进一步访问，获取其真实url
                    if(map.get("source").toString()=="安智市场"||"安智市场".equals(map.get("source").toString())) {
                        String screenShot=map.get("contentPath").toString()+ele.toString();
                        screenShot = Jsoup.connect(screenShot)
                                .ignoreContentType(true)
                                .userAgent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)")
                                .timeout(1500)
                                .get().location();
                        screenBuffer.append(screenShot+",");
                    }
                    screenBuffer.append(ele.toString()+",");
                }
                screenShots=screenBuffer.toString();
                System.out.println(screenShots);
                gameInfo.setPicture(screenShots);
            }
            System.out.println("----------------------------------------------------------------------");
            //存入数据库
            storeToDataBase(gameInfo,progtypes,proPlatform);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过xpath来获取相对应的网页信息
     */
    public String getInfomation(JXDocument document,String xpath) throws XpathSyntaxErrorException {
        String information=null;
        String path=map.get(xpath).toString();
            if(StringUtils.isNotEmpty(path)) {
                if(document.sel(path).size()==0){
                    throw new NullPointerException("Xpath语句：<"+xpath+">:"+path+"出错，未捕获到页面标签！！");
                }
                information =document.sel(map.get(xpath).toString()) .get(0).toString();
                System.out.println(information);
            }
        return information;
    }

    /**
     *将数据存入mysql数据库中
     */
    public void storeToDataBase(BasProGameInfo gameInfo,ProGameType gtypes,ProGamePlatform platform){
        //网站源链接
        gameInfo.setUrl(startUrl);
        String uuid=UUID.randomUUID().toString();
        //uuid
        gameInfo.setUuid(uuid);
        //用dao层接口插入数据库
        ProGameInfoDao infoDao=new ProGameInfoDaoImpl();
        infoDao.insertGame(gameInfo);

        //插入游戏类型
        ProGameTypeDao typeDao=new ProGameTypeDaoImpl();
        gtypes.setUuid(uuid);
        typeDao.insertType(gtypes);

        //插入游戏平台（研发公司）
        platform.setUuid(uuid);
        ProGamePlatformDao platformDao=new ProGamePlatformDaoImpl();
        platformDao.insertPlatform(platform);

    }

    /**
     * 将时间字符串格式化为想要的格式化字符串
     */
    public  String timeFormat(String time,String formatStr)throws ParseException{
            SimpleDateFormat parse=new SimpleDateFormat(formatStr);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date dateTemp=parse.parse(time);
            String date=format.format(dateTemp);
            return date;
    }

    /**
     *将字符串转换为Date类型
     */
    public  Date strToDate(String time,String formatStr)throws ParseException{
        SimpleDateFormat parse=new SimpleDateFormat(formatStr);
        Date date=parse.parse(time);
        return date;
    }

    /**
     * 通过游戏分类字段获取对应的游戏的网络类型
     */
    public String getNetType(String network_type){
        if(map.get("source").toString()=="游戏观察"){
            return "2";
        }
        if(network_type.equals("网络游戏")||network_type=="网络游戏"){
            return "2";
        }else{
            return "0";
        }
    }
}


