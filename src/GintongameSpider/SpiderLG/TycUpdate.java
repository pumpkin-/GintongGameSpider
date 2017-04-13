package GintongameSpider.SpiderLG;

import JavaBean.*;
import SpiderUtils.SpiderContant;
import dao.*;
import dao.impl.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/4/11.
 */
public class TycUpdate {
    private List<String> perUrlList=new ArrayList<String>();
    private WebDriver driver = null;

    public static void main(String [] args) throws Exception {
        //公司网址
//        SpiderTyc spiderTyc=new SpiderTyc();
//        List<String> urls = new ArrayList<String>();
//        urls.add("http://www.tianyancha.com/company/2347469001");
//        urls.add("http://www.tianyancha.com/company/24582538");
//        urls.add("http://www.tianyancha.com/company/15676849");
//        urls.add("http://www.tianyancha.com/company/712667541");
//        urls.add("http://www.tianyancha.com/company/96685097");
//        urls.add("http://www.tianyancha.com/company/15676849");
//        urls.add("http://www.tianyancha.com/company/28644163");
//        urls.add("http://www.tianyancha.com/company/16091722");
//        urls.add("http://www.tianyancha.com/company/9459198");
//        urls.add("http://www.tianyancha.com/company/96829874");
//        urls.add("http://www.tianyancha.com/company/28510961");
//        urls.add("http://www.tianyancha.com/company/103890902");
//        urls.add("http://www.tianyancha.com/company/28552456");
//        urls.add("http://www.tianyancha.com/company/5519198");
//        urls.add("http://www.tianyancha.com/company/28013865");
//        urls.add("http://www.tianyancha.com/company/2450478858");
//        urls.add("http://www.tianyancha.com/company/82731450");
//        urls.add("http://www.tianyancha.com/company/2377462584");
//        urls.add("http://www.tianyancha.com/company/978948221");
//        urls.add("http://www.tianyancha.com/company/26255088");
//        urls.add("http://www.tianyancha.com/company/10361034");
//        urls.add("http://www.tianyancha.com/company/27175339");
//        urls.add("http://www.tianyancha.com/company/83201574");
//        urls.add("http://www.tianyancha.com/company/35833909");
//        urls.add("http://www.tianyancha.com/company/118466410");
//        urls.add("http://www.tianyancha.com/company/24838528");
//        urls.add("http://www.tianyancha.com/company/9000434");
//        urls.add("http://www.tianyancha.com/company/30081795");
//        urls.add("http://www.tianyancha.com/company/15239518");
//        urls.add("http://www.tianyancha.com/company/3855448");
//        urls.add("http://www.tianyancha.com/company/26697419");
//        urls.add("http://www.tianyancha.com/company/11949400");
//        urls.add("http://www.tianyancha.com/company/2450478858");
//        urls.add("http://www.tianyancha.com/company/2316993363");
//        urls.add("http://www.tianyancha.com/company/108245097");
//        urls.add("http://www.tianyancha.com/company/2353587338");
//        urls.add("http://www.tianyancha.com/company/9000434");
//        urls.add("http://www.tianyancha.com/company/17782765");
//        urls.add("http://www.tianyancha.com/company/2350113433");
//        urls.add("http://www.tianyancha.com/company/25588370");
//        urls.add("http://www.tianyancha.com/company/2517536223");
//        urls.add("http://www.tianyancha.com/company/2344690438");
//        urls.add("http://www.tianyancha.com/company/28415550");
//        urls.add("http://www.tianyancha.com/company/2315672506");
//        urls.add("http://www.tianyancha.com/company/5369226");
//        urls.add("http://www.tianyancha.com/company/26621891");
//        urls.add("http://www.tianyancha.com/company/2344968663");
//        urls.add("http://www.tianyancha.com/company/27732799");
//        urls.add("http://www.tianyancha.com/company/8450050");
//        urls.add("http://www.tianyancha.com/company/2358562179");
//        urls.add("http://www.tianyancha.com/company/1965476");
//        urls.add("http://www.tianyancha.com/company/31762302");
//        urls.add("http://www.tianyancha.com/company/15792651");
//        urls.add("http://www.tianyancha.com/company/6951861");
//        urls.add("http://www.tianyancha.com/company/11216089");
//        urls.add("http://www.tianyancha.com/company/31751038");
//        urls.add("http://www.tianyancha.com/company/2168189");
//        urls.add("http://www.tianyancha.com/company/26425907");
//        urls.add("http://www.tianyancha.com/company/12566358");
//        urls.add("http://www.tianyancha.com/company/109491575");
//        urls.add("http://www.tianyancha.com/company/32726890");
//        urls.add("http://www.tianyancha.com/company/24285243");
//        urls.add("http://www.tianyancha.com/company/23113285");
//        urls.add("http://www.tianyancha.com/company/33108730");
//        urls.add("http://www.tianyancha.com/company/15239518");
//        urls.add("http://www.tianyancha.com/company/26956239");
//        urls.add("http://www.tianyancha.com/company/26677731");
//        urls.add("http://www.tianyancha.com/company/28554472");
//        urls.add("http://www.tianyancha.com/company/83568248");
//        urls.add("http://www.tianyancha.com/company/21284311");
//        urls.add("http://www.tianyancha.com/company/135716396");
//        urls.add("http://www.tianyancha.com/company/1771586");
//        spiderTyc.getBussinessDataByList(urls);


        TycUpdate tycUpdate=new TycUpdate();
        tycUpdate.getBussinessDataByList("河南多益实业有限公司");
//        tycUpdate.getBussinessDataByOne("http://www.tianyancha.com/company/713808677",true,null);
    }

