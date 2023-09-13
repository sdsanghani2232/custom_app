package com.example.custome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class SharedPreferenceActivity extends AppCompatActivity {

    EditText name,id,clg,age,con;
    TextView tv;
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        clg = findViewById(R.id.clg_name);
        age = findViewById(R.id.age);
        con = findViewById(R.id.contact);
        tv = findViewById(R.id.tv);
        sub = findViewById(R.id.submit);
        checkData();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp =  getSharedPreferences("Demo",MODE_PRIVATE);
                SharedPreferences.Editor   editor = sp.edit();
                editor.putString("Name",name.getText().toString());
                editor.putString("id",id.getText().toString());
                editor.putString("clg",clg.getText().toString());
                editor.putString("age",age.getText().toString());
                editor.putString("con",con.getText().toString());
                editor.putBoolean("flag",true);
                editor.apply();
                name.setText("");
                age.setText("");
                clg.setText("");
                id.setText("");
                con.setText("");
                tv.setText("Loing Successfully!!");
                tv.setTextColor(Color.GREEN);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SharedPreferenceActivity.this,HomeScreen.class);
                        startActivity(i);
                        finish();
                    }
                },2000);
            }
        });
    }

    private void checkData() {
        SharedPreferences sp = getSharedPreferences("Demo",MODE_PRIVATE);
        if (sp.contains("Name"))
        {
            name.setText(sp.getString("Name",""));
            age.setText(sp.getString("age",""));
            clg.setText(sp.getString("clg",""));
            con.setText(sp.getString("con",""));
            id.setText(sp.getString("id",""));
        }else {
            tv.setText("Record not found");
            tv.setTextColor(Color.RED);
        }
    }
}