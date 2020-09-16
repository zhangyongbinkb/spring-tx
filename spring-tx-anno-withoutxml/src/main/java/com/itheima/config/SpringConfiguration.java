package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Author: zhangyongbin
 * @Date: 2020/9/15 17:31
 */
@Configuration
@Import({JdbcConfig.class, TransactionConfig.class})
@ComponentScan(basePackages = "com.itheima")
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

}
