package com.example.mapper;

import com.example.entity.GoodsSeckill;

import java.util.List;

public interface GoodsSeckillMapper {
    GoodsSeckill findById(Integer id);

    List<GoodsSeckill> selectAll();

    int add(GoodsSeckill goodsSeckill);

    int deleteById(int id);

    int updateById(GoodsSeckill goodsSeckill);
}
