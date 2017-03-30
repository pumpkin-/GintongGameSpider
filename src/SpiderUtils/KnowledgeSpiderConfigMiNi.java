package SpiderUtils;

import org.dom4j.Element;

import java.util.List;

/**
 * Created by lenovon on 2017/3/13.
 */
public class KnowledgeSpiderConfigMiNi {
    public Element flag;
    public Element url;
    public List<Element> webUrls;
    public Element ptime;
    public Element nextPage;
    public Element chose;

    public Element getMain() {
        return main;
    }

    public void setMain(Element main) {
        this.main = main;
    }

    public Element main;

    public Element getNextPage() {
        return nextPage;
    }

    public void setNextPage(Element nextPage) {
        this.nextPage = nextPage;
    }

    public Element getChildLink() {
        return childLink;
    }

    public void setChildLink(Element childLink) {
        this.childLink = childLink;
    }

    public Element childLink;

    public Element getFlag() {
        return flag;
    }

    public void setFlag(Element flag) {
        this.flag = flag;
    }

    public Element getUrl() {
        return url;
    }

    public void setUrl(Element url) {
        this.url = url;
    }

    public List<Element> getWebUrls() {
        return webUrls;
    }

    public void setWebUrls(List<Element> webUrls) {
        this.webUrls = webUrls;
    }

    public Element getPtime() {
        return ptime;
    }

    public void setPtime(Element ptime) {
        this.ptime = ptime;
    }


}
