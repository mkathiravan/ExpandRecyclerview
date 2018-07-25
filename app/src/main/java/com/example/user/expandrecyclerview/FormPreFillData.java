package com.example.user.expandrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class FormPreFillData implements Parcelable{

    String PreFillkey;

    String Prefilldescription;

    protected FormPreFillData(Parcel in) {
        PreFillkey = in.readString();
        Prefilldescription = in.readString();
    }

    public static final Creator<FormPreFillData> CREATOR = new Creator<FormPreFillData>() {
        @Override
        public FormPreFillData createFromParcel(Parcel in) {
            return new FormPreFillData(in);
        }

        @Override
        public FormPreFillData[] newArray(int size) {
            return new FormPreFillData[size];
        }
    };

    public FormPreFillData() {
    }

    public String getPreFillkey() {
        return PreFillkey;
    }

    public void setPreFillkey(String preFillkey) {
        PreFillkey = preFillkey;
    }

    public String getPrefilldescription() {
        return Prefilldescription;
    }

    public void setPrefilldescription(String prefilldescription) {
        Prefilldescription = prefilldescription;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PreFillkey);
        dest.writeString(Prefilldescription);
    }
}
