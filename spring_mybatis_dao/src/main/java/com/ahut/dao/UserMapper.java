package com.ahut.dao;

import com.ahut.domain.User;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 11:27
 */
public interface UserMapper {
    public List<User> findAll();
    public User findOne(int id);

}
