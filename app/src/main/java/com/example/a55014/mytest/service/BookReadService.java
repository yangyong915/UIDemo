package com.example.a55014.mytest.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.a55014.mytest.R;
import com.example.a55014.mytest.audiosimple.PlayWordsActivity;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * @author yy
 * Create by 2019/9/6 19:15
 * to do 绘本后台播放服务，对播放内容进行控制
 */
public class BookReadService extends Service {
    private final String TAG = BookReadService.class.getSimpleName();
    public static String name="默认";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "开启服务");
        initMedia();

        /**
         * 进程优先级别：前台进程，可视进程，服务进程，后台进程，空进程  （前台进程是最稳定，系统内存不足是先回收 空进程）
         *
         * 为什么要把服务Service提升为前台进程，在内存不足时，前台进程不会那么容易被系统回收
         *
         * 把 服务进程 提升到 前台进程 会自动绑定通知
         */

        // 需要用到通知，用户点击通知栏，就计划APP-->Activity

        // 这是以前到写法，已经过时
        /*Notification notification = new
                Notification(R.mipmap.ic_launcher, "我的音乐播放器", System.currentTimeMillis());*/

        // 设置事件信息，点击通知可以跳转到指定Activity
        Intent intent = new Intent(this, PlayWordsActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);


        // 设置事件信息，点击通知可以跳转到指定Activity
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        // 设置通知显示相关信息
        Notification.Builder builder1 = new Notification.Builder(this);
        builder1.setSmallIcon(R.mipmap.ic_launcher); //设置图标
        /*builder1.setTicker("显示第二个通知");*/
        builder1.setContentTitle("播放中"); //设置标题
        builder1.setContentText("我的音乐播放器"); //消息内容
        builder1.setWhen(System.currentTimeMillis()); //发送时间
        builder1.setDefaults(Notification.DEFAULT_ALL); //设置默认的提示音，振动方式，灯光
        builder1.setAutoCancel(false);//打开程序后图标消失

        // 延时意图，所谓延时意图就是不是马上执行，需要用户去点击后才执行，其实就是对Intent对封装
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder1.setContentIntent(pendingIntent);
        Notification notification1 = builder1.build();
        notificationManager.notify(124, notification1); // 通过通知管理器发送通知

        // id=通知到唯一标示  notification=通知
//        startForeground(1, builder1.getNotification());
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "绑定成功");
        return new PlayMusicBinder();
    }

    private MediaPlayer mediaPlayer;

    private void initMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();//结束服务自己
            }
        });
    }

    /**
     * 增强版Binder，扩展出播放音乐🎵行为
     */
    class PlayMusicBinder extends Binder implements AudioPlayInterface {

        public PlayMusicBinder() {
//            mediaPlayer = new MediaPlayer();
        }

        /**
         * 播放音乐
         *
         * @param musicPath 音乐文件的路径
         */
        @Override
        public void playMusic(FileDescriptor musicPath) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(musicPath);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 暂停播放
         */
        @Override
        public void pausedPlay() {
            mediaPlayer.pause();
        }

        /**
         * 继续播放
         */
        @Override
        public void continuePlay() {
            mediaPlayer.start();
        }

        /**
         * 停止播放
         */
        @Override
        public void stopPlay() {
            mediaPlayer.stop();
        }

        /**
         * 让Activity可以获取到服务使用到MediaPlayer
         *
         * @return
         */
        @Override
        public MediaPlayer getMediaPlayer() {
            return mediaPlayer;
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "退出服务");
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release(); // 释放硬件播放资源
        }
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "解绑成功");

        // 为什么解绑服务了，音乐还在播放，应该MediaPlay内部是一个服务
//        if (mediaPlayer != null) {
//            if (mediaPlayer.isPlaying()) {
//                mediaPlayer.stop();
//            }
//            mediaPlayer.release(); // 释放硬件播放资源
//        }
        return super.onUnbind(intent);
    }
}
