package com.perc.qanda.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabQ {

    private Integer q_id;
    private Integer stu_id;
    private Integer tch_id;
    private String stu_name;
    private String tch_name;
    private String sub_time;
    private String answer_time;
    private String q_text;
    private String answer_text;


}
