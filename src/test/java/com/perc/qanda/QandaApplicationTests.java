package com.perc.qanda;

import com.perc.qanda.bean.Student;
import com.perc.qanda.bean.Teacher;
import com.perc.qanda.mappers.StuMapper;
import com.perc.qanda.mappers.TchMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QandaApplicationTests {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private TchMapper tchMapper;


    @Test
    void contextLoads() {
        Student student = new Student(123,"haha","女",2712,"34@","dsfa");
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
        student.setStu_id(23);
        stuMapper.updateStu(student);
    }

    @Test
    void foundAllStu(){
        List<Student> allStu = stuMapper.findAllStu();
        for(Student  stu:allStu){
            System.out.println(stu.toString());
        }
    }
    @Test
    void updateStuPwd(){

        Student stu = stuMapper.findStuById(12);
        stu.setPwd("123");
        stuMapper.updateStuPwd(stu);

    }

    @Test
    void findTchById(){
        Teacher tch = tchMapper.findTchById(1);
        System.out.println(tch.toString());
    }


    @Test
    void findAllTch(){
        List<Teacher> allTch = tchMapper.findAllTch();
        for(Teacher teacher:allTch){
            System.out.println(teacher.toString());
        }
    }

    @Test
    void insertTch(){
        Teacher teacher = new Teacher();
        teacher.setTch_id(100);
        teacher.setTch_name("雅马哈");
        teacher.setApp_time("2019");
        tchMapper.addTch(teacher);
    }

    @Test
    void delTch(){
        tchMapper.delTchById(100);
    }

    @Test
    void updateTch(){
        Teacher tch = tchMapper.findTchById(1);
        tch.setTch_id(4);
        tchMapper.updateTch(tch);

    }

    @Test
    void updateTchPwd(){
        Teacher tch = tchMapper.findTchById(1);
        tch.setPwd("45gfs");
        System.out.println(tchMapper.updateTchPwd(tch));


    }
}
