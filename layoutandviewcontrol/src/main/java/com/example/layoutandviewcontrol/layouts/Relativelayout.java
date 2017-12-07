package com.example.layoutandviewcontrol.layouts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.layoutandviewcontrol.mainActivity.MainActivity;
import com.example.layoutandviewcontrol.R;
import com.example.layoutandviewcontrol.utils.Utils;


@SuppressLint("Registered")
public class Relativelayout extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Utils.printLog(TAG  , "inside onCreate()");
        Utils.printLog(TAG  , "outside onCreate()");
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent backMainTest = new Intent(this,MainActivity.class);
                startActivity(backMainTest);
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        } }
}
