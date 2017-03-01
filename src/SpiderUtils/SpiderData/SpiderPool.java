package SpiderUtils.SpiderData;

import SpiderUtils.CommonSpiderKnowledge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 123 on 2017/3/1.
 */
public class SpiderPool {
    public static void main(String [] args){
        ExecutorService spider = Executors.newFixedThreadPool(5);
        spider.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spider52PKRW", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderYYNDS", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        spider.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spider52PKCY", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderCHWZL", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        spider.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spider52PKDL", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderCHWPC", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });








    }
}
