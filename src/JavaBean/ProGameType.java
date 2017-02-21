package JavaBean;

public class ProGameType {
    private String uuid;

    private String gtype;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype == null ? null : gtype.trim();
    }
}