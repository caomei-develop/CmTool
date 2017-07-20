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
import com.caomei.cn.cmtool.bean.returns.Picture;

import java.util.List;

/**
 * Created by zw on 2017/4/24.
 */
public class PictureAdapter  extends  RecyclerView.Adapter<PictureAdapter.ViewHolder1>{
    private Context context;
    private List<Picture.Img> listImg;
    private LayoutInflater layoutInflater;

    public PictureAdapter(Context context , List<Picture.Img> listImg){
        this.context = context;
        this.listImg = listImg;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder1(layoutInflater.inflate(R.layout.pictures_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, final int position) {
        holder.titles.setText(listImg.get(position).getAlt());
        Glide.with(context).load(listImg.get(position).getSrc()).centerCrop().into(holder.picture);
        if (listener != null){
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
        return listImg.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView titles;
        public ViewHolder1(View v) {
            super(v);
            picture  = (ImageView) v.findViewById(R.id.imageView);
            titles   = (TextView) v.findViewById(R.id.titletxt);
        }
    }
    private OnitemListener listener;
    public void OnitemListener(OnitemListener listener) {
        this.listener = listener;
    }
}
