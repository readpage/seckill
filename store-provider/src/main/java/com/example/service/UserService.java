package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
public interface UserService extends IService<User> {
    Map<String, Object> myPage(Integer pageNum, Integer pageSize);

    Result mySave(User user);

    Result myUpdateById(User user);

    Result myDeleteById(Integer id);

    List<User> like(String username);

    Result myDeleteBatchId(List<Integer> lists);

}
