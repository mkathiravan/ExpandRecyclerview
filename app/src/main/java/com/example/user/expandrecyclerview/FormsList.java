package com.example.user.expandrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class FormsList implements Parcelable {

     String formId;
    String formType;

    List<FormPreFillData> formPreFillList=new ArrayList<FormPreFillData>();


    protected FormsList(Parcel in) {
        formId = in.readString();
        formType = in.readString();
        formURL = in.readString();
        formLinkURL = in.readString();
        formName = in.readString();
        Token = in.readString();
        in.readList(formPreFillList,null);
    }


    public static final Creator<FormsList> CREATOR = new Creator<FormsList>() {
        @Override
        public FormsList createFromParcel(Parcel in) {
            return new FormsList(in);
        }

        @Override
        public FormsList[] newArray(int size) {
            return new FormsList[size];
        }
    };

    public FormsList() {
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }



    public String getFormURL() {
        return formURL;
    }

    public void setFormURL(String formURL) {
        this.formURL = formURL;
    }

    public String getFormLinkURL() {
        return formLinkURL;
    }

    public void setFormLinkURL(String formLinkURL) {
        this.formLinkURL = formLinkURL;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public List<FormPreFillData> getFormPreFillList() {
        return formPreFillList;
    }

    public void setFormPreFillList(List<FormPreFillData> formPreFillList) {
        this.formPreFillList = formPreFillList;
    }


    String formURL;
    String formLinkURL;
    String formName;
    String Token;
    ArrayList<FormPreFillData> formPreFillData;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(formId);
        dest.writeString(formType);
        dest.writeString(formURL);
        dest.writeString(formLinkURL);
        dest.writeString(formName);
        dest.writeString(Token);
        dest.writeList(formPreFillData);
    }

}

