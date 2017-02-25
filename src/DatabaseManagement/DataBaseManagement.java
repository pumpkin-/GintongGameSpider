package DatabaseManagement;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/20.
 */
public class DataBaseManagement {
    public static void main(String [] args) throws Exception {
        Map<String,String> mainMap=new HashMap<String,String>();
        Map<String,String> coverMap=new HashMap<String, String>();
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String queryAllSql="select * from pro_knowledge_copy";
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(queryAllSql);
        String updateMainSql="update pro_knowledge_copy set main=? where uuid=? ";
        String updateCoverSqlSrc="update pro_knowledge_copy set cover=? where uuid=?";
        PreparedStatement ps=con.prepareStatement(updateMainSql);
        PreparedStatement ps1=con.prepareStatement(updateCoverSqlSrc);
        String updateCoverSqlQM="update pro_knowledge_copy set cover=replace(cover,'<img src=\"','')";
        String updateCoverSqlHM="update pro_knowledge_copy set cover=replace(cover,'\">','')";
        String updateCoverSqlQ="update pro_knowledge_copy set cover=replace(cover,'<img src=','')";
        String updateCoverSqlH="update pro_knowledge_copy set cover=replace(cover,'>','')";
        sta.executeUpdate(updateCoverSqlQM);
        sta.executeUpdate(updateCoverSqlHM);
        sta.executeUpdate(updateCoverSqlQ);
        sta.executeUpdate(updateCoverSqlH);
        while(rs.next()){
            String main=rs.getString("main");
            String uuid=rs.getString("uuid");
            String cover=rs.getString("cover");
            if(main!=null) {
                main = main.replaceAll("\\.([a-z]{3,})>", "\\.$1\">");
                main = main.replaceAll("src=h", "src=\"h");
                mainMap.put(uuid, main);
            }
            if(cover.contains("?src=")){
                Pattern pat=Pattern.compile("(?<=\\?src=).+\\.jpg");
                Matcher mat=pat.matcher(cover);
                while(mat.find()){
                    coverMap.put(uuid,mat.group(0));
                }
            }

        }

        Set<String> uuid= mainMap.keySet();
        for(String uuid1:uuid){
            ps.setString(1, mainMap.get(uuid1));
            ps.setString(2, uuid1);
            ps.executeUpdate();
        }

        Set<String> coverUuid=coverMap.keySet();
        for(String uuid1:coverUuid){
            ps1.setString(1,coverMap.get(uuid1));
            ps1.setString(2,uuid1);
            ps1.executeUpdate();
        }



    }
}


