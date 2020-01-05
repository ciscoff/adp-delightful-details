package com.alexjlockwood.example.delight;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        ((Animatable) ((ImageView) findViewById(R.id.spinnerOutIcon)).getDrawable()).start();
        ((Animatable) ((ImageView) findViewById(R.id.textIcon)).getDrawable()).start();

    }
}
