package com.ahut.test;

import com.ahut.config.SpringConfiguration;
import com.ahut.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author hanzijian
 * @create 2020-06-24 9:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService mUserService;
    @Autowired
    private DataSource mDataSource;
    @Test
    public void test() throws SQLException {
        mUserService.save();
        System.out.println(mDataSource.getConnection());
    }
}
