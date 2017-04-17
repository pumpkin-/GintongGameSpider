package GintongameSpider.SpiderLxm;

import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.SpiderProduct;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovon on 2017/2/25.
 */
public class SpiderXpath {
    public static void main(String[] args){
//        try {
//            System.out.println("SpiderXpath starting......");
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            CommonSpiderKnowledge.ergodicUrl("spiderYXCYW", 311, "no");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*ExecutorService pool= Executors.newSingleThreadExecutor();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spiderYXCYW", 200, "no");
//                    BasCommonSpiderKnowledgeSpider.ergodicUrl("spiderYWW", 0, "no");
//                    BasCommonKnowledgeSpider.ergodicUrl("SpiderHrsalon",SpiderContant.xmlUrl);
//                    KnowledgeSpiderConfigMiNi knowledgeSpiderConfigMiNi=BasCommonKnowledgeSpider.ergodicUrl("spiderUrl",SpiderContant.xmlUrl);
//                    System.out.println(knowledgeSpiderConfigMiNi);
//                    SpiderProduct.ergodicUrl("spider97973", 0, 0);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
}
