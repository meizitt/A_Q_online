package com.perc.qanda.service;

import com.perc.qanda.bean.Result;
import com.perc.qanda.bean.Student;
import com.perc.qanda.bean.Teacher;
import com.perc.qanda.mappers.TchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TchService {

    TchMapper tchMapper;


    Result res = new Result("msg","res");

    @Autowired
    public void setTchMapper(TchMapper tchMapper) {
        this.tchMapper = tchMapper;
    }


    public List<Teacher> findAllTch() {
        return tchMapper.findAllTch();
    }

    public Teacher findTchById(Integer id) {
        return tchMapper.findTchById(id);
    }

    public Result delTchById(Integer id) {
        int i = tchMapper.delTchById(id);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result addTch(Teacher teacher) {
        int i = tchMapper.addTch(teacher);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateTch(Teacher teacher) {
        int i = tchMapper.updateTch(teacher);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result updateTchPwd(Integer id, String pwd) {
        Teacher tch = tchMapper.findTchById(id);
        tch.setPwd(pwd);
        int i = tchMapper.updateTchPwd(tch);
        if (i == 1) {
            res.setRes("success");
        } else {
            res.setRes("failed");
        }
        return res;
    }

    public Result tchLogin(Teacher tch) {
        Teacher teacher = tchMapper.findTchById(tch.getTch_id());
        if(teacher != null){
            if(tch.getPwd().equals(teacher.getPwd())){
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
