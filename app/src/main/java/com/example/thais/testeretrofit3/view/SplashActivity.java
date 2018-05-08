package com.example.thais.testeretrofit3.view;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thais.testeretrofit3.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();

    }

    private void apresentarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent telaPrincipal
                        = new Intent(SplashActivity.this,
                        MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}
