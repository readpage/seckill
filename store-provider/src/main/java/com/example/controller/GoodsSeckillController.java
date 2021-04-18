package com.example.controller;

import com.example.entity.GoodsSeckill;
import com.example.mapper.GoodsSeckillMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "秒杀商品")
@RequestMapping("/goodsSeckill")
@RestController
public class GoodsSeckillController {

    @Resource
    GoodsSeckillMapper goodsSeckillMapper;

    @ApiOperation("分页查询秒杀商品数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<GoodsSeckill> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsSeckill> goodsSeckills = goodsSeckillMapper.selectAll();
        return new PageInfo<>(goodsSeckills);
    }

    @ApiOperation("通过id查询秒杀商品")
    @GetMapping("/findById/{id}")
    public GoodsSeckill findById(@PathVariable Integer id) {
        return goodsSeckillMapper.findById(id);
    }

    @ApiOperation("添加秒杀商品")
    @PostMapping("/add")
    public Result add(@RequestBody GoodsSeckill goodsSeckill) {
        Integer n = goodsSeckillMapper.add(goodsSeckill);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation("删除秒杀商品")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Integer n = goodsSeckillMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @ApiOperation("修改秒杀商品")
    @PutMapping("/update")
    public Result updateById(@RequestBody GoodsSeckill goodsSeckill) {
        Integer n = goodsSeckillMapper.updateById(goodsSeckill);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
