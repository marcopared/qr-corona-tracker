/**
 * Class to control splash screen (aka loading screen) of the application
 *
 * @author: Marco Paredes
 * @version: 1.0.0
 * @since 1.0
 */

package com.example.qr_corona_tracker_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private Timer timer;
    private ImageView icon;
    private CircularProgressBar progressBar;
    private int progress = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set imageView
        //icon.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nav_default_enter_anim));

        // Create and begin circular progress bar
        progressBar = (CircularProgressBar)findViewById(R.id.custom_progressBar);
        progressBar.setProgress(0);

        // Fade in


        final long period = 100; // long variable used to set time limit of progress bar
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // This repeats every 100 ms
                if (progress < 100) {
                    progressBar.setProgress(progress);
                    progress += 1;
                } else {
                    // Closing the timer
                    timer.cancel();
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Close this activity
                }
            }
        }, 0, period);

    }
}
