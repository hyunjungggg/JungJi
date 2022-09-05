package com.example.jungji;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewDetail extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_detail);

        Button bt_siteLink = findViewById(R.id.bt_siteLink);
        Button bt_kakaoLink = findViewById(R.id.bt_kakaoLink);
        Intent intent = getIntent();

        TextView location=(TextView) findViewById(R.id.tv_location);
        TextView storeName=(TextView) findViewById(R.id.tv_storeName);
        TextView orderTime=(TextView) findViewById(R.id.tv_orderTime);


        location.setText(intent.getStringExtra("location"));
        storeName.setText(intent.getStringExtra("storeName"));
        orderTime.setText(intent.getStringExtra("orderTime"));

        bt_siteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baemin.com/"));
                startActivity(intent);
            }
        });
        bt_kakaoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.kakao.com/o/g8i85age"));
                startActivity(intent);
            }
        });
    };
}


