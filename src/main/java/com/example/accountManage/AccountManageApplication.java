package com.example.accountManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.accountManage.mapper")
public class AccountManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManageApplication.class, args);
    }

}
