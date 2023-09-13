package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class CustomGrideView extends AppCompatActivity {

    GridView gv;

    int img[] ={R.drawable.france,
            R.drawable.germany,
            R.drawable.india,
            R.drawable.spain,
            R.drawable.us
    };

    String name[] = {
            "France",
            "germany",
            "india",
            "spain",
            "us"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gride_view);
        gv =findViewById(R.id.custom_grid);

        Mygriddata mygriddata = new Mygriddata(this,img,name);
        gv.setAdapter(mygriddata);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomGrideView.this, name[i], Toast.LENGTH_SHORT).show();
            }
        });


    }
}