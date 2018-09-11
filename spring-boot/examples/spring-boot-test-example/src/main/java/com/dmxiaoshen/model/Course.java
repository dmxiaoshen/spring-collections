package com.dmxiaoshen.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Course {

    private String name;

    private BigDecimal score;

    private String studentId;
}
