package com.example.mapper;

import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;

import java.util.List;

public interface OrdersGoodsMapper {
    int insert(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    int deleteOrderGoods(Integer gid);

    int deleteBatchOrderGoods(List<Integer> list);
}
