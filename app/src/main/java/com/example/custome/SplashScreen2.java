package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences("Demo",MODE_PRIVATE);
                boolean check = sp.getBoolean("flag",false);

                Intent i;
                if(check)
                {
                    i = new Intent(SplashScreen2.this,HomeScreen.class);
                }
                else {
                    i = new Intent(SplashScreen2.this,SharedPreferenceActivity.class);
                }
                startActivity(i);
                finish();
            }
        },3000);
    }
}