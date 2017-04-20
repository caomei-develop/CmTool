package com.caomei.cn.cmtool.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caomei.cn.cmtool.Listener.BaseAdapterListener;
import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.bean.returns.Abean;
import com.caomei.cn.cmtool.view.CircleImageView;

import java.util.List;

/**
 * Created by zw on 2017/4/10.
 */
public class Aadapter extends RecyclerView.Adapter<Aadapter.AViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<Abean.FlListEntity> FlList;
    public Aadapter(Context context,List<Abean.FlListEntity> FlList){
        this.context = context;
        this.FlList = FlList;
        this.mLayoutInflater= LayoutInflater.from(context);
    }
    @Override
    public AViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AViewHolder(mLayoutInflater.inflate(R.layout.aitem, parent, false));
    }

    @Override
    public void onBindViewHolder(AViewHolder holder, final int position) {
        if (mListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.ItemOnClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public AViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            img = (CircleImageView) v.findViewById(R.id.img);
            ObjectAnimator rot = ObjectAnimator.ofFloat(img, "rotation", 0, 360);
            rot.setDuration(3000);
            rot.setRepeatCount(-1);
            rot.start();
        }
    }
    private BaseAdapterListener mListener;
    public void setListener(BaseAdapterListener mListener) {
        this.mListener = mListener;
    }
}
