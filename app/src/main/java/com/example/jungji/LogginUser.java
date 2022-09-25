package com.example.jungji;

import android.app.Application;

public class LogginUser extends Application {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
