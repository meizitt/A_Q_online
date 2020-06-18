package com.perc.qanda.controller;

import com.perc.qanda.bean.LabQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.service.LabQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<LabQ> findAll() {
        return labQService.findALl();
    }

    @GetMapping("/{id}")
    public LabQ findLabQById(@PathVariable Integer id) {
        return labQService.findById(id);
    }

    @GetMapping("/findByText/{txt}")
    public List<LabQ> findLabQByText(@PathVariable String txt) {
        return labQService.findByText(txt);
    }

    @GetMapping("/del/{id}")
    public Result delLabQById(@PathVariable Integer id) {
        return labQService.delLabQById(id);
    }

    @PostMapping("/add")
    public Result addLabQ(@RequestBody LabQ labQ) {
        return labQService.addLabQ(labQ);
    }

    @PostMapping("/update")
    public Result updateLabQById(@RequestBody LabQ labQ) {
        return labQService.updateLabQ(labQ);
    }

    @PostMapping("/updateText")
    public Result updateLabQText(@RequestBody Map<String, String> x) {
        return labQService.updateLabQText(Integer.parseInt(x.get("id")), x.get("text"));
    }

    @PostMapping("/updateAnswer")
    public Result updateLabQAnswer(@RequestBody LabQ labQ) {
        System.out.println(labQ);
        return labQService.updateAnswer(labQ.getQ_id(),labQ.getAnswer_text());
    }
}
