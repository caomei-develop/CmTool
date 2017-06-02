package com.caomei.cn.cmtool.view.baseview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.utils.util.DimenUtil;

/**
 * Created by zw on 2017/6/2.
 */

public class LoginPop extends PopupWindow {
    public LoginPop(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.login_pop, null);

        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        ColorDrawable drawable = new ColorDrawable();
        drawable.setColor(0xb0000000);
        setBackgroundDrawable(drawable);


        int windowWidth = DimenUtil.getWindowWidth((Activity) context);
        int windowHeight = DimenUtil.getWindowHeight((Activity) context);
        int statusBarHeight = DimenUtil.getStatusBarHeight(context);
        int actionBarHeight = DimenUtil.dip2px(context, 50);
        int tabBarHeight = DimenUtil.dip2px(context, 48);

        view.setMinimumWidth(windowWidth);
        view.setMinimumHeight(windowHeight - statusBarHeight - actionBarHeight - tabBarHeight);

        setAnimationStyle(0);
    }

    private View.OnClickListener mBtnOnClickListener;

    public void setBtnOnClickListener(View.OnClickListener listener) {
        mBtnOnClickListener = listener;
    }

    private void onClick(View view) {
        if (mBtnOnClickListener != null) {
            mBtnOnClickListener.onClick(view);
        }
    }
}
