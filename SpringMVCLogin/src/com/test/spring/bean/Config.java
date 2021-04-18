package com.test.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
    public Car car() {
        return new CarImpl();
    }

}
