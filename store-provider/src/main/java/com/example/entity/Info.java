package com.example.entity;

public class Info {
    private int userCount;
    private int goodsCount;
    private SalesType salesType;
    private double sales;
}

class SalesType {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String
    toString() {
        return "Sales{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
