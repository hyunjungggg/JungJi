package com.example.jungji;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ListViewDetail extends Activity {


    private TextView recruitmentId;
    private TextView location;
    private TextView storeName;
    private TextView orderTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_detail);

        Button bt_siteLink = findViewById(R.id.bt_siteLink);

        Intent intent = getIntent();

        recruitmentId = (TextView) findViewById(R.id.tv_recruitment);
        location = (TextView) findViewById(R.id.tv_location);
        storeName = (TextView) findViewById(R.id.tv_storeName);
        orderTime = (TextView) findViewById(R.id.tv_orderTime);

        recruitmentId.setText(intent.getStringExtra("id"));
        location.setText(intent.getStringExtra("location"));
        storeName.setText(intent.getStringExtra("storeName"));
        orderTime.setText(intent.getStringExtra("orderTime"));

        bt_siteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"해당 주문에 참가합니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ListViewDetail.this, ParticipantListViewActivity.class);
                                intent.putExtra("id", recruitmentId.getText());
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "주문 참가에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Intent Intent_intent = getIntent();
                ParticipantRegisterRequest registerRequest = new ParticipantRegisterRequest(((LogginUser)getApplicationContext()).getUserId(),Intent_intent.getStringExtra("id"),responseListener);
                RequestQueue queue = Volley.newRequestQueue(ListViewDetail.this);
                queue.add(registerRequest);
            }
        });
    }

    ;
}


