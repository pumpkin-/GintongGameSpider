package GintongameSpider;

/**
 * Created by lenovo on 2017/2/21.
 */
public abstract class BaseSpider {

    protected void begin() {
        try{
           spider();
        } catch(Exception e) {
            //..写入bug_data库

        }
    }
    /**
     * 需复写的爬虫主方法
     */
    public abstract void spider() throws Exception;


}
