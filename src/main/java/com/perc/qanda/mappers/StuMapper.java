package com.perc.qanda.mappers;

import com.perc.qanda.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper {

    @Select("select * from stu where stu_id=#{id}")
    public Student findStuById(Integer id);

    public void addStu(Student student);

}
