package com.example.service;

import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;

import java.util.List;

public interface OrdersGoodsService {

    Boolean save(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    Boolean deleteOrderGoods(Integer gid);

    Boolean deleteBatchOrderGoods(List<Integer> list);

    int selectCountByGid(Integer gid);
}
