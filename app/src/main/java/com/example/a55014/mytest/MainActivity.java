package com.example.a55014.mytest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.ctetin.expandabletextviewlibrary.app.StatusType;
import com.example.a55014.mytest.bottomsheet.PlayBottomSheetDialog;
import com.example.a55014.mytest.expand.ExpandActivity;
import com.example.a55014.mytest.game.GameActivity;
import com.example.a55014.mytest.pad.AppEntity;
import com.example.a55014.mytest.pad.FocusTestActivity;
import com.example.a55014.mytest.pad.Launcher3BroadcastReceiver;
import com.example.a55014.mytest.progress.ProgressActivity;
import com.example.a55014.mytest.refresh.RefreshActivity;
import com.example.a55014.mytest.selectcity.SelectCityActivity;
import com.example.a55014.mytest.shape.ShapeActivity;
import com.example.a55014.mytest.utils.BlurringView;
import com.example.a55014.mytest.utils.DeviceUtils;
import com.example.a55014.mytest.utils.LikeUtil;
import com.example.a55014.mytest.utils.LogUtil;
import com.example.a55014.mytest.water.WaterActivity;
import com.example.a55014.mytest.web.WebActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * crate by yy on 2018-1-18
 * describle:UI特效集合管理器
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.water_tv)
    TextView waterTv;
    @BindView(R.id.expand_tv)
    TextView expandTv;
    @BindView(R.id.progress_tv)
    TextView progressTv;
    @BindView(R.id.refresh_layout)
    TextView refreshLayout;
    @BindView(R.id.tv_agree)
    TextView tvAgree;
    @BindView(R.id.iv_agree)
    ImageView ivAgree;
    @BindView(R.id.iv_blu) ImageView ivBlu;
    @BindView(R.id.blu_view) BlurringView bluView;
    @BindView(R.id.iv_bottom) ImageView ivBottom;
    @BindView(R.id.tv_blur) TextView tvBlur;
    @BindView(R.id.tv_release_app) TextView tvReleaseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceUtils.setCustomDensity(this, getApplication());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        registLauncher3BroadCastReceiver();
        /**
         *   正常的使用
         */
        ExpandableTextView expandableTextView = findViewById(R.id.ep_01);
        //需要显示的内容
//        String yourText = " 我所认识的中国，强大、友好。@奥特曼 “一带一路”经济带带动了沿线国家的经济发展，促进我国与他国的友好往来和贸易发展，可谓“双赢”。http://www.baidu.com 自古以来，中国以和平、友好的面孔示人。汉武帝派张骞出使西域，开辟丝绸之路，增进与西域各国的友好往来。http://www.baidu.com 胡麻、胡豆、香料等食材也随之传入中国，汇集于中华美食。@RNG 漠漠古道，驼铃阵阵，这条路奠定了“一带一路”的基础，让世界认识了中国。";
        String yourText = "Binzhou Medical University is a common medical university at provincial level in Shandong Province，and its predecessor was the Public Medical School of Shandong University originally established in 1946. The university follows its school-running tradition that “teaching comes first, and quality is prior to any others” and that “the education of man is a fundamental, and moral education has the priority”, and puts into practices its university dictum of";
        //将内容设置给控件
        expandableTextView.setContent(yourText);
        //添加展开和收回操作
        expandableTextView.setExpandOrContractClickListener(new ExpandableTextView.OnExpandOrContractClickListener() {
            @Override
            public void onClick(StatusType type) {
                if (type.equals(StatusType.STATUS_CONTRACT)) {
                    Toast.makeText(MainActivity.this, "收回操作", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "展开操作", Toast.LENGTH_SHORT).show();
                }
            }
        });

        LogUtil.e("yy----time:" + getCurrentTimeZero());
