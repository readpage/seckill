package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.GoodsSeckill;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-24
 */
public interface GoodsSeckillService extends IService<GoodsSeckill> {
    Boolean deleteByGid(Integer gid);

    Boolean deleteBatchByGid(List<Integer> list);

    Boolean selectStatusByGid(Integer gid);

    Boolean selectIsExpire(Integer gid);
}
