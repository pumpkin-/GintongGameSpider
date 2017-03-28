package JavaBean;

import java.util.List;

/**
 * Created by lenovo on 2017/3/20.
 */
public class EcologyOrgData {
    private List<BaseKnowLedge> knowLedgeList;
    private List<BasProGameInfo> proGameInfoList;
    private List<BasPersonInfo> personInfoList;
    private List<BasOrganizeInfo> organizeInfoList;
    private String ourl;    //组织官网网址
    private String oLogo;      //组织Logo
    private String tycUrl;      //公司在天眼查上的Url
    private String oIntroductUrl;   //公司简介页面上的Url
    private String oIntroduct;      //公司简介
    private List<String> oIntroductPic;     //公司简介中的截图
    private String oIntroductPicConnext;    //公司简介中截图前面需要加的Url
    private String flag;     //选择驱动器的种类

    public List<BaseKnowLedge> getKnowLedgeList() {
        return knowLedgeList;
    }

    public void setKnowLedgeList(List<BaseKnowLedge> knowLedgeList) {
        this.knowLedgeList = knowLedgeList;
    }

    public List<BasProGameInfo> getProGameInfoList() {
        return proGameInfoList;
    }

    public void setProGameInfoList(List<BasProGameInfo> proGameInfoList) {
        this.proGameInfoList = proGameInfoList;
    }

    public List<BasPersonInfo> getPersonInfoList() {
        return personInfoList;
    }

    public void setPersonInfoList(List<BasPersonInfo> personInfoList) {
        this.personInfoList = personInfoList;
    }

    public List<BasOrganizeInfo> getOrganizeInfoList() {
        return organizeInfoList;
    }

    public void setOrganizeInfoList(List<BasOrganizeInfo> organizeInfoList) {
        this.organizeInfoList = organizeInfoList;
    }

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
    }

    public String getoLogo() {
        return oLogo;
    }

    public void setoLogo(String oLogo) {
        this.oLogo = oLogo;
    }

    public String getTycUrl() {
        return tycUrl;
    }

    public void setTycUrl(String tycUrl) {
        this.tycUrl = tycUrl;
    }

    public String getoIntroductUrl() {
        return oIntroductUrl;
    }

    public void setoIntroductUrl(String oIntroductUrl) {
        this.oIntroductUrl = oIntroductUrl;
    }

    public String getoIntroduct() {
        return oIntroduct;
    }

    public void setoIntroduct(String oIntroduct) {
        this.oIntroduct = oIntroduct;
    }

    public List<String> getoIntroductPic() {
        return oIntroductPic;
    }

    public void setoIntroductPic(List<String> oIntroductPic) {
        this.oIntroductPic = oIntroductPic;
    }

    public String getoIntroductPicConnext() {
        return oIntroductPicConnext;
    }

    public void setoIntroductPicConnext(String oIntroductPicConnext) {
        this.oIntroductPicConnext = oIntroductPicConnext;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
