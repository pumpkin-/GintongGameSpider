package SpiderUtils.SpiderData;

import SpiderUtils.SpiderContant;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovon on 2017/3/13.
 */
public class CommonHTMLGamesProductConfig {
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
    public Element gameType;

    @Override
    public String toString() {
        return "CommonHTMLGamesProductConfig{" +
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
