package com.example.jungji.data.model;

import org.json.JSONObject;

public class RecruitmentItem {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String location;
    private String storeName;
    private String orderTime;
    private String siteURL;
    private String chatURL;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public String getChatURL() {
        return chatURL;
    }

    public void setChatURL(String chatURL) {
        this.chatURL = chatURL;
    }

    public RecruitmentItem(JSONObject o) {
        try {
            this.id = o.get("id").toString();
            this.location = o.get("location").toString();
            this.orderTime = o.get("orderTime").toString();
            this.storeName = o.get("storeName").toString();
            this.chatURL = o.get("chatURL").toString();
            this.siteURL = o.get("siteURL").toString();
        } catch (Exception e) {

        };
    }

}