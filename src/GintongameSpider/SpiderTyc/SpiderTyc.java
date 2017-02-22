package GintongameSpider.SpiderTyc;

import SpiderUtils.SpiderContant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2017/2/21.
 */
public class SpiderTyc {
    public static void main(String [] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", SpiderContant.chromeWindowsPath);
            WebDriver driver = new ChromeDriver();
            driver.get("http://www.tianyancha.com/company/150041670");
            Thread.sleep(2000);
            WebElement webElement = driver.findElement(By.xpath("/html"));
            Document doc = Jsoup.parse(webElement.getAttribute("outerHTML"));
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
            String bossUrl="www.tianyancha.com"+doc.select("td.td-legalPersonName-value a[ng-if=company.baseInfo.legalPersonName]").attr("href");
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
            //营业期限(未确认)
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
            System.out.println("公司名字："+oname);
            System.out.println("公司曾用名:"+usedName);
            System.out.println("联系方式:"+con_way);
            System.out.println("邮箱:"+email);
            System.out.println("地址:"+address);
            System.out.println("网址:"+web);
            System.out.println("公司简介:---->"+oname+"-"+con_way+"-"+email+"-"+address+"-"+web);
            System.out.println("公司基本信息:--->"+ztime+"-"+boss+"-"+bossUrl+"-"+zmoney+"-"+state+"-"+industry+"-"+businessNo+"-"+
                    companyStyle+"-"+orgNo+"-"+businessTime+"-"+registDePart+"-"+approvalDate+"-"+uniformCode+"-"+registAddress+"-"+businessScope);

            //对外投资
            //对外投资公司名称
            String[] investComName=doc.select("div[class=col-xs-10 search_name search_repadding2 f14] a.query_name span.ng-binding").text().split(" ");
            //对外投资法定代表人
            String[] investBoss=doc.select("div[ng-if=company.investList.length>0] div[class=search_row_new f13] div[style=padding-left: 0]").text().split(" ");
            //对外投资行业
            String[] investIndusty=  doc.select("div[ng-if=company.investList.length>0] div.row>div.search_row_new.f13 div.title:contains(行业) span.ng-binding").text().split(" ");
            //对外投资状态
            String[] investState =doc.select("div[ng-if=company.investList.length>0] div[class=search_row_new f13] div[style=border-right: none] span.ng-binding").text().split(" ");
            //对外投资数额
            String[] investMoney=doc.select("div[ng-if=company.investList.length>0] p[class=f13 ptten] span[class=c2 ng-binding]").text().split(" ");
            for(int i=0;i<investComName.length;i++) {
                System.out.println("对外投资-----》"+investComName[i]+"--"+investBoss[i].split("：")[1]+"---"+investIndusty[i]+"--"+investState[i]+"---"+investMoney[i]);
                System.out.println();
            }


        List<String> leaderNamelist=new ArrayList();
        List<String> leaderDutylist=new ArrayList();
        List<String> leaderUrlList=new ArrayList();
        Elements leader=doc.select("div[ng-if=company.staffList.length>0] tbody>tr>td[ng-style=$last?{width:(100-(($index)*33))+'%'}:{width:'33%'}]>a");
        Elements leaderDuty=doc.select("div[ng-if=company.staffList.length>0] tr td[ng-class=$last ?'':'td-right-border']:has(span)");
        for(org.jsoup.nodes.Element leadName:leader){
            leaderNamelist.add(leadName.text());
        }
        for(org.jsoup.nodes.Element leadDuty:leader){
            leaderUrlList.add(leadDuty.attr("href"));
        }
        for(org.jsoup.nodes.Element zhi:leaderDuty){
            leaderDutylist.add(zhi.text());
        }
        for(int i=0;i<leaderDutylist.size();i++){
            //高管人名
            String leadName=leaderNamelist.get(i);
            //高管职务
            String leadDuty=leaderDutylist.get(i);
            String leadUrl="www.tianyancha.com"+leaderUrlList.get(i);
            System.out.println("高管:------>"+leadUrl+"+"+leadName+"+"+leadDuty);
            System.out.println();
        }

        //股东信息
        Elements partnerlink=doc.select("div[ng-if=company.investorList.length>0] div.search_result_single.ng-scope");
        for(org.jsoup.nodes.Element partner:partnerlink){
            if(partner.select("a").attr("href").contains("human")){
                //股东名称连接
                String partnerNameUrl="www.tianyancha.com"+partner.select("a").attr("href");
                //股东人名字
                String partnerName=partner.select("a").text();
                //股东投资金额
                String partnerMoney=partner.select("span.c2.ng-binding").text();
                System.out.println("人物股东信息:---->"+partnerNameUrl+"-"+partnerName+"-"+partnerMoney);
            }else{
                //股东公司网址
                String partnerComNameUrl="www.tianyancha.com"+partner.select("a").attr("href");
                //股东公司名称
                String partnerComName=partner.select("a").text();
                //股东公司法定代表人
                String partnerComPer=partner.select("span.ng-binding").get(0).text();
                //股东行业
                String partnerIndustry=partner.select("span.ng-binding").get(1).text();
                //股东状态
                String partnerState=partner.select("span.ng-binding").get(2).text();
                //股东投资金额
                String partnerComMoney=partner.select("p.f13.ptten span.c2.ng-binding").text();
                System.out.println("人物股东信息:---->"+partnerComNameUrl+"-"+partnerComName+"-"+partnerComPer+"-"+partnerIndustry+"-"+partnerState+"-"+partnerComMoney);
            }
        }

            driver.close();
            System.exit(0);






    }
}
