package DatabaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by lenovo on 2017/3/27.
 */
public class DataBaseDuplicateRemoval {
    public static List<String> idList=new ArrayList<String>();
    public static List<String> nameList=new ArrayList<String>();

    public static void duplicateRemoval(String tableName,String source,String columnName ) throws Exception {
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String selectSql="select * from "+tableName+" where source='"+source+"'";
        System.out.println(selectSql);
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(selectSql);
        while(rs.next()){
            String id=rs.getString("id");
            String name=rs.getString(columnName);
            idList.add(id);
            nameList.add(name);
        }
        System.out.println("id的长度:"+idList.size());
        System.out.println("名字的长度:"+nameList.size());
        for(int i=0;i<idList.size();i++){
            for(int j=idList.size()-1;j>i;j--){
                if(nameList.get(i).equals(nameList.get(j))){
                    String deleteSql="delete from "+tableName+" where id='"+idList.get(j)+"'";
                    System.out.println(deleteSql);
                    sta.executeUpdate(deleteSql);
                }
            }
        }
        close();
    }

    public static void close() {
        idList.clear();
        nameList.clear();
    }

    public static void main(String [] args) throws Exception {
        DataBaseDuplicateRemoval.duplicateRemoval("bas_organize_info","天眼查","oname");

    }
}
