package com.perc.qanda.controller;

import com.perc.qanda.bean.CommQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.service.CommQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commq")
@ResponseBody
public class CommQuestionCon {
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

    @GetMapping("/findByText/{text}")
    public List<CommQ> findCommQByText(@PathVariable String text){
        return commQService.findCommQByText(text);
    }

    @DeleteMapping("/{id}")
    public Result delCommQById(@PathVariable Integer id){
        return commQService.delCommQById(id);
    }

    @PostMapping("/add")
    public Result addCommq(@RequestBody CommQ commQ){
        return commQService.addCommQ(commQ);
    }

    @PutMapping("/update")
    public Result updateCommQ(@RequestBody CommQ commQ){
        return commQService.updateCommQ(commQ);
    }

    @PutMapping("/updateText/{id}/{text}")
    public Result updateText(@PathVariable Integer id,@PathVariable String text){
        return commQService.updateText(id,text);
    }

    @PutMapping("/updateAnswer/{id}/{answer}")
    public Result updateAnswer(@PathVariable Integer id,@PathVariable String answer){
        return commQService.updateAnswer(id,answer);
    }
}
