package com.example.mapper;

import com.example.domain.OrdersInfo;
import com.example.entity.OrdersGoods;

import java.util.List;

public interface OrdersGoodsMapper {
    int insert(OrdersGoods ordersGoods);

    List<OrdersInfo> page();
}
