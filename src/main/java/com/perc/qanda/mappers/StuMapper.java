package com.perc.qanda.mappers;

import com.perc.qanda.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuMapper {

    @Select("select * from stu where stu_id=#{id}")
    Student findStuById(Integer id);

    @Select("select * from stu")
    List<Student> findAllStu();

    @Insert("insert into stu(stu_id,stu_name,sex,class_num,email,pwd) values(#{stu_id},#{stu_name},#{sex},#{class_num},#{email},#{pwd})")
    int addStu(Student student);

    @Delete("delete from stu where stu_id=#{id}")
    int delStuById(Integer id);

    @Update("update stu set stu_name=#{stu_name},sex=#{sex},class_num=#{class_num},email=#{email} where stu_id=#{stu_id}")
    int updateStu(Student student);

    @Update("update stu set pwd = #{pwd} where stu_id=#{stu_id}")
    int updateStuPwd(Student student);

}
