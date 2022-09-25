package com.example.jungji;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ParticipantRegisterRequest extends StringRequest{

    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://hjl704.dothome.co.kr/ParticipantRegister.php";
    private Map<String, String> map;

    public ParticipantRegisterRequest(String userID, String recruitmentId, Response.Listener<String> listener) {
        super(Method.POST, URL,listener, null);

        map = new HashMap<>();
        map.put("userId",userID);
        map.put("recruitmentId", recruitmentId);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
