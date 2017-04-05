package GintongameSpider.SpiderLxm;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by lenovon on 2017/2/27.
 */
public class spiderURL {

    public static void main(String[] args){
        String url="http://www.tophr.net/news/index.asp?id=17617";
        Document doc=null;
        try {
            doc=Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content=getDocContent(doc);
        System.out.println("网页正文如下：\n"+content);
    }
    private static String getDocContent(Document doc){
        Elements divs=doc.body().getElementsByTag("div");
        int max=-1;
        String content=null;
        for(int i=0;i<divs.size();i++){
            Element div=divs.get(i);
            String divContent=getDivContent(div);
            if(divContent.length()>max){
                max=divContent.length();
               content= divContent;
            }
        }
        return content;
    }
    private static String getDivContent(Element div){
        StringBuilder sb=new StringBuilder();
        Stack<Element> sk=new Stack<Element>();
        sk.push(div);
        while(!sk.empty()){
            Element e=sk.pop();
            if (e!=div&& e.tagName().equals("div")){
                continue;
            }
            if (e.tagName().equals("p") && e.getElementsByTag("a").size()==0){
                String className=e.className();
                if(className.length()!=0 && className.equals("pictext")){
                    continue;
                }
                sb.append(e.text());
                sb.append("\n");
                continue;
            }else if(e.tagName().equals("td")){
                if (e.getElementsByTag("div").size()!=0){
                    continue;
                }
                sb.append(e.text());
                sb.append("\n");
                continue;
            }
            Elements children=e.children();
            for (int i=children.size()-1;i>=0;i--){
                sk.push(children.get(i));
            }
        }
       return sb.toString();
    }
}
