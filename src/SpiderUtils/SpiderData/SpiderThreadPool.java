package SpiderUtils.SpiderData;

import SpiderUtils.CommonSpiderKnowledge;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 123 on 2017/3/1.
 */
public class SpiderThreadPool {
    public static void main(String [] args){
        ExecutorService spider = Executors.newFixedThreadPool(5);
        spider.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    CommonSpiderKnowledge.ergodicUrl("spider52PKQQ", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderCHWZX", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        spider.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderYXC", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderCHWGL", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        spider.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderYXW", 0, "no");
                    CommonSpiderKnowledge.ergodicUrl("spiderXLCY", 0, "no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });








    }
}
