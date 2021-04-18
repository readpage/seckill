package com.example.mapper;

import com.example.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    List<Orders> selectAll();

    Orders findById(Integer id);

    Integer add(Orders orders);

    Integer deleteById(Integer id);

    Integer updateById(Orders orders);
}
