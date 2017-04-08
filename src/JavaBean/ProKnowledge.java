package JavaBean;

/**
 * Created by lenovon on 2017/4/7.
 */
public class ProKnowledge {
    public String puuid;
    public String kuuid;
    public String pname;
    public String kname;
    public String rp_desc;
    public String source;
    public String rtype;
    public String rgrade;
    public String getRgrade() {
        return rgrade;
    }

    public void setRgrade(String rgrade) {
        this.rgrade = rgrade;
    }



    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }



    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getKuuid() {
        return kuuid;
    }

    public void setKuuid(String kuuid) {
        this.kuuid = kuuid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getRp_desc() {
        return rp_desc;
    }

    public void setRp_desc(String rp_desc) {
        this.rp_desc = rp_desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ProKnowledge{" +
                "puuid='" + puuid + '\'' +
                ", kuuid='" + kuuid + '\'' +
                ", pname='" + pname + '\'' +
                ", kname='" + kname + '\'' +
                ", rp_desc='" + rp_desc + '\'' +
                ", source='" + source + '\'' +
                ", rgrade='" + rgrade + '\'' +
                ", rtype='" + rtype + '\'' +
                '}';
    }
}
