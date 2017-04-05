package SpiderUtils.SpiderData;

import org.dom4j.Element;

import java.util.List;

/**
 * Created by lenovon on 2017/3/31.
 */
public class CommonMobileGamesProductConfig {
    public Element logo;
    public Element title;
    public Element platform;
    public Element ptime;
    public Element tag;
    public Element operator;
    public Element down_Link_and;
    public Element down_Link_ios;
    public Element contentPic;
    public List<Element> webUrls;
    public Element url;
    public Element type;
    public Element childLink;
    public Element nextPage;
    public Element content;
    public Element source;

    @Override
    public String toString() {
        return "CommonMobileGamesProductConfig{" +
                "logo=" + logo +
                ", title=" + title +
                ", platform=" + platform +
                ", ptime=" + ptime +
                ", tag=" + tag +
                ", operator=" + operator +
                ", down_Link_and=" + down_Link_and +
                ", down_Link_ios=" + down_Link_ios +
                ", contentPic=" + contentPic +
                ", webUrls=" + webUrls +
                ", url=" + url +
                ", type=" + type +
                ", childLink=" + childLink +
                ", nextPage=" + nextPage +
                ", content=" + content +
                ", source=" + source +
                '}';
    }
}
