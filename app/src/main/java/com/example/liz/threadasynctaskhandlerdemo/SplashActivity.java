package com.example.liz.threadasynctaskhandlerdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static final int delay = 2000;
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Intent goToMain = new Intent(SplashActivity.this,AppActivity.class);
            startActivity(goToMain);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(mRunnable,delay);
    }
}
