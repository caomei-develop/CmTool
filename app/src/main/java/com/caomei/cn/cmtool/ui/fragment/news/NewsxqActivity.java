package com.caomei.cn.cmtool.ui.fragment.news;

import android.webkit.WebView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseActivity;

public class NewsxqActivity extends BaseActivity {
    private WebView Newswebview;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_newsxq;
    }

    @Override
    protected void init() {
        super.init();
        url = getIntent().getStringExtra( "url" );
        System.out.print(url);
        inirView();
    }

    private void inirView() {
        Newswebview = (WebView) findViewById(R.id.Newswebview);
        Newswebview.loadUrl(url);
    }
}
