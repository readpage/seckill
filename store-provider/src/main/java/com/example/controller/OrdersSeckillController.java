package com.example.controller;


import com.example.entity.OrdersSeckill;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersSeckillService;
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
 * @author f1dao😂
 * @since 2021-05-22
 */
@RestController
@Api(tags = "抢购订单信息管理")
@RequestMapping("/ordersSekcill")
public class OrdersSeckillController {
    @Autowired
    private OrdersSeckillService ordersSeckillService;
    @ApiOperation("添加抢购订单")
    @PostMapping("/add/{uid}")
    public Result add(@PathVariable Integer uid, @RequestBody List<OrdersSeckill> list) {
        boolean n = ordersSeckillService.add(uid, list);
        if (n) {
            return ResultUtils.ok().message("添加成功!😀");
        }
        return ResultUtils.error().message("添加失败😂");
    }
}

