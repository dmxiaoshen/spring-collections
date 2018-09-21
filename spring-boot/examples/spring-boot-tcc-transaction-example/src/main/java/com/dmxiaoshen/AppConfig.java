package com.dmxiaoshen;

import lombok.extern.slf4j.Slf4j;
import org.mengyun.tcctransaction.serializer.KryoPoolSerializer;
import org.mengyun.tcctransaction.spring.recover.DefaultRecoverConfig;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by hzhsg on 2018/9/17.
 */
@Configuration
@Slf4j
public class AppConfig {

    @Autowired
    private DataSource dataSource;


//    @Bean
//    @Primary
//    @ConfigurationProperties("spring.datasource")
//    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="tccDatasource")
//    @ConfigurationProperties("spring.second-datasource")
//    public DataSource tccDatasource(){
//        return DataSourceBuilder.create().build();
//    }

    /**
     * TCC补偿定时任务配置
     *
     * @return
     */
    @Bean
    public DefaultRecoverConfig defaultRecoverConfigBean() {
        log.info("==================cron");
        final DefaultRecoverConfig defaultRecoverConfig = new DefaultRecoverConfig();
        //最大重试次数
        defaultRecoverConfig.setMaxRetryCount(30);
        //恢复600秒前的事务
        defaultRecoverConfig.setRecoverDuration(600);
        defaultRecoverConfig.setCronExpression("0/5 * * * * ?");
        return defaultRecoverConfig;
    }

    /**
     * TCC事务库配置
     *
     * @return
     */
//    @Bean
//    public SpringJdbcTransactionRepository springJdbcTransactionRepositoryBean(@Qualifier("tccDatasource") DataSource dataSource) {
//        log.info("==================Repository");
//        final KryoPoolSerializer kryoPoolSerializer = new KryoPoolSerializer<>();
//        final SpringJdbcTransactionRepository springJdbcTransactionRepository = new SpringJdbcTransactionRepository();
//        springJdbcTransactionRepository.setDataSource(dataSource);
//        springJdbcTransactionRepository.setDomain("USER");
//        springJdbcTransactionRepository.setTbSuffix("_user");
//        springJdbcTransactionRepository.setSerializer(kryoPoolSerializer);
//        return springJdbcTransactionRepository;
//    }

    @Bean
    public SpringJdbcTransactionRepository springJdbcTransactionRepositoryBean() {
        log.info("==================Repository");
        final KryoPoolSerializer kryoPoolSerializer = new KryoPoolSerializer<>();
        final SpringJdbcTransactionRepository springJdbcTransactionRepository = new SpringJdbcTransactionRepository();
        springJdbcTransactionRepository.setDataSource(dataSource);
        springJdbcTransactionRepository.setDomain("USER");
        springJdbcTransactionRepository.setTbSuffix("_user");
        springJdbcTransactionRepository.setSerializer(kryoPoolSerializer);
        return springJdbcTransactionRepository;
    }
}
