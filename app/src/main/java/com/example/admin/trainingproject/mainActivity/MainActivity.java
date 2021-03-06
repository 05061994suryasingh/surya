package com.example.admin.trainingproject.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.trainingproject.BaseActivity.BaseActivity;
import com.example.admin.trainingproject.DynamicRegisterreceiver.DynamicRegisterActivity;
import com.example.admin.trainingproject.LocalBroadcast.LocalbroadcastActivitiy;
import com.example.admin.trainingproject.orderedBroadcast.OrderebroadcastActivitiy;
import com.example.admin.trainingproject.R;
import com.example.admin.trainingproject.StaticRegisterReceiver.StaticRegisterActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnDynamicReceiver , btnstaticReceiver ,btnlocalbrodcast ,btnorderedbroadcast ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        btnDynamicReceiver = (Button) findViewById(R.id.btnDynamicReceiver);
        btnstaticReceiver   = (Button) findViewById(R.id.btnstaticReceiver);
        btnlocalbrodcast = (Button) findViewById(R.id.btnlocalbrodcast);
        btnorderedbroadcast   = (Button) findViewById(R.id.btnorderedbroadcast);
    }

    @Override
    public void setListenrs() {
        btnDynamicReceiver.setOnClickListener(this);
        btnstaticReceiver.setOnClickListener(this);
        btnlocalbrodcast.setOnClickListener(this);
        btnorderedbroadcast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDynamicReceiver:
                Intent intent = new Intent(MainActivity.this , DynamicRegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnstaticReceiver:
                Intent intent1 = new Intent(MainActivity.this , StaticRegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnlocalbrodcast:
                Intent intent2 = new Intent(MainActivity.this , LocalbroadcastActivitiy.class);
                startActivity(intent2);
                break;
            case R.id.btnorderedbroadcast:
                Intent intent3 = new Intent(MainActivity.this , OrderebroadcastActivitiy.class);
                startActivity(intent3);
                break;
        }
    }
}
