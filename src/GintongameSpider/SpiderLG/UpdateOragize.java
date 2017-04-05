package GintongameSpider.SpiderLG;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/31.
 */
public class UpdateOragize {
    public static void updateOragize(String comName) throws Exception {
        String driver1 = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://123.59.74.132:3306/game_db_qa?useUnicode=true&useCursorFetch=true&defaultFetchSize=100&characterEncoding=utf-8";
        String username = "gtcom";
        String password = "admin@gt.com1";
        String id=null;
        String ouuid=null;
        String ename=null;
        String shortname=null;
        String fullname=null;
        String web=null;
        String con_way=null;
        String industry=null;
        String scale=null;
        String introduce=null;
        String other=null;
        String address=null;
        String logo=null;
        String stime=null;
        String financing_round=null;
        String picture=null;
        String development_history=null;
        String financing_stage=null;
        String financing_total=null;
        String company_nature=null;
        String corporate_culture=null;
        String tag=null;
        String management_field=null;
        String business_plan=null;
        Class.forName(driver1).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        String queryOneSql="select * from bas_organize_info where source='天眼查' and oname like '%"+comName+"%'";
        Statement staOne = con.createStatement();
        ResultSet rsOne = staOne.executeQuery(queryOneSql);
        while(rsOne.next()){
            id=rsOne.getString("id");
            ouuid=rsOne.getString("uuid");
            ename=rsOne.getString("ename");
            shortname=rsOne.getString("shortname");
            fullname=rsOne.getString("fullname");
            web=rsOne.getString("web");
            con_way=rsOne.getString("con_way");
            industry=rsOne.getString("industry");
            scale=rsOne.getString("scale");
            introduce=rsOne.getString("introduce");
            address=rsOne.getString("address");
            logo=rsOne.getString("logo");
            stime=rsOne.getString("stime");
            other=rsOne.getString("other");
            financing_round=rsOne.getString("financing_round");
            picture=rsOne.getString("picture");
            development_history=rsOne.getString("development_history");
            financing_stage=rsOne.getString("financing_stage");
            financing_total=rsOne.getString("financing_total");
            company_nature=rsOne.getString("company_nature");
            corporate_culture=rsOne.getString("corporate_culture");
            tag=rsOne.getString("tag");
            management_field=rsOne.getString("management_field");
            business_plan=rsOne.getString("business_plan");
        }
        String queryAllSql="select * from bas_organize_info where oname like '%"+comName+"%'";
        Statement staAll=con.createStatement();
        ResultSet rsAll=staAll.executeQuery(queryAllSql);
        List<String> uuidList=new ArrayList<String>();
        List<String> idList=new ArrayList<String>();
        while(rsAll.next()){
            if(StringUtils.isNotEmpty(rsAll.getString("uuid"))){
                if(!rsAll.getString("uuid").equals(ouuid)) {
                    String uuid = rsAll.getString("uuid");
                    uuidList.add(uuid);
                    String oid = rsAll.getString("id");
                    idList.add(oid);
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("ename"))){
                if(ename==null) {
                    ename = rsAll.getString("ename");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("shortname"))){
                if(shortname==null) {
                    shortname = rsAll.getString("shortname");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("fullname"))){
                if(fullname==null) {
                    fullname = rsAll.getString("fullname");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("web"))){
                if(web==null) {
                    web = rsAll.getString("web");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("con_way"))){
                if(con_way==null) {
                    con_way = rsAll.getString("con_way");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("industry"))){
                if(industry==null) {
                    industry = rsAll.getString("industry");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("scale"))){
                if(scale==null) {
                    scale = rsAll.getString("scale");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("introduce"))){
                if(introduce==null) {
                    introduce = rsAll.getString("introduce");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("address"))){
                if(address==null) {
                    address = rsAll.getString("address");
                }
            } if(StringUtils.isNotEmpty(rsAll.getString("logo"))){
                if(logo==null) {
                    logo = rsAll.getString("logo");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("stime"))){
                if(stime==null) {
                    stime = rsAll.getString("stime");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("other"))){
                if(other==null) {
                    other = rsAll.getString("other");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("financing_round"))){
                if(financing_round==null) {
                    financing_round = rsAll.getString("financing_round");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("picture"))){
                if(picture==null) {
                    picture = rsAll.getString("picture");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("development_history"))){
                if(development_history==null) {
                    development_history = rsAll.getString("development_history");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("financing_stage"))){
                if(financing_stage==null) {
                    financing_stage = rsAll.getString("financing_stage");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("financing_total"))){
                if(financing_total==null) {
                    financing_total = rsAll.getString("financing_total");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("company_nature"))){
                if(company_nature==null) {
                    company_nature = rsAll.getString("company_nature");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("corporate_culture"))){
                if(corporate_culture==null) {
                    corporate_culture = rsAll.getString("corporate_culture");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("tag"))){
                if(tag==null) {
                    tag = rsAll.getString("tag");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("management_field"))){
                if(management_field==null) {
                    management_field = rsAll.getString("management_field");
                }
            }
            if(StringUtils.isNotEmpty(rsAll.getString("business_plan"))){
                if(business_plan==null) {
                    business_plan = rsAll.getString("business_plan");
                }
            }
        }
        String updateSql=" update bas_organize_info set ename='"+ename+"', shortname='"+shortname+"',\n" +
                "        fullname='"+fullname+"', web='"+web+"', con_way='"+con_way+"',\n" +
                "        industry='"+industry+"', scale='"+scale+"', address='"+address+"',\n" +
                "        logo='"+logo+"', stime='"+stime+"', other='"+other+"',\n" +
                "         financing_stage='"+financing_stage+"', company_nature='"+company_nature+"',\n" +
                "        management_field='"+management_field+"', introduce='"+introduce+"', picture='"+picture+"',\n" +
                "        development_history='"+development_history+"', corporate_culture='"+corporate_culture+"',\n" +
                "        tag='"+tag+"' where uuid='"+ouuid+"'";
        System.out.println(updateSql);
        staAll.executeUpdate(updateSql);

        List<String> businessIdList=new ArrayList<String>();
        List<String> executiveIdList=new ArrayList<String>();
        List<String> investmentList=new ArrayList<String>();
        List<String>  shareholderList=new ArrayList<String>();
        List<String> shareholderTeamList=new ArrayList<String>();
        List<String> orgKnowlageList=new ArrayList<String>();
        List<String> orgProductList=new ArrayList<String>();
        List<String> orgPersonList=new ArrayList<String>();
        List<String> orgContractList=new ArrayList<String>();
        List<String> orgDemandList=new ArrayList<String>();
        List<String> orgEvaList=new ArrayList<String>();
        for(int i=0;i<uuidList.size();i++) {
            String quesyBusinessSql = "select * from bas_business_info where uuid='" +uuidList.get(i)+"'";
            ResultSet rsBusness= staAll.executeQuery(quesyBusinessSql);
            while (rsBusness.next()){
                String itId=rsBusness.getString("id");
                businessIdList.add(itId);
            }
            String queryComExecutiveSql="select * from com_executive_info where uuid='"+uuidList.get(i)+"'";
            ResultSet rsComExecutive= staAll.executeQuery(queryComExecutiveSql);
            while(rsComExecutive.next()){
                String itId=rsComExecutive.getString("id");
                executiveIdList.add(itId);
            }
            String queryInvestmentSql="select * from com_investment_info where uuid='"+uuidList.get(i)+"'";
            ResultSet rsInvestment= staAll.executeQuery(queryInvestmentSql);
            while(rsInvestment.next()){
                String itId=rsInvestment.getString("id");
                investmentList.add(itId);
            }
            String queryShareholderSql="select * from com_shareholder where uuid='"+uuidList.get(i)+"'";
            ResultSet rsShareholder= staAll.executeQuery(queryShareholderSql);
            while(rsShareholder.next()){
                String itId=rsShareholder.getString("id");
                shareholderList.add(itId);
            }
            String queryShareholderTeamSql="select * from com_shareholder_team where uuid='"+uuidList.get(i)+"'";
            ResultSet rsShareholderTeam= staAll.executeQuery(queryShareholderTeamSql);
            while(rsShareholderTeam.next()){
                String itId=rsShareholderTeam.getString("id");
                shareholderTeamList.add(itId);
            }
            String queryOrgKnowledgeSql="select * from org_knowledge where ouuid='"+uuidList.get(i)+"'";
            ResultSet rsOrgKnowledge= staAll.executeQuery(queryOrgKnowledgeSql);
            while(rsOrgKnowledge.next()){
                String itId=rsOrgKnowledge.getString("id");
                orgKnowlageList.add(itId);
            }
            String queryOrgPeoductSql="select * from org_product where ouuid='"+uuidList.get(i)+"'";
            ResultSet rsOrgProduct= staAll.executeQuery(queryOrgPeoductSql);
            while(rsOrgProduct.next()){
                String itId=rsOrgProduct.getString("id");
                orgProductList.add(itId);
            }
            String queryOrgPersonSql="select * from per_organize where ouuid='"+uuidList.get(i)+"'";
            ResultSet rsOrgPerson= staAll.executeQuery(queryOrgPersonSql);
            while(rsOrgPerson.next()){
                String itId=rsOrgPerson.getString("id");
                orgPersonList.add(itId);
            }
            String queryOrgContractSql="select * from org_contract_info where uuid='"+uuidList.get(i)+"'";
            ResultSet rsOrgContract= staAll.executeQuery(queryOrgContractSql);
            while(rsOrgContract.next()){
                String itId=rsOrgContract.getString("id");
                orgContractList.add(itId);
            }
//            String queryOrgDemandSql="select * from org_demand_map where uuid='"+uuidList.get(i)+"'";
//            ResultSet rsOrgDemand= staAll.executeQuery(queryOrgDemandSql);
//            while(rsOrgDemand.next()){
//                String itId=rsOrgDemand.getString("id");
//                orgDemandList.add(itId);
//            }
            String queryOrgEvaSql="select * from org_eva_info where uuid='"+uuidList.get(i)+"'";
            ResultSet rsOrgEva= staAll.executeQuery(queryOrgEvaSql);
            while(rsOrgEva.next()){
                String itId=rsOrgEva.getString("id");
                orgEvaList.add(itId);
            }
        }

        for(int i=0;i<businessIdList.size();i++){
            String updateBusinessSql="update bas_business_info set uuid ='"+ouuid+"' where id ='"+businessIdList.get(i)+"'";
            staAll.executeUpdate(updateBusinessSql);
            System.out.println(updateBusinessSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<executiveIdList.size();i++){
            String updateExecutiveSql="update com_executive_info set uuid ='"+ouuid+"' where id ='"+executiveIdList.get(i)+"'";
            staAll.executeUpdate(updateExecutiveSql);
            System.out.println(updateExecutiveSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<investmentList.size();i++){
            String updateInvestmenteSql="update com_investment_info set uuid ='"+ouuid+"' where id ='"+investmentList.get(i)+"'";
            staAll.executeUpdate(updateInvestmenteSql);
            System.out.println(updateInvestmenteSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<shareholderList.size();i++){
            String updateShareholderSql="update com_shareholder set uuid ='"+ouuid+"' where id ='"+shareholderList.get(i)+"'";
            staAll.executeUpdate(updateShareholderSql);
            System.out.println(updateShareholderSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<shareholderTeamList.size();i++){
            String updateShareholderTeamSql="update com_shareholder_team set uuid ='"+ouuid+"' where id ='"+shareholderTeamList.get(i)+"'";
            staAll.executeUpdate(updateShareholderTeamSql);
            System.out.println(updateShareholderTeamSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgKnowlageList.size();i++){
            String updateKnowledgeSql="update org_knowledge set ouuid ='"+ouuid+"' where id ='"+orgKnowlageList.get(i)+"'";
            staAll.executeUpdate(updateKnowledgeSql);
            System.out.println(updateKnowledgeSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgProductList.size();i++){
            String updateproductSql="update org_product set ouuid ='"+ouuid+"' where id ='"+orgProductList.get(i)+"'";
            staAll.executeUpdate(updateproductSql);
            System.out.println(updateproductSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgPersonList.size();i++){
            String updatePersonSql="update per_organize set ouuid ='"+ouuid+"' where id ='"+orgPersonList.get(i)+"'";
            staAll.executeUpdate(updatePersonSql);
            System.out.println(updatePersonSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgContractList.size();i++){
            String updateContractSql="update org_contract_info set uuid ='"+ouuid+"' where id ='"+orgContractList.get(i)+"'";
            staAll.executeUpdate(updateContractSql);
            System.out.println(updateContractSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgDemandList.size();i++){
            String updateDemandSql="update org_demand_map set uuid ='"+ouuid+"' where id ='"+orgDemandList.get(i)+"'";
            staAll.executeUpdate(updateDemandSql);
            System.out.println(updateDemandSql);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        for(int i=0;i<orgEvaList.size();i++){
            String updateEvaSql="update org_eva_info set uuid ='"+ouuid+"' where id ='"+orgEvaList.get(i)+"'";
            staAll.executeUpdate(updateEvaSql);
            System.out.println(updateEvaSql);
        }


        System.out.println("*******************************************************************************");
        int num=0;
        for(int i=0;i<idList.size();i++){
            num++;
            String deleteSql="delete from bas_organize_info where id='"+idList.get(i)+"'";
            staAll.executeUpdate(deleteSql);
            System.out.println(deleteSql+"-----------"+num);
            if(idList.get(i).equals(id)){
                System.out.println("哎呀我去");
            }
        }







    }

        public static void main(String [] args) throws Exception {
            UpdateOragize.updateOragize("腾讯");

        }

}
