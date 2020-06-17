package com.perc.qanda.controller;


import com.perc.qanda.bean.Result;
import com.perc.qanda.bean.Student;
import com.perc.qanda.bean.Teacher;
import com.perc.qanda.service.TchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tch")
@ResponseBody
public class TchCon {

    TchService tchService;

    @Autowired
    public void setTchService(TchService tchService) {
        this.tchService = tchService;
    }

    @GetMapping("/findAll")
    public List<Teacher> findAllTch(){
        return tchService.findAllTch();
    }

    @GetMapping("/{id}")
    public Teacher findTchById(@PathVariable Integer id){
        return tchService.findTchById(id);
    }

    @GetMapping("/del/{id}")
    public Result delTchById(@PathVariable Integer id){
        return tchService.delTchById(id);
    }

    @PostMapping("/add")
    public Result addTch(@RequestBody Teacher teacher){
        return tchService.addTch(teacher);
    }

    @PostMapping("/update")
    public Result updateTch(@RequestBody Teacher teacher){
        return tchService.updateTch(teacher);
    }

    @PostMapping("/updatePwd")
    public Result updateTchPwd(@RequestBody Teacher tch){
        return tchService.updateTchPwd(tch.getTch_id(),tch.getPwd());
    }

    @PostMapping("/login")
    public Result tchLogin(@RequestBody Teacher tch){
        return tchService.tchLogin(tch);
    }

}
