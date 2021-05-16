package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.mapper.OrdersMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public Result myDeleteBatchId(List<Integer> lists) {
        return null;
    }

    @Override
    public Map<String, Object> myPage(Integer pageNum, Integer pageSize) {
        Page<Orders> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        ordersMapper.selectPage(page, wrapper);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", page.getRecords());
        resultMap.put("total", page.getTotal());
        return resultMap;
    }

    @Override
    public Result save(User user) {
        return null;
    }

    @Override
    public Result deleteById(Integer id) {
        ordersMapper.deleteOrdersGoods(id);
        int n = ordersMapper.deleteById(id);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public Result deleteBatchId(List<Integer> list) {
        ordersMapper.deleteBatchOrdersGoods(list);
        int n = ordersMapper.deleteBatchIds(list);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public Result deleteByUId(Integer uid) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        wrapper.select("*");
        Orders orders = ordersMapper.selectOne(wrapper);
        return this.deleteById(Math.toIntExact(orders.getId()));
    }

    @Override
    public Result deleteBatchUId(List<Integer> list) {
        List<Orders> orders = ordersMapper.selectBatchUId(list);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            list1.add(orders.get(i).getId());
        }
        return this.deleteBatchId(list1);
    }

}
