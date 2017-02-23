package JavaBean;

import java.util.Date;

public class BasBusinessInfo {
    private String uuid;

    private String cname;

    private String cnameOld;

    private String stockCode;

    private String telephone;

    private String email;

    private String web;

    private String adress;

    private String legalPersen;

    private String rcapital;

    private Byte state;

    private Date rtime;

    private String industry;

    private String rbnumber;

    private String enterpriseType;

    private String ocode;

    private String operationPeriod;

    private String rdepartment;

    private Date approvaDate;

    private String ucCode;

    private String radress;

    private String source;

    private String url;

    private String bscope;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCnameOld() {
        return cnameOld;
    }

    public void setCnameOld(String cnameOld) {
        this.cnameOld = cnameOld == null ? null : cnameOld.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getLegalPersen() {
        return legalPersen;
    }

    public void setLegalPersen(String legalPersen) {
        this.legalPersen = legalPersen == null ? null : legalPersen.trim();
    }

    public String getRcapital() {
        return rcapital;
    }

    public void setRcapital(String rcapital) {
        this.rcapital = rcapital == null ? null : rcapital.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getRbnumber() {
        return rbnumber;
    }

    public void setRbnumber(String rbnumber) {
        this.rbnumber = rbnumber == null ? null : rbnumber.trim();
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    public String getOcode() {
        return ocode;
    }

    public void setOcode(String ocode) {
        this.ocode = ocode == null ? null : ocode.trim();
    }

    public String getOperationPeriod() {
        return operationPeriod;
    }

    public void setOperationPeriod(String operationPeriod) {
        this.operationPeriod = operationPeriod == null ? null : operationPeriod.trim();
    }

    public String getRdepartment() {
        return rdepartment;
    }

    public void setRdepartment(String rdepartment) {
        this.rdepartment = rdepartment == null ? null : rdepartment.trim();
    }

    public Date getApprovaDate() {
        return approvaDate;
    }

    public void setApprovaDate(Date approvaDate) {
        this.approvaDate = approvaDate;
    }

    public String getUcCode() {
        return ucCode;
    }

    public void setUcCode(String ucCode) {
        this.ucCode = ucCode == null ? null : ucCode.trim();
    }

    public String getRadress() {
        return radress;
    }

    public void setRadress(String radress) {
        this.radress = radress == null ? null : radress.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBscope() {
        return bscope;
    }

    public void setBscope(String bscope) {
        this.bscope = bscope == null ? null : bscope.trim();
    }
}