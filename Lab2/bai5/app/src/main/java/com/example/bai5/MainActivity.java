package com.example.bai5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Spinner spnCategory;
    CategoryAdapter categoryAdapter;
    GridView gridView;

    EditText get_name;
    CheckBox check_promote;
    Button buttonthem;

    int count;
    int anh;
    String tenmon;
    boolean is_pro;

    int[] imgarray ={
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view);
        get_name=findViewById(R.id.get_Name);
        check_promote =findViewById(R.id.check_promotion);
        buttonthem = findViewById(R.id.buttonthem);
        count=0;

        ArrayList<Dish> arrayList = new ArrayList<>();
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,R.layout.gridview_row,arrayList);

        gridView.setAdapter(gridViewAdapter);

        spnCategory = findViewById(R.id.spn_item_category);
        categoryAdapter = new CategoryAdapter(this,R.layout.item_selected, getListCategory());
        spnCategory.setAdapter(categoryAdapter);

        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                count=count+1;
                if(count>1) Toast.makeText(MainActivity.this, categoryAdapter.getItem(position).getName(),Toast.LENGTH_SHORT).show();
                anh=imgarray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buttonthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmon;
                boolean is_pro;
                tenmon = get_name.getText().toString();
                is_pro = check_promote.isChecked();
                Dish temp = new Dish(tenmon,anh,is_pro);
                arrayList.add(temp);
                gridViewAdapter.notifyDataSetChanged();
                get_name.getText().clear();
                check_promote.setChecked(false);
                Toast.makeText(MainActivity.this, "Add Successfull!!",Toast.LENGTH_SHORT).show();
                count=0;
                categoryAdapter = new CategoryAdapter(MainActivity.this,R.layout.item_selected, getListCategory());
                spnCategory.setAdapter(categoryAdapter);

            }
        });
    }

    private List<Catergory> getListCategory() {
        List<Catergory> List = new ArrayList<>();
        List.add(new Catergory("Thumbnail 1",R.drawable.a1));
        List.add(new Catergory("Thumbnail 2", R.drawable.a2));
        List.add(new Catergory("Thumbnail 3", R.drawable.a3));
        List.add(new Catergory("Thumbnail 4", R.drawable.a4));
        return List;
    }

}