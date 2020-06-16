package com.perc.qanda.service;

import com.perc.qanda.bean.LabQ;
import com.perc.qanda.bean.Result;
import com.perc.qanda.mappers.LabQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabQService {

    LabQuestionMapper labQuestionMapper;

    @Autowired

    public void setLabQuestionMapper(LabQuestionMapper labQuestionMapper) {
        this.labQuestionMapper = labQuestionMapper;
    }

    Result res = new Result("msg", "res");

    public List<LabQ> findALl() {
        return labQuestionMapper.findAllLabQ();
    }

    public LabQ findById(Integer id) {
        return labQuestionMapper.findLabQById(id);
    }

    public List<LabQ> findByText(String text) {
        return labQuestionMapper.findLabQByText(text);
    }

    public Result delLabQById(Integer id) {
        int i = labQuestionMapper.delLabQById(id);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }


    public Result addLabQ(LabQ labQ) {
        int i = labQuestionMapper.addLabQ(labQ);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateLabQ(LabQ labQ) {
        int i = labQuestionMapper.updateLabQ(labQ);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateLabQText(Integer id, String text) {
        LabQ labQ = labQuestionMapper.findLabQById(id);
        if (labQ != null) {
            labQ.setQ_text(text);
            int i = labQuestionMapper.updateLabQ(labQ);
            if (i == 1) {
                res.setRes("success");
            } else {
                res.setRes("failed");
            }
            return res;
        } else {
            res.setRes("failed");
            return res;
        }
    }

    public Result updateAswer(Integer id, String answer, String time) {
        LabQ labQ = labQuestionMapper.findLabQById(id);
        if (labQ != null) {
            labQ.setAnswer_text(answer);
            labQ.setSub_time(time);
            int i = labQuestionMapper.updateLabQ(labQ);
            if (i == 1) {
                res.setRes("success");
            } else {
                res.setRes("failed");
            }
            return res;
        } else {
            res.setRes("failed");
            return res;
        }
    }
}
