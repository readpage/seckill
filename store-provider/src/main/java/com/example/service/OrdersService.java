package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Orders;
import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;
import com.example.response.Result;
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
public interface OrdersService extends IService<Orders> {
    Result myDeleteBatchId(List<Integer> lists);

    Result add(Long uid, List<OrdersGoods> list);

    Result deleteById(Integer id);

    Result deleteBatchId(List<Integer> list);

    Result deleteByUId(Integer uid);

    Result deleteBatchUId(List<Integer> list);

    boolean updateGoods(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    PageInfo<OrdersInfo> page(int pageNum, int pageSize);
}
