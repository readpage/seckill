package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.GoodsSeckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author f1dao😂
 * @since 2021-05-24
 */
public interface GoodsSeckillMapper extends BaseMapper<GoodsSeckill> {
    int deleteByGid(Integer gid);

    int deleteBatchByGid(List<Integer> list);

    int selectStatusByGid(Integer gid);

    int selectIsExpire(@Param("now") Date now, @Param("gid") Integer gid);
}
