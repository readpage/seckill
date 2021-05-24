package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.GoodsSeckill;
import com.example.mapper.GoodsSeckillMapper;
import com.example.output.GoodsSeckillInfo;
import com.example.service.GoodsSeckillService;
import com.example.service.GoodsService;
import com.example.service.OrdersSeckillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    private GoodsService goodsService;

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
    public boolean updateStockById(Integer gsId) {
        return goodsSeckillMapper.updateStockByOrdersSeckill(gsId)>0;
    }

    @Override
    public PageInfo<GoodsSeckill> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(goodsSeckillMapper.selectList(null));
    }

    @Override
    public boolean add(GoodsSeckill goodsSeckill) {
        boolean b = goodsService.updateStock(goodsSeckill.getStock());
        if (b) {
            return this.save(goodsSeckill);
        }
        return false;
    }

    @Override
    public List<GoodsSeckillInfo> selectAll() {
        return goodsSeckillMapper.selectAll();
    }
}
