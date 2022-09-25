package com.example.jungji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectRegion extends AppCompatActivity {
    private Button btn_select2;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;

    private ArrayAdapter<CharSequence> adapter_unsupport;
    private ArrayAdapter<CharSequence> adapter_jeonbuk;
    private ArrayAdapter<CharSequence> adapter_gunsan;
    private ArrayAdapter<CharSequence> adapter_miryong_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        Resources res = getResources();

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        adapter_unsupport = ArrayAdapter.createFromResource(this, R.array.region_unsupport, android.R.layout.simple_spinner_item);
        adapter_unsupport.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter_jeonbuk = ArrayAdapter.createFromResource(this, R.array.region_jeonbuk, android.R.layout.simple_spinner_item);
        adapter_jeonbuk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter_gunsan = ArrayAdapter.createFromResource(this, R.array.region_kunsan, android.R.layout.simple_spinner_item);
        adapter_gunsan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter_miryong_detail = ArrayAdapter.createFromResource(this, R.array.region_miryong_detail, android.R.layout.simple_spinner_item);
        adapter_miryong_detail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner2.setAdapter(adapter_unsupport);
        spinner3.setAdapter(adapter_unsupport);
        spinner4.setAdapter(adapter_unsupport);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch ((String) spinner1.getItemAtPosition(i)) {
                    case "전라북도":
                        spinner2.setAdapter(adapter_jeonbuk);
                        break;
                    default:
                        spinner2.setAdapter(adapter_unsupport);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch ((String) spinner2.getItemAtPosition(i)) {
                    case "군산시":
                        spinner3.setAdapter(adapter_gunsan);
                        break;
                    default:
                        spinner3.setAdapter(adapter_unsupport);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch ((String) spinner3.getItemAtPosition(i)) {
                    case "미원동":
                        spinner4.setAdapter(adapter_miryong_detail);
                        break;
                    default:
                        spinner4.setAdapter(adapter_unsupport);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_select2 = findViewById(R.id.btn_select2);
        btn_select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedLocation = spinner4.getSelectedItem().toString();
                if (selectedLocation.equals("지원 안함")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SelectRegion.this).create();
                    alertDialog.setTitle("경고");
                    alertDialog.setMessage("지원하지 않는 지역입니다.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(SelectRegion.this, ListViewActivity.class);
                    intent.putExtra("location",
                            spinner1.getSelectedItem().toString() + " "
                                    + spinner2.getSelectedItem().toString() + " "
                                    + spinner3.getSelectedItem().toString() + " "
                                    + spinner4.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });
    }
}