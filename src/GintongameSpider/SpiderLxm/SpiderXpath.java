package GintongameSpider.SpiderLxm;

import SpiderUtils.CommonSpiderKnowledge;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovon on 2017/2/25.
 */
public class SpiderXpath {
    public static void main(String[] args){
        ExecutorService pool= Executors.newSingleThreadExecutor();

        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderGamerboom",0,"no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderChuapp",0,"no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderBufan",0,"no");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
