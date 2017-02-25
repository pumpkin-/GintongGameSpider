package SpiderUtils;

import SpiderUtils.SpiderUtils;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import dao.impl.ProKnowledgeImpl;
import org.dom4j.DocumentException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by 123 on 2017/2/23.
 */
public class SpiderGameData {
    public static void main(String [] args){
        try {
              SpiderUtils.getElements("windows","spiderYXTL",0,"no");
//            SpiderUtils.getElements("windows","spiderYXG",0,"no");
//            SpiderUtils.getElements("windows","spider18183",0,"no");
//            SpiderUtils.getElements("windows","spiderCDW",0,"no");
//            SpiderUtils.getElements("windows","spiderPc 25g",0,"no");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
