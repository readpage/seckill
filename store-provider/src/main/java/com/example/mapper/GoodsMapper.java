package com.example.mapper;

import com.example.entity.Goods;
import com.example.entity.Order;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectAll();

    Goods findByUsername(String username);

    Goods findById(Integer id);

    int add(Goods goods);

    int deleteById(int id);

    int updateById(Order order);
}
