package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.example.input.InGoodsSeckill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-24
 */
@ApiModel(value="GoodsSeckill对象", description="")
public class GoodsSeckill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "秒杀商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer gsId;

    @ApiModelProperty(value = "商品gid")
    private Integer gid;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date startDate;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date endDate;

    @ApiModelProperty(value = "是否开启秒杀")
    private int status;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    public GoodsSeckill(InGoodsSeckill inGoodsSeckill) {
        this.gid = inGoodsSeckill.getGid();
        this.startDate = inGoodsSeckill.getStartDate();
        this.endDate = inGoodsSeckill.getEndDate();
    }

    public GoodsSeckill() {
        super();
    }

    public Integer getGsId() {
        return gsId;
    }

    public void setGsId(Integer gsId) {
        this.gsId = gsId;
    }

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoodsSeckill{" +
                "gsId=" + gsId +
                ", gid=" + gid +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
