package GintongameSpider.SpiderLxm;

import JavaBean.BasPersonInfo;
import SpiderUtils.*;

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
//                    BasCommonSpiderKnowledgeSpider.ergodicUrl("spiderYWW", 0, "no");
                    BasCommonKnowledgeSpider.ergodicUrl("spiderHR369",SpiderContant.xmlUrl);
//                    KnowledgeSpiderConfigMiNi knowledgeSpiderConfigMiNi=BasCommonKnowledgeSpider.ergodicUrl("spiderUrl",SpiderContant.xmlUrl);
//                    System.out.println(knowledgeSpiderConfigMiNi);
//                    SpiderProduct.ergodicUrl("spiderOPPO", 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
