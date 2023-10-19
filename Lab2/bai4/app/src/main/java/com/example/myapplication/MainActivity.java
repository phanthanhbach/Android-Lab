package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    Employee employee;
    EditText nhapma,nhapten;
    CheckBox checkBox;
    Button them;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        nhapma = findViewById(R.id.nhapma);
        nhapten = findViewById(R.id.nhapten);
        checkBox=findViewById(R.id.checkbox_manager);
        them = findViewById(R.id.buttonthem);


        ArrayList<Employee> arrayList = new ArrayList<>();
        EmployeeAdapter adapter = new EmployeeAdapter(this, android.R.layout.simple_expandable_list_item_1,arrayList);
        listview.setAdapter(adapter);


        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = nhapma.getText().toString();
                String name= nhapten.getText().toString();
                Boolean manager = checkBox.isChecked();
                employee = new Employee(ID,name,manager);
                arrayList.add(employee);
                adapter.notifyDataSetChanged();
                checkBox.setChecked(false);
                nhapma.getText().clear();
                nhapten.getText().clear();
            }
        });
    }
}