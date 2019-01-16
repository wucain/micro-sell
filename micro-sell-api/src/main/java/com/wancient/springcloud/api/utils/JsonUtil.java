package com.wancient.springcloud.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/14
 * Time: 22:15
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
