package com.perc.qanda.service;

import com.perc.qanda.bean.CommQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.mappers.CommQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommQService {
    CommQuestionMapper commQuestionMapper;

    @Autowired
    public void setCommQuestionMapper(CommQuestionMapper commQuestionMapper) {
        this.commQuestionMapper = commQuestionMapper;
    }

    Result res = new Result("msg","res");


    public List<CommQ> findAllCommQ() {
       return commQuestionMapper.findAllCommQ();
    }

    public CommQ findCommQById(Integer id) {
        return commQuestionMapper.findCommQById(id);
    }

    public List<CommQ> findCommQByText(String text) {
        return commQuestionMapper.findCommQText(text);
    }

    public Result delCommQById(Integer id) {
        int i = commQuestionMapper.delCommQById(id);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result addCommQ(CommQ commQ) {
        int i = commQuestionMapper.addCommQ(commQ);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;

    }

    public Result updateCommQ(CommQ commQ) {

        int i = commQuestionMapper.updateCommQ(commQ);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }
}
