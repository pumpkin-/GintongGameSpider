package SpiderUtils;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        //调用下面的方法获取配置文件中的信息
        Map<String, Object> map = getElement("BasProductPattern");
        //创建线程池
        ExecutorService pool= Executors.newFixedThreadPool(5);
        List urlNodes= (List) map.get("urls");
        for(Object ele:urlNodes){
            Element element= (Element) ele;
            String url=element.getText().trim();
            System.out.println(url);
            pool.submit(new Spider(map,url));
        }
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
            Document dom=reader.read(SpiderProduct.class.getClassLoader().getResource("SpiderAZ/BasProductPattern.xml").getPath());
            //获取目标配置节点
            Node target=dom.selectSingleNode("//"+targetNode);
            //获取起始url
            List urls=target.selectNodes("//url");
            //获取ContentPath
            String contentPath=target.selectSingleNode("//contentPath").getText();
            //图标
            String logo=target.selectSingleNode("//logo").getText();
            //名称
            String pname=target.selectSingleNode("//pname").getText();
            //版本
            String pversion=target.selectSingleNode("//pversion").getText();
            //时间
            String ptime=target.selectSingleNode("//ptime").getText();
            //时间格式化字符串
            String formatStr=target.selectSingleNode("//ptime/@formatStr").getText();
            //大小
            String size=target.selectSingleNode("//size").getText();
            //系统
            String system=target.selectSingleNode("//system").getText();
            //资费
            String charges=target.selectSingleNode("//charges").getText();
            //作者
            String author=target.selectSingleNode("//author").getText();
            //简介
            String introduction=target.selectSingleNode("//introduction").getText();
            //游戏截图
            String screenShoots=target.selectSingleNode("//screenShoots").getText();
            //详情页url
            String detailurl=target.selectSingleNode("//detailurl").getText();
            //下一页
            String nextpage=target.selectSingleNode("//nextpage").getText();

            Map<String, Object>map=new HashMap<>();
            map.put("urls",urls);
            map.put("contentPath",contentPath);
            map.put("logo",logo);
            map.put("pname",pname);
            map.put("pversion",pversion);
            map.put("ptime",ptime);
            map.put("formatStr",formatStr);
            map.put("size",size);
            map.put("system",system);
            map.put("charges",charges);
            map.put("author",author);
            map.put("introduction",introduction);
            map.put("screenShoots",screenShoots);
            map.put("detailurl",detailurl);
            map.put("nextpage",nextpage);
            return map;
        }catch(DocumentException e){
            System.out.println("配置文件获取错误！");
            return null;
        }
    }
}

//爬虫类
class Spider implements Runnable{
    private Map<String, Object> map=null;
    private String startUrl;
    public Spider(Map<String, Object> map,String startUrl) {
        this.map=map;
        this.startUrl=startUrl;
    }
    public void run() {
        JXDocument doc=null;
        org.jsoup.nodes.Document document=null;
        try{
            document=Jsoup.connect(startUrl).get();
            doc=new JXDocument(document);
        }catch(IOException e){
            e.printStackTrace();
        }

        while(true){
            //调用下面的方法获取详情页的url列表
            List<String>detailUrls=getDetailUrls(doc,map.get("detailurl").toString());
            for(String detailUrl:detailUrls){
                try{
                    org.jsoup.nodes.Document document1=Jsoup.connect(map.get("contentPath").toString()+detailUrl).get();
                    //解析详情页面并且存储进数据库
                    parsePage(new JXDocument(document1),map);
                }catch(IOException e){
                        e.printStackTrace();
                }
            }
            String next=null;
            //进入下一页
            try{
                next=map.get("contentPath").toString()+doc.sel(map.get("nextpage").toString()).get(0).toString();
                doc=new JXDocument(Jsoup.connect(next).get());
            }catch(Exception e){
                break;
            }
        }
    }



