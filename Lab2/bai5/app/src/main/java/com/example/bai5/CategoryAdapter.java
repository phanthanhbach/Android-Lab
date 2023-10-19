package com.example.bai5;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Catergory> {


    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Catergory> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected, parent, false);
        TextView tvSelected = convertView.findViewById(R.id.tv_item_selected);
        Catergory catergory = this.getItem(position);
        if(catergory!=null)
        {
            tvSelected.setText(catergory.getName());

        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        TextView tvCatergory = convertView.findViewById(R.id.tv_category);
        TextView image = convertView.findViewById(R.id.image);
        Catergory catergory = this.getItem(position);
        if(catergory!=null)
        {
            tvCatergory.setText(catergory.getName());
            image.setBackgroundResource(catergory.getImage());
        }
        return convertView;
    }
}
