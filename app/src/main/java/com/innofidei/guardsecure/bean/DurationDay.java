package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @program: GuardSecure
 * @description: 每天的时长数据
 * @author: liuguizhou
 * @create: 2020-07-28 18:26
 */
public class DurationDay implements Parcelable {

    /**
     * 时长总时长 分钟数
     */
    private int duration;

    /**
     * 是否开启时间间隔 true表示开启时间间隔，false 表示关闭
     */
    private boolean intervalState;
    /**
     * 使用多久后 休息 分钟数
     */
    private int restAfterUsed;
    /**
     * 休息多少时间  分钟数
     */
    private int restLongtime;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isIntervalState() {
        return intervalState;
    }

    public void setIntervalState(boolean intervalState) {
        this.intervalState = intervalState;
    }

    public int getRestAfterUsed() {
        return restAfterUsed;
    }

    public void setRestAfterUsed(int restAfterUsed) {
        this.restAfterUsed = restAfterUsed;
    }

    public int getRestLongtime() {
        return restLongtime;
    }

    public void setRestLongtime(int restLongtime) {
        this.restLongtime = restLongtime;
    }

    public DurationDay() {
    }

    protected DurationDay(Parcel in) {
        duration = in.readInt();
        intervalState = in.readByte() != 0;
        restAfterUsed = in.readInt();
        restLongtime = in.readInt();
    }

    public static final Creator<DurationDay> CREATOR = new Creator<DurationDay>() {
        @Override
        public DurationDay createFromParcel(Parcel in) {
            return new DurationDay(in);
        }

        @Override
        public DurationDay[] newArray(int size) {
            return new DurationDay[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(duration);
        dest.writeByte((byte) (intervalState ? 1 : 0));
        dest.writeInt(restAfterUsed);
        dest.writeInt(restLongtime);
    }

    @Override
    public String toString() {
        return "DurationDay{" +
                "duration=" + duration +
                ", intervalState=" + intervalState +
                ", restAfterUsed=" + restAfterUsed +
                ", restLongtime=" + restLongtime +
                '}';
    }
}
