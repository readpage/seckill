package com.example.mapper;

import com.example.entity.GoodsSeckill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsSeckillMapper {
    List<GoodsSeckill> selectAll();

    GoodsSeckill findById(Integer id);

    Integer  add(GoodsSeckill goodsSeckill);

    Integer  deleteById(Integer id);

    Integer  updateById(GoodsSeckill goodsSeckill);
}
