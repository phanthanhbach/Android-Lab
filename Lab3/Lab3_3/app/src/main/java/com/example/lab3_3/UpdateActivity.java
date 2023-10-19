package com.example.lab3_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    private EditText eid, ename, emalop, ediemtb;
    private Button nhap;
    DatabaseHandler db;
    Intent intent,intentMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_main);

        intent = getIntent();
        eid = findViewById(R.id.idUp);
        ename = findViewById(R.id.nameUp);
        ediemtb = findViewById(R.id.diemTBUp);
        nhap = findViewById(R.id.btnNhapUp);

        db = new DatabaseHandler(this);
        int id = intent.getIntExtra("id",0);
        float diemtb = intent.getFloatExtra("diemtb",0);
        eid.setText(String.valueOf(id));
        ename.setText(intent.getStringExtra("name"));
        ediemtb.setText(String.valueOf(diemtb));
        intentMain = new Intent(this,MainActivity.class);
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien();
                sv.setId((Integer.parseInt(eid.getText().toString())));
                sv.setNameSV(ename.getText().toString());
                sv.setDiemTB(Float.parseFloat(ediemtb.getText().toString()));
                db.updateSV(sv);
                startActivity(intentMain);
            }
        });
    }
}
