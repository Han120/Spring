package com.ahut.config;

/**
 * @author hanzijian
 * @create 2020-06-24 8:39
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfiguration
 * @Description 数据源相关的配置
 * @author hzj
 * @date 2020/6/24 8:40
 */
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.drive}")
    private String diver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean("dataSource") //spring会将当前方法的返回值以指定名称存储在spring容器中
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(diver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
