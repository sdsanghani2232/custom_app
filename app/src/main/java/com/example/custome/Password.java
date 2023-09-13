package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Password extends AppCompatActivity {

    EditText tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        tv = findViewById(R.id.tv);
        bt = findViewById(R.id.sub);
        String s = "👍";
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s.equals(tv.getText().toString()))
                {
                    tv.setText("true");
                }

            }
        });
    }
}