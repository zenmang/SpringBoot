package com.zengmeng.heimaspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.zengmeng.heimaspringboot.mapper")
public class HeimaSpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(HeimaSpringbootApplication.class, args);
    }

}
