package com.cookandroid.and_0802_carlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    Context context;//mainactivity 저장 변수
    ArrayList<Movie> data;//데이터

    public MovieAdapter(Context context, ArrayList<Movie> data) {
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
        ImageView img = view.findViewById(R.id.imgPoster);
        TextView txttitle = view.findViewById(R.id.txtTitle);
        TextView txtgenre = view.findViewById(R.id.txtgenre);

        img.setImageDrawable(data.get(i).getImage());
        txttitle.setText(data.get(i).getTitle());
        txtgenre.setText(data.get(i).getGenre());
        return view;
    }
}
