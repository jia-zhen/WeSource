package com.we;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.we.dao")
public class WesourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WesourceApplication.class, args);
    }
}
