package com.example.output;

import java.util.Date;

public class OrdersInfo {
    private Integer id;
    private String username;
    private String number;
    private Date createDate;
    private String name;
    private Double price;
    private String img;
    private String store;
    private Integer count;
    private Date startDate;
    private Date endDate;
    private float discounts;
    private String phone;
    private Integer status;
    private Integer oid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getDiscounts() {
        return discounts;
    }

    public void setDiscounts(float discounts) {
        this.discounts = discounts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", number='" + number + '\'' +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", store='" + store + '\'' +
                ", count=" + count +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discounts=" + discounts +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", oid=" + oid +
                '}';
    }
}
