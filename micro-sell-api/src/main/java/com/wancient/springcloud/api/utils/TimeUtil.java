package com.wancient.springcloud.api.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 *
 * @author: Wancient
 * @date: 2018/6/13
 * @time: 17:55
 */
@Slf4j
public class TimeUtil {

    /**
     * 今天开始时间格式
     *
     * @return
     */
    private static Date todayStartTimeFormat() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 今天结束时间格式
     *
     * @return
     */
    private static Date todayEndTimeFormat() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 当月开始时间格式
     *
     * @return
     */
    private static Date monthStartTimeFormat() {
        Calendar monthStart = Calendar.getInstance();
        // 获取前月的第一天
        monthStart = Calendar.getInstance();
        monthStart.add(Calendar.MONTH, 0);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);
        return monthStart.getTime();
    }

    /**
     * 当月结束时间格式
     *
     * @return
     */
    private static Date monthEndTimeFormat() {
        Calendar monthEnd = Calendar.getInstance();
        // 获取前月的最后一天
        monthEnd = Calendar.getInstance();
        monthEnd.add(Calendar.MONTH, 1);
        monthEnd.set(Calendar.DAY_OF_MONTH, 0);
        return monthEnd.getTime();
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static String getTodayStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(todayStartTimeFormat());
    }

    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static String getTodayEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(todayEndTimeFormat());
    }

    /**
     * 获取当月开始时间
     *
     * @return
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(monthStartTimeFormat());
    }

    /**
     * 获取当月结束时间
     *
     * @return
     */
    public static String getMonthLastDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(monthEndTimeFormat());
    }

    /**
     * 获取当天日期
     *
     * @return
     */
    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 获取年的开始时间
     *
     * @param year
     * @return
     */
    public static Date getYearStartTime(String year) {
        try {
            String string = year + "-1-1 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(string);
        } catch (Exception e) {
            log.info("转换出错:{}", e.getMessage());
        }
        return null;
    }


    /**
     * 获取年的开始时间
     *
     * @param year
     * @return
     */
    public static Date getYearEndTime(String year) {
        try {
            String string = year + "-12-31 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(string);
        } catch (Exception e) {
            log.info("转换出错:{}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取时间的string格式
     *
     * @param date
     * @param form
     * @return
     */
    public static String getStr(Date date, String form) {
        SimpleDateFormat sdf = new SimpleDateFormat(form);
        return sdf.format(date);
    }


}
