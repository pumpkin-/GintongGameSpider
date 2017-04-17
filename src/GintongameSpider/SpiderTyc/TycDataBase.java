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

            if(0<=n&&n<=100) {
                String fullname = rs.getString("fullname");
                nameList.add(fullname);
                System.out.println(fullname);
            }
            n++;
        }
        TycUpdate tycUpdate=new TycUpdate();
        for(int i=0;i<nameList.size();i++){
            try {
                tycUpdate.getBussinessDataByList(nameList.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
