package com.example.mapper;

import com.example.entity.OrdersGoods;
import com.example.output.OrdersInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersGoodsMapper {
    int insert(OrdersGoods ordersGoods);

    List<OrdersInfo> selectAll();

    int deleteOrderGoods(Integer gid);

    int deleteBatchOrderGoods(List<Integer> list);

    int selectCountByGid(Integer gid);

    List<OrdersInfo> like(@Param("name") String name, @Param("number") String number);

    List<String> likeNumber(@Param("name") String name, @Param("number") String number);

    List<String> likeName(String name);

    int deleteOrdersGoods(Integer oid);

    int deleteBatchOrdersGoods(List<Integer> list);
}
