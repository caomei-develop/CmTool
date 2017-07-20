package com.caomei.cn.cmtool.ui.fragment.video;

import android.os.Bundle;
import android.view.View;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseFragment;

/**
 * Created by zhouwei on 17-7-20.
 */

public class AddVideoFragment extends BaseFragment {
    public static AddVideoFragment newInstance(int tags, String href) {
        Bundle args = new Bundle();
        //区别不同分类的fragment
        args.putInt("tag", tags);
        args.putString("href",href);
        AddVideoFragment fragment = new AddVideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        String href =  getArguments().getString("href");
        System.out.print(href);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_video_fragment;
    }
}
