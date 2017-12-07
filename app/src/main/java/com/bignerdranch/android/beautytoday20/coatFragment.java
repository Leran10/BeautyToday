package com.bignerdranch.android.beautytoday20;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import SQLite.DatabaseHelper;
import model.coat;

import static android.R.attr.duration;
import static java.sql.DriverManager.println;


/**
 * A simple {@link Fragment} subclass.
 */
public class coatFragment extends Fragment {

    private Context context;
    private Button mButton;
    private EditText mCoatColor;
    private EditText mCoatPattern;
    private EditText mCoatMaterial;
    private EditText mCoatStyle;
    private EditText mCoatSleeves;
    private EditText mCoatLength;
    private DatabaseHelper databasehelper;
    private coat c;
    private String color;
    private String pattern;
    private String material;
    private String style;
    private String sleeves;
    private String length;


    public coatFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview =  inflater.inflate(R.layout.coat_fragment_layout, container, false);


        mButton = (Button)rootview.findViewById(R.id.confirm);
        mCoatColor = (EditText)rootview.findViewById(R.id.colorField);
        mCoatPattern = (EditText)rootview.findViewById(R.id.patternField);
        mCoatMaterial = (EditText)rootview.findViewById(R.id.materialField);
        mCoatStyle = (EditText)rootview.findViewById(R.id.styleField);
        mCoatSleeves = (EditText)rootview.findViewById(R.id.coatSleeves);
        mCoatLength = (EditText)rootview.findViewById(R.id.coatlength);



        mButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    //Log.d("test","string1");
                    color = mCoatColor.getText().toString();
                    pattern = mCoatPattern.getText().toString();
                    material = mCoatMaterial.getText().toString();
                    style = mCoatStyle.getText().toString();
                    sleeves = mCoatSleeves.getText().toString();
                    length = mCoatLength.getText().toString();

                    databasehelper = new DatabaseHelper(getActivity());
                    c = new coat();

                    PostDataToSQLite();

                    /*Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("http://www.google.com/"));
                    startActivity(viewIntent);*/
                    //selectCoat();



                }
            });


        return rootview;
    }

    private String selectCoat(){

        return databasehelper.selectCoat();
    }
    private void PostDataToSQLite() {

        c.setColor(color);
        c.setPattern(pattern);
        c.setMaterial(material);
        c.setStyle(style);
        c.setSleeves(sleeves);
        c.setLength(length);

       databasehelper.addCoat(c);


    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
