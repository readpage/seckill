package com.example.service;

import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;
import com.example.utlis.PageInfo;

import java.util.List;

public interface OrdersGoodsService {

    Boolean save(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    Boolean deleteOrderGoods(Integer gid);

    Boolean deleteBatchOrderGoods(List<Integer> list);

    int selectCountByGid(Integer gid);

    PageInfo<OrdersInfo> likePage(int pageNum, int pageSize, String name, String number);

    List<String> likeNumber(String name, String number);

    List<String> likeName(String name);
}
