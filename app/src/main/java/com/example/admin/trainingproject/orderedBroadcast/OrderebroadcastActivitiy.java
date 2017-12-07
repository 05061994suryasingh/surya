package com.example.admin.trainingproject.orderedBroadcast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.trainingproject.BaseActivity.BaseActivity;
import com.example.admin.trainingproject.R;


public class OrderebroadcastActivitiy extends BaseActivity {
    private Button btnlaunch ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_broadcast_activity);
        this.reference();
        this.setListenrs();
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void reference() {
        btnlaunch = (Button) findViewById(R.id.btnlaunch) ;

    }

    @Override
    public void setListenrs() {
        btnlaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Messsage" , "Launch");
                intent.setAction("orderedBroadcast") ;
                sendOrderedBroadcast(intent ,null);

            }
        });
    }
}
