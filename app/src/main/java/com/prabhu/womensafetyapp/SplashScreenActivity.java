package com.prabhu.womensafetyapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    private int SLEEP_TIMER=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();

    }

    private class LogoLauncher extends Thread {public void run(){
        try {
            sleep(1000*SLEEP_TIMER);
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

}



