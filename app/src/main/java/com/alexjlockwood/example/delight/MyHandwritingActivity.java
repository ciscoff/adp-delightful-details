package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class MyHandwritingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_handwriting);
        ButterKnife.bind(this);
        ((Animatable) ((ImageView) findViewById(R.id.myIcon)).getDrawable()).start();
    }

}
