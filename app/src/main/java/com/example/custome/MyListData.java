package com.example.custome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListData extends BaseAdapter {
    private final int img[];
    private final String name[];
    Context context;

    public MyListData(Context context, int[] img1, String[] name1) {
        this.context = context;
        this.img = img1;
        this.name = name1;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.mylist,null);

        ImageView img1 =view1.findViewById(R.id.image);
        TextView name1 = view1.findViewById(R.id.text);

        img1.setImageResource(img[i]);
        name1.setText(name[i]);

        return view1;
    }
}
