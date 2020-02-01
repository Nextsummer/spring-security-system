package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableWebSecurity
@MapperScan("com.exam.mapper")
public class ExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class,args);
    }
}
