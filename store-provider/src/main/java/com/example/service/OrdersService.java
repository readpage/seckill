package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.response.Result;

import java.util.List;
import java.util.Map;

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

    Map<String, Object> myPage(Integer pageNum, Integer pageSize);

    Result save(User user);

    Result deleteById(Integer id);

    Result deleteBatchId(List<Integer> list);

    Result deleteByUId(Integer uid);

    Result deleteBatchUId(List<Integer> list);
}
