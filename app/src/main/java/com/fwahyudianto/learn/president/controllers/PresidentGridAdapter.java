package com.fwahyudianto.learn.president.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fwahyudianto.learn.president.R;
import com.fwahyudianto.learn.president.models.President;

import java.util.ArrayList;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class PresidentGridAdapter extends RecyclerView.Adapter<PresidentGridAdapter.GridViewHolder> {
    //  Variable
    private Context oContext;
    private ArrayList<President> alPresident;

    //  Constructor
    public PresidentGridAdapter(Context p_oContext) {
        this.oContext = p_oContext;
    }

    //  Getter
    public ArrayList<President> getPresident() {
        return alPresident;
    }

    //  Setter
    public void setPresident(ArrayList<President> p_alPresident) {
        this.alPresident = p_alPresident;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup oViewGroup, int iType) {
        View oView = LayoutInflater.from(oViewGroup.getContext()).inflate(
                R.layout.item_president_grid, oViewGroup, false);

        return new GridViewHolder(oView);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder oGridViewHolder, int iPosition) {
        Glide.with(oContext)
                .load(getPresident().get(iPosition).getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(oGridViewHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return getPresident().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;

        public GridViewHolder(@NonNull View oView) {
            super(oView);
            ivPhoto = oView.findViewById(R.id.img_picture);
        }
    }
}