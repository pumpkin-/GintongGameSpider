package GintongameSpider.SpiderTyc;

import JavaBean.*;
import SpiderUtils.SpiderContant;
import dao.*;
import dao.impl.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.lang.model.element.Element;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by lenovo on 2017/2/21.
 */
public class SpiderTyc {

    private static WebDriver driver = null;

    public static void main(String [] args) throws Exception {
            //公司网址
        List<String> urls = new ArrayList<String>();
        urls.add("http://www.tianyancha.com/company/2347469001");
        urls.add("http://www.tianyancha.com/company/24582538");
        urls.add("http://www.tianyancha.com/company/15676849");
        urls.add("http://www.tianyancha.com/company/712667541");
        urls.add("http://www.tianyancha.com/company/96685097");
        urls.add("http://www.tianyancha.com/company/15676849");
        urls.add("http://www.tianyancha.com/company/28644163");
        urls.add("http://www.tianyancha.com/company/16091722");
        urls.add("http://www.tianyancha.com/company/9459198");
        urls.add("http://www.tianyancha.com/company/96829874");
        urls.add("http://www.tianyancha.com/company/28510961");
        urls.add("http://www.tianyancha.com/company/103890902");
        urls.add("http://www.tianyancha.com/company/28552456");
        urls.add("http://www.tianyancha.com/company/5519198");
        urls.add("http://www.tianyancha.com/company/28013865");
        urls.add("http://www.tianyancha.com/company/2450478858");
        urls.add("http://www.tianyancha.com/company/82731450");
        urls.add("http://www.tianyancha.com/company/2377462584");
        urls.add("http://www.tianyancha.com/company/978948221");
        urls.add("http://www.tianyancha.com/company/26255088");
        urls.add("http://www.tianyancha.com/company/10361034");
        urls.add("http://www.tianyancha.com/company/27175339");
        urls.add("http://www.tianyancha.com/company/83201574");
        urls.add("http://www.tianyancha.com/company/35833909");
        urls.add("http://www.tianyancha.com/company/118466410");
        urls.add("http://www.tianyancha.com/company/24838528");
        urls.add("http://www.tianyancha.com/company/9000434");
        urls.add("http://www.tianyancha.com/company/30081795");
        urls.add("http://www.tianyancha.com/company/15239518");
        urls.add("http://www.tianyancha.com/company/3855448");
        urls.add("http://www.tianyancha.com/company/26697419");
        urls.add("http://www.tianyancha.com/company/11949400");
        urls.add("http://www.tianyancha.com/company/2450478858");
        urls.add("http://www.tianyancha.com/company/2316993363");
        urls.add("http://www.tianyancha.com/company/108245097");
        urls.add("http://www.tianyancha.com/company/2353587338");
        urls.add("http://www.tianyancha.com/company/9000434");
        urls.add("http://www.tianyancha.com/company/17782765");
        urls.add("http://www.tianyancha.com/company/2350113433");
        urls.add("http://www.tianyancha.com/company/25588370");
        urls.add("http://www.tianyancha.com/company/2517536223");
        urls.add("http://www.tianyancha.com/company/2344690438");
        urls.add("http://www.tianyancha.com/company/28415550");
        urls.add("http://www.tianyancha.com/company/2315672506");
        urls.add("http://www.tianyancha.com/company/5369226");
        urls.add("http://www.tianyancha.com/company/26621891");
        urls.add("http://www.tianyancha.com/company/2344968663");
        urls.add("http://www.tianyancha.com/company/27732799");
        urls.add("http://www.tianyancha.com/company/8450050");
        urls.add("http://www.tianyancha.com/company/2358562179");
        urls.add("http://www.tianyancha.com/company/1965476");
        urls.add("http://www.tianyancha.com/company/31762302");
        urls.add("http://www.tianyancha.com/company/15792651");
        urls.add("http://www.tianyancha.com/company/6951861");
        urls.add("http://www.tianyancha.com/company/11216089");
        urls.add("http://www.tianyancha.com/company/31751038");
        urls.add("http://www.tianyancha.com/company/2168189");
        urls.add("http://www.tianyancha.com/company/26425907");
        urls.add("http://www.tianyancha.com/company/12566358");
        urls.add("http://www.tianyancha.com/company/109491575");
        urls.add("http://www.tianyancha.com/company/32726890");
        urls.add("http://www.tianyancha.com/company/24285243");
        urls.add("http://www.tianyancha.com/company/23113285");
        urls.add("http://www.tianyancha.com/company/33108730");
        urls.add("http://www.tianyancha.com/company/15239518");
        urls.add("http://www.tianyancha.com/company/26956239");
        urls.add("http://www.tianyancha.com/company/26677731");
        urls.add("http://www.tianyancha.com/company/28554472");
        urls.add("http://www.tianyancha.com/company/83568248");
        urls.add("http://www.tianyancha.com/company/21284311");
        urls.add("http://www.tianyancha.com/company/135716396");
        urls.add("http://www.tianyancha.com/company/1771586");
        SpiderTyc.getBussinessDataByList(urls);

    }

