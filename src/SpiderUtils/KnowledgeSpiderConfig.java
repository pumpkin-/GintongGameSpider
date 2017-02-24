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

    public String flag;
    //当前网站url
    public String url;
    //当前网站的分页
    public List<String> webUrls;
    //下一页点击xpath
    public String nextPage;
    //更多页面
    public String more;
    //TODO 不懂什么意思
    public Element nextflagi;
    //文章作者
    public String author;
    //文章标题
    public String title;
    //文章封面
    public String cover;
    //文章标签
    public String tag;
    //正文
    public String main;
    //正文图片
    public String mainPicture;
    //文章发表时间
    public String ptime;
    //文章类别
    public String type;
    //文章对应的网站名称(eg:"游戏观察" "游戏狗" etc)
    public String source;
    //作者在该网站对应的url
    public String authorUrl;

    public String childnexti;
    public String childnextflagi;
    public int page=0;

    @Override
    public String toString() {
        return "KnowledgeSpiderConfig{" +
                "flag='" + flag + '\'' +
                ", url='" + url + '\'' +
                ", webUrls=" + webUrls +
                ", nextPage='" + nextPage + '\'' +
                ", more='" + more + '\'' +
                ", nextflagi=" + nextflagi +
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
                ", childnexti='" + childnexti + '\'' +
                ", childnextflagi='" + childnextflagi + '\'' +
                ", page=" + page +
                '}';
    }
}
