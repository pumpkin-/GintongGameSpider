import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException, SAXException, DocumentException {
       /* System.setProperty("phantomjs.binary.path", "E:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.gamelook.com.cn/2017/01/279393");
        WebElement web=driver.findElement(By.xpath("/html"));
        String html=web.getAttribute("outerHTML");*/
        FileInputStream inputStream=new FileInputStream(new File("C:\\Users\\lenovo\\Desktop\\GintongGameSpider\\src\\SpiderUtils\\BasKnowledgePattern.xml"));
        SAXReader sax=new SAXReader();
        List rowList=null;
        Document doc=sax.read(inputStream);
        rowList=doc.selectNodes("//spider/title");
        for(Iterator iter = rowList.iterator();iter.hasNext();){
            //获得具体的row元素
            Element element = (Element)iter.next();
            //获得row元素的所有属性列表
            List elementList = element.attributes();
            for(Iterator iter1 = elementList.iterator();iter1.hasNext();){
                //将每个属性转化为一个抽象属性，然后获取其名字和值
                AbstractAttribute aa = (AbstractAttribute)iter1.next();
                System.out.println("Name:"+aa.getName()+";Value:"+aa.getValue());
            }
            //输出：
            //Name:queryDTO.enterpriseId;Value:gfd
            //Name:queryDTO.loginName;Value:gdfg
            //Name:queryDTO.state;Value:0
            System.out.println(element.getName());
            //输出：
            //row
            // 取得row元素的queryDTO.enterpriseId属性的值
            System.out.println(element.attributeValue("queryDTO.enterpriseId"));
            //输出：
            //gfd
            //如果element下有子元素，(类似width="**")，要想获得该子元素的值，可以用如下方法
            System.out.println(element.elementText("width"));//因为没有，所以输出为null。
        }
    }
}