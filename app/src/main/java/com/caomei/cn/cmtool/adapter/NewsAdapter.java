package com.caomei.cn.cmtool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caomei.cn.cmtool.Listener.OnitemListener;
import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.bean.returns.Newsbean;

import java.util.ArrayList;

/**
 * Created by zw on 2017/4/21.
 */
public class NewsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //
    private final int EMPTY_VIEW = 1;
    private final int PROGRESS_VIEW = 2;
    private final int IMAGE_VIEW = 3;
    //
    private LayoutInflater mLayoutInflater;
    private Context context;
    private ArrayList<Newsbean.ResultEntity.DataEntity>list;

    public NewsAdapter(Context context ,ArrayList<Newsbean.ResultEntity.DataEntity>list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.size() == 0){
            return EMPTY_VIEW;
        } else if(list.get(position).thumbnail_pic_s !=null && list.get(position).thumbnail_pic_s02 != null
                &&list.get(position).thumbnail_pic_s03 != null){
            return IMAGE_VIEW;
        } else if(list.get(position).thumbnail_pic_s != null && list.get(position).thumbnail_pic_s02 != null
                &&list.get(position).thumbnail_pic_s03 == null  ){
            return PROGRESS_VIEW;
        } else if (list.get(position).thumbnail_pic_s !=null && list.get(position).thumbnail_pic_s02 == null
                &&list.get(position).thumbnail_pic_s03 == null ){
            return  EMPTY_VIEW;
        }else{
            return super.getItemViewType(position);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == 1){
            view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            return new ViewHolder1(view);
        } else if(viewType == 2){
            view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.news_item2, parent, false);
            return new ViewHolder2(view);
        } else if(viewType == 3){
            view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.news_item3, parent, false);
            return new ViewHolder3(view);
        } else {
            view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            return new ViewHolder1(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder1){
            ViewHolder1 viewHolder = (ViewHolder1)holder;
            viewHolder.name.setText(list.get(position).title);
            Glide.with(context).load(list.get(position).thumbnail_pic_s).into(viewHolder.picture);
        }else if (holder instanceof  ViewHolder2){
            ViewHolder2 viewHolder = (ViewHolder2)holder;
            viewHolder.name.setText(list.get(position).title);
            Glide.with(context).load(list.get(position).thumbnail_pic_s).into(viewHolder.picture);
            Glide.with(context).load(list.get(position).thumbnail_pic_s02).into(viewHolder.picture1);
        }else if (holder instanceof  ViewHolder3){
            ViewHolder3 viewHolder = (ViewHolder3)holder;
            viewHolder.name.setText(list.get(position).title);
            Glide.with(context).load(list.get(position).thumbnail_pic_s).into(viewHolder.picture);
            Glide.with(context).load(list.get(position).thumbnail_pic_s02).into(viewHolder.picture1);
            Glide.with(context).load(list.get(position).thumbnail_pic_s03).into(viewHolder.picture2);
        }
        if (listener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ItemOnClick(view,position);
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView name;
        public ViewHolder1(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            picture = (ImageView) v.findViewById(R.id.img);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView picture,picture1;
        private TextView name;
        public ViewHolder2(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            picture = (ImageView) v.findViewById(R.id.img);
            picture1 =(ImageView) v.findViewById(R.id.img1);
        }
    }
    public class ViewHolder3 extends RecyclerView.ViewHolder {
        private ImageView picture,picture1,picture2;
        private TextView name;
        public ViewHolder3(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            picture = (ImageView) v.findViewById(R.id.img);
            picture1 =(ImageView) v.findViewById(R.id.img1);
            picture2 =(ImageView) v.findViewById(R.id.img2);
        }
    }
    private OnitemListener listener;
    public void OnitemListener(OnitemListener listener) {
        this.listener = listener;
    }
}
