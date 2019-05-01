package com.fwahyudianto.learn.president.controllers;

import android.view.View;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class PresidentOnItemClickListener implements View.OnClickListener {
    private int m_iPosition;
    private OnItemClickCallback m_oOnItemClickCallback;

    //  Constructor
    PresidentOnItemClickListener(int iPosition, OnItemClickCallback oOnItemClickCallback) {
        this.m_iPosition = iPosition;
        this.m_oOnItemClickCallback = oOnItemClickCallback;
    }

    //  Event
    @Override
    public void onClick(View oView) {
        m_oOnItemClickCallback.onItemClicked(oView, m_iPosition);
    }

    //  Interface
    public interface OnItemClickCallback {
        void onItemClicked(View oView, int iPosition);
    }
}