package com.caomei.cn.cmtool.presenter;

import android.util.Log;

import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.bean.returns.Newsbean;
import com.caomei.cn.cmtool.bean.submit.NewsSubmit;
import com.caomei.cn.cmtool.http.helper.RetrofitHelper;
import com.caomei.cn.cmtool.http.httputils.HttpUtils;
import com.caomei.cn.cmtool.module.BaseImp;
import com.caomei.cn.cmtool.module.Basemodule;
import com.caomei.cn.cmtool.ui.fragment.news.AddNewsFragment;

import java.util.ArrayList;
import java.util.HashMap;

import rx.Observable;

/**
 * Created by zw on 2017/4/10.
 */
public class MainPresenterImp implements BasePresenter {
    private Basemodule mBasemodule;
    private AddNewsFragment addNewsFragment;
    public MainPresenterImp(AddNewsFragment addNewsFragment){
        mBasemodule = new BaseImp();
        this.addNewsFragment = addNewsFragment;
    }
    @Override
    public void doGet(String url) {
    }
    @Override
    public void dopost(String url, NewsSubmit newsSubmit) {
    }

    @Override
    public void dopost(String url,String a ,String s) {
    }
    @Override
    public void dopost(String url, String a) {
    }

    @Override
    public void dopost(String url, HashMap paramsMap) {
        Observable<Newsbean> observable = RetrofitHelper.getService(url,Api.class).sub(paramsMap);
        HttpUtils.requestNetByPost(observable, new HttpUtils.OnResultListener<Newsbean>() {
            @Override
            public void onSuccess(Newsbean newsbean) {
                if (newsbean != null)
                    addNewsFragment.NewsList(newsbean.reason, (ArrayList<Newsbean.ResultEntity.DataEntity>) newsbean.result.data);

            }
            @Override
            public void onError(Throwable error, String msg) {
                Log.e("error msg",msg);
            }
        });
    }
}
