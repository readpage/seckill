package com.example.service.impl;

import com.example.entity.GoodsSeckill;
import com.example.mapper.GoodsSeckillMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsSeckillServiceImpl implements GoodsSeckillService {
    @Autowired
    private GoodsSeckillMapper goodsSeckillMapper;

    @Override
    public PageInfo<GoodsSeckill> selectAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsSeckill> goodsSeckills = goodsSeckillMapper.selectAll();
        return new PageInfo<>(goodsSeckills);
    }

    @Override
    public GoodsSeckill findById(Integer id) {
        return goodsSeckillMapper.findById(id);
    }

    @Override
    public Result add(GoodsSeckill goodsSeckill) {
        Integer n = goodsSeckillMapper.add(goodsSeckill);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @Override
    public Result deleteById(Integer id) {
        Integer n = goodsSeckillMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @Override
    public Result updateById(GoodsSeckill goodsSeckill) {
        Integer n = goodsSeckillMapper.updateById(goodsSeckill);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
