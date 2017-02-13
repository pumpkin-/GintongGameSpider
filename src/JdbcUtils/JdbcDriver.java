package JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作工具类
 * @author lamp
 *
 */
public class JdbcDriver {

    //数据库连接地址
    public static String URL;
    //用户名
    public static String USERNAME;
    //密码
    public static String PASSWORD;
    //mysql的驱动类
    public static String DRIVER;


    private static  Connection GTCOMconn = null;

    private JdbcDriver(){}

    //使用静态块加载驱动程序
    static{
        URL ="jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true" +
                "&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        USERNAME = "gtcom";
        PASSWORD = "admin@gt.com1";
        DRIVER = "com.mysql.jdbc.Driver";
        try {
            try {
                Class.forName(DRIVER).newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义一个获取数据库连接的方法
    public static Connection getGTCOMConnection(){
        if(GTCOMconn == null) {
            try {
                GTCOMconn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("获取连接失败");
            }
        }
        return GTCOMconn;
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param stat
     * @param conn
     */
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
