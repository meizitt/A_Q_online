package com.perc.qanda.service;

import com.perc.qanda.bean.Result;
import com.perc.qanda.bean.Student;
import com.perc.qanda.mappers.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {

    private StuMapper stuMapper;

    Result res = new Result("msg", "res");

    @Autowired
    public StuService(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }


    public Result delStuById(Integer id) {
        int i = stuMapper.delStuById(id);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public List<Student> findAllStu() {
        return stuMapper.findAllStu();
    }


    public Student findStuById(Integer id) {
        return stuMapper.findStuById(id);
    }

    public Result addStu(Student student) {
        int i = stuMapper.addStu(student);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateStu(Student student) {
        int i = stuMapper.updateStu(student);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateStuPwd(Integer id, String pwd) {
        Student stu = stuMapper.findStuById(id);
        stu.setPwd(pwd);
        int i = stuMapper.updateStuPwd(stu);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result stuLogin(Student stu) {
        Student student = stuMapper.findStuById(stu.getStu_id());
        if(student != null){
            if(stu.getPwd().equals(student.getPwd())){
                res.setRes("success");
                return res;
            }else {
                res.setRes("failed");
            }
        }else {
            res.setRes("failed");
        }
        return res;
    }
}
