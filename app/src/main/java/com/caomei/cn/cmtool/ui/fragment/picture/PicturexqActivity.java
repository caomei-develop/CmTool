package com.caomei.cn.cmtool.ui.fragment.picture;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseActivity;
import com.caomei.cn.cmtool.bean.returns.Picturexq;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PicturexqActivity extends BaseActivity {
    private String PicturexqURL;
    private List<Picturexq.TpURL> mTpURLlist = new ArrayList<>();
    private static final String TpxqURL = Api.PiUrl;
    //
    private int curIndex;
    private String imgurl;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_picturexq;
    }

    @Override
    protected void init() {
        super.init();
        PicturexqURL = getIntent().getStringExtra( "Picturexq" );
        TpXq(PicturexqURL);
    }

    private void TpXq(final String picturexqURL) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Connection c = Jsoup.connect(picturexqURL);
                Document doc = null;
                try {
                    doc = c.get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (doc != null){
                    Element id = doc.getElementById("big-pic");
                    if (id !=null){
                        Elements a = id.getElementsByTag("a");
                        if (a !=null){
                            Elements img = a.select("img");
                            String imgs = img.attr("src");
                            System.out.print(imgs);
                            Picturexq.TpURL mTpURL = new Picturexq.TpURL();
                            mTpURL.setmTpurl(imgs);
                            mTpURLlist.add(mTpURL);
                        }
                    }
                    //下一页 图片地址
                    Elements pages = doc.getElementsByClass("pages");
                    Elements li = pages.select("li");
                    for (int i = 3; i < li.size() ; i++){
                        Elements pa =li.get(i).select("a");
                        imgurl = pa.attr("href");
                    }
                }
            }
        }.start();
    }


}
