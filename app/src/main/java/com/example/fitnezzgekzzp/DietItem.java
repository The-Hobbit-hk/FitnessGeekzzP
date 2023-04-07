package com.example.fitnezzgekzzp;

import java.util.List;

public class DietItem {
    private int icon;
    private String title;
    private String description;

    public DietItem(int icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public DietItem(String s, List<DietItem> preWorkout) {

    }

    public int getIconId() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getIconResId() {
        return icon;
    }
}
