package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Orders;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    int deleteBatchUid(List<Integer> list);

    int deleteOrdersGoods(Integer oid);

    int deleteBatchOrdersGoods(List<Integer> list);

    List<Orders> selectBatchUId(List<Integer> list);
}
