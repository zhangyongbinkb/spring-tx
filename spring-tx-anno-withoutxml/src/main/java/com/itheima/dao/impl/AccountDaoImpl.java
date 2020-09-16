package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据Id查询账户
     *
     * @param accountId
     * @return
     */
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    /**
     * 根据用户名称查询账户
     *
     * @param accountName
     * @return
     */
    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()){
            return null;
        }

        if(accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }

        return accounts.get(0);
    }

    /**
     * 更新账户
     *
     * @param account
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
