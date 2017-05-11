package com.example.viniciussevero.prenac2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                chamarLogin();
            }
        }, 2000);
    }

    public void chamarLogin(){
        Intent toLogin = new Intent(this, MainActivity.class);
        startActivity(toLogin);
        finish();
    }
}
