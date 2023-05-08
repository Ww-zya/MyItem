package com.item.myitem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.item.myitem.mapper")
public class MyItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyItemApplication.class, args);
    }

}
