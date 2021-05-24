package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Orders;
import com.example.entity.OrdersSeckill;
import com.example.mapper.OrdersSeckillMapper;
import com.example.output.OrdersInfo;
import com.example.service.GoodsSeckillService;
import com.example.service.OrdersSeckillService;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-22
 */
@Service
public class OrdersSeckillServiceImpl extends ServiceImpl<OrdersSeckillMapper, OrdersSeckill> implements OrdersSeckillService {
    @Resource
    private OrdersSeckillMapper ordersSeckillMapper;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsSeckillService goodsSeckillService;

    @Override
    public int deleteByGsId(Integer gsId) {
        return ordersSeckillMapper.deleteByGsId(gsId);
    }

    @Override
    public int deleteBatchByGsId(List<Integer> list) {
        return ordersSeckillMapper.deleteBatchByGsId(list);
    }

    @Override
    public int deleteByOid(Integer oid) {
        return ordersSeckillMapper.deleteByOid(oid);
    }

    @Override
    public int deleteBatchByOid(List<Integer> list) {
        return ordersSeckillMapper.deleteBatchByOid(list);
    }

    @Override
    public boolean add(Integer uid, Integer gsId) {
        Orders orders = new Orders();
        orders.setUid(Long.valueOf(uid));
        ordersService.save(orders);
        OrdersSeckill ordersSeckill = new OrdersSeckill();
        ordersSeckill.setGsId(gsId);
        ordersSeckill.setOid(Long.valueOf(orders.getId()));
        System.out.println(ordersSeckill.getGsId());
        boolean b = goodsSeckillService.updateStockById(ordersSeckill.getGsId());
        if (b) {
            return this.save(ordersSeckill);
        }
        ordersService.deleteById(orders.getId());
        return false;
    }

    @Override
    public List<OrdersInfo> selectAll() {
        return ordersSeckillMapper.selectAll();
    }

}
