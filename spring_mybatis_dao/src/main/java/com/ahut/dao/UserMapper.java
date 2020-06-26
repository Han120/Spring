package com.ahut.dao;

import com.ahut.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 11:27
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;
}
