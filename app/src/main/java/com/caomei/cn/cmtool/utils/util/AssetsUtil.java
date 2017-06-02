package com.caomei.cn.cmtool.utils.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zw on 2017/6/2.
 * android资源文件夹assets的工具类
 */

public class AssetsUtil {
    private AssetsUtil() {}

    private Properties getPropFromAssets(String filePath) {
        try {
            InputStream in = getClass().getResourceAsStream("/assets/" + filePath);
            Properties props = new Properties();
            props.load(in);
            in.close();
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static AssetsUtil instance = new AssetsUtil();

    /**
     * 获取assets文件夹下对应文件的值，根据key获取value
     */
    public static String get(String filePath, String key) {
        return (String)instance.getPropFromAssets(filePath).get(key);
    }
}
