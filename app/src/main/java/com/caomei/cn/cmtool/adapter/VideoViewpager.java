package com.caomei.cn.cmtool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.caomei.cn.cmtool.bean.returns.Video;

/**
 * Created by zhouwei on 17-7-20.
 */

public class VideoViewpager extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private  List<Video> list;
    public VideoViewpager(FragmentManager fm, List<Fragment> fragments, List<Video>list) {
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
        return list.get(position).title;
    }
}
