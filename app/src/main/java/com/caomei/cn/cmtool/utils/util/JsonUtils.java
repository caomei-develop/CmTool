
package com.caomei.cn.cmtool.utils.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * json转换工具�?
 * 
 * @author wangjie0503
 */
public class JsonUtils {

    /**
     * 将对象转换为json字符串
     * 
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * 将json字符串转为指定的对象
     * 
     * @param json json字符串
     * @param cls 目标对象
     * @return
     */
    public static <T> T objectFromJson(String json, Class<T> cls) {
        Gson gson = new Gson();
        return gson.fromJson(json, cls);
    }
    
    /**
	 * 将给定的 {@code JSON} 字符串转换成指定的类型对象�??
	 * 
	 */
	public static <T> T fromJson(String json, Type type) {
		try {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			return gson.fromJson(json, type);
		} catch (Exception e) {
		}
		return null;
		
	}
    /**
     * 将json字符串转为指定的ArrayList
     * 
     * @param json
     * @return
     */
    public static <T> ArrayList<T> listFromJson(String json, Class<T> cls) throws JSONException {
        ArrayList<T> list = new ArrayList<T>();
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        JSONArray array = new JSONArray(json);
        int len = 0;
        T t;
        if (array != null && (len = array.length()) > 0) {
            for (int i = 0; i < len; i++) {
                t = JsonUtils.objectFromJson(array.getString(i), cls);
                if (t != null) {
                    list.add(t);
                }
            }
        }

        return list;
    }

    private JsonUtils() {
    }


}
