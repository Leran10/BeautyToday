package com.bignerdranch.android.beautytoday20;

/**
 * Created by qingzhi on 12/10/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//import com.codexpedia.list.viewholder.R;

import java.util.ArrayList;

import SQLite.DatabaseHelper;
import adapter.itemlistAdapter;
import model.ItemObject;

public class today extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);
        DatabaseHelper databasehelper = new DatabaseHelper(this);

        // Initializing list view with the custom adapter
        ArrayList <ItemObject> itemList = new ArrayList<ItemObject>();

        itemlistAdapter Adapter = new itemlistAdapter(R.layout.list_idea_view, itemList);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(Adapter);

        //get 10 lists from datadase
        for (int i = 1; i < 5; i++){

            itemList.add(new ItemObject(databasehelper.selectCoatById(i),databasehelper.getDressByCoat(i),databasehelper.getSkirtByCoat(i),
                    databasehelper.getTrouserByCoat(i),databasehelper.getBootsByCoat(i),databasehelper.getBagByCoat(i)));
            ;
        }

    }

}

