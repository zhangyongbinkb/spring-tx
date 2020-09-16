package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  JdbcTemplate 的 CRUD 操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3、执行操作

        //保存
        //jt.update("insert into account(name, money) values (?, ?)", "fff", 3333f);

        //更新
        //jt.update("update account set name=?, money=? where id=?", "ggg", 1000f, 9);

        //删除
        //jt.update("delete from account where id=?", 9);

        //查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class),100f);
//        for (Account account : accounts){
//            System.out.println(account);
//        }

        //查询一个
//        List<Account> account = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(account.isEmpty() ? "没有内容" : account.get(0));

        //查询返回一行一列（使用聚合函数，但不加 group by 子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class,500f);
        System.out.println(count);
    }
}

/**
 *  定义 Account 的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到 Account 中，然后由 spring 把每个 Account 加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));

        return account;
    }
}
