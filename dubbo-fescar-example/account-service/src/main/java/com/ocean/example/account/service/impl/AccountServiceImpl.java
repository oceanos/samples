package com.ocean.example.account.service.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.ocean.example.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 余额扣款
     *
     * @param userId 用户ID
     * @param money  扣款金额
     */
    @Override
    public void debit(String userId, int money) {
        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[] {money, userId});
        LOGGER.info("Account Service End ... ");
    }
}
