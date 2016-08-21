package com.hell_board.config;

import com.hell_board.data.dao.MemberDao;
import com.hell_board.data.domain.Content;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
public class JavaConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass("org.h2.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        comboPooledDataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
        comboPooledDataSource.setUser("sa");
        comboPooledDataSource.setPassword("");

        comboPooledDataSource.setMaxPoolSize(100);
        comboPooledDataSource.setMaxIdleTime(600);
        comboPooledDataSource.setIdleConnectionTestPeriod(300);

        return comboPooledDataSource;
    }

    @Bean
    public Content content() {
        return new Content();
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());

        return dataSourceTransactionManager;
    }
}