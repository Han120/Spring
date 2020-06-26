package com.ahut.dao.impl;

import com.ahut.dao.UserMapper;
import com.ahut.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 11:28
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        return userList;
    }
}
