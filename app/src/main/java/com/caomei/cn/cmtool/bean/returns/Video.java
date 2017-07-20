package com.caomei.cn.cmtool.bean.returns;

import java.util.List;

/**
 * Created by zw on 2017/6/2.
 */

public class Video {
    public String title;
    public String href;

    public Video(String title,String href){
        this.href =href;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
