package JavaBean;

public class ComShareholder {
    private Integer bid;

    private String uuid;

    private String name;

    private String investment;

    private String adress;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment == null ? null : investment.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }
}