package com.example.surfaceview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    MySurfaceView vi1;
    FrameLayout surfviewLayout;
    boolean threadState = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vi1 = new MySurfaceView(this);
        surfviewLayout = (FrameLayout) findViewById(R.id.surfview);
        surfviewLayout.addView(vi1);
        btn1 = (Button)findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!threadState){
                    threadState=true;
                    vi1.surfaceThreadStart(threadState);
                }else{
                    threadState=false;
                    vi1.surfaceThreadStart(threadState);
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
