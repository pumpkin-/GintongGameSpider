package JavaBean;

public class BasPersonInfoWithBLOBs extends BasPersonInfo {
    private String pDesc;

    private String advantage;

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage == null ? null : advantage.trim();
    }
}