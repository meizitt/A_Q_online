package com.perc.qanda.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer tch_id;
    private String tch_name;
    private String sex;
    private String bir;
    private String title;
    private String major;
    private String part_time_teach;
    private String app_time;
    private String phonenum;



}
