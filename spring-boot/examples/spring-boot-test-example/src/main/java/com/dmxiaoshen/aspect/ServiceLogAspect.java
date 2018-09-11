package com.dmxiaoshen.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by hzhsg on 2018/8/28.
 */
@Component
@Aspect
@Slf4j
public class ServiceLogAspect {
    private static final String point = "execution(public * com.dmxiaoshen.service.impl..*.*(..))";

    @Pointcut(point)
    public void log(){};

    @Around("log()")
    public Object doAround(ProceedingJoinPoint pip) throws Throwable{
        Class clazz = pip.getClass();
        Object[] args = pip.getArgs();
        System.out.println(clazz);
        Arrays.stream(args).forEach(System.out::println);
        System.out.println(pip.toLongString());
        System.out.println(pip.toShortString());
        System.out.println(pip.toString());
        System.out.println(pip.getSignature().getName());
        System.out.println(pip.getSignature().getDeclaringType());
        System.out.println(pip.getSignature().getDeclaringTypeName());
        System.out.println(pip.getSignature().getClass());
        Object obj = pip.proceed();
        return obj;
    }
}
