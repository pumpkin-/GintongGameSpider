package DatabaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/21.
 */
public class Test1 {
    public static void main(String [] args) throws Exception{
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String queryAllSql = "select cover from pro_knowledge_copy";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(queryAllSql);
        while(rs.next()){
            String cover=rs.getString("cover");
            Pattern pat=Pattern.compile("(?<=src=).+\\.jpg");
            Matcher mat=pat.matcher(cover);
            while(mat.find()){
                System.out.println(mat.group(0));
            }
        }
    }
}
