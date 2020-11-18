package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class OutApp implements Parcelable {
    /**
     * 包名
     */
    private String packageName;

    /**
     * 1:冻结 0：解冻
     */
    private int status;

    /**
     * 应用名称
     */
    private String name;

    public OutApp(){

    }

    protected OutApp(Parcel in) {
        packageName = in.readString();
        status = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeInt(status);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OutApp> CREATOR = new Creator<OutApp>() {
        @Override
        public OutApp createFromParcel(Parcel in) {
            return new OutApp(in);
        }

        @Override
        public OutApp[] newArray(int size) {
            return new OutApp[size];
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OutApp{" +
                "packageName='" + packageName + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                '}';
    }
}
