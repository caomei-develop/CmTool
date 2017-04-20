package com.caomei.cn.cmtool.api;

import com.caomei.cn.cmtool.bean.returns.Abean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zw on 2017/4/10.
 */
public interface Api {
    //接口域名
    String BASEURL = "http://www.rongebang.cn";
    @GET("/toutiao/navs")
    Observable<Abean>Fllist();
}
