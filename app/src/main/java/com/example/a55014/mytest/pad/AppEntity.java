package com.example.a55014.mytest.pad;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * @author yy
 * Create by 2020/9/2 14:26
 * to do
 */
public class AppEntity implements Serializable {
    /**
     * 包名
     */
    public String app_package;
    /**
     * app版本
     */
    public String app_version_name;
    /**
     * app版本号
     */
    public int app_version_code;
    /**
     * 名称
     */
    public String app_name;
    /**
     * icon
     */
    public Drawable app_icon;
    /**
     * 是否是系统app
     */
    public boolean isSystemApp = true;

    @Override
    public String toString() {
        return "AppEntity{" +
                "app_package='" + app_package + '\'' +
                ", app_version_name='" + app_version_name + '\'' +
                ", app_version_code=" + app_version_code +
                ", app_name='" + app_name + '\'' +
                ", app_icon=" + app_icon +
                ", isSystemApp=" + isSystemApp +
                '}';
    }
}
