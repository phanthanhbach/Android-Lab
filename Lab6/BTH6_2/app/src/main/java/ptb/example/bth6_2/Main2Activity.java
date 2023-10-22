package ptb.example.bth6_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;



    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewsByIds();
        initVariables();
//set start new activity when user clicks ivUitLogo;
        ivUitLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent iNewActivity= new Intent(Main2Activity.this,MainActivity.class);
            startActivity(iNewActivity);

            overridePendingTransition(R.anim.anim_fade_in,R.anim.anim_fade_out);}
        });

        //HandleClickAnimationXML
        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);
        //handelclickAnimationCode
        handleClickAnimationCode(btnFadeInCode,initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode,initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode,initBlinkAnimation());
    }
    //Fade out
    private AlphaAnimation initFadeOutAnimation() {
        AlphaAnimation animation=new AlphaAnimation(1f,0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private AlphaAnimation initFadeInAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private AlphaAnimation initBlinkAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setRepeatCount(3);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    //Fade in
    private void handleClickAnimationCode(Button btn, final Animation animation) {
        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }


    private void handleClickAnimationXml(Button btn, int animId)
    {
// Sinh viên tự sửa lại code cho phù hợp
        //fadein-out
        final Animation animation = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_fade_in);
        animation.setAnimationListener(animationListener);
        final Animation animation1 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_fade_out);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnFadeInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
        btnFadeOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation1);
            }
        });
        //blink
        final Animation animation2 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_blink);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnBlinkXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation2);
            }
        });
        //bounce
        final Animation animation4 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_bounce);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnBounceXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation4);
            }
        });
        //combine
        final Animation animation5 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_combine);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnCombineXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation5);
            }
        });
        //move
        final Animation animation6 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_move);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnMoveXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation6);
            }
        });
        //rotate
        final Animation animation7 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_rotate);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnRotateXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation7);
            }
        });
        //zoom in
        final Animation animation8 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_zoom_in);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnZoomInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation8);
            }
        });
        //zoomout
        final Animation animation9 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_zoom_out);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnZoomOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation9);
            }
        });
        //slieup
        final Animation animation10 = AnimationUtils.loadAnimation(Main2Activity.this,
                R.anim.anim_slide_up);
        animation.setAnimationListener(animationListener);
        //Handla onclickIIStenner to Start anination
        btnSlideUpXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation10);
            }
        });
    }



}