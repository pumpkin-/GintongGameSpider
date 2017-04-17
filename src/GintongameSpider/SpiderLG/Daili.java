package GintongameSpider.SpiderLG;


import SpiderUtils.SpiderContant;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by admin on 2017/4/11.
 */
public class Daili {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        String proxyIpAndPort= "221.229.44.232:808";
        DesiredCapabilities cap = new DesiredCapabilities();
        Proxy proxy=new Proxy();
        proxy.setHttpProxy(proxyIpAndPort).setFtpProxy(proxyIpAndPort).setSslProxy(proxyIpAndPort);
        cap.setCapability(CapabilityType.ForSeleniumServer.AVOIDING_PROXY, true);
        cap.setCapability(CapabilityType.ForSeleniumServer.ONLY_PROXYING_SELENIUM_TRAFFIC, true);
        System.setProperty("http.nonProxyHosts", "221.229.44.232");
        cap.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver=new ChromeDriver(cap);
        driver.get("http://www.baidu.com");
        System.out.println(driver.getPageSource());



    }
}
