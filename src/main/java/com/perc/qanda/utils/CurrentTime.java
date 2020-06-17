package com.perc.qanda.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
