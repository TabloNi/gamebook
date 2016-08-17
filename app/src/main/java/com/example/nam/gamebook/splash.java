package com.example.nam.gamebook;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(),2000);

    }
    private class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(), Login.class));
            splash.this.finish();
        }
    }
}
