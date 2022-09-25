package com.example.jungji;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ListViewDataRequest extends JsonObjectRequest{

    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://hjl704.dothome.co.kr/List.php";
    private Map<String, String> map;

    public ListViewDataRequest(Response.Listener<JSONObject> listener, String location) {
        super(Method.GET, URL+"?location="+location,null, listener, null);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
