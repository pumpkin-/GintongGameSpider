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


<<<<<<< HEAD
            CommonSpiderKnowledge.ergodicUrl("spiderZOL", 0, "no");
=======
             //跑完
          //  CommonSpiderKnowledge.ergodicUrl("spider52PKRW", 0, "no");
//
//           CommonSpiderKnowledge.ergodicUrl("spider52PKQQ", 0, "no");
//            Thread t1=new Thread(){
//                @Override
//                public void run() {
//                    try {
                          //有null 需要模版｜｜
//                        CommonSpiderKnowledge.ergodicUrl("spider52PKDL", 0, "no");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
          Thread t2=new Thread(){
               @Override
               public void run() {
                    try {
                        CommonSpiderKnowledge.ergodicUrl("spider52PKCY", 158, "no");
                    } catch (Exception e) {
                        e.printStackTrace();
                   }
                }
            };
//           t1.start();
            t2.start();
           // CommonSpiderKnowledge.ergodicUrl("spiderYXC", 0, "no");














>>>>>>> f319437f029f769329288a0701cd5bab8ab5584e
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
