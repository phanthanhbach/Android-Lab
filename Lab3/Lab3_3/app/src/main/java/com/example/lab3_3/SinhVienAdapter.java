package com.example.lab3_3;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder>
{
    private List<SinhVien> listSV;
    DatabaseHandler db;
    Intent intent;
    public void setData(List<SinhVien> list)
    {
        this.listSV = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sv,parent,false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        SinhVien sv =listSV.get(position);
        if(sv==null)
        {
            return;
        }

        holder.id.setText(String.valueOf(sv.getId()));
        holder.name.setText(sv.getNameSV());
        holder.diemtb.setText(String.valueOf(sv.getDiemTB()));
        db = new DatabaseHandler(holder.itemView.getContext());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick) {
                    Toast.makeText(view.getContext(), "Đã xóa: "+listSV.get(position), Toast.LENGTH_SHORT).show();
                    db.deleteSV(listSV.get(position));
                    listSV.remove(position);
                    notifyDataSetChanged();
                }
                else
                {
                    intent = new Intent(holder.itemView.getContext(), UpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",listSV.get(position).getId());
                    bundle.putString("name",listSV.get(position).getNameSV());
                    bundle.putFloat("diemtb",listSV.get(position).getDiemTB());
                    intent.putExtras(bundle);
                    holder.itemView.getContext().startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listSV.size();
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        private TextView id, name, diemtb;
        private ImageView sv;
        private LinearLayout layout;
        private ItemClickListener itemClickListener;
        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener((View.OnClickListener) this);
            itemView.setOnLongClickListener((View.OnLongClickListener) this);
            id = itemView.findViewById(R.id.idSV);
            name = itemView.findViewById(R.id.nameSV);
            diemtb = itemView.findViewById(R.id.diemTBSV);
            sv = itemView.findViewById(R.id.image);
            layout = itemView.findViewById(R.id.layout);

        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}
