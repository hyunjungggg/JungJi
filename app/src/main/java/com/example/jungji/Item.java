package com.example.jungji;

import java.util.Collection;

public class Item {
    private String location;
    private String storeName;
    private String orderTime;


    public String getLocation() {
        return location;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getOrderTime() {
        return orderTime;
    }


    public Item(String location, String storeName, String orderTime) {

        this.location = location;
        this.storeName = storeName;
        this.orderTime = orderTime;

    }

}