package SpiderUtils.SpiderData;

import org.dom4j.Element;

/**
 * Created by lenovon on 2017/3/13.
 */
public class CommonPCGamesProductConfig {
    public Element logo;
    public Element title;
    public Element tag;
    public Element develop_com;
    public Element contentPic;
    public Element type;
    public Element childLink;
    public Element nextPage;
    public Element content;
    public Element webURL;
    public Element gtheme;
    public Element gamespy;
    public Element source;

    @Override
    public String toString() {
        return "CommonPCGamesProductConfig{" +
                "logo=" + logo +
                ", title=" + title +
                ", tag=" + tag +
                ", develop_com=" + develop_com +
                ", contentPic=" + contentPic +
                ", type=" + type +
                ", childLink=" + childLink +
                ", nextPage=" + nextPage +
                ", content=" + content +
                ", webURL=" + webURL +
                ", gtheme=" + gtheme +
                ", gamespy=" + gamespy +
                ", source=" + source +
                '}';
    }
}
