package com.example.service.impl;

import com.example.mapper.GoodsMapper;
import com.example.mapper.OrdersMapper;
import com.example.mapper.UserMapper;
import com.example.output.Info;
import com.example.output.SalesType;
import com.example.output.UserInfo;
import com.example.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Info selectInfo() {
        Info info = new Info();
        int userCount = userMapper.selectUserCount();
        List<SalesType> salesType = ordersMapper.selectSalesType();
        info.setUserCount(userCount);
        info.setSalesType(salesType);
        info.setGoodsCount(goodsMapper.selectGoodsCount());
        info.setOrdersCount(ordersMapper.selectOrdersCount());
        info.setSales(ordersMapper.selectSales());
        info.setGoodsStockCount(goodsMapper.selectGoodsStockCount());
        return info;
    }

    @Override
    public UserInfo selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
