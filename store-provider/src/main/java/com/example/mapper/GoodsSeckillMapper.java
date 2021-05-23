package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.GoodsSeckill;
import com.example.entity.OrdersSeckill;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface GoodsSeckillMapper extends BaseMapper<GoodsSeckill> {
    int deleteByGid(Integer gid);

    int deleteBatchByGid(List<Integer> list);

    Integer selectToId(Integer gid);

    List<Integer> selectBatchToId(List<Integer> list);

    int updateStockByOrdersSeckill(OrdersSeckill ordersSeckill);

}
