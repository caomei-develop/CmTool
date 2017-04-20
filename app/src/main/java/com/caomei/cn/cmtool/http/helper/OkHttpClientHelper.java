package com.caomei.cn.cmtool.http.helper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by zw on 2017/4/8.
 */
public class OkHttpClientHelper {
//    private final Cache cache;
    private OkHttpClient mClient;
    private final static long TIMEOUT = 10000; //超时时间

    private OkHttpClientHelper(){
//        cache = CacheHelper.getInstance().getCache();
    }
    private static OkHttpClientHelper clientHelper;

    public static OkHttpClientHelper getInstance(){
        if (clientHelper == null){
            synchronized (OkHttpClientHelper.class){
                if (clientHelper == null){
                    clientHelper = new OkHttpClientHelper();
                }
            }
        }
        return clientHelper;
    }

    /**
     *
     * @return获取OKHttpClicent对象
     */
    public OkHttpClient getokHttpClient(){
        if(mClient == null){
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
//                    .cache(cache)      //设置缓存
                    .build();
        }
        return mClient;
    }
}
