package com.example.jungji.data.model;

import org.json.JSONObject;

public class ParticipantItem {

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    private String createdAt;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    
    public ParticipantItem(JSONObject o) {
        try {
            this.userId = o.get("userId").toString();
            this.userName = o.get("userName").toString();
            this.createdAt = o.get("createdAt").toString();
        } catch (Exception e) {

        };
    }

}