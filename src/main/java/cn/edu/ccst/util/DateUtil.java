package cn.edu.ccst.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/16:38
 * @Description:
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理工具类.
 *
 * @author
 */
public class DateUtil {

    /**
     * 获取当前日期 2000-01-01
     *
     * @return
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取 当前时间 15:01:01
     *
     * @return
     */
    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    /**
     * 检查字符串日期date是否符合 "2010-01-01" 的格式.
     *
     * @param date 日期字符串
     * @return
     */
    public static boolean isValidDate(String date) {
        if (date.length() != 10) {
            return false;
        }
        char c[] = date.toCharArray();
        if (c[4] != '-' || c[7] != '-') {
            return false;
        }
        for (int i = 0; i < c.length; i++) {
            if (i == 4 || i == 7) {
                continue;
            }
            if (!Character.isDigit(c[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取指定日期的前后几个月的日期.
     *
     * @param date 日期字符串
     * @param value 月份偏离值 大于0 往后value月，小于0 往前value月
     * @return 日期字符串
     */
    public static String getLeaveMonth(String date, int value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(date));
            cd.add(Calendar.MONTH, value);//增加一个月

            return sdf.format(cd.getTime());

        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 获取指定日期的前后几日的日期.
     *
     * @param date 日期字符串
     * @param value 日偏离值 大于0 往后value日，小于0 往前value日
     * @return 日期字符串
     */
    public static String getLeaveDay(String date, int value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(date));
            cd.add(Calendar.DATE, value);//增加一天
            //cd.add(Calendar.MONTH, n);//增加一个月
            return sdf.format(cd.getTime());
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 字符串转日期.
     *
     * @param date
     * @return
     */
    public static Date chgStrToDate(String date) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return s.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
    /**
     * 日期转字符串.
     *
     * @param date
     * @return
     */
    public static String chgDateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    /**
     *
     * @param s
     * @return
     */
    public static String fmtMD(String s) {
        return String.format("%02d", Integer.parseInt(s));
    }

    /*
     * 判断是否是一个月的最后一天
     */
    public static boolean isLastDayOfMonth(String rq) {
        Calendar c = Calendar.getInstance();
        int year = Integer.parseInt(rq.substring(0, 4));
        int month = Integer.parseInt(rq.substring(5, 7));
        int day = Integer.parseInt(rq.substring(8));
        //c.set(year, month, day);

        c.setTime(chgStrToDate(rq));
        c.set(Calendar.DATE, (c.get(Calendar.DATE) + 1));

        if (c.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    public static String getLeaveMonth2(String rq, int value) {
        int year = Integer.parseInt(rq.substring(0, 4));
        int month = Integer.parseInt(rq.substring(5, 7));
        int day = Integer.parseInt(rq.substring(8));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//定义日期显示格式
        GregorianCalendar c = new GregorianCalendar(year, month, day);
        c.add(Calendar.MONTH, value - 1);
        return sdf.format(c.getTime());
    }

    public static boolean isLastDayOfMonth_1(String rq) {
        Calendar c = Calendar.getInstance();
        int year = Integer.parseInt(rq.substring(0, 4));
        int month = Integer.parseInt(rq.substring(5, 7));
        int day = Integer.parseInt(rq.substring(8));
        //c.set(year, month, day);
        c.setTime(chgStrToDate(rq));
        c.set(Calendar.DATE, (c.get(Calendar.DATE) + 2));

        if (c.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isLastDayOfMonth_2(String rq) {
        Calendar c = Calendar.getInstance();
        int year = Integer.parseInt(rq.substring(0, 4));
        int month = Integer.parseInt(rq.substring(5, 7));
        int day = Integer.parseInt(rq.substring(8));
        //c.set(year, month, day);
        c.setTime(chgStrToDate(rq));
        c.set(Calendar.DATE, (c.get(Calendar.DATE) + 3));

        if (c.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }
}

