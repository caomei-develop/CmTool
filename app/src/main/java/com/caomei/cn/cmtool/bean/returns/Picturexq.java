package com.caomei.cn.cmtool.bean.returns;

import java.util.List;

/**
 * Created by zw on 2017/4/25.
 */
public class Picturexq {
    List<TpURL>list;

    public List<TpURL> getList() {
        return list;
    }

    public void setList(List<TpURL> list) {
        this.list = list;
    }

    public static class TpURL {
        private String mTpurl;

        public String getmTpurl() {
            return mTpurl;
        }

        public void setmTpurl(String mTpurl) {
            this.mTpurl = mTpurl;
        }
    }

}
