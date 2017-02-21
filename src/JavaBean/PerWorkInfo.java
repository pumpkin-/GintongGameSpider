package JavaBean;

public class PerWorkInfo {
    private String oname;

    private String department;

    private String job;

    private String level;

    private String jobEarly;

    private String workTime;

    private String wtype;

    private String companyAddr;

    private String oph;

    private String income;

    private String uuid;

    private String wDesc;

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getJobEarly() {
        return jobEarly;
    }

    public void setJobEarly(String jobEarly) {
        this.jobEarly = jobEarly == null ? null : jobEarly.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype == null ? null : wtype.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getOph() {
        return oph;
    }

    public void setOph(String oph) {
        this.oph = oph == null ? null : oph.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc == null ? null : wDesc.trim();
    }
}