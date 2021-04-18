package com.example.controller;

import com.example.entity.Orders;
import com.example.response.Result;
import com.example.service.impl.OrdersServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单信息")
@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersService;

    @ApiOperation("分页查询订单")
    @GetMapping("/pageHepler/{pageSize}/{pageNum}")
    public PageInfo<Orders> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return ordersService.selectAll(pageSize,pageNum);
    }

    @ApiOperation("id查询订单")
    @GetMapping("/findById/{id}")
    public Orders findById(@PathVariable Integer id) {
        return ordersService.findById(id);
    }

    @ApiOperation("添加订单")
    @PostMapping("/add")
    public Result add(@RequestBody Orders orders) {
        return ordersService.add(orders);
    }

    @ApiOperation("删除订单")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return ordersService.deleteById(id);
    }

    @ApiOperation("修改订单")
    @PutMapping("/update")
    public Result updateById(@RequestBody Orders orders) {
       return ordersService.updateById(orders);
    }
}
