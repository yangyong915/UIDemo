package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;

public class UsageStat implements Parcelable {
    /**
     * 包名
     */
    private String mPackageName;
    /**
     * 开始时间戳
     */
    private long  mBeginTimeStamp;

    /**
     * 结束时间戳
     */
    private long mEndTimeStamp;

    /**
     * 最后一次使用时间戳
     */
    private  long mLastTimeUsed;

    /**
     * 前台使用总时长
     */
    private long mTotalTimeInForeground;

    /**
     * 启动次数
     */
    private int mLaunchCount;

    /**
     * 最后一次事件
     */
    private int mLastEvent;

    private ArrayMap<String, ArrayMap<String, Integer>> mChooserCounts;

    public UsageStat() {

    }


    protected UsageStat(Parcel in) {
        mPackageName = in.readString();
        mBeginTimeStamp = in.readLong();
        mEndTimeStamp = in.readLong();
        mLastTimeUsed = in.readLong();
        mTotalTimeInForeground = in.readLong();
        mLaunchCount = in.readInt();
        mLastEvent = in.readInt();
    }

    public static final Creator<UsageStat> CREATOR = new Creator<UsageStat>() {
        @Override
        public UsageStat createFromParcel(Parcel in) {
            return new UsageStat(in);
        }

        @Override
        public UsageStat[] newArray(int size) {
            return new UsageStat[size];
        }
    };

    public String getmPackageName() {
        return mPackageName;
    }

    public void setmPackageName(String mPackageName) {
        this.mPackageName = mPackageName;
    }

    public long getmBeginTimeStamp() {
        return mBeginTimeStamp;
    }

    public void setmBeginTimeStamp(long mBeginTimeStamp) {
        this.mBeginTimeStamp = mBeginTimeStamp;
    }

    public long getmEndTimeStamp() {
        return mEndTimeStamp;
    }

    public void setmEndTimeStamp(long mEndTimeStamp) {
        this.mEndTimeStamp = mEndTimeStamp;
    }

    public long getmLastTimeUsed() {
        return mLastTimeUsed;
    }

    public void setmLastTimeUsed(long mLastTimeUsed) {
        this.mLastTimeUsed = mLastTimeUsed;
    }

    public long getmTotalTimeInForeground() {
        return mTotalTimeInForeground;
    }

    public void setmTotalTimeInForeground(long mTotalTimeInForeground) {
        this.mTotalTimeInForeground = mTotalTimeInForeground;
    }

    public int getmLaunchCount() {
        return mLaunchCount;
    }

    public void setmLaunchCount(int mLaunchCount) {
        this.mLaunchCount = mLaunchCount;
    }

    public int getmLastEvent() {
        return mLastEvent;
    }

    public void setmLastEvent(int mLastEvent) {
        this.mLastEvent = mLastEvent;
    }

    public ArrayMap<String, ArrayMap<String, Integer>> getmChooserCounts() {
        return mChooserCounts;
    }

    public void setmChooserCounts(ArrayMap<String, ArrayMap<String, Integer>> mChooserCounts) {
        this.mChooserCounts = mChooserCounts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPackageName);
        dest.writeLong(mBeginTimeStamp);
        dest.writeLong(mEndTimeStamp);
        dest.writeLong(mLastTimeUsed);
        dest.writeLong(mTotalTimeInForeground);
        dest.writeInt(mLaunchCount);
        dest.writeInt(mLastEvent);
    }

    @Override
    public String toString() {
        return "UsageStat{" +
                "mPackageName='" + mPackageName + '\'' +
                ", mBeginTimeStamp=" + mBeginTimeStamp +
                ", mEndTimeStamp=" + mEndTimeStamp +
                ", mLastTimeUsed=" + mLastTimeUsed +
                ", mTotalTimeInForeground=" + mTotalTimeInForeground +
                ", mLaunchCount=" + mLaunchCount +
                ", mLastEvent=" + mLastEvent +
                ", mChooserCounts=" + mChooserCounts +
                '}';
    }
}