    /**
     * 获取一组公司的工商数据
     * @param urls
     * @throws InterruptedException
     */
    public static void getBussinessDataByList(List<String> urls) throws InterruptedException {
        WebDriver driver = getWebDriver();
        for(String url: urls) {
            getBusinessDataByUrl(driver, url);
        }
        closeWebDriver();
    }

    /**
     * 获取一家公司的工商数据
     * @param driver
     * @param CompanyUrl
     * @throws InterruptedException
     */
    public static void getBusinessDataByUrl(WebDriver driver, String CompanyUrl) throws InterruptedException {
        driver.get(CompanyUrl);
        Thread.sleep(2000);
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        //所对应的UUID
        String uuid=UUID.randomUUID().toString();
        //所对应businessID
        String bid=null;
        //System.out.println(doc.outerHtml());
        //组织名
        String oname = doc.select("div.company_info_text p.ng-binding").text();
        //联系方式
        String con_way =doc.select("div.company_info_text span.ng-binding:contains(电话)").text().split(":")[1].trim();
        //邮箱
        String email =doc.select("div.company_info_text span.ng-binding:contains(邮箱)").text().split(":")[1].trim();
        //地址
        String address =doc.select("div.company_info_text span.ng-binding:contains(地址)").text().split(":")[1].trim();
        //网址
        String web =doc.select("div.company_info_text span[style=margin-left:0px]").text();
        //股票代码
        String stockCode=doc.select("div.company_info_text p[ng-if=company.baseInfo.bondType] span.ng-binding span.ng-binding").text();
        stockCode=stockCode.replaceAll("（([0-9]{1,})）","$1");
        //股票代码类型
        String stockCodeType=doc.select("div.company_info_text p[ng-if=company.baseInfo.bondType]").text().split(" ")[0];
        //曾用名
        String usedName=null;
        if(oname.contains("曾用名")){
            oname=doc.select("div.company_info_text p.ng-binding").text().split(" ")[0];
            usedName=doc.select("div.company_info_text p.ng-binding").text().split(" ")[1].split("：")[1];
        }else{
            oname=doc.select("div.company_info_text p.ng-binding").text();
        }
        //注册时间
        String ztime = doc.select(" td.td-regTime-value p.ng-binding").text();

        //法定代表人
        String boss = doc.select("td.td-legalPersonName-value a[ng-if=company.baseInfo.legalPersonName]").text();
        //法定代表人连接
        String bossUrl="http://www.tianyancha.com"+doc.select("td.td-legalPersonName-value a[ng-if=company.baseInfo.legalPersonName]").attr("href");
        //注册资本
        String zmoney = doc.select("td.td-regCapital-value p.ng-binding").text();
        //状态
        String state = doc.select("td.td-regStatus-value p.ng-binding").text();
        //行业
        String industry = doc.select("td.basic-td span.ng-binding").text().split(" ")[0];
        //工商注册号
        String businessNo = doc.select("div.c8 span.ng-binding").text().split(" ")[1];
        //企业类型
        String companyStyle = doc.select("div.c8 span.ng-binding").text().split(" ")[2];
        //组织机构代码
        String orgNo = doc.select("div.c8 span.ng-binding").text().split(" ")[3];
        //营业期限
        String businessTime = doc.select("div.c8 span.ng-binding").text().split(" ")[4];
        //登记机关
        String registDePart = doc.select("div.c8 span.ng-binding").text().split(" ")[5];
        //核准日期
        String approvalDate = doc.select("div.c8 span.ng-binding").text().split(" ")[6];
        //统一信用代码
        String uniformCode = doc.select("div.c8 span.ng-binding").text().split(" ")[7];
        //注册地址
        String registAddress = doc.select("div.c8 span.ng-binding").text().split(" ")[8];
        //经营范围

        String businessScope = doc.select("div[class=c8 align-justify break-word] span.ng-binding").text();
//        System.out.println("公司名字："+oname);
//        System.out.println("公司曾用名:"+usedName);
//        System.out.println("联系方式:"+con_way);
//        System.out.println("邮箱:"+email);
//        System.out.println("地址:"+address);
//        System.out.println("网址:"+web);
//        System.out.println("公司简介:---->"+oname+"-"+con_way+"-"+email+"-"+address+"-"+web);
//        System.out.println("公司基本信息:--->"+ztime+"-"+boss+"-"+bossUrl+"-"+zmoney+"-"+state+"-"+industry+"-"+businessNo+"-"+
//                companyStyle+"-"+orgNo+"-"+businessTime+"-"+registDePart+"-"+approvalDate+"-"+uniformCode+"-"+registAddress+"-"+businessScope);

        //组织数据入库
        BasOrganizeInfo basOrgan=new BasOrganizeInfo();
        basOrgan.setTag("西奥中心AB座");
        basOrgan.setOname(oname);
        basOrgan.setCon_way(con_way);
        basOrgan.setAddress(address);
        basOrgan.setWeb(web);
        basOrgan.setIndustry(industry);
        basOrgan.setStime(ztime);
        basOrgan.setUuid(uuid);
        basOrgan.setManagement_field(businessScope);
        basOrgan.setSource("天眼查");
        basOrgan.setType("0");
        basOrgan.setUrl(CompanyUrl);
        BasOrganizeInfoDao basOrganizeInfoDao=new BasOrganizeInfoImpl();
        basOrganizeInfoDao.insertSingle(basOrgan);
        List<String> basOrganId=basOrganizeInfoDao.selcetOrganId(uuid);
        for(String bbid:basOrganId){
            bid=bbid;
        }

        //商业信息入库
        BasBusinessInfo basBus=new BasBusinessInfo();
        basBus.setBid(Integer.parseInt(bid));
        basBus.setUuid(uuid);
        basBus.setCname(oname);
        basBus.setCnameOld(usedName);
        basBus.setStockCode(stockCode);
        basBus.setStockType(stockCodeType);
        basBus.setTelephone(con_way);
        basBus.setEmail(email);
        basBus.setAdress(address);
        basBus.setLegalPersen(boss);
        basBus.setRcapital(zmoney);
        basBus.setState(state);
        basBus.setRtime(ztime);
        basBus.setIndustry(industry);
        basBus.setRbnumber(businessNo);
        basBus.setEnterpriseType(companyStyle);
        basBus.setOcode(orgNo);
        basBus.setOperationPeriod(businessTime);
        basBus.setRdepartment(registDePart);
        basBus.setApprovaDate(approvalDate);
        basBus.setUcCode(uniformCode);
        basBus.setRadress(registAddress);
        basBus.setBscope(businessScope);
        basBus.setUrl(CompanyUrl);
        basBus.setSource("天眼查");
        BasBusinessInfoDao businessInfoDao=new BasBusinessInfoImpl();
//        System.out.println("business中的bid"+basBus.getBid());
        businessInfoDao.insertBusInfo(basBus);



        //对外投资
        //对外投资公司名称
        String outInvest=doc.select("div[ng-if=company.investList.length>0] div[class=intro-head-g1 ng-binding]").text();
        //System.out.println("对外投资-----------"+outInvest);
        if(outInvest.contains("对外投资")) {
            String[] investComName = doc.select("div[class=col-xs-10 search_name search_repadding2 f14] a.query_name span.ng-binding").text().split(" ");
            //对外投资公司网址
            Elements comWeb = doc.select("div[class=col-xs-10 search_name search_repadding2 f14] a.query_name");
            //对外投资法定代表人
            String[] investBoss = doc.select("div[ng-if=company.investList.length>0] div[class=search_row_new f13] div[style=padding-left: 0]").text().split(" ");
            //对外投资行业
            String[] investIndusty = doc.select("div[ng-if=company.investList.length>0] div.row>div.search_row_new.f13 div.title:contains(行业) span.ng-binding").text().split(" ");
            //对外投资状态
            String[] investState = doc.select("div[ng-if=company.investList.length>0] div[class=search_row_new f13] div[style=border-right: none] span.ng-binding").text().split(" ");
            //对外投资数额
            String[] investMoney = doc.select("div[ng-if=company.investList.length>0] p[class=f13 ptten] span[class=c2 ng-binding]").text().split(" ");
            ComInvestmentInfoDao comInvestmentInfoDao = new ComInvestmentInfoImpl();
            for (int i = 0; i < investComName.length; i++) {
                ComInvestmentInfo comInvestmentInfo = new ComInvestmentInfo();
                comInvestmentInfo.setBid(Integer.parseInt(bid));
                comInvestmentInfo.setUuid(uuid);
                comInvestmentInfo.setOname(investComName[i]);
                comInvestmentInfo.setLegalPersen(investBoss[i].split("：")[1]);
                comInvestmentInfo.setIndustry(investIndusty[i]);
                comInvestmentInfo.setState(investState[i]);
                comInvestmentInfo.setInvestment(investMoney[i]);
                comInvestmentInfo.setWeb("http://www.tianyancha.com" + comWeb.get(i).attr("href"));
                comInvestmentInfoDao.insertInvestmentInfo(comInvestmentInfo);
//            System.out.println("对外投资-----》" + comWeb.get(i).attr("href") + "--" + investComName[i] + "--" + investBoss[i].split("：")[1] + "---" + investIndusty[i] + "--" + investState[i]+"---"+investMoney[i]);
//            System.out.println();
            }
        }

        //高管信息
        String leaderInfo=doc.select("div[ng-if=company.staffList.length>0] div[class=intro-head-g1 ng-binding]").text();
        //System.out.println("高管------------"+leaderInfo);
        if(leaderInfo.contains("高管信息")) {
            List<String> leaderNamelist = new ArrayList();
            List<String> leaderDutylist = new ArrayList();
            List<String> leaderUrlList = new ArrayList();
            //从人物表中查询出来的人物ID
            String pid = null;
            //人物的puuid
            String puuid = null;
            Elements leader = doc.select("div[ng-if=company.staffList.length>0] tbody>tr>td[ng-style=$last?{width:(100-(($index)*33))+'%'}:{width:'33%'}]>a");
            Elements leaderDuty = doc.select("div[ng-if=company.staffList.length>0] tr td[ng-class=$last ?'':'td-right-border']:has(span)");
            for (org.jsoup.nodes.Element leadName : leader) {
                leaderNamelist.add(leadName.text());
            }
            for (org.jsoup.nodes.Element leadDuty : leader) {
                leaderUrlList.add(leadDuty.attr("href"));
            }
            for (org.jsoup.nodes.Element zhi : leaderDuty) {
                leaderDutylist.add(zhi.text());
            }
            ComExecutiveInfoDao comExecutiveInfoDao = new ComExecutiveInfoImpl();
            BasPersonInfoDao basPersonInfo = new BasPersonInfoImpl();
            PerOrganizeDao perOrganizeDao = new PerOrganizeImpl();
            for (int i = 0; i < leaderDutylist.size(); i++) {
                puuid = UUID.randomUUID().toString();
                ComExecutiveInfo comExecutiveInfo = new ComExecutiveInfo();
                //高管人名
                String leadName = leaderNamelist.get(i);
                //高管职务
                String leadDuty = leaderDutylist.get(i);
                String leadUrl = "http://www.tianyancha.com" + leaderUrlList.get(i);
                //高管库
                comExecutiveInfo.setBid(Integer.parseInt(bid));
                comExecutiveInfo.setUuid(uuid);
                comExecutiveInfo.setPname(leadName);
                comExecutiveInfo.setJob(leadDuty);
                comExecutiveInfo.setWeb(leadUrl);
                comExecutiveInfoDao.insertExecutiveInfo(comExecutiveInfo);

                //人物库
                BasPersonInfo basPerson = new BasPersonInfo();
                basPerson.setUuid(puuid);
                basPerson.setName(leadName);
                basPerson.setSource("天眼查");
                basPerson.setUrl(leadUrl);
                basPersonInfo.insertPerInfo(basPerson);


                //人物 组织关系库
                PerOrganize perOrganize = new PerOrganize();
                perOrganize.setName(leadName);
                perOrganize.setOname(oname);
                perOrganize.setJob(leadDuty);
                perOrganize.setOuuid(uuid);
                perOrganize.setRtype("任职公司");
                perOrganize.setPuuid(puuid);
                perOrganize.setSource("天眼查");
                perOrganizeDao.insertPerOrgani(perOrganize);


//            System.out.println("高管:------>"+leadUrl+"+"+leadName+"+"+leadDuty);
//            System.out.println();
            }
        }

        //股东信息
        String partnerInfo=doc.select("div[ng-if=company.investorList.length>0] div[class=intro-head-g1 ng-binding]").text();
       // System.out.println("股东信息------------------"+partnerInfo);
        if(partnerInfo.contains("股东信息")) {
            Elements partnerlink = doc.select("div[ng-if=company.investorList.length>0] div.search_result_single.ng-scope");
            ComShareholderDao comShareholderDao = new ComShareholderImpl();
            ComShareholderTeamDao comShareholderTeamDao = new ComShareholderTeamImpl();
            for (org.jsoup.nodes.Element partner : partnerlink) {
                if (partner.select("a").attr("href").contains("human")) {
                    ComShareholder comShareholder = new ComShareholder();
                    //股东名称连接
                    String partnerNameUrl = "http://www.tianyancha.com" + partner.select("a").attr("href");
                    //股东人名字
                    String partnerName = partner.select("a").text();
                    //股东投资金额
                    String partnerMoney = partner.select("span.c2.ng-binding").text();
                    comShareholder.setBid(Integer.parseInt(bid));
                    comShareholder.setUuid(uuid);
                    comShareholder.setName(partnerName);
                    comShareholder.setWeb(partnerNameUrl);
                    comShareholder.setInvestment(partnerMoney);
                    comShareholderDao.insertComShareholder(comShareholder);
//                System.out.println("人物股东信息:---->"+partnerNameUrl+"-"+partnerName+"-"+partnerMoney);
                } else {
                    ComShareholderTeam comShareholderTeam = new ComShareholderTeam();
                    //股东公司网址
                    String partnerComNameUrl = "http://www.tianyancha.com" + partner.select("a").attr("href");
                    //股东公司名称
                    String partnerComName = partner.select("a").text();
                    //股东公司法定代表人
                    String partnerComPer = partner.select("span.ng-binding").get(0).text();
                    //股东行业
                    String partnerIndustry = partner.select("span.ng-binding").get(1).text();
                    //股东状态
                    String partnerState = partner.select("span.ng-binding").get(2).text();
                    //股东投资金额
                    String partnerComMoney = partner.select("p.f13.ptten span.c2.ng-binding").text();

                    comShareholderTeam.setBid(Integer.parseInt(bid));
                    comShareholderTeam.setUuid(uuid);
                    comShareholderTeam.setOname(partnerComName);
                    comShareholderTeam.setLegalPersen(partnerComPer);
                    comShareholderTeam.setWeb(partnerComNameUrl);
                    comShareholderTeam.setIndustry(partnerIndustry);
                    comShareholderTeam.setState(partnerState);
                    comShareholderTeam.setInvestment(partnerComMoney);
                    comShareholderTeamDao.insertShareholderTeam(comShareholderTeam);

//                System.out.println("人物股东信息:---->"+partnerComNameUrl+"-"+partnerComName+"-"+partnerComPer+"-"+partnerIndustry+"-"+partnerState+"-"+partnerComMoney);

                }
            }
        }

    }

    /**
     * 获取webDriver
     * @return
     */
    public synchronized static WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * 关闭webDriver
     */
    public static void closeWebDriver() {
        driver.close();
        System.exit(0);
    }


}
