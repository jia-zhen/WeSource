package com.we;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.we.dao")
@EnableCaching
public class WesourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WesourceApplication.class, args);
    }
}
