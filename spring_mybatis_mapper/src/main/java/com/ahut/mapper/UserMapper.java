package com.ahut.mapper;

import com.ahut.domain.User;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 15:36
 */
public interface UserMapper {
    public List<User> findByCondition(User pUser);

    public List<User> findByIds(List<Integer> ids);
}
