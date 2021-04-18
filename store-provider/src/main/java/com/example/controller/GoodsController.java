package com.example.controller;

import com.example.entity.Goods;
import com.example.response.Result;
import com.example.service.impl.GoodsServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "商品信息管理")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsServiceImpl goodsService;

    @ApiOperation("分页查询数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<Goods> selectAll(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum) {
        return goodsService.selectAll(pageSize,pageNum);
    }

    @ApiOperation("模糊查询商品")
    @GetMapping("/like/{name}/{pageSize}/{pageNum}")
    public PageInfo<Goods> findByGoodsnameLike(@PathVariable String name,
                                              @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return goodsService.findByGoodsnameLike(name,pageSize,pageNum);
    }

    @ApiOperation("通过名称查询商品")
    @GetMapping("/findByname/{name}")
    public Goods findByUsername(@PathVariable String name) {
        return goodsService.findByUsername(name);
    }

    @ApiOperation("通过id查询商品")
    @GetMapping("/findById/{id}")
    public Goods findById(@PathVariable Integer id) {
        return goodsService.findById(id);
    }

    @ApiOperation("添加商品,id不用填写!\uD83D\uDE42")
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        return goodsService.add(goods);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return goodsService.deleteById(id);
    }

    @ApiOperation("修改商品信息")
    @PutMapping("/update")
    public Result updateById(@RequestBody Goods goods) {
        return goodsService.updateById(goods);
    }
}
