package com.example.ahlammprojecttt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Hardrassing extends BaseAdapter {

    private ArrayList<DataServies> dataList;
    private Context context;

    LayoutInflater layoutInflater;

    public Hardrassing(ArrayList<DataServies> dataList, Context context) {
        this.dataList = dataList;
        this.context= context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (layoutInflater== null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.grid_item,null);
        }

        ImageView gridImage = view.findViewById(R.id.gridImage);
        TextView gridname = view.findViewById(R.id.gridname);
        TextView gridprice = view.findViewById(R.id.gridprice);
        TextView gridDescription = view.findViewById(R.id.gridDescription);
        CardView carddd = view.findViewById(R.id.carddd);


        Glide.with(context).load(dataList.get(i).getImageURL()).into(gridImage);


        carddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, Datial_Drass.class);
                intent.putExtra("image",dataList.get(i).getImageURL());
                intent.putExtra("name",dataList.get(i).getName());
                intent.putExtra("price",dataList.get(i).getPrice());
                intent.putExtra("Description",dataList.get(i).getDescription());
                context.startActivity(intent);
            }
        });

        gridname.setText(dataList.get(i).getName());
        gridprice.setText(dataList.get(i).getPrice());
        gridDescription.setText(dataList.get(i).getDescription());
        return view;
    }
}
