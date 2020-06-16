package com.perc.qanda.controller;

import com.perc.qanda.bean.Result;
import com.perc.qanda.bean.Student;
import com.perc.qanda.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
@ResponseBody
public class StuCon {

    StuService stuService;

    @Autowired
    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }


    @GetMapping("/del/{id}")
    public Result delStuById(@PathVariable("id") Integer id) {

        return stuService.delStuById(id);
    }


    @GetMapping("/findAll")
    public List<Student> findAllStu() {
        return stuService.findAllStu();
    }

    @GetMapping("/{id}")
    public Student findStuById(@PathVariable Integer id) {
        return stuService.findStuById(id);
    }

    @PostMapping("/add")
    public Result addStu(@RequestBody Student student) {
        return stuService.addStu(student);
    }

    @PostMapping("/update")
    public Result updateStu(@RequestBody Student student) {
        return stuService.updateStu(student);
    }

    @PostMapping("/updatePwd")
    public Result updateStuPwd(@RequestBody Student stu) {
        return stuService.updateStuPwd(stu.getStu_id(), stu.getPwd());
    }

}
