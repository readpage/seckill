package com.example.entity;

import java.util.Date;

public class GoodsSeckill {
    private Long id;
    private double seckillPrice;
    private int stockCount;
    private Date startDate;
    private Date end_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
                ", seckillPrice=" + seckillPrice +
                ", stockCount=" + stockCount +
                ", startDate=" + startDate +
                ", end_date=" + end_date +
                '}';
    }
}
