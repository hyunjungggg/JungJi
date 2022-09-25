package com.example.jungji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jungji.data.model.ParticipantItem;
import com.example.jungji.data.model.RecruitmentItem;

import java.util.ArrayList;

public class ParticipantListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ParticipantItem> participantItemsList;
    private int layout;

    public ParticipantListAdapter(Context context, int layout) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.participantItemsList = new ArrayList<>();
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return participantItemsList.size();
    }

    @Override
    public ParticipantItem getItem(int position) {
        return participantItemsList.get(position);
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
        ParticipantItem item = participantItemsList.get(position);

        TextView userId = (TextView) convertView.findViewById(R.id.tv_user_id);
        userId.setText(item.getUserId());

        TextView userName = (TextView) convertView.findViewById(R.id.tv_user_name);
        userName.setText(item.getUserName());

        TextView orderTime = (TextView) convertView.findViewById(R.id.tv_orderTime);
        orderTime.setText(item.getCreatedAt());

        return convertView;
    }

    public void addItem(ParticipantItem item) {
        participantItemsList.add(item);
    }
}