package GintongameSpider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by lenovo on 2017/2/6.
 */
public class Phantomjs {
    public static void main(String args[]){
        System.setProperty("phantomjs.binary.path","E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
    }
}
