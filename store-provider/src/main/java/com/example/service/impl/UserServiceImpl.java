package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersService;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    @Lazy
    private PasswordEncoder pw;

//    @Override
//    public PageInfo<User> myPage(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        return new PageInfo<>(userMapper.findUserWithOrders());
//    }

    @Override
    public Result mySave(User user) {
        user.setPassword(pw.encode(user.getPassword()));
        userMapper.insert(user);
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("rid", 3);
        int n = userMapper.saveUserRole(map);
        if (n==1) {
            return ResultUtils.ok().message("添加成功😀!");
        }
        return ResultUtils.error().message("添加失败!😭");
    }

    @Override
    public Result myUpdateById(User user) {
        //乐观锁
        user.setPassword(pw.encode(user.getPassword()));
        int n = userMapper.updateById(user);
        if (n==1) {
            return ResultUtils.ok().message("修改成功😀!");
        }
        return ResultUtils.error().message("修改失败!😭");
    }

    @Override
    public Result myDeleteById(Integer id) {
        ordersService.deleteByUId(id);
        userMapper.deleteUserRole(id);
        int n = userMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public List<User> like(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", username);
        wrapper.select("*");
        return userMapper.selectList(wrapper);
    }
    @Override
    public Result myDeleteBatchId(List<Integer> lists) {
        ordersService.deleteBatchUId(lists);
        userMapper.deleteBatchUserRole(lists);
        int n = userMapper.deleteBatchIds(lists);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.select("*");
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public PageInfo<User> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.selectAll());
    }
}
