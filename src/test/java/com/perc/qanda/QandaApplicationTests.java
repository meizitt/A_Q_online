package com.perc.qanda;

import com.perc.qanda.bean.Student;
import com.perc.qanda.mappers.StuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QandaApplicationTests {

    @Test
    void contextLoads() {
        StuMapper stuMapper=null;

        Student stu=stuMapper.findStuById(1);
        System.out.println(stu.toString());
    }



}
