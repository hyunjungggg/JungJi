package com.example.jungji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectPage extends AppCompatActivity {

    private Button btn_write,btn_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);

        btn_write = findViewById(R.id.btn_write);
        btn_select = findViewById(R.id.btn_select);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectPage.this , WritePage.class);
                startActivity(intent);
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectPage.this , SelectRegion.class);
                startActivity(intent);
            }
        });

    }

}