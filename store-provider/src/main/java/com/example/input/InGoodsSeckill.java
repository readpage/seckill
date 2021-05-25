package com.example.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class InGoodsSeckill {
    @ApiModelProperty(value = "商品gid")
    private Integer gid;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date startDate;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date endDate;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
