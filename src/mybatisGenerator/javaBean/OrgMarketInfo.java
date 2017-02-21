package mybatisGenerator.javaBean;

public class OrgMarketInfo {
    private Long issueId;

    private String stock;

    private String listeMarket;

    private String capitalStruct;

    private String stockType;

    private String marketData;

    private String institutionRate;

    private String bonusInfo;

    private String uuid;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock == null ? null : stock.trim();
    }

    public String getListeMarket() {
        return listeMarket;
    }

    public void setListeMarket(String listeMarket) {
        this.listeMarket = listeMarket == null ? null : listeMarket.trim();
    }

    public String getCapitalStruct() {
        return capitalStruct;
    }

    public void setCapitalStruct(String capitalStruct) {
        this.capitalStruct = capitalStruct == null ? null : capitalStruct.trim();
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType == null ? null : stockType.trim();
    }

    public String getMarketData() {
        return marketData;
    }

    public void setMarketData(String marketData) {
        this.marketData = marketData == null ? null : marketData.trim();
    }

    public String getInstitutionRate() {
        return institutionRate;
    }

    public void setInstitutionRate(String institutionRate) {
        this.institutionRate = institutionRate == null ? null : institutionRate.trim();
    }

    public String getBonusInfo() {
        return bonusInfo;
    }

    public void setBonusInfo(String bonusInfo) {
        this.bonusInfo = bonusInfo == null ? null : bonusInfo.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}