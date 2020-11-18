package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AppDisable implements Parcelable {

    private String packageName;

    //1:冻结 0：解冻
    private int status;

    public AppDisable() {

    }

    protected AppDisable(Parcel in) {
        packageName = in.readString();
        status = in.readInt();
    }

    public static final Creator<AppDisable> CREATOR = new Creator<AppDisable>() {
        @Override
        public AppDisable createFromParcel(Parcel in) {
            return new AppDisable(in);
        }

        @Override
        public AppDisable[] newArray(int size) {
            return new AppDisable[size];
        }
    };

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeInt(status);
    }

    @Override
    public String toString() {
        return "AppDisable{" +
                "packageName='" + packageName + '\'' +
                ", status=" + status +
                '}';
    }
}
