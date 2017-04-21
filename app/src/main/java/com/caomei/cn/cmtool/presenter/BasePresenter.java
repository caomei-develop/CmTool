package com.caomei.cn.cmtool.presenter;

import com.caomei.cn.cmtool.bean.submit.NewsSubmit;

/**
 * Created by zw on 2017/4/10.
 */
public interface BasePresenter {
    void doGet(String url);
    void dopost(String url , NewsSubmit newsSubmit);//post提交对象到后台
    void dopost(String url , String a ,String s);//post提交对象到后台
    void dopost(String url , String a );//post提交对象到后台
}
