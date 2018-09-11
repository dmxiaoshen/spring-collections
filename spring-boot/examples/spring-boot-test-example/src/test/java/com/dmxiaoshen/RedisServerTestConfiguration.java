package com.dmxiaoshen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

/**
 * Created by hzhsg on 2018/8/1.
 */
@Configuration
@Slf4j
public class RedisServerTestConfiguration implements DisposableBean, EnvironmentAware, InitializingBean {

    private RedisServer redisServer;
    private Environment environment;

    @Override
    public void destroy() throws Exception {
        if (redisServer != null && redisServer.isActive()) {
            redisServer.stop();
            redisServer = null;
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!isEmbedded()){
            return;
        }
        try {
            int port = getPort();
            // setting  maxheap 512Mb 怕内存不够启动报错
            redisServer = new RedisServerBuilder().setting("maxheap 512Mb").port(port).build();
            if(!redisServer.isActive()){
                redisServer.start();
            }
            log.info("Success to start local embedded redis server on port:{}",port);
        }catch (Exception e){
            throw new RuntimeException("Failed to start local embedded redis server",e);
        }
    }

    private boolean isEmbedded(){
        Boolean v = environment.getProperty("spring.redis.embedded",Boolean.class,null);
        v = v == null ? environment.getProperty("global.redis.embedded",Boolean.class,false) : v;
        return v;
    }

    public int getPort() {
        int v = environment.getProperty("spring.redis.port",Integer.class,0);
        v = v == 0 ? environment.getProperty("global.redis.port",Integer.class,6379) : v;
        return v;
    }
}
