package GintongameSpider.Spiderlzx;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2017/3/3.
 */
public class SpiderAQW {
           //1.读取XML文件，获取XML的dom结构  sax
            public Document readXML() {
                return  null;
            }
           //2.读取dom节点获取text  jsoup
            @Test
            public void getXpathString() throws IOException {
                Document doc = Jsoup.parse(new File("./src/GintongameSpider/Spiderlzx/SpiderAQW.xml"),"UTF-8");
                Elements spiderAQW = doc.select("SpiderAQW");
                for (Element elements:spiderAQW){
                    System.out.print(elements.select("spider source").text());
                }
            }

           //3.获取获取网页的dom结构 doc
            public void getWebDom (String url){

            }
           //4.传入2，获取相应的数据
           //5.存入javaBean，调取Mybatis入库


}
