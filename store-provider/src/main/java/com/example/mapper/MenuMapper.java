package com.example.mapper;

import com.example.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<Menu> getAllMenus();
}
