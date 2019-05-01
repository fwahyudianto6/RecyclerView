package com.fwahyudianto.learn.president.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class PresidentCardAdapter extends RecyclerView.Adapter<PresidentCardAdapter.CardViewHolder> {
    //  Variable
    private Context oContext;
    private ArrayList<President> alPresident;

    //  Constructor
    public PresidentCardAdapter(Context p_oContext) {
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
    public PresidentCardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup oViewGroup, int i) {
        View oView = LayoutInflater.from(oViewGroup.getContext()).inflate(
                R.layout.item_president_card, oViewGroup, false);

        return new CardViewHolder(oView);
    }

    @Override
    public void onBindViewHolder(@NonNull PresidentCardAdapter.CardViewHolder oCardViewHolder, int iPosition) {
        // Create Instance
        final President oPresident = getPresident().get(iPosition);

        //  Set Photo
        Glide.with(oContext)
                .load(oPresident.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(oCardViewHolder.ivPhoto);

        //  Set Name & Descriptions
        oCardViewHolder.tvName.setText(oPresident.getPresidentName());
        oCardViewHolder.tvDescriptions.setText(oPresident.getDescriptions());

        //  Set Favorite
        oCardViewHolder.btnFavorite.setOnClickListener(new PresidentOnItemClickListener(iPosition, new PresidentOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View oView, int iPosition) {
                Toast.makeText(oContext, "Favorite " + oPresident.getPresidentName(), Toast.LENGTH_SHORT).show();
            }
        }));

        //  Set Share
        oCardViewHolder.btnShare.setOnClickListener(new PresidentOnItemClickListener(iPosition, new PresidentOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View oView, int iPosition) {
                Toast.makeText(oContext, "Share " + oPresident.getPresidentName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getPresident().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName, tvDescriptions;
        Button btnFavorite, btnShare;

        public CardViewHolder(@NonNull View oView) {
            super(oView);
            ivPhoto = itemView.findViewById(R.id.iv_picture);
            tvName = itemView.findViewById(R.id.tv_president_name);
            tvDescriptions = itemView.findViewById(R.id.tv_president_descriptions);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}