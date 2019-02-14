package com.ocean.example.account;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public interface AccountService {

    /**
     * 余额扣款
     *
     * @param userId 用户ID
     * @param money  扣款金额
     */
    void debit(String userId, int money);
}
