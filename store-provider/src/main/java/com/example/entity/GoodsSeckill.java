package com.example.entity;

import java.util.Date;

public class GoodsSeckill {
    private Long id;
    private double seckill_price;
    private int stock_count;
    private Date start_date;
    private Date end_date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSeckill_price() {
        return seckill_price;
    }

    public void setSeckill_price(double seckill_price) {
        this.seckill_price = seckill_price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "GoodsSeckill{" +
                "id=" + id +
                ", seckill_price=" + seckill_price +
                ", stock_count=" + stock_count +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
