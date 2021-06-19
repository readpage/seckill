package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectAll();
}
