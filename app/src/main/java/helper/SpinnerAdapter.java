package helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.beautytoday20.R;

import java.util.ArrayList;

import model.ItemData;

/**
 * Created by qingzhi on 12/8/2017.
 */

public class SpinnerAdapter extends ArrayAdapter<ItemData> {

    int groupid;
    Activity context;
    ArrayList<ItemData> list;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<ItemData> list){
        super(context,id,list);
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(int position, View convertview, ViewGroup parent){
        View itemview = inflater.inflate(groupid,parent,false);
        ImageView imageview = (ImageView)itemview.findViewById(R.id.img);
        imageview.setImageResource(list.get(position).getImageId());
        TextView textview = (TextView)itemview.findViewById(R.id.txt);
        textview.setText(list.get(position).getText());
        return itemview;
    }

    public View getDropDownView(int position,View convertview,ViewGroup parent){
        return getView(position,convertview,parent);
    }
}
