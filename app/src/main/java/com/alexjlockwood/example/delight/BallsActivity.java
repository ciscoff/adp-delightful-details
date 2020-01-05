package com.alexjlockwood.example.delight;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BallsActivity extends AppCompatActivity {

//    @BindView(R.id.balls) ImageView ballsView;
    @BindView(R.id.iv_jumping_balls) ImageView jumpingBallsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balls);
        ButterKnife.bind(this);

        AnimatedVectorDrawableCompat avd =
        AnimatedVectorDrawableCompat.create(this, R.drawable.avd_jumping_balls);

        jumpingBallsView.setImageDrawable(avd);

        if(avd != null) {
            avd.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    jumpingBallsView.post(avd::start);
                }
            });
            avd.start();
        }
    }

//    @OnClick(R.id.balls)
//    void onClick() {
//        ((Animatable) ballsView.getDrawable()).start();
//    }
}