package com.example.qr_corona_tracker_app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class Splash extends AppCompatActivity {
    private Timer timer;
    private ImageView contentView;
    private CircularProgressBar progressBar;
    private int progress = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //contentView = findViewById(R.id.)
        progressBar = findViewById(R.id.custom_progressBar);

    }
}
