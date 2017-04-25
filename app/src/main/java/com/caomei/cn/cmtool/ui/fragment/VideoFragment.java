package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseFragment;

/**
 * Created by zw on 2017/4/12.
 */
public class VideoFragment extends BaseFragment{
    private TextView mTitle;
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
        return R.layout.videofragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTitle = (TextView) view.findViewById(R.id.mTitle);
        mTitle.setText("网络视频");

    }
}
