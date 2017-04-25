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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        tycUpdate.getBussinessDataByList("浙江梧斯源通信科技股份有限公司");
        //tycUpdate.getBussinessDataByOne("http://www.tianyancha.com/company/1600645095",true,null);
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
        perUrlList=getPerUrl(driver,ComName);
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
        perUrlList.clear();
        Thread.sleep(2000);
        //closeWebDriver();
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
        Thread.sleep(3000);
        Boolean isBreak=false;
            if(docMain.outerHtml().contains("移动到此开始验证")){
            isBreak=mainProcess(docMain);
        }else{
            isBreak=true;
        }
        if(isBreak==true) {
            driver.get(comUrl);
            Thread.sleep(1000);
            WebElement webElementMains = driver.findElement(By.xpath("/html"));
            Document docMains = Jsoup.parse(webElementMains.getAttribute("outerHTML"));
            Elements elements = docMain.select("div[class=search_result_single search-2017 pb20 pt20 pl30 pr30 ng-scope]");
            for (Element element : elements) {
                System.out.println("走我了么？");
                String href = element.select("a[class=query_name search-new-color ng-isolate-scope]").attr("href");
                String gupiao = element.select("div p[ng-if=node.bondType]").text();
                System.out.println(href);
                System.out.println(gupiao);
                if (StringUtils.isNotEmpty(gupiao)) {
                    perUrlList.add(href);
                    return perUrlList;
                }
                System.out.println("---------------------------------");
            }
            System.out.println("第1页数据已经跑完");
            Element elementsPage = docMain.select("div[class=total ng-binding]").last();
            if (elementsPage != null) {
                String pages = elementsPage.text();
                Pattern pattern = Pattern.compile("[0-9]{1,}");
                Matcher matcher = pattern.matcher(pages);
                while (matcher.find()) {
                    page = Integer.parseInt(matcher.group(0));
                    System.out.println("page----:" + page);
                }
                for (int i = 2; i < page; i++) {
                    try {
                        String url = "http://www.tianyancha.com/search/p" + i + "?key=" + comName;
                        docMain = getDocumentBySelenium(driver, url);
                        Elements eles = docMain.select("div[class=search_result_single search-2017 pb20 pt20 pl30 pr30 ng-scope]");
                        for (Element element : eles) {
                            String href = element.select("a[class=query_name search-new-color]").attr("href");
                            String gupiao = element.select("div p[ng-if=node.bondType]").text();
                            if (StringUtils.isNotEmpty(gupiao)) {
                                perUrlList.add(href);
                                return perUrlList;
                            }
                        }
                        System.out.println("第" + i + "页数据已经跑完");
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

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
        executornext.executeScript("$(\"#ng-view > div.ng-scope > div > div > div > div.col-9.company-main.pl0.pr10.company_new_2017 > " +
                "div > div.pl30.pr30.pt25 > div:nth-child(7) > div.ng-scope > div.company_pager.ng-scope > ul > li.pagination-next.ng-scope > a\").click()");
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
        //System.out.println(zmoney+"--"+ztime+"--"+state);

//        //注册时间
//        String ztime = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[1];
//       // System.out.println(ztime);
//        //状态
//        String state = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[2];
//        //System.out.println(state);
//        //注册资本
//        String zmoney = doc.select("div[class=baseinfo-module-content-value ng-binding]").text().split(" ")[0];
//        // System.out.println(zmoney);

        //法定代表人
        String boss = doc.select("a[class=in-block vertival-middle overflow-width f14 mr20 ng-binding ng-scope]").text();
        //System.out.println(boss);
        //法定代表人连接
        String bossUrl = "http://www.tianyancha.com" + doc.select("a[class=in-block vertival-middle overflow-width f14 mr20 ng-binding ng-scope]").attr("href");
        //System.out.println(bossUrl);

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
//               companyStyle+"-"+orgNo+"-"+businessTime+"-"+registDePart+"-"+approvalDate+"-"+uniformCode+"-"+registAddress+"-"+businessScope);

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

    public Boolean mainProcess(Document doc) throws Exception {
        Elements elements=doc.select("div[class=gt_cut_bg gt_show] div[class=gt_cut_bg_slice]");
        List<String> dgImgUrl=new ArrayList<String>();
        List<String[]> dgImgTopLeftPointList=new ArrayList<String[]>();
        for(Element element:elements){
            String dgImg=element.attr("style");
            dgImgUrl.add(dgImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=dgImg.split("background-position:")[1].split(";")[0].trim();
            String[] dgImgTopLeftPoint=new String[2];
            dgImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            dgImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            dgImgTopLeftPointList.add(dgImgTopLeftPoint);
        }
        List<String> fullImgUrl=new ArrayList<String>();
        List<String[]> fullImgTopLeftPointList=new ArrayList<String[]>();
        Elements eles=doc.select("div[class=gt_cut_fullbg gt_show] div[class=gt_cut_fullbg_slice]");
        for(Element element:eles){
            String fullImg=element.attr("style");
            fullImgUrl.add(fullImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=fullImg.split("background-position:")[1].split(";")[0].trim();
            String[] fullImgTopLeftPoint=new String[2];
            fullImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            fullImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            fullImgTopLeftPointList.add(fullImgTopLeftPoint);
        }
        Boolean dgjudge=combineImages(dgImgUrl,dgImgTopLeftPointList,26,10,58,"E://极验图片/tyc_dg.webp","webp");
        Boolean fulljudge=combineImages(fullImgUrl,fullImgTopLeftPointList,26,10,58,"E://极验图片/tyc_full.webp","webp");
        System.out.println("dgjudge:"+dgjudge);
        System.out.println("fulljudge:"+fulljudge);
        int left=findXDiffRectangeOfTwoImage("E://极验图片/tyc_dg.webp","E://极验图片/tyc_full.webp");
        System.out.println(left);
        Boolean isBreak = breakIdentifyingCode(left, driver);
        while(isBreak==false) {
            left=findXDiffRectangeOfTwoImage("E://极验图片/tyc_dg.webp","E://极验图片/tyc_full.webp");
            System.out.println(left);
            isBreak = breakIdentifyingCode(left, driver);
            if(isBreak==true){
                break;
            }
        }
        return isBreak;
    }


    public void getPicture(WebDriver driver) throws Exception {
        Element doc=getCode(driver);
        Elements elements=doc.select("div[class=gt_cut_bg gt_show] div[class=gt_cut_bg_slice]");
        List<String> dgImgUrl=new ArrayList<String>();
        List<String[]> dgImgTopLeftPointList=new ArrayList<String[]>();
        for(Element element:elements){
            String dgImg=element.attr("style");
            dgImgUrl.add(dgImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=dgImg.split("background-position:")[1].split(";")[0].trim();
            String[] dgImgTopLeftPoint=new String[2];
            dgImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            dgImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            //System.out.println(dgImgTopLeftPoint[0]+"-"+dgImgTopLeftPoint[1]);
            dgImgTopLeftPointList.add(dgImgTopLeftPoint);
        }
//        for(int i=0;i<dgImgUrl.size();i++){
//            System.out.println(dgImgUrl.get(i)+"-----"+dgImgTopLeftPointList.get(i));
//        }
        //System.out.println("------------------------------------------------------------");
        List<String> fullImgUrl=new ArrayList<String>();
        List<String[]> fullImgTopLeftPointList=new ArrayList<String[]>();
        Elements eles=doc.select("div[class=gt_cut_fullbg gt_show] div[class=gt_cut_fullbg_slice]");
        for(Element element:eles){
            String fullImg=element.attr("style");
            fullImgUrl.add(fullImg.split("\\(\"")[1].split("\"\\);")[0]);
            String imgSize=fullImg.split("background-position:")[1].split(";")[0].trim();
            String[] fullImgTopLeftPoint=new String[2];
            fullImgTopLeftPoint[0]=imgSize.split(" ")[0].replace("px","");
            fullImgTopLeftPoint[1]=imgSize.split(" ")[1].replace("px","");
            //System.out.println(fullImgTopLeftPoint[0]+"-"+ fullImgTopLeftPoint[1]);
            fullImgTopLeftPointList.add(fullImgTopLeftPoint);
        }
        Boolean dgjudge=combineImages(dgImgUrl,dgImgTopLeftPointList,26,10,58,"E://极验图片/tyc_dg.webp","webp");
        Boolean fulljudge=combineImages(fullImgUrl,fullImgTopLeftPointList,26,10,58,"E://极验图片/tyc_full.webp","webp");
        System.out.println("dgjudge:"+dgjudge);
        System.out.println("fulljudge:"+fulljudge);
        int left=findXDiffRectangeOfTwoImage("E://极验图片/tyc_dg.webp","E://极验图片/tyc_full.webp");
    }


    public List<Integer> clearLeft(int left){
        List<Integer> leftList=new ArrayList<Integer>();
        int x=(int)(Math.random()*2+1);
        while(left-x>5){
            leftList.add(x);
            left=left-x;
            x=(int)(Math.random()*2+1);
        }
        for(int i=0;i<left;i++) {
            leftList.add(1);
        }
        return leftList;
    }


    public Boolean breakIdentifyingCode(int left,WebDriver driver) throws Exception {
        Boolean isBreak=false;
        WebElement element = driver.findElement(By.cssSelector(".gt_slider_knob.gt_show"));
        Point location = element.getLocation();
        int y=location.y;
        element.getSize();
        Actions action = new Actions(driver);
        action.clickAndHold(element).perform();
        List<Integer> leftList=clearLeft(left);
        int num=0;
        action.moveToElement(element).clickAndHold(element).perform();
        Thread.sleep(150);
        int x1=22;
        for(int i=0;i<leftList.size();i++){
            action.moveToElement(element,22+leftList.get(i),location.y-445).perform();
        }
        Thread.sleep(200);
        for(int i=0;i<7;i++){
            action.moveToElement(element,21,location.y-445).perform();
            Thread.sleep(200);
        }
        int[] xx={4,10};
        int sum=0;
        for(int i=0;i<2;i++){
            int xx1=new Random().nextInt(xx[0]);
            int xx2=new Random().nextInt(xx[0]);
            sum=sum+(xx1*2)-(xx2*2);
            action.moveToElement(element,22+xx1,location.y-445).perform();
            Thread.sleep(((int)Math.random()*2+1)*100);
            action.moveToElement(element,22-xx2,location.y-445).perform();
            Thread.sleep(((int)Math.random()*2+1)*100);
            action.moveToElement(element,22+xx2,location.y-445).perform();
            Thread.sleep(((int)Math.random()*2+1)*100);
            action.moveToElement(element,22-xx1,location.y-445).perform();
            Thread.sleep(((int)Math.random()*2+1)*100);
            xx[0]-=0;
        }
        action.release().perform();
        Thread.sleep(1500);
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementsByClassName(\"btn btn-block btn-info\")[0].click()");
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
        WebElement webMainElement=driver.findElement(By.xpath("/html"));
        Document document=Jsoup.parse(webMainElement.getAttribute("outerHTML"));
        getPicture(driver);
        System.out.println("position-abs:"+document.select("div.position-abs").text());
        if(StringUtils.isNotEmpty(document.select("div.position-abs").text())){
            isBreak=true;
        }
        System.out.println("First.isBreak:"+isBreak);
        return isBreak;
    }

    public Document getCode(WebDriver driver) throws InterruptedException {
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
        WebElement webMainElement=driver.findElement(By.xpath("/html"));
        Document document=Jsoup.parse(webMainElement.getAttribute("outerHTML"));
        return document;
    }


    public static boolean combineImages(List<String> imgSrcList, List<String[]> topLeftPointList, int countOfLine, int cutWidth, int cutHeight, String savePath, String subfix) {
        if (imgSrcList == null || savePath == null || savePath.trim().length() == 0) return false;
        BufferedImage lastImage = new BufferedImage(cutWidth * countOfLine, cutHeight * ((int) (Math.floor(imgSrcList.size() / countOfLine))), BufferedImage.TYPE_INT_RGB);
        String prevSrc = "";
        BufferedImage prevImage = null;
        try {
            for (int i = 0; i < imgSrcList.size(); i++) {
                String src = imgSrcList.get(i);
                BufferedImage image;
                if (src.equals(prevSrc)) image = prevImage;
                else {
                    if (src.trim().toLowerCase().startsWith("http"))
                        image = ImageIO.read(new URL(src));
                    else
                        image = ImageIO.read(new File(src));
                    prevSrc = src;
                    prevImage = image;

                }
                if (image == null) continue;
                String[] topLeftPoint = topLeftPointList.get(i);
                int[] pixArray = image.getRGB(0 - Integer.parseInt(topLeftPoint[0].trim()), 0 - Integer.parseInt(topLeftPoint[1].trim()), cutWidth, cutHeight, null, 0, cutWidth);
                int startX = ((i) % countOfLine) * cutWidth;
                int startY = ((i) / countOfLine) * cutHeight;

                lastImage.setRGB(startX, startY, cutWidth, cutHeight, pixArray, 0, cutWidth);
            }
            File file = new File(savePath);
            System.out.println(lastImage+"---"+subfix+"---"+file);
            return ImageIO.write(lastImage, subfix, file);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static int findXDiffRectangeOfTwoImage(String imgSrc1, String imgSrc2) {
        try {
            BufferedImage image1 = ImageIO.read(new File(imgSrc1));
            BufferedImage image2 = ImageIO.read(new File(imgSrc2));
            int width1 = image1.getWidth();
            int height1 = image1.getHeight();
            int width2 = image2.getWidth();
            int height2 = image2.getHeight();

            if (width1 != width2) return -1;
            if (height1 != height2) return -1;

            int left = 0;
            /**
             * 从左至右扫描
             */
            boolean flag = false;
            for (int i = 0; i < width1; i++) {
                for (int j = 0; j < height1; j++)
                    if (isPixelNotEqual(image1, image2, i, j)) {
                        left = i;
                        flag = true;
                        break;
                    }
                if (flag) break;
            }
            return left;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    private static boolean isPixelNotEqual(BufferedImage image1, BufferedImage image2, int i, int j) {
        int pixel1 = image1.getRGB(i, j);
        int pixel2 = image2.getRGB(i, j);

        int[] rgb1 = new int[3];
        rgb1[0] = (pixel1 & 0xff0000) >> 16;
        rgb1[1] = (pixel1 & 0xff00) >> 8;
        rgb1[2] = (pixel1 & 0xff);

        int[] rgb2 = new int[3];
        rgb2[0] = (pixel2 & 0xff0000) >> 16;
        rgb2[1] = (pixel2 & 0xff00) >> 8;
        rgb2[2] = (pixel2 & 0xff);


        for (int k = 0; k < 3; k++) {
            //System.out.println(Math.abs(rgb1[k])+"---------------"+Math.abs(rgb2[k]));
            if (Math.abs(rgb1[k] - rgb2[k]) > 50)//因为背景图会有一些像素差异
                return true;
        }
        return false;
    }




}
