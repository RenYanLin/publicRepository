package com.ryl.app;

import android.util.Log;

/**
 * Created by ryl on 2016/11/2.
 */

public class MLog {
    public static final boolean DEBUG = true;
    public static final String TOG = "TOG";
    private MLog() {
    }

    public static void d(String desc) {
        if (DEBUG)
            Log.d(TOG, desc);
    }

    public static void d(String desc, Throwable tr) {
        if (DEBUG)
            Log.d(TOG, desc, tr);
    }

    public static void v(String desc) {
        if (DEBUG)
            Log.v(TOG, desc);
    }
    public static void v(String desc, Throwable tr) {
        if (DEBUG)
            Log.v(TOG, desc);
    }

    public static void w(String desc) {
        if (DEBUG)
            Log.w(TOG, desc);
    }

    public static void w(Throwable ioe) {
        if (DEBUG)
            Log.w(TOG, ioe);
    }

    public static void w(String desc, Throwable e) {
        if (DEBUG)
            Log.w(TOG, desc, e);
    }

    public static void i(String desc) {
        if (DEBUG)
            Log.i(TOG, desc);
    }

    public static void i(String desc, Throwable tr) {
        if (DEBUG)
            Log.i(TOG, desc, tr);
    }

    public static void e(String desc) {
        if (DEBUG)
            Log.e(TOG, desc);
    }

    public static void e(String desc, Throwable tr) {
        if (DEBUG)
            Log.e(TOG, desc, tr);
    }
}
