package GintongameSpider.SpiderLgw;

import JavaBean.BasOrganizeInfo;
import JavaBean.OrgEvaInfo;
import SpiderUtils.SpiderContant;
import dao.BasOrganizeInfoDao;
import dao.OrgEvaInfoDao;
import dao.impl.BasOrganizeInfoImpl;
import dao.impl.OrgEvaInfoImpl;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lenovo on 2017/3/21.
 */
public class SpiderLgw {
    private static WebDriver driver=null;

    /**
     * 主程序
     * @param url
     * @throws InterruptedException
     */
    public static BasOrganizeInfo getBussinessDataByOne(String url,BasOrganizeInfo basOrganizeInfo) throws InterruptedException {
        WebDriver driver = getWebDriver();
        BasOrganizeInfo basOrganizeInfo1=getBusinessDataByUrl(driver, url,basOrganizeInfo);
        System.out.println( ":数据入库完毕(拉勾)");
        Thread.sleep(2000);
        closeWebDriver();
        return basOrganizeInfo1;
    }

    /**
     * 获取驱动器
     * @return
     */
    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    //BasOrganizeInfo

    /**
     * 根据给的url爬取相应的数据
     * @param driver
     * @param CompanyUrl
     */
    public static BasOrganizeInfo getBusinessDataByUrl(WebDriver driver, String CompanyUrl,BasOrganizeInfo basOrganizeInfo) {
        OrgEvaInfoDao orgEvaInfoDao=new OrgEvaInfoImpl();
        try {
            driver.get(CompanyUrl);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
           // System.out.println(doc.outerHtml());
            String base = doc.select("div[id=basic_container] div").text();
            String type=base.split(" ")[1];
            String process = base.split(" ")[2];
            String number = base.split(" ")[3];
            String[] tags = doc.select("ul[class=item_con_ul clearfix]").text().split(" ");
            StringBuffer sb = new StringBuffer();
            for (String tag : tags) {
                sb.append(tag + ",");
            }
            String tag = sb.toString();
//            System.out.println("type:" + type);
//            System.out.println("process:" + process);
//            System.out.println("number:" + number);
//            System.out.println("tag:" + tag);
            BasOrganizeInfoDao basOrganizeInfoDao=new BasOrganizeInfoImpl();
            basOrganizeInfo.setTag(tag);
            basOrganizeInfo.setFinancing_stage(process);
            basOrganizeInfo.setScale(number);
            basOrganizeInfo.setIndustry(basOrganizeInfo.getIndustry() + "," + type);
            basOrganizeInfoDao.updateSingle(basOrganizeInfo);
            Element mainDoc = clickMoreSelenium(driver);
            String nextPage=mainDoc.select("span.next").text();
            int num=0;
            while(StringUtils.isNotEmpty(nextPage)){
                num++;
            String[] names=mainDoc.select(".review-name").text().split(" ");
            Elements elements=mainDoc.select("div[class=review-tags clearfix]");
            String[] evaluatorTags=new String[10];
            int index=0;
            for(Element element:elements){
                evaluatorTags[index]=element.text();
                index++;
            }
            String[] details=mainDoc.select("div.interview-process").text().split(" ");
            String[] jobNames=mainDoc.select("a.job-name").text().split(" ");
            String[] viewDates=mainDoc.select("span.review-date").text().split(" ");
            for(int i=0;i<names.length;i++) {
                OrgEvaInfo orgEvaInfo = new OrgEvaInfo();
                String name = names[i];
                String detail = details[i];
                String viewDate = viewDates[i];
                String jobName = jobNames[i];
                String evaluatorTag = evaluatorTags[i];
                orgEvaInfo.setDetail(detail);
                orgEvaInfo.setEback("拉勾网");
                orgEvaInfo.setJob_interview(jobName);
                orgEvaInfo.setEvaluator(name);
                orgEvaInfo.setEplace("测试");
                orgEvaInfo.setEtype((byte) 3);
                orgEvaInfo.setEtime(viewDate);
                orgEvaInfo.setTag(evaluatorTag);
                orgEvaInfo.setUuid(basOrganizeInfo.getUuid());
                orgEvaInfoDao.insertSingle(orgEvaInfo);
//                System.out.println("tag:" + evaluatorTag);
//                System.out.println("name:" + name);
//                System.out.println("detail:" + detail);
//                System.out.println("viewData:" + viewDate);
//                System.out.println("jobName:" + jobName);
            }
                nextPage=mainDoc.select("span[class=next]").text();
                System.out.println("*拉勾网*第"+num+"页数据加载完成");
                mainDoc=listPageSelenium(driver);
        }


        } catch (Exception e) {
            System.out.println("解析拉钩网网站错误!(招聘数据过少)");
            e.printStackTrace();
        }
        return basOrganizeInfo;
    }

    /**
     * 进去招聘列表页
     * @param driver
     * @return
     * @throws InterruptedException
     */
    public static Document clickMoreSelenium(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("document.getElementsByClassName(\"view-more\")[0].click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        Document Document=Jsoup.parse(webElement.getAttribute("outerHTML"));
        return Document;
    }

    public static Document listPageSelenium(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("document.getElementsByClassName(\"next\")[0].click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        Document Document=Jsoup.parse(webElement.getAttribute("outerHTML"));
        return Document;
    }




    /**
     * 关闭驱动器
     */
    public static void closeWebDriver() {
        driver.close();
        //System.exit(0);
    }
}
