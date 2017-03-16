package GintongameSpider.SpiderLG;

import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.SpiderProduct;

///**
// * Created by lenovo on 2017/2/28.
// */
public class SpiderLG {
    public static void main(String [] args)  {
        try {
            SpiderProduct spider = new SpiderProduct();
            spider.ergodicUrl("spider96u", 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
