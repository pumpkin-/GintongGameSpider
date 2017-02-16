import JavaBean.ProKnowledge;
import dao.impl.ProKnowledgeImpl;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.swing.text.Style;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test{
    private static List<ProKnowledge> proKnowledges = new ArrayList<ProKnowledge>();
    public static void main(String args[]) throws ProKnowledgeImpl.FormatEexception, IOException {
        Document doc=Jsoup.connect("http://news.17173.com/content/02142017/002040859_1.shtml").get();
        System.out.println(doc.select("div.vr-final-mod-pagination").toString());
        String tag=null;
        String main=null;
        String type=null;
        String title=null;
        String puuid= UUID.randomUUID().toString();
        String kuuid=UUID.randomUUID().toString();
        try {
            type=doc.select("div.crumb.forsetLink1 a[target=_blank]").get(1).text();
        }catch (Exception e1){
            try {
                type = doc.select("div.gb-final-mod-crumbs a").get(2).text();
            }catch (Exception e2){
                try {
                    type = doc.select("div.gb-final-mod-crumbs span.gb-final-cur").get(0).text();
                }catch (Exception e3){
                    type=null;
                }
            }
        }
        if(StringUtils.isNotEmpty(doc.select("h1.article-tit.forsetLink3").text())) {
            title = doc.select("h1.article-tit.forsetLink3").text();
        }else{
            title=doc.select("span.gb-final-cur").text();
        }
        String test=doc.select("span.tag.forsetLink3 script").toString();

        Pattern pat=Pattern.compile(".*var _tags.*",Pattern.CASE_INSENSITIVE);
        Matcher mat=pat.matcher(test);
        while(mat.find()){
            tag=(mat.group(0).replace("var _tags = '","").replace("';","")).trim();
        }

        if(StringUtils.isEmpty(doc.select("div.vr-final-mod-pagination").toString())) {
            if (doc.select("div.vr-article-bd p") != null && doc.select("div.vr-article-bd p").toString().length() > 0) {
                Elements linksmain = doc.select("div.vr-article-bd p");
                for (Element linkmain : linksmain) {
                    if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                        main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                    }
                    if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                        main = (main + "\r\n" + "<img src=" + linkmain.select("img").attr("src") + ">").replace("null\r\n", "");
                    }
                }
            } else {
                Elements linksmain = doc.select("div.gb-final-mod-article.gb-final-mod-article-p2em p");
                for (Element linkmain : linksmain) {
                    if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                        main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                    }
                    if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                        main = (main + "\r\n" + "<img src=" + linkmain.select("a").attr("href") + ">").replace("null\r\n", "");
                    }
                }
            }
        }else{
            if (doc.select("div.vr-article-bd p") != null && doc.select("div.vr-article-bd p").toString().length() > 0) {
                Elements linksmain = doc.select("div.vr-article-bd p");
                for (Element linkmain : linksmain) {
                    if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                        main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                    }
                    if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                        main = (main + "\r\n" + "<img src=" + linkmain.select("img").attr("src") + ">").replace("null\r\n", "");
                    }
                }
            } else {
                Elements linksmain = doc.select("div.gb-final-mod-article.gb-final-mod-article-p2em p");
                for (Element linkmain : linksmain) {
                    if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                        main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                    }
                    if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                        main = (main + "\r\n" + "<img src=" + linkmain.select("a").attr("href") + ">").replace("null\r\n", "");
                    }
                }
            }
            Elements linkschild=doc.select("div.vr-final-mod-pagination li.next");
            for(Element linkchild:linkschild) {
                Document docchild=Jsoup.connect(linkchild.attr("href")).get();
                if (doc.select("div.vr-article-bd p") != null && doc.select("div.vr-article-bd p").toString().length() > 0) {
                    Elements linksmain = doc.select("div.vr-article-bd p");
                    for (Element linkmain : linksmain) {
                        if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                            main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                        }
                        if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                            main = (main + "\r\n" + "<img src=" + linkmain.select("img").attr("src") + ">").replace("null\r\n", "");
                        }
                    }
                } else {
                    Elements linksmain = doc.select("div.gb-final-mod-article.gb-final-mod-article-p2em p");
                    for (Element linkmain : linksmain) {
                        if (StringUtils.isNoneEmpty(linkmain.text()) && !linkmain.text().contains("专稿")) {
                            main = (main + "\r\n" + "<p>" + linkmain.text() + "</p>").replace("null\r\n", "");
                        }
                        if (StringUtils.isNoneEmpty(linkmain.select("img").attr("src"))) {
                            main = (main + "\r\n" + "<img src=" + linkmain.select("a").attr("href") + ">").replace("null\r\n", "");
                        }
                    }
                }
            }
        }
        System.out.println(main);
    }
}