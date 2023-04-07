package com.example.homnayangi.model;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Meal implements Serializable {
    @DrawableRes
    int thumbnail;
    String title;
    String description;

    public Meal(@DrawableRes int thumbnail, String title, String description) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
