package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseFragment;

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

    @Override
    protected int getLayoutId() {
        return R.layout.newsfragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
