package com.perc.qanda.controller;

import com.perc.qanda.bean.Student;
import com.perc.qanda.mappers.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuCon {

    private StuMapper stuMapper;

    @Autowired
    public StuCon(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }


    @GetMapping("/qa/{id}")
    public Student getStuById(@PathVariable("id") Integer id) {
      return null;
    }

}
