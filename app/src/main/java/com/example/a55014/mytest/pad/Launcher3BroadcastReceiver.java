package com.example.a55014.mytest.pad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.a55014.mytest.utils.LogUtil;
import com.innofidei.guardsecure.bean.Location;
import com.innofidei.guardsecure.bean.OutApp;
import com.innofidei.guardsecure.bean.UsageStat;

import java.util.List;

/***********************************************************************************
 *       @Author: guohao
 *         @Date: 2020/6/18 11:45
 *  @Description:
 *         @模块: 领创 广播对接
 *         @功能: 领创日志：LTKLog
 *                                 ZHL Primary Study
 ************************************************************************************/
public class Launcher3BroadcastReceiver extends BroadcastReceiver {

    /**
     * 领创接收到登录成功的广播后，进行用户后台初始化操作结果通知
     */
    public static final String ACTION_INIT_USER_OK = "com.android.launcher3.mdm.INIT_USER_OK";
    /**
     * 领创请求到位置信息返回给第三方 ISV
     */
    public static final String ACTION_RETURN_LOCATION = "com.linspirer.edu.returnlocation";
    /**
     * 领创同步设备已安装应用列表给第三方 ISV
     */
    public static final String ACTION_RETURN_INSTALLED_APPS = "com.linspirer.edu.returninstalledapps";
    /**
     * 领创同步使用时长数据给第三方 ISV 使用
     */
    public static final String ACTION_RETURN_USE_TIME = "com.linspirer.edu.returnusage";
    /**
     * 禁用 back 按键调用结果回执
     */
    public static final String ACTION_RETURN_DISABLE_BACK = "com.linspirer.edu.disableback.receipt";
    /**
     * 启用 Back 键回执
     */
    public static final String ACTION_RETURN_ENABLE_BACK = "com.linspirer.edu.enableback.receipt";
    /**
     * 禁用 home 键功能回执
     */
    public static final String ACTION_RETURN_DISABLE_HOME = "com.linspirer.edu.disablehome.receipt";
    /**
     * 启用 home 键回执
     */
    public static final String ACTION_RETURN_ENABLE_HOME = "com.linspirer.edu.enablehome.receipt";
    /**
     * 禁用 recent 键功能回执
     */
    public static final String ACTION_RETURN_DISABLE_RECENT = "com.linspirer.edu.disablerecent.receipt";
    /**
     * 启用 recent 键功能回执
     */
    public static final String ACTION_RETURN_ENABLE_RECENT = "com.linspirer.edu.enablerecent.receipt";
    /**
     * 禁用 音量 键功能回执
     */
    public static final String ACTION_RETURN_DISABLE_VOLUME = "com.linspirer.edu.disablevolume.receipt";
    /**
     * 启用 音量 键功能回执
     */
    public static final String ACTION_RETURN_ENABLE_VOLUME = "com.linspirer.edu.enablevolume.receipt";
    /**
     * 禁用 电源 键功能回执
     */
    public static final String ACTION_RETURN_DISABLE_POWER = "com.linspirer.edu.disableshortpower.receipt";
    /**
     * 启用 电源 键功能回执
     */
    public static final String ACTION_RETURN_ENABLE_POWER = "com.linspirer.edu.enableshortpower.receipt";

    /**
     * 注销通知接口
     */
    public static final String ACTION_RETURN_UN_LOGOUT = "com.android.launcher3.mdm.LOGOUT";
    public static final String ACTION_TEST = "com.zhl.test";
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.e("接收到 test 广播》》》》》 ：Launcher3BroadcastReceiver" + intent.getAction());
        switch (intent.getAction()) {
            case ACTION_INIT_USER_OK:
                LogUtil.e("接收到【领创】广播》》》》》 ：登录结果：isOk = " + intent.getBooleanExtra("isOK", false));

                break;
            case ACTION_RETURN_LOCATION:
                Location location = intent.getParcelableExtra("location");
                LogUtil.e("接收到【领创】广播》》》》》 ：位置信息：location = " + location.toString());

                break;
            case ACTION_RETURN_INSTALLED_APPS:
                List<OutApp> outAppList = intent.getParcelableArrayListExtra("apps");
                LogUtil.e("接收到【领创】广播》》》》》 ：已安装应用列表：outAppList = " + outAppList);


                break;
            case ACTION_RETURN_USE_TIME:
                List<UsageStat> usageStatList = intent.getParcelableArrayListExtra("usage");
                LogUtil.e("接收到【领创】广播》》》》》 ：使用时长：usageStatList = " + usageStatList);
                break;
            case ACTION_RETURN_DISABLE_BACK:
            case ACTION_RETURN_ENABLE_BACK:
            case ACTION_RETURN_DISABLE_HOME:
            case ACTION_RETURN_ENABLE_HOME:
            case ACTION_RETURN_DISABLE_RECENT:
            case ACTION_RETURN_ENABLE_RECENT:
            case ACTION_RETURN_DISABLE_VOLUME:
            case ACTION_RETURN_ENABLE_VOLUME:
            case ACTION_RETURN_DISABLE_POWER:
            case ACTION_RETURN_ENABLE_POWER:

                LogUtil.e("接收到【领创】广播》》》》》 管控：action = " + intent.getAction() + "\t result=" + intent.getBooleanExtra("result", false));
                break;
            case ACTION_RETURN_UN_LOGOUT: //注销登录
                break;
            default:
                LogUtil.e("接收到【领创】广播》》》》》 智慧流：收到一条未定义的领创广播：" + intent.getAction());
        }
    }
}
