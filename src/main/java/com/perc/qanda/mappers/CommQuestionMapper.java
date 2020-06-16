package com.perc.qanda.mappers;

import com.perc.qanda.bean.CommQ;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommQuestionMapper {

    @Insert("insert into comm_q(q_id,text,time,num,answer) " +
            "values(#{q_id},#{text},#{time},#{num},#{answer})")
    int addCommQ(CommQ commQ);

    @Delete("delete from comm_q where q_id=#{id}")
    int delCommQById(Integer id);

    @Select("select * from comm_q where q_id=#{id}")
    CommQ findCommQById(Integer id);

    @Select("select * from comm_q where text like '%${text}%'")
    List<CommQ> findCommQText(String text);

    @Select("select * from comm_q")
    List<CommQ> findAllCommQ();

    @Update("update comm_q set text=#{text},answer=#{answer},time=#{time},num=#{num} " +
            "where q_id=#{q_id}")
    int updateCommQ(CommQ commQ);

    @Update("update comm_q set num=#{num} where q_id=#{id}")
    int updateCommQNum(Integer id,Integer num);



}
