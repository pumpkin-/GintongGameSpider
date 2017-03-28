package JavaBean;

public class PerWorkInfo {
    private String oname;

    private String department;

    private String job;

    private String level;

    public String getJob_early() {
        return job_early;
    }

    public void setJob_early(String job_early) {
        this.job_early = job_early;
    }

    private String job_early;

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getCompany_addr() {
        return company_addr;
    }

    public void setCompany_addr(String company_addr) {
        this.company_addr = company_addr;
    }

    public String getW_desc() {
        return w_desc;
    }

    public void setW_desc(String w_desc) {
        this.w_desc = w_desc;
    }

    private String work_time;

    private String wtype;

    private String company_addr;

    private String oph;

    private String income;

    private String uuid;

    private String w_desc;

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


    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype == null ? null : wtype.trim();
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

}