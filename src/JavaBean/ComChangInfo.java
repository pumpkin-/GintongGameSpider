package JavaBean;

/**
 * Created by admin on 2017/4/6.
 */
public class ComChangInfo {
    private Integer bid;
    private String uuid;
    private String change_time;
    private String change_item;
    private String before_change;
    private String after_change;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getChange_time() {
        return change_time;
    }

    public void setChange_time(String change_time) {
        this.change_time = change_time;
    }

    public String getChange_item() {
        return change_item;
    }

    public void setChange_item(String change_item) {
        this.change_item = change_item;
    }

    public String getBefore_change() {
        return before_change;
    }

    public void setBefore_change(String before_change) {
        this.before_change = before_change;
    }

    public String getAfter_change() {
        return after_change;
    }

    public void setAfter_change(String after_change) {
        this.after_change = after_change;
    }
}
