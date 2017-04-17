package GintongameSpider.SpiderLxm;

import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.SpiderContant;

import SpiderUtils.SpiderProduct;
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
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;


/**
 * Created by lenovon on 2017/3/3.
 */
public class HW {
    public static void main(String[] args){
        try {
//            SpiderProduct.ergodicUrl("spiderYXCYW", 0, 0);
            CommonSpiderKnowledge.ergodicUrl("spiderYXGK",8,"no");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
