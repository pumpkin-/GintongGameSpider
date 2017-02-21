package JavaBean;

/**
 * 组织与产品表
 * Created 丁全彬 123 on 2017/2/21.
 */
public class OrgProduct {
    private String id;//（主键）
    private String oname;//（组织名）
    private String pname;//（产品名）
    private String rtype;//（关系类型）
    private String rgrade;//（关系权重）
    private String rg_desc;//（关系权重描述）
    private String ouuid;
    private String pr_uuid;
    private String source;
    private String ctime;//（创建时间）
    private String atime;//（修改时间）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRgrade() {
        return rgrade;
    }

    public void setRgrade(String rgrade) {
        this.rgrade = rgrade;
    }

    public String getRg_desc() {
        return rg_desc;
    }

    public void setRg_desc(String rg_desc) {
        this.rg_desc = rg_desc;
    }

    public String getOuuid() {
        return ouuid;
    }

    public void setOuuid(String ouuid) {
        this.ouuid = ouuid;
    }

    public String getPr_uuid() {
        return pr_uuid;
    }

    public void setPr_uuid(String pr_uuid) {
        this.pr_uuid = pr_uuid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }
}
