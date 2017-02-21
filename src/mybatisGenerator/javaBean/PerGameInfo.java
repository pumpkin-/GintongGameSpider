package mybatisGenerator.javaBean;

import java.util.Date;

public class PerGameInfo {
    private String gname;

    private String area;

    private String rolename;

    private String achievement;

    private String lvl;

    private String gang;

    private String speech;

    private Date startTime;

    private String consume;

    private String uuid;

    private String gameExp;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl == null ? null : lvl.trim();
    }

    public String getGang() {
        return gang;
    }

    public void setGang(String gang) {
        this.gang = gang == null ? null : gang.trim();
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech == null ? null : speech.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume == null ? null : consume.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGameExp() {
        return gameExp;
    }

    public void setGameExp(String gameExp) {
        this.gameExp = gameExp == null ? null : gameExp.trim();
    }
}