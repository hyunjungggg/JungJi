package com.example.jungji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WritePage extends AppCompatActivity {

    private EditText et_location,et_name2, et_time,et_link,et_link2;
    private Button writebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_page);

        et_location = findViewById(R.id.et_location);
        et_name2 = findViewById(R.id. et_name2);
        et_time = findViewById(R.id.et_time);
        et_link = findViewById(R.id.et_link);
        et_link2 = findViewById(R.id.et_link2);

        writebutton = findViewById(R.id.writebutton);
        writebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = et_location.getText().toString();
                String storeName = et_name2.getText().toString();
                String orderTime = et_time.getText().toString();
                String siteLink = et_link.getText().toString();
                String kakaoLink = et_link2.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    private Intent Intent_intent;

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"글 등록에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(WritePage.this ,
                                        ListViewActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "글 등록에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                WriteRequest writeRequest = new WriteRequest(location,storeName,orderTime,siteLink,kakaoLink,responseListener);
                RequestQueue queue = Volley.newRequestQueue(WritePage.this);
                queue.add(writeRequest);

            }
        });


    }

}
