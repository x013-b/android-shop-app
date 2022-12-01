package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    int[] zdjecia;
    String[] opisy;
    LayoutInflater layoutInflater;
    ImageView imageView;
    TextView textView;

    public SpinnerAdapter(Context context, int[] zdjecia, String[] opisy) {
        super();
        this.context = context;
        this.zdjecia = zdjecia;
        this.opisy = opisy;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return zdjecia.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.spinner_items , null);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);
        imageView.setImageResource(zdjecia[i]);
        textView.setText(opisy[i]);
        return view;

    }
}
