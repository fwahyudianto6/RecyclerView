package com.fwahyudianto.learn.president;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.fwahyudianto.learn.president.controllers.PresidentCardAdapter;
import com.fwahyudianto.learn.president.controllers.PresidentGridAdapter;
import com.fwahyudianto.learn.president.controllers.PresidentListAdapter;
import com.fwahyudianto.learn.president.models.President;
import com.fwahyudianto.learn.president.models.PresidentData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String m_strStateTitle = "state_title";
    final String m_strStateMode = "state_mode";
    int iMode;
    private RecyclerView oRecyclerView;
    private ArrayList<President> alData = new ArrayList<>();

    //  Event
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oRecyclerView = findViewById(R.id.rv_main);
        oRecyclerView.setHasFixedSize(true);

        alData = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("President List with List View");
            alData.addAll(PresidentData.List());
            RecyclerList();
            iMode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(m_strStateTitle);
            ArrayList<President> oPresident = (ArrayList<President>) savedInstanceState.getSerializable("president");
            int iStateMode = savedInstanceState.getInt(m_strStateMode);

            setActionBarTitle(stateTitle);
            alData.addAll(oPresident);
            setMode(iStateMode);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu p_oMenu) {
        getMenuInflater().inflate(R.menu.menu_main, p_oMenu);

        return super.onCreateOptionsMenu(p_oMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem p_oMenuItem) {
        setMode(p_oMenuItem.getItemId());

        return super.onOptionsItemSelected(p_oMenuItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle oBundle) {
        super.onSaveInstanceState(oBundle);
        oBundle.putString(m_strStateTitle, getSupportActionBar().getTitle().toString());
        oBundle.putSerializable("president", alData);
        oBundle.putInt(m_strStateMode, iMode);
    }

    //  Method
    private void RecyclerList() {
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PresidentListAdapter oPresidentListAdapter = new PresidentListAdapter(this);
        oPresidentListAdapter.setPresident(alData);

        oRecyclerView.setAdapter(oPresidentListAdapter);
    }

    private void RecyclerGrid() {
        oRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        PresidentGridAdapter oPresidentGridAdapter = new PresidentGridAdapter(this);
        oPresidentGridAdapter.setPresident(alData);

        oRecyclerView.setAdapter(oPresidentGridAdapter);
    }

    private void RecyclerCard() {
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PresidentCardAdapter oPresidentCardAdapter = new PresidentCardAdapter(this);
        oPresidentCardAdapter.setPresident(alData);

        oRecyclerView.setAdapter(oPresidentCardAdapter);
    }

    private void setActionBarTitle(String p_strTitle) {
        getSupportActionBar().setTitle(p_strTitle);
    }

    private void setMode(int p_iMode) {
        String strTitle = null;
        switch (p_iMode) {
            case R.id.action_list:
                strTitle = "President List with List View";
                RecyclerList();
                break;
            case R.id.action_grid:
                strTitle = "President List with Grid View";
                RecyclerGrid();
                break;
            case R.id.action_cardview:
                strTitle = "President List with Card View";
                RecyclerCard();
                break;
        }

        iMode = p_iMode;
        setActionBarTitle(strTitle);
    }
}