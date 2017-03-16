package SpiderUtils;
import JavaBean.ProKnowledge;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;

import com.google.gson.Gson;

import com.gargoylesoftware.htmlunit.activex.javascript.msxml.XMLSerializer;

import dao.impl.ProKnowledgeImpl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) throws ParserConfigurationException, XpathSyntaxErrorException, SpiderUtils.FormatEexception, DocumentException, IOException, ProKnowledgeImpl.FormatEexception, InterruptedException, ParseException {

    }
}
