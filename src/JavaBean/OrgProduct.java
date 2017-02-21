package JavaBean;

public class OrgProduct {
    private String oname;

    private String pname;

    private String rtype;

    private String rgrade;

    private String rgDesc;

    private String ouuid;

    private String prUuid;

    private String source;

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
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

    public String getRgDesc() {
        return rgDesc;
    }

    public void setRgDesc(String rgDesc) {
        this.rgDesc = rgDesc == null ? null : rgDesc.trim();
    }

    public String getOuuid() {
        return ouuid;
    }

    public void setOuuid(String ouuid) {
        this.ouuid = ouuid == null ? null : ouuid.trim();
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