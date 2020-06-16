package com.perc.qanda.controller;

import com.perc.qanda.bean.LabQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.service.LabQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labq")
@ResponseBody
public class LabQCon {
    LabQService labQService;

    @Autowired
    public void setLabQService(LabQService labQService) {
        this.labQService = labQService;
    }

    @GetMapping("/findAll")
    public List<LabQ> findAll(){
        return labQService.findALl();
    }

    @GetMapping("/{id}")
    public LabQ findLabQById(@PathVariable Integer id){
        return labQService.findById(id);
    }

    @GetMapping("/findByText/{text}")
    public List<LabQ> findLabQByText(@PathVariable String text){
        return labQService.findByText(text);
    }

    @GetMapping("/del/{id}")
    public Result delLabQById(@PathVariable Integer id){
        return labQService.delLabQById(id);
    }

    @PostMapping("/add")
    public Result addLabQ(@RequestBody LabQ labQ){
        return labQService.addLabQ(labQ);
    }

    @PostMapping("/update")
    public Result updateLabQById(@RequestBody LabQ labQ){
        return labQService.updateLabQ(labQ);
    }

    @PostMapping("/updateTex/{id}/{text}")
    public Result updateLabQText(@PathVariable Integer id,@PathVariable String text){
        return labQService.updateLabQText(id,text);
    }

    @PostMapping("/updateAnswer/{id}/{answer}/{time}")
    public Result updateLabQAnswer(@PathVariable Integer id,@PathVariable String answer,@PathVariable String time){
        return labQService.updateAnswer(id,answer,time);
    }
}
