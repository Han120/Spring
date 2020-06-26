package com.ahut.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author hanzijian
 * @create 2020-06-23 15:09
 */
@Configuration //标志该类是核心配置类
@ComponentScan("com.ahut") // <context:component-scan base-package="com.ahut"/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}
