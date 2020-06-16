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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.qr_corona_tracker_app.CircularProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private Timer timer;
    private ImageView contentView;
    private CircularProgressBar progressBar;
    private int progress = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create and begin circular progress bar
        progressBar = findViewById(R.id.custom_progressBar);
        progressBar.setProgress(0);

        final long period = 100; // long variable used to set time limit of progress bar
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() { // Run function repeats every 100 ms
                // Variable progress gets updated every 100 ms until it reaches 100
                if (progress < 100) {
                    progressBar.setProgressWithAnimation(progress);
                    progress += 2;
                } else { // Reached end of progress
                    timer.cancel();
                    // Will transition to MainActivity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish(); // Close this activity
                }
            }
        }, 0, period);

    }
}
