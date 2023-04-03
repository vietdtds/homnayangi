package com.example.homnayangi.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    String title;
    List<Meal> meals;

    public Menu(String title, List<Meal> meals) {
        this.title = title;
        this.meals = meals;
    }
}
