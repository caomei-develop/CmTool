package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.caomei.cn.cmtool.Listener.OnitemListener;
import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.adapter.PictureAdapter;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseFragment;
import com.caomei.cn.cmtool.bean.returns.Picture;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2017/4/12.
 */
public class PicturesFragment extends BaseFragment{
    private RecyclerView TpRv;
    private static final String Tpurl = Api.PiUrl;//jsoup爬虫接口
    private PictureAdapter mPictureAdapter;
    private List<Picture.Img> list = new ArrayList<Picture.Img>();
    private GridLayoutManager mGridLayoutManager;
    private String page;//下页数据
    private boolean mFresh = false;//是否请求下一页
    private TextView mTitle;
    private String Picturexq;
    @Override
    protected int getLayoutId() {
        return R.layout.picturesfragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTitle = (TextView) view.findViewById(R.id.mTitle);
        mTitle.setText("网络唯美图片");
        TpRv = (RecyclerView) view.findViewById(R.id.TpRv);
        TpRv.setLayoutManager(mGridLayoutManager = new GridLayoutManager(getActivity(),2));
        TpRv.addOnScrollListener(mOnScrollListener);
        TpRv.setAdapter(mPictureAdapter = new PictureAdapter(getActivity(),list));
        mPictureAdapter.OnitemListener(new OnitemListener() {
            @Override
            public void ItemOnClick(View v, int position) {
//                trans(PicturexqActivity.class,Picturexq,"Picturexq");
            }
        });
        Tpdata(Tpurl);
    }

    private void Tpdata(final String tpurl) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection c = Jsoup.connect(tpurl);
                Document doc = null;
                try {
                    doc = c.get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (doc != null) {
                    //获取下一页数据
                    Element pageNum = doc.getElementById("pageNum");
                    if (pageNum != null){
                        Elements as = pageNum.select("a");
                        int size = as.size()-1;
                        if (as != null){
                            for (int i = 2 ; i < size ; i++){
                                page = as.get(i).attr("href");
                            }
                        }
                    }
                    Element id = doc.getElementById("infinite_scroll");
                    if (id != null){
                        Elements div = id.getElementsByClass("ABox");
                        if (div != null){
                            for (int i =0 ; i < div.size() ; i++){
                                Elements a = div.get(i).getElementsByTag("a");
                                String href = a.attr("href");
                                Picturexq= href;
                                for (int j = 0; j < a.size() ; j++){
                                    Elements img = a.get(j).getElementsByTag("img");
                                    String src  = img.get(j).attr("src");
                                    String alt  = img.get(j).attr("alt");
                                    System.out.print("查看地址"+href+"图片链接"+src+"标题"+alt);
                                    Picture.Img Img = new Picture.Img();
                                    Img.setAlt(alt);
                                    Img.setHref(href);
                                    Img.setSrc(src);
                                    list.add(Img);
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            mPictureAdapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            }
        }.start();
    }


    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        private int position;
        private boolean refreshTag = true;
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            position = mGridLayoutManager.findLastVisibleItemPosition();
            if (dy > 0) {
                refreshTag = false;
            } else {
                refreshTag = true;
            }
        }
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (!refreshTag && newState == RecyclerView.SCROLL_STATE_IDLE && position + 1 == mPictureAdapter.getItemCount()) {
                mFresh = true;
                String pageurl = "http://www.mmonly.cc/"+page;
                Tpdata(pageurl);
            }
        }
    };
}
