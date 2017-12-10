package com.bignerdranch.android.beautytoday20;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mCoatButton;
    Button mDressButton;
    Button mTrousersButton;
    Button mSkirtButton;
    Button mBootsButton;
    Button mBagButton;
    private Button mTodayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoatButton = (Button) findViewById(R.id.coat);
        mCoatButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();

            @Override
            public void onClick(View v) {
                coatFragment coat1 = new coatFragment();
                fragmentTransaction.replace(R.id.fragment_container, coat1);
                fragmentTransaction.commit();
            }
        });

        mDressButton = (Button)findViewById(R.id.dress);
        mDressButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                dressFragment dress1 = new dressFragment();
                fragmentTransaction.replace(R.id.fragment_container,dress1);
                fragmentTransaction.commit();
            }
        });

        mTrousersButton = (Button)findViewById(R.id.trousers);
        mTrousersButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                TrousersFragment trousers1 = new TrousersFragment();
                fragmentTransaction.replace(R.id.fragment_container,trousers1);
                fragmentTransaction.commit();
            }
        });

        mSkirtButton = (Button)findViewById(R.id.skirt);
        mSkirtButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                skirtFragment skirt1 = new skirtFragment();
                fragmentTransaction.replace(R.id.fragment_container,skirt1);
                fragmentTransaction.commit();
            }
        });

        mBootsButton = (Button)findViewById(R.id.boots);
        mBootsButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                bootsFragment boots1 = new bootsFragment();
                fragmentTransaction.replace(R.id.fragment_container,boots1);
                fragmentTransaction.commit();
            }
        });

        mBagButton = (Button)findViewById(R.id.bag);
        mBagButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                bootsFragment boots1 = new bootsFragment();
                fragmentTransaction.replace(R.id.fragment_container,boots1);
                fragmentTransaction.commit();
            }
        });

        mTodayButton = (Button)findViewById(R.id.today);
        mTodayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, today.class);
                startActivity(intent);
            }
        });

    }

}
