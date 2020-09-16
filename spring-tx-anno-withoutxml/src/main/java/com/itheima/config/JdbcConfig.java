package com.itheima.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * @Description:
 * @Author: zhangyongbin
 * @Date: 2020/9/15 17:33
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){  //当我们使用注解配置方法时，如果方法有参数，spring 框架会去容器中查找有没有可用的 bean 对象
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
