package com.example.jungji;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

public class ParticipantListViewDataRequest extends JsonObjectRequest{

    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://hjl704.dothome.co.kr/OrderDetail.php";
    private Map<String, String> map;

    public ParticipantListViewDataRequest(Response.Listener<JSONObject> listener, String id) {
        super(Method.GET, URL+"?id="+id,null, listener, null);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
