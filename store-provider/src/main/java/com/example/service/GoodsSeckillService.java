package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.GoodsSeckill;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface GoodsSeckillService extends IService<GoodsSeckill> {
    int deleteByGid(Integer gid);

    int deleteBatchByGid(List<Integer> list);

    Integer selectToId(Integer gid);

    List<Integer> selectBatchToId(List<Integer> list);

    boolean updateStockById(Integer gsId);

    PageInfo<GoodsSeckill> page(int pageNum, int pageSize);

    boolean add(GoodsSeckill goodsSeckill);
}
