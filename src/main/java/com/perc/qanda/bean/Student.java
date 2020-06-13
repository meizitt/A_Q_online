package com.perc.qanda.bean;

import org.springframework.context.annotation.Bean;

public class Student {

    private Integer stu_id;
    private String stu_name;
    private String sex;
    private Integer class_num;
    private String email;

    public Student(Integer stu_id, String stu_name, String sex, Integer class_num, String email) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.sex = sex;
        this.class_num = class_num;
        this.email = email;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getClass_num() {
        return class_num;
    }

    public void setClass_num(Integer class_num) {
        this.class_num = class_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
