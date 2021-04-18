package com.example.mapper;

import com.example.entity.GoodsSeckill;

import java.util.List;

public interface GoodsSeckillMapper {
    List<GoodsSeckill> selectAll();

    GoodsSeckill findById(Integer id);

    Integer  add(GoodsSeckill goodsSeckill);

    Integer  deleteById(Integer id);

    Integer  updateById(GoodsSeckill goodsSeckill);
}
