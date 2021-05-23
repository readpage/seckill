package com.example.service;

import com.example.domain.OrdersInfo;
import com.github.pagehelper.PageInfo;

public interface OrdersGoodsService {
    PageInfo<OrdersInfo> page(int pageNum, int PageSize);

}
