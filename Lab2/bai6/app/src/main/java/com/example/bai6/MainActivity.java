package com.example.bai6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Employee employee;
    EditText nhapma,nhapten;
    CheckBox checkBox;
    Button them;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listview);
        nhapma = findViewById(R.id.nhapma);
        nhapten = findViewById(R.id.nhapten);
        checkBox=findViewById(R.id.checkbox_manager);
        them = findViewById(R.id.buttonthem);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<Employee> arrayList = new ArrayList<>();
        EmployeeAdapter adapter = new EmployeeAdapter(this);

        recyclerView.setAdapter(adapter);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = nhapma.getText().toString();
                String name= nhapten.getText().toString();
                Boolean manager = checkBox.isChecked();
                System.out.println("Đây là id:"+ID);
                System.out.println("Đây là tên:"+name);
                System.out.println("Đây là manager:"+manager);
                employee = new Employee(ID,name,manager);
                arrayList.add(employee);
                adapter.setData(arrayList);
               //adapter.notifyDataSetChanged();
                checkBox.setChecked(false);
                nhapma.getText().clear();
                nhapten.getText().clear();
            }
        });
    }
}