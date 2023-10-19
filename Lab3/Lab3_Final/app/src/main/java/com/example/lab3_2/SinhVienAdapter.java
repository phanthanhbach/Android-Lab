package com.example.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {
    private List<SinhVien> listSV;
    private DatabaseHandler db;
    private Intent intent;

    public void setData(List<SinhVien> list) {
        this.listSV = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sv, parent, false);
        db = new DatabaseHandler(parent.getContext());
        return new SinhVienViewHolder(view, db);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
        SinhVien sv = listSV.get(position);
        if (sv == null) {
            return;
        }

        holder.id.setText(String.valueOf(sv.getId()));
        holder.name.setText(sv.getNameSV());
        holder.diemtb.setText(String.valueOf(sv.getDiemTB()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(view.getContext(), "Đã xóa: " + listSV.get(position), Toast.LENGTH_SHORT).show();
                    db.deleteSV(listSV.get(position));
                    listSV.remove(position);
                    notifyDataSetChanged();
                } else {
                    intent = new Intent(holder.itemView.getContext(), UpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", listSV.get(position).getId());
                    bundle.putString("name", listSV.get(position).getNameSV());
                    bundle.putFloat("diemtb", listSV.get(position).getDiemTB());
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

    public static class SinhVienViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView id, name, diemtb;
        private ImageView sv;
        private LinearLayout layout;
        private ItemClickListener itemClickListener;
        private DatabaseHandler db;

        public SinhVienViewHolder(@NonNull View itemView, DatabaseHandler db) {
            super(itemView);
            this.db = db;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            id = itemView.findViewById(R.id.idSV);
            name = itemView.findViewById(R.id.nameSV);
            diemtb = itemView.findViewById(R.id.diemTBSV);
            sv = itemView.findViewById(R.id.image);
            layout = itemView.findViewById(R.id.layout);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}