package com.wancient.springcloud.api.utils;

import com.github.pagehelper.util.StringUtil;

import java.util.Date;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/27
 * Time: 15:47
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        //int s = random.nextInt(max) % (max - min + 1) + min;
        Integer number = random.nextInt(999999) % (999999 - 100000 + 1) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

    /**
     * 生成编号
     *
     * @param type 生成编号前缀 如：DZ返回,DZ+时间戳+4位随机数,如果为空：返回,时间戳+4位随机数
     */
    public static String createNum(String type) {
        try {

            Date date = new Date();
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
            String time = date.getTime() + "";
            String num = getRanNum();
            if (StringUtil.isEmpty(type)) {
                return time + num;
            }
            return type + time + num;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRanNum() {
        double r = Math.random();
        return (int) (r * 9000 + 1000) + "";//取值范围是[1000,10000)
    }
}
