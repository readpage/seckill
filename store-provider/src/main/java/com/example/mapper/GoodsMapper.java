package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Goods;
import com.example.entity.OrdersGoods;

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

    int updateStockByOrdersGoods(OrdersGoods ordersGoods);

    List<Goods> selectAll();

    List<Goods> like(String name);
    
    List<String> selectType();

}
