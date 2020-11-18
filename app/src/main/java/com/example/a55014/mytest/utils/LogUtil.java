package com.example.a55014.mytest.utils;

import android.util.Log;

/**
 * Created by HB on 2017/6/21.
 */

public class LogUtil {

    private static final String TAG = "TAG_H";
    private static Boolean DEBUG_TRUE = true;
    private static boolean LOGV = DEBUG_TRUE;
    private static boolean LOGD = DEBUG_TRUE;
    private static boolean LOGI = DEBUG_TRUE;
    private static boolean LOGW = DEBUG_TRUE;
    private static boolean LOGE = DEBUG_TRUE;

    public static void v(String tag, String mess) {
        if (LOGV) {
            Log.v(tag, mess);
        }
    }

    public static void d(String tag, String mess) {
        if (LOGD) {
            Log.d(tag, mess);
        }
    }

    public static void d(String mess) {
        if (LOGD) {
            Log.d(TAG, mess);
        }
    }

    public static void i(String tag, String mess) {
        if (LOGI) {
            Log.i(tag, mess);
        }
    }

    public static void w(String tag, String mess) {
        if (LOGW) {
            Log.w(tag, mess);
        }
    }

    public static void e(String tag, String mess) {
        if (LOGE) {
            Log.e(tag, mess);
        }
    }

    public static void e( String mess) {
        if (LOGE) {
            Log.e(TAG, mess);
        }
    }
}
