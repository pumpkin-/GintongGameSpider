package mybatisGenerator.javaBean;

public class OrgFrameworkInfo {
    private String framework;

    private Integer member;

    private String recruit;

    private String conSystem;

    private String welfare;

    private String uuid;

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework == null ? null : framework.trim();
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public String getRecruit() {
        return recruit;
    }

    public void setRecruit(String recruit) {
        this.recruit = recruit == null ? null : recruit.trim();
    }

    public String getConSystem() {
        return conSystem;
    }

    public void setConSystem(String conSystem) {
        this.conSystem = conSystem == null ? null : conSystem.trim();
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare == null ? null : welfare.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}