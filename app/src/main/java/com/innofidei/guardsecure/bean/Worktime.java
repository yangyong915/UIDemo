package com.innofidei.guardsecure.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * author: Administrator
 * created on: 2018/11/14
 * description:
 */
public class Worktime implements Parcelable {

    public List<Week> monday;
    public List<Week> friday;
    public List<Week> sunday;
    public List<Week> tuesday;
    public List<Week> saturday;
    public List<Week> thursday;
    public List<Week> wednesday;

    public Worktime(){

    }


    protected Worktime(Parcel in) {
        monday = in.createTypedArrayList(Week.CREATOR);
        friday = in.createTypedArrayList(Week.CREATOR);
        sunday = in.createTypedArrayList(Week.CREATOR);
        tuesday = in.createTypedArrayList(Week.CREATOR);
        saturday = in.createTypedArrayList(Week.CREATOR);
        thursday = in.createTypedArrayList(Week.CREATOR);
        wednesday = in.createTypedArrayList(Week.CREATOR);
    }

    public static final Creator<Worktime> CREATOR = new Creator<Worktime>() {
        @Override
        public Worktime createFromParcel(Parcel in) {
            return new Worktime(in);
        }

        @Override
        public Worktime[] newArray(int size) {
            return new Worktime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(monday);
        dest.writeTypedList(friday);
        dest.writeTypedList(sunday);
        dest.writeTypedList(tuesday);
        dest.writeTypedList(saturday);
        dest.writeTypedList(thursday);
        dest.writeTypedList(wednesday);
    }

    public List<Week> getMonday() {
        return monday;
    }

    public void setMonday(List<Week> monday) {
        this.monday = monday;
    }

    public List<Week> getFriday() {
        return friday;
    }

    public void setFriday(List<Week> friday) {
        this.friday = friday;
    }

    public List<Week> getSunday() {
        return sunday;
    }

    public void setSunday(List<Week> sunday) {
        this.sunday = sunday;
    }

    public List<Week> getTuesday() {
        return tuesday;
    }

    public void setTuesday(List<Week> tuesday) {
        this.tuesday = tuesday;
    }

    public List<Week> getSaturday() {
        return saturday;
    }

    public void setSaturday(List<Week> saturday) {
        this.saturday = saturday;
    }

    public List<Week> getThursday() {
        return thursday;
    }

    public void setThursday(List<Week> thursday) {
        this.thursday = thursday;
    }

    public List<Week> getWednesday() {
        return wednesday;
    }

    public void setWednesday(List<Week> wednesday) {
        this.wednesday = wednesday;
    }

    @Override
    public String toString() {
        return "Worktime{" +
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
