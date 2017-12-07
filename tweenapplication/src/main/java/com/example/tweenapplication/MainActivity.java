package com.example.tweenapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView sun = (ImageView) findViewById(R.id.imgsun);
        Animation sunRise = AnimationUtils.loadAnimation(this, R.anim.sunrise);
        sun.startAnimation(sunRise);
        ImageView clock = (ImageView) findViewById(R.id.clock);
        ImageView hour  = (ImageView) findViewById(R.id.hour);
        Animation hourkanim = AnimationUtils.loadAnimation(this, R.anim.houranim);
        Animation clockanim = AnimationUtils.loadAnimation(this, R.anim.clock);
        clock.startAnimation(clockanim);
        hour.setAnimation(hourkanim);
                }
                }
