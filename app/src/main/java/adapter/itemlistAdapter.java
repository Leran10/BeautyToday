package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bignerdranch.android.beautytoday20.R;

import java.util.ArrayList;

import model.ItemObject;

/**
 * Created by qingzhi on 12/10/2017.
 */

public class itemlistAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ItemObject> ideaList;

    public itemlistAdapter(Context context,int layout,ArrayList<ItemObject>ideaList) {
        this.context = context;
        this.layout = layout;
        this.ideaList = ideaList;
    }


    @Override
    public int getCount() {
        return ideaList.size();
    }

    @Override
    public Object getItem(int position) {
        return ideaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView img1,img2,img3,img4,img5,img6;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.img1 = (ImageView)row.findViewById(R.id.coatph);
            holder.img2 = (ImageView)row.findViewById(R.id.dressph);
            holder.img3 = (ImageView)row.findViewById(R.id.skirtph);
            holder.img4 = (ImageView)row.findViewById(R.id.trousersph);
            holder.img5 = (ImageView)row.findViewById(R.id.bootsph);
            holder.img6 = (ImageView)row.findViewById(R.id.bagph);

            row.setTag(holder);
        }else{
            holder = (ViewHolder)row.getTag();
        }

        ItemObject item = ideaList.get(position);

        byte[] coatImg = item.getCoatPh();
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap1);

        byte[] dressImg = item.getDressPh();
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap2);

        byte[] skirtImg = item.getSkirtPh();
        Bitmap bitmap3 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap3);

        byte[] trousersImg = item.getTrousersPh();
        Bitmap bitmap4 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap4);

        byte[] bootsImg = item.getBootsPh();
        Bitmap bitmap5 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap5);

        byte[] bagImg = item.getBagPh();
        Bitmap bitmap6 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap6);

        return row;
    }
}
