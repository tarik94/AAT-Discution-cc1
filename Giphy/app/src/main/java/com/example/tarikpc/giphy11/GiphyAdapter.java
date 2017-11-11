package com.example.tarikpc.giphy11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tarik PC on 11-11-17.
 */

public class GiphyAdapter extends ArrayAdapter<Giphy> {
    public int _resource;

    public GiphyAdapter(Context context, int resource, List<Giphy> items) {
        super(context, resource, items);
        _resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LinearLayout newView;
        if(convertView == null){
            newView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater)getContext().getSystemService(inflater);
            layoutInflater.inflate(_resource, newView, true);
        } else {
            newView = (LinearLayout)convertView;
        }
        Giphy giphy = getItem(position);
        TextView title = (TextView)newView.findViewById(R.id.giphyTitle);
        title.setText(giphy.getTitle());
        return newView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }
}

