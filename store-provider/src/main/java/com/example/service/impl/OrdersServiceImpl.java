package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Orders;
import com.example.entity.OrdersGoods;
import com.example.mapper.OrdersGoodsMapper;
import com.example.mapper.OrdersMapper;
import com.example.output.OrdersInfo;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersGoodsService;
import com.example.service.OrdersSeckillService;
import com.example.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private OrdersGoodsMapper ordersGoodsMapper;

    @Autowired
    private OrdersSeckillService ordersSeckillService;

    @Autowired
    private OrdersGoodsService ordersGoodsService;

    @Override
    public Result myDeleteBatchId(List<Integer> lists) {
        return null;
    }

    @Override
    public Result add(Long uid, List<OrdersGoods> products) {
        int r =0;
        Orders orders = new Orders();
        orders.setUid(uid);
        ordersMapper.insert(orders);
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setOid(orders.getId());
        }
        for (int i = 0; i < products.size(); i++) {
            if (ordersMapper.updateGoods(products.get(i))>0) {
                r=ordersGoodsMapper.insert(products.get(i));
            } else {
                ordersMapper.deleteById(orders.getId());
                return ResultUtils.error().message("购买失败!😭库存不足");
            }
        }

        if (r >= 1) {
            return ResultUtils.ok().message("购买成功😀!");
        }
        return ResultUtils.error().message("购买失败!😭");
    }

    @Override
    public Result deleteById(Integer id) {
        ordersSeckillService.deleteByOid(id);
        ordersMapper.deleteOrdersGoods(id);
        int n = ordersMapper.deleteById(id);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public Result deleteBatchId(List<Integer> list) {
        ordersSeckillService.deleteBatchByOid(list);
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

    @Override
    public boolean updateGoods(OrdersGoods ordersGoods) {
        return ordersMapper.updateGoods(ordersGoods) > 0;
    }

    @Override
    public List<OrdersInfo> selectAll() {
        List<OrdersInfo> list = ordersGoodsService.selectAll();
        List<OrdersInfo> list1 = ordersSeckillService.selectAll();
        List<OrdersInfo> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.addAll(list1);
        return list2;
    }

    @Override
    public PageInfo<OrdersInfo> page(int pageNum, int pageSize) {
        return new PageInfo<>();
    }

}
