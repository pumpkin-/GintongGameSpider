package GintongameSpider.SpiderLxm;

import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.SpiderProduct;

/**
 * Created by lenovon on 2017/4/8.
 */
public class HelloWorld {
    public static void main(String[] args){
        try {
//            CommonSpiderKnowledge.ergodicUrl("spiderYXGC", 0, "no");
            SpiderProduct.ergodicUrl("spiderAppStore",0,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
