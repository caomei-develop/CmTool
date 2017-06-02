package com.caomei.cn.cmtool.bean.returns;

import java.util.List;

/**
 * Created by zw on 2017/6/2.
 */

public class Vidotitle {
    List<title> list;

    public List<title> getList() {
        return list;
    }

    public void setList(List<title> list) {
        this.list = list;
    }

    public static class title {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
