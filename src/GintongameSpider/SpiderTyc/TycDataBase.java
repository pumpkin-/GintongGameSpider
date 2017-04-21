package GintongameSpider.SpiderTyc;

import GintongameSpider.SpiderLG.TycUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/7.
 */
public class TycDataBase {
    public static void main(String [] args) throws Exception {
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/big_data?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String selectSql="select * from finance_info_huangda";
        System.out.println(selectSql);
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(selectSql);
        List<String> nameList=new ArrayList<String>();
        int n=0;
        while(rs.next()){
            if(18110<=n&&n<=18200) {
                String fullname = rs.getString("fullname");
                nameList.add(fullname);
                System.out.println(fullname);
            }
            n++;
        }
//        List<String> ipList=new ArrayList<String>();
//        String useIp=null;
//        org.jsoup.nodes.Document doc1=Jsoup.connect("http://www.xdaili.cn/ipagent//privateProxy/getDynamicIP/MF20174182996HjChgo/d0d4ced0f83211e6942200163e1a31c0?returnType=1")
//                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").timeout(100000)
//                .get();
//
//        Pattern pattern=Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}:[0-9]{1,6}");
//        Matcher mat=pattern.matcher(doc1.toString());
//        System.out.println(doc1.toString());
//        while(mat.find()){
//            String ip=mat.group(0);
//            useIp=ip;
//        }

        TycUpdate tycUpdate=new TycUpdate();
        //TycTwo tycTwo=new TycTwo();
        for(int i=0;i<nameList.size();i++){
            try {
                //tycTwo.getBussinessDataByList(nameList.get(i),useIp);
                tycUpdate.getBussinessDataByList(nameList.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
