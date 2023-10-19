package com.example.bai5;

import android.graphics.drawable.Drawable;


public class Catergory {
    String name;
    int thumbnail;
    Boolean is_promote;

    public Catergory(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public  int getImage()
    {
        return thumbnail;
    }
}
