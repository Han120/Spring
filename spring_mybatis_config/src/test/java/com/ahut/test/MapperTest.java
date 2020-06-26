package com.ahut.test;

import com.ahut.domain.User;
import com.ahut.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-26 15:39
 */
public class MapperTest {
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //模拟一下条件
        for(int i=5;i<=10;i++)
        {
            User user = new User();
            user.setId(i);
            user.setName("hanzijian");
            user.setPassword("123456");
            user.setBirthday(formatter.format(new Date()));

            mapper.save(user);

        }




    }
    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = mapper.findById(1);
        System.out.println(user);


    }
    @Test
    public void test3() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数 当前页+每页显示的条数
        PageHelper.startPage(6,2);

        List<User> userList = mapper.findAll();
        for (User user:userList) {
           System.out.println(user);
        }

        //获得与分页相关的参数
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("第一页"+pageInfo.getFirstPage());
        System.out.println("最后一页"+pageInfo.getLastPage());
        System.out.println("是否是第一页"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页"+pageInfo.isIsLastPage());
        System.out.println("endrow"+pageInfo.getEndRow());
        System.out.println("startrow"+pageInfo.getStartRow());

    }

}
