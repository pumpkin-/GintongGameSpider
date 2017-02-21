package mybatisGenerator.javaBean;

public class ProGameInfoWithBLOBs extends ProGameInfo {
    private String picture;

    private String gDesc;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getgDesc() {
        return gDesc;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc == null ? null : gDesc.trim();
    }
}