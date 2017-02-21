package JavaBean;

public class BasOrganizeInfoWithBLOBs extends BasOrganizeInfo {
    private String introduce;

    private String picture;

    private String developmentHistory;

    private String corporateCulture;

    private String tag;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDevelopmentHistory() {
        return developmentHistory;
    }

    public void setDevelopmentHistory(String developmentHistory) {
        this.developmentHistory = developmentHistory == null ? null : developmentHistory.trim();
    }

    public String getCorporateCulture() {
        return corporateCulture;
    }

    public void setCorporateCulture(String corporateCulture) {
        this.corporateCulture = corporateCulture == null ? null : corporateCulture.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}