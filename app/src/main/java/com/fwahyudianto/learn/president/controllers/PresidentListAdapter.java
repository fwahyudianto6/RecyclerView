package com.fwahyudianto.learn.president.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class PresidentListAdapter extends RecyclerView.Adapter<PresidentListAdapter.CategoryViewHolder> {
    //  Variable
    private Context oContext;
    private ArrayList<President> alPresident;

    //  Constructor
    public PresidentListAdapter(Context p_oContext) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup oViewGroup, int i) {
        View oView = LayoutInflater.from(oViewGroup.getContext()).inflate(
                R.layout.item_president_list, oViewGroup, false);

        return new CategoryViewHolder(oView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder oCategoryViewHolder, int iPosition) {
        oCategoryViewHolder.tvName.setText(getPresident().get(iPosition).getPresidentName());
        oCategoryViewHolder.tvDescriptions.setText(getPresident().get(iPosition).getDescriptions());

        Glide.with(oContext)
                .load(getPresident().get(iPosition).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(oCategoryViewHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return getPresident().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescriptions;
        ImageView ivPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_president_name);
            tvDescriptions = itemView.findViewById(R.id.tv_president_descriptions);
            ivPhoto = itemView.findViewById(R.id.civ_picture);
        }
    }
}
