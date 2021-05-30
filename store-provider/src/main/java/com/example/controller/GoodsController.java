package com.example.controller;


import com.example.entity.Goods;
import com.example.input.InGoods;
import com.example.input.InGoodsSeckill;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.example.service.GoodsService;
import com.example.service.OrdersGoodsService;
import com.example.utlis.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @Autowired
    private GoodsSeckillService goodsSeckillService;
    @Autowired
    private OrdersGoodsService ordersGoodsService;

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

    @ApiOperation(value = "秒杀管理")
    @PostMapping("/add-seckill")
    public Result addSeckill(@RequestBody InGoodsSeckill inGoodsSeckill) {
        if (goodsSeckillService.updateByGid(inGoodsSeckill)) {
            return ResultUtils.ok().message("修改成功😂!");
        }
        return ResultUtils.error().message("修改失败😂!");
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

    @ApiOperation("模糊查询")
    @GetMapping("/like")
    public List<Goods> like(@ApiParam(value = "空值或空字符串查询所有同理") String name, String type) {
        return goodsService.like(name, type);
    }

    @ApiOperation("模糊查询分页")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<Goods> likePage(@PathVariable int pageNum, @PathVariable int pageSize, @ApiParam(value = "空值或空字符串查询所有同理") String name,
                                    String type) {
        return goodsService.likePage(pageNum, pageSize, name, type);
    }

    @ApiOperation("模糊查询抢购商品分页")
    @GetMapping("/pageSeckill/{pageNum}/{pageSize}")
    public PageInfo<Goods> likeSeckillPage(@PathVariable int pageNum, @PathVariable int pageSize, @ApiParam(value = "空值或空字符串查询所有同理") String name,
                                    String type) {
        return goodsService.likeSeckillPage(pageNum, pageSize, name, type);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/deleteBatchId/{list}")
    public Result DeleteBatchId(@PathVariable List<Integer> list) {
        if (goodsService.deleteBatchId(list)) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @ApiOperation("获取所有商品类型")
    @GetMapping("/type")
    public List<String> selectType() {
        return goodsService.selectType();
    }

}

