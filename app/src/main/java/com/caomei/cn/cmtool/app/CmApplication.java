package com.caomei.cn.cmtool.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Stack;

/**
 * Created by zw on 2017/4/10.
 */
public class CmApplication extends Application{
    private static final String TAG = CmApplication.class.getName();
    private static Stack<Activity> activityStack;
    private static CmApplication instance;
    private CmApplication(){}
    //单一实例
    public static CmApplication getAppManager(){
        if (instance == null){
            instance = new CmApplication();
        }
        return instance;
    }
    public static Context getContext(){
        return instance;
    }
    /**
     * 添加activity到堆栈
     */
    public void getSize(String name){
        System.out.print("=====" + name + "倔强的小草莓丶"+activityStack.size());
    }
    public void addActivity(Activity activity){
        if (activityStack == null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }
    /**
     * 获取当前activity
     */
    public Activity currentActivity(){
        Activity activity = activityStack.lastElement();
        return activity;
    }
    /**
     * 结束当前activity(堆栈中最后一个压入的)
     */
    public void finishActivity(){
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    private void finishActivity(Activity activity) {
        if (activity != null){
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    /**
     * 结束指定的activity
     */
    public void finishActivity(Class<?> cls){
        Stack<Activity> activities = new Stack<>();
        for (Activity activity : activities){
            if (activity.getClass().equals(cls)){
                activities.add(activity);
            }
        }
        for (Activity activity :activities){
            finishActivity(activity);
        }
    }
    /**
     * 结束所有activity
     */
    public void finishAllActivity(){
        for (int i = 0 ,size = activityStack.size(); i <size ;i++ ){
            if (null != activityStack.get(i)){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(){
        finishActivityTwo();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
    private void finishActivityTwo() {
        for (int i = 0 ; i < activityStack.size() ; i++){
            if (activityStack.get(i) != null){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
}