    /**
     * 获取一组公司的工商数据
     * @param
     * @throws InterruptedException
     */
//    public  void getBussinessDataByList(List<String> urls) throws Exception {
//        WebDriver driver = getWebDriver();
//        for(String url: urls) {
//            BasOrganizeInfo basOrganizeInfo=getBusinessDataByUrl(driver, url);
//            System.out.println(basOrganizeInfo.getOname() + ":数据入库完毕");
//            Thread.sleep(2000);
//        }
//        closeWebDriver();
//    }

    public BasOrganizeInfo getBussinessDataByOne(String url,Boolean isFirst,String ouuid) throws Exception {
        WebDriver driver = getWebDriver();
        BasOrganizeInfo basOrganizeInfo=null;
        basOrganizeInfo = getBusinessDataByUrl(driver, url, isFirst,ouuid);
        System.out.println(basOrganizeInfo.getOname() + ":数据入库完毕(天眼查)");
        Thread.sleep(2000);
        closeWebDriver();
        return basOrganizeInfo;
    }

    public  BasOrganizeInfo getBussinessDataByList(String ComName) throws Exception {
        WebDriver driver = getWebDriver();
        BasOrganizeInfo basOrganizeInfo=null;
        List<String> perUrlList=getPerUrl(driver,ComName);
        if(perUrlList.size()!=0) {
            for (String url : perUrlList) {
                try {
                    basOrganizeInfo = getBusinessDataByUrl(driver, url, true, null);
                    System.out.println(basOrganizeInfo.getOname() + ":数据入库完毕(天眼查)");
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.sleep(2000);
        closeWebDriver();
        return basOrganizeInfo;
    }


    /**
     * 爬取列表页
     * @param driver
     * @param comName
     * @throws Exception
     */
    public  List<String> getPerUrl(WebDriver driver,String comName) throws Exception {
        int page=0;
        String comUrl="http://www.tianyancha.com/search?key="+comName+"&checkFrom=searchBox";
        driver.get(comUrl);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
//        Elements elements=docMain.select("a[class=query_name search-new-color]");
//        for(Element element:elements){
//            perUrlList.add(element.attr("href"));
//            System.out.println(element.attr("href"));
//        }
        Elements elements=docMain.select("div[class=search_result_single search-2017 pb15 ng-scope]");
        for(Element element:elements){
            String href=element.select("a[class=query_name search-new-color]").attr("href");
            String gupiao=element.select("div p[ng-if=node.bondType]").text();
            if(StringUtils.isNotEmpty(gupiao)){
                perUrlList.add(href);
                return perUrlList;
            }
        }
        System.out.println("第1页数据已经跑完");
        Element elementsPage=docMain.select("div[class=total ng-binding]").last();
        if(elementsPage!=null) {
            String pages = elementsPage.text();
            Pattern pattern = Pattern.compile("[0-9]{1,}");
            Matcher matcher = pattern.matcher(pages);
            while (matcher.find()) {
                page = Integer.parseInt(matcher.group(0));
                System.out.println("page----:"+page);
            }
            for(int i=2;i<page;i++){
                try{
                    String url="http://www.tianyancha.com/search/p"+i+"?key="+comName;
                    docMain=getDocumentBySelenium(driver,url);
                    Elements eles=docMain.select("div[class=search_result_single search-2017 pb15 ng-scope]");
                    for(Element element:eles){
                        String href=element.select("a[class=query_name search-new-color]").attr("href");
                        String gupiao=element.select("div p[ng-if=node.bondType]").text();
                        if(StringUtils.isNotEmpty(gupiao)){
                            perUrlList.add(href);
                            return perUrlList;
                        }
                    }
                    System.out.println("第"+i+"页数据已经跑完");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return perUrlList;
    }

    /**
     * 通过驱动器获得当前页面的doucument树
     * @param driver
     * @return
     */
    public static org.jsoup.nodes.Document getDocumentBySelenium(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
        return Jsoup.parse(driver.findElement(By.xpath("/html")).getAttribute("outerHTML"));
    }


    /**
     * 翻页程序
     * @param driver
     * @return
     * @throws InterruptedException
     */
    public static Document listPageSelenium(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executornext = (JavascriptExecutor) driver;
        executornext.executeScript("$(\"#ng-view > div.ng-scope > div > div > div > div.col-9.company-main.pl0.pr20.pt18.company_new_2017 > div > div:nth-child(11) " +
                "> div.ng-scope > div.company_pager.ng-scope > ul > li.pagination-next.ng-scope > a\").click()");
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.close();
                driver.switchTo().window(handles);
            }
        }
        Thread.sleep(5000);
        WebElement webElement=driver.findElement(By.xpath("/html"));
        Document Document=Jsoup.parse(webElement.getAttribute("outerHTML"));
        return Document;
    }




    /**
     * 获取一家公司的工商数据
     * @param driver
     * @param CompanyUrl
     * @throws InterruptedException
     */
    public  BasOrganizeInfo  getBusinessDataByUrl(WebDriver driver, String CompanyUrl,Boolean isFirst,String ouuid) throws Exception {
        String oname=null;
        String uuid=null;
        BasOrganizeInfo basOrgan = new BasOrganizeInfo();
        driver.get(CompanyUrl);
        Thread.sleep(2000);
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
        //所对应的UUID
        if(isFirst==true) {
            uuid= UUID.randomUUID().toString();
        }else{
            uuid=ouuid;
        }
        //所对应businessID
        String bid = null;
        //System.out.println(doc.outerHtml());
        //组织名
        oname = doc.select("div[class=in-block ml10 f18 mb5 ng-binding]").text();
        //联系方式
        String con_way = doc.select("div.company_info_text span.ng-binding:contains(电话)").text().split(":")[1].trim();
        //邮箱
        String email = doc.select("div.company_info_text span.ng-binding:contains(邮箱)").text().split(":")[1].trim();
        //地址
        String address = doc.select("div.company_info_text span.ng-binding:contains(地址)").text().split(":")[1].trim();
        //网址
        String web = doc.select("div.company_info_text span[style=margin-left:0px]").text();
        //股票代码
        String stockCode = doc.select("span[style=font-size:16px]").text();
        stockCode = stockCode.replaceAll("（([0-9]{1,})）", "$1");
        //股票代码类型
        String stockCodeType = doc.select("span[style=background-color: #009bae;color:white;padding: 2px 5px;font-size: 14px;border-radius: 3px]").text();
        //曾用名
        String usedName = null;
        usedName = doc.select("span[class=history-last ng-binding]").text();
        //注册时间
        String ztime = doc.select("div.baseinfo-module-item:contains(注册时间) div[class=baseinfo-module-content-value ng-binding]").text();

        //法定代表人
        String boss = doc.select("a[ng-if=company.legalPersonName]").text();
        //法定代表人连接
        String bossUrl = "http://www.tianyancha.com" + doc.select("a[ng-if=company.legalPersonName]").attr("href");
        //注册资本
        String zmoney = doc.select("div.baseinfo-module-item:contains(注册资本) div[class=baseinfo-module-content-value ng-binding]").text();
        //状态
        String state = doc.select("div.baseinfo-module-item:contains(状态) div[class=baseinfo-module-content-value ng-binding]").text();
        //行业
        String industry = doc.select("div.c8:contains(行业) span.ng-binding").text();
        //工商注册号
        String businessNo = doc.select("div.c8:contains(工商注册号) span.ng-binding").text();
        //企业类型
        String companyStyle = doc.select("div.c8:contains(企业类型) span.ng-binding").text();
        //组织机构代码
        String orgNo = doc.select("div.c8:contains(组织机构代码) span.ng-binding").text();
        //营业期限
        String businessTime = doc.select("div.c8:contains(营业期限) span.ng-binding").text();
        //登记机关
        String registDePart = doc.select("div.c8:contains(登记机关) span.ng-binding").text();
        //核准日期
        String approvalDate = doc.select("div.c8:contains(核准日期) span.ng-binding").text();
        //统一信用代码
        String uniformCode = doc.select("div.c8:contains(统一信用代码) span.ng-binding").text();
        //注册地址
        String registAddress = doc.select("div.c8:contains(注册地址) span.ng-binding").text();
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
        //basOrgan.setTag("西奥中心AB座");
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
        BasOrganizeInfoDao basOrganizeInfoDao = new BasOrganizeInfoImpl();
        if(isFirst==true) {
            basOrganizeInfoDao.insertSingle(basOrgan);
        }else{
            basOrganizeInfoDao.updateSingle(basOrgan);
        }
        List<String> basOrganId = basOrganizeInfoDao.selcetOrganId(uuid);
        for (String bbid : basOrganId) {
            bid = bbid;
        }

        //商业信息入库
        BasBusinessInfo basBus = new BasBusinessInfo();
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
        BasBusinessInfoDao businessInfoDao = new BasBusinessInfoImpl();
//        System.out.println("business中的bid"+basBus.getBid());
        if(isFirst==true) {
            businessInfoDao.insertBusInfo(basBus);
        }else{
            businessInfoDao.updateBusInfo(basBus);
        }


        //对外投资
        //对外投资公司名称
        Elements investCom = doc.select("div[ng-if=dataItemCount.inverstCount>0] table[class=table companyInfo-table] tr.ng-scope");
        ComInvestmentInfoDao comInvestmentInfoDao = new ComInvestmentInfoImpl();
        for (Element invest : investCom) {
            try{
                String investComName = invest.select("span[ng-bind-html=node.name | trustHtml]").text();
                String comWeb = invest.select("a[ng-click=$event.preventDefault();toOtherCompany(node.id,node.name);inClick = true;]").attr("href");
                String investBoss = invest.select("span[ng-bind-html=node.legalPersonName?node.legalPersonName:' ' | trustHtml]").text();
                String investState = invest.select("span[ng-class={'c-none':!node.regStatus}]").text();
                String investMoney = invest.select("span[ng-class=node.amount ? '':'c-none']").text();

                ComInvestmentInfo comInvestmentInfo = new ComInvestmentInfo();
                comInvestmentInfo.setBid(Integer.parseInt(bid));
                comInvestmentInfo.setUuid(uuid);
                comInvestmentInfo.setOname(investComName);
                comInvestmentInfo.setLegalPersen(investBoss);
                //comInvestmentInfo.setIndustry(investIndusty[i]);
                comInvestmentInfo.setState(investState);
                comInvestmentInfo.setInvestment(investMoney);
                comInvestmentInfo.setWeb("http://www.tianyancha.com" + comWeb);
                if(isFirst==true) {
                    comInvestmentInfoDao.insertInvestmentInfo(comInvestmentInfo);
                }else {
                    List<ComInvestmentInfo> comInvestmentInfoList = comInvestmentInfoDao.selectInvestmentInfo(uuid);
                    boolean isExist=false;
                    for (int i = 0; i < comInvestmentInfoList.size(); i++) {
                        String investOname=comInvestmentInfoList.get(i).getOname();
                        String investUuid=comInvestmentInfoList.get(i).getUuid();
                        if(investOname.equals(investComName)&&investUuid.equals(uuid)){
                            comInvestmentInfoDao.updateInvestmentInfo(comInvestmentInfo);
                            isExist=true;
                            break;
                        }
                    }
                    if(isExist==false){
                        comInvestmentInfoDao.insertInvestmentInfo(comInvestmentInfo);
                    }
                }

                //System.out.println("对外投资:"+investComName+"-"+comWeb+"-"+investBoss+"-"+investState+"-"+investMoney);
            }catch (Exception e){
                e.printStackTrace();
            }
        }




        //高管信息
        List<String> leaderNamelist = new ArrayList();
        List<String> leaderDutylist = new ArrayList();
        List<String> leaderUrlList = new ArrayList();
        //从人物表中查询出来的人物ID
        String pid = null;
        //人物的puuid
        String puuid = null;
        String[] leaderName=doc.select("div[ng-class=($last&&getStaffByGroupIndex(staffList.result,staff).length>1) ?'end-item':''] div.staffinfo-module-content-title").text().split(" ");
        Elements leaderUrl=doc.select("div[ng-class=($last&&getStaffByGroupIndex(staffList.result,staff).length>1) ?'end-item':''] div.staffinfo-module-content-title a");
        String[] leaderDuty=doc.select("div[ng-class=($last&&getStaffByGroupIndex(staffList.result,staff).length>1) ?'end-item':''] div.staffinfo-module-content-value").text().split(" ");
        for(int i=0;i<leaderName.length;i++){
            try {
                leaderNamelist.add(leaderName[i]);
                leaderDutylist.add(leaderDuty[i]);
                leaderUrlList.add(leaderUrl.get(i).attr("href"));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        ComExecutiveInfoDao comExecutiveInfoDao = new ComExecutiveInfoImpl();
        BasPersonInfoDao basPersonInfo = new BasPersonInfoImpl();
        PerOrganizeDao perOrganizeDao = new PerOrganizeImpl();
        for (int i = 0; i < leaderDutylist.size(); i++) {
            try {
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
                if(isFirst==true) {
                    comExecutiveInfoDao.insertExecutiveInfo(comExecutiveInfo);
                }else {
                    List<ComExecutiveInfo> comExecutiveInfoList = comExecutiveInfoDao.selectExecutiveInfo(uuid);
                    boolean isExist=false;
                    for (int j = 0; j < comExecutiveInfoList.size(); j++) {
                        String investOname=comExecutiveInfoList.get(j).getPname();
                        String investUuid=comExecutiveInfoList.get(j).getUuid();
                        if(investOname.equals(leadName)&&investUuid.equals(uuid)){
                            comExecutiveInfoDao.updateExecutiveInfo(comExecutiveInfo);
                            isExist=true;
                            break;
                        }
                    }
                    if(isExist==false){
                        comExecutiveInfoDao.insertExecutiveInfo(comExecutiveInfo);
                    }
                }

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

                // System.out.println("高管:------>"+leadUrl+"+"+leadName+"+"+leadDuty);
            }catch (Exception e){
                e.printStackTrace();
            }
//            System.out.println();

        }

        //股东信息
        Elements partnerlink = doc.select("div[ng-if=dataItemCount.holderCount>0] table[class=table companyInfo-table] tbody tr");
        ComShareholderDao comShareholderDao = new ComShareholderImpl();
        ComShareholderTeamDao comShareholderTeamDao = new ComShareholderTeamImpl();
        for (org.jsoup.nodes.Element partner : partnerlink) {
            try {
                if (partner.select("a[event-name=company-detail-investment]").attr("href").contains("human")) {
                    ComShareholder comShareholder = new ComShareholder();
                    //股东名称连接
                    String partnerNameUrl = "http://www.tianyancha.com" + partner.select("a[event-name=company-detail-investment]").attr("href");
                    //股东人名字
                    String partnerName = partner.select("a[event-name=company-detail-investment]").text();
                    //股东投资金额
                    String partnerMoney = partner.select("span[ng-class=item.amomon?'':'c-none']").text().split(" ")[0];
                    //股东投资人 出资比例
                    String investment_rate=partner.select("span[class=c-money-y ng-binding]").text();
                    //股东投资人的 认缴时间
                    String subscription_time=partner.select("span[ng-if=item.time]").text().split("：")[1];

//                            System.out.println(investment_rate);
//                            System.out.println(subscription_time);

                    comShareholder.setSubscription_time(subscription_time);
                    comShareholder.setInvestment_rate(investment_rate);
                    comShareholder.setBid(Integer.parseInt(bid));
                    comShareholder.setUuid(uuid);
                    comShareholder.setName(partnerName);
                    comShareholder.setWeb(partnerNameUrl);
                    comShareholder.setInvestment(partnerMoney);
                    if(isFirst==true) {
                        comShareholderDao.insertComShareholder(comShareholder);
                    }else {
                        List<ComShareholder> comShareholderList = comShareholderDao.selectComShareholder(uuid);
                        boolean isExist=false;
                        for (int j = 0; j < comShareholderList.size(); j++) {
                            String investOname=comShareholderList.get(j).getName();
                            String investUuid=comShareholderList.get(j).getUuid();
                            if(investOname.equals(partnerName)&&investUuid.equals(uuid)){
                                comShareholderDao.updateComShareholder(comShareholder);
                                isExist=true;
                                break;
                            }
                        }
                        if(isExist==false){
                            comShareholderDao.insertComShareholder(comShareholder);
                        }
                    }
                    // System.out.println("人物股东信息:---->"+partnerNameUrl+"-"+partnerName+"-"+partnerMoney);
                } else {
                    ComShareholderTeam comShareholderTeam = new ComShareholderTeam();
                    //股东公司网址
                    String partnerComNameUrl = "http://www.tianyancha.com" + partner.select("a[event-name=company-detail-investment]").attr("href");
                    //股东公司名称
                    String partnerComName = partner.select("a[event-name=company-detail-investment]").text();
                    //股东公司法定代表人
                    //String partnerComPer = partner.select("span.ng-binding").get(0).text();
                    //股东行业
                    //String partnerIndustry = partner.select("span.ng-binding").get(1).text();
                    //股东状态
                    //String partnerState = partner.select("span.ng-binding").get(2).text();
                    //股东投资金额
                    String partnerComMoney = partner.select("span[ng-class=item.amomon?'':'c-none']").text();
                    //股东投资比例
                    String investment_rate=partner.select("span[class=c-money-y ng-binding]").text();
                    //股东投资 认缴时间
                    String subscription_time=partner.select("span[ng-if=item.time]").text().split("：")[1];

//                            System.out.println(investment_rate);
//                            System.out.println(subscription_time);


                    comShareholderTeam.setSubscription_time(subscription_time);
                    comShareholderTeam.setInvestment_rate(investment_rate);
                    comShareholderTeam.setBid(Integer.parseInt(bid));
                    comShareholderTeam.setUuid(uuid);
                    comShareholderTeam.setOname(partnerComName);
                    //comShareholderTeam.setLegalPersen(partnerComPer);
                    comShareholderTeam.setWeb(partnerComNameUrl);
                    //comShareholderTeam.setIndustry(partnerIndustry);
                    //comShareholderTeam.setState(partnerState);
                    comShareholderTeam.setInvestment(partnerComMoney);
                    if(isFirst==true) {
                        comShareholderTeamDao.insertShareholderTeam(comShareholderTeam);
                    }else {
                        List<ComShareholderTeam> comShareholderTeamList = comShareholderTeamDao.selectShareholderTeam(uuid);
                        boolean isExist=false;
                        for (int j = 0; j < comShareholderTeamList.size(); j++) {
                            String investOname=comShareholderTeamList.get(j).getOname();
                            String investUuid=comShareholderTeamList.get(j).getUuid();
                            if(investOname.equals(partnerComName)&&investUuid.equals(uuid)){
                                comShareholderTeamDao.updateShareholderTeam(comShareholderTeam);
                                isExist=true;
                                break;
                            }
                        }
                        if(isExist==false){
                            comShareholderTeamDao.insertShareholderTeam(comShareholderTeam);
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //System.out.println("公司股东信息:---->"+partnerComNameUrl+"-"+partnerComName+"-"+partnerComMoney);
        }

        //变更信息
        String changePage = doc.select("div[ng-if=dataItemCount.changeCount>0] div[class=total ng-binding]").text();
        ComChangeInfoDao comChangeInfoDao=new ComChangeInfoImpl();
        if(changePage!=null){
            int page=0;
            Pattern pattern = Pattern.compile("[0-9]{1,}");
            Matcher matcher = pattern.matcher(changePage);
            while (matcher.find()) {
                page = Integer.parseInt(matcher.group(0));
                System.out.println("page----:"+page);
            }
            Elements elements = doc.select("div[ng-if=dataItemCount.changeCount>0] table[class=table companyInfo-table] tr.ng-scope");
            for (Element element : elements) {
                try {
                    ComChangInfo comChangInfo = new ComChangInfo();
                    String change_time = element.select("span[class=ng-binding]").text().split(" ")[0];
                    String change_item = element.select("span[class=ng-binding]").text().split(" ")[1];
                    String before_change = element.select("span[ng-bind-html=change.contentBefore | splitNum]").text();
                    String after_change = element.select("span[ng-bind-html=change.contentAfter | splitNum]").text();
                    comChangInfo.setBid(Integer.parseInt(bid));
                    comChangInfo.setUuid(uuid);
                    comChangInfo.setAfter_change(after_change);
                    comChangInfo.setChange_time(change_time);
                    comChangInfo.setChange_item(change_item);
                    comChangInfo.setBefore_change(before_change);
                    if (isFirst == true) {
                        comChangeInfoDao.insertChangeInfo(comChangInfo);
                    } else {
                        List<ComChangInfo> comChangInfoList = comChangeInfoDao.selectChangeInfo(uuid);
                        boolean isExist = false;
                        for (int j = 0; j < comChangInfoList.size(); j++) {
                            String investOname = comChangInfoList.get(j).getChange_item();
                            String investUuid = comChangInfoList.get(j).getUuid();
                            if (investOname.equals(change_item) && investUuid.equals(uuid)) {
                                comChangeInfoDao.updateChangeInfo(comChangInfo);
                                isExist = true;
                                break;
                            }
                        }
                        if (isExist == false) {
                            comChangeInfoDao.insertChangeInfo(comChangInfo);
                        }
                    }
                    //System.out.println(change_time + "***" + change_item + "***" + before_change + "***" + after_change);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for(int i=2;i<=page;i++) {
                doc = listPageSelenium(driver);
                Elements eles = doc.select("div[ng-if=dataItemCount.changeCount>0] table[class=table companyInfo-table] tr.ng-scope");
                for (Element ele : eles) {
                    try {
                        ComChangInfo comChangInfo = new ComChangInfo();
                        String change_time = ele.select("span[class=ng-binding]").text().split(" ")[0];
                        String change_item = ele.select("span[class=ng-binding]").text().split(" ")[1];
                        String before_change = ele.select("span[ng-bind-html=change.contentBefore | splitNum]").text();
                        String after_change = ele.select("span[ng-bind-html=change.contentAfter | splitNum]").text();
                        comChangInfo.setBid(Integer.parseInt(bid));
                        comChangInfo.setUuid(uuid);
                        comChangInfo.setAfter_change(after_change);
                        comChangInfo.setChange_time(change_time);
                        comChangInfo.setChange_item(change_item);
                        comChangInfo.setBefore_change(before_change);
                        if (isFirst == true) {
                            comChangeInfoDao.insertChangeInfo(comChangInfo);
                        } else {
                            List<ComChangInfo> comChangInfoList = comChangeInfoDao.selectChangeInfo(uuid);
                            boolean isExist = false;
                            for (int j = 0; j < comChangInfoList.size(); j++) {
                                String investOname = comChangInfoList.get(j).getChange_item();
                                String investUuid = comChangInfoList.get(j).getUuid();
                                if (investOname.equals(change_item) && investUuid.equals(uuid)) {
                                    comChangeInfoDao.updateChangeInfo(comChangInfo);
                                    isExist = true;
                                    break;
                                }
                            }
                            if (isExist == false) {
                                comChangeInfoDao.insertChangeInfo(comChangInfo);
                            }
                        }
                        //System.out.println(change_time + "***" + change_item + "***" + before_change + "***" + after_change);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }


        }else{
            Elements elements=doc.select("div[ng-if=dataItemCount.changeCount>0] table[class=table companyInfo-table] tr.ng-scope");
            for(Element element:elements){
                try{
                    ComChangInfo comChangInfo=new ComChangInfo();
                    String change_time=element.select("span[class=ng-binding]").text().split(" ")[0];
                    String change_item=element.select("span[class=ng-binding]").text().split(" ")[1];
                    String before_change=element.select("span[ng-bind-html=change.contentBefore | splitNum]").text();
                    String after_change=element.select("span[ng-bind-html=change.contentAfter | splitNum]").text();
                    comChangInfo.setBid(Integer.parseInt(bid));
                    comChangInfo.setUuid(uuid);
                    comChangInfo.setAfter_change(after_change);
                    comChangInfo.setChange_time(change_time);
                    comChangInfo.setChange_item(change_item);
                    comChangInfo.setBefore_change(before_change);
                    if(isFirst==true) {
                        comChangeInfoDao.insertChangeInfo(comChangInfo);
                    }else {
                        List<ComChangInfo> comChangInfoList = comChangeInfoDao.selectChangeInfo(uuid);
                        boolean isExist=false;
                        for (int j = 0; j < comChangInfoList.size(); j++) {
                            String investOname=comChangInfoList.get(j).getChange_item();
                            String investUuid=comChangInfoList.get(j).getUuid();
                            if(investOname.equals(change_item)&&investUuid.equals(uuid)){
                                comChangeInfoDao.updateChangeInfo(comChangInfo);
                                isExist=true;
                                break;
                            }
                        }
                        if(isExist==false){
                            comChangeInfoDao.insertChangeInfo(comChangInfo);
                        }
                    }
                    //System.out.println(change_time + "***" + change_item + "***" + before_change + "***" + after_change);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


        return basOrgan;
    }


    /**
     * 获取webDriver
     * @return
     */
    public  WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * 关闭webDriver
     */
    public  void closeWebDriver() {
        driver.close();
        //System.exit(0);
    }




    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }
}
