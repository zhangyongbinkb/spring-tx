package com.itheima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: zhangyongbin
 * @Date: 2020/9/15 17:41
 */
public class TransactionConfig {


    /**
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
