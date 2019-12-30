package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BallsActivity extends AppCompatActivity {

    @BindView(R.id.balls) ImageView ballsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balls);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.balls)
    void onClick() {
        ((Animatable) ballsView.getDrawable()).start();
    }
}