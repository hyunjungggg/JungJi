package com.example.jungji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class SelectRegion extends AppCompatActivity {
    private Button btn_select2;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;

    private ArrayAdapter<CharSequence> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        Resources res = getResources();


        //spinnerAdapter = new ArrayAdapter<>(this, R.layout.activity_select_region,res.getStringArray(R.array.region));
        //spinnerAdapter.setDropDownViewResource(android.R.layout.activity_select_region);

        spinner = (Spinner)findViewById(R.id.spinner);
        //spinner.setAdapter(spinnerAdapter);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("test", "dddddd" + spinner.getItemAtPosition(i));

//               //spinner.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_select2 = findViewById(R.id. btn_select2);
        btn_select2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectRegion.this , ListViewActivity.class);
                startActivity(intent);
            }
        });
    }


}