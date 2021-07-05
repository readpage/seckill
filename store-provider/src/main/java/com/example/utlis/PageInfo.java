package com.example.utlis;


import com.github.pagehelper.PageSerializable;

import java.util.List;

public class PageInfo<T> extends PageSerializable<T> {
    public PageInfo(List<T> list) {
        super(list);
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
