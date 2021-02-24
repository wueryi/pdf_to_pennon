package com.pennonedu.student_sign_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pennonedu.student_sign_api.dao")
public class StudentSignApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSignApiApplication.class, args);
    }

}
