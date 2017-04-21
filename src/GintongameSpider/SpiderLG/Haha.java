package GintongameSpider.SpiderLG;

import org.jsoup.Jsoup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/4/17.
 */
public class Haha {
    public static void main(String [] args){
        try {
            org.jsoup.nodes.Document doc1=Jsoup.connect("http://www.xdaili.cn/ipagent//privateProxy/getDynamicIP/MF20174182996HjChgo/d0d4ced0f83211e6942200163e1a31c0?returnType=1")
                          .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").timeout(100000)
                         .get();

            Pattern pattern=Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}:[0-9]{1,6}");
            Matcher mat=pattern.matcher(doc1.toString());
            while(mat.find()){
                String ip=mat.group(0);
                System.out.println(ip);
            }
            System.out.println("返回的东西:" + doc1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
