package com.codingapi.tx;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Configuration
@ConditionalOnProperty("tx.manager.url")
public class TxManagerConfiguration {

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "tx.manager")
    public TxManagerProperity txManagerProperity(){
        return new TxManagerProperity();
    };

    @Bean
    public TxManagerTxUrlService txManagerTxUrlService(){
        return new TxManagerTxUrlServiceImpl(txManagerProperity());
    }

    @Bean
    public TxManagerHttpRequestService txManagerHttpRequestService(){
        return new TxManagerHttpRequestServiceImpl();
    }
}
