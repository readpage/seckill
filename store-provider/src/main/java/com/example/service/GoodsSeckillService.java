package com.example.service;

import com.example.entity.GoodsSeckill;
import com.example.response.Result;
import com.github.pagehelper.PageInfo;

public interface GoodsSeckillService {
    PageInfo<GoodsSeckill> selectAll(Integer pageSize,  Integer pageNum);

    GoodsSeckill findById(Integer id);

    Result add(GoodsSeckill goodsSeckill);

    Result deleteById(Integer id);

    Result updateById(GoodsSeckill goodsSeckill);
}
