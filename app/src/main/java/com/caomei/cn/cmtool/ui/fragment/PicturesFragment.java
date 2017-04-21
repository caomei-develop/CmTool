package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseFragment;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by zw on 2017/4/12.
 */
public class PicturesFragment extends BaseFragment{
//    public static NewsFragment newInstance(int type) {
//        Bundle args = new Bundle();
//        //区别不同分类的fragment
//        args.putInt("type", type);
//        NewsFragment fragment = new NewsFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    private static final String Tpurl = Api.PiUrl;//jsoup爬虫接口

    @Override
    protected int getLayoutId() {
        return R.layout.newsfragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Tpdata();
    }

    private void Tpdata() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection c = Jsoup.connect(Tpurl);
                Document doc = null;
                try {
                    doc = c.get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (doc != null){
                    Elements eles=doc.getElementsByTag("a");
                    for(Element e :eles) {

                    }

                }
            }
        }.start();

    }
}
