package JavaBean;

public class PerDemandWork {
    private String dplace;

    private String jtype;

    private String dpay;

    private String industry;

    private String djob;

    private String uuid;

    public String getDplace() {
        return dplace;
    }

    public void setDplace(String dplace) {
        this.dplace = dplace == null ? null : dplace.trim();
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype == null ? null : jtype.trim();
    }

    public String getDpay() {
        return dpay;
    }

    public void setDpay(String dpay) {
        this.dpay = dpay == null ? null : dpay.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getDjob() {
        return djob;
    }

    public void setDjob(String djob) {
        this.djob = djob == null ? null : djob.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}