package com.example.admin.trainingproject.DynamicRegisterreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.admin.trainingproject.utils.Utils;

public class MyDynamicRegisterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message").toString();
        Utils.showToast(context , ""+message);
        Intent intent1 = new Intent(context, Myservice1.class);
        context.startService(intent1);
        if(message.equalsIgnoreCase(" song play")){
            context.startService(intent1);
        }else if (message.equalsIgnoreCase("song stop")){
            context.stopService(intent1);
        }
    }
}
