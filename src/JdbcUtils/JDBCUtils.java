package JdbcUtils;

import java.sql.SQLException;

import JdbcUtils.JdbcDriver;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author byron 2017.1.6
 *
 */
public class JDBCUtils {

    private static PreparedStatement preparedStatement;
    /**
     *
     * @param name							姓名
     * @param enname						英语姓名
     * @param alias							别名
     * @param country						国家
     * @param nation						民族
     * @param con_way						联系方式
     * @param id_number						身份证号
     * @param birthday						出生日期
     * @param household_register			户籍地
     * @param liveplace						居住地
     * @param marital_status				婚姻状况：0未婚，1已婚，2再婚，3离异
     * @param employment					工作状况：0无业，1在职，2兼职，3创业
     * @param diploma						学历学位
     * @param work_years					工龄
     * @param child_status					是否有孩子：0无，1有
     * @param live_photo					生活照
     * @param occu_photo					职业照
     * @param art_photo						艺术照
     * @param ptag							个人标签
     * @param p_desc						个人描述
     * @param type							数据视角：0只对内，1可对外
     * @param advantage						个人优势
     * @param age							年龄
     * @param sex							性别
     * @param hometown						籍贯
     * @param source						数据来源
     * @param url							个人信息链接
     * @return
     * @throws SQLException
     */
    public static PreparedStatement insertBasPersonInfo(String uuid,String name, String enname,String age,String alias,String hometown,String country,String nation,String con_way,String sex,String id_number,String birthday,String household_register,String liveplace,String marital_status,String employment,String diploma,String work_years,String child_status,String live_photo,String occu_photo,String art_photo,String ptag,String p_desc, String source, String url,String type,String advantage,int a,double b) throws SQLException {
        //sql语句
        String sql = "insert into bas_person_info(uuid,name,enname,age,alias,hometown,country,nation,con_way,sex,id_number,birthday,household_register,liveplace,marital_status,employment,diploma,work_years,child_status,live_photo,occu_photo,art_photo,ptag,p_desc,source,url,type,advantage) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            //清理执行对象
            preparedStatement.clearParameters();
        }
        //执行
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql);
        //提交队列
        preparedStatement.setString(1,uuid);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,enname);
        preparedStatement.setString(4,age);
        preparedStatement.setString(5,alias);
        preparedStatement.setString(6,hometown);
        preparedStatement.setString(7,country);
        preparedStatement.setString(8,nation);
        preparedStatement.setString(9,con_way);
        preparedStatement.setString(10,sex);
        preparedStatement.setString(11,id_number);
        preparedStatement.setString(12,birthday);
        preparedStatement.setString(13,household_register);
        preparedStatement.setString(14,liveplace);
        preparedStatement.setString(15,marital_status);
        preparedStatement.setString(16,employment);
        preparedStatement.setString(17,diploma);
        preparedStatement.setString(18,work_years);
        preparedStatement.setString(19,child_status);
        preparedStatement.setString(20,live_photo);
        preparedStatement.setString(21,occu_photo);
        preparedStatement.setString(22,art_photo);
        preparedStatement.setString(23,ptag);
        preparedStatement.setString(24,p_desc);
        preparedStatement.setString(25,source);
        preparedStatement.setString(26,url);
        preparedStatement.setString(27,type);
        preparedStatement.setString(28,advantage);
        preparedStatement.addBatch();
        return  preparedStatement;
    }
    public static PreparedStatement insertBasOrganizeInfo(String oname,String ename,String shortname,String fullname,String web,String con_way,String industry,String scale,String introduce,String address,String logo,String stime,String other,String source,String url,String uuid,String type,String financing_info,String picture,String development_history,String financing_stage,String company_nature,String corporate_culture,String tag,String management_field,int a,double b) throws SQLException {
        String sql="insert into bas_organize_info(oname,ename,shortname,fullname,web,con_way,industry,scale,introduce,address,logo,stime,other,source,url,uuid,type,financing_info,picture,development_history,financing_stage,company_nature,corporate_culture,tag,management_field) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{oname,ename,shortname,fullname,web,con_way,industry,scale,introduce,address,logo,stime,other,source,url,uuid,type,financing_info,picture,development_history,financing_stage,company_nature,corporate_culture,tag,management_field});

        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertOrgProduct(String oname,String pname,String rtype,String rgrade,String rg_desc,String ouuid,String pr_uuid,String source,int a,double b) throws SQLException {
        String sql="insert into org_product(oname,pname,rtype,rgrade,rg_desc,ouuid,pr_uuid,source) values(?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{oname,pname,rtype,rgrade,rg_desc,ouuid,pr_uuid,source});
        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertPerOrganize(String name,String oname,String org_desc,String revent,String rtype,String rgrade,String rg_desc,String job,String puuid,String ouuid,String source,int a,double b) throws SQLException {
        String sql="insert into per_organize(name,oname,org_desc,revent,rtype,rgrade,rg_desc,job,puuid,ouuid,source) values(?,?,?,?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{name,oname,org_desc,revent,rtype,rgrade,rg_desc,job,puuid,ouuid,source});
        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertPerPooduct(String name,String pname,String rtype,String rgrade,String rp_desc,String puuid,String pr_uuid,String source,int a,double b) throws SQLException {
        String sql="insert into per_product(name,pname,rtype,rgrade,rp_desc,puuid,pr_uuid,source) values(?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{name,pname,rtype,rgrade,rp_desc,puuid,pr_uuid,source});
        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertProGameInfo(String gname,String gename,String logo,String version,String language,String network_type,String suitable_age,String issue_area,String publisher,String gstyle,String gtags,String picture,String viewpoint,String engine,String grade,String dpprogress,String gtheme,String scale,String pdemand,String price,String charge_mode,String develop_com,String g_desc,String ptime,String beta_time,String test_time,String betatest_time,String set_time,String web,String url,String source,String uuid,String operator,String films_time,String gamespy,String game_size,String web_update_time,String download_link,int a,double b) throws SQLException {
        String sql="insert into pro_game_info(gname,gename,logo,version,language,network_type,suitable_age,issue_area,publisher,gstyle,gtags,picture,viewpoint,engine,grade,dpprogress,gtheme,scale,pdemand,price,charge_mode,develop_com,g_desc,ptime,beta_time,test_time,betatest_time,set_time,web,url,source,uuid,operator,films_time,gamespy,game_size,web_update_time,download_link) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{gname,gename,logo,version,language,network_type,suitable_age,issue_area,publisher,gstyle,gtags,picture,viewpoint,engine,grade,dpprogress,gtheme,scale,pdemand,price,charge_mode,develop_com,g_desc,ptime,beta_time,test_time,betatest_time,set_time,web,url,source,uuid,operator,films_time,gamespy,game_size,web_update_time,download_link});
        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertProKnowledge(String uuid,String author,String title,String cover,String tag,String main,String ptime,String type,String url,String source,int a,double b) throws SQLException {
        String sql="insert into pro_knowledge(uuid,author,title,cover,tag,main,ptime,type,url,source) values(?,?,?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{uuid,author,title,cover,tag,main,ptime,type,url,source});
        preparedStatement.addBatch();
        return preparedStatement;
    }
    public static PreparedStatement insertPerKnowledge(String name,String kname,String rtype,String rgrade,String rp_desc,String puuid,String kuuid,String source,int a,double b) throws SQLException {
        String sql="insert into per_knowledge(name,kname,rtype,rgrade,rp_desc,puuid,kuuid,source) values(?,?,?,?,?,?,?,?)";
        if(preparedStatement != null) {
            preparedStatement.clearParameters();
        }
        preparedStatement=(PreparedStatement) JdbcDriver.getGTCOMConnection().prepareStatement(sql, new String[]{name,kname,rtype,rgrade,rp_desc,puuid,kuuid,source});
        preparedStatement.addBatch();
        return preparedStatement;
    }
}
