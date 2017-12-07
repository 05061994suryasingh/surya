package com.example.layoutandviewcontrol.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.layoutandviewcontrol.R;
import com.example.layoutandviewcontrol.layouts.FrameLayout;
import com.example.layoutandviewcontrol.layouts.Linearlayout;
import com.example.layoutandviewcontrol.layouts.Relativelayout;
import com.example.layoutandviewcontrol.layouts.TableLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
private Button btnRelativeLayout, btnFrameLayout, btnTableLayout,btnLinearLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListener();
    }

    private void setListener() {
        btnRelativeLayout.setOnClickListener(this);
        btnFrameLayout.setOnClickListener(this);
        btnTableLayout.setOnClickListener(this);
        btnLinearLayout.setOnClickListener(this);
    }

    private void reference() {
        btnRelativeLayout   = (Button) findViewById(R.id.btnRelativeLayout);
        btnFrameLayout      = (Button) findViewById(R.id.btnfLayout);
        btnTableLayout      = (Button) findViewById(R.id.btntLayout);
        btnLinearLayout     = (Button) findViewById(R.id.btnLinearLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLinearLayout :
                startActivity(new Intent(MainActivity.this , Linearlayout.class));
                break;
            case R.id.btnRelativeLayout :
                startActivity(new Intent(MainActivity.this , Relativelayout.class));
                break;
            case R.id.btnfLayout :
                startActivity(new Intent(MainActivity.this , FrameLayout.class));
                break ;
            case R.id.btntLayout :
                startActivity(new Intent(MainActivity.this , TableLayout.class));
                break ;
        }
    }
}
