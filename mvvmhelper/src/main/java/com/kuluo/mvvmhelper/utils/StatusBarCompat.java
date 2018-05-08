package com.kuluo.mvvmhelper.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 魅族、小米 状态栏文字颜色设置
 *
 * @author liucr on 2018/1/26/26.
 */
public class StatusBarCompat {

    /**
     * 小米状态栏文字颜色设置
     */
    public static void setMiuiStatusBarTextColor(Window window, boolean textColorDark) {
        // MIUI版本样式 V8.5.2.0.MHOCNED 或者 7.7.20
        if (checkMiuiInfo()) {
            setMiuiStatusBarTextColorApi23(window, textColorDark);
        } else {
            setMiuiStatusBarTextColorCompat(window, textColorDark);
        }
    }

    // 需要用到新的状态栏设置方法返回true
    private static boolean checkMiuiInfo() {
        String ver = Build.VERSION.INCREMENTAL;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M || TextUtils.isEmpty(ver)
                || TextUtils.equals(ver, Build.UNKNOWN)) {
            return false;
        }

        if (ver.startsWith("V") || ver.startsWith("v")) {
            ver = ver.substring(1, ver.length());
        }

        String[] split = ver.split("\\.");
        if (split.length < 3) {
            return false;
        }

        if (split.length == 3) {
            return checkMiuiVer(split);
        }

        return checkMiuiVer(new String[]{split[1], split[2], split[3]});
    }

    // MIUI 7.7.13及以后版本返回true
    private static boolean checkMiuiVer(String[] split) {
        if (split.length != 3) return false;

        try {
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);
            int c = Integer.valueOf(split[2]);
            return a >= 7 && (a > 7 || b >= 7 && (b > 7 || c >= 13));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void setMiuiStatusBarTextColorCompat(Window window, boolean textColorDark) {
        Class<? extends Window> clazz = window.getClass();
        try {
            int textColorDarkFlag;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            textColorDarkFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(window, textColorDark ? textColorDarkFlag : 0, textColorDarkFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private static void setMiuiStatusBarTextColorApi23(Window window, boolean textColorDark) {
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (!textColorDark) {
            int flag = window.getDecorView().getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            window.getDecorView().setSystemUiVisibility(flag);
        }
    }

    /**
     * 魅族状态栏文字颜色设置
     */
    public static void setFlymeStatusBarTextColor(Window window, boolean textColorDark) {
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (textColorDark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isMiui() {
        try {
            final BuildProperties prop = BuildProperties.newInstance();
            return prop.getProperty("ro.miui.ui.version.code", null) != null
                    || prop.getProperty("ro.miui.ui.version.name", null) != null
                    || prop.getProperty("ro.miui.internal.storage", null) != null;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isFlyme() {
        try {
            // Invoke Build.hasSmartBar()
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (Exception e) {
            return false;
        }
    }

    private static class BuildProperties {

        private final Properties properties;

        private BuildProperties() throws IOException {
            properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public boolean containsKey(final Object key) {
            return properties.containsKey(key);
        }

        public boolean containsValue(final Object value) {
            return properties.containsValue(value);
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            return properties.entrySet();
        }

        public String getProperty(final String name) {
            return properties.getProperty(name);
        }

        public String getProperty(final String name, final String defaultValue) {
            return properties.getProperty(name, defaultValue);
        }

        public boolean isEmpty() {
            return properties.isEmpty();
        }

        public Enumeration<Object> keys() {
            return properties.keys();
        }

        public Set<Object> keySet() {
            return properties.keySet();
        }

        public int size() {
            return properties.size();
        }

        public Collection<Object> values() {
            return properties.values();
        }

        public static BuildProperties newInstance() throws IOException {
            return new BuildProperties();
        }

    }
}
