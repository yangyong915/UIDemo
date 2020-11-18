package com.example.a55014.mytest.audiosimple;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.service.AudioPlayInterface;
import com.example.a55014.mytest.service.BookReadService;
import com.example.a55014.mytest.utils.DeviceUtils;
import com.example.a55014.mytest.utils.LogUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yy
 * Create by 2019/9/2 16:13
 * to do
 */
public class PlayWordsActivity extends AppCompatActivity {

    @BindView(R.id.tv_context) ScoolerTextView tvContext;
    @BindView(R.id.scroll_view_parent) NestedScrollView scrollViewParent;
    @BindView(R.id.bt_move) Button btMove;
    int dy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        DeviceUtils.setCustomDensity(this, getApplication());
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BookReadService.class);
        startService(intent);
        // 绑定服务
        bindService(intent, connection, BIND_AUTO_CREATE);
        BookReadService.name = "my name is yy";
    }

    private AudioPlayInterface iMusicPlay;

    private ServiceConnection connection = new ServiceConnection() {
        /**
         * 连接到服务
         * @param name
         * @param service
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMusicPlay = (AudioPlayInterface) service;
        }

        /**
         * 断开连接
         * @param name
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解绑服务：注意bindService后 必须要解绑服务，否则会报 连接资源异常
        if (null != connection) {
            unbindService(connection);
        }
    }

    private void initView() {
        if (getIntent() != null) {
            LogUtil.d("getintent ---");
        } else {
            LogUtil.d("getintent ---null");
        }
        Toast.makeText(this, "名字：" + BookReadService.name, Toast.LENGTH_SHORT).show();

        tvContext.setText("我种下一颗种子，1\n" +
                "终于长出了果实\n" +
                "今天是个伟大日子3\n" +
                "摘下星星送给你，\n" +
                "拽下月亮送给你，5\n" +
                "让太阳每天为你升起\n" +
                "变成蜡烛燃烧自己，7\n" +
                "只为照亮你，\n" +
                "把我一切都献给你，9\n" +
                "只要你欢喜\n" +
                "你让我每个明天都11\n" +
                "变得有意义，\n" +
                "生命虽短爱你永远，13\n" +
                "不离不弃\n" +
                "你是我的小呀小苹果儿15\n" +
                " 怎么爱你都不嫌多\n" +
                "红红的小脸儿温暖我的心窝17\n" +
                "  点亮我生命的火  火火火火\n" +
                "你是我的小呀小苹果儿19\n" +
                "  就像天边最美的云朵\n" +
                "春天又来到了花开满山坡21\n" +
                " 种下希望就会收获\n" +
                "从不觉得你讨厌，你的一切都喜欢23\n" +
                "  有你的每天都新鲜\n" +
                "有你阳光更灿烂，25\n" +
                "   你是白云我是蓝天\n" +
                "春天和你漫步在盛开的 花丛间27\n" +
                "夏天夜晚陪你一起看 星星眨眼\n" +
                "秋天黄昏与你徜徉在 金色麦田29\n" +
                "冬天雪花飞舞有你 更加温暖\n" +
                "你是我的小呀小苹果儿31\n" +
                " 怎么爱你都不嫌多\n" +
                "红红的小脸儿温暖我的心窝33\n" +
                "  点亮我生命的火  火火火火\n" +
                "你是我的小呀小苹果儿35\n" +
                "  就像天边最美的云朵\n" +
                "春天又来到了花开满山坡\n" +
                "  种下希望就会收获37\n" +
                "你是我的小呀小苹果儿\n" +
                "   怎么爱你都不嫌多39\n" +
                "红红的小脸儿温暖我的心窝\n" +
                "  点亮我生命的火  火火火火41\n" +
                "你是我的小呀小苹果儿\n" +
                "  就像天边最美的云朵43\n" +
                "春天又来到了花开满山坡\n" +
                "  种下希望就会收获45");
        dy = (int) DeviceUtils.dpToPixel(getApplicationContext(), 20);
        btMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetFileDescriptor fd = null;
                try {
                    fd = getAssets().openFd("words.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                iMusicPlay.playMusic(fd.getFileDescriptor());
                scrollViewParent.fling(dy);
                scrollViewParent.smoothScrollBy(0, dy);
//                tvContext.smoothScrollBy(0, dy);
            }
        });
    }
}
