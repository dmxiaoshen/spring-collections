package com.dmxiaoshen.service;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
public interface AccountService {

    int decreaseBalance(String id, BigDecimal amount);
}
