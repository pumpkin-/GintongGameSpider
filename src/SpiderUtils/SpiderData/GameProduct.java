package SpiderUtils.SpiderData;


import static SpiderUtils.SpiderProduct.ergodicUrl;

/**
 * Created by 123 on 2017/3/2.
 */
public class GameProduct {
    public static void main(String[]args){
        try {
            ergodicUrl("spiderAZSC",0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
