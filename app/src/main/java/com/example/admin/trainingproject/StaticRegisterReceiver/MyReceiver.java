package com.example.admin.trainingproject.StaticRegisterReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.admin.trainingproject.utils.Utils;


/**
 *
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message").toString();
        Utils.printLog("MyReceiver","MyReceiver"+message);
        Utils.showToast(context , ""+message);
        Intent intent1 = new Intent(context, Myservice.class);
        if(message.equalsIgnoreCase("song play")){
            context.startService(intent1);
        }else if (message.equalsIgnoreCase("song stop")){
            context.stopService(intent1);
        }

    }
}
