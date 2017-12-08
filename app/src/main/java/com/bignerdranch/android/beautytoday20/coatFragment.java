package com.bignerdranch.android.beautytoday20;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import SQLite.DatabaseHelper;
import helper.SpinnerAdapter;
import model.ItemData;
import model.coat;

import static android.R.attr.duration;
import static android.app.Activity.RESULT_OK;
import static java.sql.DriverManager.println;


/**
 * A simple {@link Fragment} subclass.
 */
public class coatFragment extends Fragment {

    private Context context;
    private Button mButtonCon;
    private Button mButtonCam;
    private ImageView result;
    private Spinner mCoatColor;
    private Spinner mCoatPattern;
    private Spinner mCoatMaterial;
    private Spinner mCoatStyle;
    private Spinner mCoatSleeves;
    private Spinner mCoatLength;
    private DatabaseHelper databasehelper;
    private coat c;
    private String color;
    private String pattern;
    private String material;
    private String style;
    private String sleeves;
    private String length;

    static final int REQUEST_IMAGE_CAPTURE = 1;


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
        list2.add(new ItemData("leather",R.drawable.leather));
        list2.add(new ItemData("cotton",R.drawable.cotton));
        list2.add(new ItemData("chiffon",R.drawable.chiffon));
        list2.add(new ItemData("flax",R.drawable.flax));
        list2.add(new ItemData("down or cotton",R.drawable.downorcotton));
        list2.add(new ItemData("silk",R.drawable.silk));
        list2.add(new ItemData("waterproof fabric",R.drawable.waterprooffabric));
        list2.add(new ItemData("wool",R.drawable.wool));
        list2.add(new ItemData("denim",R.drawable.denim));
        Spinner sp2 = (Spinner)rootview.findViewById(R.id.materialSpinner);
        SpinnerAdapter adapter2 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list2);
        sp2.setAdapter(adapter2);

        ArrayList<ItemData> list3 = new ArrayList<>();
        list3.add(new ItemData("suit",R.drawable.white));
        list3.add(new ItemData("bussiness casual",R.drawable.white));
        list3.add(new ItemData("outdoor",R.drawable.white));
        list3.add(new ItemData("ladies",R.drawable.white));
        list3.add(new ItemData("punk",R.drawable.white));
        list3.add(new ItemData("evening dress",R.drawable.white));
        list3.add(new ItemData("saxy",R.drawable.white));
        list3.add(new ItemData("mori girl",R.drawable.white));
        list3.add(new ItemData("natual style",R.drawable.white));
        Spinner sp3 = (Spinner)rootview.findViewById(R.id.styleSpinner);
        SpinnerAdapter adapter3 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list3);
        sp3.setAdapter(adapter3);

         ArrayList<ItemData> list4 = new ArrayList<>();
        list4.add(new ItemData("long sleeves",R.drawable.longsleeves));
        list4.add(new ItemData("short sleeves",R.drawable.shortsleeves));
        list4.add(new ItemData("vest",R.drawable.vest));
        list4.add(new ItemData("sling",R.drawable.sling));
        Spinner sp4 = (Spinner)rootview.findViewById(R.id.sleevesSpinner);
        SpinnerAdapter adapter4 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list4);
        sp4.setAdapter(adapter4);

        ArrayList<ItemData> list5 = new ArrayList<>();
        list5.add(new ItemData("long",R.drawable.longcoat));
        list5.add(new ItemData("short",R.drawable.shortcoat));
        Spinner sp5 = (Spinner)rootview.findViewById(R.id.lengthSpinner);
        SpinnerAdapter adapter5 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list5);
        sp5.setAdapter(adapter5);

        mButtonCon = (Button)rootview.findViewById(R.id.confirm);
        mButtonCam = (Button)rootview.findViewById(R.id.camera);
        result = (ImageView)rootview.findViewById(R.id.img);
        mCoatColor = (Spinner)rootview.findViewById(R.id.colorSpinner);
        mCoatPattern = (Spinner)rootview.findViewById(R.id.patternSpinner);
        mCoatMaterial = (Spinner)rootview.findViewById(R.id.materialSpinner);
        mCoatStyle = (Spinner)rootview.findViewById(R.id.styleSpinner);
        mCoatSleeves = (Spinner)rootview.findViewById(R.id.sleevesSpinner);
        mCoatLength = (Spinner)rootview.findViewById(R.id.lengthSpinner);

        mButtonCam.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });


        mButtonCon.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    //Log.d("test","string1");
                    color = mCoatColor.getSelectedItem().toString();
                    pattern = mCoatPattern.getSelectedItem().toString();
                    material = mCoatMaterial.getSelectedItem().toString();
                    style = mCoatStyle.getSelectedItem().toString();
                    sleeves = mCoatSleeves.getSelectedItem().toString();
                    length = mCoatLength.getSelectedItem().toString();

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

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            result.setImageBitmap(imageBitmap);
        }
    }

}
