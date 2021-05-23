package com.example.service.impl;

import com.example.domain.OrdersInfo;
import com.example.mapper.OrdersGoodsMapper;
import com.example.service.OrdersGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersGoodsServiceImpl implements OrdersGoodsService {
    @Resource
    private OrdersGoodsMapper ordersGoodsMapper;
    @Override
    public PageInfo<OrdersInfo> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(ordersGoodsMapper.page());
    }
}
