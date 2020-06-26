package com.ahut.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

/**
 * @author hanzijian
 * @create 2020-06-23 9:13
 */
public class DataSourceTest {
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/livesystem?useSSL=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("Admin@123");
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
