package com.caomei.cn.cmtool.presenter;

import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.bean.returns.Abean;
import com.caomei.cn.cmtool.bean.submit.Submit;
import com.caomei.cn.cmtool.http.helper.RetrofitHelper;
import com.caomei.cn.cmtool.http.httputils.HttpUtils;
import com.caomei.cn.cmtool.module.BaseImp;
import com.caomei.cn.cmtool.module.Basemodule;
import com.caomei.cn.cmtool.ui.activity.MainActivity;

import rx.Observable;

/**
 * Created by zw on 2017/4/10.
 */
public class MainPresenterImp implements BasePresenter {
    private Basemodule mBasemodule;
    private MainActivity activity;
    public MainPresenterImp(MainActivity activity){
        mBasemodule = new BaseImp();
        this.activity = activity;
    }
    @Override
    public void doGet(String url) {
        Observable<Abean> observable = RetrofitHelper.getService(url,Api.class).Fllist();
        HttpUtils.requestNetByGet(observable, new HttpUtils.OnResultListener<Abean>() {
            @Override
            public void onSuccess(Abean abean) {
                if (abean != null){
                    activity.getFlList(abean.status,abean.fl_list);
                }
            }
            @Override
            public void onError(Throwable error, String msg) {

            }
        });

    }

    @Override
    public void dopost(String url, Submit submit) {

    }
}
