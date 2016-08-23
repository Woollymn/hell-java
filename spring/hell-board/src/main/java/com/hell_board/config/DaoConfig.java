package com.hell_board.config;

import com.hell_board.dao.ContentDao;
import com.hell_board.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JavaConfig.class})
public class DaoConfig {

    @Autowired
    private JavaConfig javaConfig;

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(this.javaConfig.dataSource());
    }

    @Bean
    public ContentDao contentDao() {
        return new ContentDao(this.javaConfig.dataSource());
    }
}
