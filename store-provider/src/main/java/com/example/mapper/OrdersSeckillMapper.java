package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.OrdersSeckill;
import com.example.output.OrdersInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-22
 */
public interface OrdersSeckillMapper extends BaseMapper<OrdersSeckill> {
    int deleteByGsId(Integer gsId);

    int deleteBatchByGsId(List<Integer> list);

    int deleteByOid(Integer oid);

    int deleteBatchByOid(List<Integer> list);

    List<OrdersInfo> selectAll();
}
