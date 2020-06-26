package com.ahut.mapper;

import com.ahut.domain.User;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 15:36
 */
public interface UserMapper {
   public void save(User pUser);
   public User findById(int id);
   public List<User> findAll();
}
