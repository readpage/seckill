package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
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
public interface UserService extends IService<User> {
    Result mySave(User user);

    Result myUpdateById(User user);

    Result myDeleteById(Integer id);

    List<User> like(String username);

    Result myDeleteBatchId(List<Integer> lists);

    User findByUsername(String username);

    PageInfo<User> page(int pageNum, int pageSize);
}
