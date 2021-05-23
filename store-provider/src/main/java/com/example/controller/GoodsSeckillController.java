package com.example.controller;


import com.example.entity.GoodsSeckill;
import com.example.input.InGoodsSeckill;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.GoodsSeckillService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
@RestController
@Api(tags = "抢购商品信息管理")
@RequestMapping("/goods-seckill")
public class GoodsSeckillController {
    @Autowired
    private GoodsSeckillService goodsSeckillService;

    @ApiOperation("分页查询数据")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<GoodsSeckill> page(@PathVariable int pageNum, @PathVariable int pageSize) {
        return goodsSeckillService.page(pageNum, pageSize);
    }

    @ApiOperation("添加抢购商品")
    @PostMapping("/add")
    public Result add(@RequestBody InGoodsSeckill inGoodsSeckill) {
        if (goodsSeckillService.add(new GoodsSeckill(inGoodsSeckill))) {
            return ResultUtils.ok().message("添加成功!");
        } else {
            return ResultUtils.error().message("添加失败!");
        }
    }
}

