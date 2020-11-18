package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: Administrator
 * created on: 2018/11/14
 * description:
 */
public class Week implements Parcelable {
    /**
     *  开始时间 23:00
     */
    public String start;

    /**
     * 结束时间 23:00
     */
    public String end;

    public Week(){

    }
    protected Week(Parcel in) {
        start = in.readString();
        end = in.readString();
    }

    public static final Creator<Week> CREATOR = new Creator<Week>() {
        @Override
        public Week createFromParcel(Parcel in) {
            return new Week(in);
        }

        @Override
        public Week[] newArray(int size) {
            return new Week[size];
        }
    };

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(start);
        dest.writeString(end);
    }

    @Override
    public String toString() {
        return "Week{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
