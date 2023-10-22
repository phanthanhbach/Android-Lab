package ptb.example.bth6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnExecute;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnExecute = findViewById(R.id.button); //Tìm lại button
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v){
                    Intent iNewActivity= new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(iNewActivity);
                overridePendingTransition(R.anim.anim_fade_in,R.anim.anim_move);
            }
        });

//        btnExecute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Main2Activity.execute();
//            }
//        });




    }

}