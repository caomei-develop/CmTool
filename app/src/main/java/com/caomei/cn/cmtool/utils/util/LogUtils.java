package com.caomei.cn.cmtool.utils.util;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by android on 2017/4/1.
 */
public class LogUtils {
    public static int C = 5;
    public static int A = 4;
    public static int O = 3;
    public static int M = 2;
    public static int E = 1;

    private static int CAOMEI = 5;
    private static String ZW_CAOMEIPATH= "/sadcard/cm_caomei.txt";
    private static String TAG = "LogUtils";

    public LogUtils(){}

    public static void initLog(){
        setCAOMEI(CAOMEI);
        setTAG(TAG);
        setZW_caomiePath(ZW_CAOMEIPATH);
    }

    public static void v(String tag, Object msg) throws IOException {
        if (CAOMEI >= C){
            writeFilLog(tag,msg);
            Log.d(tag, String.valueOf(msg));
        }
    }
    public static void d(String tag, Object msg) throws IOException {
        if (CAOMEI >= A){
            writeFilLog(tag,msg);
            Log.d(tag, String.valueOf(msg));
        }
    }
    public static void i(String tag, Object msg) throws IOException {
        if (CAOMEI >= O){
            writeFilLog(tag,msg);
            Log.d(tag, String.valueOf(msg));
        }
    }
    public static void w(String tag, Object msg) throws IOException {
        if (CAOMEI >= M){
            writeFilLog(tag,msg);
            Log.d(tag, String.valueOf(msg));
        }
    }
    public static void e(String tag, Object msg) throws IOException {
        if (CAOMEI >= E){
            writeFilLog(tag,msg);
            Log.d(tag, String.valueOf(msg));
        }
    }
    public static void e(String tag , Throwable e){
        String msg = getTrace(e);
        if (CAOMEI >= E && null != e){
            Log.e(tag,msg);
            e.printStackTrace();
            writeFilLog("aideRRor" + tag,msg);
        }
    }

    private static String getTrace(Throwable e) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        for (Throwable throwable = e.getCause(); throwable != null ; throwable = throwable.getCause()){
            throwable.printStackTrace(printWriter);
        }
        printWriter.close();
        String result = writer.toString();
        return result;
    }

    private static void writeFilLog(String tag, Object msg)  {
        try {
            if (!isHasSDcard()){
                return;
            }
            File e = new File(ZW_CAOMEIPATH);
            if (!e.exists()){
                try {
                    e.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            FileWriter fw = null;
            BufferedWriter bw = null;

            try {
                fw = new FileWriter(ZW_CAOMEIPATH , true);
                bw = new BufferedWriter(fw);
                bw.newLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM_DD hh:mm:ss");
                String time = simpleDateFormat.format(new Date());
                bw.write(time+"##"+tag+"###"+ msg);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if (null != bw){
                try {
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (null != fw){
                try {
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }catch (Throwable throwable){
          e(TAG,throwable);
        }

    }
    public static boolean isHasSDcard(){
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static void setZW_caomiePath(String zwCaomeipath) {
        ZW_CAOMEIPATH = zwCaomeipath;
    }
    private static void setCAOMEI(int caomei) {
        CAOMEI = caomei;
    }
    private static void setTAG(String tag) {
        TAG = tag;
    }

}
