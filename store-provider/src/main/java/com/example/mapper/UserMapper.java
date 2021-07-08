package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import com.example.output.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface UserMapper extends BaseMapper<User> {
    int saveUserRole(Map<String, Object> map);

    int deleteUserRole(int uid);

    int deleteBatchUserRole(List<Integer> list);

    List<User> findUserWithOrders();

    List<User> selectById(Integer id);

    List<User> selectAll();

    int selectIsUsername(String username);

    int selectUserCount();

    int insert1(User user);

    int updateByUsername(@Param("user") User user, @Param("username") String username);

    UserInfo selectByUsername(String username);
}
