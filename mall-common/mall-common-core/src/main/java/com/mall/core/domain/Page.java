package com.mall.core.domain;

import com.github.pagehelper.PageInfo;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Page<T> {
    private Integer pageNum; //页码
    private Integer pageSize; //每页大小
    private Integer totalPages; //总页数
    private Long total; //总数
    private List<T> data; //数据

    /**
     * 将PageHelper分页后数据格式化
     */
    public static <T> Page<T> restPage(List<T> list) {
        Page<T> result = new Page<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPages(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        return result;
    }
    /**
     * 将SpringData分页后数据格式化
     */
//    public static <T> Page<T> restPage(org.springframework.data.domain.Page<T> pageInfo) {
//        Page<T> result = new Page<T>();
//        result.setTotalPages(pageInfo.getTotalPages());
//        result.setPageNum(pageInfo.getNumber());
//        result.setPageSize(pageInfo.getSize());
//        result.setTotal(pageInfo.getTotalElements());
//        result.setData(pageInfo.getContent());
//        return result;
//    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "CommonPage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
