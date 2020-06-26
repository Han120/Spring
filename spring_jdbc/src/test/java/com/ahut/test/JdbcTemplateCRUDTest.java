package com.ahut.test;

import com.ahut.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hanzijian
 * @create 2020-06-25 17:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增
    @Test
    public void testAdd(){
        jdbcTemplate.update("insert into live_users value (?,?,?)", 4,"hanzijian", "1234567hh");
    }

    //改
    @Test
    public void testUpdat() {
        jdbcTemplate.update("update live_users set name=? where id=?","zhangran",4);
    }

    //删
    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from live_users where id=?",4);
    }

    //查询全部
    @Test
    public void testQueryAll() {
//        List<User> users = jdbcTemplate.query("select * from live_users", new BeanPropertyRowMapper<User>(User.class));
        List<User> users = jdbcTemplate.query("select * from live_users where name=?", new BeanPropertyRowMapper<User>(User.class),"hanzijian");
        System.out.println(users);
    }
    //查询一个对象

    @Test
    public void testQueryOne() {
        User users = jdbcTemplate.queryForObject("select * from live_users where id=?", new BeanPropertyRowMapper<User>(User.class),5);
        System.out.println(users);
    }
    //查询总数
    @Test
    public void testQueryCcount() {
        Long counts = jdbcTemplate.queryForObject("select  count(*) from live_users", Long.class);
        Long counts1 = jdbcTemplate.queryForObject("select  count(*) from live_users where name=?", Long.class,"hanzijian");
        System.out.println(counts+counts1);
    }
}

