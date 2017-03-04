package JavaBean;

public class ProGamePlatform {
    private String uuid;

    private String platform;

    private String dpprogress;

    private String downloadLink;

    private String game_size;

    public String getGame_size() {
        return game_size;
    }

    public void setGame_size(String game_size) {
        this.game_size = game_size;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getDpprogress() {
        return dpprogress;
    }

    public void setDpprogress(String dpprogress) {
        this.dpprogress = dpprogress == null ? null : dpprogress.trim();
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink == null ? null : downloadLink.trim();
    }
}