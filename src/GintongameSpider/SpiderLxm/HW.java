package GintongameSpider.SpiderLxm;

import SpiderUtils.SpiderContant;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


/**
 * Created by lenovon on 2017/3/3.
 */
public class HW {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        org.jsoup.nodes.Document doc1=Jsoup.connect("http://app.mi.com/category/16").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").get();
        JXDocument doc=new JXDocument(doc1);
        System.out.println(doc);
    }
}
