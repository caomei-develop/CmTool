package com.caomei.cn.cmtool.bean.returns;

import java.util.List;

/**
 * Created by zw on 2017/4/24.
 */
public class Picture {
    List<Img> list;

    public List<Img> getList() {
        return list;
    }

    public void setList(List<Img> list) {
        this.list = list;
    }

    public static class Img {
        private String href;
        private String src;
        private String alt;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }
    }
}