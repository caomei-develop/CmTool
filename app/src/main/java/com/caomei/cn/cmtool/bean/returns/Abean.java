package com.caomei.cn.cmtool.bean.returns;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by zw on 2017/4/10.
 */
public class Abean {

    @SerializedName("status")
    public int status;
    @SerializedName("fl_list")
    public ArrayList<FlListEntity> fl_list;
    @SerializedName("flall_list")
    public ArrayList<FlallListEntity> flall_list;
    public static class FlListEntity {
        @SerializedName("id")
        public int id;
        @SerializedName("pid")
        public String pid;
        @SerializedName("name")
        public String name;
        @SerializedName("type")
        public String type;
    }
    public static class FlallListEntity {
        @SerializedName("id")
        public String id;
        @SerializedName("pid")
        public String pid;
        @SerializedName("name")
        public String name;
        @SerializedName("tpe")
        public String type;
    }
}
