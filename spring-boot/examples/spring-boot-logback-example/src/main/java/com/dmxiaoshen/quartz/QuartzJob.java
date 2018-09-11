package com.dmxiaoshen.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by hzhsg on 2018/8/24.
 */
@Component
@Slf4j
public class QuartzJob {

    @Scheduled(initialDelay = 5000,fixedRate = 5000)
    public void job1(){
        log.debug("debug job1 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.info("info job1 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.warn("warn job1 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.error("error job1 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));

    }

    @Scheduled(initialDelay = 6000,fixedRate = 6000)
    public void job2(){
        log.debug("debug job2 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.info("info job2 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.warn("warn job2 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        log.error("error job2 current time is {}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));

    }

}
