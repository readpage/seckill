package com.example.service.impl;

import com.example.entity.Goods;
import com.example.mapper.GoodsMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> selectAll(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }

    @Override
    public PageInfo<Goods> findByGoodsnameLike(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(goodsMapper.findByNameLike(name));
    }

    @Override
    public Goods findByUsername(String name) {
        return goodsMapper.findByName(name);
    }

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.findById(id);
    }

    @Override
    public Result add(Goods goods) {
        Integer n=goodsMapper.add(goods);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @Override
    public Result deleteById(Integer id) {
        Integer n=goodsMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @Override
    public Result updateById(Goods goods) {
        Integer n=goodsMapper.updateById(goods);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
