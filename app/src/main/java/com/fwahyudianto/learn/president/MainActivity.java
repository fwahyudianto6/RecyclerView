package com.fwahyudianto.learn.president;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fwahyudianto.learn.president.controllers.PresidentListAdapter;
import com.fwahyudianto.learn.president.models.President;
import com.fwahyudianto.learn.president.models.PresidentData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView oRecyclerView;
    private ArrayList<President> alData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oRecyclerView = findViewById(R.id.rv_main);
        oRecyclerView.setHasFixedSize(true);

        alData.addAll(PresidentData.List());
        RecyclerList();
    }

    private void RecyclerList(){
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        PresidentListAdapter oPresidentListAdapter = new PresidentListAdapter(this);
        oPresidentListAdapter.setPresident(alData);
        oRecyclerView.setAdapter(oPresidentListAdapter);
    }
}