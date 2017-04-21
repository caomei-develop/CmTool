package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.adapter.NewsViewpager;
import com.caomei.cn.cmtool.base.BaseFragment;
import com.caomei.cn.cmtool.ui.fragment.news.AddNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2017/4/12.
 */
public class NewsFragment extends BaseFragment{
    private TabLayout mXwTabLyout;
    private ViewPager mXwViewpager;
    //
    private NewsViewpager mNewsViewpager;
    private FragmentManager fManager;
    //
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> type = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.newsfragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mXwTabLyout  = (TabLayout) view.findViewById(R.id.mXwTabLayout);
        mXwViewpager = (ViewPager) view.findViewById(R.id.mXwViewpager);
        mNewsViewpager = new NewsViewpager(getActivity().getSupportFragmentManager(), fragments,title);
        mXwViewpager.setAdapter(mNewsViewpager);
        mXwTabLyout.setupWithViewPager(mXwViewpager);
        getTitle();
        getType();
        fManager = getChildFragmentManager();
        if (mXwViewpager != null) {
            setupViewPager();
        }
    }

    private void getType() {
        type.add("top");
        type.add("shehui");
        type.add("guonei");
        type.add("guoji");
        type.add("yule");
        type.add("tiyu");
        type.add("keji");
        type.add("caijing");
        type.add("shishang");
    }

    private void getTitle() {
        //"头条", "社会", "国内", "娱乐", "体育", "军事","科技", "财经", "时尚"
        title.add("头条");
        title.add("社会");
        title.add("国内");
        title.add("娱乐");
        title.add("军事");
        title.add("军事");
        title.add("科技");
        title.add("财经");
        title.add("时尚");
    }

    private void setupViewPager() {
        if (title != null){
            for (int i = 0; i < title.size(); i++) {
                mXwTabLyout.addTab(mXwTabLyout.newTab());
                fragments.add(AddNewsFragment.newInstance(i,type.get(i)));
            }
        }
        mNewsViewpager.notifyDataSetChanged();
    }
}
