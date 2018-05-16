package com.example.admin.materialtest;

/**
 * Created by admin on 2018/3/27.
 */

public class Fruit {
    public Fruit(String name, int imaged) {
        this.name = name;
        this.imaged = imaged;
    }

    private String name;

    public String getName() {
        return name;
    }

    public int getImaged() {
        return imaged;
    }

    private int imaged;
}
