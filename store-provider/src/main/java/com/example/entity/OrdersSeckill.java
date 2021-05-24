package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-22
 */
@ApiModel(value="OrdersSeckill实体类", description="")
public class OrdersSeckill implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "抢购id")
    @TableField("gsId")
    private Integer gsId;

    @ApiModelProperty(value = "抢购订单oid")
    private Long oid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGsId() {
        return gsId;
    }

    public void setGsId(Integer gsId) {
        this.gsId = gsId;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }


    @Override
    public String toString() {
        return "OrdersSeckill{" +
        "id=" + id +
        ", gsid=" + gsId +
        ", oid=" + oid +
        "}";
    }
}
