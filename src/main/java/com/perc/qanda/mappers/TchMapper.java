package com.perc.qanda.mappers;

import com.perc.qanda.bean.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TchMapper {
    @Select("select * from tch where tch_id = #{id}")
    Teacher findTchById(Integer id);

    @Select("select * from tch")
    List<Teacher> findAllTch();

    @Insert("insert into " +
            "tch(tch_id,tch_name,sex,bir,title,major,part_time_teach,app_time,phonenum,pwd) " +
            "values(#{tch_id},#{tch_name},#{sex},#{bir},#{title},#{major},#{part_time_teach},#{app_time},#{phonenum},#{pwd})")
    int addTch(Teacher teacher);

    @Delete("delete from tch where tch_id=#{id}")
    int delTchById(Integer id);

    @Update("update tch set tch_name=#{tch_name},sex=#{sex},bir=#{bir},title=#{title},major=#{major}," +
            "part_time_teach=#{part_time_teach},app_time=#{app_time},phonenum=#{phonenum} " +
            "where tch_id=#{tch_id}")
    int updateTch(Teacher teacher);

    @Update("update tch set pwd = #{pwd} where tch_id = #{tch_id}")
    int updateTchPwd(Teacher teacher);
}
