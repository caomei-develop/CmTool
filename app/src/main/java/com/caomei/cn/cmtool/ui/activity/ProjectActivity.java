package com.caomei.cn.cmtool.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseActivity;

public class ProjectActivity extends BaseActivity {
    private ViewPager mViewPager;
    private FragmentManager fManager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_project;
    }

    @Override
    protected void init() {
        super.init();
        initview();
        fManager = getSupportFragmentManager();
    }

    private void initview() {
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
    }

}