package com.example.jungji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends Activity implements View.OnClickListener {

    private ArrayList<Item> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listview);

        data = new ArrayList<>();

        Item item1 = new Item("전라북도 군산시 미룡동 주공1단지","bhc","5/30 2:30 PM");
        Item item2 = new Item("전라북도 군산시 미룡동 군산대학교", "엽떡 군산대점","5/30 9:10 PM");
        Item item3 = new Item("전라북도 군산시 수송동 주공1차", "네네치킨 수송점","5/30 7:30 PM");
        Item item4 = new Item("전라북도 군산시 월명동 월명공원", "라라코스트 월명점","5/30 8:40 PM");
        Item item5 = new Item("전라북도 군산시 미룡동 미룡그린빌2단지", "리조또","5/30 9:30 PM");

        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);


        /* 리스트 속의 아이템 연결 */
        ListAdapter adapter = new ListAdapter(this, R.layout.listview_list_item, data);
        listView.setAdapter(adapter);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListViewDetail.class);
                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                intent.putExtra("location", data.get(position).getLocation());
                intent.putExtra("storeName", data.get(position).getStoreName());
                intent.putExtra("orderTime", data.get(position).getOrderTime());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
    }

}