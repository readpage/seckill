package com.example.controller;

import com.example.entity.Goods;
import com.example.mapper.GoodsMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品信息管理")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsMapper goodsMapper;

    @ApiOperation("分页查询数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<Goods> selectAll(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }

    @ApiOperation("模糊查询商品")
    @GetMapping("/like/{name}/{pageSize}/{pageNum}")
    public PageInfo<Goods> findByGoodsnameLike(@PathVariable String name,
                                              @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(goodsMapper.findByNameLike(name));
    }

    @ApiOperation("通过名称查询商品")
    @GetMapping("/findByname/{name}")
    public Goods findByUsername(@PathVariable String name) {
        return goodsMapper.findByName(name);
    }

    @ApiOperation("通过id查询商品")
    @GetMapping("/findById/{id}")
    public Goods findById(@PathVariable Integer id) {
        return goodsMapper.findById(id);
    }

    @ApiOperation("添加商品,id不用填写!\uD83D\uDE42")
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        Integer n=goodsMapper.add(goods);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Integer n=goodsMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @ApiOperation("修改商品信息")
    @PutMapping("/update")
    public Result updateById(@RequestBody Goods goods) {
        Integer n=goodsMapper.updateById(goods);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
