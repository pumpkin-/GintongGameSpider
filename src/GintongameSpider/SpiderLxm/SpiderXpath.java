package GintongameSpider.SpiderLxm;

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

//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderTX",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderShouYou",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderGameBBS",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spider522k",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderHtml5",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderDianKJ",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderGameKZ",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderVR",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderYXH",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    CommonSpiderKnowledge.ergodicUrl("spiderDN",0,"no");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    SpiderProduct.ergodicUrl("spiderXMSD",0,0);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    CommonSpiderKnowledge.ergodicUrl("spider18Touch", 0, "no");
//                    KnowledgeSpiderConfigMiNi knowledgeSpiderConfigMiNi=BasCommonKnowledgeSpider.ergodicUrl("spiderUrl",SpiderContant.xmlUrl);
//                    System.out.println(knowledgeSpiderConfigMiNi);
//                    SpiderProduct.ergodicUrl("spiderXMSD", 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
