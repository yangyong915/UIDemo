package com.example.a55014.mytest.pad;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a55014.mytest.utils.LogUtil;
import com.innofidei.guardsecure.bean.AppDisable;
import com.innofidei.guardsecure.bean.DurationTactics;
import com.innofidei.guardsecure.bean.Worktime;

import java.util.ArrayList;

/***********************************************************************************
 *       @Author: guohao
 *         @Date: 2020/6/18 11:48
 *  @Description:
 *         @模块: 领创广播发送助手, 很多,暂时就先这样
 *         @功能:  领创日志：LTKLog
 *                                 ZHL Primary Study
 ************************************************************************************/
public class Launcher3SendHelper {

    /**
     * 所有的接口通过发广播形式，Android8.0对广播有要求，请在发广播的时候带上我们的包名：com.android.launcher3
     */
    private static final String LAUNCHER3_PACKAGE_NAME = "com.android.launcher3";

    /**
     * 用户登录成功时，第三方登录模块发送登录成功的广播，并在广播intent中带上相关字段  目前不与领创对接登录\注销模块了，后端处理
     *
     * @param context
     * @param userid          用户登录名（必填）
     * @param username        用户显示名称（必填）
     * @param schoolid        学校唯一标识，建议不少于8位（必填）
     * @param classname       班级名称（必填）
     * @param txurl           用户头像url路径（非必填）
     * @param token           用于客户应用单点登录，参考对外接口中的第三方发送ContentProvider，客户可以依据自己系统选择传递密码或者token（非必填）
     * @param useOfflineLogin 是否使用离线模式，true为离线模式，否则在线模式（非必填）
     */
    public static void sendLoginApkFinish(Context context, @NonNull String userid, @NonNull String username, @NonNull String schoolid, @NonNull String classname, @Nullable String txurl, @Nullable String token, @Nullable String useOfflineLogin) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.loginapkfinish");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putExtra("userid", userid);
        intent.putExtra("username", username);
        intent.putExtra("schoolid", schoolid);
        intent.putExtra("classname", classname);
        if (txurl != null) {
            intent.putExtra("txurl", txurl);
        }
        if (token != null) {
            intent.putExtra("token", token);
        }
        if (useOfflineLogin != null) {
            intent.putExtra("useOfflineLogin", useOfflineLogin);
        }
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】登录广播》》》》》schoolid = " + schoolid + "\tuserid=" + userid
                + "\tusername=" + username + "\tclassname=" + classname + "\ttxurl=" + txurl + "\ttoken=" + token
                + "\tuseOfflineLogin=" + useOfflineLogin);
    }
    /**
     * 注销登陆
     */
    public static void sendLoginOut(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.logout");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】注销登陆 广播》》》》");
    }

    /**
     * 禁用 Back 键
     */
    public static void sendLockBack(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disableback");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】禁用 Back 键 广播》》》》");
    }

    /**
     * 启用 Back 键
     */
    public static void sendOpenBack(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.enableback");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】启用 Back 键 广播》》》》");
    }

    /**
     * 禁用 home 键
     */
    public static void sendLockHome(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disablehome");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】禁用 home 键 广播》》》》");
    }

    /**
     * 启用 home 键
     */
    public static void sendOpenHome(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.enablehome");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】启用 home 键 广播》》》》");
    }

    /**
     * 禁用 recent 键
     */
    public static void sendLockRecent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disablerecent");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】禁用 recent 键 广播》》》》");
    }

    /**
     * 启用 recent 键
     */
    public static void sendOpenRecent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.enablerecent");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】启用 recent 键 广播》》》》");
    }

    /**
     * 禁用音量键
     */
    public static void sendLockVolume(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disablevolume");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】禁用音量键 广播》》》》");
    }

    /**
     * 启用音量键
     */
    public static void sendOpenVolume(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.enablevolume");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】启用音量键 广播》》》》");
    }

    /**
     * 禁用电源键
     */
    public static void sendLockPower(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disableshortpower");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】禁用电源键 广播》》》》");
    }

    /**
     * 启用电源键
     */
    public static void sendOpenPower(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.enableshortpower");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】启用电源键 广播》》》》");
    }

    /**
     * ISV 同步位置信息
     */
    public static void obtainLocation(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.obtainlocation");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】ISV 同步位置信息 广播》》》》");
    }

    //第三方应用总是显示在最上方  用户按 home 键，总是需要显示第三方应用的主界面   第三方提供：需要显示的主界面 apk 的包名

    /**
     * Home 键计数器接口
     * 描述：第三方应用由于某些原因设置了 Home 键或者 Back 键隐藏，用户无法很容易的触发按键 或者很难回到桌面。因“领创平板管理
     * ”一系列操作依赖回到桌面的次数，比如 3 次触发获取网址 白名单。提供此接口，由第三方应用实现灵活计数操作，比如用户在回到第
     * 三方应用的主界面时， 可发送此广播
     */
    public static void homeAction(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.homeaction");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】Home 键计数器接口 广播》》》》");
    }

    /**
     * 冻结/解冻应用接口
     * 描述：第三方 isv 同步应用冻结解冻列表接口给领创
     * 参数：使用 intent 传值，键值为”disableapps”，值为一个 List<AppDisable>对象，AppDisable 对象 定义，见对象定义章节
     */
    public static void disableApps(Context context, ArrayList<AppDisable> list) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.disableApps");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putParcelableArrayListExtra("disableapps", list);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】冻结/解冻应用接口 广播》》》》disableapps=" + list);
    }

    /**
     * 应用列表统计接口
     * 描述：第三方 ISV 请求获取设备已经安装的应用列表
     */
    public static void obtaininstalledapps(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.obtaininstalledapps");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】应用列表统计接口 广播》》》》");
    }

    /**
     * 应用使用时长统计接口
     * 描述：第三方 ISV 请求获取设备应用使用时长数据
     */
    public static void obtainusage(Context context, long beginTime, long endTime) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.obtainusage");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putExtra("beginTime",beginTime);
        intent.putExtra("endTime",endTime);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】应用使用时长统计接口 广播》》》》beginTime=" + beginTime +
                "\tendTime=" + endTime);
    }

    /**
     * 设置家长模式
     * 描述：第三方 isv 设置家长模式
     * 参数：使用 intent 传值，键值为”model”，返回值是一个 int 型数据，0：代表设置管控模式，1： 代表设置家长模式
     */
    public static void setcontrolmodel(Context context, int type) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.setcontrolmodel");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putExtra("model",type);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】设置家长/管控模式 广播》》》》type=" + type);
    }

    /**
     * 设置设备使用时长
     * 描述：第三方 ISV 设置设备使用时长，接口为覆盖式接口
     * 参数：使用 intent 传值，键值为”durationtactics”，值为一个 DurationTactics 对象
     */
    public static void durationtactics(Context context, DurationTactics durationtactics) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.durationtactics");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putExtra("durationtactics",durationtactics);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】设置设备使用时长 广播》》》》DurationTactics=" + durationtactics.toString());
    }

    /**
     * 设置设备使用时间段
     * 描述：第三方 ISV 设置设备使用时间段，接口为覆盖式接口
     * 参数：使用 intent 传值，键值为”timetactics”，值为一个 Worktime 对象，Worktime 对象定义， 见对象定义章节
     */
    public static void durationtactics(Context context, Worktime timetactics) {
        Intent intent = new Intent();
        intent.setAction("com.linspirer.edu.timetactics");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        intent.putExtra("timetactics",timetactics);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】置设备使用时间段 广播》》》》Worktime=" + timetactics.toString());
    }

    /**
     * 唤起管理员界面
     *
     * @param context
     */
    public static void openAdmin(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.android.launcher3.mdm.OPEN_ADMIN");
        intent.setPackage(LAUNCHER3_PACKAGE_NAME);
        context.sendBroadcast(intent);
        LogUtil.d("发送了【领创】唤起管理员界面 广播》》》》");
    }

    /**
     * 打开领创应用市场
     *
     * @param context
     */
    public static void openAppStore(Context context) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.ndwill.swd.appstore");
        context.startActivity(intent);
        LogUtil.d("打开【领创】AppStore");
    }

}
