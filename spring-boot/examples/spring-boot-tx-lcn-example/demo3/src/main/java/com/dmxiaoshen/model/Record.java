package com.dmxiaoshen.model;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
public class Record {

    private Integer id;

    private String productName;

    private String userName;

    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
