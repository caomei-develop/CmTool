package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseFragment;

/**
 * Created by zw on 2017/4/12.
 */
public class ProJectFragment extends BaseFragment{
    public static ProJectFragment newInstance(int type) {
        Bundle args = new Bundle();
        //区别不同分类的fragment
        args.putInt("type", type);
        ProJectFragment fragment = new ProJectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private TextView texts;
    @Override
    protected int getLayoutId() {
        return R.layout.projectfragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        texts = (TextView) view.findViewById(R.id.texts);
        texts.setText(getArguments().getInt("type"));

    }
}
