package com.perc.qanda;

import com.perc.qanda.bean.*;
import com.perc.qanda.mappers.CommQuestionMapper;
import com.perc.qanda.mappers.LabQuestionMapper;
import com.perc.qanda.mappers.StuMapper;
import com.perc.qanda.mappers.TchMapper;
import com.perc.qanda.service.LabQService;
import com.perc.qanda.service.StuService;
import com.perc.qanda.utils.CurrentTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.util.Length;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@SpringBootTest
class QandaApplicationTests {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private TchMapper tchMapper;

    @Autowired
    CommQuestionMapper commQuestionMapper;

    @Autowired
    LabQuestionMapper labQuestionMapper;

    @Autowired
    StuService stuService;

    @Autowired
    LabQService labQService;

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

    @Test
    void addCommQ(){
        CommQ commQ = new CommQ();
        commQ.setText("请回答小炒牛肉的家常做法");
        commQ.setQ_id(21);
        commQ.setNum(0);
        commQ.setTime("2020");
        commQuestionMapper.addCommQ(commQ);
        System.out.println(commQ.toString());
    }

    @Test
    void findCommQ(){
        System.out.println(commQuestionMapper.findCommQById(1).toString());
        System.out.println(commQuestionMapper.findCommQText("方程"));
        List<CommQ> allCommQ = commQuestionMapper.findCommQText("方程");
        for (CommQ commQ : allCommQ) {
            System.out.println(commQ.toString());
        }
    }

    @Test
    void updateCommQ(){
        CommQ q = commQuestionMapper.findCommQById(2);
        q.setTime("1919");
        commQuestionMapper.updateCommQ(q);
    }
    @Test
    void delCommQ(){
        commQuestionMapper.delCommQById(1);
    }

    @Test
    void addLabQ(){
        LabQ labQ=new LabQ();
        labQ.setQ_text("拉格朗日不等式");
        labQ.setAnswer_time("adf");
        labQuestionMapper.addLabQ(labQ);
    }

    @Test
    void delLabQById(){
        labQuestionMapper.delLabQById(1);
    }

    @Test
    void findAllLabQ(){
        List<LabQ> allLabQ = labQuestionMapper.findAllLabQ();
        for (LabQ labQ : allLabQ) {
            System.out.println(labQ.toString());
        }

    }

    @Test
    void findLabQByText(){
        List<LabQ> labQList = labQuestionMapper.findLabQByText("式");
        for (LabQ labQ : labQList) {
            System.out.println(labQ.toString());

        }
    }

    @Test
    void updateLabQ(){
        LabQ labQById = labQuestionMapper.findLabQById(1);
        labQById.setSub_time("2018");
        labQuestionMapper.updateLabQ(labQById);
    }

    @Test
    void updateNum(){

        commQuestionMapper.updateCommQNum(2,1);

    }

    @Test
    void getCurrentTime(){
        CurrentTime currentTime= new CurrentTime();

        System.out.println(currentTime.getCurrentTime().length());
    }

    @Test
    void updateLabQAnswer(){
        Result result = labQService.updateAnswer(4, "求反函数");
        System.out.println(result);
    }

    @Test
    void labSer(){
        LabQ labQ=new LabQ();
        labQ.setQ_text("齐次线性微分方程");

        labQService.addLabQ(labQ);
    }
}
