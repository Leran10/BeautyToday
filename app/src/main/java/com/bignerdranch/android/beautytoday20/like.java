package com.bignerdranch.android.beautytoday20;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by qingzhi on 12/11/2017.
 */

public class like extends AppCompatActivity {

    private ImageButton mButtonLike;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_idea_view);

        context = getApplicationContext();
        mButtonLike = (ImageButton)findViewById(R.id.like);
        mButtonLike.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(context,"Nice Choice! These cloth have been put into laundry list!",Toast.LENGTH_LONG).show();

            }
        });


    }

}
