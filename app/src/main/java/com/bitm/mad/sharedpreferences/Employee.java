package com.bitm.mad.sharedpreferences;

public class Employee {
    private String name;
    private int age;
    private String mobileNum;

    public Employee(String name, int age, String mobileNum) {
        this.name = name;
        this.age = age;
        this.mobileNum = mobileNum;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNum() {
        return mobileNum;
    }
}
