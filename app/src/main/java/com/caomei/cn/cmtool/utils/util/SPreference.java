package com.caomei.cn.cmtool.utils.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.caomei.cn.cmtool.app.CmApplication;

/**
 * Created by zw on 2017/6/2.
 */

public class SPreference {
    private final static String sp_name = "cl_sp_name";

    private static SharedPreferences sp;

    private static SharedPreferences getSharePreference() {
        if (sp == null) {
            sp = CmApplication.getContext().getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static void putString(String key, String value) {
        getSharePreference().edit().putString(key, value).commit();
    }

    public static void putInt(String key, int value) {
        getSharePreference().edit().putInt(key, value).commit();
    }

    public static void putFloat(String key, float value) {
        getSharePreference().edit().putFloat(key, value).commit();
    }

    public static void putBoolean(String key, boolean value) {
        getSharePreference().edit().putBoolean(key, value).commit();
    }

    public static void putLong(String key, long value) {
        getSharePreference().edit().putLong(key, value).commit();
    }

    public static String getString(String key) {
        return getSharePreference().getString(key, "");
    }

    public static int getInt(String key) {
        return getSharePreference().getInt(key, 0);
    }

    public static float getFloat(String key) {
        return getSharePreference().getFloat(key, 0f);
    }

    public static boolean getBoolean(String key) {
        return getSharePreference().getBoolean(key, false);
    }

    public static long getLong(String key) {
        return getSharePreference().getLong(key, 0l);
    }

    public static String getString(String key, String defaultValue) {
        return getSharePreference().getString(key, defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        return getSharePreference().getInt(key, defaultValue);
    }

    public static float getFloat(String key, float defaultValue) {
        return getSharePreference().getFloat(key, defaultValue);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return getSharePreference().getBoolean(key, defaultValue);
    }

    public static long getLong(String key, long defaultValue) {
        return getSharePreference().getLong(key, defaultValue);
    }

    public static void clear() {
        getSharePreference().edit().clear();
    }

    public static void remove(String key) {
        getSharePreference().edit().remove(key).commit();
    }
}
