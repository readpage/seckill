package com.example.controller;


import com.example.entity.Goods;
import com.example.input.InGoods;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
@RestController
@Api(tags = "商品信息管理")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation("分页查询数据")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<Goods> page(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return goodsService.page(pageNum, pageSize);
    }

    @ApiOperation("查询所有商品")
    @GetMapping("/selectAll")
    public List<Goods> selectAll() {
        return goodsService.selectAll();
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/save")
    public Result save(@RequestBody InGoods inGoods) {
        Goods goods = new Goods(inGoods);
        if (goodsService.add(goods)) {
            return ResultUtils.ok().message("添加成功");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation(value= "修改商品信息")
    @PutMapping("/update/{id}")
    public Result updateById(@PathVariable Integer id, @RequestBody InGoods inGoods) {
        Goods goods = new Goods(inGoods);
        goods.setId(id);
        return goodsService.myUpdateById(goods);
    }


    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if (goodsService.deleteById(id)) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @ApiOperation("模糊查询商品")
    @GetMapping("/like/{name}")
    public List<Goods> like(@PathVariable String name) {
        return goodsService.like(name);
    }


    @ApiOperation("批量删除")
    @DeleteMapping("/deleteBatchId/{list}")
    public Result DeleteBatchId(@PathVariable List<Integer> list) {
        if (goodsService.deleteBatchId(list)) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }
}

