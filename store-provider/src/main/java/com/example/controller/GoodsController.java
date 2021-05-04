package com.example.controller;


import com.example.entity.Goods;
import com.example.response.Result;
import com.example.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Map<String, Object> page(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return goodsService.myPage(pageNum, pageSize);
    }

    @ApiOperation(value = "添加商品", notes = "时间和id会自动生成,version,无需添加")
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) {
        return goodsService.mySave(goods);
    }

    @ApiOperation(value= "修改商品信息", notes="时间会自动更新,必须添加id")
    @PutMapping("/update")
    public Result updateById(@RequestBody Goods goods) {
        return goodsService.myUpdateById(goods);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public Result DeleteById(@PathVariable Integer id) {
        return goodsService.myDeleteById(id);
    }

    @ApiOperation("模糊查询商品")
    @GetMapping("/like/{name}")
    public List<Goods> like(@PathVariable String name) {
        return goodsService.like(name);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/deleteBatchId/{list}")
    public Result DeleteBatchId(@PathVariable List<Integer> list) {
        return goodsService.myDeleteBatchId(list);
    }
}

