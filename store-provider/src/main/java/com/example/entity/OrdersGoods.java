package com.example.entity;

import com.example.input.InOrdersGoods;

public class OrdersGoods {
    private int count;
    private int gid;
    private int oid;

    public OrdersGoods(InOrdersGoods inOrdersGoods) {
        this.gid = inOrdersGoods.getGid();
        this.count = inOrdersGoods.getCount();
    }

    public OrdersGoods() {
        super();
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }


    @Override
    public String toString() {
        return "OrdersGoods{" +
                "count=" + count +
                ", gid=" + gid +
                ", oid=" + oid +
                '}';
    }
}
