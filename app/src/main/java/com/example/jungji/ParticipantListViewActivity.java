package com.example.jungji;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.jungji.data.model.ParticipantItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParticipantListViewActivity extends Activity implements View.OnClickListener {

    //private ArrayList<OrderItem> data = new ArrayList<>();

    private ParticipantListAdapter adapter;
    private ListView listView;
    private Button bt_kakaoLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        listView = (ListView) findViewById(R.id.listview);


        /* 리스트 속의 아이템 연결 */
        adapter = new ParticipantListAdapter(this, R.layout.participant_list_item);
        listView.setAdapter(adapter);
        bt_kakaoLink = (Button) findViewById(R.id.bt_kakaoLink);

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    try {
                        JSONArray dataArray = (JSONArray) response.get("result");
                        for (int i =0; i < dataArray.length(); i++) {
                            ParticipantItem item = new ParticipantItem((JSONObject)dataArray.get(i));
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
        ParticipantListViewDataRequest request = new ParticipantListViewDataRequest(responseListener, intent.getStringExtra("id"));
        RequestQueue queue = Volley.newRequestQueue(ParticipantListViewActivity.this);
        queue.add(request);

        /* 아이템 클릭시 작동 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
            }
        });

        bt_kakaoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ceo.baemin.com/"));
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View v) {
    }

}