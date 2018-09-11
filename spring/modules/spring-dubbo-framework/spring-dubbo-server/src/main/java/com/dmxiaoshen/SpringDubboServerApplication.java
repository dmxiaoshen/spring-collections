package com.dmxiaoshen;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hzhsg on 2018/8/20.
 */
public class SpringDubboServerApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        context.start();
        System.out.println("--spring-dubbo-server--start--");
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
