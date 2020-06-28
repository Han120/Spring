package com.ahut.test;

import com.ahut.domain.Order;
import com.ahut.domain.User;
import com.ahut.mapper.OrderMapper;
import com.ahut.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 9:06
 */
public class MyBatisTest {

    private UserMapper mapper;
    @Before
    public void before() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        //获取session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得Session会话对象
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);

    }
    //查询
    @Test
    public void test() throws IOException {


        User one = mapper.findOne(14);
        //测试
        System.out.println(one);


    }
    //查询
    @Test
    public void test1() throws IOException {


        //执行操作,参数：namespace+id
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            //测试
            System.out.println(user);
        }


    }

//    插入
    @Test
    public void test2() throws IOException {

        //模拟User对象
        User user=new User();
        user.setUsername("zhangran");
        user.setPassword("zr1234567");
        mapper.save(user);

    }
    //修改
    @Test
    public void test3() throws IOException {

        //模拟User对象
        User user=new User();
        user.setId(15);
        user.setUsername("hanzijian");
        mapper.update(user);



    }

    //删除
    @Test
    public void test4() throws IOException {
        mapper.delete(13);


    }
    //1对1
    @Test
    public void test5() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = mapper.findAll();

        for(Order order:orderList) {
            System.out.println(order);
        }
    }
    //1对多
    @Test
    public void test6() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findOrders();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //多对多
    @Test
    public void test7() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findRoles();
        for(User user:userList) {
            System.out.println(user);
        }
    }
}
