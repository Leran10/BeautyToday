package com.bignerdranch.android.beautytoday20;

/**
 * Created by qingzhi on 12/10/2017.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import SQLite.DatabaseHelper;
//import adapter.RecyclerViewAdapter;
import adapter.itemlistAdapter;
import model.ItemObject;


public class today extends AppCompatActivity {

    private GridView gridview;
    ArrayList<ItemObject> list;
    itemlistAdapter adapter = null;
    DatabaseHelper databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);

        databasehelper = new DatabaseHelper(this);
        gridview = (GridView)findViewById(R.id.gridview);
        list = new ArrayList<>();
        adapter = new itemlistAdapter(this,R.layout.list_idea_view,list);
        gridview.setAdapter(adapter);

        //get 10 lists from datadase
        for (int i = 0; i < 10; i++){

            list.add(new ItemObject(databasehelper.selectCoatById(i),databasehelper.getDressByCoat(i),databasehelper.getSkirtByCoat(i),
                            databasehelper.getTrouserByCoat(i),databasehelper.getBootsByCoat(i),databasehelper.getBagByCoat(i)));
       ;
        }

        adapter.notifyDataSetChanged();

    }

}