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
import org.openqa.selenium.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/4/12.
 */
class ProxyAuthenticator extends Authenticator {
    private String user, password;

    public ProxyAuthenticator(String user, String password) {
        this.user     = user;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}

public class TycTwo {
    private List<String> perUrlList=new ArrayList<String>();
    private static WebDriver driver = null;
    private List<String> ipList=new ArrayList<String>();
    // 代理隧道验证信息
    private String proxyUser  = "H6R954181A3XJ74D";
    private String proxyPass  = "4162E8691ED2C6F3";
    // 代理服务器
    String proxyServer = "proxy.abuyun.com";
    int proxyPort      = 9020;

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


//        TycTwo spiderTyc=new TycTwo();
//        spiderTyc.getBussinessDataByList("腾讯",0);
//        spiderTyc.getBussinessDataByOne("http://www.tianyancha.com/company/713808677",true,null);
       // TycTwo tycTwo=new TycTwo();
       // tycTwo.addIp();
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

    public void addIp() throws Exception {
        File file=new File("E://可用IP.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String line=bufferedReader.readLine();
        while(line!=null){
            ipList.add(line);
            //System.out.println(line);
            line=bufferedReader.readLine();
        }
        System.out.println("ip加载完成");
    }

    public BasOrganizeInfo getBussinessDataByOne(String url,Boolean isFirst,String ouuid) throws Exception {
        WebDriver driver = getWebDriver(null);
        BasOrganizeInfo basOrganizeInfo=null;
        basOrganizeInfo = getBusinessDataByUrl(driver, url, isFirst,ouuid);
        System.out.println(basOrganizeInfo.getOname() + ":数据入库完毕(天眼查)");
        Thread.sleep(2000);
        closeWebDriver();
        return basOrganizeInfo;
    }

    public  BasOrganizeInfo getBussinessDataByList(String ComName,String ip) throws Exception {
        addIp();
        driver = getWebDriver(ip);
        //getAbuYunDriver();
        BasOrganizeInfo basOrganizeInfo=null;
        List<String> perUrlList=getPerUrl(driver,ComName);
        for(String url:perUrlList) {
            try {
                basOrganizeInfo = getBusinessDataByUrl(driver, url, true, null);
                System.out.println(basOrganizeInfo.getOname() + ":数据入库完毕(天眼查)");
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        perUrlList.clear();
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
        Thread.sleep(1000);
        WebElement webElementMain = driver.findElement(By.xpath("/html"));
        Document docMain = Jsoup.parse(webElementMain.getAttribute("outerHTML"));
//        Elements elements=docMain.select("a[class=query_name search-new-color]");
//        for(Element element:elements){
//            perUrlList.add(element.attr("href"));
//            System.out.println(element.attr("href"));
//        }
        Elements elements=docMain.select("div[class=search_result_single search-2017 pb20 pt20 pl30 pr30 ng-scope]");
        for(Element element:elements){
            System.out.println("走我了么？");
            String href=element.select("a[class=query_name search-new-color ng-isolate-scope]").attr("href");
            String gupiao=element.select("div p[ng-if=node.bondType]").text();
            System.out.println(href);
            System.out.println(gupiao);
            if(StringUtils.isNotEmpty(gupiao)){
                perUrlList.add(href);
                return perUrlList;
            }
            System.out.println("---------------------------------");
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
                    Elements eles=docMain.select("div[class=search_result_single search-2017 pb20 pt20 pl30 pr30 ng-scope]");
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




    public  BasOrganizeInfo  getBusinessDataByUrl(WebDriver driver, String CompanyUrl,Boolean isFirst,String ouuid) throws Exception {
        String oname=null;
        String uuid=null;
        BasOrganizeInfo basOrgan = new BasOrganizeInfo();
        driver.get(CompanyUrl);
        Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPass));
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
        oname = doc.select("span[   class=f18 in-block vertival-middle ng-binding]").text();
        // System.out.println(oname);
        //联系方式
        String con_way = doc.select("div[class=in-block vertical-top overflow-width mr20]:contains(电话) span.ng-binding").text();
        // System.out.println(con_way);
        //邮箱
        String email = doc.select("span[class=in-block vertical-top overflow-width emailWidth ng-binding]").text();
        // System.out.println(email);
        //地址
        String address = doc.select("span[class=in-block overflow-width vertical-top emailWidth ng-binding]").text();
        //System.out.println(address);
        //网址
        String web = doc.select("span[ng-hide=company.websiteList]").text();
        //System.out.println(web);
        //股票代码
        String stockCode = doc.select("span[class=f16 ng-binding]").text();
        stockCode = stockCode.replaceAll("（([0-9]{1,})）", "$1");
        //System.out.println(stockCode);
        //股票代码类型
        String stockCodeType = doc.select("span[class=border-radio2 f13 pl5 pr5 pt3 pb3 ng-binding]").text();
        //System.out.println(stockCodeType);
        //曾用名
        String usedName = null;
        usedName = doc.select("div[class=historyName45Bottom position-abs new-border pl8 pr8 pt4 pb4 ng-binding]").text();
        // System.out.println(usedName);
        //注册时间
//        String ztime = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[1];
        // System.out.println(ztime);

        String zmoney=null;
        String ztime=null;
        String state=null;
        int num=0;
        Elements eless=doc.select("div.baseInfo_model2017 tbody tr td div");
        for(Element element:eless){
            if(num==1){
                zmoney=element.text();
            }
            if(num==2){
                ztime=element.text();
            }
            if(num==3){
                state=element.text();
            }
            num++;
        }

        //法定代表人
        String boss = doc.select("a[class=in-block vertival-middle overflow-width f14 mr20 ng-binding ng-scope]").text();
        //System.out.println(boss);
        //法定代表人连接
        String bossUrl = "http://www.tianyancha.com" + doc.select("a[class=in-block vertival-middle overflow-width f14 mr20 ng-binding ng-scope]").attr("href");
        //System.out.println(bossUrl);
        //注册资本
//        String zmoney = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[0];
        // System.out.println(zmoney);
        //状态
//        String state = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[2];
        //System.out.println(state);


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

        String businessScope = doc.select("span[ng-if=!showDetail]").text();
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
        String[] leaderName=doc.select("a[event-name=company-detail-staff]").text().split(" ");
        Elements leaderUrl=doc.select("a[event-name=company-detail-staff]");
        String[] leaderDuty=doc.select("span[ng-repeat=join in s.typeJoin track by $index]").text().split(" ");
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
                    String partnerMoney = partner.select("span[ng-class=item.amomon?'':'c-none']").text();
                    //股东投资人 出资比例
                    String investment_rate=partner.select("span[class=c-money-y ng-binding]").text();
                    //股东投资人的 认缴时间
                    String subscription_time=null;
                    if (StringUtils.isNotEmpty(partner.select("span[ng-if=item.time]").text())) {
                        subscription_time = partner.select("span[ng-if=item.time]").text().split("：")[1];
                    }

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
                    String subscription_time=null;
                    //System.out.println("fjaknfkjasf----------"+partner.select("span[ng-if=item.time]").text());
                    if(StringUtils.isNotEmpty(partner.select("span[ng-if=item.time]").text())) {
                        subscription_time = partner.select("span[ng-if=item.time]").text().split("：")[1];
                    }

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
                    String change_time = element.select("div[class=ng-binding]").text().split(" ")[0];
                    String change_item = element.select("div[class=ng-binding]").text().split(" ")[1];
                    String before_change = element.select("div[ng-bind-html=change.contentBefore]").text();
                    String after_change = element.select("div[ng-bind-html=change.contentAfter]").text();
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
                        String change_time = ele.select("div[class=ng-binding]").text().split(" ")[0];
                        String change_item = ele.select("div[class=ng-binding]").text().split(" ")[1];
                        String before_change = ele.select("div[ng-bind-html=change.contentBefore]").text();
                        String after_change = ele.select("div[ng-bind-html=change.contentAfter]").text();
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
                    String change_time=element.select("div[class=ng-binding]").text().split(" ")[0];
                    String change_item=element.select("div[class=ng-binding]").text().split(" ")[1];
                    String before_change=element.select("div[ng-bind-html=change.contentBefore]").text();
                    String after_change=element.select("div[ng-bind-html=change.contentAfter]").text();
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
    public  WebDriver getWebDriver(String ip) {
        //String ipAndport=ipList.get(num);
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        String proxyIpAndPort= ip;
        System.out.println(ip);
        DesiredCapabilities cap = new DesiredCapabilities();
        Proxy proxy=new Proxy();
        proxy.setHttpProxy(proxyIpAndPort).setFtpProxy(proxyIpAndPort).setSslProxy(proxyIpAndPort);
        cap.setCapability(CapabilityType.ForSeleniumServer.AVOIDING_PROXY, true);
        cap.setCapability(CapabilityType.ForSeleniumServer.ONLY_PROXYING_SELENIUM_TRAFFIC, true);
        System.setProperty("http.nonProxyHosts", ip.split(":")[0]);
        cap.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver=new ChromeDriver(cap);
        return driver;
    }

    public  void getAbuYunDriver() {
        System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
        DesiredCapabilities cap = new DesiredCapabilities();
        Proxy proxy=new Proxy();
        proxy.setHttpProxy(proxyServer+":"+proxyPort).setFtpProxy(proxyServer+":"+proxyPort).setSslProxy(proxyServer+":"+proxyPort);
//        proxy.setSocksUsername(proxyUser);
//        proxy.setSocksPassword(proxyPass);
        cap.setCapability(CapabilityType.ForSeleniumServer.AVOIDING_PROXY, true);
        cap.setCapability(CapabilityType.ForSeleniumServer.ONLY_PROXYING_SELENIUM_TRAFFIC, true);
        System.setProperty("http.nonProxyHosts", proxyServer);
        cap.setCapability(CapabilityType.PROXY, proxy);
        driver=new ChromeDriver(cap);

    }

    /**
     * 关闭webDriver
     */
    public  void closeWebDriver() {
        driver.close();
        //System.exit(0);
    }
}
