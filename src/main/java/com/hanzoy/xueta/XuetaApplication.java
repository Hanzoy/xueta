package com.hanzoy.xueta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hanzoy.xueta.mapper")
public class XuetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuetaApplication.class, args);
    }

}
