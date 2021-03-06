package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Goods;
import com.example.entity.GoodsSeckill;
import com.example.entity.OrdersGoods;
import com.example.mapper.GoodsMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.example.service.GoodsService;
import com.example.service.OrdersGoodsService;
import com.example.utlis.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsSeckillService goodsSeckillService;
    @Autowired
    private OrdersGoodsService ordersGoodsService;

    @Override
    public PageInfo<Goods> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(goodsMapper.selectAll());
    }

    @Override
    public PageInfo<Goods> likePage(int pageNum, int pageSize, String name, String type) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> pageInfo =new PageInfo<>(goodsMapper.like(name, type));
        List<Goods> list = pageInfo.getList();
        for (int i = 0; i < list.size(); i++) {
            Goods goods= list.get(i);
            goods.setSales(ordersGoodsService.selectSales(goods.getId()));
            list.set(i, goods);
        }
        return pageInfo;
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public List<Goods> like(String name, String type) {
        return goodsMapper.like(name, type);
    }

    @Override
    public PageInfo<Goods> likeSeckillPage(int pageNum, int pageSize, String name, String type) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Goods> pageInfo =new PageInfo<>(goodsMapper.likeSeckill(name, type, new Date()));
        List<Goods> list = pageInfo.getList();
        for (int i = 0; i < list.size(); i++) {
            Goods goods= list.get(i);
            goods.setSales(ordersGoodsService.selectSales(goods.getId()));
            list.set(i, goods);
        }
        return pageInfo;
    }

    @Override
    public Boolean add(Goods goods) {
        goodsMapper.insert(goods);
        GoodsSeckill goodsSeckill = new GoodsSeckill();
        System.out.println("id");
        System.out.println(goods.getId());
        goodsSeckill.setGid(goods.getId());
        if (goodsSeckillService.save(goodsSeckill)) {
            return true;
        }
        goodsMapper.deleteById(goods.getId());
        return false;
    }

    @Override
    public Result myUpdateById(Goods goods) {
        int n = goodsMapper.updateById(goods);
        if (n==1) {
            return ResultUtils.ok().message("修改成功😀!");
        }
        return ResultUtils.error().message("修改失败!😭");
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (goodsSeckillService.deleteByGid(id)) {
            ordersGoodsService.deleteOrderGoods(id);
            return goodsMapper.deleteById(id)>0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatchId(List<Integer> list) {
        if (goodsSeckillService.deleteBatchByGid(list)) {
            ordersGoodsService.deleteBatchOrderGoods(list);
            return goodsMapper.deleteBatchIds(list)>0;
        }
        return false;
    }

    @Override
    public boolean updateStockByOrdersGoods(OrdersGoods ordersGoods) {
        return goodsMapper.updateStockByOrdersGoods(ordersGoods)>0;
    }

    @Override
    public List<String> selectType() {
        return goodsMapper.selectType();
    }

}
