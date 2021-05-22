package com.example.service.impl;

import com.example.entity.GoodsSeckill;
import com.example.entity.OrdersSeckill;
import com.example.mapper.GoodsSeckillMapper;
import com.example.service.GoodsSeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.OrdersSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class GoodsSeckillServiceImpl extends ServiceImpl<GoodsSeckillMapper, GoodsSeckill> implements GoodsSeckillService {
    @Resource
    private GoodsSeckillMapper goodsSeckillMapper;
    @Autowired
    private OrdersSeckillService ordersSeckillService;

    @Override
    public int deleteByGid(Integer gid) {
        Integer gsId = selectToId(gid);
        ordersSeckillService.deleteByGsId(gsId);
        return goodsSeckillMapper.deleteByGid(gid);
    }

    @Override
    public int deleteBatchByGid(List<Integer> list) {
        List<Integer> list1 = selectBatchToId(list);
        ordersSeckillService.deleteBatchByGsId(list1);
        return goodsSeckillMapper.deleteBatchByGid(list);
    }

    @Override
    public Integer selectToId(Integer gid) {
        return goodsSeckillMapper.selectToId(gid);
    }

    @Override
    public List<Integer> selectBatchToId(List<Integer> list) {
        return goodsSeckillMapper.selectBatchToId(list);
    }

    @Override
    public boolean updateStockByOrdersSeckill(OrdersSeckill ordersSeckill) {
        return goodsSeckillMapper.updateStockByOrdersSeckill(ordersSeckill)>0;
    }
}
