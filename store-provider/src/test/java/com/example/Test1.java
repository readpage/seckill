package com.example;

import com.example.entity.Menu;
import com.example.mapper.MenuMapper;
import com.example.mapper.UserDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Resource
    private UserDetailMapper userDetailMapper;
    @Resource
    private MenuMapper menuMapper;
    @Test
    public void test() {
        List<Menu> menus = menuMapper.selectAll();
        menus.forEach(System.out::println);
    }
}
