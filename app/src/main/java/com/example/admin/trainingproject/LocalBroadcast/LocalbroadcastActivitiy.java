package com.example.admin.trainingproject.LocalBroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.admin.trainingproject.BaseActivity.BaseActivity;
import com.example.admin.trainingproject.R;
import com.example.admin.trainingproject.utils.Utils;
import java.util.Random;


public class LocalbroadcastActivitiy extends BaseActivity implements View.OnClickListener{
    private FirstLocalReceiver myReceiver ;
    private Random mRandom = new Random();
    private Button mButtonSend;
    private TextView mTextView;

    public LocalbroadcastActivitiy() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_activity);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        mButtonSend = (Button) findViewById(R.id.btn_send);
        mTextView   = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void setListenrs() {
        mButtonSend.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        myReceiver = new FirstLocalReceiver();
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(
                myReceiver,
                new IntentFilter("BROADCAST_RANDOM_NUMBER")
        );
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(myReceiver);
        super.onPause();
        //unregisterReceiver(myReceiver);


    }

    @Override
    protected void onDestroy() {
        Utils.printLog("DynamicRegisterActivity" , "inside onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        int randomNumber = mRandom.nextInt(500);

        // Initialize a new intent instance
        Intent intent = new Intent("BROADCAST_RANDOM_NUMBER");
        // Put the random number to intent to broadcast it
        intent.putExtra("RandomNumber",randomNumber);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        mTextView.setText("Random number generated : "
                + randomNumber );
    }
}
