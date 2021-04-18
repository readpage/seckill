package com.example.service;

import com.example.entity.Goods;
import com.example.response.Result;
import com.github.pagehelper.PageInfo;

public interface GoodsService {

    PageInfo<Goods> selectAll(int pageSize, int pageNum);

    PageInfo<Goods> findByGoodsnameLike(String name, Integer pageSize, Integer pageNum);

    Goods findByUsername(String name);

    Goods findById(Integer id);

    Result add(Goods goods);

    Result deleteById(Integer id);

    Result updateById(Goods goods);
}
