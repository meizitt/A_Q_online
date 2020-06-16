package com.perc.qanda.controller;

import com.perc.qanda.service.StuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StuConTest {

    @Autowired
    StuService stuService;


    @Test
    void delStuById() {
    }

    @Test
    void findAllStu() {

        System.out.println(stuService.findAllStu());
    }
}
