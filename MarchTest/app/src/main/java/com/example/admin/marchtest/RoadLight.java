package com.example.admin.marchtest;

import android.widget.TextView;

public class RoadLight {
    private String road;
    private String red;
    private String yellow;
    private String green;

    public RoadLight(String road, String red, String yellow, String green) {
        this.road = road;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getYellow() {
        return yellow;
    }

    public void setYellow(String yellow) {
        this.yellow = yellow;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }
}
