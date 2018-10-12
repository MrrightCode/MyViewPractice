package com.example.yangbin.myviewpractice;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;

import com.example.yangbin.myviewpractice.widget.SurfaceViewPractice;

/**
 * Created by yangbin on 2018/9/14.
 */
public class MainActivity extends AppCompatActivity {
    private Button mButton,mButton1,mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ScrollViewActivity.class));
                Log.d("slop", "onClick: "+ViewConfiguration.get(MainActivity.this).getScaledDoubleTapSlop());
            }
        });
        mButton1 = findViewById(R.id.button2);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SurfaceViewActicity.class));
            }
        });

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mButton1,"translationX",300);
        objectAnimator.setDuration(2000);
        objectAnimator.start();

        mButton2 = findViewById(R.id.button3);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SvgPracticeActivity.class));
            }
        });
    }
}
