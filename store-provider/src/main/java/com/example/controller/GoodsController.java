package com.example.controller;

import com.example.entity.Goods;
import com.example.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsMapper goodsMapper;

    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<Goods> selectAll(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }
}
