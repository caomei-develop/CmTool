package com.caomei.cn.cmtool.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseFragment;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by zw on 2017/4/12.
 */
public class VideoFragment extends BaseFragment{
    private static String TAG = "VideoFragment";

    private static final String VideoURL = "http://www.dingziyy.com/movie/56753.html";

    private TextView mTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.videofragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTitle = (TextView) view.findViewById(R.id.mTitle);
        mTitle.setText("网络视频");
        Spdata(VideoURL);
    }

    private void Spdata(final String videoURL) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection c = Jsoup.connect(videoURL);
                Document doc = null;
                try {
                    doc = c.get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(doc != null){
//                    Element calss = doc.getElementsByClass("menu-wrapper").first();
//                    Elements l = calss.select("li");
//                    System.out.print(l);
//                    for (int i  = 0 ; i < l.size() ; i++){
//                       Vidotitle.title titles = new Vidotitle.title();
//                        Elements a = l.get(i).getElementsByTag("a");
//                        titles.setHref(a.get(i).attr("href"));
                        System.out.print(doc);
//                    }
                }

            }
        }.start();

    }
}
