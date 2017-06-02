package com.caomei.cn.cmtool.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zw on 2017/6/2.
 */

public abstract class BaseFragment extends Fragment{
    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        return view;
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
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra(parame, obj);
        intent.putExtra(parame1, obj1);
        intent.putExtra(parame2, obj2);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }
    public void trans(Class<?> cls, String obj, String parame) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra(parame, obj);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }
    public void trans(Class<?> cls, String obj, String parame, String obj1, String parame1) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra(parame, obj);
        intent.putExtra(parame, obj1);
        startActivity(intent);
//        startActivityForResult(intent,0);
    }

}
