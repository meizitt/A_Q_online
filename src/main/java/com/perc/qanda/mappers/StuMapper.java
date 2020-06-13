package com.perc.qanda.mappers;

import com.perc.qanda.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuMapper {

    @Select("select * from stu where stu_id=#{id}")
    public Student findStuById(Integer id);

}
