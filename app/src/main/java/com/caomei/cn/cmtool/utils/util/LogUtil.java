package com.caomei.cn.cmtool.utils.util;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import com.caomei.cn.cmtool.app.CmApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {
	
	/**
	 * if false, no log is print
	 */
	public static boolean isLog;
	
	private static String TAG = "caomei_tag";
	
	/** ****************** tag = caolei_tag ***************************** */
	
	public static void v(String msg){
		v(TAG, msg);
	}
	
	public static void d(String msg){
		d(TAG, msg);
	}
	
	public static void i(String msg){
		i(TAG, msg);
	}
	
	public static void e(String msg){
		e(TAG, msg);
	}
	
	public static void w(String msg){
		w(TAG, msg);
	}
	
	/** ****************** tag = caolei_tag + class.getName() ***************************** */
	
	public static void v(Object obj, String msg){
		v(obj.getClass().getSimpleName(), msg);
	}
	
	public static void d(Object obj, String msg){
		d(obj.getClass().getSimpleName(), msg);
	}
	
	public static void i(Object obj, String msg){
		i(obj.getClass().getSimpleName(), msg);
	}
	
	public static void e(Object obj,String msg){
		e(obj.getClass().getSimpleName(), msg);
	}
	
	public static void w(Object obj,String msg){
		w(obj.getClass().getSimpleName(), msg);
	}
	
	/** ****************** tag = custom tag ***************************** */
	
	public static void v(String tag, String msg){
		if (isLog) Log.v(TAG + "_" + tag, msg);
	}
	
	public static void d(String tag, String msg){
		if (isLog) Log.d(TAG + "_" + tag, msg);
	}
	
	public static void i(String tag, String msg){
		if (isLog) Log.i(TAG + "_" + tag, msg);
	}
	
	public static void e(String tag, String msg){
		if (isLog) Log.e(TAG + "_" + tag, msg);
	}
	
	public static void w(String tag, String msg){
		if (isLog) Log.w(TAG + "_" + tag, msg);
	}
	
	/** ****************** tag = custom tag 打印之后保存到SD卡上，根据日志分析APP存在问题 ***************************** */
	
	public static void vSave(String tag, String log) {
		v(tag, log);
		saveLog(log);
	}
	
	public static void dSave(String tag, String log) {
		d(tag, log);
		saveLog(log);
	}
	
	public static void iSave(String tag, String log) {
		i(tag, log);
		saveLog(log);
	}
	
	public static void eSave(String tag, String log) {
		e(tag, log);
		saveLog(log);
	}
	
	public static void wSave(String tag, String log) {
		w(tag, log);
		saveLog(log);
	}
	
	private static String log_path;
	private static File file = null;
	
	/**
	 * 初始化日志文件
	 */
	private static void initLogFile() {
		try {
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				log_path = Environment.getExternalStorageDirectory() + "/" + CmApplication.getContext().getPackageName();
				file = new File(log_path + "/wtb_log.txt");
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				if (!file.exists()) {
					file.createNewFile();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressLint("SimpleDateFormat")
	public static void saveLog(String log) {
		initLogFile();
		BufferedWriter out = null;
		try {
			if (file == null || !file.exists()) {
				return;
			}
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"), 8000);
			StringBuffer sb = new StringBuffer();

			// 操作时间
			sb.append(new SimpleDateFormat("HH:mm:ss").format(new Date())).append("\r\n");
			// 线程id
//			sb.append("thread Id: ").append(Thread.currentThread().getId()).append("\t");
			// 当前对象
			sb.append(log);
			sb.append("\r\n").append("\r\n");
			out.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}
