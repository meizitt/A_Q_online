package com.perc.qanda.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommQ {

    private Integer q_id;
    private Integer num;
    private String text;
    private String answer;
    private String time;

}
