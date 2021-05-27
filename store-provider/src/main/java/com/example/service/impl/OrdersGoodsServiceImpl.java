package com.example.service.impl;

import com.example.entity.OrdersGoods;
import com.example.mapper.OrdersGoodsMapper;
import com.example.output.OrdersInfo;
import com.example.service.OrdersGoodsService;
import com.example.utlis.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersGoodsServiceImpl implements OrdersGoodsService {
    @Resource
    private OrdersGoodsMapper ordersGoodsMapper;

    @Override
    public Boolean save(OrdersGoods ordersGoods) {
        return ordersGoodsMapper.insert(ordersGoods)>0;
    }

    @Override
    public List<OrdersInfo> selectAll() {
        return ordersGoodsMapper.selectAll();
    }

    @Override
    public Boolean deleteOrderGoods(Integer gid) {
        return ordersGoodsMapper.deleteOrderGoods(gid)>0;
    }

    @Override
    public Boolean deleteBatchOrderGoods(List<Integer> list) {
        return ordersGoodsMapper.deleteBatchOrderGoods(list)>0;
    }

    @Override
    public int selectCountByGid(Integer gid) {
        return ordersGoodsMapper.selectCountByGid(gid);
    }

    @Override
    public PageInfo<OrdersInfo> likePage(int pageNum, int pageSize, String name, String number) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(ordersGoodsMapper.like(name, number));
    }

    @Override
    public List<String> likeNumber(String name, String number) {
        return ordersGoodsMapper.likeNumber(name, number);
    }

    @Override
    public List<String> likeName(String name) {
        return ordersGoodsMapper.likeName(name);
    }
}
