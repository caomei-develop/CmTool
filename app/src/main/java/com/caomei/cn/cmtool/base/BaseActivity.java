package com.caomei.cn.cmtool.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.caomei.cn.cmtool.app.CmApplication;

/**
 * Created by zw on 2017/4/10.
 */
public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG = BaseActivity.class.getSimpleName();
    //layout布局id
    protected abstract int getLayoutId();
    //布局中Fragment的ID
//    protected abstract int getFragmentContentId();
    private long exitTime = 0;//点击两退出

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CmApplication.getAppManager().addActivity(this);
        init();

    }
    protected void init() {
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
    }
    /**
     *
     * @param cls
     * @param obj
     * @param parame
     * @param obj1
     * @param parame1
     * @param obj2
     * @param parame2
     */
    public void trans(Class<?> cls, String obj, String parame, String obj1, String parame1, String obj2, String parame2) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(parame, obj);
        intent.putExtra(parame1, obj1);
        intent.putExtra(parame2, obj2);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }
    public void trans(Class<?> cls, String obj, String parame) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(parame, obj);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }
    public void trans(Class<?> cls, String obj, String parame, String obj1, String parame1) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(parame, obj);
        intent.putExtra(parame, obj1);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }
    //返回鍵监听
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if ((System.currentTimeMillis() - exitTime) > 2000) {
//                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                CmApplication.getAppManager().finishAllActivity();
//                CmApplication.getAppManager().AppExit();
//                System.exit(0);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}