package com.example.admin.trainingproject.StaticRegisterReceiver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.admin.trainingproject.R;
import com.example.admin.trainingproject.utils.Utils;


/**
 *
 */

public class Myservice extends Service implements MediaPlayer.OnCompletionListener{
    private MediaPlayer mediaPlayer ;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Utils.printLog("Myservice" ,"inside onCreate");
        mediaPlayer= MediaPlayer.create(this , R.raw.kabil);
        mediaPlayer.setOnCompletionListener(this);
        Utils.printLog("Myservice" ,"outside onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
        Utils.printLog("Myservice","service completed");

    }
}
