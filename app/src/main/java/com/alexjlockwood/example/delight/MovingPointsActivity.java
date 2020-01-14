package com.alexjlockwood.example.delight;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovingPointsActivity extends AppCompatActivity {



    @BindView(R.id.iv_moving_points)
    ImageView movingPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_points);
        ButterKnife.bind(this);

        AnimatedVectorDrawableCompat avd =
                AnimatedVectorDrawableCompat.create(this, R.drawable.avd_moving_points);

        movingPoints.setImageDrawable(avd);

        if(avd != null) {
            avd.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    movingPoints.post(avd::start);
                }
            });
            avd.start();
        }
    }

    private Observable<Long> createTickObservable(long updateInterval) {
        return Observable
                .interval(0, updateInterval, TimeUnit.MILLISECONDS, Schedulers.io());
    }
}