package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Goods;
import com.example.entity.OrdersGoods;
import com.example.response.Result;
import com.example.utlis.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface GoodsService extends IService<Goods> {

    PageInfo<Goods> page(int pageNum, int pageSize);

    PageInfo<Goods> likePage(int pageNum, int pageSize, String name, String type);

    List<Goods> selectAll();

    List<Goods> like(String name, String type);


    Boolean add(Goods goods);

    Result myUpdateById(Goods goods);

    Boolean deleteById(Integer id);


    Boolean deleteBatchId(List<Integer> lists);

    boolean updateStockByOrdersGoods(OrdersGoods ordersGoods);

    List<String> selectType();


}
