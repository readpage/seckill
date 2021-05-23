package com.example.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="GoodsSeckill输入参数模型", description="")
public class InGoodsSeckill {

    @ApiModelProperty(value = "商品gid")
    private Integer gid;

    @ApiModelProperty(value = "秒杀价")
    private Double seckillPrice;

    @ApiModelProperty(value = "库存数量")
    private Integer stock;

    @ApiModelProperty(value = "秒杀开始时间", example = "2021-05-23 22:10:00")
    private Date startDate;

    @ApiModelProperty(value = "秒杀结束时间", example = "2021-05-23 22:22:00")
    private Date endDate;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    @Override
    public String toString() {
        return "InGoodsSeckill{" +
                "gid=" + gid +
                ", seckillPrice=" + seckillPrice +
                ", stock=" + stock +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
