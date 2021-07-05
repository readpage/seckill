package com.example.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Goods输入模型", description="")
public class InGoods {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品价格")
    private Double price;

    @ApiModelProperty(value = "商品库存")
    private Integer stock;

    @ApiModelProperty(value = "商品店铺")
    private String store;

    @ApiModelProperty(value = "商品类型")
    private String type;


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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InGoods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", store='" + store + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