    /**
     * 获取每页列表中的详情页的url
     */
    public static List<String>getDetailUrls(JXDocument document, String detailurl){
        List<Object>urllist= null;
        try {
            urllist = document.sel(detailurl);
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }
        //存储每页中列表上跳转到详情页的链接
        List<String>detailUrls=new ArrayList<>();
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
    public static void parsePage(JXDocument document, Map map){
            String image=null;
            String name=null;
            String version=null;
            Date time=null;
            String size=null;
            String sys=null;
            String charges=null;
            String author=null;
            String introduction=null;
            String screenShots=null;
            try{
            //图标
            if(StringUtils.isNoneEmpty(map.get("logo").toString())){
            String imageStr=map.get("contentPath").toString()+document.sel(map.get("logo").toString()).get(0).toString();
            image=Jsoup.connect(imageStr).ignoreContentType(true).get().location();
            System.out.println(image);
            }
            //名称
            if(StringUtils.isNoneEmpty(map.get("pname").toString())){
            name=document.sel(map.get("pname").toString()).get(0).toString();
            System.out.println(name);
            }
            //版本
            if(StringUtils.isNoneEmpty(map.get("pversion").toString())){
            version=document.sel(map.get("pversion").toString()).get(0).toString();
            System.out.println(version);
            }
            //时间
            if(StringUtils.isNoneEmpty(map.get("ptime").toString())){
            String timeStr=document.sel(map.get("ptime").toString()).get(0).toString().split("\\：")[1];
            time=timeFormat(timeStr,map.get("formatStr").toString());
            System.out.println(time);
            }
            //大小
            if(StringUtils.isNoneEmpty(map.get("size").toString())){
            size=document.sel(map.get("size").toString()).get(0).toString().split("\\：")[1];
            System.out.println(size);
            }
            //系统
            if(StringUtils.isNoneEmpty(map.get("system").toString())){
            sys=document.sel(map.get("system").toString()).get(0).toString().split("\\：")[1];
            System.out.println(sys);
            }
            //资费
            if(StringUtils.isNoneEmpty(map.get("charges").toString())){
            charges=document.sel(map.get("charges").toString()).get(0).toString().split("\\：")[1];
            System.out.println(charges);
            }
            //作者
            if(StringUtils.isNoneEmpty(map.get("author").toString())){
            author=document.sel(map.get("author").toString()).get(0).toString().split("\\：")[1];
            System.out.println(author);
            }

            //简介
            if(StringUtils.isNoneEmpty(map.get("introduction").toString())){
            introduction=document.sel(map.get("introduction").toString()).get(0).toString();
            System.out.println(introduction);
            }
            if(StringUtils.isNoneEmpty(map.get("screenShoots").toString())){
            List<Object>liEles=document.sel(map.get("screenShoots").toString());
            //多个游戏截图用“,”分隔连接为一个StringBuffer
            StringBuffer screenBuffer=new StringBuffer();
            for(Object ele:liEles){
            String screenShotStr=map.get("contentPath").toString()+ele.toString();
            String screenShot=Jsoup.connect(screenShotStr).ignoreContentType(true).get().location();
            screenBuffer.append(screenShot+",");
            }
            screenShots=screenBuffer.toString();
            System.out.println(screenShots);
            }
            System.out.println("----------------------------------------------------------------------");
            //存入数据库
    //            storeToDataBase(imageStr,name,version,time,size,
    //                sys,charges,author,introduction,screenShots);
            }catch(Exception e){
            e.printStackTrace();
            }
            }

    /**
     *将数据存入mysql数据库中
     */
    public static void storeToDataBase(String image,String name,String version,Date time,String size,
            String sys,String charges,String author,String introduction,String screenShot){

            }

    /**
     * 将时间字符串格式化为Date类型
     */
    public static Date timeFormat(String time,String formatStr)throws ParseException{
            SimpleDateFormat format=new SimpleDateFormat(formatStr);
            Date date=format.parse(time);
            return date;
    }
}


