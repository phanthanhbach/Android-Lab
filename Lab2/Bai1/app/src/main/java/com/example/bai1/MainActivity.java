package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        ListView list = (ListView) findViewById(R.id.lvperson);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter);
        final TextView text = (TextView) findViewById(R.id.txtselection);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        text.setText("position:" + i + " ;  value =" + arr[i]);
                        for(int t=0; t<adapterView.getChildCount(); t++)
                        {
                            if(t == i)
                            {
                                adapterView.getChildAt(t).setBackgroundColor(Color.rgb(110, 195, 201));
                            }
                            else
                            {
                                adapterView.getChildAt(t).setBackgroundColor(Color.WHITE);
                            }

                        }
                    }
                });
    }

}