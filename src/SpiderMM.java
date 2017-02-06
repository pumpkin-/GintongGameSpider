import com.google.gson.Gson;
import maimaiBean.Maimai;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/1/16.
 */
public class SpiderMM {
    public static void main(String args[]) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driver1="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://123.59.74.132:3306/big_data?useUnicode=true&amp;charsetEncoding=utf8&useCursorFetch=true&defaultFetchSize=100?useUnicode=true&characterEncoding=utf-8";
        String username="gtcom";
        String password="admin@gt.com1";
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);

        String insertMaimai_peo="insert into maimai_peo(ID_maimai,name,com_now,position_now,rank_now,hometown,home_now,mobile,tags,email,create_time) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps1=con.prepareStatement(insertMaimai_peo);


        String insertMaimai_exp="insert into maimai_exp(maimai_id,name,com_now,position_now,rank_now,hometown,home_now,mobile,tags,email,account,exp_com,exp_start,exp_end,exp_position,exp_description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps2=con.prepareStatement(insertMaimai_exp);


        String insertMaimai_edu="insert into maimai_edu(maimai_id,name,com_now,position_now,rank_now,hometown,home_now,mobile,tags,email,account,edu_school,edu_start,edu_end,edu_department,edu_description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps3=con.prepareStatement(insertMaimai_edu);


        String encoding="UTF-8";
        String links=null;
        int a=1;
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        String noedate=formatter.format(date);
                File file3=new File("/data/kcy/RTest/data/"+noedate);
                File[] tempList2=file3.listFiles();
                for(int i=0;i<tempList2.length;i++){
                    if(tempList2[i].isFile()){
                        File file2=new File(tempList2[i].toString());
                        System.out.println(tempList2[i]);
                        FileInputStream ff=new FileInputStream(file2);
                        InputStreamReader rr=new InputStreamReader(ff,encoding);
                        BufferedReader buffer=new BufferedReader(rr);
                        String link=null;
                        while((link=buffer.readLine())!=null){
                            links=link;
                        }
                        Gson gson = new Gson();
                        Maimai maimai = gson.fromJson(links, Maimai.class);
                        System.out.println(maimai.data.card.id);
                        String name=maimai.data.card.name;
                        String com_now=maimai.data.card.company;
                        String mmid=maimai.data.card.mmid;
                        String position_now=maimai.data.card.position;
                        String rank=maimai.data.card.rank;
                        System.out.println(maimai.data.card.avatar);
                        String diqu=maimai.data.card.province+maimai.data.card.city;
                        String tags=maimai.data.uinfo.weibo_tags.toString();
                        String mobile=maimai.data.uinfo.mobile;
                        System.out.println(maimai.data.uinfo.phone);
                        String email=maimai.data.uinfo.email;
                        String jiaxiang=maimai.data.uinfo.ht_province+maimai.data.uinfo.ht_city;
                        String account=maimai.data.uinfo.account;
                        System.out.println(maimai.data.uinfo.noaccount);
                        System.out.println(maimai.data.uinfo.noemail);
                        System.out.println(maimai.data.uinfo.nomobile);
                        System.out.println(maimai.data.uinfo.xingzuo);
                        System.out.println(maimai.data.uinfo.praised);
                        Long time=System.currentTimeMillis();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String shijian=simpleDateFormat.format(new Date(time));
                        ps1.setString(1,mmid);
                        ps1.setString(2,name);
                        ps1.setString(3,com_now);
                        ps1.setString(4,position_now);
                        ps1.setString(5,rank);
                        ps1.setString(6,jiaxiang);
                        ps1.setString(7,diqu);
                        ps1.setString(8,mobile);
                        ps1.setString(9,tags);
                        ps1.setString(10,email);
                        ps1.setString(11,shijian);
                        ps1.addBatch();

                        if(maimai.data.uinfo.work_exp!=null) {
                            for (int x = 0; x < maimai.data.uinfo.work_exp.size(); x++) {
                                System.out.println(maimai.data.uinfo.work_exp.get(x).id);
                                System.out.println(maimai.data.uinfo.work_exp.get(x).uid);
                                String exp_com = maimai.data.uinfo.work_exp.get(x).company;
                                String exp_position = maimai.data.uinfo.work_exp.get(x).position;
                                String com_start = maimai.data.uinfo.work_exp.get(x).start_date;
                                String com_end = maimai.data.uinfo.work_exp.get(x).end_date;
                                String exp_description = maimai.data.uinfo.work_exp.get(x).description;
                                System.out.println(maimai.data.uinfo.work_exp.get(x).company_info.url);
                                System.out.println(maimai.data.uinfo.work_exp.get(x).company_info.people);
                                System.out.println(maimai.data.uinfo.work_exp.get(x).company_info.share_url);
                                System.out.println(maimai.data.uinfo.work_exp.get(x).company_info.city);
                                System.out.println(maimai.data.uinfo.work_exp.get(x).company_info.clogo);

                                ps2.setString(1, mmid);
                                ps2.setString(2, name);
                                ps2.setString(3, com_now);
                                ps2.setString(4, position_now);
                                ps2.setString(5, rank);
                                ps2.setString(6, jiaxiang);
                                ps2.setString(7, diqu);
                                ps2.setString(8, mobile);
                                ps2.setString(9, tags);
                                ps2.setString(10, email);
                                ps2.setString(11, account);
                                ps2.setString(12, exp_com);
                                ps2.setString(13, com_start);
                                ps2.setString(14, com_end);
                                ps2.setString(15, exp_position);
                                ps2.setString(16, exp_description);
                                ps2.addBatch();
                            }
                        }
                        if(maimai.data.uinfo.education!=null) {
                            for (int y = 0; y < maimai.data.uinfo.education.size(); y++) {
                                System.out.println(maimai.data.uinfo.education.get(y).id);
                                System.out.println(maimai.data.uinfo.education.get(y).uid);
                                String edu_school = maimai.data.uinfo.education.get(y).school;
                                String edu_department = maimai.data.uinfo.education.get(y).department;
                                String edu_start = maimai.data.uinfo.education.get(y).start_date;
                                String edu_end = maimai.data.uinfo.education.get(y).end_date;
                                String edu_description = maimai.data.uinfo.education.get(y).description;

                                ps3.setString(1, mmid);
                                ps3.setString(2, name);
                                ps3.setString(3, com_now);
                                ps3.setString(4, position_now);
                                ps3.setString(5, rank);
                                ps3.setString(6, jiaxiang);
                                ps3.setString(7, diqu);
                                ps3.setString(8, mobile);
                                ps3.setString(9, tags);
                                ps3.setString(10, email);
                                ps3.setString(11, account);
                                ps3.setString(12, edu_school);
                                ps3.setString(13, edu_start);
                                ps3.setString(14, edu_end);
                                ps3.setString(15, edu_department);
                                ps3.setString(16, edu_description);
                                ps3.addBatch();
                            }
                        }
                        if(a%25==0){
                            ps1.executeBatch();
                            ps2.executeBatch();
                            ps3.executeBatch();
                        }
                        System.out.println("第"+a+"条");
                        System.out.println("读到"+tempList2[i]);
                        a++;
                        System.out.println("-------------------------------------------");
                    }
                }



    }
}