package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.OrdersService;
import com.example.service.UserRoleService;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

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
    @Autowired
    private UserRoleService userRoleService;

    @Transactional(rollbackFor = Exception.class)//设置检查时异常时回滚事务
    @Override
    public boolean register(User user) throws Exception {
        String phone = user.getPhone();
        Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");// 验证手机号
        if (!phone.matches(phone)) {
            return false;
        }
        user.setPassword(pw.encode(user.getPassword()));
        if (userMapper.insert(user)==0) {
            throw new Exception("注册失败!😂");
        }
        if (!userRoleService.insert(user.getId(), 3)) {
            throw new Exception("注册失败!😂");
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)//设置检查时异常时回滚事务
    @Override
    public boolean save(User user) {
        user.setPassword(pw.encode(user.getPassword()));
        if (userMapper.insert(user)==0) {
            try {
                throw new Exception("注册失败!😂");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!userRoleService.insert(user.getId(), 3)) {
            try {
                throw new Exception("注册失败!😂");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
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

    @Override
    public boolean selectIsUsername(String username) {
        return userMapper.selectIsUsername(username)>0;
    }

    @Override
    public int selectUserCount() {
        return userMapper.selectUserCount();
    }

    @Override
    public Boolean updateByUsername(User user, String username) {
        if (user.getPassword() != null && !"".equals(user.getPassword())) {
            user.setPassword(pw.encode(user.getPassword()));
        }
        return userMapper.updateByUsername(user, username)>0;
    }
}
