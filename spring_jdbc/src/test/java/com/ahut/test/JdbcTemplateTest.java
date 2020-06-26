package com.ahut.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @author hanzijian
 * @create 2020-06-25 15:52
 */
public class JdbcTemplateTest {


    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate bean = applicationContext.getBean(JdbcTemplate.class);

        int row = bean.update("insert into live_users value (?,?,?)", 8,"hanzijian", "1234567hh");
        System.out.println(row);
    }


    @Test
    public void test1() throws PropertyVetoException {

        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/livesystem?useSSL=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("Admin@123");

        JdbcTemplate jdbcTemplate=new JdbcTemplate();

        //设置数据源
        jdbcTemplate.setDataSource(dataSource);

        //执行操作

        int row = jdbcTemplate.update("insert into live_users value (?,?,?)", 6,"hanzijian", "1234567hh");
        System.out.println(row);

    }
}
