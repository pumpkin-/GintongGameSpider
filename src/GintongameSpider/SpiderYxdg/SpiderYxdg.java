package GintongameSpider.SpiderYxdg;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
public class SpiderYxdg {
    private static List<String> coverlist=new ArrayList<String>();
    private static String[] link=new String[]{"http://www.gamelook.com.cn/category/news","http://www.gamelook.com.cn/category/%E6%B8%B8%E6%88%8F%E8%BF%90%E8%90%A5","http://www.gamelook.com.cn/category/%E6%B8%B8%E6%88%8F%E5%BC%80%E5%8F%91","http://www.gamelook.com.cn/category/%E4%BA%BA%E5%8A%9B%E8%B5%84%E6%BA%90","http://www.gamelook.com.cn/category/%E7%BD%91%E9%A1%B5%E6%B8%B8%E6%88%8F-2","http://www.gamelook.com.cn/category/%E2%98%85%E6%89%8B%E6%9C%BA%E6%B8%B8%E6%88%8F","http://www.gamelook.com.cn/category/%E8%B5%84%E6%9C%AC%E5%B8%82%E5%9C%BA%E5%88%9B%E4%B8%9A","http://www.gamelook.com.cn/category/%E6%8A%95%E8%B5%84%E5%88%9B%E4%B8%9A","http://www.gamelook.com.cn/category/wiixboxps3","http://www.gamelook.com.cn/category/%E8%A7%82%E7%82%B9%E5%88%86%E6%9E%90%E8%AF%84%E6%B5%8B","http://www.gamelook.com.cn/category/%E8%B5%84%E6%9C%AC%E5%B8%82%E5%9C%BA","http://www.gamelook.com.cn/category/vrar%E6%B8%B8%E6%88%8F"};
    public static void main(String args[]) throws IOException {
        grabWeb();
    }

    public static void grabWeb() throws IOException {
        System.setProperty("phantomjs.binary.path", "E:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        int a=1;
        for(int z=0;z<link.length;z++){
            for(int i=1;i>0;i++){
                driver.get(link[z]+"/page/"+i);
                WebElement web=driver.findElement(By.xpath("/html"));
                String html=web.getAttribute("outerHTML");
                Document doc=Jsoup.parse(html);
                int flag=0;
                Elements linkscover=doc.select("div.entry-thumb img");
                for(Element linkcover:linkscover){
                    coverlist.add(linkcover.attr("src"));
                }
                Elements links=doc.select("div.entry-thumb a");
                for(Element link:links){
                    String childLink=link.attr("href");
                    driver.get(childLink);
                    WebElement webElement=driver.findElement(By.xpath("/html"));
                    String childHtml=webElement.getAttribute("outerHTML");
                    Document childDoc=Jsoup.parse(childHtml);
                    dataClean(flag,childDoc,childLink);
                    System.out.println(a + "+" + i);
                    a++;
                    flag++;
                    System.out.println("---------------------------------");
                }
                if(Integer.parseInt(doc.select("div.pagenavi.clear a.current").text())==Integer.parseInt(doc.select("div.pagenavi.clear span").text().split("/",2)[1].trim())){
                    break;
                }
            }
        }
    }

    public static void dataClean(int flag,Document doc,String url) throws IOException {
        String main=null;
        String tag=null;
        String cover=coverlist.get(flag);
        System.out.println(cover);
        System.out.println(doc.select("h1.entry-title").text());
        System.out.println(doc.select("span.meta-author a").text());
        System.out.println(doc.select("span.meta-author a").attr("href"));
        System.out.println(doc.select("span.meta-date").text().split(" ",2)[1]+" 00:00:00");
        System.out.println(doc.select("span.meta-cat a").text().replace(" ",","));
        Elements linksmain=doc.select("div.entry.entry-content p");
        for(Element linkmain:linksmain){
            if(StringUtils.isNotEmpty(linkmain.text())){
                main=(main+"\r\n<p>"+linkmain.text()+"</p>").replace("null\r\n","");
            }
            if(StringUtils.isNotEmpty(linkmain.select("img").attr("src"))){
                main=(main+"\r\n<img src="+linkmain.select("img").attr("src")+">");
            }
        }
        System.out.println(main);
        Elements linkstag=doc.select("div#entry-tags a");
        for(Element linktag:linkstag){
            tag=(tag+","+linktag.text()).replace("null,","");
        }
        System.out.println(tag);
    }
}
