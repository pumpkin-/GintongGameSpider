package GintongameSpider.SpiderLxm;

import JavaBean.BasKnowledgeInfo;
import JavaBean.BasPersonInfo;
import JavaBean.PerKnowledge;
import SpiderUtils.*;
import dao.impl.BasKnowledgeInfoDaoImpl;;
import java.text.ParseException;
import java.util.*;


/**
 * Created by lenovon on 2017/3/3.
 */
public class HW {
    public static void main(String[] args) throws ParseException{
        List<BasKnowledgeInfo> list=new ArrayList<BasKnowledgeInfo>();
        BasKnowledgeInfo basKnowledgeInfo=new BasKnowledgeInfo();
        BasKnowledgeInfo basKnowledgeInfo1=new BasKnowledgeInfo();
        String kuuid=UUID.randomUUID().toString();
        basKnowledgeInfo.setUuid(kuuid);
        basKnowledgeInfo.setTitle("测试");
        basKnowledgeInfo.setMain("我们有太多的东西日用而不知，它们累积起来变成我们的肌肉记忆和本能反应，这些日用而不知的认知假设，像黑洞一样把信息时代的光芒掠夺殆尽。");
        basKnowledgeInfo.setCover("http://www.baidu.com");
        basKnowledgeInfo.setUrl("http://ww.baidu.com");
        basKnowledgeInfo.setPtime("2017-04-25 10:34:47");
        basKnowledgeInfo.setSource("测试数据");
        String kuuid1=UUID.randomUUID().toString();
        basKnowledgeInfo1.setUuid(kuuid1);
        basKnowledgeInfo1.setTitle("测试1");
        basKnowledgeInfo1.setMain("时代纷繁复杂，忙碌的人们，终要面对自己的内心，而这种面对，在今天，变得更难，却也更急迫。我们都需要答案。");
        basKnowledgeInfo1.setCover("http://www.baidu.com1");
        basKnowledgeInfo1.setUrl("http://ww.baidu.com1");
        basKnowledgeInfo1.setPtime("2017-04-25 14:47:47");
        basKnowledgeInfo1.setSource("测试数据");
        list.add(basKnowledgeInfo);
        list.add(basKnowledgeInfo1);
        List<BasPersonInfo> list1=new ArrayList<BasPersonInfo>();
        BasPersonInfo basPersonInfo=new BasPersonInfo();
        basPersonInfo.setName("傅斯年");
        basPersonInfo.setSource("测试数据");
        basPersonInfo.setUrl("http://www/baidu.com");
        String puuid=UUID.randomUUID().toString();
        basPersonInfo.setUuid(puuid);
        BasPersonInfo basPersonInfo1=new BasPersonInfo();
        basPersonInfo1.setName("傅斯年1");
        basPersonInfo1.setSource("测试数据");
        basPersonInfo1.setUrl("http://www/baidu.com1");
        String puuid1=UUID.randomUUID().toString();
        basPersonInfo.setUuid(puuid1);
        list1.add(basPersonInfo);
        list1.add(basPersonInfo1);
        List<PerKnowledge>  list2=new ArrayList<PerKnowledge>();
        PerKnowledge perKnowledge=new PerKnowledge();
        PerKnowledge perKnowledge1=new PerKnowledge();
        perKnowledge.setName("傅斯年");
        perKnowledge.setSource("测试数据");
        perKnowledge.setKname("测试");
        perKnowledge.setPuuid(puuid);
        perKnowledge.setKuuid(kuuid);
        list2.add(perKnowledge);
        perKnowledge.setName("傅斯年1");
        perKnowledge.setSource("测试数据");
        perKnowledge.setKname("测试1");
        perKnowledge.setPuuid(puuid1);
        perKnowledge.setKuuid(kuuid1);
        list2.add(perKnowledge);
        BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl=new BasKnowledgeInfoDaoImpl();
        try {
            basKnowledgeInfoDaoImpl.insertBatchAutoDedup(list,list1,list2);
        } catch (SpiderUtils.FormatEexception formatEexception) {
            formatEexception.printStackTrace();
        } catch (BasKnowledgeInfoDaoImpl.FormatEexception formatEexception) {
            formatEexception.printStackTrace();
        }
//        try {
//          for(int i=0;i<list.size();i++){
//              Map<Integer,List> map= LevenshteinDis.isExist(list,list1,list2);
//              System.out.println("111111111111111111111111111111111111");
//              System.out.println(map);
//              System.out.println("222222222222222222222222222222222222");
//          }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
