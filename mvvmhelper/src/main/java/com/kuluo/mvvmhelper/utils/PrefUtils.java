package com.kuluo.mvvmhelper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * SharedPreferences 工具
 *
 * @author liucr on 2018/1/26/26.
 */
public class PrefUtils {
    public synchronized static String getStringValue(Context context, String key, String def) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, def);
    }

    public synchronized static void setStringValue(Context context, String key, String val) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(key, val);
        prefEditor.apply();
    }

    public synchronized static int getIntValue(Context context, String key, int def) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key, def);
    }

    public synchronized static void setIntValue(Context context, String key, int val) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(key, val);
        prefEditor.apply();
    }

    public synchronized static void setLongValue(Context context, String key, long val) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putLong(key, val);
        prefEditor.apply();
    }

    public synchronized static long getLongValue(Context context, String key, long def) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(key, def);
    }

    public synchronized static boolean getBooleanValue(Context context, String key, boolean def) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, def);
    }

    public synchronized static void setBooleanValue(Context context, String key, boolean val) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putBoolean(key, val);
        prefEditor.apply();
    }

    public synchronized static void clear(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.clear();
        prefEditor.apply();
    }

    public synchronized static void clear(Context context, Class constantClass, String prefix) {
        clear(context, constantClass, prefix, new String[]{});
    }

    public synchronized static void clear(Context context, Class constantClass, String prefix, String[] excepts) {
        Field[] fields = constantClass.getDeclaredFields();
        if (fields == null || fields.length == 0)
            return;

        Set<String> exceptions = new HashSet<>(Arrays.asList(excepts));

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        for (Field field : fields) {
            if (field.getName().startsWith(prefix) && !exceptions.contains(field.getName()) && field.getType().equals(String.class)) {
                try {
                    prefEditor.remove((String) field.get(context));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        prefEditor.apply();
    }
}
