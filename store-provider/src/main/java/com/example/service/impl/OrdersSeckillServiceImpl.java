package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Orders;
import com.example.entity.OrdersSeckill;
import com.example.mapper.OrdersSeckillMapper;
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
    public boolean add(Integer uid, List<OrdersSeckill> list) {
        Orders orders = new Orders();
        orders.setUid(Long.valueOf(uid));
        ordersService.save(orders);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOid(Long.valueOf(orders.getId()));
        }
        for (int i = 0; i < list.size(); i++) {
            boolean b = goodsSeckillService.updateStockByOrdersSeckill(list.get(i));
            if (b) {

            }
        }
        return false;
    }

}
