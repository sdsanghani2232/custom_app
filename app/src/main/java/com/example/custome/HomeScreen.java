package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView tv;
    Button log,del;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        tv = findViewById(R.id.tv);
        log = findViewById(R.id.loginout);
        del = findViewById(R.id.acc);

      SharedPreferences sp = getSharedPreferences("Demo", MODE_PRIVATE);
       String data = String.format("Name : %s\nId :%s\nAge :%s\nCollege name  :%s\nContact :%s",
               sp.getString("Name",""), sp.getString("id", ""),
               sp.getString("age", ""), sp.getString("clg", ""),
               sp.getString("con", ""));
        tv.setText(data);
        tv.setTextColor(Color.GREEN);

        log.setOnClickListener(view -> {
            SharedPreferences sp1 = getSharedPreferences("Demo" , MODE_PRIVATE);
            SharedPreferences.Editor editor = sp1.edit();
            editor.putBoolean("flag" , false);
            editor.apply();
            tv.setText("log out Successfully!!");
            tv.setTextColor(Color.RED);
            new Handler().postDelayed(() -> {
                Intent i = new Intent(HomeScreen.this,SharedPreferenceActivity.class);
                startActivity(i);
                finish();
            },2000);
        });

        del.setOnClickListener(view -> {
            SharedPreferences sharedPreferences =  getSharedPreferences("Demo",MODE_PRIVATE);
            SharedPreferences.Editor   editor = sharedPreferences.edit();
            editor.clear();
            editor.putBoolean("flag" , false);
            editor.apply();
            tv.setText("Delete Successfully!!");
            tv.setTextColor(Color.RED);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(HomeScreen.this,SharedPreferenceActivity.class);
                    startActivity(i);
                    finish();
                }
            },2000);
        });
    }
}