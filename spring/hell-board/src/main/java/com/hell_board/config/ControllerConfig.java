package com.hell_board.config;

import com.hell_board.controller.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ControllerConfig {

    @Bean
    public MainController mainController() {
        return new MainController();
    }
}
