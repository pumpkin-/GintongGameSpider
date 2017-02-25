package SpiderUtils;

import org.dom4j.Element;

import java.util.List;

/**
 * 配置文件对应的JavaBean
 * Created by Byron on 2017/2/24.
 */
public class KnowledgeSpiderConfig {

    /**
     * 该配置文件中的字段应当与数据库的字段名保持统一
     */

    public Element flag;
    //当前网站url
    public Element url;
    //当前网站的分页
    public List<Element> webUrls;
    //下一页点击xpath
    public Element nextPage;
    //更多页面
    public Element chose;
    //文章作者
    public Element author;
    //文章标题
    public Element title;
    //文章封面
    public Element cover;
    //文章标签
    public Element tag;
    //正文
    public Element main;
    //正文图片
    public Element mainPicture;
    //文章发表时间
    public Element ptime;
    //文章类别
    public Element type;
    //文章对应的网站名称(eg:"游戏观察" "游戏狗" etc)
    public Element source;
    //作者在该网站对应的url
    public Element authorUrl;

    public Element childnext;
    public Element childLink;
    public int page=0;

    @Override
    public String toString() {
        return "KnowledgeSpiderConfig{" +
                "flag='" + flag + '\'' +
                ", url='" + url + '\'' +
                ", webUrls=" + webUrls +
                ", nextPage='" + nextPage + '\'' +
                ", more='" + chose + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", tag='" + tag + '\'' +
                ", main='" + main + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                ", ptime='" + ptime + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", childnexti='" + childnext + '\'' +
                ", page=" + page +
                '}';
    }
}
