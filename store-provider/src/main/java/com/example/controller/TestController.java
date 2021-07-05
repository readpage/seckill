package com.example.controller;

import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.example.service.OrdersGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {
    @Autowired
    private OrdersGoodsService ordersGoodsService;

    @Autowired
    private GoodsSeckillService goodsSeckillService;


    @ApiOperation("查询秒杀是否过期")
    @GetMapping("/isExpire/{gid}")
    public Result selectIsExpire(@PathVariable Integer gid) {
        if (goodsSeckillService.selectIsExpire(gid)) {
            return ResultUtils.ok().message("没有过期!😂");
        } else {
            return ResultUtils.error().message("已经过期😂");
        }
    }

    @ApiOperation("查询秒杀是否失效")
    @GetMapping("/isStatus/{gid}")
    public Result selectIsStatus(@PathVariable Integer gid) {
        if (goodsSeckillService.selectStatusByGid(gid)) {
            return ResultUtils.ok().message("没有失效!😂");
        } else {
            return ResultUtils.error().message("已经失效😂");
        }
    }
}
