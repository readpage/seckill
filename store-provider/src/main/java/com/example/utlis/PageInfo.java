package com.example.utlis;


import com.github.pagehelper.PageSerializable;

import java.util.Arrays;
import java.util.List;

public class PageInfo<T> extends PageSerializable<T> {
    private long[] pageList;

    public PageInfo(List<T> list) {
        super(list);
        long num = total;
        pageList = new long[]{5, 10, 20, 40};
        if (num/8>5) {
            for (int i = 1; i < 4; i++) {
                pageList[i]= num;
                num/=2;
            }
            Arrays.sort(pageList);
        }
    }

    public long[] getPageList() {
        return pageList;
    }

    public void setPageList(long[] pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageList=" + Arrays.toString(pageList) +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
