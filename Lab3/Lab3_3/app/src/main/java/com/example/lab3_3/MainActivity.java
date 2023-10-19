package com.example.lab3_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView view;
    private SinhVienAdapter adapter;
    private List<SinhVien> listSV;
    private Button btnNhap;
    private EditText editid, editname, editdiemtb;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.rycleview);
        editid = findViewById(R.id.id);
        editname = findViewById(R.id.name);
        editdiemtb = findViewById(R.id.diemTB);
        btnNhap = findViewById(R.id.btnNhap);
        db = new DatabaseHandler(this);
        adapter = new SinhVienAdapter();

        listSV = db.getAllSV();

        adapter.setData(listSV);
        view.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(linearLayoutManager);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien();
                sv.setId((Integer.parseInt(editid.getText().toString())));
                sv.setNameSV(editname.getText().toString());
                sv.setDiemTB(Float.parseFloat(editdiemtb.getText().toString()));
                db.addSV(sv);
                listSV.add(sv);
                adapter.notifyDataSetChanged();
            }
        });

    }
}