package com.example.controller;


import com.example.domain.OrdersInfo;
import com.example.entity.OrdersGoods;
import com.example.entity.OrdersSeckill;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersGoodsService;
import com.example.service.OrdersSeckillService;
import com.example.service.OrdersService;
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
@Api(tags = "订单信息管理")
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersGoodsService ordersGoodsService;
    @Autowired
    private OrdersSeckillService ordersSeckillService;

    @ApiOperation("删除订单")
    @DeleteMapping("/delete/{id}")
    public Result DeleteById(@PathVariable Integer id) {
        return ordersService.deleteById(id);
    }
    @ApiOperation("批量删除")
    @DeleteMapping("/deleteBatchId/{list}")
    public Result DeleteBatchId(@PathVariable List<Integer> list) {
        return ordersService.deleteBatchId(list);
    }
    @ApiOperation("添加订单 ")
    @PostMapping("/add/{uid}")
    public Result add(@PathVariable Integer uid, @RequestBody List<OrdersGoods> list) {
        return ordersService.add(Long.valueOf(uid), list);
    }

    @ApiOperation("添加抢购订单")
    @PostMapping("/add/seckill/{uid}")
    public Result addSeckill(@PathVariable Integer uid, @RequestBody List<OrdersSeckill> list) {
        boolean n = ordersSeckillService.add(uid, list);
        if (n) {
            return ResultUtils.ok().message("添加成功!😀");
        }
        return ResultUtils.error().message("添加失败😂");
    }
    @ApiOperation("查询订单")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<OrdersInfo> page(@PathVariable int pageNum, @PathVariable int pageSize) {
        return ordersGoodsService.page(pageNum, pageSize);
    }
}

