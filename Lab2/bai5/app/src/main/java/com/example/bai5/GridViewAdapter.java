package com.example.bai5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<Dish> {
    Activity context;
    public GridViewAdapter(Activity context, int layoutID, List<Dish> objects)
    {
        super(context,layoutID,objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_row, null, false);
        }

        Dish dish = getItem(position);

        TextView textView = (TextView) convertView.findViewById(R.id.name_grid);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.img_grid);
        RelativeLayout relativeLayout=(RelativeLayout) convertView.findViewById(R.id.grid_layout);

        textView.setText(dish.getTenmon());
        textView.setSelected(true);
        relativeLayout.setBackgroundResource(dish.getHinh());
        if(dish.getIs_pro())
        {
            imageView.setImageResource(R.drawable.ic_android_black_24dp);
        }

        return convertView;
    }
}

