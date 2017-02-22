package JavaBean;

import java.util.Date;

public class ProGameInfo {
    private String gname;//游戏名

    private String gename;//游戏英文名

    private String logo;//产品logo

    private String version;//游戏版本

    private String language;//语言

    private Byte networkType;//0未知，1不需要联网，2需要联网

    private String suitableAge;//适合年龄

    private String issueArea;//发行区域

    private String publisher;//发行商

    private String gstyle;//游戏风格

    private String gtags;//标签

    private String viewpoint;//游戏视角

    private String engine;//游戏引擎

    private String grade;//游戏品级

    private String dpprogress;//研发进度

    private String gtheme;//游戏题材

    private String scale;//产品团队规模

    private String pdemand;//产品需求

    private String price;//价格

    private String chargeMode;//付费方式

    private String developCom;//研发公司

    private Date ptime;//出版出售时间

    private Date betaTime;//初测公司

    private Date testTime;//内侧时间

    private Date betatestTime;//封测时间

    private Date setTime;//立项时间

    private String web;//游戏官网

    private String gDesc;//游戏介绍

    private String picture;//游戏截图

    private String url;

    private String source;

    private String uuid;

    private String gamespy;//游戏界面2D

    private String operator;//运营商

    private String filmsTime;//资料发布时间

    private String gameSize;//游戏大小

    private String webUpdateTime;//网站更新时间

    private String downloadLink;//下载链接

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGename() {
        return gename;
    }

    public void setGename(String gename) {
        this.gename = gename == null ? null : gename.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getLanguage() {
        return language;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Byte getNetworkType() {
        return networkType;
    }

    public void setNetworkType(Byte networkType) {
        this.networkType = networkType;
    }

    public String getSuitableAge() {
        return suitableAge;
    }

    public void setSuitableAge(String suitableAge) {
        this.suitableAge = suitableAge == null ? null : suitableAge.trim();
    }

    public String getgDesc() {
        return gDesc;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc;
    }

    public String getIssueArea() {
        return issueArea;
    }

    public void setIssueArea(String issueArea) {
        this.issueArea = issueArea == null ? null : issueArea.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getGstyle() {
        return gstyle;
    }

    public void setGstyle(String gstyle) {
        this.gstyle = gstyle == null ? null : gstyle.trim();
    }

    public String getGtags() {
        return gtags;
    }

    public void setGtags(String gtags) {
        this.gtags = gtags == null ? null : gtags.trim();
    }

    public String getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(String viewpoint) {
        this.viewpoint = viewpoint == null ? null : viewpoint.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getDpprogress() {
        return dpprogress;
    }

    public void setDpprogress(String dpprogress) {
        this.dpprogress = dpprogress == null ? null : dpprogress.trim();
    }

    public String getGtheme() {
        return gtheme;
    }

    public void setGtheme(String gtheme) {
        this.gtheme = gtheme == null ? null : gtheme.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getPdemand() {
        return pdemand;
    }

    public void setPdemand(String pdemand) {
        this.pdemand = pdemand == null ? null : pdemand.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode == null ? null : chargeMode.trim();
    }

    public String getDevelopCom() {
        return developCom;
    }

    public void setDevelopCom(String developCom) {
        this.developCom = developCom == null ? null : developCom.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Date getBetaTime() {
        return betaTime;
    }

    public void setBetaTime(Date betaTime) {
        this.betaTime = betaTime;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public Date getBetatestTime() {
        return betatestTime;
    }

    public void setBetatestTime(Date betatestTime) {
        this.betatestTime = betatestTime;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGamespy() {
        return gamespy;
    }

    public void setGamespy(String gamespy) {
        this.gamespy = gamespy == null ? null : gamespy.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getFilmsTime() {
        return filmsTime;
    }

    public void setFilmsTime(String filmsTime) {
        this.filmsTime = filmsTime == null ? null : filmsTime.trim();
    }

    public String getGameSize() {
        return gameSize;
    }

    public void setGameSize(String gameSize) {
        this.gameSize = gameSize == null ? null : gameSize.trim();
    }

    public String getWebUpdateTime() {
        return webUpdateTime;
    }

    public void setWebUpdateTime(String webUpdateTime) {
        this.webUpdateTime = webUpdateTime == null ? null : webUpdateTime.trim();
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink == null ? null : downloadLink.trim();
    }
}