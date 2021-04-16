package com.example.entity;

import java.util.Date;

public class Order {
    private long id;
    private String uid;
    private String gid;
    private Date create_date;
    private Date pay_date;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", gid='" + gid + '\'' +
                ", create_date=" + create_date +
                ", pay_date=" + pay_date +
                ", status='" + status + '\'' +
                '}';
    }
}
