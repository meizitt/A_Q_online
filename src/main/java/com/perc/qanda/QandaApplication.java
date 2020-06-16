package com.perc.qanda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan(value = "com.perc.qanda.mappers")
@CrossOrigin
@SpringBootApplication
public class QandaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QandaApplication.class, args);
    }

}
