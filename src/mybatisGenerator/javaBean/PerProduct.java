package mybatisGenerator.javaBean;

public class PerProduct {
    private String name;

    private String pname;

    private String rtype;

    private String rgrade;

    private String rpDesc;

    private String puuid;

    private String prUuid;

    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype == null ? null : rtype.trim();
    }

    public String getRgrade() {
        return rgrade;
    }

    public void setRgrade(String rgrade) {
        this.rgrade = rgrade == null ? null : rgrade.trim();
    }

    public String getRpDesc() {
        return rpDesc;
    }

    public void setRpDesc(String rpDesc) {
        this.rpDesc = rpDesc == null ? null : rpDesc.trim();
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid == null ? null : puuid.trim();
    }

    public String getPrUuid() {
        return prUuid;
    }

    public void setPrUuid(String prUuid) {
        this.prUuid = prUuid == null ? null : prUuid.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}