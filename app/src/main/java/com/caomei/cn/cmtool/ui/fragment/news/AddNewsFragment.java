package com.caomei.cn.cmtool.ui.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.caomei.cn.cmtool.Listener.OnitemListener;
import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.adapter.NewsAdapter;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseFragment;
import com.caomei.cn.cmtool.bean.returns.Newsbean;
import com.caomei.cn.cmtool.presenter.BasePresenter;
import com.caomei.cn.cmtool.presenter.MainPresenterImp;
import com.caomei.cn.cmtool.utils.util.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zw on 2017/4/20.
 */
public class AddNewsFragment extends BaseFragment {
    private static final String URL = Api.URL;
    private static final String key = Api.key;
    private String  type;
    private HashMap<String, String> paramsMap = new HashMap<>();
    private BasePresenter mBasePresenter;
    private RecyclerView mNewsRly;
    private NewsAdapter mNewsAdapter;
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
        return R.layout.addnewsfragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        type = getArguments().getString("type");
        paramsMap.put("type",type);
        paramsMap.put("key",key);
        mBasePresenter = new MainPresenterImp(this);
        mBasePresenter.dopost(URL,paramsMap);
        initviews(view);
    }

    private void initviews(View view) {
        mNewsRly = (RecyclerView) view.findViewById(R.id.mNewsRly);
        mNewsRly.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void NewsList(final String reason, final ArrayList<Newsbean.ResultEntity.DataEntity> result) {
        if (result !=null){
            mNewsRly.setAdapter(mNewsAdapter = new NewsAdapter(getActivity(),result));
            mNewsAdapter.OnitemListener(new OnitemListener() {
                @Override
                public void ItemOnClick(View v, int position) {
                    String ulr = result.get(position).url;
                    trans(NewsxqActivity.class,ulr,"url");
                }
            });
        }else{
            ToastUtils.show(getActivity(),reason,200);
        }
    }
}