package com.we;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.we.dao")
public class WesourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WesourceApplication.class, args);
    }
}
