package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.adapter.NewsViewpager;
import com.caomei.cn.cmtool.adapter.VideoViewpager;
import com.caomei.cn.cmtool.base.BaseFragment;
import com.caomei.cn.cmtool.bean.returns.Video;
import com.caomei.cn.cmtool.ui.fragment.news.AddNewsFragment;
import com.caomei.cn.cmtool.ui.fragment.video.AddVideoFragment;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2017/4/12.
 */
public class VideoFragment extends BaseFragment{
    private static String TAG = "VideoFragment";
    private static final String VideoURL = "http://www.dingziyy.com/movie/56753.html";
    private TextView mTitle;
    private List<Video>list;
    private TabLayout mVideoTabLyout;
    private ViewPager mVideoViewpager;
    private VideoViewpager videoViewpager;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager fManager;
    @Override
    protected int getLayoutId() {
        return R.layout.videofragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setData();
        mTitle = (TextView) view.findViewById(R.id.mTitle);
        mVideoTabLyout  = (TabLayout) view.findViewById(R.id.mSpTabLayout);
        mVideoViewpager = (ViewPager) view.findViewById(R.id.mSpViewpager);
        videoViewpager = new VideoViewpager(getActivity().getSupportFragmentManager(), fragments,list);
        mVideoViewpager.setAdapter(videoViewpager);
        mVideoTabLyout.setupWithViewPager(mVideoViewpager);
        mTitle.setText("网络视频");
        fManager = getChildFragmentManager();
        if (mVideoViewpager != null) {
            setupViewPager();
        }
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new Video("首页","/movie/index.html"));
        list.add(new Video("电影","/movie/list.html"));
        list.add(new Video("电视剧","/tv/list.html"));
        list.add(new Video("热门2","projects-2.html"));
        list.add(new Video("最新","projects-3.html"));
        list.add(new Video("评分","project-details.html"));
    }

    private void setupViewPager() {
        if (list != null){
            for (int i = 0; i < list.size(); i++) {
                mVideoTabLyout.addTab(mVideoTabLyout.newTab());
                fragments.add(AddVideoFragment.newInstance(i,list.get(i).getHref()));
            }
        }
        videoViewpager.notifyDataSetChanged();
    }
}
