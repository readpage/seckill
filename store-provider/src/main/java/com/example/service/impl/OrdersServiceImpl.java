package com.example.service.impl;

import com.example.entity.Orders;
import com.example.mapper.OrdersMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public PageInfo<Orders> selectAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(ordersMapper.selectAll());
    }

    @Override
    public Orders findById(Integer id) {
        return ordersMapper.findById(id);
    }

    @Override
    public Result add(Orders orders) {
        Integer n = ordersMapper.add(orders);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @Override
    public Result deleteById(Integer id) {
        Integer n = ordersMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @Override
    public Result updateById(Orders orders) {
        Integer n = ordersMapper.updateById(orders);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
