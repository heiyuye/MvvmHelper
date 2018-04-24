package com.liucr.mvvmhelper.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

/**
 * 可以点击找到Log方法的位置。
 * 必须在 Android studio 2.0 及以上版本才有效。
 *
 * @author liucr on 2018/1/26/26.
 */
public class LogUtil {

    private static boolean debug = true;

    public static void v(String msg) {
        if (debug)
            Log.v(getLogTag(), msg);
    }

    public static void v(String msg, Throwable tr) {
        if (debug)
            Log.v(getLogTag(), msg, tr);
    }


    public static void d(String msg) {
        if (debug)
            Log.d(getLogTag(), msg);
    }

    public static void d(String msg, Throwable tr) {
        if (debug)
            Log.d(getLogTag(), msg, tr);
    }


    public static void i(String msg) {
        if (debug)
            Log.i(getLogTag(), msg);
    }

    public static void i(String msg, Throwable tr) {
        if (debug)
            Log.i(getLogTag(), msg, tr);
    }


    public static void w(String msg) {
        if (debug)
            Log.w(getLogTag(), msg);
    }

    public static void w(String msg, Throwable tr) {
        if (debug)
            Log.w(getLogTag(), msg, tr);
    }

    public static void w(Throwable tr) {
        if (debug)
            Log.w(getLogTag(), tr);
    }


    public static void e(String msg) {
        if (debug)
            Log.e(getLogTag(), msg);
    }

    public static void e(String msg, Throwable tr) {
        if (debug)
            Log.e(getLogTag(), msg, tr);
    }


    public static void throwable(Throwable ex) {
        if (debug) {
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] sts = ex.getStackTrace();
            if (sts != null && sts.length > 0) {
                for (StackTraceElement st : sts) {
                    if (st != null) {
                        sb.append("[ ")
                                .append(st.getFileName()).append(":").append(st.getLineNumber())
                                .append(" ]\r\n");
                    }
                }
            }
            e(sb.toString());
        }
    }

    @NonNull
    private static String getLogTag() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return "";
        }

        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(LogUtil.class.getName())) {
                continue;
            }
            return getCallName(st);
        }
        return "";
    }

    @NonNull
    private static String getCallName(StackTraceElement st) {
        StringBuilder buf = new StringBuilder();

        if (st == null) {
            buf.append("(Null Stack)");
        } else {
            String fName = st.getFileName();

            if (TextUtils.isEmpty(fName)) {
                buf.append("(Unknown Source)");
            } else {
                buf.append('(');
                buf.append(fName);

                int lineNum = st.getLineNumber();
                if (lineNum >= 0) {
                    buf.append(':');
                    buf.append(lineNum);
                }

                buf.append(')');
                buf.append('.');
                buf.append(st.getMethodName());
                buf.append('(');
                buf.append(')');
            }

        }
        return buf.toString();
    }

    public static void setDebug(boolean debug) {
        LogUtil.debug = debug;
    }
}
