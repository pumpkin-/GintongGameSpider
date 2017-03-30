package DatabaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */
public class DataBaseDateManagement {
    public static void main(String [] args) throws Exception {
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String selectSql="select pwi.id as pid,pwi.start_date as starttime,pwi.end_date as endtime from bas_person_info bpi,per_education_info pwi where bpi.uuid=pwi.uuid and pwi.start_date is not null and pwi.start_date != '' and source='游戏智聘'";
        System.out.println(selectSql);
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(selectSql);
        List<String> startTimeList=new ArrayList<String>();
        List<String> endTimeList=new ArrayList<String>();
        List<String> idList=new ArrayList<String>();
        while(rs.next()){
            String startTime=rs.getString("starttime");
            String endTime=rs.getString("endtime");
            String id=rs.getString("pid");
            startTimeList.add(startTime);
            endTimeList.add(endTime);
            idList.add(id);
        }
        for(int i=0;i<startTimeList.size();i++){
            try {
                        String id = idList.get(i);
                        String start_time=null;
                        String end_time=null;
                        start_time = startTimeList.get(i);
                        end_time =endTimeList.get(i);
                        if(start_time.contains("-")){
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            DateFormat fmt = new SimpleDateFormat("yyyy-MM");
                            Date start_date = fmt.parse(start_time);
                            start_time = formatter.format(start_date);
                        }else{
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            DateFormat fmt = new SimpleDateFormat("yyyy");
                            Date start_date = fmt.parse(start_time);
                            start_time = formatter.format(start_date);
                        }
                        if(end_time.contains("-")){
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            DateFormat fmt = new SimpleDateFormat("yyyy-MM");
                            if (!end_time.contains("至今")) {
                                Date end_date = fmt.parse(end_time);
                                end_time = formatter.format(end_date);
                            } else {
                                end_time = "至今";
                            }
                        }else{
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            DateFormat fmt = new SimpleDateFormat("yyyy");
                            if (!end_time.contains("至今")) {
                                Date end_date = fmt.parse(end_time);
                                end_time = formatter.format(end_date);
                            } else {
                                end_time = "至今";
                            }
                        }

//                    start_time = start_time.replace("年", ".").replace("月", "");
//                    end_time = end_time.replace("年", ".").replace("月", "").split("\\[")[0];
                    System.out.println("start_time:" + start_time);
                    System.out.println("end_time:" + end_time);
                    System.out.println("id:" + id);
//                    System.out.println("start_time:" + start_time);
//                    System.out.println("end_time:" + end_time);
                    String updateSql = "update per_education_info set start_time='" + start_time + "',end_time='" + end_time + "'  where id='" + id + "'";
                    System.out.println(updateSql);
                    sta.executeUpdate(updateSql);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
