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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import SQLite.DatabaseHelper;
import helper.SpinnerAdapter;
import model.ItemData;
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

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("dark red",R.drawable.darkred));
        list.add(new ItemData("dark teracotta",R.drawable.darkteracotta));
        list.add(new ItemData("blood orange",R.drawable.bloodorange));
        list.add(new ItemData("pink",R.drawable.pink));
        list.add(new ItemData("blue",R.drawable.blue));
        list.add(new ItemData("light blue",R.drawable.lightblue));
        list.add(new ItemData("green",R.drawable.lightgreen));
        list.add(new ItemData("light green",R.drawable.lightgreen));
        list.add(new ItemData("black",R.drawable.black));
        list.add(new ItemData("white",R.drawable.white));
        list.add(new ItemData("gray",R.drawable.gray));
        Spinner sp = (Spinner)rootview.findViewById(R.id.colorSpinner);
        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list);
        sp.setAdapter(adapter);

        ArrayList<ItemData> list1 = new ArrayList<>();
        list1.add(new ItemData("no pattern",R.drawable.white));
        list1.add(new ItemData("small floral",R.drawable.smallfloral));
        list1.add(new ItemData("big floral",R.drawable.bigfloral));
        list1.add(new ItemData("circle",R.drawable.circle));
        list1.add(new ItemData("checked",R.drawable.checked));
        list1.add(new ItemData("carton",R.drawable.carton));
        list1.add(new ItemData("abstract",R.drawable.abstract1));
        list1.add(new ItemData("paint",R.drawable.paint));
        Spinner sp1 = (Spinner)rootview.findViewById(R.id.patternSpinner);
        SpinnerAdapter adapter1 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list1);
        sp1.setAdapter(adapter1);

        ArrayList<ItemData> list2 = new ArrayList<>();
        list1.add(new ItemData("no pattern",R.drawable.white));
        list1.add(new ItemData("small floral",R.drawable.smallfloral));
        list1.add(new ItemData("big floral",R.drawable.bigfloral));
        list1.add(new ItemData("circle",R.drawable.circle));
        list1.add(new ItemData("checked",R.drawable.checked));
        list1.add(new ItemData("carton",R.drawable.carton));
        list1.add(new ItemData("abstract",R.drawable.abstract1));
        list1.add(new ItemData("paint",R.drawable.paint));
        Spinner sp2 = (Spinner)rootview.findViewById(R.id.patternSpinner);
        SpinnerAdapter adapter2 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list2);
        sp2.setAdapter(adapter2);

        ArrayList<ItemData> list3 = new ArrayList<>();
        list1.add(new ItemData("no pattern",R.drawable.white));
        list1.add(new ItemData("small floral",R.drawable.smallfloral));
        list1.add(new ItemData("big floral",R.drawable.bigfloral));
        list1.add(new ItemData("circle",R.drawable.circle));
        list1.add(new ItemData("checked",R.drawable.checked));
        list1.add(new ItemData("carton",R.drawable.carton));
        list1.add(new ItemData("abstract",R.drawable.abstract1));
        list1.add(new ItemData("paint",R.drawable.paint));
        Spinner sp3 = (Spinner)rootview.findViewById(R.id.materialSpinner);
        SpinnerAdapter adapter3 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list3);
        sp3.setAdapter(adapter3);

        ArrayList<ItemData> list4 = new ArrayList<>();
        list1.add(new ItemData("long sleeves",R.drawable.longsleeves));
        list1.add(new ItemData("short sleeves",R.drawable.shortsleeves));
        Spinner sp4 = (Spinner)rootview.findViewById(R.id.sleevesSpinner);
        SpinnerAdapter adapter4 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list4);
        sp4.setAdapter(adapter4);

        ArrayList<ItemData> list5 = new ArrayList<>();
        list1.add(new ItemData("no pattern",R.drawable.white));
        list1.add(new ItemData("small floral",R.drawable.smallfloral));
        list1.add(new ItemData("big floral",R.drawable.bigfloral));
        list1.add(new ItemData("circle",R.drawable.circle));
        list1.add(new ItemData("checked",R.drawable.checked));
        list1.add(new ItemData("carton",R.drawable.carton));
        list1.add(new ItemData("abstract",R.drawable.abstract1));
        list1.add(new ItemData("paint",R.drawable.paint));
        Spinner sp5 = (Spinner)rootview.findViewById(R.id.sleevesSpinner);
        SpinnerAdapter adapter5 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list5);
        sp5.setAdapter(adapter5);

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
