package com.perc.qanda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@MapperScan(value = "com.perc.qanda.mappers")
@SpringBootApplication
public class QandaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QandaApplication.class, args);
    }

}
