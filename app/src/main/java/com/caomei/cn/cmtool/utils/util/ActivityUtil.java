package com.caomei.cn.cmtool.utils.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.caomei.cn.cmtool.base.BaseActivity;

/**
 * Created by zw on 2017/6/2.
 */

public class ActivityUtil {
    /**
     * 跳转到指定activity
     */
    public static void toActivity(Activity from, Class<? extends Activity> clz) {
        Intent intent = new Intent(from, clz);
        from.startActivity(intent);
    }

    /**
     * 跳转到指定activity，带传值
     */
    public static void toActivity(Activity from, Class<? extends Activity> clz, Bundle data) {
        Intent intent = new Intent(from, clz);
        intent.putExtras(data);
        from.startActivity(intent);
    }

    /**
     * 跳转到指定activity，等于startActivityForResult，带传值
     */
    public static void toActivity(Activity from, Class<? extends BaseActivity> clz, Bundle data, int requestCode) {
        Intent intent = new Intent(from, clz);
        intent.putExtras(data);
        from.startActivityForResult(intent, requestCode);
    }

    /**
     * 跳转到指定activity，等于startActivityForResult
     */
    public static void toActivity(Activity from, Class<? extends Activity> clz, int requestCode) {
        Intent intent = new Intent(from, clz);
        from.startActivityForResult(intent, requestCode);
    }
}
