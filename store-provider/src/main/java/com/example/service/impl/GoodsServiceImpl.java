package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Goods;
import com.example.mapper.GoodsMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsSeckillService goodsSeckillService;

    @Override
    public Map<String, Object> myPage(Integer pageNum, Integer pageSize) {
        Page<Goods> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        goodsMapper.selectPage(page, wrapper);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", page.getRecords());
        resultMap.put("total", page.getTotal());
        return resultMap;
    }

    @Override
    public Result mySave(Goods goods) {
        int n = goodsMapper.insert(goods);
        if (n==1) {
            return ResultUtils.ok().message("添加成功😀!");
        }
        return ResultUtils.error().message("添加失败!😭");
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
    public List<Goods> like(String name) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        wrapper.select("*");
        return goodsMapper.selectList(wrapper);
    }

    @Override
    public Result myDeleteById(Integer id) {
        goodsSeckillService.deleteByGid(id);
        goodsMapper.deleteOrderGoods(id);
        int n = goodsMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public Result myDeleteBatchId(List<Integer> lists) {
        goodsSeckillService.deleteBatchByGid(lists);
        goodsMapper.deleteBatchOrderGoods(lists);
        int n = goodsMapper.deleteBatchIds(lists);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public boolean updateStock(Integer count) {
        return goodsMapper.updateStock(count)>0;
    }
}
