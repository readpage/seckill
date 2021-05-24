package com.example.output;

import java.io.Serializable;
import java.util.Date;

public class GoodsSeckillInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String img;
    private String store;
    private Double price;
    private String type;
    private String stock;
    private Date createTime;
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OrdersSeckillInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", store='" + store + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", stock='" + stock + '\'' +
                ", createTime=" + createTime +
                ", endDate=" + endDate +
                '}';
    }
}
