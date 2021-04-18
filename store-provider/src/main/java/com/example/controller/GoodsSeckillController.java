package com.example.controller;

import com.example.entity.GoodsSeckill;
import com.example.response.Result;
import com.example.service.impl.GoodsSeckillServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "秒杀商品")
@RequestMapping("/goodsSeckill")
@RestController
public class GoodsSeckillController {

    @Autowired
    private GoodsSeckillServiceImpl goodsSeckillService;

    @ApiOperation("分页查询秒杀商品数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<GoodsSeckill> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return goodsSeckillService.selectAll(pageSize,pageNum);
    }

    @ApiOperation("通过id查询秒杀商品")
    @GetMapping("/findById/{id}")
    public GoodsSeckill findById(@PathVariable Integer id) {
        return goodsSeckillService.findById(id);
    }

    @ApiOperation("添加秒杀商品")
    @PostMapping("/add")
    public Result add(@RequestBody GoodsSeckill goodsSeckill) {
        return goodsSeckillService.add(goodsSeckill);
    }

    @ApiOperation("删除秒杀商品")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return goodsSeckillService.deleteById(id);
    }

    @ApiOperation("修改秒杀商品")
    @PutMapping("/update")
    public Result updateById(@RequestBody GoodsSeckill goodsSeckill) {
        return goodsSeckillService.updateById(goodsSeckill);
    }
}
