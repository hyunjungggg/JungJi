package com.example.jungji;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class WritePage extends AppCompatActivity {

    private TextView region_main;
    private EditText et_name2,et_link,et_link2;
    private Spinner sp_location;
    private Button writebutton;
    private TimePicker tp_order_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_page);

        region_main = (TextView) findViewById(R.id.region_main);

        sp_location = (Spinner) findViewById(R.id.sp_location);
        et_name2 = findViewById(R.id. et_name2);

        tp_order_time = findViewById(R.id.tp_order_time);


        et_link = findViewById(R.id.et_link);
        et_link2 = findViewById(R.id.et_link2);

        sp_location.setSelection(0);
        sp_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        writebutton = findViewById(R.id.writebutton);
        writebutton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                String location = region_main.getText() + " " + sp_location.getSelectedItem().toString();
                String storeName = et_name2.getText().toString();
                String orderTime = (tp_order_time.getHour()) + ":" + (tp_order_time.getMinute());
                String siteLink = et_link.getText().toString();
                String kakaoLink = et_link2.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"글 등록에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(WritePage.this ,
                                        ListViewActivity.class);
                                intent.putExtra("location",region_main.getText() + " " + sp_location.getSelectedItem().toString());
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
