package com.dmxiaoshen.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.dmxiaoshen.client.Demo2Client;
import com.dmxiaoshen.dao.ProductDao;
import com.dmxiaoshen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private Demo2Client demo2Client;
    @Override
    @Transactional
    @TxTransaction(isStart = true)
    public void buy() {
        demo2Client.decreaseBalance("1",new BigDecimal("100"));
        productDao.decrease("1",1);
        int a = 3/0;
    }
}
