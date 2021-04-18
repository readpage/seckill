package com.example.mapper;

import com.example.entity.Orders;

import java.util.List;

public interface OrdersMapper {
    List<Orders> selectAll();

    Orders findById(Integer id);

    Integer add(Orders orders);

    Integer deleteById(Integer id);

    Integer updateById(Orders orders);
}
