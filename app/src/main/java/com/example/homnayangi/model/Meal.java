package com.example.homnayangi.model;

import java.io.Serializable;

public class Meal implements Serializable {
    String thumbnail;
    String title;
    String description;

    public Meal(String thumbnail, String title, String description) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
    }
}
