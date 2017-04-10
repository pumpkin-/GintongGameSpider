package GintongameSpider.SpiderLG;

import dao.BasPersonInfoDao;
import dao.impl.BasPersonInfoImpl;

import java.util.List;

/**
 * Created by admin on 2017/4/7.
 */
public class TestN {
    public static void main(String [] args){
        BasPersonInfoDao basPersonInfoDao=new BasPersonInfoImpl();
        List<String> basPersonInfoList=basPersonInfoDao.selectList("天眼查");
        for(int i=0;i<basPersonInfoList.size();i++){
            System.out.println(basPersonInfoList.get(i));
        }
    }
}
