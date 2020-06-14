package com.perc.qanda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer stu_id;
    private String stu_name;
    private String sex;
    private Integer class_num;
    private String email;
    private String pwd;

}
