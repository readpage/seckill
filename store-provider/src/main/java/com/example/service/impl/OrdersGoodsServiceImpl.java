package com.example.service.impl;

import com.example.mapper.OrdersGoodsMapper;
import com.example.output.OrdersInfo;
import com.example.service.OrdersGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersGoodsServiceImpl implements OrdersGoodsService {
    @Resource
    private OrdersGoodsMapper ordersGoodsMapper;

    @Override
    public List<OrdersInfo> selectAll() {
        return ordersGoodsMapper.selectAll();
    }
}
