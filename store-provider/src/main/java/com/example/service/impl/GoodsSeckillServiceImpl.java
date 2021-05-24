package com.example.service.impl;

import com.example.entity.GoodsSeckill;
import com.example.mapper.GoodsSeckillMapper;
import com.example.service.GoodsSeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-24
 */
@Service
public class GoodsSeckillServiceImpl extends ServiceImpl<GoodsSeckillMapper, GoodsSeckill> implements GoodsSeckillService {
    @Resource
    private GoodsSeckillMapper goodsSeckillMapper;

    @Override
    public Boolean deleteByGid(Integer gid) {
        return goodsSeckillMapper.deleteByGid(gid)>0;
    }

    @Override
    public Boolean deleteBatchByGid(List<Integer> list) {
        return goodsSeckillMapper.deleteBatchByGid(list)>0;
    }
}
