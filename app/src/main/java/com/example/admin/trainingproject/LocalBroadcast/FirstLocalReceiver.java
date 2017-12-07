package com.example.admin.trainingproject.LocalBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.admin.trainingproject.utils.Utils;



public class FirstLocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int receivedNumber = intent.getIntExtra("RandomNumber",1);
        Utils.showToast(context , "Messsage"+receivedNumber);
    }
}
