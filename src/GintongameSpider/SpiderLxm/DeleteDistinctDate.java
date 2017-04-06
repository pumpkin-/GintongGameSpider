package GintongameSpider.SpiderLxm;

import JavaBean.BasProGameInfo;
import JavaBean.ProKnowledge;
import dao.impl.ProGameInfoDaoImpl;
import dao.impl.ProKnowledgeImpl;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* Created by lenovon on 2017/4/5.
*/
public class DeleteDistinctDate {
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

    public static void main(String[] args) {

        // 获取当前时间5分钟前的时间 格式yyyy-MM-dd HH:mm:ss

        System.out.println(getTimeByMinute(-5));

        // 获取当前时间3小时后的时间 格式yyyy-MM-dd HH:mm:ss

        System.out.println(getTimeByHour(3));

        // 获取当前时间2天后的时间 格式yyyy-MM-dd HH:mm:ss

        System.out.println(getTimeByDay(2));

    }

}
