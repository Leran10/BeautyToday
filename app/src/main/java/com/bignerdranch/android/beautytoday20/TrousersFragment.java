package com.bignerdranch.android.beautytoday20;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import SQLite.DatabaseHelper;
import helper.SpinnerAdapter;
import model.ItemData;
import model.skirt;
import model.trousers;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrousersFragment extends Fragment {


    private Context context;
    private Button mButtonCon;
    private Button mButtonCam;
    private ImageView result;
    private Spinner mTrousersColor;
    private Spinner mTrousersPattern;
    private Spinner mTrousersMaterial;
    private Spinner mTrousersStyle;
    private Spinner mTrousersLength;
    private DatabaseHelper databasehelper;
    private trousers t;
    private String color;
    private String pattern;
    private String material;
    private String style;
    private String length;
    private String img;



    static final int REQUEST_IMAGE_CAPTURE = 1;



    public TrousersFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview =  inflater.inflate(R.layout.trousers_fragment_layout, container, false);

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

        ArrayList<ItemData> list5 = new ArrayList<>();
        list5.add(new ItemData("long",R.drawable.longcoat));
        list5.add(new ItemData("short",R.drawable.shortcoat));
        Spinner sp5 = (Spinner)rootview.findViewById(R.id.lengthSpinner);
        SpinnerAdapter adapter5 = new SpinnerAdapter(getActivity(),R.layout.spinner_layout, R.id.txt, list5);
        sp5.setAdapter(adapter5);

        mButtonCon = (Button)rootview.findViewById(R.id.confirm);
        mButtonCam = (Button)rootview.findViewById(R.id.camera);
        result = (ImageView)rootview.findViewById(R.id.img);
        mTrousersColor = (Spinner)rootview.findViewById(R.id.colorSpinner);
        mTrousersPattern = (Spinner)rootview.findViewById(R.id.patternSpinner);
        mTrousersMaterial = (Spinner)rootview.findViewById(R.id.materialSpinner);
        mTrousersStyle = (Spinner)rootview.findViewById(R.id.styleSpinner);
        mTrousersLength = (Spinner)rootview.findViewById(R.id.lengthSpinner);


        mButtonCam.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });


        mButtonCon.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Log.d("test","string1");
                try {

                    color = ((ItemData)mTrousersColor.getSelectedItem()).getText();
                    pattern = ((ItemData)mTrousersPattern.getSelectedItem()).getText();
                    material = ((ItemData)mTrousersMaterial.getSelectedItem()).getText();
                    style = ((ItemData)mTrousersStyle.getSelectedItem()).getText();
                    length = ((ItemData)mTrousersLength.getSelectedItem()).getText();
                    imageViewToByte(result);
                    databasehelper = new DatabaseHelper(getActivity());
                    t = new trousers();

                    PostDataToSQLite();

                    Toast.makeText(getActivity(),"new dress has been sucessfully put into your wardrobe!",Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    e.printStackTrace();
                }



                    /*Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("http://www.google.com/"));
                    startActivity(viewIntent);*/
                //selectCoat();



            }
        });


        return rootview;
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    /*private String selectDress(){

        return databasehelper.selectDress();
    }*/


    private void PostDataToSQLite() {

        t.setColor(color);
        t.setPattern(pattern);
        t.setMaterial(material);
        t.setStyle(style);
        t.setLength(length);
        t.setImage(imageViewToByte(result));

        databasehelper.addTrousers(t);


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
