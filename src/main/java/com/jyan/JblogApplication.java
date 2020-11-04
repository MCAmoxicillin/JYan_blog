package com.jyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jyan.mapper")
@SpringBootApplication
public class JblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JblogApplication.class, args);
    }

}
