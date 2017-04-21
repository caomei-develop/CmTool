package com.caomei.cn.cmtool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zw on 2017/4/20.
 */
public class NewsViewpager extends FragmentPagerAdapter {
    private  List<Fragment> fragments;
    private  List<String> list;
    public NewsViewpager(FragmentManager fm,List<Fragment> fragments,List<String>list) {
        super(fm);
        this.fragments = fragments;
        this.list = list;
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
