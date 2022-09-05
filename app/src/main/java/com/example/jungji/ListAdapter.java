package com.example.jungji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Item> data;
    private int layout;

    public ListAdapter(Context context, int layout, ArrayList<Item> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getLocation();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        Item friendsItem = data.get(position);

        TextView location = (TextView) convertView.findViewById(R.id.tv_location);
        location.setText(friendsItem.getLocation());

        TextView storeName = (TextView) convertView.findViewById(R.id.tv_storeName);
        storeName.setText(friendsItem.getStoreName());

        TextView orderTime = (TextView) convertView.findViewById(R.id.tv_orderTime);
        orderTime.setText(friendsItem.getOrderTime());


        return convertView;
    }
}