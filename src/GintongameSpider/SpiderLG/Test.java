package GintongameSpider.SpiderLG;

import JavaBean.BasOrganizeInfo;
import JavaBean.BasProGameInfo;
import JavaBean.OrgProduct;
import JavaBean.ProGameType;
import dao.BasOrganizeInfoDao;
import dao.OrgProductDao;
import dao.ProGameInfoDao;
import dao.ProGameTypeDao;
import dao.impl.BasOrganizeInfoImpl;
import dao.impl.OrgProductDaoImpl;
import dao.impl.ProGameInfoDaoImpl;
import dao.impl.ProGameTypeDaoImpl;
import org.apache.xalan.templates.ElemApplyImport;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2017/3/10.
 */
public class Test {
    public static void main(String [] args) throws Exception {
        List<String> urls=new ArrayList<String>();
        String uuid= UUID.randomUUID().toString();
        for(int i=414;i<=496;i++) {
            String sql = "http://ios.97973.com/ios/search?&page=$(page)";
            sql=sql.replace("$(page)",i+"");
            Document docMain = Jsoup.connect(sql).get();
            Elements elements=docMain.select("div[class=name f4 f18] a");
            for(Element element:elements){
                String childLine=element.attr("href");
                urls.add(childLine);
            }
            for(int j=0;j<urls.size();j++){
                try {
                    String url = urls.get(j);
                    Document doc = Jsoup.connect(url).get();
                    //游戏名字
                    String name = doc.select("div.cp-right-A h1").text();
                    System.out.println("游戏名字:" + name);
                    //游戏图标
                    String Logo = doc.select("div.ico img").attr("src");
                    System.out.println("游戏Logo:" + Logo);
                    //游戏描述
                    String dec = doc.select("div[class=f5 comments] p").text();
                    System.out.println("游戏描述:" + dec);
                    //下载次数
                    String downLoad = doc.select("div.down_num span.red").text();
                    System.out.println("下载次数:" + downLoad);
                    //价格
                    String price = doc.select("div[class=cp-right-E f5] div span").text();
                    System.out.println("价格" + price);
                    //版本
                    String banben=null;
                    String[] one=doc.select("div[class=cp-right-E f5] div").text().split(" ");
                    //System.out.println("第一列:"+doc.select("div[class=cp-right-E f5] div").text());
                    for(String one1:one){
                        if(one1.contains("版本：")){
                            banben=one1.split("：")[1];
                        }
                    }
                    System.out.println("版本:"+banben);
                    //第二列
                    //类别
                    String leibie = null;
                    //语言
                    String yuyan = null;
                    //大小
                    String daxiao = null;
                    String[] two = doc.select("div[class=cp-right-E f5] div").text().split(" ");
                    for (String two2 : two) {
                        if (two2.contains("类别")) {
                            leibie = two2.split("：")[1];
                        }
                        if (two2.contains("语言")) {
                            yuyan = two2.split("：")[1];
                        }
                        if (two2.contains("大小")) {
                            daxiao = two2.split("：")[1];
                        }
                    }
                    System.out.println("类别：" + leibie);
                    System.out.println("语言:" + yuyan);
                    System.out.println("大小：" + daxiao);
                    //第三列
                    //开发商
                    String kaifashang = null;
                    //系统需求
                    String xuqiu=null;
                    //标签
                    String tag = null;
                    String[] three = doc.select("div[class=cp-right-E f5] div").text().split(" ");
                    for (String three3 : three) {
                        if (three3.contains("开发商")) {
                            kaifashang = three3.split("：")[1];
                        }
                        if(three3.contains("系统要求")){
                            xuqiu=three3.split("：")[1];
                        }
                        if (three3.contains("标签")) {
                            tag = three3.split("：")[1];
                        }
                    }
                    System.out.println("开发商:" + kaifashang);
                    System.out.println("系统要求:"+xuqiu);
                    System.out.println("标签:" + tag);
                    //游戏截图
                    String pic = doc.select("td[align=center] a img").attr("src");
                    System.out.println("游戏截图:" + pic);
                    System.out.println((j + 1) + "+" + i);
                    System.out.println("-----------------------------------------------------------------");
                    BasProGameInfo gameInfo = new BasProGameInfo();
                    ProGameType progtypes = new ProGameType();
                    BasOrganizeInfo basOrganizeInfo = new BasOrganizeInfo();
                    OrgProduct orgProduct = new OrgProduct();
                    BasOrganizeInfoDao basOrganizeInfoDao = new BasOrganizeInfoImpl();
                    ProGameInfoDao proGameInfoDao = new ProGameInfoDaoImpl();
                    ProGameTypeDao proGameTypeDao = new ProGameTypeDaoImpl();
                    OrgProductDao orgProductDao = new OrgProductDaoImpl();
                    gameInfo.setUrl(url);
                    gameInfo.setGname(name);
                    gameInfo.setSource("97973");
                    gameInfo.setLogo(Logo);
                    gameInfo.setVersion(banben);
                    gameInfo.setLanguage(yuyan);
                    gameInfo.setNetwork_type("0");
                    gameInfo.setPicture(pic);
                    gameInfo.setUuid(uuid);
                    gameInfo.setG_desc(dec);
                    gameInfo.setGame_size(daxiao);
                    gameInfo.setGstyle(leibie);
                    gameInfo.setPrice(price);
                    gameInfo.setGtags(tag);
                    gameInfo.setPublisher(kaifashang);
                    gameInfo.setPdemand(xuqiu);
//                    proGameInfoDao.insertGame(gameInfo);

                    progtypes.setUuid(uuid);
                    progtypes.setGtype(leibie);
                    proGameTypeDao.insertType(progtypes);

                    String ouuid = UUID.randomUUID().toString();
                    basOrganizeInfo.setUuid(ouuid);
                    basOrganizeInfo.setUrl(url);
                    basOrganizeInfo.setSource("97973");
                    basOrganizeInfo.setOname(kaifashang);
                    basOrganizeInfoDao.insertSingle(basOrganizeInfo);

                    orgProduct.setOname(kaifashang);
                    orgProduct.setPname(name);
                    orgProduct.setSource("97973");
                    orgProduct.setOuuid(ouuid);
                    orgProduct.setPr_uuid(uuid);
                    orgProduct.setRtype("开发商");
                    orgProductDao.insertOPDuct(orgProduct);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("*************************第"+i+"页数据加载完毕***************");
            urls.clear();
        }

    }

}
