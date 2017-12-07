package com.example.admin.trainingproject.orderedBroadcast;

import android.content.Context;
import android.content.Intent;

import com.example.admin.trainingproject.utils.Utils;


public class FirstBroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentvalue = intent.getStringExtra("Messsage") ;
        Utils.showToast(context , "FirstBroadcastReceiver"+intentvalue);
    }
}
