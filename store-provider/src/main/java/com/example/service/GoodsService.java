package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Goods;
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
public interface GoodsService extends IService<Goods> {
    Map<String, Object> myPage(Integer pageNum, Integer pageSize);

    Result mySave(Goods goods);

    Result myUpdateById(Goods goods);

    Result myDeleteById(Integer id);

    List<Goods> like(String name);

    Result myDeleteBatchId(List<Integer> lists);

}
