package SpiderUtils;

import org.dom4j.Element;

import java.util.List;

/**
 * Created by lenovo on 2017/3/20.
 */
public class OrganizeSpiderConfig {
    //所有知识的集合
    public List<Element> knowLedgeList;
    //所有产品的集合
    public List<Element> proGameInfoList;
    //所有人的集合
    public List<Element> personInfoList;
    //所有组织的集合
    public List<Element> organizeInfoList;
    //组织名字
    public Element oname;
    //组织官网网址
    public Element ourl;
    //组织Logo
    public Element oLogo;
    //天眼查Url
    public Element tycUrl;
    //公司简介页面上的Url
    public Element oIntroductUrl;
    //公司简介
    public Element oIntroduct;
    //公司简介中的截图
    public Element oIntroductPic;
    //公司简介中截图前面需要加的Url
    public Element oIntroductPicConnext;
    //拉勾网Url
    public Element lgwUrl;
    //所选择的驱动器
    public Element flag;
    //Logo前面所要添加的Url
    public Element oLogoContect;
    //开服网页游Url
    public Element kfwYYUrl;
    //开服网端游Url
    public Element kfwDyUrl;
    //开服网手游Url
    public Element kfwSyUrl;
    //公司的Ouuid
    public Element ouuid;


    public String toString(){
        return "OrganizeSpiderConfig{" +
                "oname='" + oname + '\'' +
                "lgwUrl='" + lgwUrl + '\'' +
                ", knowLedgeList='" + knowLedgeList + '\'' +
                ", proGameInfoList=" + proGameInfoList +
                ", personInfoList='" + personInfoList + '\'' +
                ", organizeInfoList='" + organizeInfoList + '\'' +
                ", ourl='" + ourl + '\'' +
                ", oLogo='" + oLogo + '\'' +
                ", oLogoContect='" + oLogoContect + '\'' +
                ", tycUrl='" + tycUrl + '\'' +
                ", oIntroductUrl='" + oIntroductUrl + '\'' +
                ", oIntroduct='" + oIntroduct + '\'' +
                ", oIntroductPic='" + oIntroductPic + '\'' +
                ", oIntroductPicConnext='" + oIntroductPicConnext + '\'' +
                ", kfwYYUrl='" + kfwYYUrl + '\'' +
                ", kfwDyUrl='" + kfwDyUrl + '\'' +
                ", kfwSyUrl='" + kfwSyUrl + '\'' +
                ", flag='" + flag + '\'' +
                ", ouuid='" + ouuid + '\'' +
                '}';
    }

}
