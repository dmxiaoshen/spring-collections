package com.dmxiaoshen.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.dmxiaoshen.client.Demo3Client;
import com.dmxiaoshen.dao.AccountDao;
import com.dmxiaoshen.model.Account;
import com.dmxiaoshen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private Demo3Client demo3Client;


    @Override
    @Transactional
    @TxTransaction
    public int decreaseBalance(String id, BigDecimal amount) {
        demo3Client.add("iphone x","tom",amount);
        return accountDao.decrease(id,amount);
    }
}
