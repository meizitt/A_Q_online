package com.perc.qanda.mappers;

import com.perc.qanda.bean.LabQ;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabQuestionMapper {
    @Select("select * from lab_q")
    List<LabQ> findAllLabQ();

    @Select("select * from lab_q where q_id=#{id}")
    LabQ findLabQById(Integer id);

    @Select("select * from lab_q where q_text like '%${text}%'")
    List<LabQ> findLabQByText(String text);

    @Delete("delete from lab_q where q_id=#{id}")
    int delLabQById(Integer id);

    @Insert("insert into lab_q(q_id,stu_id,stu_name,tch_id,tch_name,sub_time,answer_time,q_text,answer_text) " +
            "values(#{q_id},#{stu_id},#{stu_name},#{tch_id},#{tch_name},#{sub_time},#{answer_time},#{q_text},#{answer_text})")
    int addLabQ(LabQ labQ);

    @Update("update lab_q set stu_id=#{stu_id},stu_name=#{stu_name},tch_id=#{tch_id},tch_name=#{tch_name}," +
            "sub_time=#{sub_time},answer_time=#{answer_time},q_text=#{q_text},answer_text=#{answer_text} " +
            "where q_id=#{q_id}")
    int updateLabQ(LabQ labQ);
}
