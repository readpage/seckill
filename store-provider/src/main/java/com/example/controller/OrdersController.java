package com.example.controller;


import com.example.entity.OrdersGoods;
import com.example.input.InOrdersGoods;
import com.example.output.OrdersInfo;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Result add(@PathVariable Integer uid, @RequestBody List<InOrdersGoods> list) {
        ArrayList<OrdersGoods> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            InOrdersGoods inOrdersGoods = list.get(i);
            OrdersGoods ordersGoods = new OrdersGoods();
            ordersGoods.setCount(inOrdersGoods.getCount());
            ordersGoods.setGid(inOrdersGoods.getGid());
            list1.add(ordersGoods);
        }
        boolean b = ordersService.add(Long.valueOf(uid), list1);
        if (b) {
            return ResultUtils.ok().message("添加成功!😀");
        }
        return ResultUtils.error().message("添加失败😂,库存不足");
    }

    @ApiOperation("添加抢购订单")
    @PostMapping("/add/seckill/{uid}/{gid}")
    public Result addSeckill(@PathVariable Integer uid, @PathVariable Integer gid) {
        OrdersGoods ordersGoods = new OrdersGoods();
        ordersGoods.setGid(gid);
        ordersGoods.setCount(1);
        List<OrdersGoods> list = new ArrayList<>();
        list.add(ordersGoods);
        boolean b = ordersService.add(Long.valueOf(uid), list);
        if (b) {
            return ResultUtils.ok().message("添加成功!😀");
        }
        return ResultUtils.error().message("添加失败😂,库存不足");
    }

    @ApiOperation("查询所有订单")
    @GetMapping("/selectAll")
    public List<OrdersInfo> selectAll() {
        return ordersService.selectAll();
    }
    @ApiOperation("查询订单")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<OrdersInfo> page(@PathVariable int pageNum, @PathVariable int pageSize) {
        return ordersService.page(pageNum, pageSize);
    }
}

