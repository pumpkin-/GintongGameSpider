package JavaBean;

import java.util.Date;

public class OrgEvaInfo {
    private String evaluator;

    private Byte etype;

    private String tag;

    private String detail;

    private String etime;

    private String eplace;

    private String eback;

    private String job_interview;

    private String uuid;

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator == null ? null : evaluator.trim();
    }

    public Byte getEtype() {
        return etype;
    }

    public void setEtype(Byte etype) {
        this.etype = etype;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getEplace() {
        return eplace;
    }

    public void setEplace(String eplace) {
        this.eplace = eplace == null ? null : eplace.trim();
    }

    public String getEback() {
        return eback;
    }

    public void setEback(String eback) {
        this.eback = eback == null ? null : eback.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getJob_interview() {
        return job_interview;
    }

    public void setJob_interview(String job_interview) {
        this.job_interview = job_interview;
    }
}