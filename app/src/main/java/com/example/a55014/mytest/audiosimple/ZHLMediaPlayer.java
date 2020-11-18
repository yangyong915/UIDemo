package com.example.a55014.mytest.audiosimple;

/**
 * 用于更换视频播放器
 * Created by HB on 2017/8/11.
 */

public interface ZHLMediaPlayer {

    /**
     * 设置状态改变调用方法
     *
     * @param changeInterface
     * @author zjh
     * @createTime 2015-10-28 下午4:57:40
     */
     void setChangeInterface(MediaStateChangeInterface changeInterface);

    /**
     * 释放mediaPlayer资源 和回调接口(回调接口不释放的话会一直持有对象)
     *
     * @author zjh
     * @createTime 2015-10-28 下午2:49:31
     */
    void release();

    /**
     * 暂停操作
     *
     * @author zjh
     * @createTime 2015-10-28 下午2:49:53
     */
    void pause();

    /**
     * 继续播放
     *
     * @author zjh
     * @createTime 2015-10-28 下午2:50:04
     */
    void resume();

    /**
     * 停止播放
     *
     * @author zjh
     * @createTime 2015-10-28 下午7:54:09
     */
    public void stop();

    /**
     * 播放操作
     *
     * @param path
     * @author zjh
     * @createTime 2015-10-28 下午2:51:16
     */
    void playSound(String path, final MediafinishedInterface finishCallBack);

    /**
     * 播放操作
     *
     * @param path
     * @author zjh
     * @createTime 2015-10-28 下午2:51:16
     */
    void playSound(String path, int duration, final MediafinishedInterface finishCallBack);

    void setErrorListener();

    /**
     * 播放网络音频
     *
     * @param url
     * @param finishCallBack
     * @param duration 网络音频时长
     * @author zjh
     * @createTime 2015-11-21 下午5:15:48
     */
    void playURLSound(String url, final MediafinishedInterface finishCallBack, int duration);


    /**
     * 重新播放当前音频
     *
     * @author zjh
     * @createTime 2015-11-3 下午7:49:02
     */
    public void restart();

    /**
     * 重设mediaPlayer
     *
     * @author zjh
     * @createTime 2015-11-3 下午7:50:47
     */
    void reset();

    /**
     * 获取总时间 没有返回-1
     *
     * @return
     * @author zjh
     * @createTime 2015-11-2 上午10:29:22
     */
    int getDuration();

    /**
     * 获取播放状态
     */
    boolean isPlaying();

    /**
     * 获取当前音频的状态
     *
     * @return
     * @author zjh
     * @createTime 2015-11-4 上午9:58:03
     */
    MediaState getMediaState();

    /**
     * 获取播放的时长
     *
     * @return
     * @author zjh
     * @createTime 2015-11-3 下午9:13:34
     */
    int getCurrentDuration();

    void seekTo(int duration);

    /**
     * 变速
     *
     * @param speed
     */
    void setSonicSpeed(float speed);

    /** 媒体状态枚举 */
    enum MediaState {
        /** 正在播放 */
        MEDIA_STARTED,
        /** 暂停 */
        MEDIA_PAUSED,
        /** 停止 */
        MEDIA_STOPED,
        /** 结束 */
        MEDIA_FINISHED,
        /** 准备 */
        MEDIA_PREPARED,
        /** 初始化状态 */
        MEDIA_IDE
    }

    /**
     * 状态改变回调接口
     *
     * @author zjh
     * @createTime 2015-10-28 下午5:06:09
     */
    interface MediaStateChangeInterface {
        void finish();

        void pause();

        void start();

        void stop();
    }

    /**
     * 播放结束回调接口
     *
     * @author zjh
     * @createTime 2015-10-28 下午5:06:09
     */
    interface MediafinishedInterface {
        void finishCallback();
    }

}
