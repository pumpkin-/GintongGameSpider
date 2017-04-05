package SpiderUtils.SpiderData;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by lenovon on 2017/3/31.
 */
public class CommonProduct {
    public static void ergodicUrl(String WebName,String url,String uuid) throws IOException, XpathSyntaxErrorException, DocumentException {
        JXDocument doc=CommonMobileGamesProduct.getJXDocument(url.trim());
        String type=doc.selOne("//div[@class='fr game_dq_detail m_t15']/p[1]/text()").toString().split("/")[0];
        System.out.println(type);
        if(type.trim().equals("手机游戏")){
            System.out.println("---------------手机游戏-----------------");
            CommonMobileGamesProduct.ergodicUrl(WebName,url,uuid);
        }else if(type.trim().equals("客户端游戏")){
            System.out.println("----------------客户端游戏-----------------");
            CommonPCGamesProduct.ergodicUrl(WebName, url, uuid);
        }else if(type.trim().equals("网页游戏")){
            System.out.println("---------------网页游戏-----------------");
            CommonHTMLGamesProduct.ergodicUrl(WebName,url,uuid);
        }
    }
    public static void main(String[] args) throws DocumentException, XpathSyntaxErrorException, IOException {
        CommonProduct.ergodicUrl("spider","http://cs.kaifu.com/platforminfogame-wanmeishijie-3-3-0-0.html",UUID.randomUUID().toString());
    }
}
