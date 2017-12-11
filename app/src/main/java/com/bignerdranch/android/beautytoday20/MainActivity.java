package com.bignerdranch.android.beautytoday20;

//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton mCoatButton;
    ImageButton mDressButton;
    ImageButton mTrousersButton;
    ImageButton mSkirtButton;
    ImageButton mBootsButton;
    ImageButton mBagButton;
    private Button mTodayButton;
    FragmentManager fragmentmanager;
    FragmentTransaction fragmentTransaction;
    coatFragment coat1 = new coatFragment();
    dressFragment dress1 = new dressFragment();
    TrousersFragment trousers1 = new TrousersFragment();
    skirtFragment skirt1 = new skirtFragment();
    bootsFragment boots1 = new bootsFragment();
    bagFragment bag1 = new bagFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentmanager = getSupportFragmentManager();
        fragmentTransaction = fragmentmanager.beginTransaction();

        mCoatButton = (ImageButton) findViewById(R.id.coat);
        mCoatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //coatFragment coat1 = new coatFragment();
                openFragment(coat1);
                /*fragmentTransaction.replace(R.id.fragment_container, coat1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });

        mDressButton = (ImageButton)findViewById(R.id.dress);
        mDressButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                //dressFragment dress1 = new dressFragment();
                openFragment(dress1);
                /*fragmentTransaction.replace(R.id.fragment_container,dress1);
                fragmentTransaction.commit();*/
            }
        });

        mTrousersButton = (ImageButton)findViewById(R.id.trousers);
        mTrousersButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                //TrousersFragment trousers1 = new TrousersFragment();
                openFragment(trousers1);
                /*fragmentTransaction.replace(R.id.fragment_container,trousers1);
                fragmentTransaction.commit();*/
            }
        });

        mSkirtButton = (ImageButton)findViewById(R.id.skirt);
        mSkirtButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                //skirtFragment skirt1 = new skirtFragment();
                openFragment(skirt1);
                /*fragmentTransaction.replace(R.id.fragment_container,skirt1);
                fragmentTransaction.commit();*/
            }
        });

        mBootsButton = (ImageButton)findViewById(R.id.boots);
        mBootsButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                //bootsFragment boots1 = new bootsFragment();
                openFragment(boots1);
                /*fragmentTransaction.replace(R.id.fragment_container,boots1);
                fragmentTransaction.commit();*/
            }
        });

        mBagButton = (ImageButton)findViewById(R.id.bag);
        mBagButton.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
            @Override
            public void onClick(View v) {
                //bagFragment bag1 = new bagFragment();
                openFragment(bag1);
                /*fragmentTransaction.replace(R.id.fragment_container,bag1);
                fragmentTransaction.commit();*/
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

    private void openFragment(final Fragment fragment)   {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}

