package com.example.bai5;

public class Dish {
    String tenmon;
    int hinh;
    Boolean is_pro;

    Dish(String x, int y, Boolean z) {
        tenmon = x;
        hinh = y;
        is_pro = z;
    }

    public String getTenmon() {
        return tenmon;
    }

    public int getHinh() {
        return hinh;
    }

    public Boolean getIs_pro() {
        return is_pro;
    }
}
