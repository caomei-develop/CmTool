package com.caomei.cn.cmtool.presenter;

import com.caomei.cn.cmtool.bean.submit.Submit;

/**
 * Created by zw on 2017/4/10.
 */
public interface BasePresenter {
    void doGet(String url);
    void dopost(String url , Submit submit);//post提交对象到后台
}
