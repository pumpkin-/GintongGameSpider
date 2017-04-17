package GintongameSpider.SpiderLxm;

import JavaBean.BasKnowledgeInfo;
import SpiderUtils.CommonSpiderKnowledge;
import SpiderUtils.LevenshteinDis;
import SpiderUtils.SpiderPerson;
import dao.impl.BasKnowledgeInfoDaoImpl;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
* Created by lenovon on 2017/4/5.
*/
public class DeleteDistinctDate {
    public static int fg=0;
    /*
       *
       * 获取当前时间之前或之后几小时 hour
       *
       *
       */
    public static String getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /*
     *
     * 获取当前时间之前或之后几分钟 minute
     *
     */

    public static String getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    /*
     *
     * 获取当前时间之前或之后几天 day
     *
     */

    public static String getTimeByDay(int day) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DATE, day);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

    public static void main(String[] args) throws BasKnowledgeInfoDaoImpl.FormatEexception {
//        BasKnowledgeInfoDaoImpl basKnowledgeInfoDaoImpl=new BasKnowledgeInfoDaoImpl();
//        List<BasKnowledgeInfo> list=basKnowledgeInfoDaoImpl.selectByTime();

    }


}
