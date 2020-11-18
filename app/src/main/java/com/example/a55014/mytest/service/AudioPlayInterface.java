package com.example.a55014.mytest.service;

import android.media.MediaPlayer;

import java.io.FileDescriptor;

/**
 * @author yy
 * Create by 2019/9/6 19:20
 * to do
 */
public interface AudioPlayInterface {
    /**
     * 播放音乐
     * @param musicPath 音乐文件的路径
     */
    void playMusic(FileDescriptor musicPath);

    /**
     * 暂停播放
     */
    void pausedPlay();

    /**
     * 继续播放
     */
    void continuePlay();

    /**
     * 停止播放
     */
    void stopPlay();

    /**
     * 让Activity可以获取到服务使用到MediaPlayer
     * @return
     */
    MediaPlayer getMediaPlayer();
}
