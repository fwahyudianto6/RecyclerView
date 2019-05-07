package com.fwahyudianto.learn.president.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 *  http://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: fwahyudi06@gmail.com
 */

public class President implements Parcelable {
    protected String m_strPresidentName = "";
    protected String m_strPhoto = "";
    protected String m_strDescriptions = "";

    //  Constructor
    public President() {

    }

    //  Implement Parcelable
    protected President(Parcel in) {
        m_strPresidentName = in.readString();
        m_strPhoto = in.readString();
        m_strDescriptions = in.readString();
    }

    public static final Creator<President> CREATOR = new Creator<President>() {
        @Override
        public President createFromParcel(Parcel in) {
            return new President(in);
        }

        @Override
        public President[] newArray(int size) {
            return new President[size];
        }
    };

    //  Gettter
    public String getPresidentName() {
        return m_strPresidentName;
    }

    public String getPhoto() {
        return m_strPhoto;
    }

    public String getDescriptions() {
        return m_strDescriptions;
    }

    //  Setter
    public void setPhoto(String p_strPhoto) {
        this.m_strPhoto = p_strPhoto;
    }

    public void setPresidentName(String p_strPresidentName) {
        this.m_strPresidentName = p_strPresidentName;
    }

    public void setDescriptions(String p_strDescriptions) {
        this.m_strDescriptions = p_strDescriptions;
    }

    //  Method - Implement Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_strPresidentName);
        dest.writeString(m_strPhoto);
        dest.writeString(m_strDescriptions);
    }
}