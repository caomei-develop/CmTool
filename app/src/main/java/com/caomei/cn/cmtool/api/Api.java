package com.caomei.cn.cmtool.api;

import com.caomei.cn.cmtool.bean.returns.Newsbean;
import com.caomei.cn.cmtool.bean.submit.NewsSubmit;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zw on 2017/4/10.
 */
public interface Api {
    //接口域名
    String URL = "http://v.juhe.cn";
    String key = "7decf052c827876ee7cee76107c4ac07";
    @POST("/toutiao/index?")
    Observable<Newsbean>sub(@Body NewsSubmit newsSubmit);
}
