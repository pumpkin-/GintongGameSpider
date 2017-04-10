package SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;


import dao.impl.BasKnowledgeInfoDaoImpl;

import org.dom4j.DocumentException;

import org.jsoup.Jsoup;


import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.text.ParseException;

import java.util.List;


public class test {
//    public static WebDriver getChromeDriver(){
//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath);
//        return new ChromeDriver();
//    }
//    public static WebDriver driver=getChromeDriver();
    static List<org.dom4j.Element> books;
    public static JXDocument getJXDocument(String url) throws IOException {
        return new JXDocument(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).ignoreHttpErrors(true).timeout(100000).get());
    }
    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, BasKnowledgeInfoDaoImpl.FormatEexception, InterruptedException, ParseException {
//jsoup查看网页源码
//http://chanye.07073.com/     http://chanye.07073.com/shuju/1560716.html
//TODO
      org.jsoup.nodes.Document doc1=Jsoup.connect("http://news.baidu.com/ns?ct=1&rn=20&ie=utf-8&bs=intitle%3A%28%E7%99%BE%E5%BA%A6%E6%90%9C%E7%B4%A2%29&rsv_bp=1&sr=0&cl=2&f=8&prevct=no&tn=newstitle&word=%E5%AE%8C%E7%BE%8E%E4%B8%96%E7%95%8C&rsv_sug3=11&rsv_sug4=107&rsv_sug1=11&rsv_sug2=0&inputT=4581&rsv_sug=1")
                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36")
                         .get();
        JXDocument doc=new JXDocument(doc1);
        List<Object> list=doc.sel("//div[@class='c-title-author']/text()");
        for(Object lists:list){
            System.out.println(lists.toString().replace(Jsoup.parse("&nbsp;&nbsp;").text(),"-").split("-")[1]);
        }







//selenium查看网页源码
//////
//        System.setProperty("webdriver.chrome.driver",SpiderContant.chromeWindowsPath );
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://kns.cnki.net/kns/brief/default_result.aspx");
//        WebElement webElement=driver.findElement(By.xpath("/html"));
//        org.jsoup.nodes.Document doc=Jsoup.parse(webElement.getAttribute("outerHTML"));
//        JXDocument jxDocument=new JXDocument(doc);
//        System.out.println(doc.outerHtml());
//        System.out.println(jxDocument.sel("//a[@class='fz14']/@href"));
//

    }
}