//        bluView.setBlurredView(ivBlu);
//        bluView.invalidate();
//        Glide.with(this).load(R.mipmap.pad_app_bottom_bg).transition(new BlurTransformation());
    }

    /**
     * 今天0点的时间戳
     *
     * @return
     */
    public static long getCurrentTimeZero() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    @OnClick({R.id.bottom_dialog, R.id.water_tv, R.id.expand_tv, R.id.progress_tv, R.id.refresh_layout, R.id.shape_layout,
            R.id.web_layout, R.id.select_city, R.id.geogebra_tv, R.id.tv_agree, R.id.tv_game, R.id.tv_blur,
            R.id.tv_release_app, R.id.tv_focus, R.id.tv_start_app})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.water_tv:
                startActivity(new Intent(this, WaterActivity.class));
                break;
            case R.id.expand_tv:
                startActivity(new Intent(this, ExpandActivity.class));
                break;
            case R.id.progress_tv:
                startActivity(new Intent(this, ProgressActivity.class));
                break;
            case R.id.refresh_layout:
                startActivity(new Intent(this, RefreshActivity.class));
                break;
            case R.id.shape_layout:
                startActivity(new Intent(this, ShapeActivity.class));
                break;
            case R.id.web_layout:
                startActivity(new Intent(this, WebActivity.class));
                break;
            case R.id.select_city:
                startActivity(new Intent(this, SelectCityActivity.class));
                break;
            case R.id.bottom_dialog:
                startActivity(new Intent(this, PlayBottomSheetDialog.class));
                break;
            case R.id.geogebra_tv:
                break;
            case R.id.tv_agree:
                ivAgree.setVisibility(View.VISIBLE);
                LikeUtil.loadOneTimeGif(this, R.mipmap.agree, ivAgree, new LikeUtil.GifListener() {
                    @Override
                    public void gifPlayComplete() {
                        ivAgree.setVisibility(View.GONE);
                    }
                });
                break;
            case R.id.tv_game:
                startActivity(new Intent(this, GameActivity.class));
                break;
            case R.id.tv_blur:
                break;
            case R.id.tv_focus:
                startActivity(new Intent(this, FocusTestActivity.class));
                break;
            case R.id.tv_release_app:
                AppEntity entity = getAppInfoByPackage(this, "com.zhl.zjyy.apad");
                LogUtil.d("entity:-----" + entity.toString());
//                ArrayList<AppDisable> list = new ArrayList<>();
//                AppDisable app = new AppDisable();
//                app.setPackageName("com.zhl.zjyy.apad");
//                app.setStatus(1);
//                list.add(app);
//                Launcher3SendHelper.disableApps(this, list);
                break;
            case R.id.tv_start_app:
                //要调用另一个APP的activity所在的包名
                String packageName = "com.zhl.enteacher.tv";
                JumpOpEntity jumpOpEntity = new JumpOpEntity();
                jumpOpEntity.op_type = 4;
                jumpOpEntity.source_id = 7795;
                jumpOpEntity.redirect_url = "https://zhledu.cdn.bcebos.com/ktb/usercourse/a5c89bf2-5cfd-428a-b727-f5e4d3195612";
                String strData = JsonHp.getGsonConverter().toJson(jumpOpEntity); //把对象转成json字符串

                TokenEntity tokenEntity = new TokenEntity();
                tokenEntity.access_token = "dcb589c4f425614ea51ad0f5aa155536715bd94dae80799bc3885ee9f5a7031a";
                tokenEntity.refresh_token = "fb6c964ffd030a6bdfb5bbc2f49a70f1715bd94dae80799bc3885ee9f5a7031a";
                tokenEntity.token_type = "Bearer";
                tokenEntity.expires_in = 2010301405;
                tokenEntity.account = "13531698110";
                String strToken = JsonHp.getGsonConverter().toJson(tokenEntity); //把对象转成json字符串

                openApp(this, packageName,strToken,strData);
                break;
        }
    }

    /**
     * 打开当前APP
     */
    public static void openApp(Context context, String app_package,String strToken,String strData) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(app_package);
            if (intent != null) {
                intent.putExtra("token", strToken);
                intent.putExtra("data", strData);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据包名获取应用信息
     *
     * @param context
     * @param packageName
     * @return
     */
    public static AppEntity getAppInfoByPackage(Context context, String packageName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            AppEntity entity = new AppEntity();
            entity.app_package = packageInfo.packageName;   //app包名
            entity.app_version_name = packageInfo.versionName;  //app的versionName
            entity.app_version_code = packageInfo.versionCode;  //app的versionCode
            entity.app_name = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString(); //app名
            entity.app_icon = packageInfo.applicationInfo.loadIcon(context.getPackageManager());  //app图标

            return entity;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (launcher3BroadcastReceiver != null) {
            unregisterReceiver(launcher3BroadcastReceiver);
        }
    }

    private void registLauncher3BroadCastReceiver() {
        launcher3BroadcastReceiver = new Launcher3BroadcastReceiver();
        IntentFilter filter = new IntentFilter();
//        filter.addAction(Launcher3BroadcastReceiver.ACTION_INIT_USER_OK);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_UN_LOGOUT);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_LOCATION);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_INSTALLED_APPS);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_USE_TIME);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_DISABLE_BACK);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_ENABLE_BACK);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_DISABLE_HOME);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_ENABLE_HOME);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_DISABLE_RECENT);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_ENABLE_RECENT);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_DISABLE_VOLUME);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_ENABLE_VOLUME);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_DISABLE_POWER);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_RETURN_ENABLE_POWER);
        filter.addAction(Launcher3BroadcastReceiver.ACTION_TEST);
        registerReceiver(launcher3BroadcastReceiver, filter);
    }

    /**
     * 领创 管控广播接收器
     **/
    Launcher3BroadcastReceiver launcher3BroadcastReceiver;
}
