package organizeUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by lenovo on 2017/2/21.
 */
public class organizeUtils {
    public static void getElement(String element) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream fileInputStream=new FileInputStream(organizeUtils.class.getClassLoader().getResource("organizeUtils/BasKnowledgePattern.xml").getFile());
        Document docsax=saxReader.read(fileInputStream);
        Element root=docsax.getRootElement();
        Element website=root.element(element).element("knowledge").element("website");

    }
}
