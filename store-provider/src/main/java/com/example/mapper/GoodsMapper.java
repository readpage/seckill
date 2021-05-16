package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Goods;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    Integer deleteOrderGoods(Integer gid);

    Integer deleteBatchOrderGoods(List<Integer> list);
}
