package com.example.input;

public class InOrdersGoods {
    private int count;
    private int gid;

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
        return "InOrdersGoods{" +
                "count=" + count +
                ", gid=" + gid +
                '}';
    }
}
