package com.caomei.cn.cmtool.ui.fragment.news;

import android.os.Bundle;
import android.view.View;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseFragment;
import com.caomei.cn.cmtool.bean.returns.Newsbean;
import com.caomei.cn.cmtool.bean.submit.NewsSubmit;
import com.caomei.cn.cmtool.presenter.BasePresenter;
import com.caomei.cn.cmtool.presenter.MainPresenterImp;
import com.caomei.cn.cmtool.utils.util.ToastUtils;

import java.util.ArrayList;

/**
 * Created by zw on 2017/4/20.
 */
public class AddNewsFragment extends BaseFragment {
    private static final String URL = Api.URL;
    private static final String key = Api.key;
    private String  type;
    private NewsSubmit mNewsSubmit = new NewsSubmit();
    private BasePresenter mBasePresenter;
    public static AddNewsFragment newInstance(int tags, String type) {
        Bundle args = new Bundle();
        //区别不同分类的fragment
        args.putInt("tag", tags);
        args.putString("type",type);
        AddNewsFragment fragment = new AddNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.newsfragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        type = getArguments().getString("type");
        mNewsSubmit.setKey(key);
        mNewsSubmit.setType(type);
        mBasePresenter = new MainPresenterImp(this);
        mBasePresenter.dopost(URL,mNewsSubmit);
    }
    public void NewsList(String reason,ArrayList<Newsbean.ResultEntity.DataEntity> result) {
        if (result !=null){

        }else{
            ToastUtils.show(getActivity(),reason,200);
        }
    }
}