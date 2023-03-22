package com.itheima.config;

import com.itheima.utils.MyBatisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@Import({MyBatisConfig.class,JdbcConfig.class})

@ComponentScan("com.itheima.service.impl")
@EnableTransactionManagement

public class SpringConfig {
    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourcTxManager
            (@Autowired DataSource dataSource){
        DataSourceTransactionManager dtm=new DataSourceTransactionManager();
        dtm.setDataSource(dataSource);
        return dtm;
    }

}
