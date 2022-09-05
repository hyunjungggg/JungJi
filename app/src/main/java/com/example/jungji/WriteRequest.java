package com.example.jungji;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WriteRequest extends StringRequest {

    final static private String URL = "http://hjl704.dothome.co.kr/Recruitment.php";
    private Map<String, String> map;

    public WriteRequest(String location, String store, String order_time, String site, String chat_url, Response.Listener<String> listener) {
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("location",location);
        map.put("store",store);
        map.put("order_time",order_time);
        map.put("site",site);
        map.put("chat_url",chat_url);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}