package com.example.jungji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jungji.data.model.RecruitmentItem;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<RecruitmentItem> recruitmentItemsList;
    private int layout;

    public ListAdapter(Context context, int layout) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.recruitmentItemsList = new ArrayList<>();
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return recruitmentItemsList.size();
    }

    @Override
    public RecruitmentItem getItem(int position) {
        return recruitmentItemsList.get(position);
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
        RecruitmentItem friendsRecruitmentItem = recruitmentItemsList.get(position);

        TextView id = (TextView) convertView.findViewById(R.id.tv_id);
        id.setText(friendsRecruitmentItem.getId());

        TextView location = (TextView) convertView.findViewById(R.id.tv_location);
        location.setText(friendsRecruitmentItem.getLocation());

        TextView storeName = (TextView) convertView.findViewById(R.id.tv_storeName);
        storeName.setText(friendsRecruitmentItem.getStoreName());

        TextView orderTime = (TextView) convertView.findViewById(R.id.tv_orderTime);
        orderTime.setText(friendsRecruitmentItem.getOrderTime());


        return convertView;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(RecruitmentItem item) {
        recruitmentItemsList.add(item);
    }
}