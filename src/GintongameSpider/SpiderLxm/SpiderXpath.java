package GintongameSpider.SpiderLxm;

import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.SpiderProduct;

import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovon on 2017/2/25.
 */
public class SpiderXpath {
    public static void main(String[] args)  {
        try {
//            System.setOut(new PrintStream(new File("D:/logs/outLog.txt")));
            CommonSpiderKnowledge.ergodicUrl("spiderYXDG", 0, "no");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}