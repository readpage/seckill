package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Orders;
import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;
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
public interface OrdersService extends IService<Orders> {

    boolean add(Long uid, OrdersGoods ordersGoods) throws Exception;

    boolean add(Long uid, List<OrdersGoods> list) throws Exception;

    Result deleteById(Integer id);

    Result deleteBatchId(List<Integer> list);

    Result deleteByUId(Integer uid);

    Result deleteBatchUId(List<Integer> list);

    boolean updateGoods(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    PageInfo<OrdersInfo> page(int pageNum, int pageSize);
}
