package com.example.jungji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.jungji.data.model.RecruitmentItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListViewActivity extends Activity implements View.OnClickListener {

    //private ArrayList<OrderItem> data = new ArrayList<>();

    private ListAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listview);

        /* 리스트 속의 아이템 연결 */
        adapter = new ListAdapter(this, R.layout.listview_list_item);
        listView.setAdapter(adapter);

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    try {
                        JSONArray dataArray = (JSONArray) response.get("result");
                        for (int i =0; i < dataArray.length(); i++) {
                            RecruitmentItem item = new RecruitmentItem((JSONObject)dataArray.get(i));
                            adapter.addItem(item);
                        }
                    }  catch (JSONException e) {}
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Intent intent = getIntent();
        ListViewDataRequest request = new ListViewDataRequest(responseListener, intent.getStringExtra("location"));
        RequestQueue queue = Volley.newRequestQueue(ListViewActivity.this);
        queue.add(request);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListViewDetail.class);

                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                RecruitmentItem item = adapter.getItem(position);
                intent.putExtra("id", item.getId());
                intent.putExtra("location", item.getLocation());
                intent.putExtra("storeName", item.getStoreName());
                intent.putExtra("orderTime", item.getOrderTime());


                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
    }

}