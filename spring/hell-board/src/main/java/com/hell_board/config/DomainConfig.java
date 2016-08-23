package com.hell_board.config;

import com.hell_board.domain.Content;
import com.hell_board.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public Member member() {
        return new Member();
    }

    @Bean
    public Content content() {
        return new Content();
    }
}
