package com.example.mapper;

import com.example.entity.Goods;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectAll();

    List<Goods> findByNameLike(String name);

    Goods findByName(String name);

    Goods findById(Integer id);

    Integer add(Goods goods);

    Integer deleteById(Integer id);

    Integer updateById(Goods goods);
}
