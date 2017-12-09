package adapter;

/**
 * Created by qingzhi on 12/10/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.beautytoday20.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView coat;
    public ImageView dress;
    public ImageView skirt;
    public ImageView trousers;
    public ImageView boots;
    public ImageView bag;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        coat = (ImageView) itemView.findViewById(R.id.coatph);
        dress = (ImageView) itemView.findViewById(R.id.dressph);
        skirt= (ImageView) itemView.findViewById(R.id.skirtph);
        trousers = (ImageView) itemView.findViewById(R.id.trousersph);
        boots = (ImageView) itemView.findViewById(R.id.bootsph);
        bag = (ImageView) itemView.findViewById(R.id.bagph);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
