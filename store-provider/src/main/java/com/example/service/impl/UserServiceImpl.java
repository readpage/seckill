package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.UserService;
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
    @Lazy
    private PasswordEncoder pw;

    @Override
    public Map<String, Object> myPage(Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        userMapper.selectPage(page, null);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", page.getRecords());
        resultMap.put("total", page.getTotal());
        return resultMap;
    }

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
        userMapper.selectById(user.getId());
        user.setPassword(pw.encode(user.getPassword()));
        int n = userMapper.updateById(user);
        if (n==1) {
            return ResultUtils.ok().message("修改成功😀!");
        }
        return ResultUtils.error().message("修改失败!😭");
    }

    @Override
    public Result myDeleteById(Integer id) {
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
        return userMapper.selectList(wrapper);
    }

    @Override
    public Result myDeleteBatchId(List<Integer> lists) {
        userMapper.deleteBatchUserRole(lists);
        int n = userMapper.deleteBatchIds(lists);
        if (n >= 1) {
            return ResultUtils.ok().message("删除成功😀!");
        }
        return ResultUtils.error().message("删除失败!😭");
    }
}
