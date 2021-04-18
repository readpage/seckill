package com.example.controller;

import com.example.entity.Orders;
import com.example.mapper.OrdersMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "订单信息")
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Resource
    private OrdersMapper ordersMapper;

    @ApiOperation("分页查询订单")
    @GetMapping("/pageHepler/{pageSize}/{pageNum}")
    public PageInfo<Orders> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(ordersMapper.selectAll());
    }

    @ApiOperation("id查询订单")
    @GetMapping("/findById/{id}")
    public Orders findById(@PathVariable Integer id) {
        return ordersMapper.findById(id);
    }

    @ApiOperation("添加订单")
    @PostMapping("/add")
    public Result add(@RequestBody Orders orders) {
        Integer n = ordersMapper.add(orders);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation("删除订单")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Integer n = ordersMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @ApiOperation("修改订单")
    @PutMapping("/update")
    public Result updateById(@RequestBody Orders orders) {
        Integer n = ordersMapper.updateById(orders);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
