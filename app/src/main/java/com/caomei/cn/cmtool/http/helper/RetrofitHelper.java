package com.caomei.cn.cmtool.http.helper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zw on 2017/4/8.
 */
public class RetrofitHelper {
    private OkHttpClient mClient;
    private Retrofit mRetrofit;

    private RetrofitHelper (){
        mClient = OkHttpClientHelper.getInstance().getokHttpClient();
    }

    private static RetrofitHelper helper;

    //单例 保证对象唯一

    public static RetrofitHelper getInstance(){
        if(helper==null){
            synchronized (RetrofitHelper.class){
                if(helper==null){
                    helper = new RetrofitHelper();
                }
            }
        }
        return helper;
    }

    /**
     *
     * @param url
     * @return 获取Retrofit对象
     */
    public Retrofit getRetrofit(String url){
        if(mRetrofit==null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url + "/")
                    .addConverterFactory(GsonConverterFactory.create())  //添加Gson支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  //添加RxJava支持
                    .client(mClient)                                            //关联okhttp
                    .build();
        }
        return mRetrofit;
    }

    /**
     *
     * @param url
     * @param classz
     * @param <T>
     * @return 获取服务对象
     */
    public static<T> T getService(String url,Class<T> classz){

        return RetrofitHelper.getInstance()
                .getRetrofit(url)
                .create(classz);
    }
}
