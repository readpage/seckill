package com.example.controller;


import com.example.response.Result;
import com.example.service.OrdersService;
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
@Api(tags = "订单信息管理")
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @ApiOperation("分页查询数据")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public Map<String, Object> page(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return ordersService.myPage(pageNum, pageSize);
    }
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
}

