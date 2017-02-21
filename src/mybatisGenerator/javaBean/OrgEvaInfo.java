package mybatisGenerator.javaBean;

import java.util.Date;

public class OrgEvaInfo {
    private String evaluator;

    private Byte etype;

    private String evaluatorDesc;

    private Long detailId;

    private Date etime;

    private String eplace;

    private String eback;

    private Date startTime;

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

    public String getEvaluatorDesc() {
        return evaluatorDesc;
    }

    public void setEvaluatorDesc(String evaluatorDesc) {
        this.evaluatorDesc = evaluatorDesc == null ? null : evaluatorDesc.trim();
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}