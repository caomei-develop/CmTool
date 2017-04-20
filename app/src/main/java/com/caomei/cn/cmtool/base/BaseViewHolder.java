package com.caomei.cn.cmtool.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by zw on 2017/4/10.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder{
    private View mConvertView;
    private int mPosition;
    private Context mContext;
    private final SparseArray<View> mViews;

    public BaseViewHolder(Context context,View itemView) {
        super(itemView);
        this.mConvertView = itemView;
        this.mContext = context;
        this.mViews = new SparseArray<>();
    }
    /**
     * 通过控件的Id获取对应的控件，如果没有则加入views
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId){

        View view = mViews.get(viewId);
        if(view==null && mConvertView!=null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseViewHolder setText(int viewId, String text)
    {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置字符串
     * @param viewId
     * @param imageUrl
     */
    public void showImage(int viewId,String imageUrl){
        ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(imageUrl)
                .centerCrop()
                .crossFade()
                .into(view);
    }


}
