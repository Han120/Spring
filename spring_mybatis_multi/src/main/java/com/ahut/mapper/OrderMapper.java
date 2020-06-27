package com.ahut.mapper;

import com.ahut.domain.Order;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-27 8:43
 */
public interface OrderMapper {
    public List<Order> findAll();
}
