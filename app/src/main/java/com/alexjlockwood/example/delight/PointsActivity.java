package com.alexjlockwood.example.delight;

import android.os.Bundle;
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

public class PointsActivity extends AppCompatActivity {

    private static final int[] STATE_SET_P1 =
            {R.attr.state_point1};
    private static final int[] STATE_SET_P2 =
            {R.attr.state_point2,};
    private static final int[] STATE_SET_P3 =
            {R.attr.state_point3,};
    private static final int[] STATE_SET_P4 =
            {R.attr.state_point4};

    private static ArrayList<int[]> states = new ArrayList<>(
            Arrays.asList(STATE_SET_P4, STATE_SET_P1, STATE_SET_P2, STATE_SET_P3)
    );

    Disposable disposable = null;
    Observable<Long> ticks = null;

    @BindView(R.id.iv_blinking_points)
    ImageView blinkingPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        ButterKnife.bind(this);

        ticks = createTickObservable(400);
    }

    @Override
    protected void onResume() {
        super.onResume();

        disposable = ticks
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        l -> {
                            blinkingPoints.setImageState(states.get(0), false);
                            Collections.rotate(states, states.size() - 1);
                        },
                        e -> System.out.println("APP_TAG: " + e.getMessage())
                );
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private Observable<Long> createTickObservable(long updateInterval) {
        return Observable
                .interval(0, updateInterval, TimeUnit.MILLISECONDS, Schedulers.io());
    }
}