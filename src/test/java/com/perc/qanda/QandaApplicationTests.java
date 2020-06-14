package com.perc.qanda;

import com.perc.qanda.bean.Student;
import com.perc.qanda.mappers.StuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QandaApplicationTests {

    @Autowired
    private StuMapper stuMapper;


    @Test
    void contextLoads() {
        Student student = new Student(123,"haha","女",2712,"34@");
        stuMapper.addStu(student);
        System.out.println(stuMapper.findStuById(123));
    }

    @Test
    void delStu(){
        System.out.println(stuMapper.delStuById(1));
    }

    @Test
    void updateStu(){
        Student student=stuMapper.findStuById(11);
        student.setStu_name("嘤嘤嘤");
        stuMapper.updateStu(student);
    }

    @Test
    void foundAllStu(){
        List<Student> allStu = stuMapper.findAllStu();
        for(Student  stu:allStu){
            System.out.println(stu.toString());
        }
    }

}
