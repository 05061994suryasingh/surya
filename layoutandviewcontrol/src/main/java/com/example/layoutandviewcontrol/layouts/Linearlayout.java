package com.example.layoutandviewcontrol.layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.layoutandviewcontrol.R;
import com.example.layoutandviewcontrol.utils.Utils;


public class Linearlayout extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        Utils.printLog(TAG  , "inside onCreate()");

        Utils.printLog(TAG  , "outside onCreate()");

    }


}
