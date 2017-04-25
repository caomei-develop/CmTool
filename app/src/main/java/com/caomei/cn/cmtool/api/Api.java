package com.caomei.cn.cmtool.api;

import com.caomei.cn.cmtool.bean.returns.Newsbean;

import java.util.HashMap;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zw on 2017/4/10.
 */
public interface Api {
    //接口域名
    String URL = "http://v.juhe.cn";
    String PiUrl = "http://www.mmonly.cc/mmtp/qcmn/";
    String key = "7decf052c827876ee7cee76107c4ac07";
    @POST("/toutiao/index")
    @FormUrlEncoded
    Observable<Newsbean>sub(@FieldMap HashMap<String, String> paramsMap );
}
