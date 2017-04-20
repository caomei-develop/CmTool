package com.caomei.cn.cmtool.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zw on 2017/4/10.
 */
public abstract class BaseAdapter <T> extends RecyclerView.Adapter<BaseViewHolder>{
    protected Context mContext;
    protected List<T> mDatas;
    protected View mView;
    private BaseViewHolder viewHolder;
    public BaseAdapter(Context context){
        this.mContext = context;
    }
    public BaseAdapter(Context context, List<T> datas){
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = initView();
        viewHolder = new BaseViewHolder(mContext,mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        setData(holder,position);
    }

    @Override
    public int getItemCount() {
        return  mDatas!=null && mDatas.size()>0 ? mDatas.size() : 0;
    }
    public BaseViewHolder getViewHolder() {
        return viewHolder;
    }

    public abstract View initView();

    public abstract void setData(BaseViewHolder holder, int position);
}
