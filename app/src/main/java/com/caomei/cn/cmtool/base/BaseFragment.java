package com.caomei.cn.cmtool.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zw on 2017/4/12.
 */
public abstract class BaseFragment extends Fragment{
    private BaseActivity mActivity;
    //布局文件ID
    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);
    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }


    /**
     *
     * @param cls
     * @param obj
     * @param parame
     * 此操作是跳转传值
     */
    public void trans(Class<?> cls, String obj, String parame) {
        try {
            Intent intent = new Intent(getActivity(), cls);
            intent.putExtra(parame, obj);
            startActivity(intent);
        } catch (Exception e) {
        }
    }
    public void trans(Class<?> cls , String obj, String parame,String obj1,String parame1 ){
        try {
            Intent intent = new Intent(getActivity(), cls);
            intent.putExtra(parame, obj);
            intent.putExtra(parame1, obj1);
            startActivity(intent);
        } catch (Exception e) {
        }
    }
    public void trans(Class<?> cls , String obj, String parame,String obj1,String parame1,String obj2 ,String parame2){
        try {
            Intent intent = new Intent(getActivity(), cls);
            intent.putExtra(parame, obj);
            intent.putExtra(parame1, obj1);
            intent.putExtra(parame2, obj2);
            startActivity(intent);
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        return view;
    }

}
