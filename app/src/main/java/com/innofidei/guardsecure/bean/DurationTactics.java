package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DurationTactics implements Parcelable {

    public DurationDay monday;

    public DurationDay friday;

    public DurationDay sunday;

    public DurationDay tuesday;

    public DurationDay saturday;

    public DurationDay thursday;

    public DurationDay wednesday;

    public DurationTactics() {
    }

    public DurationTactics(Parcel in) {
        monday = in.readParcelable(DurationDay.class.getClassLoader());
        friday = in.readParcelable(DurationDay.class.getClassLoader());
        sunday = in.readParcelable(DurationDay.class.getClassLoader());
        tuesday = in.readParcelable(DurationDay.class.getClassLoader());
        saturday = in.readParcelable(DurationDay.class.getClassLoader());
        thursday = in.readParcelable(DurationDay.class.getClassLoader());
        wednesday = in.readParcelable(DurationDay.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(monday, flags);
        dest.writeParcelable(friday, flags);
        dest.writeParcelable(sunday, flags);
        dest.writeParcelable(tuesday, flags);
        dest.writeParcelable(saturday, flags);
        dest.writeParcelable(thursday, flags);
        dest.writeParcelable(wednesday, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DurationTactics> CREATOR = new Creator<DurationTactics>() {
        @Override
        public DurationTactics createFromParcel(Parcel in) {
            return new DurationTactics(in);
        }

        @Override
        public DurationTactics[] newArray(int size) {
            return new DurationTactics[size];
        }
    };

    public DurationDay getMonday() {
        return monday;
    }



    public void setMonday(DurationDay monday) {
        this.monday = monday;
    }

    public DurationDay getFriday() {
        return friday;
    }

    public void setFriday(DurationDay friday) {
        this.friday = friday;
    }

    public DurationDay getSunday() {
        return sunday;
    }

    public void setSunday(DurationDay sunday) {
        this.sunday = sunday;
    }

    public DurationDay getTuesday() {
        return tuesday;
    }

    public void setTuesday(DurationDay tuesday) {
        this.tuesday = tuesday;
    }

    public DurationDay getSaturday() {
        return saturday;
    }

    public void setSaturday(DurationDay saturday) {
        this.saturday = saturday;
    }

    public DurationDay getThursday() {
        return thursday;
    }

    public void setThursday(DurationDay thursday) {
        this.thursday = thursday;
    }

    public DurationDay getWednesday() {
        return wednesday;
    }

    public void setWednesday(DurationDay wednesday) {
        this.wednesday = wednesday;
    }


    @Override
    public String toString() {
        return "DurationTactics{" +
                "monday=" + monday +
                ", friday=" + friday +
                ", sunday=" + sunday +
                ", tuesday=" + tuesday +
                ", saturday=" + saturday +
                ", thursday=" + thursday +
                ", wednesday=" + wednesday +
                '}';
    }
}
