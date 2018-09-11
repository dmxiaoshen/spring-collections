package com.dmxiaoshen.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hzhsg on 2018/8/28.
 */
public class RabbitConfit {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void test(){
        rabbitTemplate.getConnectionFactory().createConnection();
    }
}
