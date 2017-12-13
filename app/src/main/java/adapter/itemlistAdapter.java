package adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.beautytoday20.R;
//import com.codexpedia.list.viewholder.R;
import java.util.ArrayList;

import model.ItemObject;


public class itemlistAdapter extends RecyclerView.Adapter<itemlistAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    //private AdapterView.OnItemClickListener mOnItemClickListener;
    private int listItemLayout;
    private ArrayList<ItemObject> list;

  //  Context context = getApplicationContext();





    // Constructor of the class
    public itemlistAdapter(int layoutId, ArrayList<ItemObject> list) {
        listItemLayout = layoutId;
        this.list = list;

    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        ImageView item1 = holder.img1;
        ImageView item2 = holder.img2;
        ImageView item3 = holder.img3;
        ImageView item4 = holder.img4;
        ImageView item5 = holder.img5;
        ImageView item6 = holder.img6;
        ImageButton item7 = holder.ok;
        //item1.setText(list.get(listPosition).getName());

        ItemObject item = list.get(listPosition);

        byte[] coatImg = item.getCoatPh();
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(coatImg,0,coatImg.length);
        holder.img1.setImageBitmap(bitmap1);

        byte[] dressImg = item.getDressPh();
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(dressImg,0,dressImg.length);
        holder.img2.setImageBitmap(bitmap2);

        byte[] skirtImg = item.getSkirtPh();
        Bitmap bitmap3 = BitmapFactory.decodeByteArray(skirtImg,0,skirtImg.length);
        holder.img3.setImageBitmap(bitmap3);

        byte[] trousersImg = item.getTrousersPh();
        Bitmap bitmap4 = BitmapFactory.decodeByteArray(trousersImg,0,trousersImg.length);
        holder.img4.setImageBitmap(bitmap4);

        byte[] bootsImg = item.getBootsPh();
        Bitmap bitmap5 = BitmapFactory.decodeByteArray(bootsImg,0,bootsImg.length);
        holder.img5.setImageBitmap(bitmap5);

        byte[] bagImg = item.getBagPh();
        Bitmap bitmap6 = BitmapFactory.decodeByteArray(bagImg,0,bagImg.length);
        holder.img6.setImageBitmap(bitmap6);

        holder.ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(.getContext(),"Nice Choice! These cloth have been put into laundry list!",Toast.LENGTH_LONG).show();

            }
        });


    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView img1,img2,img3,img4,img5,img6;
        public ImageButton ok;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img1 = (ImageView) itemView.findViewById(R.id.coatph);
            img2 = (ImageView) itemView.findViewById(R.id.dressph);
            img3 = (ImageView) itemView.findViewById(R.id.skirtph);
            img4 = (ImageView) itemView.findViewById(R.id.trousersph);
            img5 = (ImageView) itemView.findViewById(R.id.bootsph);
            img6 = (ImageView) itemView.findViewById(R.id.bagph);
            ok = (ImageButton) itemView.findViewById(R.id.like);


        }
        @Override
        public void onClick(View view) {

        }
    }
}


