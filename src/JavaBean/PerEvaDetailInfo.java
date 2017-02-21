package JavaBean;

public class PerEvaDetailInfo {
    private Long evaId;

    private String image;

    private String hobby;

    private String psychology;

    private String mand;

    private String charact;

    private String pfAbility;

    private String mgAbility;

    private String itThink;

    private String virtue;

    private String flaw;

    private String bosom;

    private String familyStatus;

    private String ethics;

    private String uuid;

    public Long getEvaId() {
        return evaId;
    }

    public void setEvaId(Long evaId) {
        this.evaId = evaId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getPsychology() {
        return psychology;
    }

    public void setPsychology(String psychology) {
        this.psychology = psychology == null ? null : psychology.trim();
    }

    public String getMand() {
        return mand;
    }

    public void setMand(String mand) {
        this.mand = mand == null ? null : mand.trim();
    }

    public String getCharact() {
        return charact;
    }

    public void setCharact(String charact) {
        this.charact = charact == null ? null : charact.trim();
    }

    public String getPfAbility() {
        return pfAbility;
    }

    public void setPfAbility(String pfAbility) {
        this.pfAbility = pfAbility == null ? null : pfAbility.trim();
    }

    public String getMgAbility() {
        return mgAbility;
    }

    public void setMgAbility(String mgAbility) {
        this.mgAbility = mgAbility == null ? null : mgAbility.trim();
    }

    public String getItThink() {
        return itThink;
    }

    public void setItThink(String itThink) {
        this.itThink = itThink == null ? null : itThink.trim();
    }

    public String getVirtue() {
        return virtue;
    }

    public void setVirtue(String virtue) {
        this.virtue = virtue == null ? null : virtue.trim();
    }

    public String getFlaw() {
        return flaw;
    }

    public void setFlaw(String flaw) {
        this.flaw = flaw == null ? null : flaw.trim();
    }

    public String getBosom() {
        return bosom;
    }

    public void setBosom(String bosom) {
        this.bosom = bosom == null ? null : bosom.trim();
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus == null ? null : familyStatus.trim();
    }

    public String getEthics() {
        return ethics;
    }

    public void setEthics(String ethics) {
        this.ethics = ethics == null ? null : ethics.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}