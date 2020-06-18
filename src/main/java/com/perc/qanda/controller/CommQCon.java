package com.perc.qanda.controller;

import com.perc.qanda.bean.CommQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.service.CommQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commq")
@ResponseBody
public class CommQCon {
    CommQService commQService;

    @Autowired
    public void setCommQService(CommQService commQService) {
        this.commQService = commQService;
    }

    @GetMapping("/findAll")
    public List<CommQ> findAllCommQ(){
        return commQService.findAllCommQ();
    }

    @GetMapping("/{id}")
    public CommQ findCommQById(@PathVariable Integer id){
        return commQService.findCommQById(id);
    }

    @GetMapping("/findByText/{txtt}")
    public List<CommQ> findCommQByText(@PathVariable String txtt){

        return commQService.findCommQByText(txtt);
    }

    @GetMapping("/del/{id}")
    public Result delCommQById(@PathVariable Integer id){
        return commQService.delCommQById(id);
    }

    @PostMapping("/add")
    public Result addCommq(@RequestBody CommQ commQ){
        return commQService.addCommQ(commQ);
    }

    @PostMapping("/update")
    public Result updateCommQ(@RequestBody CommQ commQ){
        return commQService.updateCommQ(commQ);
    }

    @PostMapping("/updateText")
    public Result updateText(@RequestBody Map<String,String> x){
        return commQService.updateText(Integer.parseInt(x.get("id")),x.get("text"));
    }

    @PostMapping("/updateAnswer")
    public Result updateAnswer(@RequestBody Map<String,String> x){
        return commQService.updateAnswer(Integer.parseInt(x.get("id")),x.get("answer"));
    }
}
