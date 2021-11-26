package com.lamaq.counter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button add, sub, reset, color;
    TextView textView;
    int counter = 0;
    private AdView mAdView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        reset = findViewById(R.id.reset);
        color = findViewById(R.id.color);
        textView = findViewById(R.id.textView);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.tick);

        add.setOnClickListener(v -> {
//                String text = textView.getText().toString();
//                int num = Integer.parseInt(text);
//                num++;
//                textView.setText(num);
            counter++;
            mp.start();
            textView.setText(Integer.toString(counter));
        });
        sub.setOnClickListener(v -> {
//                String text = textView.getText().toString();
//                int num = Integer.parseInt(text);
//                num--;
//                textView.setText(num);
            counter--;
            mp.start();
            textView.setText(Integer.toString(counter));
        });
        reset.setOnClickListener(v -> {
           
            counter = 0;
            textView.setText(Integer.toString(counter));
        });
        color.setOnClickListener(v -> {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            View lay = (View) findViewById(R.id.lay);
            lay.setBackgroundColor(color);
        });
    }
}