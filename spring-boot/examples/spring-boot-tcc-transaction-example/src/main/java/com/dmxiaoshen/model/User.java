package com.dmxiaoshen.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hzhsg on 2018/1/9.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5240917587115739546L;

    private String id;

    private Integer age;

    private String mobilePhone;

    private String name;
}
