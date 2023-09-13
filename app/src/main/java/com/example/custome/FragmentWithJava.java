package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentWithJava extends AppCompatActivity {

    Button a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_with_java);
        a = findViewById(R.id.btn_a);
        b = findViewById(R.id.btn_b);
        c = findViewById(R.id.btn_c);

        onLoad(new FiratFragment(),true);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoad(new FiratFragment(),false);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoad(new SecondFragment(),false);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoad(new FiratFragment(),false);
            }
        });
    }
    private void onLoad(Fragment f,boolean d) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(d)
        {
            fragmentTransaction.add(R.id.fragment,f);
        }else
        {
            fragmentTransaction.replace(R.id.fragment,f);
        }
        fragmentTransaction.commit();
    }
}