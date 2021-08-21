package com;

import android.util.Log;

public class Debug {
    public static boolean DEBUG = false;

    private static final String TAG_DEBUG = "DEBUG:";

    public static void log(int content) {
        if (DEBUG)
            try {
                Log.w(TAG_DEBUG, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(String title, String content) {
        if (DEBUG)
            try {
                Log.w(title, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(double content) {
        if (DEBUG)
            try {
                Log.w(TAG_DEBUG, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(float content) {
        if (DEBUG)
            try {
                Log.w(TAG_DEBUG, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(String title, int content) {
        if (DEBUG)
            try {
                Log.w(title, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(String content) {
        if (DEBUG)
            try {
                Log.w(TAG_DEBUG, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void log(String text, float content) {
        if (DEBUG)
            try {
                Log.w(text, TAG_DEBUG + " " + content);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}