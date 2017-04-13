package GintongameSpider.SpiderLG;

import SpiderUtils.SpiderContant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2017/4/12.
 */
public class ExtremeVerification {
    public void mainProcess() throws Exception {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.gsxt.gov.cn/index.html");
        WebElement webElement=driver.findElement(By.xpath("/html"));
        org.jsoup.nodes.Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        // System.out.println(doc.outerHtml());
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
//        javascriptExecutor.executeAsyncScript("document.getElementById('keyword').value='完美世界'");
//        javascriptExecutor.executeAsyncScript("$('#btn_query').click()");
        javascriptExecutor.executeScript("document.getElementById('keyword').value='完美世界'");
        Thread.sleep(1000);
        javascriptExecutor.executeScript("$('#btn_query').click()");
        Thread.sleep(2000);
        doc=getCode(driver);
        Elements elements=doc.select("div[class=gt_cut_bg gt_show] div[class=gt_cut_bg_slice]");
        List<String> dgImgUrl=new ArrayList<String>();
        List<String[]> dgImgTopLeftPointList=new ArrayList<String[]>();
        for(Element element:elements){
            String dgImg=element.attr("style");
            dgImgUrl.add(dgImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=dgImg.split("background-position:")[1].split(";")[0].trim();
            String[] dgImgTopLeftPoint=new String[2];
            dgImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            dgImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            System.out.println(dgImgTopLeftPoint[0]+"-"+dgImgTopLeftPoint[1]);
            dgImgTopLeftPointList.add(dgImgTopLeftPoint);
        }
//        for(int i=0;i<dgImgUrl.size();i++){
//            System.out.println(dgImgUrl.get(i)+"-----"+dgImgTopLeftPointList.get(i));
//        }
        System.out.println("------------------------------------------------------------");
        List<String> fullImgUrl=new ArrayList<String>();
        List<String[]> fullImgTopLeftPointList=new ArrayList<String[]>();
        Elements eles=doc.select("div[class=gt_cut_fullbg gt_show] div[class=gt_cut_fullbg_slice]");
        for(Element element:eles){
            String fullImg=element.attr("style");
            fullImgUrl.add(fullImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=fullImg.split("background-position:")[1].split(";")[0].trim();
            String[] fullImgTopLeftPoint=new String[2];
            fullImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            fullImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            System.out.println(fullImgTopLeftPoint[0]+"-"+ fullImgTopLeftPoint[1]);
            fullImgTopLeftPointList.add(fullImgTopLeftPoint);
        }
        Boolean dgjudge=combineImages(dgImgUrl,dgImgTopLeftPointList,26,10,58,"E://极验图片/1_dg.webp","webp");
        Boolean fulljudge=combineImages(fullImgUrl,fullImgTopLeftPointList,26,10,58,"E://极验图片/1_full.webp","webp");
        System.out.println("dgjudge:"+dgjudge);
        System.out.println("fulljudge:"+fulljudge);
        int left=findXDiffRectangeOfTwoImage("E://极验图片/1_dg.webp","E://极验图片/1_full.webp");
        System.out.println(left);
        javascriptExecutor.executeScript("");
        WebElement element = driver.findElement(By.className("gt_slider_knob gt_show"));//(".gt_slider_knob"));
        Point location = element.getLocation();
        element.getSize();
        Actions action = new Actions(driver);
        action.clickAndHold().perform();// 鼠标在当前位置点击后不释放
        action.clickAndHold(element).perform();// 鼠标在 onElement 元素的位置点击后不释放
        Thread.sleep(2000);
        action.clickAndHold(element).moveByOffset(location.x+left,location.y).release().perform(); //选中source元素->拖放到（xOffset,yOffset）位置->释放左键






    }

    public Document getCode(WebDriver driver) throws InterruptedException {
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
        WebElement webMainElement=driver.findElement(By.xpath("/html"));
        Document document=Jsoup.parse(webMainElement.getAttribute("outerHTML"));
        return document;
    }


    public static boolean combineImages(List<String> imgSrcList, List<String[]> topLeftPointList, int countOfLine, int cutWidth, int cutHeight, String savePath, String subfix) {
        if (imgSrcList == null || savePath == null || savePath.trim().length() == 0) return false;
        BufferedImage lastImage = new BufferedImage(cutWidth * countOfLine, cutHeight * ((int) (Math.floor(imgSrcList.size() / countOfLine))), BufferedImage.TYPE_INT_RGB);
        String prevSrc = "";
        BufferedImage prevImage = null;
        try {
            for (int i = 0; i < imgSrcList.size(); i++) {
                String src = imgSrcList.get(i);
                BufferedImage image;
                if (src.equals(prevSrc)) image = prevImage;
                else {
                    if (src.trim().toLowerCase().startsWith("http"))
                        image = ImageIO.read(new URL(src));
                    else
                        image = ImageIO.read(new File(src));
                    prevSrc = src;
                    prevImage = image;

                }
                if (image == null) continue;
                String[] topLeftPoint = topLeftPointList.get(i);
                int[] pixArray = image.getRGB(0 - Integer.parseInt(topLeftPoint[0].trim()), 0 - Integer.parseInt(topLeftPoint[1].trim()), cutWidth, cutHeight, null, 0, cutWidth);
                int startX = ((i) % countOfLine) * cutWidth;
                int startY = ((i) / countOfLine) * cutHeight;

                lastImage.setRGB(startX, startY, cutWidth, cutHeight, pixArray, 0, cutWidth);
            }
            File file = new File(savePath);
            System.out.println(lastImage+"---"+subfix+"---"+file);
            return ImageIO.write(lastImage, subfix, file);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static int findXDiffRectangeOfTwoImage(String imgSrc1, String imgSrc2) {
        try {
            BufferedImage image1 = ImageIO.read(new File(imgSrc1));
            BufferedImage image2 = ImageIO.read(new File(imgSrc2));
            int width1 = image1.getWidth();
            int height1 = image1.getHeight();
            int width2 = image2.getWidth();
            int height2 = image2.getHeight();

            if (width1 != width2) return -1;
            if (height1 != height2) return -1;

            int left = 0;
            /**
             * 从左至右扫描
             */
            boolean flag = false;
            for (int i = 0; i < width1; i++) {
                for (int j = 0; j < height1; j++)
                    if (isPixelNotEqual(image1, image2, i, j)) {
                        left = i;
                        flag = true;
                        break;
                    }
                if (flag) break;
            }
            return left;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    private static boolean isPixelNotEqual(BufferedImage image1, BufferedImage image2, int i, int j) {
        int pixel1 = image1.getRGB(i, j);
        int pixel2 = image2.getRGB(i, j);

        int[] rgb1 = new int[3];
        rgb1[0] = (pixel1 & 0xff0000) >> 16;
        rgb1[1] = (pixel1 & 0xff00) >> 8;
        rgb1[2] = (pixel1 & 0xff);

        int[] rgb2 = new int[3];
        rgb2[0] = (pixel2 & 0xff0000) >> 16;
        rgb2[1] = (pixel2 & 0xff00) >> 8;
        rgb2[2] = (pixel2 & 0xff);

        for (int k = 0; k < 3; k++)
            if (Math.abs(rgb1[k] - rgb2[k]) > 50)//因为背景图会有一些像素差异
                return true;

        return false;
    }




    public static void main(String [] args) throws Exception {
        ExtremeVerification extremeVerification=new ExtremeVerification();
        System.out.println(System.getProperty("java.library.path"));
        extremeVerification.mainProcess();

    }


}
