package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class DesignActivity extends AppCompatActivity {
    /**
     * https://stackoverflow.com/questions/41767676/how-to-restart-android-animatedvectordrawables-animations
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
        ((Animatable) ((ImageView) findViewById(R.id.designIconLeft)).getDrawable()).start();
        ((Animatable) ((ImageView) findViewById(R.id.designIconRight)).getDrawable()).start();
        ((Animatable) ((ImageView) findViewById(R.id.textIcon)).getDrawable()).start();

    }
}
