package JavaBean;

import org.dom4j.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.InputStream;

/**
 * Created by lenovo on 2017/2/17.
 */
public class BaseKnowLedge {
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public org.dom4j.Document getDocsax() {
        return docsax;
    }

    public void setDocsax(org.dom4j.Document docsax) {
        this.docsax = docsax;
    }

    public Element getRoot() {
        return root;
    }

    public void setRoot(Element root) {
        this.root = root;
    }

    private  WebDriver driver;
    private  WebElement webElement;
    private  Document doc;
    private Elements elements;
    private InputStream inputStream;
    private org.dom4j.Document docsax;
    private Element root;


}
