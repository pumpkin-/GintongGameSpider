package JavaBean;

public class ComShareholderTeam {
    private Integer bid;

    private String uuid;

    private String oname;

    private String legal_persen;

    private String industry;

    private String state;

    private String investment;

    private String web;

    private String investment_rate;

    private String subscription_time;

    public String getInvestment_rate() {
        return investment_rate;
    }

    public void setInvestment_rate(String investment_rate) {
        this.investment_rate = investment_rate;
    }

    public String getSubscription_time() {
        return subscription_time;
    }

    public void setSubscription_time(String subscription_time) {
        this.subscription_time = subscription_time;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getLegalPersen() {
        return legal_persen;
    }

    public void setLegalPersen(String legalPersen) {
        this.legal_persen = legalPersen == null ? null : legalPersen.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment == null ? null : investment.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }
}