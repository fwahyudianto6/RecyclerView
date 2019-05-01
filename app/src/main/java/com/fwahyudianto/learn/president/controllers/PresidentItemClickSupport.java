package com.fwahyudianto.learn.president.controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fwahyudianto.learn.president.R;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class PresidentItemClickSupport {
    private final RecyclerView m_RecyclerView;
    private OnItemClickListener m_OnItemClickListener;
    private OnItemLongClickListener m_OnItemLongClickListener;

    //  Constructor
    private PresidentItemClickSupport(RecyclerView p_oRecyclerView) {
        m_RecyclerView = p_oRecyclerView;
        m_RecyclerView.setTag(R.id.item_click_support, this);
        m_RecyclerView.addOnChildAttachStateChangeListener(mAttachListener);
    }

    //  Getter
    public static PresidentItemClickSupport addTo(RecyclerView p_oRecyclerView) {
        PresidentItemClickSupport oSupport = (PresidentItemClickSupport) p_oRecyclerView.getTag(R.id.item_click_support);
        if (oSupport == null) {
            oSupport = new PresidentItemClickSupport(p_oRecyclerView);
        }

        return oSupport;
    }

    public static PresidentItemClickSupport removeFrom(RecyclerView p_oRecyclerView) {
        PresidentItemClickSupport oSupport = (PresidentItemClickSupport) p_oRecyclerView.getTag(R.id.item_click_support);
        if (oSupport != null) {
            oSupport.setDetach(p_oRecyclerView);
        }

        return oSupport;
    }

    //  Setter
    public void setOnItemClickListener(OnItemClickListener p_oListener) {
        this.m_OnItemClickListener = p_oListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener p_oListener) {
        this.m_OnItemLongClickListener = p_oListener;
    }

    private void setDetach(RecyclerView oView) {
        oView.removeOnChildAttachStateChangeListener(mAttachListener);
        oView.setTag(R.id.item_click_support, null);
    }

    //  Event
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View p_oView) {
            if (m_OnItemClickListener != null) {
                RecyclerView.ViewHolder holder = m_RecyclerView.getChildViewHolder(p_oView);
                m_OnItemClickListener.onItemClicked(m_RecyclerView, holder.getAdapterPosition(), p_oView);
            }
        }
    };

    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View p_oView) {
            if (m_OnItemLongClickListener != null) {
                RecyclerView.ViewHolder holder = m_RecyclerView.getChildViewHolder(p_oView);
                return m_OnItemLongClickListener.onItemLongClicked(m_RecyclerView, holder.getAdapterPosition(), p_oView);
            }
            return false;
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener mAttachListener
            = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View p_oView) {
            if (m_OnItemClickListener != null) {
                p_oView.setOnClickListener(mOnClickListener);
            }
            if (m_OnItemLongClickListener != null) {
                p_oView.setOnLongClickListener(mOnLongClickListener);
            }
        }
        @Override
        public void onChildViewDetachedFromWindow(@NonNull View p_oView) {
        }
    };

    //  Interface
    public interface OnItemClickListener {
        void onItemClicked(RecyclerView p_oRecyclerView, int p_iPosition, View p_oView);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView p_oRecyclerView, int p_iPosition, View p_oView);
    }
}