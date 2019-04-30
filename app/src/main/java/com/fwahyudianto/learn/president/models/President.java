package com.fwahyudianto.learn.president.models;

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 *  http://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: fwahyudi06@gmail.com
 */

public class President {
    protected String m_strPresidentName = "";
    protected String m_strPhoto = "";
    protected String m_strDescriptions = "";

    //  Constructor
    public President() {

    }

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
}