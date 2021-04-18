package com.example.service;

import com.example.entity.Orders;
import com.example.response.Result;
import com.github.pagehelper.PageInfo;

public interface OrdersService {

    PageInfo<Orders> selectAll(Integer pageSize, Integer pageNum);

    Orders findById(Integer id);

    Result add(Orders orders);

    Result deleteById(Integer id);

    Result updateById(Orders orders);

}
