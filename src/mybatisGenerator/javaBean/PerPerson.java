package mybatisGenerator.javaBean;

public class PerPerson {
    private String name;

    private String rname;

    private String revent;

    private String rtype;

    private String rgrade;

    private String rgDesc;

    private String uuid1;

    private String uuid2;

    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
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

    public String getUuid1() {
        return uuid1;
    }

    public void setUuid1(String uuid1) {
        this.uuid1 = uuid1 == null ? null : uuid1.trim();
    }

    public String getUuid2() {
        return uuid2;
    }

    public void setUuid2(String uuid2) {
        this.uuid2 = uuid2 == null ? null : uuid2.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}