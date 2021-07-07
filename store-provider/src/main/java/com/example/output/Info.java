package com.example.output;

import java.util.List;

public class Info {
    private int userCount;
    private int goodsCount;
    private int goodsStockCount;
    private List<SalesType> salesType;
    private int ordersCount;
    private double sales;

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getGoodsStockCount() {
        return goodsStockCount;
    }

    public void setGoodsStockCount(int goodsStockCount) {
        this.goodsStockCount = goodsStockCount;
    }

    public List<SalesType> getSalesType() {
        return salesType;
    }

    public void setSalesType(List<SalesType> salesType) {
        this.salesType = salesType;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Info{" +
                "userCount=" + userCount +
                ", goodsCount=" + goodsCount +
                ", goodsStockCount=" + goodsStockCount +
                ", salesType=" + salesType +
                ", ordersCount=" + ordersCount +
                ", sales=" + sales +
                '}';
    }
}

