package JavaBean;

public class PerOrganize {
    private String name;

    private String oname;

    private String orgDesc;

    private String revent;

    private String rtype;

    private Short rgrade;

    private String rgDesc;

    private String job;

    private String puuid;

    private String ouuid;

    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
    }

    public String getRevent() {
        return revent;
    }

    public void setRevent(String revent) {
        this.revent = revent == null ? null : revent.trim();
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype == null ? null : rtype.trim();
    }

    public Short getRgrade() {
        return rgrade;
    }

    public void setRgrade(Short rgrade) {
        this.rgrade = rgrade;
    }

    public String getRgDesc() {
        return rgDesc;
    }

    public void setRgDesc(String rgDesc) {
        this.rgDesc = rgDesc == null ? null : rgDesc.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid == null ? null : puuid.trim();
    }

    public String getOuuid() {
        return ouuid;
    }

    public void setOuuid(String ouuid) {
        this.ouuid = ouuid == null ? null : ouuid.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}