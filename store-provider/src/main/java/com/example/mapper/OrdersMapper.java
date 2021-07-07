package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Orders;
import com.example.entity.OrdersGoods;
import com.example.output.SalesType;

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

    int insertOrdersWithGoods();

    int updateGoods(OrdersGoods ordersGoods);

    int selectOrdersCount();

    double selectSales();

    List<SalesType> selectSalesType();
}
