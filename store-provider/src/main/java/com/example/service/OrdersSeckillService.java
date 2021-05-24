package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.OrdersSeckill;
import com.example.output.OrdersInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-22
 */
public interface OrdersSeckillService extends IService<OrdersSeckill> {
    int deleteByGsId(Integer gsId);

    int deleteBatchByGsId(List<Integer> list);

    int deleteByOid(Integer oid);

    int deleteBatchByOid(List<Integer> list);

    boolean add(Integer uid, Integer gsId);

    List<OrdersInfo> selectAll();

}
