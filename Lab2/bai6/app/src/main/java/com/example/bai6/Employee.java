package com.example.bai6;

public class Employee {
    String id;
    String fullname;
    Boolean ismanger;
    Employee(String x, String y, Boolean z)
    {
        id=x;
        fullname=y;
        ismanger=z;
    }

    public String getFullName()
    {
        return fullname;
    }

    public Boolean isManager()
    {
        return ismanger;
    }

}
