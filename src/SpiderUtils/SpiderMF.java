package SpiderUtils;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.DocumentException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by 123 on 2017/2/22.
 */
public class SpiderMF {
    public static void main(String[] args)  {
        try {
            SpiderUtils.getElements("windows", "spiderMf", 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
