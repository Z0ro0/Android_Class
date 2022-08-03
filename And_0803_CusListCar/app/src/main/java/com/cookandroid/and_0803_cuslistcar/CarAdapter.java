package com.cookandroid.and_0803_cuslistcar;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {

    Context context;//mainactivity 저장 변수
    ArrayList<Car> data;//데이터

    public CarAdapter(Context context, ArrayList<Car> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view = View.inflate(context, R.layout.listitem, null);
        }
        ImageView img = view.findViewById(R.id.imgCar);
        TextView txttitle = view.findViewById(R.id.txtCarName);

        img.setImageDrawable(data.get(i).getImage());
        txttitle.setText(data.get(i).getTitle());
        return view;
    }
}

