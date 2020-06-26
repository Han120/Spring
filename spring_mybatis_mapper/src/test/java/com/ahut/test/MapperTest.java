package com.ahut.test;

import com.ahut.domain.User;
import com.ahut.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 15:39
 */
public class MapperTest {
    @Test
    public void test() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟一下条件
        User condition = new User();
        condition.setId(3);

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        List<User> users = mapper.findByIds(ids);
        System.out.println(users);


    }
}
