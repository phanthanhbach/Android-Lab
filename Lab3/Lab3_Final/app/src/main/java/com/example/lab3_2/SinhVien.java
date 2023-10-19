package com.example.lab3_2;

public class SinhVien {
    int id;
    String nameSV;
    float diemTB;

    public SinhVien() {
    }

    public SinhVien(int id, String nameSV, float diemTB) {
        this.id = id;
        this.nameSV = nameSV;
        this.diemTB = diemTB;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }


    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }
    @Override
    public String toString() {
        return "ID: " + this.id + ", Ten SV: " + this.nameSV  + ", Diem TB: "+ this.diemTB;
    }
}
