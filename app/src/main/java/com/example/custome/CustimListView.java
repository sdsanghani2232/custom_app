package com.example.custome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustimListView extends AppCompatActivity {

    ListView lv;

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
        setContentView(R.layout.activity_custim_list_view);

        lv = findViewById(R.id.custom_list);

        MyListData myListData = new MyListData(this,img,name);
        lv.setAdapter(myListData);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(CustimListView.this, name[i], Toast.LENGTH_SHORT).show();
         }
        });
    }
}