package com.alexjlockwood.example.delight;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GeometryActivity extends AppCompatActivity {

    @BindView(R.id.geometry) ImageView geometryView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.geometry)
    void onClick() {
        ((Animatable) geometryView.getDrawable()).start();
    }
}

