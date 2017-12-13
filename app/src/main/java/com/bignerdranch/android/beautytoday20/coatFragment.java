package com.bignerdranch.android.beautytoday20;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import SQLite.DatabaseHelper;
import helper.SpinnerAdapter;
import model.ItemData;
import model.coat;

import static android.R.attr.bitmap;
import static android.R.attr.duration;
import static android.app.Activity.RESULT_OK;
import static java.sql.DriverManager.println;


/**
 * A simple {@link Fragment} subclass.
 */
public class coatFragment extends Fragment {

    private Context context;
    private ImageButton mButtonCon;
    private ImageButton mButtonCam;
    private ImageButton mButtonCho;
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
    private String img;
    int status = 0;


    static final int REQUEST_IMAGE_CAPTURE = 1;
    final int REQUEST_CODE_GALLARY = 999;
    final int PICK_PHOTO_FOR_AVATAR = 1;


    public coatFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.coat_fragment_layout, container, false);

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("dark red", R.drawable.darkred));
        list.add(new ItemData("dark teracotta", R.drawable.darkteracotta));
        list.add(new ItemData("blood orange", R.drawable.bloodorange));
        list.add(new ItemData("pink", R.drawable.pink));
        list.add(new ItemData("blue", R.drawable.blue));
        list.add(new ItemData("light blue", R.drawable.lightblue));
        list.add(new ItemData("green", R.drawable.lightgreen));
        list.add(new ItemData("light green", R.drawable.lightgreen));
        list.add(new ItemData("black", R.drawable.black));
        list.add(new ItemData("white", R.drawable.white));
        list.add(new ItemData("gray", R.drawable.gray));
        Spinner sp = (Spinner) rootview.findViewById(R.id.colorSpinner);
        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list);
        sp.setAdapter(adapter);

        ArrayList<ItemData> list1 = new ArrayList<>();
        list1.add(new ItemData("no pattern", R.drawable.white));
        list1.add(new ItemData("small floral", R.drawable.smallfloral));
        list1.add(new ItemData("big floral", R.drawable.bigfloral));
        list1.add(new ItemData("circle", R.drawable.circle));
        list1.add(new ItemData("checked", R.drawable.checked));
        list1.add(new ItemData("carton", R.drawable.carton));
        list1.add(new ItemData("abstract", R.drawable.abstract1));
        list1.add(new ItemData("paint", R.drawable.paint));
        Spinner sp1 = (Spinner) rootview.findViewById(R.id.patternSpinner);
        SpinnerAdapter adapter1 = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list1);
        sp1.setAdapter(adapter1);

        ArrayList<ItemData> list2 = new ArrayList<>();
        list2.add(new ItemData("leather", R.drawable.leather));
        list2.add(new ItemData("cotton", R.drawable.cotton));
        list2.add(new ItemData("chiffon", R.drawable.chiffon));
        list2.add(new ItemData("flax", R.drawable.flax));
        list2.add(new ItemData("down or cotton", R.drawable.downorcotton));
        list2.add(new ItemData("silk", R.drawable.silk));
        list2.add(new ItemData("waterproof fabric", R.drawable.waterprooffabric));
        list2.add(new ItemData("wool", R.drawable.wool));
        list2.add(new ItemData("denim", R.drawable.denim));
        Spinner sp2 = (Spinner) rootview.findViewById(R.id.materialSpinner);
        SpinnerAdapter adapter2 = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list2);
        sp2.setAdapter(adapter2);

        ArrayList<ItemData> list3 = new ArrayList<>();
        list3.add(new ItemData("suit", R.drawable.white));
        list3.add(new ItemData("bussiness casual", R.drawable.white));
        list3.add(new ItemData("outdoor", R.drawable.white));
        list3.add(new ItemData("ladies", R.drawable.white));
        list3.add(new ItemData("punk", R.drawable.white));
        list3.add(new ItemData("evening dress", R.drawable.white));
        list3.add(new ItemData("saxy", R.drawable.white));
        list3.add(new ItemData("mori girl", R.drawable.white));
        list3.add(new ItemData("natual style", R.drawable.white));
        Spinner sp3 = (Spinner) rootview.findViewById(R.id.styleSpinner);
        SpinnerAdapter adapter3 = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list3);
        sp3.setAdapter(adapter3);

        ArrayList<ItemData> list4 = new ArrayList<>();
        list4.add(new ItemData("long sleeves", R.drawable.longsleeves));
        list4.add(new ItemData("short sleeves", R.drawable.shortsleeves));
        list4.add(new ItemData("vest", R.drawable.vest));
        list4.add(new ItemData("sling", R.drawable.sling));
        Spinner sp4 = (Spinner) rootview.findViewById(R.id.sleevesSpinner);
        SpinnerAdapter adapter4 = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list4);
        sp4.setAdapter(adapter4);

        ArrayList<ItemData> list5 = new ArrayList<>();
        list5.add(new ItemData("long", R.drawable.longcoat));
        list5.add(new ItemData("short", R.drawable.shortcoat));
        Spinner sp5 = (Spinner) rootview.findViewById(R.id.lengthSpinner);
        SpinnerAdapter adapter5 = new SpinnerAdapter(getActivity(), R.layout.spinner_layout, R.id.txt, list5);
        sp5.setAdapter(adapter5);

        mButtonCon = (ImageButton) rootview.findViewById(R.id.confirm);
        mButtonCam = (ImageButton) rootview.findViewById(R.id.camera);
        mButtonCho = (ImageButton) rootview.findViewById(R.id.choose);
        result = (ImageView) rootview.findViewById(R.id.img);
        mCoatColor = (Spinner) rootview.findViewById(R.id.colorSpinner);
        mCoatPattern = (Spinner) rootview.findViewById(R.id.patternSpinner);
        mCoatMaterial = (Spinner) rootview.findViewById(R.id.materialSpinner);
        mCoatStyle = (Spinner) rootview.findViewById(R.id.styleSpinner);
        mCoatSleeves = (Spinner) rootview.findViewById(R.id.sleevesSpinner);
        mCoatLength = (Spinner) rootview.findViewById(R.id.lengthSpinner);


        mButtonCam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
        mButtonCho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               /* ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                       REQUEST_CODE_GALLARY);*/
                pickImage();

            }

        });


        mButtonCon.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Log.d("test","string1");
                try {

                    color = ((ItemData) mCoatColor.getSelectedItem()).getText();
                    pattern = ((ItemData) mCoatPattern.getSelectedItem()).getText();
                    material = ((ItemData) mCoatMaterial.getSelectedItem()).getText();
                    style = ((ItemData) mCoatStyle.getSelectedItem()).getText();
                    sleeves = ((ItemData) mCoatSleeves.getSelectedItem()).getText();
                    length = ((ItemData) mCoatLength.getSelectedItem()).getText();
                    imageViewToByte(result);
                    databasehelper = new DatabaseHelper(getActivity());
                    c = new coat();

                    PostDataToSQLite();

                    Toast.makeText(getActivity(), "new coat has been sucessfully put into your wardrobe!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        return rootview;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_GALLARY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image*//*");
                startActivityForResult(intent, REQUEST_CODE_GALLARY);
            } else {
                Toast.makeText(getActivity(), "you don't have the permission to access the gallary", Toast.LENGTH_SHORT).show();
            }
            return;
        }


    }



    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }


    private void PostDataToSQLite() {

        c.setColor(color);
        c.setPattern(pattern);
        c.setMaterial(material);
        c.setStyle(style);
        c.setSleeves(sleeves);
        c.setLength(length);
        c.setImage(imageViewToByte(result));

        databasehelper.addCoat(c);


    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void dispatchTakePictureIntent() {
        status = 1;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void pickImage() {
        status = 2;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(status == 1) {
             if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                 Bundle extras = data.getExtras();
                 Bitmap imageBitmap = (Bitmap) extras.get("data");
                 result.setImageBitmap(imageBitmap);
             }
         }
         else if(status == 2) {
             if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == RESULT_OK) {
                 if (data == null) {
                     //Display an error
                     return;
                 } else {
                     InputStream inputStream = null;
                     try {
                         inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                         Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                         result.setImageBitmap(bitmap);
                     } catch (FileNotFoundException e) {
                         e.printStackTrace();
                     }
                 }


             }
         }
        }

       /* else {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
                Uri uri = data.getData();
                try {
                    InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    result.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }*/



/*    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            InputStream inputStream = null;
            try {
                inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                result.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }*/
}
